package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.jboss.logging.Logger;

import Entities.TrattePercorse;

public class TrattePercorseDAO {

	private final EntityManager em;
	private static Logger log = Logger.getLogger(TrattePercorseDAO.class);

	public TrattePercorseDAO(EntityManager em) {
		this.em = em;
	}

	public void close() {
		em.close();
	}

	public TrattePercorse find(Long codiceTratta) {
		return em.find(TrattePercorse.class, codiceTratta);
	}

	public void save(TrattePercorse trattaPercorsa) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(trattaPercorsa);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
	}

	public void update(TrattePercorse trattaPercorsa) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.merge(trattaPercorsa);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
	}

	public void delete(TrattePercorse trattaPercorsa) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.remove(em.contains(trattaPercorsa) ? trattaPercorsa : em.merge(trattaPercorsa));
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
	}

	public List<TrattePercorse> findByMezzo(Long codiceMezzo) {
		return em.createQuery("SELECT tp FROM TrattePercorse tp WHERE tp.codiceMezzo = :codiceMezzo",
				TrattePercorse.class).setParameter("codiceMezzo", codiceMezzo).getResultList();
	}

	public List<TrattePercorse> findByStorico(Long codiceStorico) {
		return em.createQuery("SELECT tp FROM TrattePercorse tp WHERE tp.codiceStorico = :codiceStorico",
				TrattePercorse.class).setParameter("codiceStorico", codiceStorico).getResultList();
	}

	public List<TrattePercorse> findByTempoEffettivoSuperioreA(Long sogliaTempo) {
		return em.createQuery("SELECT tp FROM TrattePercorse tp WHERE tp.tempoEffettivo > :sogliaTempo",
				TrattePercorse.class).setParameter("sogliaTempo", sogliaTempo).getResultList();
	}
}
