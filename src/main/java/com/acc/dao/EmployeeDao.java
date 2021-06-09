package com.acc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import com.acc.bean.Employee;
import com.acc.util.ConnectorMysql;

public class EmployeeDao {
	// SELECTs
	public ArrayList<Employee> getEmployees() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		ConnectorMysql connectorMysql = ConnectorMysql.getConnector();

		Connection conn = connectorMysql.getConn();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

			// print out query result
			while (rs.next()) {
				employees.add(createEmployee(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employees;
	}

	public Employee getEmployee(Integer sysId) {
		Employee res;
		
		ConnectorMysql connectorMysql = ConnectorMysql.getConnector();
		System.out.println("ConnectorMysql: " + connectorMysql);
		Connection conn = connectorMysql.getConn();
		System.out.println("conn: " + conn);

		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM employees WHERE sysId = ?");
			ps.setInt(1, sysId);

			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			System.out.println("rs: " + rs);
			if (rs.next()) {
				res = createEmployee(rs);
			} else {
				res = null;
			}
		} catch (Exception e) {
			throw new RuntimeException("Falla en el método getEmployee(int)", e);
		}

		return res;
	}

	// INSERTs
	public int insertEmployee(Employee employee, String responsable) {
		if (employee == null)
			throw new NullPointerException("No se proveyó un empleado -- Insert employee");

		employee.setSysId(new Random().nextInt(Integer.MAX_VALUE));

		int res = 0;

		System.out.println("Insert employee SYS_ID " + employee.getSysId() + " | By " + responsable);

		ConnectorMysql connectorMysql = ConnectorMysql.getConnector();
		Connection conn = connectorMysql.getConn();

		try {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO employees (sysId, eId, name, level, location, birthday) VALUES (?, ?, ?, ?, ?, ?)");

			int i = 1;

			ps.setInt(i++, employee.getSysId());
			ps.setString(i++, employee.geteId());
			ps.setString(i++, employee.getName());
			ps.setInt(i++, employee.getLevel());
			ps.setString(i++, employee.getLocation());
			ps.setString(i++, employee.getBirthday());

			res = ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException("Algo salió mal al hacer la llamada", e);
		}

		return res;
	}

	// UPDATEs
	public int updateEmployee(Employee employee, String responsable) {
		int res = 0;

		System.out.println("Update employee SYS_ID " + employee.getSysId() + " | By " + responsable);

		ConnectorMysql connectorMysql = ConnectorMysql.getConnector();
		Connection conn = connectorMysql.getConn();

		try {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE employees SET eId = ?, name = ?, level = ?, location = ?, birthday = ? WHERE sysId = ?");

			int i = 1;

			ps.setString(i++, employee.geteId());
			ps.setString(i++, employee.getName());
			ps.setInt(i++, employee.getLevel());
			ps.setString(i++, employee.getLocation());
			ps.setString(i++, employee.getBirthday());

			ps.setInt(i++, employee.getSysId());

			res = ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException("Algo salió mal al hacer la llamada", e);
		}

		return res;
	}

	public static Employee createEmployee(ResultSet rs) throws SQLException {
		Employee employee = new Employee();
		employee.setSysId(rs.getInt("sysId"));
		employee.seteId(rs.getString("eId"));
		employee.setName(rs.getString("name"));
		employee.setLevel(rs.getInt("level"));
		employee.setLocation(rs.getString("location"));
		employee.setBirthday(rs.getString("birthday"));

		return employee;
	}
}
