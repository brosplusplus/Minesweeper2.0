package com.bros.minesweeper.test;

import java.util.Scanner;

import com.bros.minesweeper.db.CtrlAdministrador;
import com.bros.minesweeper.domain.controller.LoginUseCaseController;
import com.bros.minesweeper.domain.model.Administrador;
import com.bros.minesweeper.factory.FactoriaControladors;
import com.bros.minesweeper.utils.debug;

public class HibernateAdministradorTest {
	
	@SuppressWarnings("resource")
	public static Administrador newAdministrador() {
		Scanner in = new Scanner(System.in);
		debug.outln("Machete, anem a fer un admin no fos cas que fessis trampes ;)");
		debug.outln("1. Nou administrador\n2. Carregar administrador (si fas això ets un hacker de pwds)");
		int accio = Integer.parseInt(in.nextLine());
		Administrador admin = null;
		CtrlAdministrador ca = FactoriaControladors.getCtrlAdministrador();
		if (accio == 1) {
			admin = new Administrador();
			debug.outln("Nom:");
			admin.setNom(in.nextLine());
			debug.outln("Cognom:");
			admin.setCognom(in.nextLine());
			debug.outln("Username:");
			admin.setUsername(in.nextLine());
			debug.outln("Password:");
			admin.setPwd(in.nextLine());
			debug.outln("Telefon:");
			admin.setTlfn(in.nextLine());
			ca.save(admin);
		}
		else {
			debug.outln("Nom d'usuari:");
			String username = in.nextLine();
			LoginUseCaseController lucc = new LoginUseCaseController();
			while (admin == null) {
				debug.outln("Contrasenya:");
				String pwd = in.nextLine();
				try {
					lucc.login(username, pwd);
					admin = ca.get(username);
				}
				catch (Exception e) {
					debug.err(e.getMessage());
				}
			}			
		}
		return admin;
		
	}
}
