package it.pale.tweb.dao.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Connection;
import it.pale.tweb.dao.utils.DBManager;


public class NewsDAO {
	private static Connection conn = null;

	public News get(News news) {
		String query = "SELECT * FROM News WHERE Id=?";

		News res = null;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, news.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res = recordToNews(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public boolean salva(News news) {
		String query = "INSERT INTO News VALUES ( ?, ?, ?, ?)";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, news.getId());
			ps.setString(2, news.getTesto());

			java.sql.Date data=new java.sql.Date(news.getData().getTime());
			ps.setDate(3, data);
			ps.setLong(4, news.getPalestra());

			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	private News recordToNews(ResultSet rs) throws SQLException {
		News news = new News();
		news.setId(rs.getInt("id"));
		news.setTesto(rs.getString("testo"));
		news.setData(rs.getDate("data"));
		news.setPalestra(rs.getInt("palestra"));


		return news;
	}

	public boolean elimina(News news) {
		String query = "DELETE FROM News WHERE Id = ?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, news.getId());

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

	public Vector<News> getAll() {
		String query = "SELECT * FROM News order by Id";

		Vector<News> res = new Vector<News>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				News news = recordToNews(rs);
				res.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public boolean modifica(News news) {
		String query = "UPDATE News SET testo=?, data=?, palestra=? WHERE id=?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, news.getTesto());
			ps.setDate(2, new java.sql.Date(news.getData().getTime()));
			ps.setInt(3, news.getPalestra());
			ps.setInt(4, news.getId());

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
