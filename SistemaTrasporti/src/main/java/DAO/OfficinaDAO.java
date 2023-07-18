package DAO;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

public class OfficinaDAO {
	
	private final EntityManager em;
    private static Logger log = Logger.getLogger(OfficinaDAO.class);

    public OfficinaDAO(EntityManager em) {
        this.em = em;
    }

}
