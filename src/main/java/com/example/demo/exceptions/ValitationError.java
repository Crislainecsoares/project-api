package com.example.demo.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValitationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();

    public ValitationError() {
        super();
    }

    public ValitationError(long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public List< FieldMessage > getErrors() {
        return errors;
    }

    public void addErrors(String fieldName, String message) {
        this.errors.add(new FieldMessage(fieldName, message));
    }

}
