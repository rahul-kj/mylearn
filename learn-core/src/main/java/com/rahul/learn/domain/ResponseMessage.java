package com.rahul.learn.domain;

import java.io.Serializable;

public class ResponseMessage implements Serializable {

	private static final long serialVersionUID = 8104860642085310260L;

	private String requestId;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

}
