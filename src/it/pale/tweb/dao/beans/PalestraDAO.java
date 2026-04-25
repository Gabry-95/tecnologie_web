package it.pale.tweb.dao.beans;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Connection;
import it.pale.tweb.dao.utils.DBManager;


public class PalestraDAO {
	private static Connection conn = null;

	public Palestra get(Palestra palestra) {
		String query = "SELECT * FROM Palestra WHERE id=?";

		Palestra res = null;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, palestra.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res = recordToPalestra(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	private Palestra recordToPalestra(ResultSet rs) throws SQLException {
		Palestra palestra = new Palestra();
		palestra.setId(rs.getInt("id"));
		palestra.setTelefono(rs.getInt("telefono"));
		palestra.setCap(rs.getInt("cap"));
		palestra.setCitta(rs.getString("citta"));
		palestra.setVia(rs.getString("via"));

		return palestra;
	}

	public Vector<Palestra> getAll() {
		String query = "SELECT * FROM Palestra order by id";

		Vector<Palestra> res = new Vector<Palestra>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Palestra palestra = recordToPalestra(rs);
				res.add(palestra);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public boolean salva(Palestra palestra) {
		String query = "INSERT INTO Palestra VALUES ( ?, ?, ?, ?, ?)";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, palestra.getId());
			ps.setLong(2, palestra.getTelefono());
			ps.setInt(3, palestra.getCap());
			ps.setString(4, palestra.getVia());
			ps.setString(5, palestra.getCitta());

			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean elimina(Palestra palestra) {
		String query = "DELETE FROM Palestra WHERE id = ?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, palestra.getId());

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

	public boolean modifica(Palestra palestra) {
		String query = "UPDATE Palestra SET telefono=? WHERE id=?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, palestra.getId());
			ps.setLong(2, palestra.getTelefono());
		

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
