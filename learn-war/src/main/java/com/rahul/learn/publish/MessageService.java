package com.rahul.learn.publish;

import com.rahul.learn.domain.RequestMessage;

/**
 * Quick notes. Return type should be a string, as the response received from the other end is a json.
 * @author rahulkj
 * 
 */
public interface MessageService {
	public String publishMessage(RequestMessage requestMessage);
}
