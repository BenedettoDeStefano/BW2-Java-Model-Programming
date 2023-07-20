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
import DAO.TrattePercorseDAO;
import DAO.UtenteDAO;
import Entities.Abbonamento;
import Entities.Biglietto;
import Entities.DistributoreAutomatico;
import Entities.Mezzo;
import Entities.Officina;
import Entities.RivenditoreAutorizzato;
import Entities.Tessera;
import Entities.Tratta;
import Entities.TrattePercorse;
import Entities.Utente;
import Enum.StatoMezzo;
import Enum.TipoAbbonamento;
import Enum.TipoBiglietto;
import Enum.TipoMezzo;

public class App {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaTrasporti");
	private static Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		EntityManager em = emf.createEntityManager();
		Faker faker = new Faker(new Locale("it"));
		Random random = new Random();

		RivenditoreAutorizzatoDAO rva = new RivenditoreAutorizzatoDAO(em);
		TesseraDAO ts = new TesseraDAO(em);
		TrattaDAO tr = new TrattaDAO(em);
		OfficinaDAO of = new OfficinaDAO(em);
		DistributoreAutomaticoDAO dsa = new DistributoreAutomaticoDAO(em);
		TrattePercorseDAO tpd = new TrattePercorseDAO(em);
		MezzoDAO mz = new MezzoDAO(em);
		UtenteDAO ut = new UtenteDAO(em);
		AbbonamentoDAO ab = new AbbonamentoDAO(em);
		BigliettoDAO bg = new BigliettoDAO(em);

//		// Creazione e salvataggio dei rivenditori autorizzati
//		for (int i = 0; i < 5; i++) {
//			RivenditoreAutorizzato rivenditore = new RivenditoreAutorizzato(faker.company().name(),
//					faker.address().fullAddress());
//			rva.saveRivenditoreAutorizzato(rivenditore);
//		}
//
//		// Creazione/Salvataggio Tessere
//		for (int i = 0; i < 5; i++) {
//			LocalDate dataScadenza = LocalDate.now().plusMonths(i + 1);
//			Long codiceTessera = random.nextLong();
//			Tessera tessera = new Tessera(dataScadenza, codiceTessera);
//			ts.salvaTessera(tessera);
//		}
//
//		// Creazione/Salvataggio Tratta
//		List<Tratta> tratte = new ArrayList<>();
//		for (int i = 0; i < 5; i++) {
//			String partenza = faker.address().city();
//			String capolinea = faker.address().city();
//			Tratta tratta = new Tratta(partenza, capolinea);
//			tratte.add(tratta);
//			tr.saveTratta(tratta);
//		}
//
//		// Creazione/Salvataggio Officine
//		List<Officina> officineList = new ArrayList<>();
//		for (int i = 0; i < 5; i++) {
//			LocalDate dataInizio = LocalDate.now().plusDays(random.nextInt(30) + 1);
//			LocalDate dataFine = dataInizio.plusDays(random.nextInt(30) + 1);
//			Officina officina = new Officina(dataInizio, dataFine);
//			officineList.add(officina);
//			of.saveOfficina(officina);
//		}
//
//		// Creazione/Salvataggio Distributori
//		for (int i = 0; i < 5; i++) {
//			String posizione = faker.address().city();
//			boolean stato = faker.bool().bool();
//			DistributoreAutomatico distributore = new DistributoreAutomatico(posizione, stato);
//			dsa.saveDistributoreAutomatico(distributore);
//		}
//
//		// Creazione/Salvataggio Mezzo
//		List<Mezzo> mezzi = new ArrayList<>();
//
//		for (int i = 0; i < 5; i++) {
//			TipoMezzo tipo = TipoMezzo.values()[random.nextInt(TipoMezzo.values().length)];
//			StatoMezzo stato = StatoMezzo.values()[random.nextInt(StatoMezzo.values().length)];
//			int capienza = random.nextInt(100) + 1;
//			Tratta tratta = tratte.get(random.nextInt(tratte.size()));
//			Officina officina = null;
//
//			if (stato == StatoMezzo.IN_SERVIZIO) {
//				Mezzo mezzo = new Mezzo(tipo, stato, capienza, tratta);
//				mz.saveMezzo(mezzo);
//				mezzi.add(mezzo);
//			} else {
//				officina = officineList.get(random.nextInt(officineList.size()));
//				Mezzo mezzo = new Mezzo(tipo, stato, capienza, tratta, officina);
//				mz.saveMezzo(mezzo);
//				mezzi.add(mezzo);
//			}
//		}
//
//		// Creazione/Salvataggio TrattePercorse
//		List<Mezzo> mezzis = mz.getAllMezzi();
//		List<Tratta> trattes = tr.getAllTratte();
//
//		for (int i = 0; i < 5; i++) {
//			long codiceStorico = random.nextLong(1000) + 1;
//			int tempoEffettivo = random.nextInt(200) + 1;
//			Mezzo mezzo = mezzi.get(random.nextInt(mezzi.size()));
//			Tratta tratta = trattes.get(random.nextInt(trattes.size()));
//			TrattePercorse trattePercorse = new TrattePercorse(codiceStorico, tempoEffettivo, mezzo, tratta);
//			mezzo.addTrattePercorse(trattePercorse);
//			tratta.addTrattePercorse(trattePercorse);
//			tpd.save(trattePercorse);
//		}
//
//		// Creazione/Salvataggio Utenti tramite scanner
//		List<Tessera> tessere = ts.getAllTessere();
//		System.out.println();
//		System.err.println(" \n Crea 3 utenti:");
//
//		for (int i = 1; i < 4; i++) {
//			System.out.print("Inserisci il nome dell'utente " + i + " ");
//			String nome = scanner.nextLine();
//
//			System.out.print("Inserisci il cognome dell'utente " + i + " ");
//			String cognome = scanner.nextLine();
//
//			int randomIndex = random.nextInt(tessere.size());
//			Tessera tesseraRecuperataCasualmente = tessere.get(randomIndex);
//			tessere.remove(randomIndex);
//
//			Utente utente = new Utente(nome, cognome, tesseraRecuperataCasualmente);
//			ut.salvaUtente(utente);
//			System.out.println(utente);
//		}

