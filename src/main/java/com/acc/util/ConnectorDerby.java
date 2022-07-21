package com.acc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDerby {
	private static final ConnectorDerby connector = new ConnectorDerby();
	
	private final String DEB_URL = "jdbc:derby:C:\\temp\\derbydb\\skills_dashboard_db;create=true";
	private Connection conn;

	private ConnectorDerby() {
		try {
			conn = DriverManager.getConnection(DEB_URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectorDerby  getConnector() {
		return connector;
	}

	public Connection getConn() {
		return conn;
	}

}
