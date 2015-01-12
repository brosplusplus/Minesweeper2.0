package com.bros.minesweeper.adapter;

import java.rmi.RemoteException;

import com.bros.minewsweeper.service.ServiceLocator;
import com.bros.services.mailer.MailSender;
import com.bros.services.mailer.MailSender.MailSenderAddressException;
import com.bros.services.mailer.MailSender.MailSenderMessagingException;
import com.bros.services.mailer.MailSender.SendMail;
import com.bros.services.mailer.MailSenderAddressExceptionException;
import com.bros.services.mailer.MailSenderMessagingExceptionException;

public class AdaptadorCorreuPropi implements IAdaptadorCorreu{

	@Override
	public void sendMessage(String dest, String subj, String msg) throws RemoteException, MailSenderAddressExceptionException, MailSenderMessagingExceptionException{
		MailSender stub = new MailSender();
		SendMail send = new SendMail();
		send.setDestination(dest);
		send.setSubject(subj);
		send.setBody(msg);
		stub.sendMail(send);
	}
	
}
