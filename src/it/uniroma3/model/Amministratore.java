package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Amministratore {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
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
	
	public boolean equals(Object obj) {
		Amministratore amministratore = (Amministratore)obj;
        return this.getNome().equals(amministratore.getNome()) && this.getCognome().equals(amministratore.getCognome());
    }
	
	@Override
	public int hashCode() {
        return this.getNome().hashCode() + this.getCognome().hashCode();
    }
	
	@Override
	public String toString() {
		return "Amministratore [nome=" + nome + ", cognome=" + cognome + "]";
	}
}
