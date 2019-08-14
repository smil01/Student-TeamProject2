package main.member.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import main.member.DTO.memberDTO;
import main.test.DTO.TestDTO;


public class memberDAO {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private static memberDAO dao;

	public static memberDAO getDao() {
		if (dao == null) {
			dao = new memberDAO();
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
	
	public boolean insert(memberDTO dto) {
		try {
			getCon();

			String sql = "INSERT INTO MEMBERS(NAME, ID, PW) VALUES(?,?,?)";
			
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, dto.getName());
			pst.setString(2, dto.getId());
			pst.setString(3, dto.getPw());
			
			int cnt = pst.executeUpdate();
			
			if(cnt > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return false;
	}
	
	public memberDTO select(memberDTO dto) {
		try {
			getCon();

			String sql = "SELECT * FROM MEMBERS WHERE ID = ? AND PW = ?";
			
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, dto.getId());
			pst.setString(2, dto.getPw());
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				return new memberDTO(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return null;
	}
}
