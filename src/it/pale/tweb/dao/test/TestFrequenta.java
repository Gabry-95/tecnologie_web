package it.pale.tweb.dao.test;

import it.pale.tweb.dao.beans.Abbonamento;
import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.beans.join.FrequentaDAO;

public class TestFrequenta {
	public static void main(String[] args) {
		
		Abbonamento a= new Abbonamento();
		Corso c= new Corso();
		FrequentaDAO fDAO= new FrequentaDAO();
		
		//METODO SALVA
		a.setFattura(5);
		c.setId(3);
		
//		if(fDAO.salva(a, c)) {
//			System.out.println("salvato");
//		}
		
		//METODO MODIFICA
		
		Abbonamento a2= new Abbonamento();
		a2.setFattura(7);
//		if(fDAO.modifica(c, a, c, a2)) {
//			System.out.println("modificato "+fDAO);
//		}
		
		//METODO ELIMINA 
//		if(fDAO.elimina(a2, c)) {
//			System.out.println("eliminato");
//		}
		
	}
}
