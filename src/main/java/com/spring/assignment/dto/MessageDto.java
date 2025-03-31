package com.spring.assignment.dto;

import org.springframework.stereotype.Component;

@Component
public class MessageDto {

	private String body;
	private int statusCode;

	public MessageDto() {
		super();
	}

	public MessageDto(String body, int statusCode) {
		super();
		this.body = body;
		this.statusCode = statusCode;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
