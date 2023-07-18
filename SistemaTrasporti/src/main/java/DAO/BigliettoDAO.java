package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.jboss.logging.Logger;

import Entities.Biglietto;


public class BigliettoDAO {
	
	private final EntityManager em;
    private static Logger log = Logger.getLogger(BigliettoDAO.class);

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }
    
    public void emettiBiglietto(Biglietto biglietto) {
    	EntityTransaction t = em.getTransaction();
        t.begin();

        em.persist(biglietto);

        t.commit();
        log.info("Biglietto emesso correttamente");
     }
    
    public List<Biglietto> acquisisciNumeroBigliettiVidimati() {
        List<Biglietto> bigliettiVidimati = em.createQuery("SELECT b FROM Biglietto b WHERE b.vidimato = true", Biglietto.class)
              .getResultList();
        log.info("Numero biglietti vidimati: " + bigliettiVidimati.size());
        return bigliettiVidimati;
     }

     public void vidimaBiglietto(Biglietto biglietto) {
    	 if (!biglietto.getVidimato()) {
    		 biglietto.setVidimato(true);
    		 em.merge(biglietto);
    		 log.info("Biglietto vidimato correttamente");
    	 } else {
    		 log.info("Biglietto già vidimato in precedenza");
    	 }
        
     }

}
