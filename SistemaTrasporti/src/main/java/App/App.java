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
import Entities.Utente;
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
//		System.out.println();
//		List<Mezzo> mezziAll = mz.getAllMezzi();
//		List<Tratta> tratteAll = tr.getAllTratte();
//
//		for (int i = 0; i < 5; i++) {
//			long codiceStorico = random.nextLong(1000) + 1;
//			long tempoEffettivo = random.nextLong((long) 200) + 1;
//			Mezzo mezzo = mezziAll.get(random.nextInt(mezziAll.size()));
//			Tratta tratta = tratteAll.get(random.nextInt(tratteAll.size()));
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
			Accesso.accessoUtente();
			break;
		case 2:
			Accesso.accessoAmministratore();
			break;
		default:
			System.out.println("Scelta non valida. Uscita dall'applicazione.");
			break;
		}

		scanner.close();
		em.close();
		emf.close();
	}
}