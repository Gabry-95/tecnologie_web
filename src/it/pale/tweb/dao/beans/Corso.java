package it.pale.tweb.dao.beans;


public class Corso {
	private int id;
	private String nome;
	private int anno;
	private int costo;
	private String tipo;
	private int palestra;

	public Corso() {
		this.id=0;
		this.nome=null;
		this.anno=0;
		this.costo=0;
		this.tipo=null;
		this.palestra=0;
	}

	public Corso(int id, String nome, int anno, int costo, String tipo, int palestra) {

		this.id = id;
		this.nome = nome;
		this.anno = anno;
		this.costo = costo;
		this.tipo = tipo;
		this.palestra = palestra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPalestra() {
		return palestra;
	}

	public void setPalestra(int palestra) {
		this.palestra = palestra;
	}

	@Override
	public String toString() {
		return "Corso [id=" + id + ", nome=" + nome + ", anno=" + anno + ", costo=" + costo + ", tipo=" + tipo
				+ ", palestra=" + palestra + "]";
	}


}


