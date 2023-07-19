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
import Entities.DistributoreAutomatico;
import Entities.Mezzo;
import Entities.Officina;
import Entities.RivenditoreAutorizzato;
import Entities.Tessera;
import Entities.Tratta;
import Entities.Utente;
import Entities.trattePercorse;
import Enum.StatoMezzo;
import Enum.TipoBiglietto;
import Enum.TipoMezzo;

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
		DistributoreAutomaticoDAO dsa = new DistributoreAutomaticoDAO(em);
		UtenteDAO ut = new UtenteDAO(em);
		MezzoDAO mz = new MezzoDAO(em);
		AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO(em);
		BigliettoDAO bigliettoDAO = new BigliettoDAO(em);

		
          // Creazione e salvataggio dei rivenditori autorizzati 	
        for (int i = 0; i < 5; i++) {
            RivenditoreAutorizzato rivenditore = new RivenditoreAutorizzato(faker.company().name(), faker.address().fullAddress());
            rva.saveRivenditoreAutorizzato(rivenditore);
        }
		
		  //Creazione/Salvataggio Tessere
	        for (int i = 0; i < 5; i++) {
	            LocalDate dataScadenza = LocalDate.now().plusMonths(i + 1);
	            Tessera tessera = new Tessera(dataScadenza);
	            ts.salvaTessera(tessera);
	            }
	        
	      //Creazione/Salvataggio Tratta 
	        List<Tratta> trattePercorseList = new ArrayList<>();
	        for (int i = 0; i < 5; i++) {
	            String partenza = faker.address().city();
	            String capolinea = faker.address().city();
	            Tratta tratta = new Tratta(partenza, capolinea);
	            trattePercorseList.add(tratta);
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
	        
	      //Creazione/Salvataggio Distributori        
	        for (int i = 0; i < 5; i++) {
	            String posizione = faker.address().city(); 
	            boolean stato = faker.bool().bool();
	            DistributoreAutomatico distributore = new DistributoreAutomatico(posizione, stato);
	            dsa.saveDistributoreAutomatico(distributore);
	        }
	        
	        // **************************************************************
	        
//	        Tessera tessera1 = ts.getTesseraById(192);
//	        Tessera tessera2 = ts.getTesseraById(240);
//	        Tessera tessera3 = ts.getTesseraById(215);
	        
	      //Creazione/Salvataggio Mezzi
//	        Mezzo mezzo1 = new Mezzo(TipoMezzo.AUTOBUS, StatoMezzo.IN_SERVIZIO, 100, tr.getTrattaById(304), null, of.getOfficinaById(181));
//	        mz.saveMezzo(mezzo1);
	        
	        
	        //Creazione/Salvataggio Utenti
//	        Utente utente1 = new Utente("Benedetto" , "De Stefano" , ts.getTesseraById(192), null);
//	        ut.salvaUtente(utente1);
//	        
//	        Utente utente2 = new Utente("Artem", "X5", ts.getTesseraById(240), null);
//	        ut.salvaUtente(utente2);

	        
	        //CAMBIARE LONG CON UUD
	        
	        
	        // SCANNER (1)
//	        System.out.println("Sei un utente o un amministratore? (scrivi 'utente' o 'amministratore')");
//	        String userType = scanner.nextLine();
//
//	        if (userType.equalsIgnoreCase("utente")) {
//	            
//	        } else if (userType.equalsIgnoreCase("amministratore")) {
//	            
//	        } else {
//	            System.out.println("Tipo di utente non riconosciuto. Accesso negato.");
//	        }
	        
	     // SCANNER (1)
//	        System.out.println("Benvenuto! Seleziona il tuo ruolo:");
//	        System.out.println("1. Utente");
//	        System.out.println("2. Amministratore");
//	        System.out.print("Inserisci il numero corrispondente al tuo ruolo: ");
//	        int choice = scanner.nextInt();
//
//	        switch (choice) {
//	            case 1:
//	                accessoUtente(em, faker);
//	                break;
//	            case 2:
//	                accessoAmministratore(em, faker);
//	                break;
//	            default:
//	                System.out.println("Scelta non valida. Uscita dall'applicazione.");
//	                break;
//	        }
//	    }
	    
	        // ****************************************************************
	  
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