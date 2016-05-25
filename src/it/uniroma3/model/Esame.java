package it.uniroma3.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Esame {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	@Temporal (TemporalType.DATE)
    private java.util.Date data_prenotazione;
	
	@Column(nullable = false)
	@Temporal (TemporalType.DATE)
    private java.util.Date data_effettuazione;

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

}
