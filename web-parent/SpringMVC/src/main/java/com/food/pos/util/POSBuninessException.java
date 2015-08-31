package com.food.pos.util;

public class POSBuninessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message = "";

	public POSBuninessException(Exception e) {
		this.message = e.getMessage();
	}

	public POSBuninessException(String message, Exception e) {
		this.message = message + ":" + e.getMessage();
	}

	public POSBuninessException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
