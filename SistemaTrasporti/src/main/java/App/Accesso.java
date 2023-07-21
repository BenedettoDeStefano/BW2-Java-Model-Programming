package App;
//
//import java.time.LocalDate;
//import java.util.Scanner;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import DAO.AbbonamentoDAO;
//import DAO.BigliettoDAO;
//import DAO.MezzoDAO;
//import Entities.Biglietto;
//import Entities.DistributoreAutomatico;
//import Entities.Mezzo;
//import Entities.RivenditoreAutorizzato;
//import Entities.Utente;
//import Enum.TipoBiglietto;
//import Enum.TipoMezzo;
//
//

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DAO.AbbonamentoDAO;
import DAO.BigliettoDAO;
import DAO.DistributoreAutomaticoDAO;
import DAO.MezzoDAO;
import DAO.OfficinaDAO;
import DAO.RivenditoreAutorizzatoDAO;
import DAO.TesseraDAO;
import DAO.TrattaDAO;
import DAO.TrattePercorseDAO;
import DAO.UtenteDAO;
import Entities.Abbonamento;
import Entities.Biglietto;
import Entities.DistributoreAutomatico;
import Entities.Mezzo;
import Entities.Officina;
import Entities.RivenditoreAutorizzato;
import Entities.Tessera;
import Enum.TipoAbbonamento;
import Enum.TipoBiglietto;
import Enum.TipoMezzo;


public class Accesso {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaTrasporti");
	
	public static void accessoUtente() {
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.print("\n Benvenuto Utente, cosa vuoi fare? \n");
		System.out.println("1. Acquista Biglietto");
		System.out.println("2. Acquista Abbonamento");
		System.out.println("3. Visualizza tratte disponibili");
		System.out.println("4. Visualizza rivenditori autorizzati");
		System.out.println("5. Visualizza distributori automatici");
		System.out.println("6. Visualizza lista dei mezzi");
		System.out.println("7. Visualizza tratta per mezzo");
		System.out.println("8. Visualizza tempo per tratta");

		int sceltaUtente = scanner.nextInt();
		scanner.nextLine();
		EntityManager em = emf.createEntityManager();
		BigliettoDAO bg = new BigliettoDAO(em);
		DistributoreAutomaticoDAO dsa = new DistributoreAutomaticoDAO(em);
		UtenteDAO ut = new UtenteDAO(em);
		MezzoDAO mz = new MezzoDAO(em);
		AbbonamentoDAO ab = new AbbonamentoDAO(em);
		TesseraDAO ts = new TesseraDAO(em);
		RivenditoreAutorizzatoDAO rva = new RivenditoreAutorizzatoDAO(em);
		TrattaDAO tr = new TrattaDAO(em);
		TrattePercorseDAO tps = new TrattePercorseDAO(em);

		switch (sceltaUtente) {
		case 1:
			Biglietto ticket1 = new Biglietto("opppl55", LocalDate.now(), 12.50, TipoBiglietto.SINGOLO, false,
					dsa.getDistributoreAutomaticoById((long) 1200), null, ut.getUtenteById((long) 777),
					mz.getMezzoById((long) 767), TipoMezzo.TRAM);
			bg.acquistaBiglietto(ticket1);
			break;
		case 2:
			Abbonamento abbonamento1 = new Abbonamento("AAA11", LocalDate.now(), 10.50, TipoAbbonamento.MENSILE,
					LocalDate.now().plusMonths(3), true, ts.getTesseraById((long) 777),
					rva.getRivenditoreAutorizzatoById((long) 742));
			ab.acquistaAbbonamento(abbonamento1);
			break;
		case 3:
			tr.getAllTratte();
			break;
		case 4:
			rva.getAllRivenditoriAutorizzati();
			break;
		case 5:
			dsa.getAllDistributoriAutomatici();
			break;
		case 6:
			mz.getAllMezzi();
			break;
		case 7:
			System.out.println(tps.findByMezzo((long) 767));
			break;
		case 8:
			System.out.println(tps.findByTempoEffettivoSuperioreA((long) 125));
			break;
		default:
			System.out.println("Scelta non valida. Uscita dall'applicazione.");
			break;
		}

		scanner.close();
	}

