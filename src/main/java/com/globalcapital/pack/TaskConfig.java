package com.globalcapital.pack;
/**
 * @author michael.akinyade 
 * 
 */

import java.util.Map;
import java.util.Random;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class TaskConfig implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		execution.setVariable("processStart2", true);
		
		System.out.println("got here!!!");
	}
}