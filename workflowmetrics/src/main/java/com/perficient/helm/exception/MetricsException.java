package com.perficient.helm.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public abstract class MetricsException extends RuntimeException {

    private UUID uuid;
    private Integer errorCode;
    private String errorMessage;

    private HashMap<String, Object> exceptionData;

    public MetricsException() {
        super();
        uuid = UUID.fromString(ErrorConstants.GENERAL_SYSTEM_EXCEPTION.toString() + "-"
                + ExceptionUtil.lookupMessage(ErrorConstants.GENERAL_SYSTEM_EXCEPTION));
    }

    public MetricsException(String message) {
        super(message);
        uuid = UUID.fromString(ExceptionUtil.lookupErrorCode(message) + "-" + message);
        addInfo(ErrorConstants.ERROR_MESSAGE, message);
        addInfo(ErrorConstants.ERROR_CODE, ExceptionUtil.lookupErrorCode(message));
    }

    public MetricsException(Throwable cause) {
        super(cause);
        uuid = UUID.fromString(ExceptionUtil.lookupErrorCode(this.getMessage()) + "-" + this.getMessage());
        addInfo(ErrorConstants.ERROR_MESSAGE, this.getMessage());
        addInfo(ErrorConstants.ERROR_CODE, ExceptionUtil.lookupErrorCode(this.getMessage()));
    }

    public MetricsException(String message, Throwable cause) {
        super(message, cause);
        uuid = UUID.fromString(ExceptionUtil.lookupErrorCode(this.getMessage()) + "-" + this.getMessage());
        addInfo(ErrorConstants.ERROR_MESSAGE, this.getMessage());
        addInfo(ErrorConstants.ERROR_CODE, ExceptionUtil.lookupErrorCode(this.getMessage()));
    }

    public MetricsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        uuid = UUID.fromString(ExceptionUtil.lookupErrorCode(this.getMessage()) + "-" + this.getMessage());
        addInfo(ErrorConstants.ERROR_MESSAGE, this.getMessage());
        addInfo(ErrorConstants.ERROR_CODE, ExceptionUtil.lookupErrorCode(this.getMessage()));
    }

    public MetricsException(Integer errorCode) {
        super(ExceptionUtil.lookupMessage(errorCode));
        uuid = UUID.fromString(errorCode.toString() + "-" + ExceptionUtil.lookupMessage(errorCode));
        addInfo(ErrorConstants.ERROR_MESSAGE, ExceptionUtil.lookupMessage(errorCode));
        addInfo(ErrorConstants.ERROR_CODE, errorCode);
    }
    
    public MetricsException(Integer errorCode, Throwable cause) {
        super(ExceptionUtil.lookupMessage(errorCode), cause);
        uuid = UUID.fromString(errorCode.toString() + "-" + ExceptionUtil.lookupMessage(errorCode));
        addInfo(ErrorConstants.ERROR_MESSAGE, ExceptionUtil.lookupMessage(errorCode));
        addInfo(ErrorConstants.ERROR_CODE, errorCode);
    }

    public MetricsException addInfo(String key, Object value) {
        if (null == exceptionData) {
            exceptionData = new HashMap<String, Object>();
        }

        exceptionData.put(key, value);
        return this;
    }

    public String getMetricsKeyValuePairsAsJSON() {
        if (null == exceptionData || exceptionData.isEmpty()) {
            return null;
        }
        
        ObjectMapper mapper = (new ObjectMapper()).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        
        try {
            return mapper.writeValueAsString(exceptionData);
        } catch (JsonProcessingException e) {
            return "Unable to process exception data";
        }
    }

}
