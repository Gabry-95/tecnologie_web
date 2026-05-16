package it.pale.tweb.dao.test;

import java.util.Vector;

import it.pale.tweb.dao.beans.Abbonamento;
import it.pale.tweb.dao.beans.Cliente;
import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.beans.CorsoDAO;
import it.pale.tweb.dao.beans.Palestra;

public class TestCorso {
	public static void main (String [] args) {
		CorsoDAO corsoDAO= new CorsoDAO();
		Corso corso= new Corso();

		corso.setId(90);
		corso.setNome("Yoga");
		corso.setCosto(50);
		corso.setTipo("Gold");
		corso.setPalestra(1); //siccome FK va messo obbligatoriamente un valore esistente dal DB, i valori precedenti sono inventati.

		//METODO SALVA 
		//	if (corsoDAO.salva(corso)) {
		//		System.out.println("Salvato " + corso);
		//	}
		//METODO MODIFICA 

		//	corso.setNome("Boxe");
		//	corso.setCosto(30);
		//	corso.setTipo("Gold");
		//	corso.setPalestra(1);
		//	
		//	if(corsoDAO.modifica(corso)) {
		//		System.out.println("Modificato " + corso);
		//	}
		//METODO GET 
		//	corso=corsoDAO.get(corso);
		//	System.out.println("Riletto " +corso);

		//METODO GET ALL
		//	Vector<Corso> corsos= corsoDAO.getAll();
		//	for (Corso c:corsos) {
		//		System.out.println(c);
		//	}
		//	corsoDAO.elimina(corso);
		//	corso=corsoDAO.get(corso);
		//	System.out.println(corso);
		//	
		//METODO ELIMINA

		//	if(corsoDAO.elimina(corso)) {
		//		System.out.println("il corso è stato eliminato " + corso);
		//	}

		//DATA UNA PALESTRA RESTITUIRE L'ELENCO DEI CORSI
		//	Palestra palestra= new Palestra();
		//	palestra.setId(3);
		//	Vector<Corso> elenco= corsoDAO.getCorso(palestra);
		//	for (Corso c: elenco) {
		//	System.out.println("Id " +c.getId() + "Nome :" +c.getNome());
		//	}

		//DATO UN CORSO RESTITUIRE IL NUMERO DI ISCRITTI
//		Corso c= new Corso();
//		c.setId(2);
//		int iscritti = corsoDAO.numIscritti(c);
//		System.out.println("Numero di iscritti: " + iscritti);



		//Costo di un corso
		Corso c1= new Corso();
		c1.setId(2);
		Corso c2= new Corso();
		c2.setId(3);
	
		Vector <Corso> lista = new Vector<>();
		lista.add(c1);
		lista.add(c2);
	
		int costo=0;
		costo=corsoDAO.costoCorsiAbbonamento(lista);
		System.out.println("il costo di un corso è " + costo);

	}
}
