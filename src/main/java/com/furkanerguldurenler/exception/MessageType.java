package com.furkanerguldurenler.exception;

import lombok.Getter;

@Getter
public enum MessageType {

	NO_RECORD_EXIST("1001", "no records found"), GENERAL_EXCEPTION("9999", "general exception");

	private String code;
	private String message;

	private MessageType(String code, String message) {
		this.code = code;
		this.message = message;
	}

}
