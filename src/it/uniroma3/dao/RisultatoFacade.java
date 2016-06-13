package it.uniroma3.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import it.uniroma3.model.Risultato;

@Stateless(name="risultato_facade")
public class RisultatoFacade {
	
	@PersistenceContext(unitName = "clinica-unit")
	private EntityManager em;
	
	public Risultato save(Risultato p) {
		em.persist(p);
	    return p;

	}

	public Risultato findById(long id) {
		Risultato c = em.find(Risultato.class, id);
		return c;
	}

	public void delete(Risultato p) {
		Risultato toRemove = em.merge(p);
		em.remove(toRemove);
	}

	public Risultato update(Risultato p) {
		em.merge(p);
        return p;
	}

	@SuppressWarnings("unchecked")
	public List<Risultato> findAll() {
		List<Risultato> result = em.createNamedQuery("Risultato.findAllEsami").getResultList();
		return result;
	}
	
	public List<Risultato> getRisultatiByEsame(long id) {
		try {
			List<Risultato> risultati = new ArrayList<Risultato>();
			TypedQuery<Risultato> userQuery = em.createQuery("SELECT e FROM Risultato e WHERE e.esame.id = :id", Risultato.class).setParameter("id", id);
			risultati = userQuery.setParameter("id", id).getResultList();
			return risultati;
		}
		catch(Exception e){
			return null;
		}
	}

}
