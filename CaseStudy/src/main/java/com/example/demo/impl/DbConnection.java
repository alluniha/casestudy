package com.example.demo.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.example.demo.DbInterface;

@Component
public class DbConnection implements DbInterface {
	
Connection connection;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/casestudydb","root","admin@123");
			
		}catch(ClassNotFoundException e) {e.printStackTrace();}
		 catch(SQLException s) {s.printStackTrace();}
		
		return connection;
	}
	
	public void closeConnection() {
		try {
			if(connection != null) {
				connection.close();
			}
		} catch(SQLException se) {se.printStackTrace();}
	
	}

}
