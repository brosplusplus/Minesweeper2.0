package com.bros.minesweeper.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.bros.minesweeper.domain.model.Casella;
import com.bros.minesweeper.domain.model.Partida;

public class CasellaTest {
	public static void main (String[] args) {
		AnnotationConfiguration conf = new AnnotationConfiguration();
		conf.addAnnotatedClass(Casella.class);
		conf.configure("hibernate.cfg.xml");
		new SchemaExport(conf).create(true, true);
		SessionFactory sessionfact = conf.buildSessionFactory();
		Session session = sessionfact.getCurrentSession();
		session.beginTransaction();
		Casella c = new Casella();
		c.setNumeroColumna(1);
		c.setNumeroFila(2);
		Partida p = new Partida();
		c.setPartida(p);
		session.save(p);
		session.save(c);
		session.getTransaction().commit();
		session.close();
	}
}
