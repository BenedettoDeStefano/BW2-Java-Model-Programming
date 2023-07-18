package DAO;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

public class DistributoreAutomaticoDAO {
	
	private final EntityManager em;
    private static Logger log = Logger.getLogger(DistributoreAutomaticoDAO.class);

    public DistributoreAutomaticoDAO(EntityManager em) {
        this.em = em;
    }

}
