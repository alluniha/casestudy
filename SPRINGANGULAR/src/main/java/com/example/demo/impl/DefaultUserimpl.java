package com.example.demo.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.User;
import com.example.demo.UserInterface;


@SpringBootApplication
@Component
public class DefaultUserimpl implements UserInterface{
	DbConnection db=new DbConnection();
	User user=null;
	int row=0;
	public User addUser(Object object)
	{
		try {
			user=(User)object;
			PreparedStatement cs=db.getConnection().prepareStatement
					("insert into User values(?,?,?,?,?,?,?,?,?,?,?)");
			cs.setInt(1,user.getUser_Id());
			cs.setString(2, user.getUsername());
			cs.setString(3, user.getEmail());
			cs.setString(4, user.getFirst_Name());
			cs.setString(5, user.getLast_Name());
			cs.setLong(6, user.getContact_Number());
			cs.setString(7, user.getROLE());
			cs.setBoolean(8, user.getIsActive());
			cs.setString(9, user.getDOB());
			cs.setString(10, user.getCreated_On());
			cs.setString(11,user.getPassword());
			row=cs.executeUpdate();
			db.closeConnection();
		}catch(SQLException e) {System.out.println(e);}
		return user;
	}
	public boolean validateuser(Object object)
	{
		user=(User)object;
		try {
			PreparedStatement cs1=db.getConnection().prepareStatement("select Password from User where Email=?");
			
			cs1.setString(1, user.getEmail());
	
			
			ResultSet rs=cs1.executeQuery();
				 String  orPass = "";
		            while (rs.next()) {
		                orPass = rs.getString(1);
		            } 
		            if (orPass.equals(user.getPassword()))
		            {
		            	return true ;
		            } 
		            else {
		                
		            }
		}catch(SQLException e) {e.printStackTrace();}
		
		return false;
		
		
	}
}
