package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(unique = true, nullable=false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String ruolo;
	
	@OneToOne
	@JoinColumn(nullable = true)
	private Amministratore amministratore;
	
	@OneToOne
	@JoinColumn(nullable = true)
	private Paziente paziente;
	
	public Utente() {} 
	
	public Utente(String username, String password) {
		this.username = username;
		this.password = password;
		} 

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	public Amministratore getAmministratore() {
		return amministratore;
	}

	public void setAmministratore(Amministratore amministratore) {
		this.amministratore = amministratore;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	@Override
    public boolean equals(Object obj) {
		Utente utente = (Utente)obj;
        return this.getUsername().equals(utente.getUsername());
    }
	
	@Override
	public int hashCode() {
        return this.getUsername().hashCode();
	}

	@Override
	public String toString() {
		return "Utente [username=" + username 
				+ ", password=" + password 
				+ ", ruolo=" + ruolo 
				+ ", amministratore=" + amministratore 
				+ ", paziente=" + paziente + "]";
	}

}
