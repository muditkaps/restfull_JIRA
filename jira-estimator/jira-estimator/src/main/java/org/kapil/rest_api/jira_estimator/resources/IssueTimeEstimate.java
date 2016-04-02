package org.kapil.rest_api.jira_estimator.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.kapil.rest_api.jira_estimator.service.IssueService;

@Path("/issuetimes")
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
public class IssueTimeEstimate {

	IssueService issueService = new IssueService();

	@GET
	public String getAllIssueTimes() throws RuntimeException{
		return issueService.getAllIssueTimes();
	}
	
}
