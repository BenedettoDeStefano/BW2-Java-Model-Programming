package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import Entities.RivenditoreAutorizzato;

public class RivenditoreAutorizzatoDAO {

    private final EntityManager em;
    private static Logger log = Logger.getLogger(RivenditoreAutorizzatoDAO.class);

    public RivenditoreAutorizzatoDAO(EntityManager em) {
        this.em = em;
    }

    public void saveRivenditoreAutorizzato(RivenditoreAutorizzato rivenditore) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(rivenditore);
            transaction.commit();
            log.info("Rivenditore autorizzato salvato con successo.");
        } catch (Exception e) {
            log.error("Errore durante il salvataggio del rivenditore autorizzato: " + e.getMessage());
            transaction.rollback();
        }
    }

    public RivenditoreAutorizzato getRivenditoreAutorizzatoById(int id) {
        try {
            return em.find(RivenditoreAutorizzato.class, id);
        } catch (Exception e) {
            log.error("Errore durante il recupero del rivenditore autorizzato con ID " + id + ": " + e.getMessage());
            return null;
        }
    }

    public List<RivenditoreAutorizzato> getAllRivenditoriAutorizzati() {
        try {
            Query query = em.createQuery("SELECT r FROM RivenditoreAutorizzato r", RivenditoreAutorizzato.class);
            List<RivenditoreAutorizzato> rivenditoriAutorizzati = query.getResultList();
            for (RivenditoreAutorizzato rivenditore : rivenditoriAutorizzati) {
                log.info(rivenditore.toString());
            }
            return rivenditoriAutorizzati;
        } catch (Exception e) {
            log.error("Errore durante il recupero di tutti i rivenditori autorizzati: " + e.getMessage());
            return null;
        }
    }

    public void updateRivenditoreAutorizzato(RivenditoreAutorizzato rivenditore) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(rivenditore);
            transaction.commit();
            log.info("Rivenditore autorizzato aggiornato con successo.");
        } catch (Exception e) {
            log.error("Errore durante l'aggiornamento del rivenditore autorizzato: " + e.getMessage());
            transaction.rollback();
        }
    }

    public void deleteRivenditoreAutorizzato(RivenditoreAutorizzato rivenditore) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(rivenditore);
            transaction.commit();
            log.info("Rivenditore autorizzato eliminato con successo.");
        } catch (Exception e) {
            log.error("Errore durante l'eliminazione del rivenditore autorizzato: " + e.getMessage());
            transaction.rollback();
        }
    }
}
