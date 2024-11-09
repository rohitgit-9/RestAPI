package com.user;

public class NoSuchUserException extends RuntimeException {
	String msg;

	public NoSuchUserException() {

	}

	public NoSuchUserException(String message) {
		super(message);
		this.msg = message;

	}
}
