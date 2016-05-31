package it.uniroma3.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.model.Medico;


@Stateless(name="facade")
public class  MedicoFacade {

	@PersistenceContext(unitName = "progetto-siw")
	private EntityManager em;


	public Medico save(Medico p) {
		em.persist(p);
	    return p;

	}

	public Medico findById(long id) {
		Medico c = em.find(Medico.class, id);
		return c;
	}

	public void delete(Medico p) {
		Medico toRemove = em.merge(p);
		em.remove(toRemove);
	}

	public Medico update(Medico p) {
		em.merge(p);
        return p;
	}

	@SuppressWarnings("unchecked")
	public List<Medico> findAll() {
		List<Medico> result = em.createNamedQuery("Medico.findAll").getResultList();
		return result;
	}

}