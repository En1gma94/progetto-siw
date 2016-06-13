package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Tipologia_Esame.findAllTipologie", query = "SELECT t FROM Tipologia_Esame t")
public class Tipologia_Esame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(length = 2000)
	private String descrizione;
	
	private float prezzo;
	
	@ManyToMany
	private List<Indicatore_Esame> indicatori; 
	
	@ManyToMany
	private List<Prerequisito_esame> prerequisiti;
	
	@ManyToMany
	private List<Medico> medici;
	
	public Tipologia_Esame(String nome, String descrizione, float prezzo) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.indicatori = new ArrayList<>();
		this.prerequisiti = new ArrayList<>();
		this.medici = new ArrayList<>();
	}
	
	public Tipologia_Esame() {}
	
	public List<Medico> getMedici() {
		return medici;
	}
	
	public void setMedici(List<Medico> medici) {
		this.medici = medici;
	}
	
	public List<Indicatore_Esame> getIndicatori() {
		return indicatori;
	}
	
	public void setIndicatori(List<Indicatore_Esame> indicatori) {
		this.indicatori = indicatori;
	}
	
	public List<Prerequisito_esame> getPrerequisiti() {
		return prerequisiti;
	}
	
	public void setPrerequisiti(List<Prerequisito_esame> prerequisiti) {
		this.prerequisiti = prerequisiti;
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
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public float getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		Tipologia_Esame a = (Tipologia_Esame)obj;
		return this.nome.equals(a.getNome());
	}
	
	@Override
	public String toString() {
		return "nome=" + nome 
				+ ", descrizione=" + descrizione 
				+ ", prezzo=" + prezzo;
	}
	
}
