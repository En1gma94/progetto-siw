package it.uniroma3.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import it.uniroma3.model.Utente;


@Stateless(name="utente_facade")
public class UtenteFacade {

	@PersistenceContext(unitName = "clinica-unit")
	private EntityManager em;


	public Utente save(Utente p) {
		em.persist(p);
	    return p;

	}

	public Utente findById(long id) {
		Utente c = em.find(Utente.class, id);
		return c;
	}

	public void delete(Utente p) {
		Utente toRemove = em.merge(p);
		em.remove(toRemove);
	}

	public Utente update(Utente p) {
		em.merge(p);
        return p;
	}
	
	public Boolean checkPassword(Utente utente, String password) {
		return utente.getPassword().equals(password);
	}

	@SuppressWarnings("unchecked")
	public List<Utente> findAll() {
		List<Utente> result = em.createNamedQuery("Utente.findAllUsers").getResultList();
		return result;
	}
	
	public Utente getUtente(String username, String password) {
		try {
			Utente utente = new Utente();
			TypedQuery<Utente> userQuery = em.createQuery("SELECT u FROM Utente u WHERE u.username = :username AND u.password = :password", Utente.class).setParameter("username", username).setParameter("password", password);
			utente = userQuery.setParameter("username", username).setParameter("password", password).getSingleResult();
			return utente;
		}
		catch(Exception e){
			return null;
		}
	}
}