package com.dtcc.workflowmetrics.metricsitems.jira;

import com.dtcc.workflowmetrics.metricsitems.jira.common.StatusDetails;

public class IssueTransition {
    private String id;
    private String name;
    private StatusDetails to;
    private Boolean hasScreen;
    private Boolean isGlobal;
    private Boolean isInitial;
    private Boolean isConditional;
    private Object fields;
    private String expand;
}
