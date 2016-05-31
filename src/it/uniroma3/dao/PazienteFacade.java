package it.uniroma3.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.model.Paziente;


@Stateless(name="facade")
public class PazienteFacade {

	@PersistenceContext(unitName = "progetto-siw")
	private EntityManager em;


	public Paziente save(Paziente p) {
		em.persist(p);
	    return p;

	}

	public Paziente findById(long id) {
		Paziente c = em.find(Paziente.class, id);
		return c;
	}

	public void delete(Paziente p) {
		Paziente toRemove = em.merge(p);
		em.remove(toRemove);
	}

	public Paziente update(Paziente p) {
		em.merge(p);
        return p;
	}

	@SuppressWarnings("unchecked")
	public List<Paziente> findAll() {
		List<Paziente> result = em.createNamedQuery("Paziente.findAll").getResultList();
		return result;
	}

}