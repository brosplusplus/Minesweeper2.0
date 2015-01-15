package com.bros.minesweeper.db;

import org.hibernate.Session;

import com.bros.minesweeper.datainterface.ICtrlAdministrador;
import com.bros.minesweeper.domain.model.Administrador;


/**
 * Controlador de la persistencia de la clase Administrador
 * @author Alex More
 *
 */
public class CtrlAdministrador implements ICtrlAdministrador{
	/**
	 * Obtenim l'administrador "username", retorna null en cas de no trobar-lo.
	 */
	@Override
	public Administrador get(String username) {
		Session session = PersistenceSessionFactory.getInstance().openSession();
		
		Administrador administrador = (Administrador)session.get(Administrador.class,username);
		session.close();
		
		return administrador;
	}

	/**
	 * Guardem l'Adminisrador administrador a la base de dades.
	 */
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
