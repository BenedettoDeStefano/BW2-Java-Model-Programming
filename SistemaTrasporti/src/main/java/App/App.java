package App;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.logging.Logger;

import DAO.AbbonamentoDAO;
import DAO.BigliettoDAO;
import DAO.DistributoreAutomaticoDAO;
import DAO.MezzoDAO;
import DAO.OfficinaDAO;
import DAO.RivenditoreAutorizzatoDAO;
import DAO.TesseraDAO;
import DAO.TrattaDAO;
import DAO.UtenteDAO;
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
		   DistributoreAutomaticoDAO distributoreAutomaticoDAO = new DistributoreAutomaticoDAO(em);
		   OfficinaDAO officinaDAO = new OfficinaDAO(em);
		   RivenditoreAutorizzatoDAO rivenditoreAutorizzatoDAO = new RivenditoreAutorizzatoDAO(em);
		   TesseraDAO tesseraDAO = new TesseraDAO(em);
		   TrattaDAO trattaDAO = new TrattaDAO(em);
		   UtenteDAO utenteDAO = new UtenteDAO(em);

	
//		   Biglietto biglietto1 = new Biglietto("B001", LocalDate.now(), 10.50, TipoBiglietto.SINGOLO, false, null, null, null, null);
//		   bigliettoDAO.emettiBiglietto(biglietto1);
//		   System.out.println("Biglietto emesso: " + biglietto1);

		   em.close();
		   emf.close();
	}

}
