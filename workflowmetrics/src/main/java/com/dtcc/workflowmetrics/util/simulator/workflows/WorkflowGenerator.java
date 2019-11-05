package com.dtcc.workflowmetrics.util.simulator.workflows;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.dtcc.workflowmetrics.metricsitems.jira.IssueHistory;

public class WorkflowGenerator {
    
    private static Random rnd = new Random();
    
    public static ArrayList<IssueHistory> generateWorkflow(IssueHistory issue) {
        ArrayList<IssueHistory> issues = new ArrayList<IssueHistory>();
        LocalDateTime date;
        IssueHistory nextIssue = issue;
        Date previousEventDate;
        
        issue.setPreviousStatus(null);
        issue.setStatus(Status.TODO.getName());
        issue.setEventDate(new Date(System.currentTimeMillis()));
        issue.setDurationInPreviousStatus(issue);
        nextIssue = (new IssueHistory()).setStatus(issue.getStatus()).setDescription(issue.getDescription()).setIssueType(issue.getIssueType()).setKey(issue.getKey()).setPreviousStatus(issue.getPreviousStatus()).setStatus(issue.getStatus()).setEventDate(issue.getEventDate()).setSummary(issue.getSummary());
        nextIssue.setDurationInPreviousStatus(issue);
        
        // Always start in ToDo status
        issues.add(nextIssue);
        while (! issue.getStatus().contentEquals("Done") && !issue.getStatus().contentEquals("Cancelled")) {
            previousEventDate = issue.getEventDate();
            issue = moveIssueToNextStatus(issue);
            nextIssue = (new IssueHistory()).setStatus(issue.getStatus()).setDescription(issue.getDescription()).setIssueType(issue.getIssueType()).setKey(issue.getKey()).setPreviousStatus(issue.getPreviousStatus()).setStatus(issue.getStatus()).setEventDate(issue.getEventDate()).setSummary(issue.getSummary());
            nextIssue.setDurationInPreviousStatus(previousEventDate);
            issues.add(nextIssue);
        }
        return issues;
    }

    private static IssueHistory moveIssueToNextStatus(IssueHistory issue) {
        IssueHistory nextIssue = (new IssueHistory()).setStatus(issue.getStatus()).setDescription(issue.getDescription()).setIssueType(issue.getIssueType()).setKey(issue.getKey()).setPreviousStatus(issue.getPreviousStatus()).setStatus(issue.getStatus()).setEventDate(issue.getEventDate()).setSummary(issue.getSummary());
        
        // Reassign the current status to the previous status
        Status currentStatus = (Status.getStatusByName(issue.getStatus()));
        nextIssue.setPreviousStatus(currentStatus.getName());
        
        // Calculate the time in the current status, so that we know when to stamp the next date
        LocalDateTime ldt = nextIssue.getEventDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); 
        int daysSpentInStatus = rnd.nextInt(currentStatus.getMaxDuration() - currentStatus.getMinDuration()) + currentStatus.getMinDuration();
        ldt = ldt.plusDays(daysSpentInStatus);
        
        nextIssue.setEventDate(Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant()));
        nextIssue.setStatus(getNextStatus(currentStatus).getName());
        return nextIssue;
        
    }

    private static Status getNextStatus(Status currentStatus) {
       if (currentStatus.equals(Status.TODO)) {
           return getNextTodoStatus();
       }
       if (currentStatus.equals(Status.IN_PROGRESS)) {
           return getNextInProgressStatus();
       }
       if (currentStatus.equals(Status.IN_REVIEW)) {
           return getNextInReviewStatus();
       }
       if (currentStatus.equals(Status.IN_TEST)) {
           return getNextInTestStatus();
       }
       return Status.DONE;
    }
    
    private static Status getNextTodoStatus() {
        int i = rnd.nextInt(100);
        if (i < 4) {
            return Status.CANCELLED;
        }
        return Status.IN_PROGRESS;
    }
    
    private static Status getNextInProgressStatus() {
        int i = rnd.nextInt(100);
        if (i < 4) {
            return Status.CANCELLED;
        } else if (i < 14) {
            return Status.TODO;
        }
        return Status.IN_REVIEW;
    }
    
    private static Status getNextInReviewStatus() {
        int i = rnd.nextInt(100);
        if (i < 1) {
            return Status.CANCELLED;
        } else if (i < 15) {
            return Status.IN_PROGRESS;
        }
        return Status.IN_TEST;
    }
    
    private static Status getNextInTestStatus() {
        int i = rnd.nextInt(100);
        if (i < 1) {
            return Status.CANCELLED;
        } else if (i < 18) {
            return Status.IN_PROGRESS;
        }
        return Status.DONE;
    }
}
