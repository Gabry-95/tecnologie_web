package it.pale.tweb.dao.beans;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Connection;
import it.pale.tweb.dao.utils.DBManager;

public class PersonalTDAO {
	private static Connection conn = null;

	public PersonalT get(PersonalT personalT) {
		String query = "SELECT * FROM PersonalT WHERE matricola=?";

		PersonalT res = null;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, personalT.getMatricola());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res = recordToPersonalT(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	private PersonalT recordToPersonalT(ResultSet rs) throws SQLException {
		PersonalT personalT = new PersonalT();
		personalT.setMatricola(rs.getInt("matricola"));
		personalT.setNome(rs.getString("nome"));
		personalT.setCognome(rs.getString("cognome"));
		personalT.setTelefono(rs.getLong("telefono"));


		return personalT;
	}

	public Vector<PersonalT> getAll() {
		String query = "SELECT * FROM PersonalT order by matricola";

		Vector<PersonalT> res = new Vector<PersonalT>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PersonalT personalT = recordToPersonalT(rs);
				res.add(personalT);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public boolean salva(PersonalT personalT) {
		String query = "INSERT INTO PersonalT VALUES ( ?, ?, ?, ?)";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, personalT.getMatricola());
			ps.setString(2, personalT.getNome());
			ps.setString(3, personalT.getCognome());
			ps.setLong(4, personalT.getTelefono());


			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean elimina(PersonalT personalT) {
		String query = "DELETE FROM PersonalT WHERE matricola = ?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, personalT.getMatricola());

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

	//	public boolean modifica(PersonalT PersonalT) {
	//		String query = "UPDATE PersonalT SET nome=? WHERE id=?";
	//		boolean esito = false;
	//
	//		PreparedStatement ps;
	//		conn = DBManager.startConnection();
	//		try {
	//			ps = conn.prepareStatement(query);
	//
	//			ps.setInt(1, PersonalT.getId());
	//			ps.setLong(2, PersonalT.getTelefono());
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
