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
	    stmt.executeUpdate("drop table employees");
	 
	    // create table
	    String fields = "(sysId int primary key, eId varchar(30), name varchar(30)," +
	    				"level int, location varchar(20), birthday varchar(15))";
	    
	    stmt.executeUpdate("Create table employees " + fields);
	 
	    // insert 2 rows
	    stmt.executeUpdate("insert into employees values (1,'carlos.baez','Baez - Carlos',11,'CD-MX','00/00/00')");
	    stmt.executeUpdate("insert into employees values (2,'s.coronado.andrad','Coronado Andrade, S.',12,'MTY','00/00/00')");
	    stmt.executeUpdate("insert into employees values (3,'g.rodriguez.lozano','Rodriguez Lozano, G.',10,'CDMX','00/00/00')");	    
	    stmt.executeUpdate("insert into employees values (4,'r.sanchez.rojas','Sanchez Rojas, R.',10,'MTY','00/00/00')");
	    stmt.executeUpdate("insert into employees values (5,'ivan.albor','Albor, Ivan',9,'USA','00/00/00')");	    	    
	    // query
	    ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
	 
	    // print out query result
	    while (rs.next()) { 
	      System.out.printf("%d\t%s\t%s\t%d\t%s\t%s\n", rs.getInt("sysId"), rs.getString("eId"), rs.getString("name"), 
	    		  rs.getInt("level"), rs.getString("location"), rs.getString("birthday") );
	    }
	  }
}
