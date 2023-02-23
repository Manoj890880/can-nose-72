package com.watchman.exception;

public class SomeThingWrongException extends Exception{
	@Override
	public String toString() {
		return "Something Went Wrong , Please try again later";
	}
}
