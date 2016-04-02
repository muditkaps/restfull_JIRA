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
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;
import org.kapil.rest_api.jira_estimator.service.IssueService;
import org.kapil.rest_api.jira_estimator.model.IssueType;

@Path("/issuetypes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IssueTypeResource {

	IssueService issueService = new IssueService();

	@GET
	public List<IssueType> getAllIssueTypes(){
		return issueService.getAllIssuesTypes();
	}

	@GET
	@Path("/{issueType}")
	public IssueType getIssue(@PathParam("issueType") String issueType, @Context UriInfo uriInfo) throws URISyntaxException{
		IssueType issuetype = issueService.getissuesByIssueType(issueType, uriInfo.getPath());
		return issuetype;
	}

	@POST
	public Response addIssueType(IssueType issueType){
		issueService.addIssueType(issueType);
		return Response.status(Status.CREATED).entity(issueType).build();
	}


}
