package org.csbs.configurationservice.exception;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Status {
    private Boolean success;
    private String message;
    private List<Error> errors;

    public List<Error> getErrors() {
        return errors;
    }
    
    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

}
