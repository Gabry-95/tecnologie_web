package it.pale.tweb.dao.beans;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Connection;
import it.pale.tweb.dao.utils.DBManager;

public class CorsoDAO {
	private static Connection conn = null;

	public Corso get(Corso corso) {
		String query = "SELECT * FROM Corso WHERE id=?";

		Corso res = null;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, corso.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res = recordToCorso(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	private Corso recordToCorso(ResultSet rs) throws SQLException {
		Corso corso = new Corso();
		corso.setId(rs.getInt("id"));
		corso.setNome(rs.getString("nome"));
		corso.setAnno(rs.getInt("anno"));
		corso.setCosto(rs.getInt("costo"));
		corso.setTipo(rs.getString("tipo"));
		corso.setPalestra(rs.getInt("palestra"));

		return corso;
	}

	public Vector<Corso> getAll() {
		String query = "SELECT * FROM Corso order by id";

		Vector<Corso> res = new Vector<Corso>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Corso corso = recordToCorso(rs);
				res.add(corso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public boolean salva(Corso corso) {
		String query = "INSERT INTO Corso VALUES ( ?, ?, ?, ?, ?, ?)";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, corso.getId());
			ps.setString(2, corso.getNome());
			ps.setInt(3, corso.getAnno());
			ps.setInt(4, corso.getCosto());
			ps.setString(5, corso.getTipo());
			ps.setInt(6, corso.getPalestra());

			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean elimina(Corso corso) {
		String query = "DELETE FROM Corso WHERE id = ?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, corso.getId());

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

//	public boolean modifica(Corso corso) {
//		String query = "UPDATE Corso SET nome=? WHERE id=?";
//		boolean esito = false;
//
//		PreparedStatement ps;
//		conn = DBManager.startConnection();
//		try {
//			ps = conn.prepareStatement(query);
//
//			ps.setInt(1, corso.getId());
//			ps.setLong(2, corso.getTelefono());
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
