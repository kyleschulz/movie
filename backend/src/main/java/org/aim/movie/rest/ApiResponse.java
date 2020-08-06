package org.aim.movie.rest;

import java.util.List;

public class ApiResponse<T> {
    private List<ErrorMessage> errors;
    private T response;

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public List<ErrorMessage> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorMessage> errors) {
        this.errors = errors;
    }


}