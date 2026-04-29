package it.pale.tweb.dao.beans;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Connection;
import it.pale.tweb.dao.utils.DBManager;


public class Istruttore_salaDAO {
	private static Connection conn = null;

	public Istruttore_sala get(Istruttore_sala istruttoreS) {
		String query = "SELECT * FROM Istruttore_sala WHERE matricola=?";

		Istruttore_sala res = null;
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

	private Istruttore_sala recordToIstruttoreS(ResultSet rs) throws SQLException {
		Istruttore_sala istruttoreS = new Istruttore_sala();
		istruttoreS.setMatricola(rs.getInt("matricola"));
		istruttoreS.setNome(rs.getString("nome"));
		istruttoreS.setCognome(rs.getString("cognome"));
		istruttoreS.setPalestra(rs.getInt("palestra"));
		istruttoreS.setTelefono(rs.getLong("telefono"));


		return istruttoreS;
	}

	public Vector<Istruttore_sala> getAll() {
		String query = "SELECT * FROM Istruttore_sala order by matricola";

		Vector<Istruttore_sala> res = new Vector<Istruttore_sala>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Istruttore_sala istruttoreS = recordToIstruttoreS(rs);
				res.add(istruttoreS);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public boolean salva(Istruttore_sala istruttoreS) {
		String query = "INSERT INTO Istruttore_sala VALUES ( ?, ?, ?, ?, ?)";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, istruttoreS.getMatricola());
			ps.setString(2, istruttoreS.getNome());
			ps.setString(3, istruttoreS.getCognome());
			ps.setInt(4, istruttoreS.getPalestra());
			ps.setLong(5, istruttoreS.getTelefono());


			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean elimina(Istruttore_sala istruttoreS) {
		String query = "DELETE FROM Istruttore_sala WHERE matricola = ?";
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

	public boolean modifica(Istruttore_sala istruttoreS) {
		String query = "UPDATE Istruttore_sala SET nome=?, cognome=?, palestra=?, telefono=? WHERE matricola=?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, istruttoreS.getNome());
			ps.setString(2, istruttoreS.getCognome());
			ps.setInt(3, istruttoreS.getPalestra());
			ps.setLong(4, istruttoreS.getTelefono());
			ps.setInt(5, istruttoreS.getMatricola());


			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	
	//Elenca istruttori di sala di una palestra ordinandoli per cognome
	public Vector<Istruttore_sala> elencoIS(Palestra p) {
		String query = "SELECT cognome, nome FROM istruttore_sala"
				+ "WHERE palestra = ?"
				+ "ORDER BY cognome";

		Vector<Istruttore_sala> res = new Vector<Istruttore_sala>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ps.setInt(1, p.getId());
			while (rs.next()) {
				Istruttore_sala istruttoreS = recordToIstruttoreS(rs);
				res.add(istruttoreS);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	
	//69 Data una palestra restituire tutti i numeri di telefono dei dipendenti con nome e cognome
	public Vector<String> getTelefonoIS(Palestra p) {
		String query = "SELECT nome, cognome, telefono FROM Istruttore_sala WHERE palestra=?";

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
