package it.pale.tweb.dao.beans;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Connection;
import it.pale.tweb.dao.utils.DBManager;

public class Personal_trainerDAO {
	private static Connection conn = null;

	public Personal_trainer get(Personal_trainer personalT) {
		String query = "SELECT * FROM Personal_trainer WHERE matricola=?";

		Personal_trainer res = null;
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

	private Personal_trainer recordToPersonalT(ResultSet rs) throws SQLException {
		Personal_trainer personalT = new Personal_trainer();
		personalT.setMatricola(rs.getInt("matricola"));
		personalT.setNome(rs.getString("nome"));
		personalT.setCognome(rs.getString("cognome"));
		personalT.setPalestra(rs.getInt("palestra"));
		personalT.setTelefono(rs.getLong("telefono"));


		return personalT;
	}

	public Vector<Personal_trainer> getAll() {
		String query = "SELECT * FROM Personal_trainer order by matricola";

		Vector<Personal_trainer> res = new Vector<Personal_trainer>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Personal_trainer personalT = recordToPersonalT(rs);
				res.add(personalT);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public boolean salva(Personal_trainer personalT) {
		String query = "INSERT INTO Personal_trainer VALUES ( ?, ?, ?, ?, ?)";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, personalT.getMatricola());
			ps.setString(2, personalT.getNome());
			ps.setString(3, personalT.getCognome());
			ps.setInt(4, personalT.getPalestra());
			ps.setLong(5, personalT.getTelefono());


			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean elimina(Personal_trainer personalT) {
		String query = "DELETE FROM Personal_trainer WHERE matricola = ?";
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

	public boolean modifica(Personal_trainer PersonalT) {
		String query = "UPDATE Personal_trainer SET nome=?, cognome=?, palestra=?, telefono=? WHERE matricola=?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, PersonalT.getNome());
			ps.setString(2, PersonalT.getCognome());
			ps.setInt(3, PersonalT.getPalestra());
			ps.setLong(4, PersonalT.getTelefono());
			ps.setInt(5, PersonalT.getMatricola());


			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	//Elenca personal trainer di una palestra ordinandoli per cognome
	public Vector<Personal_trainer> elencoIS(Palestra p) {
		String query = "SELECT cognome, nome FROM personal_trainer"
				+ "WHERE palestra = ?"
				+ "ORDER BY cognome";

		Vector<Personal_trainer> res = new Vector<Personal_trainer>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ps.setInt(1, p.getId());
			while (rs.next()) {
				Personal_trainer personalT = recordToPersonalT(rs);
				res.add(personalT);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	
	//69. Data una palestra restituire tutti i numeri di telefono dei dipendenti con nome e cognome 
	public Vector<Personal_trainer> getTelefonoPT(Palestra p) {
		String query = "SELECT telefono, nome, cognome FROM Personal_Trainer WHERE palestra=?";


		Vector<Personal_trainer> res = new Vector<Personal_trainer>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ps.setInt(1, p.getId());
			while (rs.next()) {
				Personal_trainer pt= recordToPersonalT(rs);
				res.add(pt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
}
