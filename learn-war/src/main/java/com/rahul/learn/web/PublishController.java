package com.rahul.learn.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rahul.learn.domain.RequestMessage;
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
		String response = messageService.publishMessage(requestMessage);
		
		System.out.println("************************" + response);

		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
