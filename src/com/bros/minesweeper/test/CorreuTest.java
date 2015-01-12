package com.bros.minesweeper.test;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.apache.ws.axis2.SenderAddressExceptionException;
import org.apache.ws.axis2.SenderMessagingExceptionException;

import com.bros.minesweeper.domain.factory.AdaptadorType;
import com.bros.minesweeper.domain.factory.FactoriaAdaptadorCorreu;

public class CorreuTest {
	public static void main (String[] args)
	{
		try {
			FactoriaAdaptadorCorreu.getAdaptadorCorreu(AdaptadorType.OWN)
				.sendMessage("borja.arias.upc@gmail.com", "PROVA2", "HOLAAA");
		} catch (RemoteException
				| SenderMessagingExceptionException
				| SenderAddressExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
