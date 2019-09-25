package com.dtcc.workflowmetrics.issueObjects.util;

import java.util.Comparator;

import com.dtcc.workflowmetrics.metricsitems.IssueHistory;

public class IssueComparatorFactory {

    private static DateComparator dateComparator = new DateComparator();
    private static KeyComparator keyComparator = new KeyComparator();
    private static KeyAndDateComparator keyAndDateComparator = new KeyAndDateComparator();

    public static final Comparator<IssueHistory> getDateComparator() {
        return dateComparator;
    }

    public static final Comparator<IssueHistory> getKeyComparator() {
        return keyComparator;
    }
    
    public static final Comparator<IssueHistory> getKeyAndDateComparator() {
        return keyAndDateComparator;
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

    static class KeyAndDateComparator implements Comparator<IssueHistory> {
        @Override
        public int compare(IssueHistory issue1, IssueHistory issue2) {
            if (0 == issue1.getKey().compareTo(issue2.getKey())) {
                return issue1.getEventDate().compareTo(issue2.getEventDate());
            }
            return issue1.getKey().compareTo(issue2.getKey());
        }
    }

}
