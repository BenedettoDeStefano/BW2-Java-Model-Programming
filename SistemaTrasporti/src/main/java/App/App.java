package App;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.logging.Logger;

import com.github.javafaker.Faker;

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
import Entities.Officina;
import Entities.RivenditoreAutorizzato;
import Entities.Tessera;
import Entities.Tratta;
import Enum.TipoBiglietto;

public class App {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaTrasporti");
	private static Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		EntityManager em = emf.createEntityManager();
		Faker faker = new Faker(new Locale("it"));
		  
		RivenditoreAutorizzatoDAO rva = new RivenditoreAutorizzatoDAO(em);
		TesseraDAO ts = new TesseraDAO(em);
		TrattaDAO tr = new TrattaDAO(em);
		OfficinaDAO of = new OfficinaDAO(em);
		DistributoreAutomaticoDAO distributoreAutomaticoDAO = new DistributoreAutomaticoDAO(em);
		UtenteDAO utenteDAO = new UtenteDAO(em);
		MezzoDAO mezzoDAO = new MezzoDAO(em);
		AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO(em);
		BigliettoDAO bigliettoDAO = new BigliettoDAO(em);

		
        // Creazione e salvataggio dei rivenditori autorizzati 
		List<RivenditoreAutorizzato> rivenditoriAutorizzatiList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            RivenditoreAutorizzato rivenditore = new RivenditoreAutorizzato(faker.company().name(), faker.address().fullAddress());
            rva.saveRivenditoreAutorizzato(rivenditore);
            rivenditoriAutorizzatiList.add(rivenditore);
        }
		
		//Creazione/Salvataggio Tessere
		  int numeroTessere = 5;
	      Tessera[] tessere = new Tessera[numeroTessere];

	        for (int i = 0; i < numeroTessere; i++) {
	            LocalDate dataScadenza = LocalDate.now().plusMonths(i + 1);
	            tessere[i] = new Tessera(dataScadenza);
	            ts.salvaTessera(tessere[i]);
	            }
	        
	      //Creazione/Salvataggio Tratta 
	        List<Tratta> tratteList = new ArrayList<>();
	        for (int i = 0; i < 5; i++) {
	            String partenza = faker.address().city();
	            String capolinea = faker.address().city();
	            Tratta tratta = new Tratta(partenza, capolinea);
	            tratteList.add(tratta);
	            tr.saveTratta(tratta);
	        }
	        
	        //Creazione/Salvataggio Officine
	        
	        List<Officina> officineList = new ArrayList<>();
	        for (int i = 0; i < 5; i++) {
	        	LocalDate dataInizio = LocalDate.now().plusDays(new Random().nextInt(30) + 1);
	            LocalDate dataFine = dataInizio.plusDays(new Random().nextInt(30) + 1);

	            Officina officina = new Officina(dataInizio, dataFine);
	            officineList.add(officina);
	            of.saveOfficina(officina);
	        }

		   em.close();
		   emf.close();
	}

}



//		RivenditoreAutorizzato rivenditore1 = new RivenditoreAutorizzato(faker.company().name(), faker.address().fullAddress());
//	    RivenditoreAutorizzato rivenditore2 = new RivenditoreAutorizzato(faker.company().name(), faker.address().fullAddress());
//	    RivenditoreAutorizzato rivenditore3 = new RivenditoreAutorizzato(faker.company().name(), faker.address().fullAddress());
//	    RivenditoreAutorizzato rivenditore4 = new RivenditoreAutorizzato(faker.company().name(), faker.address().fullAddress());
//	    RivenditoreAutorizzato rivenditore5 = new RivenditoreAutorizzato(faker.company().name(), faker.address().fullAddress());
//
//		
//		rva.saveRivenditoreAutorizzato(rivenditore1);
//		rva.saveRivenditoreAutorizzato(rivenditore2);
//		rva.saveRivenditoreAutorizzato(rivenditore3);
//		rva.saveRivenditoreAutorizzato(rivenditore4);
//		rva.saveRivenditoreAutorizzato(rivenditore5);



//		Tessera tessera1 = new Tessera(LocalDate.now().plusMonths(1));
//		Tessera tessera2 = new Tessera(LocalDate.now().plusMonths(2));
//		Tessera tessera3 = new Tessera(LocalDate.now().plusMonths(3));
//		Tessera tessera4 = new Tessera(LocalDate.now().minusMonths(1));
//		Tessera tessera5 = new Tessera(LocalDate.now().minusMonths(2));


//	    Tratta tratta1 = new Tratta("Napoli","Roma");

//	    Officina officina1 = new Officina (LocalDate.now(), LocalDate.now().plusMonths(1));