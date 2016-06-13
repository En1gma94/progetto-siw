package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Indicatore_Esame {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(nullable = false)
	private String nome;
	
	public Indicatore_Esame(String nome) {
		this.nome = nome;
	}
	
	public Indicatore_Esame() {}
	
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

	@Override
	public int hashCode() {
		return this.getNome().hashCode();				
	}
	
	@Override
	public boolean equals(Object obj) {
		Indicatore_Esame a = (Indicatore_Esame)obj;
		return this.nome.equals(a.getNome());
	}
	
	@Override
	public String toString() {
		return "Indicatore_Esame [nome=" + nome + "]";
	}

}
