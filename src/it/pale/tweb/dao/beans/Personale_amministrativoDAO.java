package it.pale.tweb.dao.beans;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Connection;
import it.pale.tweb.dao.utils.DBManager;
public class Personale_amministrativoDAO {
	private static Connection conn = null;

	public Personale_amministrativo get(Personale_amministrativo personaleA) {
		String query = "SELECT * FROM Personale_amministrativo WHERE matricola=?";

		Personale_amministrativo res = null;
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

	private Personale_amministrativo recordToPersonaleA(ResultSet rs) throws SQLException {
		Personale_amministrativo personaleA = new Personale_amministrativo();
		personaleA.setMatricola(rs.getInt("matricola"));
		personaleA.setNome(rs.getString("nome"));
		personaleA.setCognome(rs.getString("cognome"));
		personaleA.setPalestra(rs.getInt("palestra"));
		personaleA.setTelefono(rs.getLong("telefono"));


		return personaleA;
	}

	public Vector<Personale_amministrativo> getAll() {
		String query = "SELECT * FROM Personale_amministrativo order by matricola";

		Vector<Personale_amministrativo> res = new Vector<Personale_amministrativo>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Personale_amministrativo personaleA = recordToPersonaleA(rs);
				res.add(personaleA);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public boolean salva(Personale_amministrativo personaleA) {
		String query = "INSERT INTO Personale_amministrativo VALUES ( ?, ?, ?, ?, ?)";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, personaleA.getMatricola());
			ps.setString(2, personaleA.getNome());
			ps.setString(3, personaleA.getCognome());
			ps.setInt(4, personaleA.getPalestra());
			ps.setLong(5, personaleA.getTelefono());


			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean elimina(Personale_amministrativo personaleA) {
		String query = "DELETE FROM Personale_amministrativo WHERE matricola = ?";
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

	public boolean modifica(Personale_amministrativo personaleA) {
		String query = "UPDATE Personale_amministrativo SET nome=?, cognome=?, palestra=?, telefono=? WHERE matricola=?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, personaleA.getNome());
			ps.setString(2, personaleA.getCognome());
			ps.setInt(3, personaleA.getPalestra());
			ps.setLong(4, personaleA.getTelefono());
			ps.setInt(5, personaleA.getMatricola());


			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	
	//Elenca personale amministrativo di una palestra ordinandoli per cognome
	public Vector<Personale_amministrativo> elencoPA(Palestra p) {
		//nome, cognome
		String query = "SELECT * FROM personale_amministrativo "
				+ "WHERE palestra = ? "
				+ "ORDER BY cognome";

		Vector<Personale_amministrativo> res = new Vector<Personale_amministrativo>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, p.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Personale_amministrativo personalA = recordToPersonaleA(rs);
				res.add(personalA);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	
	//69. Data una palestra restituire tutti i numeri di telefono dei dipendenti con nome e cognome 
		public Vector<Personale_amministrativo> getTelefonoPA(Palestra p) {
			//telefono, nome, cognome
			String query = "SELECT * FROM Personale_amministrativo WHERE palestra=?";


			Vector<Personale_amministrativo>res = new Vector<Personale_amministrativo>();
			PreparedStatement ps;
			conn = DBManager.startConnection();
			try {
				ps = conn.prepareStatement(query);
				ps.setInt(1, p.getId());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Personale_amministrativo pa= recordToPersonaleA(rs);
					res.add(pa);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBManager.closeConnection();
			return res;
		}

}
