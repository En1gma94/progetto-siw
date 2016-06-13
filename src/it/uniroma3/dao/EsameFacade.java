package it.uniroma3.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import it.uniroma3.model.Esame;


@Stateless(name="esame_facade")
public class  EsameFacade {

	@PersistenceContext(unitName = "clinica-unit")
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
		List<Esame> result = em.createNamedQuery("Esame.findAllEsami").getResultList();
		return result;
	}
	
	public List<Esame> getEsami(long id) {
		try {
			List<Esame> esami = new ArrayList<Esame>();
			TypedQuery<Esame> userQuery = em.createQuery("SELECT e FROM Esame e WHERE e.medico.id = :id", Esame.class).setParameter("id", id);
			esami = userQuery.setParameter("id", id).getResultList();
			return esami;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<Esame> getEsamiPaziente(long id) {
		try {
			List<Esame> esami = new ArrayList<Esame>();
			TypedQuery<Esame> userQuery = em.createQuery("SELECT e FROM Esame e WHERE e.paziente.id = :id", Esame.class).setParameter("id", id);
			esami = userQuery.setParameter("id", id).getResultList();
			return esami;
		}
		catch(Exception e){
			return null;
		}
	}

}