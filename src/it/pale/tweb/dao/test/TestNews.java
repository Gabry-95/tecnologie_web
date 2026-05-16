package it.pale.tweb.dao.test;

import java.util.Date;
import java.util.Vector;

import it.pale.tweb.dao.beans.News;
import it.pale.tweb.dao.beans.NewsDAO;

public class TestNews {
public static void main (String [] args) {
	NewsDAO newsDAO= new NewsDAO();
	News news = new News();
	
	news.setId(888);
	news.setTesto("Ciao");
	news.setData(new Date());
	news.setPalestra(2);
	
	
	//METODO SALVA
	if(newsDAO.salva(news)) {
		System.out.println("Salvato "+ news);
	}
	
	//METODO MODIFICA
//	news.setTesto("No");
//	news.setData(new Date(0));
//	
//	if(newsDAO.modifica(news)) {
//		System.out.println("Modifica: " + news);
//	}
	
	//METODO GET
//	news=newsDAO.get(news);
//	System.out.println("Riletto "+ news);
//	
	//METODO GET ALL
//	Vector<News> newss = newsDAO.getAll();
//	for (News n : newss) {
//		System.out.println(n);
//	}
	//METODO ELIMINA
//	if(newsDAO.elimina(news)) {
//		System.out.println("La news è stata eliminata " + news);
//	}
	
}
}
