package DAO;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.jboss.logging.Logger;

import Entities.Abbonamento;

public class AbbonamentoDAO {

	private final EntityManager em;
    private static Logger log = Logger.getLogger(AbbonamentoDAO.class);

    public AbbonamentoDAO(EntityManager em) {
        this.em = em;
    }
    
    public void emettiAbbonamento(Abbonamento abbonamento) {
    	EntityTransaction t = em.getTransaction();
        t.begin();

        em.persist(abbonamento);

        t.commit();
        log.info("Abbonamento emesso correttamente");
     }

     public boolean verificaValiditaAbbonamento(String numeroTessera) {
        Long count = em.createQuery("SELECT COUNT(a) FROM Abbonamento a WHERE a.tessera.numeroTessera = :numeroTessera AND a.dataScadenza >= CURRENT_DATE", Long.class)
              .setParameter("numeroTessera", numeroTessera)
              .getSingleResult();
        if(count > 0) {
             log.info("Abbonamento valido");
             return true;
        } else {
        	  log.info("Abbonamento non valido");
        	  return false;
        }

     }
	
}
