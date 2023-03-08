package com.practice.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.practice.pojo.Employee;

@Component
public class DoSomethingA implements Processor {
	
	@Override
	public void process(Exchange exchange) throws Exception {
       Employee oscar=exchange.getIn().getBody(Employee.class);
       oscar.setShift("MORNING");   
       oscar.setaRouteMessage("ERROR");
       exchange.getIn().setBody(oscar); 
       Thread.sleep(500);
	}

}
