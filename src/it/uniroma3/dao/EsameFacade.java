package it.uniroma3.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.model.Esame;


@Stateless(name="facade")
public class  EsameFacade {

	@PersistenceContext(unitName = "progetto-siw")
	private EntityManager em;


	public Esame save(Esame p) {
		em.persist(p);
	    return p;

	}

	public Esame findById(long id) {
		Esame c = em.find(Esame.class, id);
		return c;
	}

	public void delete(Esame p) {
		Esame toRemove = em.merge(p);
		em.remove(toRemove);
	}

	public Esame update(Esame p) {
		em.merge(p);
        return p;
	}

	@SuppressWarnings("unchecked")
	public List<Esame> findAll() {
		List<Esame> result = em.createNamedQuery("Esame.findAll").getResultList();
		return result;
	}

}