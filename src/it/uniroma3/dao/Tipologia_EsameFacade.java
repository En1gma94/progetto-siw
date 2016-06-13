package it.uniroma3.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.model.Tipologia_Esame;


@Stateless(name="facade")
public class Tipologia_EsameFacade {

	@PersistenceContext(unitName = "progetto-siw")
	private EntityManager em;


	public Tipologia_Esame save(Tipologia_Esame p) {
		em.persist(p);
	    return p;

	}

	public Tipologia_Esame findById(long id) {
		Tipologia_Esame c = em.find(Tipologia_Esame.class, id);
		return c;
	}

	public void delete(Tipologia_Esame p) {
		Tipologia_Esame toRemove = em.merge(p);
		em.remove(toRemove);
	}

	public Tipologia_Esame update(Tipologia_Esame p) {
		em.merge(p);
        return p;
	}

	@SuppressWarnings("unchecked")
	public List<Tipologia_Esame> findAll() {
		List<Tipologia_Esame> result = em.createNamedQuery("Tipologia_Esame.findAll").getResultList();
		return result;
	}

}