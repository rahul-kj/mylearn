package com.rahul.learn.web;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rahul.learn.domain.RequestMessage;
import com.rahul.learn.publish.MessageGateway;

@Controller
@RequestMapping("/publish")
public class PublishController {

	@Autowired
	MessageGateway messageGateway;
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Object publishMessage(@RequestBody RequestMessage requestMessage) {
		requestMessage.setRequestId(UUID.randomUUID().toString());
		messageGateway.publishMessage(requestMessage);

		return new ResponseEntity<String>("You sent the message " + requestMessage.getMessage(), HttpStatus.OK);
	}
}
