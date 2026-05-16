package it.pale.tweb.dao.test;

import java.util.Vector;

import it.pale.tweb.dao.beans.Istruttore_corso;
import it.pale.tweb.dao.beans.Istruttore_sala;
import it.pale.tweb.dao.beans.Istruttore_salaDAO;
import it.pale.tweb.dao.beans.Palestra;

public class TestIstruttoreSala {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Istruttore_salaDAO istruttoreDAO = new Istruttore_salaDAO();
		Istruttore_sala istruttore = new Istruttore_sala();
		
		istruttore.setMatricola(2222);
		istruttore.setNome("Giuseppe");
		istruttore.setCognome("No");
		istruttore.setPalestra(2);
		istruttore.setTelefono(777777);
		
		//METODO SALVA
//		if(istruttoreDAO.salva(istruttore)) {
//			System.out.println("Salvato " + istruttore);
//		}
		//METODO MODIFICA 
//		istruttore.setTelefono(11111);
//		if(istruttoreDAO.modifica(istruttore)) {
//			System.out.println("Modifica: "+ istruttore);
//			
//		}
		
		//METODO GET 
//		istruttore=istruttoreDAO.get(istruttore);
//		System.out.println("Riletto "+ istruttore);
		//METODO GET ALL 
//		Vector<Istruttore_sala> istruttores= istruttoreDAO.getAll();
//			for (Istruttore_sala i:istruttores) {
//				System.out.println(i);
//			}
		//METODO ELIMINA
//		if(istruttoreDAO.elimina(istruttore)) {
//					System.out.println("l'istruttore è stato eliminato " + istruttore);
//				}
		
		//ELENCA GLI ISTRUTTORI DI SALA ORDINANDOLI PER COGNOME
//		Palestra palestra= new Palestra();
//		palestra.setId(2);
//		Vector <Istruttore_sala> istruttori = istruttoreDAO.elencoIS(palestra);
//		for(Istruttore_sala i:istruttori) {
//			System.out.println("Gli istruttori di sala sono: "+ i.getCognome());
//		}
//		
		//DATA UNA PALESTRA RESTITUIRE TUTTI I NUMERI DI TELEONO DEI DIPENDENDETI CON NOME E COGNOME
				Palestra palestra= new Palestra ();
				palestra.setId(3);
				Vector<Istruttore_sala> telefono= istruttoreDAO.getTelefonoIS(palestra);
				for (Istruttore_sala t: telefono) {
					System.out.println("Numero di telefono " +t.getTelefono() + " Nome :" +t.getNome() + " Cognome :" + t.getCognome());
					}
		
		
		
		
	}
	
	

}
