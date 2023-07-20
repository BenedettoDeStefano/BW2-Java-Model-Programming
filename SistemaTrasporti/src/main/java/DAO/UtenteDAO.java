package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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

			log.info("Utente salvato correttamente nel database, *è stato assegnato un numero di tessera*");
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();

			log.error("Errore durante salvataggio di un Utente");
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
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();

			log.error("Errore durante la modifica dei dati di un utente");
		} finally {
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
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();

			log.error("Errore durante cancellazione di un utente");
		} finally {
			if (em != null)
				em.close();
		}
	}

	public List<Utente> getAllUtenti() {
		try {
			TypedQuery<Utente> query = em.createQuery("SELECT t FROM Utente t", Utente.class);
			log.info("Lista utenti recuperata correttamente");
			return query.getResultList();
		} catch (Exception e) {
			log.error("Errore durante il recupero della lista utenti");
			return new ArrayList<>();
		}
	}

	public Utente getUtenteById(int id) {

		try {
			log.info("Utente trovato con id" + id);
			return em.find(Utente.class, id);
		} finally {
			em.close();
		}
	}

//	public Utente getUtenteCasuale() {
//		try {
//			// Esegui una query per ottenere tutti gli ID dei distributori presenti nel
//			// database
//			TypedQuery<Long> query = em.createQuery("SELECT d.id FROM Utente d", Long.class);
//			List<Long> utenteIds = query.getResultList();
//
//			// Genera un numero casuale tra 0 e la dimensione della lista degli ID
//			Random random = new Random();
//			int randomIndex = random.nextInt(utenteIds.size());
//
//			// Ottieni l'ID casuale dalla lista degli ID
//			Long utenteIdCasuale = utenteIds.get(randomIndex);
//
//			// Utilizza l'ID casuale per recuperare il distributore corrispondente dal
//			// database
//			return em.find(Utente.class, utenteIdCasuale);
//		} catch (Exception e) {
//			log.error("Errore durante il recupero dell'utente casuale: " + e.getMessage());
//			return null;
//		}
//	}

}
