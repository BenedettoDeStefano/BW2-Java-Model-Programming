package DAO;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

public class UtenteDAO {

	private final EntityManager em;
    private static Logger log = Logger.getLogger(UtenteDAO.class);

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }
	
}
