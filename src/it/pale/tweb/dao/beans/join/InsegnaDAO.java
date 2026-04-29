package it.pale.tweb.dao.beans.join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.pale.tweb.dao.beans.Istruttore_corso;
import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.utils.DBManager;

public class InsegnaDAO {
	private static Connection conn = null;
//Assegna un istruttore corso a un corso
	public boolean salva(Corso c, Istruttore_corso ic) {
		String query = "INSERT INTO frequenta VALUES ( ?, ?)";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, c.getId());
			ps.setInt(2, ic.getMatricola());

			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean elimina(Corso c, Istruttore_corso ic) {
		String query = "DELETE FROM frequenta WHERE Corso=? AND Istruttore_corso=?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, c.getId());
			ps.setInt(2, ic.getMatricola());
			
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
	
	public boolean modifica(Corso oldC, Istruttore_corso oldIC, Corso newC, Istruttore_corso newIC) {
		String query = "UPDATE frequenta SET Corso=?, Istruttore_corso=? "+
				"WHERE Corso=? AND Istruttore_corso=?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			
			//nuovi
			ps.setInt(1, newC.getId());
			ps.setLong(2, newIC.getMatricola());
			
			//vecchi
			ps.setInt(4, oldC.getId());
			ps.setLong(5, oldIC.getMatricola());

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
