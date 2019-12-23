package com.concatel.restful.exceptions;

public class InvalidRebelException extends Exception{
	public InvalidRebelException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRebelException(String message) {
        super(message);
    }
}