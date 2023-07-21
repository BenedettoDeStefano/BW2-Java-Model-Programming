package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;

import Entities.Officina;

public class OfficinaDAO {
	
	private final EntityManager em;
    private static Logger log = Logger.getLogger(OfficinaDAO.class);

    public OfficinaDAO(EntityManager em) {
        this.em = em;
    }
    
    // Salva Officina
    public void saveOfficina(Officina officina) {
        em.getTransaction().begin();
        
        em.persist(officina);
        
        em.getTransaction().commit();
        log.info("Officina salvata correttamente");
    }
    
    // Cerca officina id
    public Officina getOfficinaById(Long id) {
        try {
            Officina officina = em.find(Officina.class, id);
            if (officina != null) {
                log.info("Officina trovata con ID " + id);
            }
            return officina;
        } catch (Exception e) {
            log.error("Errore durante la ricerca dell'officina con ID " + id, e);
            return null;
        }
    }
    
    // Cerca tutte le officine
//    public List<Officina> getAllOfficine() {
//        Query query = em.createQuery("SELECT o FROM Officina o");
//        return query.getResultList();
//    }
    
    public List<Officina> getAllOfficine() {
        TypedQuery<Officina> query = em.createQuery("SELECT DISTINCT o FROM Officina o",
                Officina.class);
        List<Officina> Officina = query.getResultList();
        log.info("Lista di tutte le Officine presenti nel database: \n" + Officina);
        return Officina;
    }
    
    // Aggiorna officina
    public void updateOfficina(Officina officina) {
        em.getTransaction().begin();
        
        em.merge(officina);
        
        em.getTransaction().commit();
        log.info("Officina aggiornata correttamente");
    }
    // Elimina Officina
    public void deleteOfficina(Officina officina) {
        em.getTransaction().begin();
        
        em.remove(officina);
        
        em.getTransaction().commit();
        log.info("Officina eliminata correttamente");
    }

}
