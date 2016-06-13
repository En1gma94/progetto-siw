package it.uniroma3.beans;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import it.uniroma3.dao.AmministratoreFacade;
import it.uniroma3.dao.EsameFacade;
import it.uniroma3.dao.PazienteFacade;
import it.uniroma3.dao.RisultatoFacade;
import it.uniroma3.dao.UtenteFacade;
import it.uniroma3.model.Amministratore;
import it.uniroma3.model.Esame;
import it.uniroma3.model.Paziente;
import it.uniroma3.model.Risultato;
import it.uniroma3.model.Utente;

@ManagedBean(name="UtenteController")
@SessionScoped
public class LoginBean {

	@EJB
	private UtenteFacade utente_facade;
	@EJB
	private AmministratoreFacade amministratore_facade;
	@EJB
	private PazienteFacade paziente_facade;
	@EJB
	private EsameFacade esame_facade;
	@EJB
	private RisultatoFacade risultato_facade;
	private List<Esame> esami;
    private java.util.Date data_effettuazione;
    private java.util.Date data_prenotazione;
	private String username;
	private String password;
	private Utente utente;
	private Paziente paziente;
	private Amministratore amministratore;
	private String risultatoAutenticazione;
	private List<Risultato> risultati;
	private Esame item;
	
	
	public String loginUtente(){
		this.utente = utente_facade.getUtente(username, password);
        FacesContext context = FacesContext.getCurrentInstance();
		
		if(utente==null || !utente_facade.checkPassword(utente, password)){
			this.utente = null;
			this.risultatoAutenticazione = "USERNAME O PASSWORD ERRATI";
			return "login";
		}
		else if (utente.getRuolo().equals("paziente")){
			this.risultatoAutenticazione="";
			this.paziente=paziente_facade.findById(utente.getPaziente().getId());
            context.getExternalContext().getSessionMap().put("paziente", paziente);
            return "benvenutoPaziente?faces-redirect=true";
		}
		else if (utente.getRuolo().equals("amministratore")) {
			this.risultatoAutenticazione="";
			this.amministratore=amministratore_facade.findById(utente.getAmministratore().getId());
            context.getExternalContext().getSessionMap().put("amministratore", amministratore);
            return "benvenutoAmministratore?faces-redirect=true";
		}
		else 
			return "errore";
	}
	
	public String logoutUtente() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "home?faces-redirect=true";
    }
	
	
	public String mostraEsami (long id) {
		this.esami = new ArrayList<>();
		this.esami = this.esame_facade.getEsamiPaziente(id);
		return "esamiEffettuati";
	}
	
	public String mostraRisultati (long id) {
		this.risultati = new ArrayList<>();
		this.risultati = this.risultato_facade.getRisultatiByEsame(id);
		return "risultatoEsameEffettuato";
	}
	
	public void isPaziente(){
		FacesContext fc = FacesContext.getCurrentInstance();
		ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler)fc.getApplication().getNavigationHandler();		
		if(paziente==null)
		nav.performNavigation("errore");
	  }	
	
	public void isAmministratore(){
		FacesContext fc = FacesContext.getCurrentInstance();
		ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler)fc.getApplication().getNavigationHandler();		
		if(amministratore==null)
		nav.performNavigation("errore");
	  }	
	
	public UtenteFacade getUtente_facade() {
		return utente_facade;
	}

	public void setUtente_facade(UtenteFacade utente_facade) {
		this.utente_facade = utente_facade;
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
 
	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public Amministratore getAmministratore() {
		return amministratore;
	}

	public void setAmministratore(Amministratore amministratore) {
		this.amministratore = amministratore;
	}

	public String getRisultatoAutenticazione() {
		return risultatoAutenticazione;
	}

	public void setRisultatoAutenticazione(String risultatoAutenticazione) {
		this.risultatoAutenticazione = risultatoAutenticazione;
	}

	public AmministratoreFacade getAmministratore_facade() {
		return amministratore_facade;
	}

	public void setAmministratore_facade(AmministratoreFacade amministratore_facade) {
		this.amministratore_facade = amministratore_facade;
	}

	public PazienteFacade getPaziente_facade() {
		return paziente_facade;
	}

	public void setPaziente_facade(PazienteFacade paziente_facade) {
		this.paziente_facade = paziente_facade;
	}

	public List<Esame> getEsami() {
		return esami;
	}

	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}

	public java.util.Date getData_effettuazione() {
		return data_effettuazione;
	}

	public void setData_effettuazione(java.util.Date data_effettuazione) {
		this.data_effettuazione = data_effettuazione;
	}

	public java.util.Date getData_prenotazione() {
		return data_prenotazione;
	}

	public void setData_prenotazione(java.util.Date data_prenotazione) {
		this.data_prenotazione = data_prenotazione;
	}

	public List<Risultato> getRisultati() {
		return risultati;
	}

	public void setRisultati(List<Risultato> risultati) {
		this.risultati = risultati;
	}

	public Esame getItem() {
		return item;
	}

	public void setItem(Esame item) {
		this.item = item;
	}
}