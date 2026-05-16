package it.pale.tweb.dao.test;

import it.pale.tweb.dao.beans.Abbonamento;
import it.pale.tweb.dao.beans.Personal_trainer;
import it.pale.tweb.dao.beans.join.SegueDAO;

public class TestSegue {
	public static void main (String [] args) {
		SegueDAO segue = new SegueDAO();
		Abbonamento abbonamento = new Abbonamento ();
		Personal_trainer personal = new Personal_trainer();
	
//		abbonamento.setFattura(3);
//		personal.setMatricola(3);
		abbonamento.setTipo("Gold");
		
		//METODO SALVA
//		if(segue.salva(abbonamento, personal)) {
//			System.out.println("Salvato "+ segue);
//		}
		//METODO MODIFICA
		abbonamento.setFattura(7);
		personal.setMatricola(4);
//		if(segue.modifica(abbonamento, abbonamento, personal)) {
//			System.out.println("Modifica " +segue);
//		}
		//METODO ELIMINA
		if(segue.elimina(abbonamento, personal)) {
			System.out.println("Elimina "+ segue);
		}
	}

}
