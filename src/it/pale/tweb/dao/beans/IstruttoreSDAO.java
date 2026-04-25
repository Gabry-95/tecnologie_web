package it.pale.tweb.dao.beans;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Connection;
import it.pale.tweb.dao.utils.DBManager;


public class IstruttoreSDAO {
	private static Connection conn = null;

	public IstruttoreS get(IstruttoreS istruttoreS) {
		String query = "SELECT * FROM IstruttoreS WHERE matricola=?";

		IstruttoreS res = null;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, istruttoreS.getMatricola());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res = recordToIstruttoreS(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	private IstruttoreS recordToIstruttoreS(ResultSet rs) throws SQLException {
		IstruttoreS istruttoreS = new IstruttoreS();
		istruttoreS.setMatricola(rs.getInt("matricola"));
		istruttoreS.setNome(rs.getString("nome"));
		istruttoreS.setCognome(rs.getString("cognome"));
		istruttoreS.setTelefono(rs.getLong("telefono"));
		

		return istruttoreS;
	}

	public Vector<IstruttoreS> getAll() {
		String query = "SELECT * FROM IstruttoreS order by matricola";

		Vector<IstruttoreS> res = new Vector<IstruttoreS>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				IstruttoreS istruttoreS = recordToIstruttoreS(rs);
				res.add(istruttoreS);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public boolean salva(IstruttoreS istruttoreS) {
		String query = "INSERT INTO IstruttoreS VALUES ( ?, ?, ?, ?)";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, istruttoreS.getMatricola());
			ps.setString(2, istruttoreS.getNome());
			ps.setString(3, istruttoreS.getCognome());
			ps.setLong(4, istruttoreS.getTelefono());
			

			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean elimina(IstruttoreS istruttoreS) {
		String query = "DELETE FROM IstruttoreS WHERE matricola = ?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, istruttoreS.getMatricola());

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

//	public boolean modifica(IstruttoreS istruttoreS) {
//		String query = "UPDATE IstruttoreS SET nome=? WHERE id=?";
//		boolean esito = false;
//
//		PreparedStatement ps;
//		conn = DBManager.startConnection();
//		try {
//			ps = conn.prepareStatement(query);
//
//			ps.setInt(1, istruttoreS.getId());
//			ps.setLong(2, istruttoreS.getTelefono());
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
