package DAO;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;

import Entities.DistributoreAutomatico;

public class DistributoreAutomaticoDAO {

	private final EntityManager em;
	private static Logger log = Logger.getLogger(DistributoreAutomaticoDAO.class);

	public DistributoreAutomaticoDAO(EntityManager em) {
		this.em = em;
	}

	public void saveDistributoreAutomatico(DistributoreAutomatico distributore) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(distributore);
			transaction.commit();
			log.info("Distributore automatico salvato con successo.");
		} catch (Exception e) {
			log.error("Errore durante il salvataggio del distributore automatico: " + e.getMessage());
			transaction.rollback();
		}
	}

	public DistributoreAutomatico getDistributoreAutomaticoById(Long id) {
		try {
			return em.find(DistributoreAutomatico.class, id);
		} catch (Exception e) {
			log.error("Errore durante il recupero del distributore automatico con ID " + id + ": " + e.getMessage());
			return null;
		}
	}

	public List<DistributoreAutomatico> getAllDistributoriAutomatici() {
		try {
			Query query = em.createQuery("SELECT d FROM DistributoreAutomatico d", DistributoreAutomatico.class);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Errore durante il recupero di tutti i distributori automatici: " + e.getMessage());
			return null;
		}
	}

	public void updateDistributoreAutomatico(DistributoreAutomatico distributore) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.merge(distributore);
			transaction.commit();
			log.info("Distributore automatico aggiornato con successo.");
		} catch (Exception e) {
			log.error("Errore durante l'aggiornamento del distributore automatico: " + e.getMessage());
			transaction.rollback();
		}
	}

	public void deleteDistributoreAutomatico(DistributoreAutomatico distributore) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.remove(distributore);
			transaction.commit();
			log.info("Distributore automatico eliminato con successo.");
		} catch (Exception e) {
			log.error("Errore durante l'eliminazione del distributore automatico: " + e.getMessage());
			transaction.rollback();
		}
	}

	public DistributoreAutomatico getDistributoreAutomaticoCasuale() {
		try {
			// Esegui una query per ottenere tutti gli ID dei distributori presenti nel
			// database
			TypedQuery<Long> query = em.createQuery("SELECT d.id FROM DistributoreAutomatico d", Long.class);
			List<Long> distributoriIds = query.getResultList();

			// Genera un numero casuale tra 0 e la dimensione della lista degli ID
			Random random = new Random();
			int randomIndex = random.nextInt(distributoriIds.size());

			// Ottieni l'ID casuale dalla lista degli ID
			Long distributoreIdCasuale = distributoriIds.get(randomIndex);

			// Utilizza l'ID casuale per recuperare il distributore corrispondente dal
			// database
			return em.find(DistributoreAutomatico.class, distributoreIdCasuale);
		} catch (Exception e) {
			log.error("Errore durante il recupero del distributore automatico casuale: " + e.getMessage());
			return null;
		}
	}

}
