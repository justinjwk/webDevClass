/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rbevans;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author evansrb1
 */
public class TaskExecutorServer extends UnicastRemoteObject
  implements RemoteTaskExecutor {

    public static final String REGISTRY_NAME = TaskExecutorServer.class.getName();    
    public TaskExecutorServer() throws RemoteException {
        super();
    }

    public Object executeTask(Task task, Serializable argument) {
        return task.execute(argument);
    }
    
    public static void main(String[] args) throws Exception {
        int registryPortNumber = 1099;

        // Start RMI registry
        LocateRegistry.createRegistry(registryPortNumber);

        Naming.rebind(REGISTRY_NAME, new TaskExecutorServer());
        System.out.println("Server running...");
    }    
}
