package it.pale.tweb.dao.test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.pale.tweb.dao.beans.Personal_trainer;
import it.pale.tweb.dao.beans.Personal_trainerDAO;
import it.pale.tweb.dao.beans.Palestra;

import it.pale.tweb.dao.utils.DBManager;

public class TestPT {
	
	public static void main(String[] args) {	
		
		Personal_trainer pt=new Personal_trainer();
		Personal_trainerDAO ptDAO= new Personal_trainerDAO();
//		//CREAZIONE 
//		pt.setMatricola(1000);
//		pt.setNome("Carlo");
//		pt.setCognome("Chirico");
//		pt.setPalestra(1);
//		pt.setTelefono(67676767);
		

		//METODO SALVA
//		if (ptDAO.salva(pt)) {
//		System.out.println("Salvato "+pt);
//		}
		
		//MODIFICHIAMO GLI ATTRIBUTI DI Personal_trainer PER PROVARE IL METODO MODIFICA
//		pt.setMatricola(1000);
//		pt.setNome("Tetesto");
//		pt.setCognome("Iderroni");
//		pt.setPalestra(1);
//		pt.setTelefono(69696969);
//		if (ptDAO.modifica(pt)) {
//		System.out.println("Modificato " + pt);
//		}
		
		//METODO GET
//		pt= ptDAO.get(pt);
//		System.out.println("Riletto " + pt);
		
		//METODO GETALL
//		Vector<Personal_trainer> pts= ptDAO.getAll();
//		for (Personal_trainer a:pts) {
//			System.out.println(a);
//		}
		
//		//METODO ELIMINA
//		if(ptDAO.elimina(pt));
//		System.out.println("L'Personal_trainer " + pt + " è stato eliminato" );
		
	//ELENCA PERSONAL TRAINER DI UNA PALESTRA ORDINANDOLI PER COGNOME
		
//		Palestra p=new Palestra();
//		p.setId(1);
//		Vector<Personal_trainer> pts= ptDAO.elencoPT(p);
//		for (Personal_trainer a:pts) {
//			System.out.println("cognome: "+a.getCognome()+" nome: "+a.getNome());
//		}
		
		//DATA UNA PALESTRA RESTITUISCI TUTTI I NUMERI DI TELEFONO DEI DIPENDENTI CON NOME E COGNOME
//		Palestra p=new Palestra();
//		p.setId(1);
//		Vector<Personal_trainer> pts= ptDAO.elencoPT(p);
//		for (Personal_trainer a:pts) {
//			System.out.println("cognome: "+a.getCognome()+" nome: "+a.getNome()+" telefono "+a.getTelefono());
//		}
	}
}
