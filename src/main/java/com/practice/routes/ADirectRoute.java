package com.practice.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.pojo.Employee;

@Component
public class ADirectRoute extends RouteBuilder {

	
	@Autowired
	DoSomethingA doSomething;
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("direct:A")
		.routeId("ADirectRoute")
		//can call backend here and parse the response
		.unmarshal(new JacksonDataFormat(Employee.class))
		.process(doSomething)		
		.marshal().json() 
		//.to("stream:out")
		.end();   //marks the multicast as successful

	}
	
}
