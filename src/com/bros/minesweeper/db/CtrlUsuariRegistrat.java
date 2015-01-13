package com.bros.minesweeper.db;

import java.sql.Connection;
import java.sql.Statement;

import org.hibernate.Session;

import com.bros.minesweeper.datainterface.ICtrlUsuariRegistrat;
import com.bros.minesweeper.domain.model.Jugador;
import com.bros.minesweeper.domain.model.UsuariRegistrat;
import com.bros.minesweeper.factory.FactoriaControladors;
import com.bros.minesweeper.utils.debug;

public class CtrlUsuariRegistrat implements ICtrlUsuariRegistrat {

	private static String tableName = "USUARIREGISTRAT";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
	
	public UsuariRegistrat get(String username) {
		Session session = PersistenceSessionFactory.getInstance().openSession();
		
		UsuariRegistrat user = (UsuariRegistrat)session.get(UsuariRegistrat.class, username);
		
		return user;
	}

	@Override
	public String save(UsuariRegistrat usuariRegistrat) {
		Session session = PersistenceSessionFactory.getInstance().openSession();
		
		session.beginTransaction();
		String id = (String)session.save(usuariRegistrat);
		session.getTransaction().commit();
		session.close();		
		
		return id;
	}

	
	public static void main (String[] args) {
		ICtrlUsuariRegistrat ctrlUsuari = FactoriaControladors.getCtrlUsuariRegistrat();
		
		UsuariRegistrat user = new Jugador();
		user.setUsername("Paco");
		user.setNom("Paco");
		user.setCognom("Franco");
		user.setPwd("pacopaco");
		
		ctrlUsuari.save(user);
		
		user = ctrlUsuari.get("Paco");
		
		if (user != null) 
			debug.outln("S'ha trobat un Paco al sistema: "+user.getNom()+" "+user.getCognom());
		else
			debug.outln("No s'ha trobat cap Paco al sistema");
		
	}
}