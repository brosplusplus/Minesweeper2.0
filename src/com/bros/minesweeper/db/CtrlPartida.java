package com.bros.minesweeper.db;

import java.util.List;

import org.hibernate.Session;

import com.bros.minesweeper.datainterface.ICtrlCasella;
import com.bros.minesweeper.datainterface.ICtrlPartida;
import com.bros.minesweeper.domain.model.Casella;
import com.bros.minesweeper.domain.model.Partida;
import com.bros.minesweeper.factory.FactoriaControladors;

/**
 * Controlador de la persistencia de la clase Partida
 * @author Alex More
 *
 */
public class CtrlPartida implements ICtrlPartida{

	/**
	 * Obtenim la partida amb idPartida.
	 */
	@Override
	public Partida get(Integer idPartida) {
		// TODO Auto-generated method stub
		Session session = PersistenceSessionFactory.getInstance().openSession();
		
		Partida partida = (Partida) session.get(Partida.class, idPartida);
		
		return partida;
	}

	/**
	 * Guardem la Partida partida a la base de dades.
	 */
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
	
	/**
	 * Actualitzem la Partida partida a la base de dades.
	 */
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
