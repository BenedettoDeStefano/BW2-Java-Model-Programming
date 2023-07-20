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
import Entities.DistributoreAutomatico;
import Entities.Mezzo;
import Entities.Officina;
import Entities.RivenditoreAutorizzato;
import Entities.Tessera;
import Entities.Tratta;
import Entities.TrattePercorse;
import Enum.StatoMezzo;
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

		// Creazione e salvataggio dei rivenditori autorizzati
		for (int i = 0; i < 5; i++) {
			RivenditoreAutorizzato rivenditore = new RivenditoreAutorizzato(faker.company().name(),
					faker.address().fullAddress());
			rva.saveRivenditoreAutorizzato(rivenditore);
		}

		// Creazione/Salvataggio Tessere
		for (int i = 0; i < 5; i++) {
			LocalDate dataScadenza = LocalDate.now().plusMonths(i + 1);
			Long codiceTessera = random.nextLong();
			Tessera tessera = new Tessera(dataScadenza, codiceTessera);
			ts.salvaTessera(tessera);
		}

		// Creazione/Salvataggio Tratta
		List<Tratta> tratte = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			String partenza = faker.address().city();
			String capolinea = faker.address().city();
			Tratta tratta = new Tratta(partenza, capolinea);
			tratte.add(tratta);
			tr.saveTratta(tratta);
		}

		// Creazione/Salvataggio Officine
		List<Officina> officineList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			LocalDate dataInizio = LocalDate.now().plusDays(random.nextInt(30) + 1);
			LocalDate dataFine = dataInizio.plusDays(random.nextInt(30) + 1);
			Officina officina = new Officina(dataInizio, dataFine);
			officineList.add(officina);
			of.saveOfficina(officina);
		}

		// Creazione/Salvataggio Distributori
		for (int i = 0; i < 5; i++) {
			String posizione = faker.address().city();
			boolean stato = faker.bool().bool();
			DistributoreAutomatico distributore = new DistributoreAutomatico(posizione, stato);
			dsa.saveDistributoreAutomatico(distributore);
		}

		// Creazione/Salvataggio Mezzo
		List<Mezzo> mezzi = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			TipoMezzo tipo = TipoMezzo.values()[random.nextInt(TipoMezzo.values().length)];
			StatoMezzo stato = StatoMezzo.values()[random.nextInt(StatoMezzo.values().length)];
			int capienza = random.nextInt(100) + 1;
			Tratta tratta = tratte.get(random.nextInt(tratte.size()));
			Officina officina = null;

			if (stato == StatoMezzo.IN_SERVIZIO) {
				Mezzo mezzo = new Mezzo(tipo, stato, capienza, tratta);
				mz.saveMezzo(mezzo);
				mezzi.add(mezzo); 
			} else {
				officina = officineList.get(random.nextInt(officineList.size()));
				Mezzo mezzo = new Mezzo(tipo, stato, capienza, tratta, officina);
				mz.saveMezzo(mezzo);
				mezzi.add(mezzo); 
			}
		}

		// Creazione/Salvataggio TrattePercorse
		List<Mezzo> mezzis = mz.getAllMezzi();
		List<Tratta> trattes = tr.getAllTratte();

		for (int i = 0; i < 5; i++) {
			long codiceStorico = random.nextLong(1000) + 1;
			int tempoEffettivo = random.nextInt(200) + 1;
			Mezzo mezzo = mezzi.get(random.nextInt(mezzi.size()));
			Tratta tratta = trattes.get(random.nextInt(trattes.size()));
			TrattePercorse trattePercorse = new TrattePercorse(codiceStorico, tempoEffettivo, mezzo, tratta);
			mezzo.addTrattePercorse(trattePercorse);
			tratta.addTrattePercorse(trattePercorse);
			tpd.save(trattePercorse);
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