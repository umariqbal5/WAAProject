package com.exam.waaproject.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ValidationErrorDTO {

    private String errorType;

    private List<FieldErrorDTO> fieldErrors = new ArrayList<>();

    public void addFieldError(String field, String message){
        fieldErrors.add(new FieldErrorDTO(field, message));
    }
}
