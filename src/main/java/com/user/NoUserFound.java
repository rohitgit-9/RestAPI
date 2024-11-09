package com.user;

public class NoUserFound extends RuntimeException {

	private String message;

	public NoUserFound() {

	}

	public NoUserFound(String msg) {
		super(msg);
		this.message = msg;
	}

}
