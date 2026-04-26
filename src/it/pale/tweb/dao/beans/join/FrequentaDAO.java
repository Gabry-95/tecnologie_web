package it.pale.tweb.dao.beans.join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.pale.tweb.dao.beans.Abbonamento;
import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.utils.DBManager;

public class FrequentaDAO {
	private static Connection conn = null;

	public boolean salva(Abbonamento a, Corso c) {
		String query = "INSERT INTO frequenta VALUES ( ?, ?)";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, a.getFattura());
			ps.setInt(2, c.getId());
			
			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean elimina(Abbonamento a, Corso c) {
		String query = "DELETE FROM frequenta WHERE Corso=? AND abbonamento=?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, c.getId());
			ps.setInt(2, a.getFattura());
			
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
	
	public boolean modifica(Corso oldC, Abbonamento oldA, Corso newC, Abbonamento newA) {
		String query = "UPDATE frequenta SET Corso=?, Abbonamento=? "+
				"WHERE Corso=? AND Abbonamento=?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			
			//nuovi
			ps.setInt(1, newC.getId());
			ps.setLong(2, newA.getFattura());
			
			//vecchi
			ps.setInt(4, oldC.getId());
			ps.setLong(5, oldA.getFattura());

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
