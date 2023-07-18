package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import Entities.Biglietto;


public class BigliettoDAO {
	
	private final EntityManager em;
    private static Logger log = Logger.getLogger(BigliettoDAO.class);

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }
    
    
    // Emissione Biglietto
    public void emettiBiglietto(Biglietto biglietto) {
    	EntityTransaction t = em.getTransaction();
    	try {
            t.begin();
            em.persist(biglietto);
            t.commit();
            log.info("Biglietto emesso correttamente");
        } catch (Exception e) {
            t.rollback();
            log.error("Errore durante l'emissione del biglietto", e);
        }
    }
     
    // Numero biglietti vidimati
    public List<Biglietto> acquisisciNumeroBigliettiVidimati() {
        List<Biglietto> bigliettiVidimati = em.createQuery("SELECT b FROM Biglietto b WHERE b.vidimato = true", Biglietto.class)
              .getResultList();
        log.info("Numero biglietti vidimati: " + bigliettiVidimati.size());
        return bigliettiVidimati;
     }
    
    // Vidima biglietto
     public void vidimaBiglietto(Biglietto biglietto) {
    	 if (!biglietto.getVidimato()) {
    		 biglietto.setVidimato(true);
    		 em.merge(biglietto);
    		 log.info("Biglietto vidimato correttamente");
    	 } else {
    		 log.info("Biglietto già vidimato in precedenza");
    	 }
        
     }
     
     // Cerca biglietto con id
     public Biglietto getBigliettoById(Long id) {
    	    try {
    	        Biglietto biglietto = em.find(Biglietto.class, id);
    	        if (biglietto != null) {
    	            log.info("Biglietto trovato con ID " + id);
    	        }
    	        return biglietto;
    	    } catch (Exception e) {
    	        log.error("Errore durante la ricerca del biglietto con ID " + id, e);
    	        return null;
    	    }
    	}
     
     // COntrolla tutti i biglietti
     public List<Biglietto> getAllBiglietti() {
         Query query = em.createQuery("SELECT b FROM Biglietto b");
         return query.getResultList();
     }
     
     // Aggiorna biglietto
     public void updateBiglietto(Biglietto biglietto) {
    	 EntityTransaction t = em.getTransaction();
         try {
             t.begin();
             em.merge(biglietto);
             t.commit();
             log.info("Biglietto aggiornato correttamente");
         } catch (Exception e) {
             t.rollback();
             log.error("Errore durante l'aggiornamento del biglietto", e);
         }
     }
     
     // Elimina biglietto
     public void deleteBiglietto(Biglietto biglietto) {
    	 EntityTransaction t = em.getTransaction();
         try {
             t.begin();
             em.remove(biglietto);
             t.commit();
             log.info("Biglietto eliminato correttamente");
         } catch (Exception e) {
             t.rollback();
             log.error("Errore durante l'eliminazione del biglietto", e);
         }
     }

}
