package it.pale.tweb.dao.test;

import java.util.Vector;

import it.pale.tweb.dao.beans.Palestra;
import it.pale.tweb.dao.beans.PalestraDAO;

public class TestPalestra {
	
	public static void main(String[] args) {
		Palestra pa=new Palestra();
		PalestraDAO paDAO= new PalestraDAO();
		//CREAZIONE 
		pa.setId(1);
//		pa.setCap(1234);
//		pa.setVia("Via Viva il duce");
//		pa.setCitta("Roma");
//		pa.setTelefono(67676767);

		//METODO SALVA
//		if (paDAO.salva(pa)) {
//			System.out.println("Salvato "+pa);
//		}
		
		//MODIFICHIAMO GLI ATTRIBUTI DI Palestra PER PROVARE IL METODO MODIFICA
//		pa.setId(1000);
//		pa.setCap(4321);
//		pa.setVia("Via Viva il duce");
//		pa.setCitta("Torino");
//		pa.setTelefono(69696969);
//		if (paDAO.modifica(pa)) {
//			System.out.println("Modificato " + pa);
//		}
		
		//METODO GET
//		pa= paDAO.get(pa);
//		System.out.println("Riletto " + pa);
		
		//METODO GETALL
//		Vector<Palestra> pas= paDAO.getAll();
//		for (Palestra a:pas) {
//			System.out.println(a);
//		}
		
//		//METODO ELIMINA
//		if(paDAO.elimina(pa));
//		System.out.println("L'Palestra " + pa + " è stato eliminato" );
		
	//DATA UNA PALESTRA RESTITUIRE IL NUMERO DI TELEFONO
		
		System.out.println("Telefono: "+paDAO.telefono(pa));
		
	}
}
