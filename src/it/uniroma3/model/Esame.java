package it.uniroma3.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Esame {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(nullable = false)
	@Temporal (TemporalType.DATE)
    private java.util.Date data_prenotazione;
	
	@Column(nullable = false)
	@Temporal (TemporalType.DATE)
    private java.util.Date data_effettuazione;
	
	@ManyToOne
	private Paziente paziente;
	
	@ManyToOne
	private Tipologia_Esame tipologia_esame;
	
	@ManyToOne
	private Medico medico;
	
	private float prezzo;
	
	@OneToMany(mappedBy = "esame", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Risultato> risultati;
	
	public Esame(Date data_effettuazione) {
		this.data_prenotazione = new java.sql.Date(new java.util.Date().getTime());
		this.data_effettuazione = data_effettuazione;
		this.risultati = new ArrayList<>();
	}
	
	public Esame() {}
	
	public Medico getMedico() {
		return medico;
	}
	
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	public Paziente getPaziente() {
		return paziente;
	}
	
	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}
	
	public Tipologia_Esame getTipologia_esame() {
		return tipologia_esame;
	}
	
	public void setTipologia_esame(Tipologia_Esame tipologia_esame) {
		this.tipologia_esame = tipologia_esame;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getData_prenotazione() {
		return data_prenotazione;
	}
	
	public void setData_prenotazione(Date data_prenotazione) {
		this.data_prenotazione = data_prenotazione;
	}
	
	public Date getData_effettuazione() {
		return data_effettuazione;
	}
	
	public void setData_effettuazione(Date data_effettuazione) {
		this.data_effettuazione = data_effettuazione;
	}
	
	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public List<Risultato> getRisultati() {
		return risultati;
	}

	public void setRisultati(List<Risultato> risultati) {
		this.risultati = risultati;
	}

	@Override
	public int hashCode() {
		return this.getData_effettuazione().hashCode() + 
				this.getData_prenotazione().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		Esame a = (Esame)obj;
		return this.data_effettuazione.equals(a.getData_effettuazione()) 
				&& this.data_prenotazione.equals(a.getData_prenotazione());
	}
	
	@Override
	public String toString() {
		return "Esame [data_prenotazione=" + data_prenotazione 
				+ ", data_effettuazione=" + data_effettuazione
				+ ", paziente=" + paziente 
				+ ", tipologia_esame=" + tipologia_esame 
				+ ", medico=" + medico + "]";
	}
}