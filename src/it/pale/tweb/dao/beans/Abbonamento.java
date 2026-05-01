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

	public Abbonamento(int fattura, String tipo, Date dataScadenza, int costo,
			int cliente) {
		this.fattura = fattura;
		this.tipo = tipo;
		this.dataScadenza = dataScadenza;
		if(this.tipo.equals("standard")) {
			this.limiteIngressi = 3;
		}
		else {
			this.limiteIngressi = null;
		}
		this.costo = costo;
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
