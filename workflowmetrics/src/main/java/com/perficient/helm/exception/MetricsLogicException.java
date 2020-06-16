package com.perficient.helm.exception;

import java.util.ArrayList;

public class MetricsLogicException extends MetricsException {
    
    private ArrayList<MetricsError> errors = new ArrayList<MetricsError>();

    public MetricsLogicException() {
        super();
    }

    public MetricsLogicException(Integer errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public MetricsLogicException(Integer errorCode) {
        super(errorCode);
    }

    public MetricsLogicException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MetricsLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public MetricsLogicException(String message) {
        super(message);
    }

    public MetricsLogicException(Throwable cause) {
        super(cause);
    }

    public final ArrayList<MetricsError> getErrors() {
        return errors;
    }

    public final MetricsLogicException setErrors(ArrayList<MetricsError> errors) {
        this.errors = errors;
    
        return this;
    }
}
