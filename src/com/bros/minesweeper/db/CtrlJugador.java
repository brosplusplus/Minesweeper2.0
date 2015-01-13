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
	public Integer save(Jugador jugador) {
			Session session = PersistenceSessionFactory.getInstance().openSession();
			
			session.beginTransaction();
			Integer id = (Integer)session.save(jugador);
			session.save(jugador);
			session.getTransaction().commit();
			session.close();
			
			return id;
	} 
}

