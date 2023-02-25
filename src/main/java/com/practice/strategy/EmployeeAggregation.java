package com.practice.strategy;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.practice.pojo.Employee;

@Component
public class EmployeeAggregation implements AggregationStrategy {

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange;
        }
        
        // get the json string
        String oldBody = oldExchange.getIn().getBody(String.class);
        String newBody = newExchange.getIn().getBody(String.class);
        
      //  System.out.println("OLD: "+oldBody);
       // System.out.println("NEW: "+newBody);
        
        // transform json string to POJO
        Gson gson = new GsonBuilder().create();        
        Employee oldE = gson.fromJson(oldBody, Employee.class);                
        Employee newE = gson.fromJson(newBody, Employee.class);
        
        // set only when  empty
        oldE.setaRouteMessage(newE.getaRouteMessage());
        oldE.setbRouteMessage(newE.getbRouteMessage());
        oldE.setcRouteMessage(newE.getcRouteMessage());
        
        //transformback to JSON
        String newJson = gson.toJson(oldE);
        oldExchange.getIn().setBody(newJson);
        return oldExchange;
    }
    
 
}