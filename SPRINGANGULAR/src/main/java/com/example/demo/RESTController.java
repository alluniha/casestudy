package com.example.demo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="http://localhost:4200/")
@RestController
public class RESTController {
	@Autowired
	TaskInterface dao;
	@Autowired
	UserInterface userdao;

	@RequestMapping(value="/gettask/{Task_Id}",method=RequestMethod.GET,produces= {"application/json"})
	public Task gTask(@PathVariable int Task_Id) throws SQLException
	{
		return dao.getTask(Task_Id);
	}
	@RequestMapping(value="/deletetask/{TaskId}",method=RequestMethod.DELETE,produces= {"application/json"})
	public Task deleteTask(@PathVariable int TaskId) throws SQLException
	{
		return dao.delete(TaskId);
	}
	@RequestMapping(value="/listtask",method=RequestMethod.GET,produces= {"application/json"})
	public List<Task> getAllTasks()
	{
		return dao.getAllTasks();
	}
	@RequestMapping(value="/updatenotes",method=RequestMethod.PUT,produces= {"application/json"}, consumes = "application/json")
	public Task getUpdateNotes(@RequestBody Task task) throws SQLException
	{
		return dao.setNotes(task);
	}
	@RequestMapping(value="/updatebookmark",method=RequestMethod.PUT,produces= {"application/json"}, consumes = "application/json")
	public Task getUpdateBookmark(@RequestBody Task task) throws SQLException
	{
		return dao.setBookmark(task);
	}
	
	@RequestMapping(value="/updatepriority",method=RequestMethod.PUT,produces= {"application/json"}, consumes = "application/json")
	public Task getUpdate(@RequestBody Task task) throws SQLException
	{
		return dao.setPriority(task);
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
	@PostMapping(value= "/validateuser", consumes = "application/json", produces = "application/json")
	public boolean validateuser(@RequestBody User user) throws Exception
	{
		return userdao.validateuser(user); 
		
	}
	@RequestMapping(value="/trackstatus/{Status}",method=RequestMethod.GET,produces= {"application/json"})
	public List<Task> getAllTasksstatus(@PathVariable String Status) throws SQLException
		{
			return dao.getAllTasksstatus(Status);
		}
	@RequestMapping(value="/assigntask",method=RequestMethod.PUT,produces= {"application/json"}, consumes = "application/json")
	public Task setTask(@RequestBody Task task) throws SQLException
	{
		
		return dao.assignTask(task);
	}
	@RequestMapping(value="/updatetask/{TaskId}",method=RequestMethod.PUT,produces= {"application/json"})
	public Task update(@PathVariable int TaskId,@RequestBody Task task) throws SQLException
	{	
		 return dao.update(TaskId,task);
	}
}
