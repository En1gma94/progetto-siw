package it.uniroma3.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import it.uniroma3.dao.EsameFacade;
import it.uniroma3.dao.MedicoFacade;
import it.uniroma3.dao.PazienteFacade;
import it.uniroma3.dao.Tipologia_EsameFacade;
import it.uniroma3.model.Esame;
import it.uniroma3.model.Medico;
import it.uniroma3.model.Paziente;
import it.uniroma3.model.Tipologia_Esame;


@ManagedBean(name="CreaEsameBean")
public class CreaEsameBean {

	@EJB
	private PazienteFacade paziente_facade;
	@EJB
	private MedicoFacade medico_facade;
	@EJB
	private Tipologia_EsameFacade tipologia_facade;
	@EJB
	private EsameFacade esame_facade;

	private String dataEffettuazione;
	private String codiceFiscale;
	private String tipologia;
	private String nomeMedico;
	private String cognomeMedico;

	private Esame esame;

	private String avvertimento;

	public String aggiungiEsame() throws java.text.ParseException {
		try {
			Date dataDaInserire = fromTo(dataEffettuazione); 
			Paziente paziente = paziente_facade.getByCF(codiceFiscale);
			Medico medico = medico_facade.getMedico(nomeMedico, cognomeMedico);
			Tipologia_Esame tipologia_Esame = tipologia_facade.getTipologia(tipologia);
			if (paziente!=null && tipologia_Esame!=null && medico!=null) {
				Esame e = new Esame();
				e.setMedico(medico);
				e.setPaziente(paziente);
				e.setTipologia_esame(tipologia_Esame);
				e.setData_effettuazione(dataDaInserire);
				e.setData_prenotazione(new java.sql.Date(new java.util.Date().getTime()));
				e.setPrezzo(tipologia_Esame.getPrezzo());
				this.esame = esame_facade.save(e);
				paziente.getEsami().add(esame);
				medico.getEsami().add(esame);
				this.avvertimento = "";
				return "aggiuntaEsameCompletata";
			}
			else {
				if (paziente==null) {
					this.avvertimento = "paziente non esistente";
				}
				else if (medico==null) {
					this.avvertimento = "medico non esistente";
				}
				else if (tipologia_Esame==null) {
					this.avvertimento = "tipologia dell'esame non esistente";
				}
				else this.avvertimento = "dati inseriti errati";
				return "creaEsame";
			}
		}
		catch (Exception e) {
			this.avvertimento = "formato data non valido";
			return "creaEsame";
		}
	}

	public String getDataEffettuazione() {
		return dataEffettuazione;
	}
	public void setDataEffettuazione(String dataEffettuazione) {
		this.dataEffettuazione = dataEffettuazione;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getNomeMedico() {
		return nomeMedico;
	}
	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}
	public String getCognomeMedico() {
		return cognomeMedico;
	}

	public void setCognomeMedico(String cognomeMedico) {
		this.cognomeMedico = cognomeMedico;
	}

	public Esame getEsame() {
		return esame;
	}
	public void setEsame(Esame esame) {
		this.esame = esame;
	}

	public String getAvvertimento() {
		return avvertimento;
	}

	public void setAvvertimento(String avvertimento) {
		this.avvertimento = avvertimento;
	}

	private static Date fromTo (String dateString) throws java.text.ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date date = formatter.parse(dateString);
			return date;

		} catch (ParseException e) {
			return null;
		}
	}
}
