package it.pale.tweb.dao.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.pale.tweb.dao.utils.DBManager;

public class AbbonamentoDAO {
	private static Connection conn = null;

	public Abbonamento get(Abbonamento abbonamento) {
		String query = "SELECT * FROM Abbonamento WHERE fattura =?";

		Abbonamento res = null;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, abbonamento.getFattura());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res = recordToAbbonamento(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	private Abbonamento recordToAbbonamento(ResultSet rs) throws SQLException {
		Abbonamento abbonamento = new Abbonamento();
		abbonamento.setFattura(rs.getInt("fattura"));
		abbonamento.setTipo(rs.getString("tipo"));
		abbonamento.setDataScadenza(rs.getDate("dataScadenza"));
		abbonamento.setLimiteIngressi(rs.getInt("limiteIngressi"));
		abbonamento.setIngressi(rs.getInt("ingressi"));
		return abbonamento;
	}

	public Vector<Abbonamento> getAll() {
		String query = "SELECT * FROM Abbonamento order by fattura";

		Vector<Abbonamento> res = new Vector<Abbonamento>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Abbonamento Abbonamento = recordToAbbonamento(rs);
				res.add(Abbonamento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public boolean salva(Abbonamento abbonamento) {
		String query = "INSERT INTO Abbonamento VALUES ( ?, ?, ?, ?, ?)";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, abbonamento.getFattura());
			ps.setString(2, abbonamento.getTipo());

			//converto da util.Date a sql.Date 
			java.sql.Date data=new java.sql.Date(abbonamento.getDataScadenza().getTime());
			ps.setDate(3, data);

			//Gestione null integer
			if (abbonamento.getLimiteIngressi() != null)
				ps.setInt(4, abbonamento.getLimiteIngressi());
			else
				ps.setNull(4, java.sql.Types.INTEGER);

			ps.setInt(5, abbonamento.getIngressi());
			ps.setInt(6, abbonamento.getCosto());
			ps.setInt(7, abbonamento.getCliente());
			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean elimina(Abbonamento abbonamento) {
		String query = "DELETE FROM Abbonamento WHERE fattura = ?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, abbonamento.getFattura());

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

	public boolean modifica(Abbonamento abbonamento) {
		String query = "UPDATE Abbonamento SET tipo=?, dataScadenza=?, limiteIngressi=?, ingressi=?, costo=?, cliente=? WHERE fattura=?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, abbonamento.getTipo());
			//converto da util.Date a sql.Date 
			ps.setDate(2, new java.sql.Date(abbonamento.getDataScadenza().getTime()));
			if (abbonamento.getTipo() != null)
				ps.setInt(3, abbonamento.getLimiteIngressi());
			else
				ps.setNull(3, java.sql.Types.INTEGER);
			ps.setInt(4, abbonamento.getLimiteIngressi());
			ps.setInt(5, abbonamento.getCosto());
			ps.setInt(6, abbonamento.getCliente());
			ps.setInt(7, abbonamento.getFattura());

			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	//Rinnova Abbonamento
	public boolean rinnovaAbbonamento(Abbonamento abbonamento) {
		String query = "UPDATE Abbonamento SET dataScadenza=? WHERE fattura=?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			//converto da util.Date a sql.Date 
			ps.setDate(1, new java.sql.Date(abbonamento.getDataScadenza().getTime()));
			ps.setInt(2, abbonamento.getFattura());

			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	//dato un abbonamento elenca tipo, data e limite di ingressi

	public Abbonamento InfoAbbonamento(Abbonamento abbonamento) {
		String query = "SELECT tipo, dataScadenza, limiteIngressi from Abbonamento WHERE fattura=?";
		Abbonamento res = null;

		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, abbonamento.getFattura());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res = recordToAbbonamento(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;

	}
	//Azzera il numero di ingressi settimanali mantenendo inalterati tutti gli altri valori 

	public boolean IngressiSettimanali (Abbonamento abbonamento) {
		String query=//UPDATE Abbonamento SET limiteIngressi=0 WHERE Fattura=?;
				"SELECT * FROM Abbonamento;"
				+ "UPDATE Abbonamento SET Ingressi = 0;";
		boolean esito=false;

		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps=conn.prepareStatement(query);

			//ps.setInt(1, abbonamento.getFattura());
			//data ????
			int tmp = ps.executeUpdate();
			if(tmp==1)
				esito=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	//Elimina gli ingressi avvenuti più di un anno fa
	public boolean IngressiAnnoPrecedente (Abbonamento abbonamento) {
		String query="DELETE FROM Abbonamento WHERE  dataScadenza < DATE_SUB(NOW(), INTERVAL 1 YEAR)"; //????
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			//ps.setDate(1, new java.sql.Date(abbonamento.getDataScadenza().getTime()));

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
	//Elimina gli abbonamenti scaduti più di due anni fa
	public boolean AbbonamentiScaduti (Abbonamento abbonamento) {
		String query="DELETE FROM Abbonamento WHERE  dataScadenza < DATE_SUB(NOW(), INTERVAL 2 YEAR)"; //????
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			//ps.setDate(1, new java.sql.Date(abbonamento.getDataScadenza().getTime()));

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

}
