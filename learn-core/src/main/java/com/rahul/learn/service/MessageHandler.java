package com.rahul.learn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rahul.learn.domain.RequestMessage;
import com.rahul.learn.domain.ResponseMessage;

public class MessageHandler {
	
	private static Logger logger = LoggerFactory.getLogger(MessageHandler.class);
	
	public ResponseMessage handleRequest(RequestMessage requestMessage) {
		String msg = "Ah ha... finally you are here .. welcome home " + requestMessage.getMessage();
		logger.info(msg);
		
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setMessage(msg);
		responseMessage.setRequestId(requestMessage.getRequestId());
		return responseMessage;
	}

}
