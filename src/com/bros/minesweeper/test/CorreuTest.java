package com.bros.minesweeper.test;

import java.rmi.RemoteException;

import com.bros.minesweeper.factory.AdaptadorType;
import com.bros.minesweeper.factory.FactoriaAdaptadorCorreu;
import com.bros.services.mailer.MailSenderAddressExceptionException;
import com.bros.services.mailer.MailSenderMessagingExceptionException;

public class CorreuTest {
	public static void main (String[] args)
	{
		try {
			FactoriaAdaptadorCorreu.getAdaptadorCorreu(AdaptadorType.OWN)
				.sendMessage("kaspmr@hotmail.com", "PROVA2", "HOLAAA");
		} catch (RemoteException
				| MailSenderMessagingExceptionException
				| MailSenderAddressExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
