package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;

import Entities.Tessera;

public class TesseraDAO {
	
	private EntityManager em;
	private static Logger log = Logger.getLogger(TesseraDAO.class);
	
	public TesseraDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salvaTessera(Tessera tessera) {
		EntityTransaction transaction = null;
		
		try {
			transaction = em.getTransaction();
			transaction.begin();
			
			em.persist(tessera);
			
			transaction.commit();
			
			log.info("Tessera salvata nel database correttamente");
		}catch (Exception e){
			if (transaction != null) 
				transaction.rollback();
			
			log.error("Errore durante salvataggio della tessera!");
		}
	}
	
	public void updateTessera(Tessera tessera) {
		EntityTransaction transaction = null;
		
		try {
			transaction = em.getTransaction();
			transaction.begin();
			
			em.merge(tessera);
			
			transaction.commit();
			
			log.info("Tessera modificata nel database correttamente");
		}catch (Exception e){
			if (transaction != null) 
				transaction.rollback();
			
			log.error("Errore durante la modifica della tessera!");
		}finally {
			if (em != null)
				em.close();
		}
	}
	
	public void deleteTessera(Tessera tessera) {
		EntityTransaction transaction = null;
		
		try {
			transaction = em.getTransaction();
			transaction.begin();
			
			em.remove(tessera);
			
			transaction.commit();
			
			log.info("Tessera cancellata correttamente");
		}catch (Exception e){
			if (transaction != null) 
				transaction.rollback();
			
			log.error("Errore durante cancellazione della tessera!");
		}finally {
			if (em != null)
				em.close();
		}
	}
	
	public List<Tessera> getAllTessere() {
		try {
			TypedQuery<Tessera> query = em.createQuery("SELECT t FROM Tessera t", Tessera.class);
			return query.getResultList();
		}catch (Exception e) {
			log.error("Errore durante il recupero di lista tessere");
			return new ArrayList<>();
		}
	}
	
	public Tessera getTesseraById(Long id) {
	    try {
	        log.info("Tessera trovata con id" + id);
	        return em.find(Tessera.class, id);
	    } catch (Exception e) {
	        log.error("Errore durante il recupero della tessera con id: " + id, e);
	        return null; 
	    }
	
	}
}
