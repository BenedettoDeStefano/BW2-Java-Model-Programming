package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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
}
