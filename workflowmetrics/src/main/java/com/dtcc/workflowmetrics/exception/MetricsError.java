package com.dtcc.workflowmetrics.exception;

public class MetricsError {
    private Integer errorCode;
    private String errorMessage;
    
    public MetricsError(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public final Integer getErrorCode() {
        return errorCode;
    }

    public final MetricsError setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    
        return this;
    }

    public final String getErrorMessage() {
        return errorMessage;
    }

    public final MetricsError setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((errorCode == null) ? 0 : errorCode.hashCode());
        result = prime * result + ((errorMessage == null) ? 0 : errorMessage.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        MetricsError other = (MetricsError) obj;
        if (errorCode == null) {
            if (other.errorCode != null) {
                return false;
            }
        } else if (!errorCode.equals(other.errorCode)) {
            return false;
        }
        if (errorMessage == null) {
            if (other.errorMessage != null) {
                return false;
            }
        } else if (!errorMessage.equals(other.errorMessage)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MetricsError [errorCode=");
        builder.append(errorCode);
        builder.append(", errorMessage=");
        builder.append(errorMessage);
        builder.append("]");
        return builder.toString();
    }
    
}
