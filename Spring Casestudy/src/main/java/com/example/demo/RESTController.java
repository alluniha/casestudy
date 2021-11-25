package com.example.demo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {
	@Autowired
	TaskInterface dao;
	@Autowired
	UserInterface userdao;
	@RequestMapping(value="/gettask/taskid/{TaskId}",method=RequestMethod.GET,produces= {"application/json","application/xml"})
	public List<Task> setTask(@PathVariable int TaskId) throws SQLException
	{
		return dao.getTask(TaskId);
	}
	@RequestMapping(value="/listtask",method=RequestMethod.GET,produces= {"application/json","application/xml"})
	public List<Task> getAllTasks()
	{
		return dao.getAllTasks();
	}
	@RequestMapping(value="/updatenotes/taskid/{TaskId}/notes/{Notes}",method=RequestMethod.GET,produces= {"application/json","application/xml"})
	public int getUpdateNotes(@PathVariable int TaskId,@PathVariable String Notes) throws SQLException
	{
		return dao.setNotes(TaskId,Notes);
	}
	@RequestMapping(value="/updatebookmark/taskid/{TaskId}/bookmark/{isBookmarked}",method=RequestMethod.GET,produces= {"application/json","application/xml"})
	public int getUpdateBookmark(@PathVariable int TaskId,@PathVariable Boolean isBookmarked) throws SQLException
	{
		return dao.setBookmark(TaskId,isBookmarked);
	}
	@RequestMapping(value="/assigntask/taskid/{TaskId}/ownerid/{OwnerId}",method=RequestMethod.GET,produces= {"application/json","application/xml"})
	public List<Task> setTask(@PathVariable int TaskId,@PathVariable int OwnerId) throws SQLException
	{
		@SuppressWarnings("unused")
		int row=dao.assignTask(TaskId, OwnerId);
		return dao.getTask(TaskId);
	}
	@RequestMapping(value="/updatepriority/taskid/{TaskId}/priority/{Priority}",method=RequestMethod.GET,produces= {"application/json","application/xml"})
	public int getUpdate(@PathVariable int TaskId,@PathVariable String Priority) throws SQLException
	{
		return dao.setPriority(TaskId,Priority);
	}
	@PostMapping(value= "/addtask", consumes = "application/json", produces = "application/json")
	public Task addTask(@RequestBody Task task) throws Exception
	{
		dao.addTask(task);
		return task;
		
	}
	@PostMapping(value= "/adduser", consumes = "application/json", produces = "application/json")
	public User addUser(@RequestBody User user) throws Exception
	{
		userdao.addUser(user);
		return user;
		
	}
	@RequestMapping(value="/trackstatus/status/{Status}",method=RequestMethod.GET,produces= {"application/json","application/xml"})
	public List<Task> getAllTasksstatus(@PathVariable String Status) throws SQLException
		{
			return dao.getAllTasksstatus(Status);
		}
	
}
