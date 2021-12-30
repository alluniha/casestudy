package com.example.demo.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Task;
import com.example.demo.User;
import com.example.demo.UserInterface;


@Component
public class DefaultUserImpl implements UserInterface {
	
	@Autowired
	DbConnection db;
	
	int row = 0;
	boolean status;
	
	@Autowired
	User user = null;

	@Override
	public int createUser(User user) {
		try {
			
			PreparedStatement ps = db.getConnection().prepareStatement("Insert into user values (?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, user.getUserID());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getFirstName());
			ps.setString(5, user.getLastName());
			ps.setLong(6, user.getContactNumber());
			ps.setString(7, user.getRole());
			ps.setBoolean(8,user.getIsActive());
			ps.setString(9, user.getDob());
			ps.setString(10, user.getCreatedOn());
			ps.setString(11,user.getPassword());
			row = ps.executeUpdate();
			db.closeConnection();
			
		}catch(SQLException e) {System.out.println(e);}
		
		return row;
		
	}

	@Override
	public List<User> login(String username, String password) {
		List<User> userList = new ArrayList<>();
		
		try {
			
			PreparedStatement ps = db.getConnection().prepareStatement("Select * from user where username = ? and password = ?;");
			ps.setString(1, username );
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				int userid= rs.getInt(1);
				String name= rs.getString(2);
				String email = rs.getString(3);
				String fname = rs.getString(4);
				String lname = rs.getString(5);
				long phno = rs.getLong(6);
				String role = rs.getString(7);
				Boolean isactive = rs.getBoolean(8);
				String dob = rs.getString(9);
				String createdon = rs.getString(10);
				String pwd=rs.getString(11);

				user.setUserID(userid);
				user.setUserName(name);
				user.setEmail(email);
				user.setFirstName(fname);
				user.setLastName(lname);
				user.setContactNumber(phno);
				user.setRole(role);
				user.setIsActive(isactive);
				user.setDob(dob);
				user.setCreatedOn(createdon);
				user.setPassword(pwd);
				userList.add(user);
				}
			
		}catch(SQLException se) {se.printStackTrace();}
		
		return userList;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<>();
		try {
		PreparedStatement ps = db.getConnection().prepareStatement("Select * from user");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			User us = new User();
			int userID = rs.getInt(1);
			String userName = rs.getString(2);
			String email = rs.getString(3);
			String firstName = rs.getString(4);
			String lastName = rs.getString(5);
			long contactNumber = rs.getLong(6);
			String role = rs.getString(7);
			Boolean isActive = rs.getBoolean(8);
			String dob = rs.getString(9);
			String createdOn = rs.getString(10);
			String passwors = rs.getString(11);
			
			us.setUserID(userID);
			us.setUserName(userName);
			us.setEmail(email);
			us.setFirstName(firstName);
			us.setLastName(lastName);
		    us.setContactNumber(contactNumber);
			us.setRole(role);
			us.setIsActive(isActive);
			us.setDob(dob);
			us.setCreatedOn(createdOn);
			us.setPassword(passwors);
			
		    userList.add(us);
		}
		
	   }catch(SQLException se) {se.printStackTrace();}
		return userList;
	}

}
