package com.practice.pojo;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDoSomething implements Processor {
	
	@Override
	public void process(Exchange exchange) throws Exception {
       Employee oscar=exchange.getIn().getBody(Employee.class);
       oscar.setShift("MORNING");       
       exchange.getIn().setBody(oscar);
	}

}
