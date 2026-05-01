package it.pale.tweb.dao.beans;

import java.util.Date;

public class News {
	private int id ;
	private String testo;
	private Date data;
	private int palestra;

	public News() {
		this.id=0;
		this.testo=null;
		this.data=null;
		this.palestra=0;
	}
	public News(int id, String testo, Date data, int palestra) {

		this.id = id;
		this.testo = testo;
		this.data = data;
		this.palestra = palestra;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getPalestra() {
		return palestra;
	}
	public void setPalestra(int palestra) {
		this.palestra = palestra;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", testo=" + testo + ", data=" + data + ", palestra=" + palestra + "]";
	}




}
