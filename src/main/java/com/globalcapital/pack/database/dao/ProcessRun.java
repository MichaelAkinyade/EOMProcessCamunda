package com.globalcapital.pack.database.dao;
/**
 * @author michael.akinyade 
 * 
 */

import java.util.Date;

public class ProcessRun {

	public int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProcessRunTrackerid() {
		return processRunTrackerid;
	}
	public void setProcessRunTrackerid(String processRunTrackerid) {
		this.processRunTrackerid = processRunTrackerid;
	}
	public String getRunNumber() {
		return runNumber;
	}
	public void setRunNumber(String runNumber) {
		this.runNumber = runNumber;
	}
	public String getPk_processStepLu() {
		return pk_processStepLu;
	}
	public void setPk_processStepLu(String pk_processStepLu) {
		this.pk_processStepLu = pk_processStepLu;
	}
	public Date getDateTimeStart() {
		return dateTimeStart;
	}
	public void setDateTimeStart(Date dateTimeStart) {
		this.dateTimeStart = dateTimeStart;
	}
	public Date getDateTimeEnd() {
		return dateTimeEnd;
	}
	public void setDateTimeEnd(Date dateTimeEnd) {
		this.dateTimeEnd = dateTimeEnd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String processRunTrackerid;
	public String runNumber;
	public String pk_processStepLu;
	public Date dateTimeStart;
	public Date dateTimeEnd;
	public String userName;
	
	
}
