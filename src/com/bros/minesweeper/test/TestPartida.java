package com.bros.minesweeper.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.bros.minesweeper.domain.model.Nivell;
import com.bros.minesweeper.domain.model.Partida;


public class TestPartida {

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Partida.class);
		config.addAnnotatedClass(Nivell.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Nivell lvl = new Nivell();
		lvl.setNom("intermedi");
		lvl.setNombreCasellesxColumna(18);
		lvl.setNombreCasellesxFila(18);
		lvl.setNombreMines(40);
		
		Partida p1 = new Partida();
		Partida p2 = new Partida();
		p1.setNombreTirades(0);
		p2.setNombreTirades(0);
		p1.setTeNivell(lvl);
		p2.setTeNivell(lvl);
		
		
		session.save(lvl);
		session.save(p1);
		session.save(p2);
		session.getTransaction().commit();
		
	}

}
