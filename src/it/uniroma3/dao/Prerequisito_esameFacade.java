package it.uniroma3.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.model.Prerequisito_esame;


@Stateless(name="facade")
public class Prerequisito_esameFacade {

	@PersistenceContext(unitName = "progetto-siw")
	private EntityManager em;


	public Prerequisito_esame save(Prerequisito_esame p) {
		em.persist(p);
	    return p;

	}

	public Prerequisito_esame findById(long id) {
		Prerequisito_esame c = em.find(Prerequisito_esame.class, id);
		return c;
	}

	public void delete(Prerequisito_esame p) {
		Prerequisito_esame toRemove = em.merge(p);
		em.remove(toRemove);
	}

	public Prerequisito_esame update(Prerequisito_esame p) {
		em.merge(p);
        return p;
	}

	@SuppressWarnings("unchecked")
	public List<Prerequisito_esame> findAll() {
		List<Prerequisito_esame> result = em.createNamedQuery("Prerequisito_esame.findAll").getResultList();
		return result;
	}

}