package com.bros.minesweeper.db;

import org.hibernate.Session;

import com.bros.minesweeper.datainterface.ICtrlJugador;
import com.bros.minesweeper.domain.model.Jugador;

/**
 * Controlador de la persistencia de la clase Jugador
 * @author Alex More
 *
 */
public class CtrlJugador implements ICtrlJugador {

	/**
	 * Funcio per saber si existeix o no el jugador amb el username userN.
	 */
	public boolean exists(String userN) {
		return get(userN) != null;
	}
	
	/**
	 * Obtenim el Jugador amb username username.
	 */
	@Override
	public Jugador get(String username) {
		Session session = PersistenceSessionFactory.getInstance().openSession();
		
		Jugador jugador = (Jugador)session.get(Jugador.class,username);
		session.close();
		
		return jugador;
	}

	/**
	 * Guardem el Jugador jugador a la base de dades.
	 */
	@Override
	public String save(Jugador jugador) throws Exception {
			Session session = PersistenceSessionFactory.getInstance().openSession();
			
			session.beginTransaction();
			try {
				Jugador jug = (Jugador)session.get(Jugador.class,jugador.getUsername());
				session.persist(jug);
				jug.setCognom(jugador.getCognom());
				jug.setEmail(jugador.getEmail());
				jug.setNom(jugador.getNom());
				jug.setPwd(jugador.getPwd());
			}
			catch (Exception e) {
				session.save(jugador);
			}
			
			session.getTransaction().commit();
			session.close();
			
			return jugador.getUsername();
	} 
}

