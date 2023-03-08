package com.practice.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

import com.practice.pojo.Employee;

@Component
public class RestRoute extends RouteBuilder {
	
 	
		
	 
  @Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
	 
	  from("direct:restRoute")
		.routeId("restRoute")		
		.unmarshal(new JacksonDataFormat(Employee.class)) 
		.setHeader(Exchange.HTTP_METHOD, constant("GET"))
		.process(e->{
			Employee emp = e.getIn().getBody(Employee.class);
			e.getIn().setBody(emp.getEmployeeName());
		})		 
	    .toD("http://localhost:8080/insert?name=${body}");
	}
  
  
  
   
}
