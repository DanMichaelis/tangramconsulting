package com.dtcc.workflowmetrics.metricsitems.jira;

import java.util.ArrayList;
import java.util.HashMap;

import com.dtcc.workflowmetrics.issueObjects.util.IssueComparatorFactory;

public class IssueList {
    private static final HashMap<String, ArrayList<IssueHistory>> issueList = new HashMap<String, ArrayList<IssueHistory>>();
    private static final IssueComparatorFactory issueComparator = new IssueComparatorFactory();
    
    public static final void addIssue(IssueHistory issue) {
        ArrayList<IssueHistory> issues;
       if (issueList.containsKey(issue.getKey())) {
           issues = issueList.get(issue.getKey());
           issues.add(issue);
           issues.sort(IssueComparatorFactory.getDateComparator());
       } else {
           issues =  new ArrayList<IssueHistory>(1);
           issues.add(issue);
           issueList.put(issue.getKey(), issues);
       }
    }
    
    public static final ArrayList<IssueHistory> getIssuesByKey(String key) {
        return issueList.get(key);
    }
     
    public static final ArrayList<IssueHistory> getAllIssues() {
        ArrayList<IssueHistory> issues = new ArrayList<IssueHistory>();
        for (String key : issueList.keySet()) {
            issues.addAll(issueList.get(key));
        }
        issues.sort(IssueComparatorFactory.getKeyAndDateComparator());
        return issues;
    }
}
