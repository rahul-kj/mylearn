package com.rahul.learn.publish;

import java.util.Map;

import org.springframework.integration.annotation.Headers;
import org.springframework.integration.annotation.Payload;

import com.rahul.learn.domain.RequestMessage;
import com.rahul.learn.domain.ResponseMessage;

/**
 * Quick notes. Return type should be a string, as the response received from the other end is a json.
 * @author rahulkj
 * 
 */
public interface MessageService {
	String ROUTING_KEY = "routing.key";
	
	public ResponseMessage publishMessage(@Headers Map<String, String> headers,@Payload RequestMessage requestMessage);
}
