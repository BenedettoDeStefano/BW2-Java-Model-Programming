package DAO;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;

import Entities.Mezzo;
import Entities.Tratta;
import Enum.StatoMezzo;
import Enum.TipoMezzo;

public class MezzoDAO {
	private final EntityManager em;
	private static Logger log = Logger.getLogger(MezzoDAO.class);

	public MezzoDAO(EntityManager em) {
		this.em = em;
	}

	public void saveMezzo(Mezzo mezzo) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(mezzo);

		t.commit();
		log.info("Mezzo salvato correttamente");
	}

	public Mezzo getMezzoById(int id) {
		Mezzo mezzo = em.find(Mezzo.class, id);
		if (mezzo != null) {
			log.info("Mezzo trovato correttamente: " + mezzo);
		} else {
			log.error("Mezzo non trovato");
		}
		return mezzo;
	}

	public List<Mezzo> getAllMezzi() {
		TypedQuery<Mezzo> query = em.createQuery("SELECT DISTINCT m FROM Mezzo m LEFT JOIN FETCH m.trattePercorse",
				Mezzo.class);
		List<Mezzo> mezzi = query.getResultList();
		log.info("Lista di tutti i mezzi presenti nel database: " + mezzi);
		return mezzi;
	}

	public void updateMezzo(Mezzo mezzo) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.merge(mezzo);

		t.commit();
		log.info("Mezzo aggiornato correttamente");
	}

	public void deleteMezzo(Mezzo mezzo) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.remove(em.contains(mezzo) ? mezzo : em.merge(mezzo));

		t.commit();
		log.info("Mezzo eliminato correttamente");
	}

	public List<Mezzo> getMezziByTipo(TipoMezzo tipo) {
		TypedQuery<Mezzo> query = em.createQuery("SELECT m FROM Mezzo m WHERE m.tipo = :tipo", Mezzo.class);
		query.setParameter("tipo", tipo);
		List<Mezzo> mezzi = query.getResultList();
		log.info("Lista di mezzi filtrata per tipo: " + mezzi);
		return mezzi;
	}

	public List<Mezzo> getMezziByStato(StatoMezzo stato) {
		TypedQuery<Mezzo> query = em.createQuery("SELECT m FROM Mezzo m WHERE m.stato = :stato", Mezzo.class);
		query.setParameter("stato", stato);
		List<Mezzo> mezzi = query.getResultList();
		log.info("Lista di mezzi filtrata per stato: " + mezzi);
		return mezzi;
	}

	public List<Mezzo> getMezziByTratta(Tratta tratta) {
		TypedQuery<Mezzo> query = em.createQuery("SELECT m FROM Mezzo m WHERE m.tratta = :tratta", Mezzo.class);
		query.setParameter("tratta", tratta);
		List<Mezzo> mezzi = query.getResultList();
		log.info("Lista di mezzi filtrata per tratta: " + mezzi);
		return mezzi;
	}

	public List<Mezzo> getMezziInServizio() {
		TypedQuery<Mezzo> query = em.createQuery("SELECT m FROM Mezzo m WHERE m.stato = :stato", Mezzo.class);
		query.setParameter("stato", StatoMezzo.IN_SERVIZIO);
		List<Mezzo> mezzi = query.getResultList();
		log.info("Lista di mezzi in servizio: " + mezzi);
		return mezzi;
	}

	public List<Mezzo> getMezziInManutenzione() {
		TypedQuery<Mezzo> query = em.createQuery("SELECT m FROM Mezzo m WHERE m.stato = :stato", Mezzo.class);
		query.setParameter("stato", StatoMezzo.IN_MANUTENZIONE);
		List<Mezzo> mezzi = query.getResultList();
		log.info("Lista di mezzi in manutenzione: " + mezzi);
		return mezzi;
	}

	public Mezzo findMezzoByCodice(Long codiceMezzo) {
		return em.find(Mezzo.class, codiceMezzo);
	}

	public Mezzo getMezzoCasuale() {
		try {
			// Esegui una query per ottenere tutti gli ID dei distributori presenti nel
			// database
			TypedQuery<Long> query = em.createQuery("SELECT d.id FROM Mezzo d", Long.class);
			List<Long> mezzoIds = query.getResultList();

			// Genera un numero casuale tra 0 e la dimensione della lista degli ID
			Random random = new Random();
			int randomIndex = random.nextInt(mezzoIds.size());

			// Ottieni l'ID casuale dalla lista degli ID
			Long mezzoIdCasuale = mezzoIds.get(randomIndex);

			// Utilizza l'ID casuale per recuperare il distributore corrispondente dal
			// database
			return em.find(Mezzo.class, mezzoIdCasuale);
		} catch (Exception e) {
			log.error("Errore durante il recupero del mezzo casuale: " + e.getMessage());
			return null;
		}
	}
}
