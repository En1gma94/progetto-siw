package it.uniroma3.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.model.Utente;


@Stateless(name="facade")
public class UtenteFacade {

	@PersistenceContext(unitName = "progetto-siw")
	private EntityManager em;


	public Utente save(Utente p) {
		em.persist(p);
	    return p;

	}

	public Utente findById(long id) {
		Utente c = em.find(Utente.class, id);
		return c;
	}

	public void delete(Utente p) {
		Utente toRemove = em.merge(p);
		em.remove(toRemove);
	}

	public Utente update(Utente p) {
		em.merge(p);
        return p;
	}

	@SuppressWarnings("unchecked")
	public List<Utente> findAll() {
		List<Utente> result = em.createNamedQuery("Utente.findAll").getResultList();
		return result;
	}

}