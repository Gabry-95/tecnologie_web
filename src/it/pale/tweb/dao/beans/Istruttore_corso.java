package it.pale.tweb.dao.beans;

public class Istruttore_corso {
	private int matricola;
	private String nome;
	private String cognome;
	private int palestra;
	private long telefono;

	public Istruttore_corso() {
		this.matricola=0;
		this.nome=null;
		this.cognome=null;
		this.palestra=0;
		this.telefono=0;
	}

	public Istruttore_corso(int matricola, String nome, String cognome, int palestra, long telefono) {

		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.palestra = palestra;
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

	public int getPalestra() {
		return palestra;
	}

	public void setPalestra(int palestra) {
		this.palestra = palestra;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Istruttore_corso [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", palestra="
				+ palestra + ", telefono=" + telefono + "]";
	}

}
