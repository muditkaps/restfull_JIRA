package org.kapil.rest_api.jira_estimator.model;

import java.net.URI;

public class Issue {

	URI id;
	URI issuetype;
	String description;
	Long estimate;

	public Issue(){

	}

	public Issue(URI id, URI issuetype, String description, Long estimate) {
		this.id = id;
		this.issuetype = issuetype;
		this.description = description;
		this.estimate = estimate;
	}

	public URI getId() {
		return id;
	}

	public void setId(URI id) {
		this.id = id;
	}

	public URI getIssuetype() {
		return issuetype;
	}

	public void setIssuetype(URI issuetype) {
		this.issuetype = issuetype;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getEstimate() {
		return estimate;
	}

	public void setEstimate(Long estimate) {
		this.estimate = estimate;
	}

}
