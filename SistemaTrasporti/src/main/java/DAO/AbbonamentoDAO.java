package DAO;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;

import Entities.Abbonamento;
import Entities.Tessera;
import Enum.TipoAbbonamento;

public class AbbonamentoDAO {

	private final EntityManager em;
	private static Logger log = Logger.getLogger(AbbonamentoDAO.class);

	public AbbonamentoDAO(EntityManager em) {
		this.em = em;
	}

	public void emettiAbbonamento(Abbonamento abbonamento) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(abbonamento);

		t.commit();
		log.info("Abbonamento emesso correttamente");
	}

	public Abbonamento getAbbonamentoById(Long id) {
		Abbonamento abbonamento = em.find(Abbonamento.class, id);
		if (abbonamento != null) {
			log.info("Abbonamento trovato correttamente: " + abbonamento);
		} else {
			log.error("Nessun abbonamento trovato per l'ID specificato: " + id);
		}
		return abbonamento;
	}

	public List<Abbonamento> getAllAbbonamenti() {
		TypedQuery<Abbonamento> query = em.createQuery("SELECT a FROM Abbonamento a", Abbonamento.class);
		List<Abbonamento> abbonamenti = query.getResultList();
		log.info("Lista di tutti gli abbonamenti presenti nel database: " + abbonamenti);
		return abbonamenti;
	}

	public void updateAbbonamento(Abbonamento abbonamento) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.merge(abbonamento);

		t.commit();
		log.info("Abbonamento aggiornato correttamente");
	}

	public void deleteAbbonamento(Abbonamento abbonamento) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.remove(abbonamento);

		t.commit();
		log.info("Abbonamento eliminato correttamente");
	}

	public List<Abbonamento> getAbbonamentiByTipo(TipoAbbonamento tipo) {
		TypedQuery<Abbonamento> query = em
				.createQuery("SELECT a FROM Abbonamento a WHERE a.tipo = :tipo", Abbonamento.class)
				.setParameter("tipo", tipo);
		List<Abbonamento> abbonamenti = query.getResultList();
		log.info("Lista di abbonamenti per il tipo: " + tipo + " -> " + abbonamenti);
		return abbonamenti;
	}

	public List<Abbonamento> getAbbonamentiByDataScadenza(LocalDate dataScadenza) {
		TypedQuery<Abbonamento> query = em
				.createQuery("SELECT a FROM Abbonamento a WHERE a.dataScadenza = :dataScadenza", Abbonamento.class)
				.setParameter("dataScadenza", dataScadenza);
		List<Abbonamento> abbonamenti = query.getResultList();
		log.info("Lista di abbonamenti per la data di scadenza: " + dataScadenza + " -> " + abbonamenti);
		return abbonamenti;
	}

	public List<Abbonamento> getAbbonamentiByVidimato(Boolean vidimato) {
		TypedQuery<Abbonamento> query = em
				.createQuery("SELECT a FROM Abbonamento a WHERE a.vidimato = :vidimato", Abbonamento.class)
				.setParameter("vidimato", vidimato);
		List<Abbonamento> abbonamenti = query.getResultList();
		log.info("Lista di abbonamenti per lo stato di vidimazione: " + vidimato + " -> " + abbonamenti);
		return abbonamenti;
	}

	public List<Abbonamento> getAbbonamentiByTessera(Tessera tessera) {
		TypedQuery<Abbonamento> query = em
				.createQuery("SELECT a FROM Abbonamento a WHERE a.tessera = :tessera", Abbonamento.class)
				.setParameter("tessera", tessera);
		List<Abbonamento> abbonamenti = query.getResultList();
		log.info("Lista di abbonamenti per la tessera: " + tessera + " -> " + abbonamenti);
		return abbonamenti;
	}

}
