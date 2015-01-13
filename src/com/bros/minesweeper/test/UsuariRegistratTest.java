package com.bros.minesweeper.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.bros.minesweeper.domain.model.Jugador;

public class UsuariRegistratTest {
	
	public static void main (String[] args) {
		AnnotationConfiguration conf = new AnnotationConfiguration();
		conf.configure("hibernate.cfg.xml");
		//new SchemaExport(conf).create(true, true);
		SessionFactory sessionfact = conf.buildSessionFactory();
		Session session = sessionfact.getCurrentSession();
		
		
//		List<Administrador> l = session.createSQLQuery("select * from test.ADMINISTRADOR a,"
//				+ " test.USUARIREGISTRAT u where u.username = :username")
//				.addEntity("com.bros.minesweeper.domain.model.Administrador")
//				.list();
//		for (int i = 0; i < l.size(); i++)
//		{
//			Administrador ad = l.get(i);
//			System.out.println(ad.getUsername());
//		}
		session.beginTransaction();
		Jugador u = new Jugador();
		u.setNom("Brojs");
		u.setEmail("email.@email.com");
		u.setUsername("nueddvwqfqso user");
		session.save(u);
		session.getTransaction().commit();
	}
}
