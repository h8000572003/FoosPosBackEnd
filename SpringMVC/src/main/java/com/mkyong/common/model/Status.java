package com.mkyong.common.model;

public class Status {
	private String code = "";
	private String message = "";
	private Object content = "";

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	


	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public void fail() {
		final Status status = this;
		status.setCode("001");
		status.setMessage("未知");

	}

	public void fail(Exception e) {
		final Status status = this;
		status.setCode("001");
		status.setMessage(e.getMessage());

	}

	
	public void successful() {

		this.successful("作業成功");

		return;
	}


	public void successful(String message) {
		final Status status = this;
		status.setCode("000");
		status.setMessage(message);

	}
}
