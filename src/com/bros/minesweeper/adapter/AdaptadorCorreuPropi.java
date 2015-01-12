package com.bros.minesweeper.adapter;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.apache.ws.axis2.SenderAddressExceptionException;
import org.apache.ws.axis2.SenderMessagingExceptionException;
import org.apache.ws.axis2.SenderStub;
import org.apache.ws.axis2.SenderStub.SendMail;

public class AdaptadorCorreuPropi implements IAdaptadorCorreu{

	@Override
	public void sendMessage(String dest, String subj, String msg) throws RemoteException, SenderMessagingExceptionException, SenderAddressExceptionException {
		SenderStub stub = new SenderStub();
		SendMail send = new SendMail();
		send.setDest(dest);
		send.setSubj(subj);
		send.setBody(msg);
		stub.sendMail(send);
	}
	
}
