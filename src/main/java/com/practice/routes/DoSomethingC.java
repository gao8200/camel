package com.practice.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.practice.pojo.Employee;

@Component
public class DoSomethingC implements Processor {
	
	@Override
	public void process(Exchange exchange) throws Exception {
		
       Employee oscar=exchange.getIn().getBody(Employee.class);
       oscar.setShift("MORNING");      
       oscar.setcRouteMessage("FATAL");
       exchange.getIn().setBody(oscar);
       System.out.println("CCCCCCCCCCC Exchange: "+exchange.getExchangeId());
       
	}

}
