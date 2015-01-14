package com.bros.minesweeper.db;

import org.hibernate.Session;

import com.bros.minesweeper.datainterface.ICtrlAdministrador;
import com.bros.minesweeper.domain.model.Administrador;


/**
 * Accedim a la informacio dels administradors que conte la base de dades
 * 
 * @author Alex More
 *
 */
public class CtrlAdministrador implements ICtrlAdministrador{
	@Override
	public Administrador get(String username) {
		Session session = PersistenceSessionFactory.getInstance().openSession();
		
		Administrador administrador = (Administrador)session.get(Administrador.class,username);
		session.close();
		
		return administrador;
	}

	@Override
	public String save(Administrador administrador) {
			Session session = PersistenceSessionFactory.getInstance().openSession();
			
			session.beginTransaction();
			String id = (String)session.save(administrador);
			session.save(administrador);
			session.getTransaction().commit();
			session.close();
			
			return id;
	} 
}
