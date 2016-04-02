package org.kapil.rest_api.jira_estimator.exception;

public class IssueTypeNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2986019070541527634L;
	
	public IssueTypeNotFound(String message){
		super(message);
	}
}
