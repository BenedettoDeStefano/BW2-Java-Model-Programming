package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;

import Entities.Officina;
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
		} catch (Exception e) {
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
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();

			log.error("Errore durante la modifica della tessera!");
		} finally {
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
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();

			log.error("Errore durante cancellazione della tessera!");
		} finally {
			if (em != null)
				em.close();
		}
	}
	
	
	public List<Tessera> getAllTessere() {
        TypedQuery<Tessera> query = em.createQuery("SELECT DISTINCT t FROM Tessera t",
                Tessera.class);
        List<Tessera> tessere = query.getResultList();
        log.info("Lista di tutte le Officine presenti nel database: \n" + tessere);
        return tessere;
    }

	public Tessera getTesseraById(long l) {
		try {
			log.info("Tessera trovata con id" + l);
			return em.find(Tessera.class, l);
		} catch (Exception e) {
			log.error("Errore durante il recupero della tessera con id: " + l, e);
			return null;
		}

	}
}
