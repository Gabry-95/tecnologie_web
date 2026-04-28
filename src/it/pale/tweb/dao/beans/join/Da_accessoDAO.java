package it.pale.tweb.dao.beans.join;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Connection;

import it.pale.tweb.dao.beans.Abbonamento;
import it.pale.tweb.dao.beans.Palestra;
import it.pale.tweb.dao.utils.DBManager;

public class Da_accessoDAO {
	
	private static Connection conn = null;

	public boolean salva(Palestra p, Abbonamento a, Date d) {
		String query = "INSERT INTO Da_accesso VALUES ( ?, ?, ?)";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, p.getId());
			ps.setInt(2, a.getFattura());
			
			//converto da util.Date a sql.Date 
			java.sql.Date data=new java.sql.Date(d.getTime());
			ps.setDate(3, data);

			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean elimina(Palestra p, Abbonamento a, Date d) {
		String query = "DELETE FROM Da_accesso WHERE palestra=? AND abbonamento=? AND data=?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, p.getId());
			ps.setInt(2, a.getFattura());
			
			//converto da util.Date a sql.Date 
			java.sql.Date data=new java.sql.Date(d.getTime());
			ps.setDate(3, data);

			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;

		} catch (SQLException e) {
			esito = false;
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	
	public boolean modifica(Palestra oldP, Abbonamento oldA, Date oldDate, 
			Palestra newP, Abbonamento newA, Date newDate) {
		String query = "UPDATE Da_accesso SET palestra=?, abbonamento=?, data=? " +
				"WHERE palestra=? AND abbonamento=? AND data=?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			
			//nuovi
			ps.setInt(1, newP.getId());
			ps.setLong(2, newA.getFattura());
			
			//converto da util.Date a sql.Date
			ps.setDate(3, new java.sql.Date(newDate.getTime()));
			
			//vecchi
			ps.setInt(4, oldP.getId());
			ps.setLong(5, oldA.getFattura());
			
			//converto da util.Date a sql.Date
			ps.setDate(6, new java.sql.Date(oldDate.getTime()));

			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	
	}


