package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Paziente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false)
	private String codicefiscale;

	@OneToMany(mappedBy = "paziente", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Esame> esami; 

	public Paziente(String nome, String cognome, String codiceFiscale) {
		this.nome = nome;
		this.cognome = cognome;
		this.codicefiscale = codiceFiscale;
		this.esami = new ArrayList<Esame>();
	}
	
	public Paziente() {}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public List<Esame> getEsami() {
		if (esami==null) {
			esami = new ArrayList<>();
			return esami;
		}
		return esami;
	}

	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}
	
	public String getCodicefiscale() {
		return codicefiscale;
	}

	public void setCodicefiscale(String codiceFiscale) {
		this.codicefiscale = codiceFiscale;
	}

	@Override
	public int hashCode() {
		return this.getNome().hashCode() + 
				this.getCognome().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Paziente a = (Paziente)obj;
		return this.nome.equals(a.getNome()) 
				&& this.cognome.equals(a.getCognome());
	}

	@Override
	public String toString() {
		return cognome + " " + nome; 
	}
	
	public void stampaEsami() {
		for (Esame e : this.esami)
			System.out.println(e.getId());
	}

}
