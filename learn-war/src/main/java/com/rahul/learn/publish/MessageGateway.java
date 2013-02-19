package com.rahul.learn.publish;

import java.util.UUID;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.support.RabbitGatewaySupport;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.rahul.learn.domain.RequestMessage;

public class MessageGateway extends RabbitGatewaySupport {
	@Qualifier("rabbitTemplate")
	@Autowired
	RabbitTemplate rabbitTemplate;

	private String exchange;

	@Autowired
	MessageConverter jsonMessageConverter;
	
	@Qualifier("policyReplyQueue")
	@Autowired
	Queue replyQueue;

	public void publishMessage(RequestMessage requestMessage) {
		rabbitTemplate.setExchange(exchange);
		rabbitTemplate.setMessageConverter(jsonMessageConverter);
		rabbitTemplate.setQueue("policyQueue");
		rabbitTemplate.setRoutingKey("api.policy.data.publish.create");
		rabbitTemplate.setReplyQueue(replyQueue);

		CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
		rabbitTemplate.convertAndSend(exchange, "api.policy.data.publish.create", requestMessage, new MessagePostProcessor() {

			@Override
			public Message postProcessMessage(Message message) throws AmqpException {
				String correlationId = UUID.randomUUID().toString();
				message.getMessageProperties().setCorrelationId(correlationId.getBytes());
				message.getMessageProperties().setReplyTo("policyReplyQueue");
				
				message.getMessageProperties().setHeader(RabbitTemplate.STACKED_CORRELATION_HEADER, correlationId);
				
				return message;
			}
		}, correlationData);
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

}
