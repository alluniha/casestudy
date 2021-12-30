package com.example.demo;

import java.util.List;

public interface TaskInterface {
	public Task getTask(int Task_Id);
	public List<Task> getAllTasks();
	public Task setPriority(Task task);
	public Task setNotes(Task task);
	public Task setBookmark(Task task);
	public Task addTask(Object object);
	public List<Task> getAllTasksstatus(String status);
	public Task assignTask(Task task);
	public Task delete(int TaskId);
	public Task update(int TaskId,Task task);
	
}
