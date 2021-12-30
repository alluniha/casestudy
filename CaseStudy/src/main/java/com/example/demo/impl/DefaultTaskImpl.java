package com.example.demo.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Task;
import com.example.demo.TaskInterface;

@Component
public class DefaultTaskImpl implements TaskInterface{
	
	@Autowired
	DbConnection db;
	
	int row = 0;
	
	@Autowired
	Task task = null;
	
	@Autowired
	Task tk1;
	
	@Override
	public int createTask(Task task) {
		try {
			 PreparedStatement ps = db.getConnection().prepareStatement("Insert into task values(?,?,?,?,?,?,?,?,?,?,?)");
			 ps.setInt(1, task.getTaskID());
			 ps.setInt(2, task.getOwnerID());
			 ps.setInt(3, task.getCreatorID());
			 ps.setString(4, task.getName());
			 ps.setString(5, task.getDescription());
			 ps.setString(6, task.getStatus());
			 ps.setString(7, task.getPriority());
			 ps.setString(8, task.getNotes());
			 ps.setBoolean(9, task.getIsBookmarked());
			 ps.setString(10, task.getCreatedOn());
			 ps.setString(11, task.getStatusChangedOn());
			 row = ps.executeUpdate();
			 db.closeConnection();
		}catch(SQLException e) {System.out.println(e);}
		
		return row;
		
	}

	@Override
	public List<Task> getAllTasks() {
	
		List<Task> taskList = new ArrayList<>();
		try {
		PreparedStatement ps = db.getConnection().prepareStatement("Select * from task");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Task tk = new Task();
			int taskID = rs.getInt(1);
			int ownerID = rs.getInt(2);
			int creatorID = rs.getInt(3);
			String name = rs.getString(4);
			String description = rs.getString(5);
			String status = rs.getString(6);
			String priority = rs.getString(7);
			String notes = rs.getString(8);
			Boolean isBookmarked = rs.getBoolean(9);
			String createdOn = rs.getString(10);
			String statusChangedOn = rs.getString(11);
			
			tk.setTaskID(taskID);
			tk.setOwnerID(ownerID);
			tk.setCreatorID(creatorID);
			tk.setName(name);
			tk.setDescription(description);
			tk.setStatus(status);
			tk.setPriority(priority);
			tk.setNotes(notes);
			tk.setIsBookmarked(isBookmarked);
			tk.setCreatedOn(createdOn);
			tk.setStatusChangedOn(statusChangedOn);
			
			taskList.add(tk);
		}
		
	   }catch(SQLException se) {se.printStackTrace();}
		return taskList;
	}

	@Override
	public int assignTask(int taskid, int userid) {
		try {
			 PreparedStatement ps = db.getConnection().prepareStatement("update task set owner_id = ? where task_id = ?");
			 ps.setInt(1, userid);
			 ps.setInt(2, taskid);
			 row = ps.executeUpdate();
			 db.closeConnection();
			 
		 }catch(SQLException sqe) {sqe.printStackTrace();}
		 
		return row;

	}

	@Override
	public int setPriority(int taskid, String priority) {
		try {
			 
			 PreparedStatement ps = db.getConnection().prepareStatement("update task set priority = ? where task_id = ?");
			 ps.setString(1, priority);
			 ps.setInt(2, taskid);
			 row = ps.executeUpdate();
			 db.closeConnection();
			 
		 }catch(SQLException sqe) {sqe.printStackTrace();}
		 
		return row;

	}

	@Override
	public int addNotes(int taskid, String notes) {
		try {
			 
			 PreparedStatement ps = db.getConnection().prepareStatement("update task set notes = ? where task_id = ?");
			 ps.setString(1, notes);
			 ps.setInt(2, taskid);
			 row = ps.executeUpdate();
			 db.closeConnection();
			 
		 }catch(SQLException sqe) {sqe.printStackTrace();}
		 
		return row;

	}

	@Override
	public int addBookmark(int taskid, boolean isBookmarked) {
		try {
			 PreparedStatement ps = db.getConnection().prepareStatement("update task set IsBookmarked = ? where task_id = ?");
			 ps.setBoolean(1, isBookmarked);
			 ps.setInt(2, taskid);
			 row = ps.executeUpdate();
			 db.closeConnection();
			 
		 }catch(SQLException sqe) {sqe.printStackTrace();}
		 
		return row;

	}

	@Override
	public List<Task> searchTask(int taskid) {
		List<Task> taskList = new ArrayList<>();
		try {
			 PreparedStatement ps = db.getConnection().prepareStatement("select * from task where task_id = ?");
			 ps.setInt(1, taskid);
			 ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					int taskID = rs.getInt(1);
					int ownerID = rs.getInt(2);
					int creatorID = rs.getInt(3);
					String name = rs.getString(4);
					String description = rs.getString(5);
					String status = rs.getString(6);
					String priority = rs.getString(7);
					String notes = rs.getString(8);
					Boolean isBookmarked = rs.getBoolean(9);
					String createdOn = rs.getString(10);
					String statusChangedOn = rs.getString(11);
					
					tk1.setTaskID(taskID);
					tk1.setOwnerID(ownerID);
					tk1.setCreatorID(creatorID);
					tk1.setName(name);
					tk1.setDescription(description);
					tk1.setStatus(status);
					tk1.setPriority(priority);
					tk1.setNotes(notes);
					tk1.setIsBookmarked(isBookmarked);
					tk1.setCreatedOn(createdOn);
					tk1.setStatusChangedOn(statusChangedOn);
					taskList.add(tk1);
				}

			
			 db.closeConnection();
			 
		 }catch(SQLException sqe) {sqe.printStackTrace();}
		 
		return taskList;

	}

	@Override
	public List<Task> trackTask(String status) {
		List<Task> taskList = new ArrayList<>();
		try {
		PreparedStatement ps = db.getConnection().prepareStatement("Select * from task where status = ?");
		ps.setString(1, status);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Task tk = new Task();
			int taskID = rs.getInt(1);
			int ownerID = rs.getInt(2);
			int creatorID = rs.getInt(3);
			String name = rs.getString(4);
			String description = rs.getString(5);
			String stat = rs.getString(6);
			String priority = rs.getString(7);
			String notes = rs.getString(8);
			Boolean isBookmarked = rs.getBoolean(9);
			String createdOn = rs.getString(10);
			String statusChangedOn = rs.getString(11);
			
			tk.setTaskID(taskID);
			tk.setOwnerID(ownerID);
			tk.setCreatorID(creatorID);
			tk.setName(name);
			tk.setDescription(description);
			tk.setStatus(stat);
			tk.setPriority(priority);
			tk.setNotes(notes);
			tk.setIsBookmarked(isBookmarked);
			tk.setCreatedOn(createdOn);
			tk.setStatusChangedOn(statusChangedOn);
			
			taskList.add(tk);
		}
		
	   }catch(SQLException se) {se.printStackTrace();}
		return taskList;
	}

	@Override
	public int deleteTask(int taskid) {
		try {
			 PreparedStatement ps = db.getConnection().prepareStatement("delete from task where task_id=?");
			 ps.setInt(1, taskid);
			 row = ps.executeUpdate();
			 db.closeConnection();
			 
		 }catch(SQLException sqe) {sqe.printStackTrace();}

		
				return row;
	}
	
	

}
