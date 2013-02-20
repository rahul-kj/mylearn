package com.rahul.learn.domain;

import java.io.Serializable;

public class RequestMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7127688995728374773L;

	private String key;
	private String message;
	private String id;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
