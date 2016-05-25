package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prerequisito_esame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String nome;

	@Column(length = 2000)
	private String descrizione;

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
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode();				
	}
	
	@Override
	public boolean equals(Object obj) {
		Prerequisito_esame a = (Prerequisito_esame)obj;
		return this.nome.equals(a.getNome());
	}
	@Override
	public String toString() {
		return "Prerequisito_esame [nome=" + nome + ", descrizione=" + descrizione + "]";
	}

	
}
