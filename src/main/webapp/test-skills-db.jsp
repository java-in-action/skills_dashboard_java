
<%@ page import="java.sql.*" %>
<%
  // Read RDS connection information from the environment
  String dbName = "skills_dashboard";
  String userName = "admin";
  String password = "Welcome_123";
  String hostname = "database-1.cwxpiixovu60.us-west-2.rds.amazonaws.com";
  String port = "3306";
  String jdbcUrl = "jdbc:mysql://" + hostname + ":" +
    port + "/" + dbName + "?user=" + userName + "&password=" + password;
  
  // Load the JDBC driver
  try {
    System.out.println("Loading driver...");
    Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println("Driver loaded!");
  } catch (ClassNotFoundException e) {
    throw new RuntimeException("Cannot find the driver in the classpath!", e);
  }

  Connection conn = null;
  Statement setupStatement = null;
  Statement readStatement = null;
  ResultSet resultSet = null;
  String results = "";
  int numresults = 0;
  String statement = null;


  try {
    conn = DriverManager.getConnection(jdbcUrl);
    
    readStatement = conn.createStatement();
    resultSet = readStatement.executeQuery("SELECT * FROM employees;");

    resultSet.first();
    results = resultSet.getString("name");
    resultSet.next();
    results += ", " + resultSet.getString("name");
    
    resultSet.close();
    readStatement.close();
    conn.close();

  } catch (SQLException ex) {
    // Handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
  } finally {
       System.out.println("Closing the connection.");
      if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
  }
%>
<html>
<body>
<p>Established connection to DB: <%= dbName %></p>
<p>Read first two rows: <%= results %></p>
</body>
</html>