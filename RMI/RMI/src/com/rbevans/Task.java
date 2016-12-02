/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rbevans;

import java.io.Serializable;

/**
 *
 * @author evansrb1
 */
public interface Task extends Serializable {
  public Object execute(Object argument);
}