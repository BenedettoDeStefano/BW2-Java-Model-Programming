package DAO;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

import Entities.Mezzo;
import Enum.StatoMezzo;

public class MezzoDAO {
	
	private final EntityManager em;
    private static Logger log = Logger.getLogger(MezzoDAO.class);

    public MezzoDAO(EntityManager em) {
        this.em = em;
    }

    public void registraMezzoInServizio(Mezzo mezzo) {
    	if(mezzo.getStato() == StatoMezzo.IN_SERVIZIO) {
    		log.info("il mezzo è in servizio");
    	} else {
    		mezzo.setStato(StatoMezzo.IN_SERVIZIO);
    		em.merge(mezzo);
    		log.info("il mezzo è appena rientrato in servizio");
    	}
   
     }

     public void registraMezzoInManutenzione(Mezzo mezzo) {
    	 if(mezzo.getStato() == StatoMezzo.IN_MANUTENZIONE) {
     		log.info("il mezzo è in manutenzione");
     	} else {
     		mezzo.setStato(StatoMezzo.IN_MANUTENZIONE);
     		em.merge(mezzo);
     		log.info("il mezzo è stato registrato come in manutenzione");
     	}
     }

}
