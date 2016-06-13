package it.uniroma3.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import it.uniroma3.model.*;
import it.uniroma3.dao.*;

@ManagedBean(name="registrazioneutenteBean")
public class RegistrazioneUtenteBean {

	@EJB
	private UtenteFacade utente_facade;
	@EJB
	private PazienteFacade paziente_facade;
	private String nome;
	private String cognome;
	private String username;
	private String password;	
	private String passwordConferma;
	private Utente utente;
	private Paziente paziente;	
	private String risultatoRegistrazione;
	private String codiceFiscale;

	public String registraUtente() {
		try {
			if (password.equals(passwordConferma)) {
				//			!nome.equals("") && !cognome.equals("") && !username.equals("")
				//			&& !password.equals("") && !passwordConferma.equals("")) {
				Paziente p = new Paziente(nome, cognome, codiceFiscale);
				Utente u = new Utente(username, password);
				u.setRuolo("paziente");
				this.paziente = paziente_facade.save(p);
				u.setPaziente(paziente);
				this.utente = utente_facade.save(u);
				this.risultatoRegistrazione="";
				return "confermaRegistrazione";
			}
			else {
				this.risultatoRegistrazione = "Le due password non corrispondono";
				return "registrazione";
			}
		}
		catch (Exception e) {
			this.paziente_facade.delete(paziente);
			this.risultatoRegistrazione = "nome utente non valido";
			return "registrazione";
		}
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

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public UtenteFacade getUtente_facade() {
		return utente_facade;
	}

	public void setUtente_facade(UtenteFacade utente_facade) {
		this.utente_facade = utente_facade;
	}

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

	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public PazienteFacade getPaziente_facade() {
		return paziente_facade;
	}

	public void setPaziente_facade(PazienteFacade paziente_facade) {
		this.paziente_facade = paziente_facade;
	}

	public String getPasswordConferma() {
		return passwordConferma;
	}

	public void setPasswordConferma(String passwordConferma) {
		this.passwordConferma = passwordConferma;
	}

	public String getRisultatoRegistrazione() {
		return risultatoRegistrazione;
	}

	public void setRisultatoRegistrazione(String risultatoRegistrazione) {
		this.risultatoRegistrazione = risultatoRegistrazione;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

}
