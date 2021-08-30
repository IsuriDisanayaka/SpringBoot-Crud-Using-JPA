package com.wixis.springbootcrud.exception;

/**
 * @author : Isuri Disanayaka
 * @date:30/08/2021
 * @since : 0.0.1
 **/
public class ValidateException extends RuntimeException {
    public ValidateException(String message) {
        super(message);
    }
}
