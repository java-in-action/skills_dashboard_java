package com.acc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.acc.bean.Employee;
import com.acc.util.ConnectorDerby;

public class EmployeeDao {

	public ArrayList<Employee> getEmployees() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		ConnectorDerby connectorDerby = ConnectorDerby.getConnector();

		Connection conn = connectorDerby.getConn();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

			// print out query result
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setSysId(rs.getInt("sysId"));
				employee.seteId(rs.getString("eId"));
				employee.setName(rs.getString("name"));
				employee.setLevel(rs.getInt("level"));
				employee.setLocation(rs.getString("location"));
				employee.setBithday(rs.getString("birthday"));
				employees.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employees;
	}
}
