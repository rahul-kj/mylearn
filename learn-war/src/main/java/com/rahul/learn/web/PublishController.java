package com.rahul.learn.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rahul.learn.domain.RequestMessage;
import com.rahul.learn.domain.ResponseMessage;
import com.rahul.learn.publish.MessageService;

@Controller
@RequestMapping("/publish")
public class PublishController {

	@Autowired
	MessageService messageService;
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Object publishMessage(@RequestBody RequestMessage requestMessage) {
		requestMessage.setKey("api.policy.data.test");
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put(MessageService.ROUTING_KEY, "publish.message");
		
		ResponseMessage responseMessage = messageService.publishMessage(headers, requestMessage);
		
		System.out.println("************************" + responseMessage.getMessage());

		return new ResponseEntity<String>(responseMessage.getMessage(), HttpStatus.OK);
	}
}
