package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jboss.logging.Logger;

import Entities.Tessera;

public class TesseraDAO {
	
	private EntityManagerFactory emf;
	
	public TesseraDAO() {
		emf = Persistence.createEntityManagerFactory("sistemaTrasporti");
	}
	
	public void salvaTessera(Tessera tessera) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = null;
		
		try {
			transaction = em.getTransaction();
			transaction.begin();
			
			em.persist(tessera);
			
			transaction.commit();
			
			System.out.println("Tessera salvata nel databse correttamente");
		}catch (Exception e){
			if (transaction != null) 
				transaction.rollback();
			
			System.out.println("Errore durante salvataggio della tessera!");
		}finally {
			if (em != null)
				em.close();
		}
	}
}
