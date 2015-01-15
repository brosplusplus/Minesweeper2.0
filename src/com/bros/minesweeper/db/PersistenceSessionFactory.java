package com.bros.minesweeper.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/*
 * Creadora de sessions de la capa de persistència automàtica.
 * De manera aproximada, es podria considerar aquesta classe interioritzada en l'element
 * que al disseny apareix com a Persistence Generator.
 */
public class PersistenceSessionFactory {
	
	private static PersistenceSessionFactory persistenceSessionFactory = null;
	
	private Configuration configuration = null;
	private StandardServiceRegistryBuilder serviceRegistryBuilder = null;
	private ServiceRegistry serviceRegistry = null;
	private SessionFactory sessionFactory = null;
	private Session s = null;
	
	/**
	 * Creadora de PersistenceSessionFactory
	 */
	private PersistenceSessionFactory() {
		this.configuration=new Configuration().configure();
		this.serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		this.serviceRegistryBuilder.applySettings(configuration.getProperties());
		this.serviceRegistry = serviceRegistryBuilder.build();
		this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	/**
	 * Obtenim una instancia de PersistenceSessionFactory
	 */
	public static PersistenceSessionFactory getInstance() {
		if (persistenceSessionFactory == null) {
			persistenceSessionFactory = new PersistenceSessionFactory();
		}
		return persistenceSessionFactory;
	}
	
	/**
	 * Obrim una nova Sessio.
	 */
	public Session openSession() {
		if (s == null) {
			s = sessionFactory.openSession();
		} else {
			if (!s.isOpen()) {
				s = sessionFactory.openSession();
			}
		}
		return s;
	}
	
	/**
	 * Tanquem la sessió.
	 */
	public void closeSession() {
		s.close();
	}
	
}
