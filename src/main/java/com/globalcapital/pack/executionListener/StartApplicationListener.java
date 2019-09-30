package com.globalcapital.pack.executionListener;
/**
 * @author michael.akinyade 
 * 
 */
import java.util.logging.Logger;

import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.history.HistoricActivityStatisticsQuery;
import org.camunda.bpm.engine.impl.context.Context;

import com.globalcapital.pack.database.H2DatabaseLuncher;
import com.globalcapital.pack.database.dao.ProcessRun;
import com.globalcapital.pack.database.dao.TaskHistory;

public class StartApplicationListener implements ExecutionListener {

	private static final Logger LOGGER = Logger.getLogger(StartApplicationListener.class.getName());

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		ProcessRun pr = new ProcessRun();
		TaskHistory taskHistory = H2DatabaseLuncher
				.getTaskHistoryByID(String.valueOf(execution.getProcessInstanceId()));
		pr.setPk_processStepLu(execution.getCurrentActivityId());
		pr.setRunNumber(execution.getActivityInstanceId());
		pr.setProcessRunTrackerid(execution.getProcessInstanceId());
		pr.setUserName(Context.getCommandContext().getAuthenticatedUserId());
		pr.setDateTimeEnd(taskHistory.getEndTime());
		pr.setDateTimeStart(taskHistory.getStartTime());
		String activityName = execution.getCurrentActivityName();
		LOGGER.info("user that started the process is: " + "userStarted_Process" + "Activity name is : " + activityName
				+ " process ID is : " + execution.getActivityInstanceId() + "Process CurrentActivity is :"
				+ execution.getCurrentActivityId() + "Process InstanceId is " + execution.getProcessInstanceId());
	}

}
