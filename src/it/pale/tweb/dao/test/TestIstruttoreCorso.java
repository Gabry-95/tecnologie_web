package it.pale.tweb.dao.test;

import java.util.Vector;

import it.pale.tweb.dao.beans.Istruttore_corso;
import it.pale.tweb.dao.beans.Istruttore_corsoDAO;
import it.pale.tweb.dao.beans.Palestra;

public class TestIstruttoreCorso {
	public static void main (String [] args) {
		Istruttore_corsoDAO istruttoreDAO= new Istruttore_corsoDAO();
		Istruttore_corso istruttore= new Istruttore_corso();
		
		istruttore.setMatricola(111);
		istruttore.setNome("mario");
		istruttore.setCognome("verdi");
		istruttore.setPalestra(1);
		istruttore.setTelefono(1111);
		
		//METODO SALVA
//		if (istruttoreDAO.salva(istruttore)) {
//			System.out.println("Salvato " + istruttore);
//		}
		//METODO MODIFICA 
//		istruttore.setTelefono(22222222);
//		if(istruttoreDAO.modifica(istruttore)) {
//			System.out.println("modifica : " + istruttore);
//		}
		//METODO GET
//		istruttore=istruttoreDAO.get(istruttore);
//		System.out.println("Riletto "+ istruttore);
		//METODO GET ALL 
//		Vector<Istruttore_corso> istruttores= istruttoreDAO.getAll();
//			for (Istruttore_corso i:istruttores) {
//				System.out.println(i);
//			}
		//METODO ELIMINA
//		if(istruttoreDAO.elimina(istruttore)) {
//					System.out.println("l'istruttore è stato eliminato " + istruttore);
//				}
		//DATA UNA PALESTRA RESTITUIRE TUTTI I NUMERI DI TELEONO DEI DIPENDENDETI CON NOME E COGNOME
		Palestra palestra= new Palestra ();
		palestra.setId(3);
		Vector<Istruttore_corso> telefono= istruttoreDAO.getTelefonoIC(palestra);
		for (Istruttore_corso t: telefono) {
			System.out.println("Numero di telefono " +t.getTelefono() + " Nome :" +t.getNome() + " Cognome :" + t.getCognome());
			}
	
	}

}
