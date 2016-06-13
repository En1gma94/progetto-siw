package it.uniroma3.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.uniroma3.model.*;
import it.uniroma3.dao.*;

@ManagedBean(name="consultaTipologieBean")
@SessionScoped
public class ConsultaTipologieBean {

	@EJB
	private Tipologia_EsameFacade tipologia_facade;
	private List<Tipologia_Esame> tipologie;
	private String nome;
	private String descrizione;
	private float prezzo;
	private Tipologia_Esame item;
	
	public String mostraTipologie() {
		this.tipologie = new ArrayList<>();
        this.tipologie = tipologia_facade.findAll();
		return "elencoTipologieEsami";
	}
	
	public String mostraDettagli(long id) {
	    Tipologia_Esame tipologia = tipologia_facade.findById(id);
	    this.nome = tipologia.getNome();
	    this.descrizione = tipologia.getDescrizione();
	    this.setPrezzo(tipologia.getPrezzo());
		return "dettaglioTipologia";
	}
	
	public Tipologia_EsameFacade getTipologia_facade() {
		return tipologia_facade;
	}
	
	public void setTipologia_facade(Tipologia_EsameFacade tipologia_facade) {
		this.tipologia_facade = tipologia_facade;
	}
	
	public List<Tipologia_Esame> getTipologie() {
		return tipologie;
	}
	
	public void setTipologie(List<Tipologia_Esame> tipologie) {
		this.tipologie = tipologie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public Tipologia_Esame getItem() {
		return item;
	}

	public void setItem(Tipologia_Esame item) {
		this.item = item;
	}
	
}
