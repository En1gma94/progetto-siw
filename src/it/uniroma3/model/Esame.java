package it.uniroma3.model;

import java.util.Date;

public class Esame {
private long id;
private Date data_prenotazione, data_effettuazione;

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
