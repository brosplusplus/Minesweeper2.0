package com.bros.minesweeper.service;

import org.apache.axis2.AxisFault;

public class ServiceLocator {

	   public static Object getService(String jndiName) throws AxisFault{
	      InitialContext context = new InitialContext();
	      Object service = context.lookup(jndiName);
	      return service;
	   }
}
