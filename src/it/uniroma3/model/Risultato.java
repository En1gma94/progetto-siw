package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Risultato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(nullable = false)
	@ManyToOne
	private Esame esame;
	
	@Column(nullable = false)
	@ManyToOne
	private Indicatore_Esame indicatore_Esame;
	
	@Column(nullable = false)
	private String valore;
	
	public Risultato() { }
	
	public Risultato (String valore) {
		this.valore = valore;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Esame getEsame() {
		return esame;
	}

	public void setEsame(Esame esame) {
		this.esame = esame;
	}

	public Indicatore_Esame getIndicatore_Esame() {
		return indicatore_Esame;
	}

	public void setIndicatore_Esame(Indicatore_Esame indicatore_Esame) {
		this.indicatore_Esame = indicatore_Esame;
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}
}
