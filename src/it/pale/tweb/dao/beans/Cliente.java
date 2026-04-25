package it.pale.tweb.dao.beans;

public class Cliente {
	private int matricola;
	private String nome;
	private String cognome;
	private long telefono;// siccome ha 13 cifre 9+prefisso

	public Cliente() {
		this.matricola=0;
		this.nome=null;
		this.cognome=null;
		this.telefono=0;

	}
	public Cliente(int matricola, String nome, String cognome, long telefono) {

		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
	}
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
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
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}




}
