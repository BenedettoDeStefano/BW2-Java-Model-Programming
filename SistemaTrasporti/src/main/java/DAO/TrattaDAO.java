package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;

import Entities.Tratta;

public class TrattaDAO {

	private final EntityManager em;
	private static Logger log = Logger.getLogger(TrattaDAO.class);

	public TrattaDAO(EntityManager em) {
		this.em = em;
	}

	public void saveTratta(Tratta tratta) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(tratta);

		t.commit();
		log.info("Tratta salvata correttamente");
	}

	public Tratta getTrattaById(Long id) {
		Tratta tratta = em.find(Tratta.class, id);
		if (tratta != null) {
			log.info("Tratta trovata correttamente" + tratta);
		} else {
			log.error("Tratta non trovata");
		}
		return tratta;
	}

	public List<Tratta> getAllTratte() {
		TypedQuery<Tratta> query = em.createQuery("SELECT t FROM Tratta t", Tratta.class);
		List<Tratta> tratte = query.getResultList();
		log.info("Lista di tutte le tratte presenti nel database: \n" + tratte);
		return tratte;
	}

	public void updateTratta(Tratta tratta) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.merge(tratta);

		t.commit();
		log.info("Tratta aggiornata correttamente");
	}

	public void deleteTratta(Tratta tratta) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.remove(tratta);

		t.commit();
		log.info("Tratta eliminata correttamente");
	}

	public List<Tratta> getTratteByZonaPartenzaAndCapolinea(String zonaPartenza, String capolinea) {
		TypedQuery<Tratta> query = em
				.createQuery("SELECT t FROM Tratta t WHERE t.zonaPartenza = :zonaPartenza AND t.capolinea = :capolinea",
						Tratta.class)
				.setParameter("zonaPartenza", zonaPartenza).setParameter("capolinea", capolinea);
		List<Tratta> tratte = query.getResultList();
		log.info("Lista delle tratte con zona di partenza " + zonaPartenza + " e capolinea " + capolinea + ": "
				+ tratte);
		return tratte;
	}

	public int getNumeroTratte() {
		TypedQuery<Long> query = em.createQuery("SELECT COUNT(t) FROM Tratta t", Long.class);
		Long count = query.getSingleResult();
		log.info("Numero totale di tratte nel database: " + count);
		return count.intValue();
	}

	public Tratta findTrattaByCodice(Long codiceTratta) {
		return em.find(Tratta.class, codiceTratta);
	}
}
