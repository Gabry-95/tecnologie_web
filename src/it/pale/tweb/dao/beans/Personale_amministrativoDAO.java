package it.pale.tweb.dao.beans;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Connection;
import it.pale.tweb.dao.utils.DBManager;
public class Personale_amministrativoDAO {
	private static Connection conn = null;

	public Personale_ammistrativo get(Personale_ammistrativo personaleA) {
		String query = "SELECT * FROM PersonaleA WHERE matricola=?";

		Personale_ammistrativo res = null;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, personaleA.getMatricola());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res = recordToPersonaleA(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	private Personale_ammistrativo recordToPersonaleA(ResultSet rs) throws SQLException {
		Personale_ammistrativo personaleA = new Personale_ammistrativo();
		personaleA.setMatricola(rs.getInt("matricola"));
		personaleA.setNome(rs.getString("nome"));
		personaleA.setCognome(rs.getString("cognome"));
		personaleA.setTelefono(rs.getLong("telefono"));


		return personaleA;
	}

	public Vector<Personale_ammistrativo> getAll() {
		String query = "SELECT * FROM PersonaleA order by matricola";

		Vector<Personale_ammistrativo> res = new Vector<Personale_ammistrativo>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Personale_ammistrativo personaleA = recordToPersonaleA(rs);
				res.add(personaleA);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public boolean salva(Personale_ammistrativo personaleA) {
		String query = "INSERT INTO PersonaleA VALUES ( ?, ?, ?, ?)";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, personaleA.getMatricola());
			ps.setString(2, personaleA.getNome());
			ps.setString(3, personaleA.getCognome());
			ps.setLong(4, personaleA.getTelefono());


			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean elimina(Personale_ammistrativo personaleA) {
		String query = "DELETE FROM PersonaleA WHERE matricola = ?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, personaleA.getMatricola());

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

	//	public boolean modifica(PersonaleA personaleA) {
	//		String query = "UPDATE PersonaleA SET nome=? WHERE id=?";
	//		boolean esito = false;
	//
	//		PreparedStatement ps;
	//		conn = DBManager.startConnection();
	//		try {
	//			ps = conn.prepareStatement(query);
	//
	//			ps.setInt(1, personaleA.getId());
	//			ps.setLong(2, personaleA.getTelefono());
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
