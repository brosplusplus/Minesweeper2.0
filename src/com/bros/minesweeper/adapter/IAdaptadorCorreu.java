package com.bros.minesweeper.adapter;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

public interface IAdaptadorCorreu {
	
	public void sendMessage(String dest, String subj, String msg) throws AxisFault, RemoteException, com.bros.services.mailer.MailSenderAddressExceptionException, com.bros.services.mailer.MailSenderMessagingExceptionException;
	
}
