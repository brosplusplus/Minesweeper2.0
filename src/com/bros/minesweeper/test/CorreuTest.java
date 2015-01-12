package com.bros.minesweeper.test;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.apache.ws.axis2.SenderAddressExceptionException;
import org.apache.ws.axis2.SenderMessagingExceptionException;

import com.bros.minesweeper.factory.AdaptadorType;
import com.bros.minesweeper.factory.FactoriaAdaptadorCorreu;

public class CorreuTest {
	public static void main (String[] args)
	{
		try {
			FactoriaAdaptadorCorreu.getAdaptadorCorreu(AdaptadorType.OWN)
				.sendMessage("kaspmr@hotmail.com", "PROVA2", "HOLAAA");
		} catch (RemoteException
				| SenderMessagingExceptionException
				| SenderAddressExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
