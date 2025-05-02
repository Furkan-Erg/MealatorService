package com.furkanerguldurenler.handler;

import java.util.Date;

import lombok.Data;

@Data
public class Exception<E> {
	
	private Date createTime;
	
	private E message;
	
}
