package org.csbs.configurationservice.exception;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiErrorResponse {
    private List<String> details;
    @JsonIgnore
    @ToString.Exclude
    private HttpStatus httpStatus;
    private Status status;

    public static final List<HttpStatus> RETRYABLE_CODES = Collections
            .unmodifiableList(Arrays.asList(HttpStatus.SERVICE_UNAVAILABLE, HttpStatus.BAD_GATEWAY,
                    HttpStatus.GATEWAY_TIMEOUT, HttpStatus.INSUFFICIENT_STORAGE, HttpStatus.BANDWIDTH_LIMIT_EXCEEDED));

    /**
     * Exists only to support deserialization; do NOT invoke from application code!
     */
    ApiErrorResponse() {
    }
    
    private ApiErrorResponse(HttpStatus httpStatus, IResultCode resultCode, Throwable t)
}
