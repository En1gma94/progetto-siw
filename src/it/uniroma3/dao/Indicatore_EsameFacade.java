package it.uniroma3.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.model.Indicatore_Esame;


@Stateless(name="indicatore_facade")
public class  Indicatore_EsameFacade {

	@PersistenceContext(unitName = "clinica-unit")
	private EntityManager em;


	public Indicatore_Esame save(Indicatore_Esame p) {
		em.persist(p);
	    return p;

	}

	public Indicatore_Esame findById(long id) {
		Indicatore_Esame c = em.find(Indicatore_Esame.class, id);
		return c;
	}

	public void delete(Indicatore_Esame p) {
		Indicatore_Esame toRemove = em.merge(p);
		em.remove(toRemove);
	}

	public Indicatore_Esame update(Indicatore_Esame p) {
		em.merge(p);
        return p;
	}

	@SuppressWarnings("unchecked")
	public List<Indicatore_Esame> findAll() {
		List<Indicatore_Esame> result = em.createNamedQuery("Indicatore_Esame.findAll").getResultList();
		return result;
	}

}