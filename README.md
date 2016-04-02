# restfull_JIRA
# Atlassian API Exercise

## Background

A common pattern for extending the functionality of JIRA is to develop a stand-alone 
app or service that pulls data via a REST api.  JIRA exposes an api to get individual 
documents as well as executing searches via a proprietary, SQL like language called JQL.

JIRA is fundamentally a workflow engine, with the primary object being the Issue object. 
======

## Exercise

We need you to write the code to traverse a RESTful API to report on the total number of 
story points (in the context of the Scrum development methodology) for each type of Issue.  
You must "walk" the api by first querying a list of issue ids by issue type, and then 
iteratively fetching issue data for each issue within the list.  

Please write this code in Java.  You can use System.main or any framework you wish 
(Spring Boot, DropWizard, Play).  Your code needs only to walk the api a single time, 
and does not need to persist across executions.

### Input

Input can be accepted as either configuration or as command line arguments.

The following inputs will be provided:
* API root (for example, "http://www.example.com/api/v1")
* List of issue types (for example, [bug|story|task])

### Output

After your code walks the api, please output the sum of estimates for all issues of each 
issue type., one per line, in the format:
<issue type>: <estimate total>

For the sake of this exercise, you can simply use an in-memory data store.

API endpoints are the following (concatenate with the API root for a full URL):
* GET /issuetypes/<issue type>
* GET /issues/<issue id>

### Example API results

Example responses from the API are provided in the following files:

bugs.json - sample response for an issue type, named 'bug'
stories.json - sample response for an issue type, named 'story'
issue-1.json - sample response for a single, unique issue with id 1
issue-2.json - sample response for a single, unique issue with id 2
issue-3.json - sample response for a single, unique issue with id 3
issue-4.json - sample response for a single, unique issue with id 3
issue-5.json - sample response for a single, unique issue with id 3

### Other Considerations

* Assume this is a public API with NO access control
* Performance is an active concern.
* Serviceability and level of "production readiness" are concerns.
* Solution should not be machine or OS specific

