/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jkim;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Justin
 */
@WebService(serviceName = "RateCalculatorWS")
public class RateCalculatorWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "calculateRate")
    public double calculateRate(@WebParam(name = "numParty") int numParty, @WebParam(name = "duration") int duration, @WebParam(name = "rate") double rate) {
        //TODO write your implementation code here:
        return rate * numParty * duration;
    }
    
    
}
