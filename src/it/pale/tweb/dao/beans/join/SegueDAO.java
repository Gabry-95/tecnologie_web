package it.pale.tweb.dao.beans.join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.pale.tweb.dao.beans.Abbonamento;
import it.pale.tweb.dao.beans.Personal_trainer;
import it.pale.tweb.dao.utils.DBManager;

public class SegueDAO {
	private static Connection conn = null;

	public boolean salva(Abbonamento a, Personal_trainer pt) {
		String query = "INSERT INTO segue VALUES ( ?, ?)";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, a.getFattura());
			ps.setInt(2, pt.getMatricola());

			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean elimina(Abbonamento a, Personal_trainer pt) {
		String query = "DELETE FROM segue WHERE abbonamento=?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, a.getFattura());
			ps.setInt(2, pt.getMatricola());
			
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
	
	public boolean modifica(Abbonamento oldA, Abbonamento newA, Personal_trainer newPT) {
		String query = "UPDATE segue SET Abbonamento=?, Personal_trainer=?"+
				"WHERE Abbonamento=?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			
			//nuovi
			ps.setInt(1, newPT.getMatricola());
			ps.setLong(2, newA.getFattura());
			
			//vecchi
			ps.setLong(3, oldA.getFattura());

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
