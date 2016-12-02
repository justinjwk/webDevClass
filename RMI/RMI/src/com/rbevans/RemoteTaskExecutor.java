/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rbevans;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author evansrb1
 */
public interface RemoteTaskExecutor extends Remote {
    public Object executeTask(Task task, Serializable argument) throws RemoteException;
}
