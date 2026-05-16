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
			
			if(a.getTipo().equals("Gold")) {
				ps = conn.prepareStatement(query);

				ps.setInt(1, a.getFattura());
				ps.setInt(2, pt.getMatricola());

				int tmp = ps.executeUpdate();
				if (tmp == 1)
					esito = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean elimina(Abbonamento a, Personal_trainer pt) {
		String query = "DELETE FROM segue WHERE abbonamento=? AND PersonalTrainer=?";
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
		String query = "UPDATE segue SET Abbonamento=?, PersonalTrainer=? "+
				"WHERE Abbonamento=? ";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			
			//nuovi
			ps.setLong(1, newA.getFattura());
			ps.setInt(2, newPT.getMatricola());
			
			
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
