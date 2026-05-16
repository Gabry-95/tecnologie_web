package it.pale.tweb.dao.test;

import java.util.Date;
import java.util.Vector;

import it.pale.tweb.dao.beans.Cliente;
import it.pale.tweb.dao.beans.ClienteDAO;
import it.pale.tweb.dao.beans.Personal_trainer;
import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.beans.Palestra;

public class TestCliente {

	public static void main(String[] args) {
		
		Cliente Cliente=new Cliente();
		ClienteDAO clienteDAO= new ClienteDAO();
//		//Adesso gli assegno:
//		Cliente.setMatricola(100);
//		Cliente.setNome("Peppe");
//		Cliente.setCognome("Senatorissimo");
//		Cliente.setTelefono(67676767);

		//METODO SALVA
//		if (clienteDAO.salva(Cliente)) {
//		System.out.println("Salvato "+Cliente);
//		}
		
		//MODIFICHIAMO GLI ATTRIBUTI DI Cliente PER PROVARE IL METODO MODIFICA
//		Cliente.setMatricola(100);
//		Cliente.setNome("Tetesto");
//		Cliente.setCognome("Iderroni");
//		Cliente.setTelefono(69696969);
//		if (clienteDAO.modifica(Cliente)) {
//		System.out.println("Modificato " + Cliente);
//		}
		
		//METODO GET
//		Cliente= ClienteDAO.get(Cliente);
//		System.out.println("Riletto " + Cliente);
		
		//METODO GETALL
//		Vector<Cliente> Clientes= clienteDAO.getAll();
//		for (Cliente a:Clientes) {
//			System.out.println(a);
//		}
		
//		//METODO ELIMINA
//		if(clienteDAO.elimina(Cliente));
//		System.out.println("L'Cliente " + Cliente + " è stato eliminato" );
		
		//METODO ELENCA CLIENTI SEGUITI DALLO STESSO PERSONAL TRAINER
//		Personal_trainer pt= new Personal_trainer();
//		pt.setMatricola(3);
//		System.out.println(pt.getMatricola());
//		Vector<Cliente> Clientes= clienteDAO.elencaClienti(pt);
//		for (Cliente a:Clientes) {
//			System.out.println("Nome: "+a.getNome()+" cognome: "+a.getCognome());
//		}
		
		//DATO UN CORSO RESTITUISCI UNA LISTA DEI CLIENTI CHE SEGUONO IL CORSO
//		Corso c= new Corso();
//		Palestra p = new Palestra();
//		p.setId(2);
//		c.setId(4);
//		Vector<Cliente> Clientes= clienteDAO.getIscrittiCorso(p,c);
//		for (Cliente a:Clientes) {
//			System.out.println("Nome: "+a.getNome()+" cognome: "+a.getCognome());
//		}
//		
		//DATO UN CORSO RESTITUIRE LA LISTA DI NOME COGNOME E NUMERO DI TELEFONO DEI CLIENTI CHE LO SEGUONO
		Corso c= new Corso();
		c.setId(4);
		Vector<Cliente> Clientes= clienteDAO.IscrittiCorso(c);
		for (Cliente a:Clientes) {
			System.out.println("Nome: "+a.getNome()+" cognome: "+a.getCognome()+" telefono: "+a.getTelefono());
		}
	}
}
