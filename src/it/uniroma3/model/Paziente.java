package it.uniroma3.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Paziente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@OneToMany(mappedBy = "paziente")
	private List<Esame> esami; 
	
	
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
		return esami;
	}
	public void setEsami(List<Esame> esami) {
		this.esami = esami;
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
		return "Paziente [nome=" + nome 
				+ ", cognome=" + cognome 
				+ "]";
	}
}
