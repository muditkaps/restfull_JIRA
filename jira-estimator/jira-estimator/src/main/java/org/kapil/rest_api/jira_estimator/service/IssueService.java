package org.kapil.rest_api.jira_estimator.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.kapil.rest_api.jira_estimator.database.DatabaseClass;
import org.kapil.rest_api.jira_estimator.exception.IssueNotFound;
import org.kapil.rest_api.jira_estimator.exception.IssueTypeNotFound;
import org.kapil.rest_api.jira_estimator.model.Issue;
import org.kapil.rest_api.jira_estimator.model.IssueType;

public class IssueService {

	private Map<URI, Issue> issues = DatabaseClass.getIssues();
	private Map<String, IssueType> issuesTypes = DatabaseClass.getIssueTypes();

	public Issue getIssue(long issueNumber, String path) throws URISyntaxException{
		URI uri = new URI("/"+path);
		Issue issue = issues.get(uri);

		if(issue == null){
			throw new IssueNotFound("Issue with ID "+issueNumber+" not found");
		}
		return issues.get(uri);
	} 

	public Issue addIssue(Issue issue){
		issues.put(issue.getId(), issue);
		return issue;		
	}

	public List<Issue> getAllIssues(){
		return  new ArrayList<Issue>( issues.values());
	}


	public List<IssueType> getAllIssuesTypes(){
		return  new ArrayList<IssueType>( issuesTypes.values());
	}
	public void addIssueType(IssueType issueType){	
		issuesTypes.put(issueType.getId().toString(), issueType);	
	}

	public IssueType getissuesByIssueType(String issueType, String path) throws URISyntaxException{
		URI uri = new URI("/"+path);
		IssueType issuetype = issuesTypes.get(uri.toString());
		if(issuetype == null){
			throw new IssueTypeNotFound("IssueType "+issueType+" not found");
		}
		return issuesTypes.get(uri.toString());
	}

	/**
	 * Generates Total estimate time for all the issues for an IssueType. 
	 * Output format is "time : issuetype", example: 12 : bugs
	 */
	public String getTotalTimeForIssueType(IssueType issueType){

		long time = 0;
		for(URI uri: issueType.getIssues()){			
			if(issues.containsKey(uri)){
				time+=issues.get(uri).getEstimate();
			}		
		}
		return issueType.getName()+" : "+time;
	}

	/**
	 * Returns getTotalTimeForIssueType() for all IssueTypes
	 */
	public String getAllIssueTimes() throws RuntimeException{
		StringBuilder result = new StringBuilder();
		List<IssueType> issueTypes = getAllIssuesTypes();
		if(issueTypes.isEmpty()){
			throw new IssueTypeNotFound("No issues found mapped to IssueTypes");			
		}
		for(IssueType issueType : issueTypes){
			result.append(getTotalTimeForIssueType(issueType));
			result.append(System.getProperty("line.separator"));
		}
		return result.toString();
	}

}
