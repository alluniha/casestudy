package com.example.demo.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.Task;
import com.example.demo.TaskInterface;
@SpringBootApplication
@Component
public class DefaultTaskimpl implements TaskInterface {

	DbConnection db=new DbConnection();
	Task task=null;
	
	int row=0;
	int row2=0;
	int row7=0;
	int row5=0;
	@Override
	public Task getTask(int Task_Id){
		Task ts=new Task();
		try {
			PreparedStatement cs1=db.getConnection().prepareStatement("select * from task where Task_Id=? ");
			cs1.setInt(1, Task_Id);
			ResultSet rs=cs1.executeQuery();
			while(rs.next()) {
				
				ts.setTask_Id(rs.getInt(1));
				ts.setOwner_Id(rs.getInt(2));
				ts.setCreator_Id(rs.getInt(3));
				ts.setName(rs.getString(4));
				ts.setDescription(rs.getString(5));
				ts.setStatus(rs.getString(6));
				ts.setPriority(rs.getString(7));
				ts.setNotes(rs.getString(8));
				ts.setIsBookmarked(rs.getBoolean(9));
				ts.setCreated_On(rs.getString(10));
				ts.setStatusChanged_On(rs.getString(11));
			}
		}catch(SQLException e) {e.printStackTrace();}
		
		return ts;
		
	}
	@Override 
	public List<Task> getAllTasks(){
	List<Task> taskList=new ArrayList<>();
	try {
		PreparedStatement cs1=db.getConnection().prepareStatement("select * from task ");
		
		ResultSet rs=cs1.executeQuery();
		while(rs.next()) {
			Task ts=new Task();
			ts.setTask_Id(rs.getInt(1));
			ts.setOwner_Id(rs.getInt(2));
			ts.setCreator_Id(rs.getInt(3));
			ts.setName(rs.getString(4));
			ts.setDescription(rs.getString(5));
			ts.setStatus(rs.getString(6));
			ts.setPriority(rs.getString(7));
			ts.setNotes(rs.getString(8));
			ts.setIsBookmarked(rs.getBoolean(9));
			ts.setCreated_On(rs.getString(10));
			ts.setStatusChanged_On(rs.getString(11));
			taskList.add(ts);
		}
	}catch(SQLException e) {e.printStackTrace();}
	
	return taskList;
	}
	public Task setNotes(Task task) {
		try {
			PreparedStatement cs2=db.getConnection().prepareStatement("update Task set Notes=? where Task_Id=?");
			cs2.setString(1,task.getNotes());
			cs2.setInt(2,task.getTask_Id());
			row=cs2.executeUpdate();
			
			db.closeConnection();
		}catch(SQLException e) {System.out.println(e);}
		return task;
		
	}
	public Task setBookmark(Task task)
	{
		try {
			PreparedStatement cs2=db.getConnection().prepareStatement("update Task set isBookmarked=? where Task_Id=?");
			cs2.setBoolean(1,task.getIsBookmarked());
			cs2.setInt(2,task.getTask_Id());
			row=cs2.executeUpdate();
			System.out.println("this number of updated records  are "+row);
			db.closeConnection();
		}catch(SQLException e) {System.out.println(e);}
		return task;
		
	}
	public Task setPriority(Task task)
	{
		
		try {
			PreparedStatement cs2=db.getConnection().prepareStatement("update Task set Priority=? where Task_Id=?");
			cs2.setString(1,task.getPriority());
			cs2.setInt(2,task.getTask_Id());
			row=cs2.executeUpdate();
			System.out.println("this number of updated records  are "+row);
			db.closeConnection();
		}catch(SQLException e) {System.out.println(e);}
		return task;
		
	}
	public Task addTask(Object object)
	{
		try {
			task=(Task)object;
			PreparedStatement cs= db.getConnection().prepareStatement
					("insert into TASK values(?,?,?,?,?,?,?,?,?,?,?)");
			cs.setInt(1,task.getTask_Id());
			cs.setInt(2, task.getOwner_Id());
			cs.setInt(3,task.getCreator_Id());
			cs.setString(4, task.getName());
			cs.setString(5, task.getDescription());
			cs.setString(6, task.getStatus());
			cs.setString(7, task.getPriority());
			cs.setString(8, task.getNotes());
			cs.setBoolean(9, task.getIsBookmarked());
			cs.setString(10, task.getCreated_On());
			cs.setString(11,task.getStatusChanged_On() );
			@SuppressWarnings("unused")
			int row3=cs.executeUpdate();
			db.closeConnection();
		}catch(SQLException e) {e.printStackTrace();}
		return task;
	}
	public List<Task> getAllTasksstatus(String status)
	{
		List<Task> taskstatusList=new ArrayList<>();
		try {
			PreparedStatement cs1=db.getConnection().prepareStatement("select * from task where Status=?");
			cs1.setString(1,status);
			ResultSet rs=cs1.executeQuery();
			while(rs.next()) {
				Task ts=new Task();
				ts.setTask_Id(rs.getInt(1));
				ts.setOwner_Id(rs.getInt(2));
				ts.setCreator_Id(rs.getInt(3));
				ts.setName(rs.getString(4));
				ts.setDescription(rs.getString(5));
				ts.setStatus(rs.getString(6));
				ts.setPriority(rs.getString(7));
				ts.setNotes(rs.getString(8));
				ts.setIsBookmarked(rs.getBoolean(9));
				ts.setCreated_On(rs.getString(10));
				ts.setStatusChanged_On(rs.getString(11));
				taskstatusList.add(ts);
			}
		}catch(SQLException e) {e.printStackTrace();}
		
		return taskstatusList;
	}
	public Task assignTask(Task task)
	{
		
		try {
			PreparedStatement cs2=db.getConnection().prepareStatement("update Task set Owner_Id=? where Task_Id=?");
			cs2.setInt(1,task.getOwner_Id());
			cs2.setInt(2,task.getTask_Id());
			row=cs2.executeUpdate();
			db.closeConnection();
		}catch(SQLException e) {System.out.println(e);}
		return task;
	}
	
	public Task delete(int TaskId) {
		try {
			PreparedStatement cs2=db.getConnection().prepareStatement("delete from task where Task_Id=?");
			cs2.setInt(1,TaskId);
			row5=cs2.executeUpdate();
			
			db.closeConnection();
		}catch(SQLException e) {System.out.println(e);}
		return task;
	}
	
	public Task update(int TaskId,Task task) {
		try {
			
			PreparedStatement cs=db.getConnection().prepareStatement("update Task set Task_Id=?,Owner_Id=?,Creator_Id=?,Name=?,Description=?,Status=?,Priority=?,Notes=?,isBookmarked=?,Created_On=?,Status_Changed_On=? where Task_Id=?");
			
			cs.setInt(1,task.getTask_Id());
			cs.setInt(2, task.getOwner_Id());
			cs.setInt(3,task.getCreator_Id());
			cs.setString(4, task.getName());
			cs.setString(5, task.getDescription());
			cs.setString(6, task.getStatus());
			cs.setString(7, task.getPriority());
			cs.setString(8, task.getNotes());
			cs.setBoolean(9, task.getIsBookmarked());
			cs.setString(10, task.getCreated_On());
			cs.setString(11,task.getStatusChanged_On() );
			cs.setInt(12,TaskId);
			row7=cs.executeUpdate();
			db.closeConnection();
		}catch(SQLException e) {System.out.println(e);}
	return task;
		
	}

}