		// Scelta tra Utente e Amministratore
		System.out.println("\n -----------------------Seleziona il tuo ruolo:-----------------------");
		System.out.println("1. Utente");
		System.out.println("2. Amministratore");
		System.err.print("Inserisci il numero corrispondente al tuo ruolo: ");
		int scelta = scanner.nextInt();
		scanner.nextLine();

		switch (scelta) {
		case 1:
			accessoUtente();
			break;
		case 2:
			accessoAmministratore();
			break;
		default:
			System.out.println("Scelta non valida. Uscita dall'applicazione.");
			break;
		}

		scanner.close();
		em.close();
		emf.close();
	}

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
		System.out.println("9. Visualizza tratta del mezzo");


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

		switch (sceltaUtente) {
		case 1:
			Biglietto ticket1 = new Biglietto("opppl55", LocalDate.now(), 12.50, TipoBiglietto.SINGOLO, false,
					dsa.getDistributoreAutomaticoById(1200), null, ut.getUtenteById(1212), mz.getMezzoById(1205), TipoMezzo.TRAM);
			bg.acquistaBiglietto(ticket1);
			break;
		case 2:			
			Abbonamento abbonamento1 = new Abbonamento("AAA11", LocalDate.now(), 10.50, TipoAbbonamento.MENSILE,
					LocalDate.now().plusMonths(3), true, ts.getTesseraById(1183), rva.getRivenditoreAutorizzatoById(1179));
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
		//Biglietti e Abbonamento
		System.out.println("1. Emetti Biglietto");
		System.out.println("2. Emetti Abbonamento");
		System.out.println("3. Vidima Biglietto");
		System.out.println("4. Aquisisci numero biglietti vidimati");
		System.out.println("5. Modifica Biglietto");
		System.out.println("6. Elimina Biglietto");
		System.out.println("7. Visualizza biglietti disponibili");
		System.out.println("8. Visualizza il tipo di abbonamento");
		System.out.println("10. Visualizza abbonamento vidimato");
		System.out.println("11. Visualizza tessera abbonamento");
		System.out.println("12. Visualizza tutti abbonamenti");
		System.out.println("13. Modifica abbonamento");
		System.out.println("14. Cancella abbonamento \n");
		
		//Distributore
		System.out.println("15. Modifica distributore");
		System.out.println("16. Cancella un distributore \n");
		
		//Mezzo
		System.out.println("17. Visualizza lo stato del mezzo");
		System.out.println("18. Visualizza mezzi in servizio");
		System.out.println("19. Visualizza mezzi in manutenzione");
		System.out.println("20. Modifica mezzo");
		System.out.println("21. Cancella mezzo \n");
		
		//Officine
		System.out.println("22. Visualizza le officine disponibili");
		System.out.println("23. Modifica officina");
		System.out.println("24. Elimina officina \n");
		
		//Rivenditori
		System.out.println("25. Modifica rivenditore");
		System.out.println("26. Cancella rivenditore \n");
		
		//Tessera
		System.out.println("27. Visualizza tessere disponibili");
		System.out.println("28. Modifica tessera");
		System.out.println("29. Cancella tessera \n");
		
		//Tratta
		System.out.println("30. Modifica tratta");
		System.out.println("31. Cancella tratta \n");
		
		//Utente
		System.out.println("32. Visualizza tutti gli utenti");
		System.out.println("33. Modifica utente");
		System.out.println("34. Cancella utente \n");

		
		int sceltaAmministratore = scanner.nextInt();
		scanner.nextLine();

		switch (sceltaAmministratore) {
		case 1:
			
			break;
		case 2:

			break;
		default:
			System.out.println("Scelta non valida. Uscita dall'applicazione.");
			break;
		}

		scanner.close();
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
// **************************************************************

//	        Tessera tessera1 = ts.getTesseraById(192);
//	        Tessera tessera2 = ts.getTesseraById(240);
//	        Tessera tessera3 = ts.getTesseraById(215);

// Creazione/Salvataggio Utenti
//	        Utente utente1 = new Utente("Benedetto" , "De Stefano" , ts.getTesseraById(192), null);
//	        ut.salvaUtente(utente1);
//	        
//	        Utente utente2 = new Utente("Artem", "X5", ts.getTesseraById(240), null);
//	        ut.salvaUtente(utente2);

// CAMBIARE LONG CON UUD\

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