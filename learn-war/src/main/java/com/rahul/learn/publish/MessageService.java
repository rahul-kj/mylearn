package com.rahul.learn.publish;

import com.rahul.learn.domain.RequestMessage;
import com.rahul.learn.domain.ResponseMessage;

/**
 * Quick notes. Return type should be a string, as the response received from the other end is a json.
 * @author rahulkj
 * 
 */
public interface MessageService {
	public ResponseMessage publishMessage(RequestMessage requestMessage);
}
