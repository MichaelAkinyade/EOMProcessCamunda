package com.globalcapital.pack;
/**
 * @author michael.akinyade 
 * 
 */

import java.util.Map;
import java.util.Random;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ProcessInstanceChecker implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		boolean financialInstance = false;
		boolean uploadTillToSolifeInstance = false;
		boolean directDebitUpdatedInsatnce = false;
		execution.setVariable("	", false);

		Map<String, Object> variables = execution.getVariables();
		if (variables.get("financialBatchCompleted") != null && variables.get("uploadTillToSolife") != null
				&& variables.get("directDebitUpdated") != null) {	
			financialInstance = (boolean) variables.get("financialBatchCompleted");
			uploadTillToSolifeInstance = (boolean) variables.get("uploadTillToSolife");
			directDebitUpdatedInsatnce = (boolean) variables.get("directDebitUpdated");

		}

		if (financialInstance && uploadTillToSolifeInstance && directDebitUpdatedInsatnce == true) {

		/*	execution.setVariable("instanceConditionalCheck", true);
			System.out.println("got here!!!");
*/
		}
		
	}
}