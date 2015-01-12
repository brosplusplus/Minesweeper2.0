package com.bros.minesweeper.adapter;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.apache.ws.axis2.SenderAddressExceptionException;
import org.apache.ws.axis2.SenderMessagingExceptionException;

public interface IAdaptadorCorreu {
	
	public void sendMessage(String dest, String subj, String msg) throws AxisFault, RemoteException, SenderMessagingExceptionException, SenderAddressExceptionException;
	
}
