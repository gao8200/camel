package com.practice.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.pojo.EmployeeDoSomething;

@Component
public class RabbitMQRoute extends RouteBuilder {
	
	
	@Autowired
	EmployeeDoSomething doSomething;

	@Override
	public void configure() throws Exception {
	 
		from("rabbitmq:rabbit-express?queue=rabbit-employee&autoDelete=false")
		.routeId("RECEIVE")
	
		/*
		.log("--------------------------------------------------------")
		.to("stream:out")
		 .unmarshal(new JacksonDataFormat(Employee.class)) //maps json stream to employee
		 .process(doSomething) // do something with the Employee object
		 .to("stream:out")
		 .log("--------------------------------------------------------")
		.marshal().json() //converts to json stream
		 .to("direct:update-employee");
		 */
		
		.to("direct:orchestrate");
		
	}
	
}
