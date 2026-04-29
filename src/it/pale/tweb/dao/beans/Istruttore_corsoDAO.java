package it.pale.tweb.dao.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.pale.tweb.dao.utils.DBManager;

public class Istruttore_corsoDAO {
	private static Connection conn = null;

	public Istruttore_corso get(Istruttore_corso istruttoreC) {
		String query = "SELECT * FROM Istruttore_corso WHERE matricola=?";

		Istruttore_corso res = null;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, istruttoreC.getMatricola());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res = recordToIstruttoreC(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	private Istruttore_corso recordToIstruttoreC(ResultSet rs) throws SQLException {
		Istruttore_corso istruttoreC = new Istruttore_corso();
		istruttoreC.setMatricola(rs.getInt("matricola"));
		istruttoreC.setNome(rs.getString("nome"));
		istruttoreC.setCognome(rs.getString("cognome"));
		istruttoreC.setPalestra(rs.getInt("palestra"));
		istruttoreC.setTelefono(rs.getLong("telefono"));
		


		return istruttoreC;
	}

	public Vector<Istruttore_corso> getAll() {
		String query = "SELECT * FROM Istruttore_corso order by matricola";

		Vector<Istruttore_corso> res = new Vector<Istruttore_corso>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Istruttore_corso istruttoreC = recordToIstruttoreC(rs);
				res.add(istruttoreC);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public boolean salva(Istruttore_corso istruttoreC) {
		String query = "INSERT INTO Istruttore_corso VALUES ( ?, ?, ?, ?, ?)";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, istruttoreC.getMatricola());
			ps.setString(2, istruttoreC.getNome());
			ps.setString(3, istruttoreC.getCognome());
			ps.setInt(4, istruttoreC.getPalestra());
			ps.setLong(5, istruttoreC.getTelefono());


			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean elimina(Istruttore_corso istruttoreC) {
		String query = "DELETE FROM Istruttore_corso WHERE matricola = ?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, istruttoreC.getMatricola());

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

	public boolean modifica(Istruttore_corso istruttoreC) {
		String query = "UPDATE Istruttore_corso SET nome=?, cognome=?, palestra=?, telefono=? WHERE matricola=?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, istruttoreC.getNome());
			ps.setString(2, istruttoreC.getCognome());
			ps.setInt(3, istruttoreC.getPalestra());
			ps.setLong(4, istruttoreC.getTelefono());
			ps.setInt(5, istruttoreC.getMatricola());


			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	
	//69 Data una palestra restituire tutti i numeri di telefono dei dipendenti con nome e cognome
	public Vector<String> getTelefonoIC(Palestra p) {
		String query = "SELECT nome, cognome, telefono FROM Istruttore_corso WHERE palestra=?";

		Vector<String> res = new Vector<String>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ps.setInt(1, p.getId());
			while (rs.next()) {
				String s = rs.getString("nome")+" "+rs.getString("cognome")+" "+rs.getLong("telefono");
				res.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	
}
