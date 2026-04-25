package it.pale.tweb.dao.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.pale.tweb.dao.utils.DBManager;

public class IstruttoreCDAO {
	private static Connection conn = null;

	public IstruttoreC get(IstruttoreC istruttoreC) {
		String query = "SELECT * FROM IstruttoreC WHERE matricola=?";

		IstruttoreC res = null;
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

	private IstruttoreC recordToIstruttoreC(ResultSet rs) throws SQLException {
		IstruttoreC istruttoreC = new IstruttoreC();
		istruttoreC.setMatricola(rs.getInt("matricola"));
		istruttoreC.setNome(rs.getString("nome"));
		istruttoreC.setCognome(rs.getString("cognome"));
		istruttoreC.setTelefono(rs.getLong("telefono"));


		return istruttoreC;
	}

	public Vector<IstruttoreC> getAll() {
		String query = "SELECT * FROM IstruttoreC order by matricola";

		Vector<IstruttoreC> res = new Vector<IstruttoreC>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				IstruttoreC istruttoreC = recordToIstruttoreC(rs);
				res.add(istruttoreC);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public boolean salva(IstruttoreC istruttoreC) {
		String query = "INSERT INTO IstruttoreC VALUES ( ?, ?, ?, ?)";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, istruttoreC.getMatricola());
			ps.setString(2, istruttoreC.getNome());
			ps.setString(3, istruttoreC.getCognome());
			ps.setLong(4, istruttoreC.getTelefono());


			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean elimina(IstruttoreC istruttoreC) {
		String query = "DELETE FROM IstruttoreC WHERE matricola = ?";
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

	//	public boolean modifica(IstruttoreC istruttoreC) {
	//		String query = "UPDATE IstruttoreC SET nome=? WHERE id=?";
	//		boolean esito = false;
	//
	//		PreparedStatement ps;
	//		conn = DBManager.startConnection();
	//		try {
	//			ps = conn.prepareStatement(query);
	//
	//			ps.setInt(1, istruttoreC.getId());
	//			ps.setLong(2, istruttoreC.getTelefono());
	//		
	//
	//			int tmp = ps.executeUpdate();
	//			if (tmp == 1)
	//				esito = true;
	//		} catch (SQLException e) {
	//			e.printStackTrace();
	//		}
	//		DBManager.closeConnection();
	//		return esito;
	//	}


}
