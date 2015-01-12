package com.bros.minesweeper.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class MSession {
	public static org.hibernate.SessionFactory getDefaultFactorySession(Class[] classes) {
		AnnotationConfiguration conf = new AnnotationConfiguration();
		conf.configure();
		new SchemaExport(conf).create(true,true);
		return conf.buildSessionFactory();
	}
}
