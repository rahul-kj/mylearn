package com.rahul.learn.domain;

import java.io.Serializable;
import java.util.UUID;

public class RequestMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7127688995728374773L;

	private String requestId;
	private String message;
	private String id = UUID.randomUUID().toString();

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
