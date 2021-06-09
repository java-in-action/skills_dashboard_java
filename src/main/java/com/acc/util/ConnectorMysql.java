package com.acc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorMysql {
	private static final ConnectorMysql connector = new ConnectorMysql();
	
	private final String DEB_URL = "jdbc:mysql://database-1.cwxpiixovu60.us-west-2.rds.amazonaws.com:3306/skills_dashboard?autoReconnect=true";
	private final String USER = "admin";
	private final String PASSWORD = "Welcome_123";
		
	private Connection conn;

	private ConnectorMysql() {
		try {
			  // Load the JDBC driver
			  try {
			    System.out.println("ConnectorMysql: Loading driver ...");
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    System.out.println("Driver loaded!");
			  } catch (ClassNotFoundException e) {
			    throw new RuntimeException("Cannot find the driver in the classpath!", e);
			  }
			  
			if (conn == null) {
				conn = DriverManager.getConnection(DEB_URL, USER, PASSWORD);				
			}
			System.out.println("Connection Successful");
		} catch (SQLException e) {
			System.out.println("Error when getConnectio");
			e.printStackTrace();
		} 
	}
	
	public static ConnectorMysql  getConnector() {
		return connector;
	}

	public Connection getConn() {
		return conn;
	}

}
