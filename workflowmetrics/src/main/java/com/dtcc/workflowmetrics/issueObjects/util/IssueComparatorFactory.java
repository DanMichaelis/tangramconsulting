package com.dtcc.workflowmetrics.issueObjects.util;

import java.util.Comparator;

import com.dtcc.workflowmetrics.issueObjects.IssueHistory;

public class IssueComparatorFactory {

    private static DateComparator dateComparator = new DateComparator();
    private static KeyComparator keyComparator = new KeyComparator();
    
    public static final Comparator<IssueHistory> getDateComparator() {
        return dateComparator;
    }
    
    public static final Comparator<IssueHistory> getKeyComparator() {
        return keyComparator;
    }
    
    static class DateComparator implements Comparator<IssueHistory> {
        
        @Override
        public int compare(IssueHistory issue1, IssueHistory issue2) {
            return issue1.getEventDate().compareTo(issue2.getEventDate());
        }    
    }
    
    static class KeyComparator implements Comparator<IssueHistory> {
        @Override
        public int compare(IssueHistory issue1, IssueHistory issue2) {
            return issue1.getKey().compareTo(issue2.getKey());
        }  
    }
    

}
