package it.uniroma3.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import it.uniroma3.model.*;
import it.uniroma3.dao.*;

@ManagedBean(name="consultamedicoBean")
public class ConsultaMedicoBean {

	@EJB
	private EsameFacade esame_facade;
	@EJB
	private MedicoFacade medico_facade;
	private String nome;
	private String cognome;
	private Medico medico;
	private long id_medico;
	private List<Esame> esami;
	private String risultatoErrore;


	public String esamiMedico() {
		this.medico = medico_facade.getMedico(nome, cognome);
		if(this.medico == null) {
			this.risultatoErrore = "MEDICO NON TROVATO";
		    return "esamiMedico";
		}
//		Medico m = new Medico("paolo", "rossi", "cc");
//		m.setId(5); 
//		this.id_medico = m.getId();
		this.id_medico = this.medico.getId();	
		this.esami = new ArrayList<>();
	    this.esami = esame_facade.getEsami(this.id_medico);
//		Date d = new Date();
//		Esame e = new Esame(d);
//		Utente u = new Utente("mario", "rossi");
//		this.esami.add(u);		
		return "ritornoEsamiMedico";
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
	
	public EsameFacade getEsame_facade() {
		return esame_facade;
	}


	public void setEsame_facade(EsameFacade esame_facade) {
		this.esame_facade = esame_facade;
	}
	
	public MedicoFacade getMedico_facade() {
		return medico_facade;
	}


	public void setMedico_facade(MedicoFacade medico_facade) {
		this.medico_facade = medico_facade;
	}


	public Medico getMedico() {
		return medico;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	public long getId_medico() {
		return id_medico;
	}


	public void setId_medico(long id_medico) {
		this.id_medico = id_medico;
	}


	public List<Esame> getEsami() {
		return esami;
	}


	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}


	public String getRisultatoErrore() {
		return risultatoErrore;
	}


	public void setRisultatoErrore(String risultatoErrore) {
		this.risultatoErrore = risultatoErrore;
	}


}
