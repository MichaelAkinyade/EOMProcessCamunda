package com.globalcapital.pack.database.dao;

/**
 * @author michael.akinyade 
 * 
 */
import java.util.Date;

public class TaskHistory {
	
	
	public String id;
	public String taskDefinationKey;
	public String processDefinitionkey;
	public String executionId;
	public String accountInstanceId;
	public String description;
	public String taskName;
	public Date startTime;
	public Date endTime;
	public long duration;
	public Date dueDate;
	public Date followUpDate;
	public Date removalTime;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTaskDefinationKey() {
		return taskDefinationKey;
	}
	public void setTaskDefinationKey(String taskDefinationKey) {
		this.taskDefinationKey = taskDefinationKey;
	}
	public String getProcessDefinitionkey() {
		return processDefinitionkey;
	}
	public void setProcessDefinitionkey(String processDefinitionkey) {
		this.processDefinitionkey = processDefinitionkey;
	}
	public String getExecutionId() {
		return executionId;
	}
	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}
	public String getAccountInstanceId() {
		return accountInstanceId;
	}
	public void setAccountInstanceId(String accountInstanceId) {
		this.accountInstanceId = accountInstanceId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getFollowUpDate() {
		return followUpDate;
	}
	public void setFollowUpDate(Date followUpDate) {
		this.followUpDate = followUpDate;
	}
	public Date getRemovalTime() {
		return removalTime;
	}
	public void setRemovalTime(Date removalTime) {
		this.removalTime = removalTime;
	}
	
	
	

}
