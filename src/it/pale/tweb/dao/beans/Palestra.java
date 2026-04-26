package it.pale.tweb.dao.beans;

public class Palestra {
	private int id;
	private long telefono; //considerando anche il prefisso, quindi 12 cifre
	private int cap;
	private String via;
	private String citta;

	public Palestra() {
		this.id=0;
		this.telefono=0;
		this.cap=0;
		this.via=null;
		this.citta=null;
	}


	public Palestra(int id, long telefono, int cap, String via, String citta) {

		this.id = id;
		this.telefono=telefono;
		this.cap = cap;
		this.via = via;
		this.citta = citta;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public long getTelefono() {
		return telefono;
	}


	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}


	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}


	@Override
	public String toString() {
		return "Palestra [id=" + id + ", telefono=" + telefono + ", cap=" + cap + ", via=" + via + ", citta=" + citta
				+ "]";
	}






}
