package com.practice.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.pojo.Employee;

@Component
public class RabbitMQRouteUpdate extends RouteBuilder {

	@Autowired
	Employee emp;
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("direct:update-employee")
		.routeId("END")
		.log("--------------------------------------------------------")
		 //.unmarshal(new JacksonDataFormat(Employee.class))		 
		// .bean(emp,"toString()")
		.to("stream:out");
		 
	}
	
}
