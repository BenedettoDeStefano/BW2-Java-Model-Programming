//package App;
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
//public class Accesso {
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
