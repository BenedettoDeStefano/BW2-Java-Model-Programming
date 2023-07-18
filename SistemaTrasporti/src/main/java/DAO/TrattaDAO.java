package DAO;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

public class TrattaDAO {
	
	private final EntityManager em;
    private static Logger log = Logger.getLogger(TrattaDAO.class);

    public TrattaDAO(EntityManager em) {
        this.em = em;
    }

}
