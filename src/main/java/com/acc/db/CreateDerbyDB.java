package com.acc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDerbyDB {
	Connection conn;

	public static void main(String[] args) throws SQLException {
		CreateDerbyDB app = new CreateDerbyDB();

		app.connectionToDerby();
		app.normalDbUsage();
	}

	public void connectionToDerby() throws SQLException {
		// -------------------------------------------
		// URL format is
		// jdbc:derby:<local directory to save data>
		// -------------------------------------------
		String dbUrl = "jdbc:derby:C:\\Users\\angel.daniel.alonso\\derbydb\\skills_dashboard_db;create=true";
		conn = DriverManager.getConnection(dbUrl);
	}

	public void normalDbUsage() throws SQLException {
		Statement stmt = conn.createStatement();

		// drop table
		try {
			stmt.executeUpdate("drop table employee_skill");
		} catch (Exception e) {
			
		}
		try {
			stmt.executeUpdate("drop table skill");	
		} catch (Exception e) {

		}
		try {
			stmt.executeUpdate("drop table employees");
		} catch (Exception e) {

		}

		// create table
		String fields = "(sysId int primary key, eId varchar(30), name varchar(30),"
				+ "level int, location varchar(20), birthday date)";

		stmt.executeUpdate("Create table employees " + fields);

		stmt.executeUpdate("CREATE TABLE skill (id INT PRIMARY KEY, description VARCHAR(100) NOT NULL)");

		stmt.executeUpdate("CREATE TABLE employee_skill (employee_id INT NOT NULL, skill_id INT NOT NULL)");
		stmt.executeUpdate("ALTER TABLE employee_skill ADD FOREIGN KEY (employee_id) REFERENCES employees(sysId)");
		stmt.executeUpdate("ALTER TABLE employee_skill ADD FOREIGN KEY (skill_id) REFERENCES skill(id)");

		stmt.executeUpdate("INSERT INTO skill VALUES (1, 'Leadership'), (2, 'C#'), (3, 'Java'), (4, 'Angular'), (5, 'SQL')");


		// insert 2 rows
		stmt.executeUpdate("insert into employees values (1,'carlos.baez','Baez Carlos',11,'CD-MX','1990-01-01')");
		stmt.executeUpdate(
				"insert into employees values (2,'s.coronado.andrad','Coronado Andrade, S.',12,'MTY','1985-06-25')");
		stmt.executeUpdate(
				"insert into employees values (3,'g.rodriguez.lozano','Rodriguez Lozano, G.',10,'CDMX','1978-04-14')");
		stmt.executeUpdate(
				"insert into employees values (4,'r.sanchez.rojas','Sanchez Rojas, R.',10,'MTY','1996-08-09')");
		stmt.executeUpdate("insert into employees values (5,'ivan.albor','Albor, Ivan',9,'USA','1981-03-12')");

		stmt.executeUpdate("INSERT INTO employee_skill VALUES (2, 1), (2, 2), (3, 3), (4, 4), (1, 5)");
		// query
		ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

		// print out query result
		while (rs.next()) {
			System.out.printf("%d\t%s\t%s\t%d\t%s\t%s\n", rs.getInt("sysId"), rs.getString("eId"), rs.getString("name"),
					rs.getInt("level"), rs.getString("location"), rs.getString("birthday"));
		}
	}
}
