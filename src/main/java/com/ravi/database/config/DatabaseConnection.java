package com.ravi.database.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	
	static Connection connection = null;
	
	public static Connection getConnection()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}  
		  
		try {
			connection=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		return connection;
	}
	
	static Statement getStatement() throws SQLException
	{
		Statement stmt=getConnection().createStatement();  
		return stmt;
	}
	
	public static ResultSet getResultSet(String sql) throws SQLException
	{
		return getStatement().executeQuery(sql);
		
	}
	
	public static void closeConnection() throws SQLException
	{
		connection.close();
	}

}
