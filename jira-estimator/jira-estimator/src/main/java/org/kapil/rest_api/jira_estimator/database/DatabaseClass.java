package org.kapil.rest_api.jira_estimator.database;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.kapil.rest_api.jira_estimator.model.Issue;
import org.kapil.rest_api.jira_estimator.model.IssueType;

public class DatabaseClass {

	private static Map<URI, Issue> issues = new HashMap<URI, Issue>();
	private static Map<String, IssueType> issueTypes = new HashMap<String, IssueType>();

	public static Map<String, IssueType> getIssueTypes() {
		return issueTypes;
	}

	public static Map<URI, Issue> getIssues() {
		return issues;
	}

}
