package it.pale.tweb.dao.test;

import it.pale.tweb.dao.beans.Abbonamento;
import it.pale.tweb.dao.beans.AbbonamentoDAO;
import java.util.Date;
import java.util.Vector;
import it.pale.tweb.dao.beans.Cliente;

public class Test {
	//TEST PALESTRA
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creo due oggetti abbonamento, uno relativo al DAO e uno relativo al Bean
		AbbonamentoDAO abbonamentoDAO= new AbbonamentoDAO();
		Abbonamento abbonamento=new Abbonamento();
		//Adesso gli assegno:
//		abbonamento.setFattura(100);
//		abbonamento.setTipo("standard");
//		abbonamento.setDataScadenza(new Date());
//		abbonamento.setLimiteIngressi(3);
//		abbonamento.setCosto(30);
//		abbonamento.setCliente(8);

		//METODO SALVA
//		if (abbonamentoDAO.salva(abbonamento)) {
//		System.out.println("Salvato "+abbonamento);
//		}
//		//MODIFICHIAMO GLI ATTRIBUTI DI ABBONAMENTO PER PROVARE IL METODO MODIFICA
//		abbonamento.setTipo("gold");
//		abbonamento.setDataScadenza(new Date(0));
//		abbonamento.setLimiteIngressi(null);
//		abbonamento.setCosto(50);
//		abbonamento.setCliente(8);
		//METODO MODIFICA
//		if (abbonamentoDAO.modifica(abbonamento)) {
//		System.out.println("Modificato " + abbonamento);
//		}
//		//METODO GET
//		abbonamento= abbonamentoDAO.get(abbonamento);
//		System.out.println("Riletto " + abbonamento);
//		//METODO GETALL
		Vector<Abbonamento> Abbonamentos= abbonamentoDAO.getAll();
		for (Abbonamento a:Abbonamentos) {
			System.out.println(a);
		}
//		abbonamentoDAO.elimina(abbonamento);
//		abbonamento=abbonamentoDAO.get(abbonamento);
//		System.out.println(abbonamento);
//		
//		//METODO ELIMINA
//		if(abbonamentoDAO.elimina(abbonamento));
//		System.out.println("L'abbonamento " + abbonamento + " è stato eliminato" );
		//METODO RINNOVA ABBONAMENTO
//		if(abbonamentoDAO.rinnovaAbbonamento(abbonamento));
//		System.out.println("L'abbonamento è stato rinnovato " + abbonamento);
//		
		//INFO ABBONAMENTO
		Cliente cliente= new Cliente();
		cliente.setMatricola(3);
		Abbonamento info= abbonamentoDAO.InfoAbbonamento(cliente);
		System.out.println("Tipo " +info.getTipo() + "Data :" +info.getDataScadenza() + "Limite ingressi: "+ info.getLimiteIngressi());
		
	}
}


