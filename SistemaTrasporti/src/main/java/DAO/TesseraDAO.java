package DAO;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

public class TesseraDAO {
	
	private final EntityManager em;
    private static Logger log = Logger.getLogger(TesseraDAO.class);

    public TesseraDAO(EntityManager em) {
        this.em = em;
    }

}
