package com.globalcapital.pack.TaskListener;
/**
 * @author michael.akinyade 
 * 
 */
import java.util.Date;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.impl.context.Context;

import com.globalcapital.pack.database.H2DatabaseLuncher;
import com.globalcapital.pack.database.dao.ProcessRun;
import com.globalcapital.pack.database.dao.TaskHistory;

public class GenericTaskListener implements TaskListener {

	public void notify(DelegateTask delegateTask) {

		ProcessRun pr = new ProcessRun();
		TaskHistory taskHistory = H2DatabaseLuncher.getTaskHistoryByID(String.valueOf(delegateTask.getId()));
		pr.setPk_processStepLu(delegateTask.getTaskDefinitionKey());
		pr.setRunNumber(delegateTask.getId());
		pr.setProcessRunTrackerid(delegateTask.getProcessInstanceId());
		pr.setUserName(Context.getCommandContext().getAuthenticatedUserId());
		pr.setDateTimeEnd(taskHistory.getEndTime());
		pr.setDateTimeStart(taskHistory.getStartTime());
		java.sql.Timestamp ts = new java.sql.Timestamp(new Date().getTime());
		
		// Insert into the processrun table here.
		H2DatabaseLuncher.InsertUpdateAndTruncate(
				"insert  into GCLI_PROCESSRUN values (process_run_seq.nextval," + "'" + pr.getProcessRunTrackerid()
						+ "'," + "'" + pr.getRunNumber() + "'," + "'" + pr.getPk_processStepLu() + "'," + "'"
						+ pr.getDateTimeStart() + "'," + "'" + ts + "'," + "'"+pr.getUserName() + "'"+")");

	}

}
