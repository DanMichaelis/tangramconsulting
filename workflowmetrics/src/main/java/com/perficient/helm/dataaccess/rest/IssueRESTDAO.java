package com.perficient.helm.dataaccess.rest;

import org.springframework.web.client.RestTemplate;

import com.perficient.helm.events.jira.issue.Issue;

public class IssueRESTDAO {
    public static Issue getIssue(String issueKey) {
        RestTemplate template = new RestTemplate();
        Issue issue = template.getForObject("http://localhost:8080/rest/api/2/issue/" + issueKey, Issue.class);
        System.out.println(issue);
        
        
        
        
        
        
        
        
        return null;
    }
}
