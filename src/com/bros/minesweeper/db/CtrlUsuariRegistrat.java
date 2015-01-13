package com.bros.minesweeper.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Session;

import com.bros.minesweeper.datainterface.ICtrlUsuariRegistrat;
import com.bros.minesweeper.domain.model.Partida;
import com.bros.minesweeper.domain.model.UsuariRegistrat;

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

}