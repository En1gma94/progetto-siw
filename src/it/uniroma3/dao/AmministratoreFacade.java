package it.uniroma3.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.model.Amministratore;


@Stateless(name="amministratore_facade")
public class  AmministratoreFacade {

	@PersistenceContext(unitName = "clinica-unit")
	private EntityManager em;


	public Amministratore save(Amministratore p) {
		em.persist(p);
	    return p;

	}

	public Amministratore findById(long id) {
		Amministratore c = em.find(Amministratore.class, id);
		return c;
	}

	public void delete(Amministratore p) {
		Amministratore toRemove = em.merge(p);
		em.remove(toRemove);
	}

	public Amministratore update(Amministratore p) {
		em.merge(p);
        return p;
	}

	@SuppressWarnings("unchecked")
	public List<Amministratore> findAll() {
		List<Amministratore> result = em.createNamedQuery("Amministratore.findAll").getResultList();
		return result;
	}

}