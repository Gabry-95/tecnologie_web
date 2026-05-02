package it.pale.tweb.dao.beans;

import java.util.Date;

public class Abbonamento {
	private int fattura;
	private String tipo;
	private Date dataScadenza;
	private Integer limiteIngressi;
	private int costo;
	private int cliente;
	
	public Abbonamento() {
		this.fattura = 0;
		this.tipo = null;
		this.dataScadenza = null;
		this.limiteIngressi = null;
		this.costo = 0;
		this.cliente = 0;
	}
	
	public Abbonamento(int fattura, String tipo, Date dataScadenza, Integer limiteIngressi, int costo, int cliente) {
		this.fattura = fattura;
		this.tipo = tipo;
		this.dataScadenza = dataScadenza;
		this.limiteIngressi = limiteIngressi;
		this.costo = costo;
		this.cliente = cliente;
	}

	public Abbonamento(int fattura, String tipo, int cliente) {
		
		final int COSTO_STANDARD=30;
		final int COSTO_PREMIUM=40;
		final int COSTO_GOLD=50;
		
		final int LIMITI_INGRSSO=3;
		
		this.fattura = fattura;
		this.tipo = tipo;
		
		//i piani di abbonamento hanno prezzi e limiti di ingrsso fissi
		if(this.tipo.equals("standard")) {
			this.limiteIngressi = LIMITI_INGRSSO;
			this.costo=COSTO_STANDARD;
		}
		else {
			this.limiteIngressi = null;
			if(this.tipo.equals("premium")) {
				this.costo=COSTO_PREMIUM;
			}
			else if(this.tipo.equals("gold")){
				this.costo=COSTO_GOLD;
			}
		}
		
		//CREAZIONE DATA SCADENZA: creiamo data di oggi e aggiungiamo 30 giorni da oggi 
		Date oggi = new Date();
		long mil= oggi.getTime();
		mil += 30*24*60*60*1000;
		Date scadenza= new Date(mil);
		this.dataScadenza = scadenza;
		
		this.cliente = cliente;
	}

	public int getFattura() {
		return fattura;
	}
	
	public void setFattura(int fattura) {
		this.fattura = fattura;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Date getDataScadenza() {
		return dataScadenza;
	}
	
	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	
	public Integer getLimiteIngressi() {
		return limiteIngressi;
	}

	public void setLimiteIngressi(Integer limiteIngressi) {
		this.limiteIngressi = limiteIngressi;
	}

	public int getCosto() {
		return costo;
	}
	
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	public int getCliente() {
		return cliente;
	}
	
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
}
