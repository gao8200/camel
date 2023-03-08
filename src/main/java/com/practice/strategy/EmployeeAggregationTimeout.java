package com.practice.strategy;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.practice.common.NameVariables;
import com.practice.pojo.Employee;

@Component
public class EmployeeAggregationTimeout implements AggregationStrategy  {

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange;
        }
        
        // get the json string
        String oldBody = oldExchange.getIn().getBody(String.class);
        String newBody = newExchange.getIn().getBody(String.class);
        
       System.out.println("OldBody: "+oldBody + "  ----  NewBody: "+newBody);
        
        // transform json string to POJO
        Gson gson = new GsonBuilder().create();        
        Employee oldE = gson.fromJson(oldBody, Employee.class);                
        Employee newE = gson.fromJson(newBody, Employee.class);
        
        if (oldE == null)
          return oldExchange;
        
        // set only when  empty
        oldE.setaRouteMessage(newE.getaRouteMessage());
        oldE.setbRouteMessage(newE.getbRouteMessage());
        oldE.setcRouteMessage(newE.getcRouteMessage());
        
        //transformback to JSON
        String newJson = gson.toJson(oldE);
        oldExchange.getIn().setBody(newJson);
        return oldExchange;
    }
    
    @Override
    public void timeout(Exchange exchange, int index, int total, long timeout) {
    	// TODO Auto-generated method stub
    	switch(index){
    		case NameVariables.DIRECT_A :
    			 System.out.println("Timeout on AADirectRoute");
    			 break;
    		case NameVariables.DIRECT_B :
    			System.out.println("Timeout on BBDirectRoute");
    			 break;
    		case NameVariables.DIRECT_C :
    			System.out.println("Timeout on CCDirectRoute");
    			 break;
    	}
    //	System.out.println(exchange.getException().getMessage());
    	AggregationStrategy.super.timeout(exchange, index, total, timeout);
    }
 
}