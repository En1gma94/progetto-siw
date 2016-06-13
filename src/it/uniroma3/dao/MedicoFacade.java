package it.uniroma3.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import it.uniroma3.model.Medico;


@Stateless(name="medico_facade")
public class  MedicoFacade {

	@PersistenceContext(unitName = "clinica-unit")
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
	
	public Medico getMedico(String nome, String cognome) {
		try {
			Medico medico = new Medico();
			TypedQuery<Medico> userQuery = em.createQuery("SELECT m FROM Medico m WHERE m.nome = :nome AND m.cognome = :cognome", Medico.class).setParameter("nome", nome).setParameter("cognome", cognome);
			medico = userQuery.setParameter("nome", nome).setParameter("cognome", cognome).getSingleResult();
			return medico;
		}
		catch(Exception e){
			return null;
		}
	}

}