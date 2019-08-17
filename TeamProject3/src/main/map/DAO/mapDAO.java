package main.map.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import main.map.DTO.mapDTO;
import main.map.DTO.searchDTO;

public class mapDAO {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private static mapDAO dao;

	public static mapDAO getDao() {
		if (dao == null) {
			dao = new mapDAO();
		}
		return dao;
	}

	private void getCon() {
		try {
			InputStream in = this.getClass().getResourceAsStream("../../db.properties");
			Properties p = new Properties();
			p.load(in);

			Class.forName(p.getProperty("driver"));

			String url = p.getProperty("url");
			String user = p.getProperty("id");
			String password = p.getProperty("pw");

			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}

			if (pst != null) {
				pst.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<mapDTO> select(String column, String table, String max, String desc, String dong) {
		ArrayList<mapDTO> list = new ArrayList<mapDTO>();
		try {
			getCon();

			String sql = "SELECT * FROM (SELECT X, Y, DONG, " + column + " FROM " + table + " WHERE " + dong + " ORDER BY "
					+ desc + " DESC) WHERE ROWNUM <= " + max;

			System.out.println("========================= SQL 커멘드 확인 :" + sql);

			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				list.add(new mapDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}
}
