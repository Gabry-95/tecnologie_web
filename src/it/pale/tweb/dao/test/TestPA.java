package it.pale.tweb.dao.test;


import java.util.Vector;

import it.pale.tweb.dao.beans.Palestra;
import it.pale.tweb.dao.beans.Personale_amministrativo;
import it.pale.tweb.dao.beans.Personale_amministrativoDAO;

public class TestPA {
	public static void main(String[] args) {
		Personale_amministrativo pa=new Personale_amministrativo();
		Personale_amministrativoDAO paDAO= new Personale_amministrativoDAO();
//		//CREAZIONE 
		pa.setMatricola(1000);
//		pa.setNome("Carlo");
//		pa.setCognome("Chirico");
//		pa.setPalestra(1);
//		pa.setTelefono(67676767);
//		

		//METODO SALVA
//		if (paDAO.salva(pa)) {
//		System.out.println("Salvato "+pa);
//		}
		
		//MODIFICHIAMO GLI ATTRIBUTI DI Personale_amministrativo PER PROVARE IL METODO MODIFICA
//		pa.setMatricola(1000);
//		pa.setNome("Tetesto");
//		pa.setCognome("Iderroni");
//		pa.setPalestra(1);
//		pa.setTelefono(69696969);
//		if (paDAO.modifica(pa)) {
//			System.out.println("Modificato " + pa);
//		}
		
		//METODO GET
//		pa= paDAO.get(pa);
//		System.out.println("Riletto " + pa);
		
		//METODO GETALL
//		Vector<Personale_amministrativo> pas= paDAO.getAll();
//		for (Personale_amministrativo a:pas) {
//			System.out.println(a);
//		}
		
//		//METODO ELIMINA
//		if(paDAO.elimina(pa));
//		System.out.println("L'Personale_amministrativo " + pa + " è stato eliminato" );
//		
	//ELENCA PERSONALE AMMINISTRATIVO DI UNA PALESTRA DI UNA PALESTRA ORDINANDOLI PER COGNOME
		
//		Palestra p=new Palestra();
//		p.setId(1);
//		Vector<Personale_amministrativo> pas= paDAO.elencoPA(p);
//		for (Personale_amministrativo a:pas) {
//			System.out.println("cognome: "+a.getCognome()+" nome: "+a.getNome());
//		}
//		
		//DATA UNA PALESTRA RESTITUISCI TUTTI I NUMERI DI TELEFONO DEI DIPENDENTI CON NOME E COGNOME
//		Palestra p=new Palestra();
//		p.setId(1);
//		Vector<Personale_amministrativo> pas= paDAO.getTelefonoPA(p);
//		for (Personale_amministrativo a:pas) {
//			System.out.println("cognome: "+a.getCognome()+" nome: "+a.getNome()+" telefono "+a.getTelefono());
//		}
	}
}
