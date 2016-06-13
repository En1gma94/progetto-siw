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
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false)
	private String specializzazione;

	@OneToMany(mappedBy = "medico",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Esame> esami;
	
	public Medico(String nome, String cognome, String specializzazione) {
		this.nome = nome;
		this.cognome = cognome;
		this.specializzazione = specializzazione;
		this.esami = new ArrayList<>();
	}
	
	public Medico() {
		this.esami = new ArrayList<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
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

	public String getSpecializzazione() {
		return specializzazione;
	}

	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}
	
	public List<Esame> getEsami() {
		if (this.esami==null){
			this.esami = new ArrayList<>();
		}
		return this.esami;
	}

	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode() + 
				this.getCognome().hashCode() + 
				this.getSpecializzazione().hashCode(); 
	}
	
	@Override
	public boolean equals(Object obj) {
		Medico a = (Medico)obj;
		return this.nome.equals(a.getNome()) 
				&& this.cognome.equals(a.getCognome())
				&& this.specializzazione.equals(a.getSpecializzazione()); 
	}

	@Override
	public String toString() {
		return "Medico [nome=" + nome 
				+ ", cognome=" + cognome 
				+ ", specializzazione=" + specializzazione + "]";
	}
	
	public void stampaEsami() {
		for (Esame e : this.esami)
			System.out.println(e.getId());
	}
	
}
