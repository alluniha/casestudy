package com.example.demo;

import java.sql.Connection;

public interface DbInterface {
	
	public Connection getConnection();
	public void closeConnection();

}
