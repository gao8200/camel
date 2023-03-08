package com.practice.routes;

 
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.practice.strategy.EmployeeAggregationTimeout;


@Component
public class OrchestratorRoute extends RouteBuilder {

		
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		from("direct:orchestrate") 	
		 //mark the end of onException block		   		   		
	  	 .routeId("OrchestratorRoute")
	  	 .log("Orchestrator")
		 .multicast(new EmployeeAggregationTimeout())
		   /*** index returns what endpoint is timing out */
		   //.to("direct:A","direct:C","direct:B") // -- index: 2 directB timeouts
		   //.to("direct:B","direct:C","direct:A") // -- index: 0 directB timeouts
		   //.to("direct:C","direct:B","direct:A") // -- index: 1 directB timeouts
		   .to("direct:A","direct:B","direct:C","direct:restRoute") // -- index: 1 directB timeouts		 
		   .parallelProcessing()
		   .timeout(1000)		   
		.end()		
		.process(e -> {
		  e.getMessage().removeHeader("CamelRabbitmqRoutingKey");//remove this header so we can redirect
		})		  
		.to("rabbitmq:rabbit-express?queue=rabbit-project&autoDelete=false&routingKey=project")
		.to("stream:out");
		 
	} 
	
}

 
/*
.onException(ExchangeTimedOutException.class)
.id("myException")
.handled(true)
.process(e->{
	  System.out.println("onException "+e.getException());  
 })
.end()
*/