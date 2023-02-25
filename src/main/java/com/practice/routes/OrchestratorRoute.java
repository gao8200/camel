package com.practice.routes;

 
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.strategy.EmployeeAggregation;


@Component
public class OrchestratorRoute extends RouteBuilder {

		
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		from("direct:orchestrate")
		.routeId("OrchestratorRoute")
		.log("--------------------------------------------------------")
		 //.unmarshal(new JacksonDataFormat(Employee.class))		 
		// .bean(emp,"toString()")
		.multicast(new EmployeeAggregation()).parallelProcessing() //don't inject
		 .to("direct:A")	 		 
		 .to("direct:C")
		 .to("direct:B")		 
		.end()
		.to("stream:out");
		//.to("rabbitmq:rabbit-express?queue=rabbit-project&autoDelete=false");
		 
	} 
	
}

 