package it.uniroma3.dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import it.uniroma3.model.Esame;
import it.uniroma3.model.Paziente;

@Stateless(name="paziente_facade")
public class PazienteFacade {

	@PersistenceContext(unitName = "clinica-unit")
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
	
	public Paziente getPaziente(String nome, String cognome) {
		try {
			Paziente paziente = new Paziente();
			TypedQuery<Paziente> userQuery = em.createQuery("SELECT p FROM Paziente p WHERE p.nome = :nome AND p.cognome = :cognome", Paziente.class).setParameter("nome", nome).setParameter("cognome", cognome);
			paziente = userQuery.setParameter("nome", nome).setParameter("cognome", cognome).getSingleResult();
			return paziente;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<Esame> getEsami(long paziente_id) {
		try {
			List<Esame> esami = new ArrayList<>();
			TypedQuery<Esame> esamiQuery = em.createQuery("SELECT e FROM Esame e WHERE e.paziente.id = :paziente_id", Esame.class).setParameter("paziente_id", paziente_id);
			esami = esamiQuery.setParameter("paziente_id", paziente_id).getResultList();
			return esami;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<Esame> getEsame(long esame_id) {
		try {
			List<Esame> esami = new ArrayList<>();
			TypedQuery<Esame> esameQuery = em.createQuery("SELECT e FROM Esame e WHERE e.tipologia_esame.id = :esame_id", Esame.class).setParameter("esame_id", esame_id);
			esami = esameQuery.setParameter("esame_id", esame_id).getResultList();
			return esami;}
		catch(Exception e){
			return null;
		}
	}
	
	public Paziente getByCF(String codicefiscale) {
		try {
			Paziente paziente = new Paziente();
			TypedQuery<Paziente> userQuery = em.createQuery("SELECT p FROM Paziente p WHERE p.codicefiscale = :codicefiscale", Paziente.class).setParameter("codicefiscale", codicefiscale);
			paziente = userQuery.setParameter("codicefiscale", codicefiscale).getSingleResult();
			return paziente;
		}
		catch(Exception e){
			return null;
		}
	}
}