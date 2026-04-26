package it.pale.tweb.dao.beans.join;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import java.sql.Connection;

import it.pale.tweb.dao.beans.Palestra;
import it.pale.tweb.dao.utils.DBManager;

public class Da_accessoDAO {
	
	private static Connection conn = null;

	public boolean salva(Palestra p, Abbonamento a, Date d) {
		String query = "INSERT INTO Da_accesso VALUES ( ?, ?, ?, ?, ?, ?)";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, Da_accesso.getId());
			ps.setString(2, Da_accesso.getNome());
			ps.setInt(3, Da_accesso.getAnno());
			ps.setInt(4, Da_accesso.getCosto());
			ps.setString(5, Da_accesso.getTipo());
			ps.setInt(6, Da_accesso.getPalestra());

			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean elimina(Da_accesso Da_accesso) {
		String query = "DELETE FROM Da_accesso WHERE id = ?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, Da_accesso.getId());

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

	public boolean modifica(Da_accesso Da_accesso) {
		String query = "UPDATE Da_accesso SET nome=? WHERE id=?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, Da_accesso.getId());
			ps.setLong(2, Da_accesso.getTelefono());
		

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
