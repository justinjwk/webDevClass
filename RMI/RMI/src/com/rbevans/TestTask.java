/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rbevans;

import java.rmi.Naming;

/**
 *
 * @author evansrb1
 */
public class TestTask implements Task {

    public Object execute(Object argument) {
        System.out.println("Executing task for " + argument);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        // Do nothing.
        }
        System.out.println("Executed task for " + argument);
        return argument;
    }

    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int portNumber = 1099;
        String lookupName = "//" + host + ":" + portNumber + "/" +
 
              TaskExecutorServer.REGISTRY_NAME;
        RemoteTaskExecutor executor = (RemoteTaskExecutor)Naming.lookup(lookupName);

        System.out.println("Requesting task execution for Bob");
        Object result = executor.executeTask(new TestTask(), "Bob");
        System.out.println("Task executed for " + result);
  }    
}
