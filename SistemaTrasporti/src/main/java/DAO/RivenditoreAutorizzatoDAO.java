package DAO;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

public class RivenditoreAutorizzatoDAO {
	
	private final EntityManager em;
    private static Logger log = Logger.getLogger(RivenditoreAutorizzatoDAO.class);

    public RivenditoreAutorizzatoDAO(EntityManager em) {
        this.em = em;
    }


}
