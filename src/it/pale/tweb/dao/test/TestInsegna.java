package it.pale.tweb.dao.test;

import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.beans.Istruttore_corso;
import it.pale.tweb.dao.beans.join.InsegnaDAO;

public class TestInsegna {
	public static void main (String [] args) {
		InsegnaDAO insegna = new InsegnaDAO();
		Corso corso= new Corso();
		Istruttore_corso istruttore= new Istruttore_corso();
		corso.setId(1);
		istruttore.setMatricola(2);
		
		//METODO SALVA
//		if(insegna.salva(corso, istruttore)) {
//			System.out.println("Salvato "+ insegna);
//		}
		//METODO MODIFICA
//		corso.setId(2);
//		if(insegna.modifica(corso, istruttore, corso, istruttore)) {
//			System.out.println("Modifica " +insegna);
//		}
		//METODO ELIMINA
//		if(insegna.elimina(corso, istruttore)) {
//			System.out.println("Elimina "+ insegna);
//		}
		
	}

}
