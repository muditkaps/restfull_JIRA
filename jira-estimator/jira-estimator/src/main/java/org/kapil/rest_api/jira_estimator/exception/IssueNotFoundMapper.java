package org.kapil.rest_api.jira_estimator.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.kapil.rest_api.jira_estimator.model.ErrorMessage;

@Provider
public class IssueNotFoundMapper implements ExceptionMapper<IssueNotFound>{

	@Override
	public Response toResponse(IssueNotFound exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 404, "http://stackoverflow.com/");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
