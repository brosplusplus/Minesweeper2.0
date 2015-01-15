/**
 * 
 */
package com.bros.minesweeper.test;

import org.hibernate.Query;
import org.hibernate.Session;

import com.bros.minesweeper.db.PersistenceSessionFactory;
import com.bros.minesweeper.domain.model.Administrador;
import com.bros.minesweeper.domain.model.Jugador;
import com.bros.minesweeper.domain.model.Nivell;
import com.bros.minesweeper.utils.debug;

/**
 * @author Borja Arias
 */
public class GeneralHibernateTest {
	
	public static int hqlTruncate(String myTable){
		Session session = PersistenceSessionFactory.getInstance().openSession();
		session.beginTransaction();
	    String hql = String.format("delete from %s",myTable);
	    Query query = session.createQuery(hql);
	    query.executeUpdate();
	    session.getTransaction().commit();
	    session.close();
	    return 0;
	}
	
	public static void main (String[] args) {
		Jugador jug = HibernateJugadorTest.newJugador();
		if (jug != null) 
			debug.outln("Creat el jugador: "+jug.getUsername());
		else
			debug.err("Error en crear el jugador");
//		Nivell niv = HibernateNivellTest.newNivell();
//		if (niv != null)
//			debug.outln("Creat el Nivell: "+niv.getNom());
//		else
//			debug.err("Error en crear el Nivell");
//		Administrador admin = HibernateAdministradorTest.newAdministrador();
//		if (admin != null)
//			debug.outln("Creat el Administrador: "+admin.getUsername());
//		else
//			debug.err("Error en crear Administrador");
//		GeneralHibernateTest.hqlTruncate("Casella");
//		Partida part = HibernatePartidaTest.newPartida();
//		if (part != null)
//			debug.outln("Creada la Partida amb IdPartida: "+part.getIdPartida());
//		else
//			debug.err("Error en crear Partida");
//		
//		debug.outln("Si hem arribat fins aqu� es que res a petat xD");
	}
}
