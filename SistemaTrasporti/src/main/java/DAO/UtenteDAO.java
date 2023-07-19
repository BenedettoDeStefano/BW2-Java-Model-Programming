package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;

import Entities.Utente;

public class UtenteDAO {

	private final EntityManager em;
    private static Logger log = Logger.getLogger(UtenteDAO.class);

	public UtenteDAO(EntityManager em) {
		this.em = em;
	}
    
	public void salvaUtente(Utente utente) {
		EntityTransaction transaction = null;
		
		try {
			transaction = em.getTransaction();
			transaction.begin();
			
			em.persist(utente);
			
			transaction.commit();
			
			log.info("Utente salvato nel databse correttamente");
		}catch (Exception e){
			if (transaction != null) 
				transaction.rollback();
			
			log.error("Errore durante salvataggio di un Utente");
		}finally {
			if (em != null)
				em.close();
		}
	}
	
	public void updateUtente(Utente utente) {
		EntityTransaction transaction = null;
		
		try {
			transaction = em.getTransaction();
			transaction.begin();
			
			em.merge(utente);
			
			transaction.commit();
			
			log.info("Dati utente modificati nel databse correttamente");
		}catch (Exception e){
			if (transaction != null) 
				transaction.rollback();
			
			log.error("Errore durante la modifica dei dati di un utente");
		}finally {
			if (em != null)
				em.close();
		}
	}
	
	public void deleteUtente(Utente utente) {
		EntityTransaction transaction = null;
		
		try {
			transaction = em.getTransaction();
			transaction.begin();
			
			em.remove(utente);
			
			transaction.commit();
			
			log.info("Utente cancellato correttamente");
		}catch (Exception e){
			if (transaction != null) 
				transaction.rollback();
			
			log.error("Errore durante cancellazione di un utente");
		}finally {
			if (em != null)
				em.close();
		}
	}
	
	public List<Utente> getAllUtenti() {
		try {
			TypedQuery<Utente> query = em.createQuery("SELECT t FROM Utente t", Utente.class);
			log.info("Lista utenti recuperata correttamente");
			return query.getResultList();
		}catch (Exception e) {
			log.error("Errore durante il recupero della lista utenti");
			return new ArrayList<>();
		}
	}
	
	public Utente getUtenteById(Long id) {
		
		try {
			log.info("Utente trovato con id" + id);
			return em.find(Utente.class, id);
		}finally {
			em.close();
		}
	}
	
}
