package com.bros.minesweeper.utils;

import java.net.ServerSocket;
import java.sql.SQLException;

import com.bros.minesweeper.datainterface.ICtrlAdministrador;
import com.bros.minesweeper.datainterface.ICtrlNivell;
import com.bros.minesweeper.domain.model.Administrador;
import com.bros.minesweeper.domain.model.Nivell;
import com.bros.minesweeper.factory.FactoriaControladors;

public class DerbyDB {
	private static String derbyBin = "cmd /c E:/workspace/Minesweeper2.0/derbydb/bin/";
	private static String start = "startNetworkServer";
	private static String stop = "stopNetworkServer";
	private static String winExtens = ".bat";
	private static String OS;
	
	static {
		OS = System.getProperty("os.name").toLowerCase();
	}
	
	private static Process executeFile(String file){
		try {
			Process p = Runtime.getRuntime().exec(file);
			return p;
		}
		catch (Exception e) {
			debug.err(e.getMessage());
		}
		return null;
	}
	
	private static Boolean checkPort(Integer port){
		try {
			ServerSocket checkPort = new ServerSocket(port);
			checkPort.close();
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static Process startDerbyDB () {
		Boolean availablePort = checkPort(1527);
		Process p = null;
		if (availablePort && OS.contains("win")) {
			p = executeFile(derbyBin+start+winExtens);
		}
		else if (availablePort) {
			p = executeFile(derbyBin+start);
		}
		return p;
	}
	
	public static void stopDerbyDB() {
		if (OS.contains("win")) {
			executeFile(derbyBin+stop+winExtens);
		}
		else {
			executeFile(derbyBin+stop);
		}
	}

	public static void initialConfig() {
		ICtrlNivell cN = FactoriaControladors.getCtrlNivell();
		ICtrlAdministrador cA = FactoriaControladors.getCtrlAdministrador();
		try {
			if (cN.getAll().isEmpty()){
				cN.save(new Nivell("Facil",9,9,10));
				cN.save(new Nivell("Mitja",16,16,40));
				cN.save(new Nivell("Dificil",30,30,160));
			}
			if (cA.get("Brospp") == null) {
				Administrador admin = new Administrador();
				admin.setNom("Bros");
				admin.setCognom("PlusPlus");
				admin.setUsername("Brospp");
				admin.setPwd("brospluspluspass");
				admin.setTlfn("609759147");
				cA.save(admin);
			}
		}
		catch (SQLException e) {
			debug.err(e.getMessage());
		}
	}
	
	public static void main(String args[]) {
		DerbyDB.startDerbyDB();
	}
}
