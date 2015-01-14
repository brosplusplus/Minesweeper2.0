package com.bros.minesweeper.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.bros.minesweeper.datainterface.ICtrlCasella;
import com.bros.minesweeper.datainterface.ICtrlPartida;
import com.bros.minesweeper.domain.model.Casella;
import com.bros.minesweeper.domain.model.Partida;
import com.bros.minesweeper.factory.FactoriaControladors;

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
		
		partida.setIdPartida(id);
		session.getTransaction().commit();
		session.close();
		
		return id;
	}
	
	@Override
	public void update(Partida partida) {
		Session session = PersistenceSessionFactory.getInstance().openSession();
		
		session.beginTransaction();
		session.update(partida);
		session.getTransaction().commit();
		
		ICtrlCasella cc = FactoriaControladors.getCtrlCasella();
		List<Casella> tau = partida.getTaulell();
		for (Casella c : tau) {
			cc.update(c);
		}
	}

}
