package com.dtcc.workflowmetrics.exception;

import java.util.ArrayList;

public class MetricsLogicException extends MetricsException {
    
    private ArrayList<MetricsError> errors = new ArrayList<MetricsError>();

    public final ArrayList<MetricsError> getErrors() {
        return errors;
    }

    public final MetricsLogicException setErrors(ArrayList<MetricsError> errors) {
        this.errors = errors;
    
        return this;
    }
}
