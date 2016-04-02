package org.kapil.rest_api.jira_estimator.model;

import java.net.URI;
import java.util.List;

public class IssueType {

	URI id;
	String name;
	List<URI> issues;

	public IssueType(){

	}

	public IssueType(URI id, String name, List<URI> issues) {
		this.id = id;
		this.name = name;
		this.issues = issues;
	}

	public URI getId() {
		return id;
	}

	public void setId(URI id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<URI> getIssues() {
		return issues;
	}

	public void setIssues(List<URI> issues) {
		this.issues = issues;
	}

}
