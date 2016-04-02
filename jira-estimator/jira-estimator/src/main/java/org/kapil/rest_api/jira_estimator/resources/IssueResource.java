package org.kapil.rest_api.jira_estimator.resources;

import java.net.URISyntaxException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import org.kapil.rest_api.jira_estimator.service.IssueService;
import org.kapil.rest_api.jira_estimator.model.Issue;

@Path("/issues")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IssueResource {

	IssueService issueService = new IssueService();

	@GET
	public List<Issue> getAllIssues(){
		return issueService.getAllIssues();
	}

	@GET
	@Path("/{issueNumber}")
	public Issue getIssue(@PathParam("issueNumber") long issueNumber, @Context UriInfo uriInfo ) throws URISyntaxException{
		Issue issue = issueService.getIssue(issueNumber,uriInfo.getPath());
		return issue;
	}

	@POST
	public Response addIssue(Issue issue){
		issueService.addIssue(issue);
		return Response.status(Status.CREATED).entity(issue).build();
	}

}
