package com.bros.minesweeper.db;

import org.hibernate.Session;

import com.bros.minesweeper.datainterface.ICtrlJugador;
import com.bros.minesweeper.domain.model.Jugador;

public class CtrlJugador implements ICtrlJugador {

	public boolean exists(String userN) {
		return get(userN) != null;
	}
	
	@Override
	public Jugador get(String username) {
		Session session = PersistenceSessionFactory.getInstance().openSession();
		
		Jugador jugador = (Jugador)session.get(Jugador.class,username);
		session.close();
		
		return jugador;
	}

	@Override
	public String save(Jugador jugador) throws Exception {
			Session session = PersistenceSessionFactory.getInstance().openSession();
			
			session.beginTransaction();
			Jugador jug = (Jugador)session.get(Jugador.class,jugador.getUsername());
			session.persist(jug);
			jug.setCognom(jugador.getCognom());
			jug.setEmail(jugador.getEmail());
			jug.setNom(jugador.getNom());
			jug.setPwd(jugador.getPwd());
			session.getTransaction().commit();
			session.close();
			
			return jug.getUsername();
	} 
}

