package it.pale.tweb.dao.beans;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Connection;
import it.pale.tweb.dao.utils.DBManager;
public class PersonaleADAO {
	private static Connection conn = null;

	public PersonaleA get(PersonaleA personaleA) {
		String query = "SELECT * FROM PersonaleA WHERE matricola=?";

		PersonaleA res = null;
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

	private PersonaleA recordToPersonaleA(ResultSet rs) throws SQLException {
		PersonaleA personaleA = new PersonaleA();
		personaleA.setMatricola(rs.getInt("matricola"));
		personaleA.setNome(rs.getString("nome"));
		personaleA.setCognome(rs.getString("cognome"));
		personaleA.setTelefono(rs.getLong("telefono"));


		return personaleA;
	}

	public Vector<PersonaleA> getAll() {
		String query = "SELECT * FROM PersonaleA order by matricola";

		Vector<PersonaleA> res = new Vector<PersonaleA>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PersonaleA personaleA = recordToPersonaleA(rs);
				res.add(personaleA);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public boolean salva(PersonaleA personaleA) {
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

	public boolean elimina(PersonaleA personaleA) {
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
