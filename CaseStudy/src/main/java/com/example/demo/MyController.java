package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.impl.DefaultTaskImpl;
import com.example.demo.impl.DefaultUserImpl;
@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class MyController {
	
	@Autowired
	DefaultTaskImpl taskDao;
	
	@Autowired
	DefaultUserImpl userDao;
	
	
	
	List<Task> taskList = new ArrayList<>();
	
	// As a Portal Admin, I should be able to create a task
	
	@PostMapping(value= "/createTask", consumes = "application/json", produces = "application/json")
	public Task createTask(@RequestBody Task task) throws Exception {
	   taskDao.createTask(task);
	   return task;
	}
	
	// Create a user
	
	@PostMapping(value= "/createUser", consumes = "application/json", produces = "application/json")
	public User createUser(@RequestBody User user) throws Exception {
	   userDao.createUser(user);
	   return user;
	}
	
	// As a portal admin, I should be able to assign task to the team member (taskid, userid)
	
	@GetMapping(value="/taskid/{taskid}/userid/{userid}", produces = "applicatio/json")
	public void assignTask(@PathVariable("taskid") int taskid, @PathVariable("userid") int userid, Model model) {
		model.addAttribute("taskid", taskid);
		model.addAttribute("userid", userid);
		taskDao.assignTask(taskid, userid);
	}
	
	 // As a admin, I should be able to prioritize tasks (taskid, priority)
	
	@GetMapping(value="/taskid/{taskid}/priority/{priority}", produces = "application/json")
	public void setPriority(@PathVariable("taskid") int taskid, @PathVariable("priority") String priority, Model model) {
		model.addAttribute("taskid", taskid);
		model.addAttribute("priority", priority);
		taskDao.setPriority(taskid, priority);
	}
	
	// As a admin, I should be able to add internal notes (taskid, notes)

	@GetMapping(value="/taskid/{taskid}/notes/{notes}", produces = "application/json" )
	public void addNotes(@PathVariable("taskid") int taskid, @PathVariable("notes") String notes, Model model) {
		model.addAttribute("taskid", taskid);
		model.addAttribute("notes", notes);
		taskDao.addNotes(taskid, notes);
	}
	
	 // As a admin, I should be able to add bookmark (taskid, bookmark)
	
	@GetMapping(value="/taskid/{taskid}/isBookmarked/{isBookmarked}", produces = "application/json" )
	public void addBookmark(@PathVariable("taskid") int taskid, @PathVariable("isBookmarked") boolean isBookmarked, Model model) {
		model.addAttribute("taskid", taskid);
		model.addAttribute("isBookmarked", isBookmarked);
		taskDao.addBookmark(taskid, isBookmarked);
	}
	
	// As a admin, I should be able to search tasks easier (taskid)
	
	@GetMapping(value="/taskid/{taskid}", produces = "application/json" )
	public List<Task> searchTask(@PathVariable("taskid") int taskid, Model model) {
		model.addAttribute("taskid", taskid);
		taskList = taskDao.searchTask(taskid);
		return taskList;
	}
	
	// As a admin, I should be able to get all tasks

	@GetMapping(value = "/tasks",produces = {"application/json"})
	public List<Task> getTask() {
		return taskDao.getAllTasks();
	}
	
	// As a admin, I should be able to track completion of all tasks (status)
	
	@GetMapping(value="/status/{status}", produces = "application/json" )
	public List<Task> trackTask(@PathVariable("status") String status, Model model) {
		model.addAttribute("status", status);
		taskList = taskDao.trackTask(status);
		return taskList;
	}
	
	//As a portal admin, I should be able to delete task
	@GetMapping(value="/task/{taskid}", produces = "application/json")
	public void deleteTask(@PathVariable int taskid, Model model) {
		model.addAttribute("task", taskid);
		taskDao.deleteTask(taskid);
	}
	
	//Validate user
	@GetMapping(value ="/username/{username}/password/{password}",produces = {"application/json"})
	public List<User> login(@PathVariable String username, @PathVariable String password, Model model) {
	model.addAttribute("username",username);
	model.addAttribute("password", password);
	return userDao.login(username, password);
	}
	
	//get all users
	@GetMapping(value = "/users",produces = {"application/json"})
	public List<User> getUser() {
		return userDao.getAllUsers();
	}
}
