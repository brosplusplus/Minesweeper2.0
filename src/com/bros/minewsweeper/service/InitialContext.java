package com.bros.minewsweeper.service;

import org.apache.axis2.AxisFault;

import com.bros.services.mailer.MailSender;

public class InitialContext {
	   public Object lookup(String jndiName) throws AxisFault{
	      if(jndiName.equalsIgnoreCase("BrosSendMailService")){
	         System.out.println("Looking up and creating a new Service1 object");
	         return new MailSender();
	      }
	      return null;
	   }
}
