package com.bros.minesweeper.db;

import org.hibernate.Session;

import com.bros.minesweeper.datainterface.ICtrlUsuariRegistrat;
import com.bros.minesweeper.domain.model.UsuariRegistrat;

/**
 * Controlador de la persistencia de la clase UsuariRegistrat.
 * @author alaxmo13
 *
 */
public class CtrlUsuariRegistrat implements ICtrlUsuariRegistrat {

	/**
	 * Obtenim l'usuariRegistrat amb username username.
	 */
	public UsuariRegistrat get(String username) {
		Session session = PersistenceSessionFactory.getInstance().openSession();
		
		UsuariRegistrat user = (UsuariRegistrat)session.get(UsuariRegistrat.class, username);
		
		return user;
	}

	/**
	 * Guardem l'usuariRegistrat usuariRegistrat a la base de dades
	 */
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