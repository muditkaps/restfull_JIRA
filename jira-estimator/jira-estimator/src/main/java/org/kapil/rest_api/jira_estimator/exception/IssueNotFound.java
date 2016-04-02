package org.kapil.rest_api.jira_estimator.exception;

public class IssueNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2986019070541527655L;
	
	public IssueNotFound(String message){
		super(message);
	}
}
