package com.naverblog.dawndevelopers.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ResponseTemplate<T> {
    private Code code = Code.OK;
    private T data;
    private String message;

    @Builder
    public ResponseTemplate(Code code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public ResponseTemplate<T> success() {
        return new ResponseTemplate<>(Code.OK);
    }

    public ResponseTemplate<T> success(String message) {
        return new ResponseTemplate<>(message);
    }

    public ResponseTemplate<T> success(T data) {
        return new ResponseTemplate<>(data);
    }

    public ResponseTemplate<T> success(T data, String message) {
        return new ResponseTemplate<>(data, message);
    }

    public ResponseTemplate<T> fail() {
        return new ResponseTemplate<>(Code.FAIL);
    }

    public ResponseTemplate<T> fail(String message) {
        return new ResponseTemplate<>(message);
    }

    public ResponseTemplate(Code code) {
        this.code = code;
    }

    public ResponseTemplate(T data) {
        this.data = data;
    }

    public ResponseTemplate(String message) {
        this.message = message;
    }

    public ResponseTemplate(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public enum Code {
        OK, FAIL
    }
}