	public static void accessoAmministratore() {
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.print("\n Benvenuto Amministratore, cosa vuoi fare? \n");
		// Biglietti e Abbonamento
		System.out.println("------------------Principale------------------");
		System.out.println("1. Emetti Biglietto");
		System.out.println("2. Emetti Abbonamento");
		System.out.println("3. Vidima Biglietto");
		System.out.println("------------------Elimina------------------");
		System.out.println("4. Elimina abbonamento");
		System.out.println("5. Elimina un distributore");
		System.out.println("6. Elimina mezzo");
		System.out.println("7. Elimina officina");
		System.out.println("8. Elimina rivenditore");
		System.out.println("9. Elimina tessera");
		System.out.println("10. Elimina tratta");
		System.out.println("11. Elimina utente");
		System.out.println("------------------Modifica------------------");
		System.out.println("12. Modifica abbonamento");
		System.out.println("13. Modifica tessera");
		System.out.println("14. Modifica tratta");
		System.out.println("15. Modifica utente");
		
		
		
//		System.out.println("25. Modifica rivenditore");
//		System.out.println("23. Modifica officina");
//		System.out.println("20. Modifica mezzo");
//		System.out.println("15. Modifica distributore");
//		System.out.println("6. Elimina Biglietto");
//		System.out.println("5. Modifica Biglietto");
//		System.out.println("4. Aquisisci numero biglietti vidimati");
//		System.out.println("7. Visualizza biglietti disponibili");
//		System.out.println("8. Visualizza il tipo di abbonamento");
//		System.out.println("10. Visualizza abbonamento vidimato");
//		System.out.println("11. Visualizza tessera abbonamento");
//		System.out.println("12. Visualizza tutti abbonamenti");
//
//		// Distributore
//
//		// Mezzo
//		System.out.println("17. Visualizza lo stato del mezzo");
//		System.out.println("18. Visualizza mezzi in servizio");
//		System.out.println("19. Visualizza mezzi in manutenzione");
//
//		// Officine
//		System.out.println("22. Visualizza le officine disponibili");
//
//		// Rivenditori
//
//		// Tessera
//		System.out.println("27. Visualizza tessere disponibili");
//
//		// Tratta
//
//		// Utente
//		System.out.println("32. Visualizza tutti gli utenti");

		EntityManager em = emf.createEntityManager();
		BigliettoDAO bg = new BigliettoDAO(em);
		DistributoreAutomaticoDAO dsa = new DistributoreAutomaticoDAO(em);
		UtenteDAO ut = new UtenteDAO(em);
		MezzoDAO mz = new MezzoDAO(em);
		AbbonamentoDAO ab = new AbbonamentoDAO(em);
		TesseraDAO ts = new TesseraDAO(em);
		RivenditoreAutorizzatoDAO rva = new RivenditoreAutorizzatoDAO(em);
		TrattaDAO tr = new TrattaDAO(em);
		TrattePercorseDAO tps = new TrattePercorseDAO(em);
		OfficinaDAO of = new OfficinaDAO(em);

		Biglietto ticket2 = null; 

		int sceltaAmministratore = scanner.nextInt();
		scanner.nextLine();
		
		switch (sceltaAmministratore) {
		
		case 1:
			ticket2 = new Biglietto("opppl55", LocalDate.now(), 12.50, TipoBiglietto.SINGOLO, false,
					dsa.getDistributoreAutomaticoById((long) 1243), null, ut.getUtenteById((long) 1256),
					mz.getMezzoById((long)1245), TipoMezzo.TRAM);
			bg.emettiBiglietto(ticket2);
			break;
		case 2:
			Abbonamento abbonamento2 = new Abbonamento("AAA11", LocalDate.now(), 10.50, TipoAbbonamento.MENSILE,
					LocalDate.now().plusMonths(3), true, ts.getTesseraById((long) 1228),
					rva.getRivenditoreAutorizzatoById((long) 1223));
			ab.emettiAbbonamento(abbonamento2);
			break;
		case 3:
				ticket2 = bg.getBigliettoById((long)1260);
				bg.vidimaBiglietto(ticket2);
			break;
		case 4:
			ab.getAllAbbonamenti();
			
			System.out.println("Inserisci l'ID dell'abbonamento che vuoi eliminare");
	        long idAbbonamento = scanner.nextLong();
	        scanner.nextLine();
	        
			Abbonamento abb1 = ab.getAbbonamentoById(idAbbonamento);
			
			ab.deleteAbbonamento(abb1);
		break;
		case 5:
			dsa.getAllDistributoriAutomatici();
			
			System.out.println("Inserisci l'ID del distributore che vuoi eliminare");
	        long idDistributore = scanner.nextLong();
	        scanner.nextLine();
	        
			DistributoreAutomatico dis1 = dsa.getDistributoreAutomaticoById(idDistributore);
			
			dsa.deleteDistributoreAutomatico(dis1);
		break;
		case 6:
			mz.getAllMezzi();
			
			System.out.println("Inserisci l'ID del mezzo che vuoi eliminare");
	        long idMezzo = scanner.nextLong();
	        scanner.nextLine();
	        
			Mezzo mezzo1 = mz.getMezzoById(idMezzo);
			
			mz.deleteMezzo(mezzo1);
		break;
		case 7:
			of.getAllOfficine();
			
			System.out.println("Inserisci l'ID dell' officina che vuoi eliminare");
	        long idOfficina = scanner.nextLong();
	        scanner.nextLine();
	        
			Officina officina1 = of.getOfficinaById(idOfficina);
			
			of.deleteOfficina(officina1);
		break;
		case 8:
			rva.getAllRivenditoriAutorizzati();
			
			System.out.println("Inserisci l'ID del rivenditore che vuoi eliminare");
	        long idRivenditore = scanner.nextLong();
	        scanner.nextLine();
	        
			RivenditoreAutorizzato rivenditore1 = rva.getRivenditoreAutorizzatoById(idRivenditore);
			
			rva.deleteRivenditoreAutorizzato(rivenditore1);
		break;
		case 9:
			ts.getAllTessere();
			
			System.out.println("Inserisci l'ID della tessera che vuoi eliminare");
	        long idTessera = scanner.nextLong();
	        scanner.nextLine();
	        
			Tessera tessera1 = ts.getTesseraById(idTessera);
			
			ts.deleteTessera(tessera1);
		break;
		case 10:
		
		break;
		case 11:
			
		break;
		case 12:
			ab.getAllAbbonamenti();
			System.out.println("Inserisci l'ID dell'abbonamento da aggiornare:");
		    long abbonamentoId = scanner.nextLong();
		    scanner.nextLine(); 
		    Abbonamento abb2 = ab.getAbbonamentoById(abbonamentoId);

		    if (abb2 != null) {
		        System.out.println("Inserisci il nuovo tipo di abbonamento (SETTIMANALE - MENSILE)");
		        String tipoAbbonamento = scanner.nextLine();
		        abb2.setTipo(TipoAbbonamento.valueOf(tipoAbbonamento.toUpperCase()));

		        System.out.println("Inserisci la nuova data di scadenza (formato: YYYY-MM-DD):");
		        String dataScadenzaString = scanner.nextLine();
		        LocalDate dataScadenza = LocalDate.parse(dataScadenzaString);;
		        abb2.setDataScadenza(dataScadenza);

		        ab.updateAbbonamento(abb2);
		    } else {
		        System.out.println("Abbonamento non trovato con l'ID fornito.");
		    }
		    break;
		case 13:
		
		break;
		case 14:
			
		break;
		case 15:
			
		break;
		default:
			System.out.println("Scelta non valida. Uscita dall'applicazione.");
			break;
			
		}
		em.close();
		scanner.close();


	}

}

