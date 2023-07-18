package App;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.logging.Logger;

import DAO.AbbonamentoDAO;
import DAO.BigliettoDAO;
import DAO.MezzoDAO;
import Entities.Biglietto;
import Enum.TipoBiglietto;

public class App {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaTrasporti");
	private static Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) {
		
		EntityManager em = emf.createEntityManager();
		  
		   BigliettoDAO bigliettoDAO = new BigliettoDAO(em);
		   AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO(em);
		   MezzoDAO mezzoDAO = new MezzoDAO(em);

	
		   Biglietto biglietto1 = new Biglietto("B001", LocalDate.now(), 10.50, TipoBiglietto.SINGOLO, false, null, null, null, null);
		   bigliettoDAO.emettiBiglietto(biglietto1);
		   System.out.println("Biglietto emesso: " + biglietto1);

		   em.close();
		   emf.close();
	}

}
