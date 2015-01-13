package com.bros.minesweeper.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.bros.minesweeper.db.PersistenceSessionFactory;
import com.bros.minesweeper.domain.model.Casella;
import com.bros.minesweeper.domain.model.Partida;

public class CasellaTest {
	public static void main (String[] args) {
		Session session = PersistenceSessionFactory.getInstance().openSession();
		session.beginTransaction();
		Partida p = new Partida();
		Casella c = new Casella(1,1,p);
		session.save(p);
		session.save(c);
		session.getTransaction().commit();
	}
}
