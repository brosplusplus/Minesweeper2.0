package com.bros.minesweeper.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.bros.minesweeper.db.CtrlNivell;
import com.bros.minesweeper.domain.controller.ConsultarNivellUseCaseController;
import com.bros.minesweeper.domain.controller.LoginUseCaseController;
import com.bros.minesweeper.domain.model.Nivell;
import com.bros.minesweeper.factory.FactoriaControladors;
import com.bros.minesweeper.utils.debug;

public class HibernateNivellTest {
	public static Nivell newNivell() {
		Scanner in = new Scanner(System.in);
		debug.outln("Hola, que vols fer?");
		debug.outln("1. Nou nivell\n2. Mostra Nivells");
		int accio = in.nextInt();
		Nivell nivell = new Nivell();
		CtrlNivell cn = FactoriaControladors.getCtrlNivell();
		if (accio == 1) {
			debug.outln("Nom:");
			nivell.setNom(in.nextLine());
			debug.outln("Files:");
			nivell.setNombreCasellesxColumna(in.nextInt());
			debug.outln("Columnes:");
			nivell.setNombreCasellesxFila(in.nextInt());
			debug.outln("Mines:");
			nivell.setNombreMines(in.nextInt());
			cn.save(nivell);
		}
		else {
			ConsultarNivellUseCaseController CNUCC = new ConsultarNivellUseCaseController();
			try {
				ArrayList<HashMap<String,String>> nivells = CNUCC.consultarNivells();
				debug.outln(nivell.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return nivell;
		
	}
}
