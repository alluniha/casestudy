package com.example.demo;

import java.util.List;

public interface TaskInterface {
	public List<Task> getTask(int Task_Id);
	public List<Task> getAllTasks();
	public int setPriority(int Task_Id,String Priority);
	public int setNotes(int Task_Id,String Notes);
	public int setBookmark(int Task_Id,Boolean isBookmarked);
	public Task addTask(Object object);
	public List<Task> getAllTasksstatus(String status);
	public int assignTask(int TaskId,int ownerid);
	
}
