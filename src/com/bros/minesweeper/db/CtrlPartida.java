package com.bros.minesweeper.db;

import org.hibernate.Session;

import com.bros.minesweeper.datainterface.ICtrlPartida;
import com.bros.minesweeper.domain.model.Partida;

public class CtrlPartida implements ICtrlPartida{

	@Override
	public Partida get(Integer idPartida) {
		// TODO Auto-generated method stub
		Session session = PersistenceSessionFactory.getInstance().openSession();
		
		Partida partida = (Partida) session.get(Partida.class, idPartida);
		
		return partida;
	}

	@Override
	public Integer save(Partida partida) {
		Session session = PersistenceSessionFactory.getInstance().openSession();
		
		session.beginTransaction();
		Integer id = (Integer)session.save(partida);
		session.getTransaction().commit();
		session.close();		
		
		partida.setIdPartida(id);
		
		return id;
	}

}
