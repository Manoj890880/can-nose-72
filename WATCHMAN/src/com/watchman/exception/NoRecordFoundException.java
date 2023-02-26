package com.watchman.exception;

public class NoRecordFoundException extends Exception{
	public NoRecordFoundException(String msg) {
		super(msg);
	}
	@Override
	
	public String toString() {
		return getMessage();
	}
}
