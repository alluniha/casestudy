package com.example.demo;

import java.sql.Timestamp;


public class Task {
	
	
		private int Task_Id;
		private int Owner_Id;
		private int Creator_Id;
		private String Name;
		private String Description;
		private String Status;
		private String Priority;
		private String Notes;
		private Boolean isBookmarked;
		private Timestamp Created_On;
		private Timestamp StatusChanged_On;
		public int getTask_Id() {
			return Task_Id;
		}
		public void setTask_Id(int task_Id) {
			Task_Id = task_Id;
		}
		public int getOwner_Id() {
			return Owner_Id;
		}
		public void setOwner_Id(int owner_Id) {
			Owner_Id = owner_Id;
		}
		public int getCreator_Id() {
			return Creator_Id;
		}
		public void setCreator_Id(int creator_Id) {
			Creator_Id = creator_Id;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}
		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
		}
		public String getPriority() {
			return Priority;
		}
		public void setPriority(String priority) {
			Priority = priority;
		}
		public String getNotes() {
			return Notes;
		}
		public void setNotes(String notes) {
			Notes = notes;
		}
		public Boolean getIsBookmarked() {
			return isBookmarked;
		}
		public void setIsBookmarked(Boolean isBookmarked) {
			this.isBookmarked = isBookmarked;
		}
		public Timestamp getCreated_On() {
			return Created_On;
		}
		public void setCreated_On(Timestamp created_On) {
			Created_On = created_On;
		}
		public Timestamp getStatusChanged_On() {
			return StatusChanged_On;
		}
		public void setStatusChanged_On(Timestamp statusChanged_On) {
			StatusChanged_On = statusChanged_On;
		}
		
		
		



}
