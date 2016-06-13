package it.uniroma3.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import it.uniroma3.dao.AmministratoreFacade;
import it.uniroma3.dao.UtenteFacade;
import it.uniroma3.model.Amministratore;
import it.uniroma3.model.Utente;

@ManagedBean(name="registrazioneamministratoreBean")
public class RegistrazioneAmministratoreBean {

	@EJB
	private UtenteFacade utente_facade;
	@EJB
	private AmministratoreFacade amministratore_facade;
	private String nome;
	private String cognome;
	private String username;
	private String password;	
	private String passwordConferma;
	private Utente utente;
	private Amministratore amministratore;	
	private String risultatoRegistrazione;

	public String registraUtente() {
		try {
			if (password.equals(passwordConferma)) {
				//			!nome.equals("") && !cognome.equals("") && !username.equals("")
				//			&& !password.equals("") && !passwordConferma.equals("")) {
				Amministratore a = new Amministratore(nome, cognome);
				Utente u = new Utente(username, password);
				u.setRuolo("amministratore");
				this.amministratore = amministratore_facade.save(a);
				u.setAmministratore(amministratore);
				this.utente = utente_facade.save(u);
				this.risultatoRegistrazione="";
				return "confermaRegistrazioneAmministratore";
			}
			else {
				this.risultatoRegistrazione = "Le due password non corrispondono";
				return "registrazioneAmministratore";
			}
		}
		catch (Exception e) {
			this.amministratore_facade.delete(amministratore);
			this.risultatoRegistrazione = "nome utente non valido";
			return "registrazioneAmministratore";
		}
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

	public String getPasswordConferma() {
		return passwordConferma;
	}

	public void setPasswordConferma(String passwordConferma) {
		this.passwordConferma = passwordConferma;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Amministratore getAmministratore() {
		return amministratore;
	}

	public void setAmministratore(Amministratore amministratore) {
		this.amministratore = amministratore;
	}

	public String getRisultatoRegistrazione() {
		return risultatoRegistrazione;
	}

	public void setRisultatoRegistrazione(String risultatoRegistrazione) {
		this.risultatoRegistrazione = risultatoRegistrazione;
	}	

}
