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
		.unmarshal(new JacksonDataFormat(Employee.class))
		.process(doSomething)		
		.marshal().json()
		//.log("AAAAAAAAAAA here")
		.to("stream:out")
		.end();
		//.log("--------------------------------------------------------");
		 //.unmarshal(new JacksonDataFormat(Employee.class))		 
		// .bean(emp,"toString()")
		//.to("stream:out");
		 
	}
	
}
