package com.practice.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.pojo.Employee;

@Component
public class BDirectRoute extends RouteBuilder {
	
	
	@Autowired
	DoSomethingB doSomething;
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("direct:B")
		.routeId("BDirectRoute")
		.unmarshal(new JacksonDataFormat(Employee.class))
		.process(doSomething)		
		.marshal().json()
		//.log("BBBBBBBBBBBBB here")
		.to("stream:out")
		.end();
		//.toD();
		// .bean(emp,"toString()")
		//.to("direct:orchestrate");
		 
	}
	
}