//	
//	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaTrasporti");
//	public static void accessoUtente() {
//	    Scanner scanner = new Scanner(System.in);
//	    System.out.println();
//	    System.out.print("\n Benvenuto Utente, cosa vuoi fare? \n");
//	    System.out.println("1. Acquista Biglietto");
//	    System.out.println("2. Acquista Abbonamento");
//	    System.out.println("3. Cerca tratta");
//	    System.out.println("4. Visualizza tratte disponibili");
//	    System.out.println("5. Visualizza rivenditori autorizzati");
//	    System.out.println("6. Visualizza distributori disponibili");
//	    System.out.println("7. Visualizza lista dei mezzi");	
//	    
//	    EntityManager em = emf.createEntityManager();
//	    AbbonamentoDAO ab = new AbbonamentoDAO(em);
//	    BigliettoDAO bg = new BigliettoDAO(em);
//	    MezzoDAO mz = new MezzoDAO(em);
//	    
//	     mezzo1 = mz.findMezzoByCodice(null);
//	    
//	    int sceltaUtente = scanner.nextInt();
//	    scanner.nextLine();
//	    
//
//	    switch (sceltaUtente) {
//	        case 1:
//	        	Biglietto biglietto1 = new Biglietto("AAA11", LocalDate.now(), 10.50, TipoBiglietto.SINGOLO,
//	        			DistributoreAutomatico.class, RivenditoreAutorizzato.class, AUTOBUS); 		
//	        	bg.acquistaBiglietto(null);
//	            break;
//	        case 2:
//	           
//	            break;
//	        default:
//	            System.out.println("Scelta non valida. Uscita dall'applicazione.");
//	            break;
//	    }
//
//	    scanner.close();
//	}
//
//	public static void accessoAmministratore() {
//	    Scanner scanner = new Scanner(System.in);
//	    System.out.println();
//	    System.out.print("\n Benvenuto Amministratore, cosa vuoi fare? \n");
//	        
//	   
//	    int sceltaAmministratore = scanner.nextInt();
//	    scanner.nextLine();
//
//	    switch (sceltaAmministratore) {
//	        case 1:
//	            
//	            break;
//	        case 2:
//	            
//	            break;
//	        default:
//	            System.out.println("Scelta non valida. Uscita dall'applicazione.");
//	            break;
//	    }
//
//	    scanner.close();
//	}
//
//}
