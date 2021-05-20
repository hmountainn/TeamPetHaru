package com.petharu.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.petharu.web.entity.Notice;


public class NoticeService {
	
	public List<Notice> getList() throws ClassNotFoundException, SQLException {
		return getList(1, "title", "");
	}

	public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		
		List<Notice> list = new ArrayList<>();
		
		int size = 10;
		int startIdx = (page-1)*size + 1;
		int endIdx = size*page;
		
		String sql = "SELECT * FROM ("
				+ "    SELECT ROWNUM \"INDEX\", N.*"
				+ "    FROM"
				+ "    (SELECT *"
				+ "    FROM NOTICE"
				+ "    WHERE "+field+" LIKE '%"+query+"%'"
				+ "    ORDER BY REGDATE DESC"
				+ "    ) N)"
				+ "    WHERE \"INDEX\" BETWEEN "+startIdx+" AND "+endIdx;
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			int adminId = rs.getInt("admin_id");
			Date regDate = rs.getDate("regdate");
			int hit = rs.getInt("hit");
			String content = rs.getString("content");
			String files = rs.getString("files");
			
			Notice notice = new Notice();
			notice.setId(id);
			notice.setTitle(title);
			notice.setAdminId(adminId);
			notice.setRegDate(regDate);
			notice.setHit(hit);
			notice.setContent(content);
			notice.setFiles(files);
			
			list.add(notice);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
	
	public int getCount(String field, String query) throws ClassNotFoundException, SQLException {
		
		int count = 0;
		
		String sql = "SELECT COUNT(ID) COUNT"
				+ "    FROM NOTICE"
				+ "    WHERE "+field+" LIKE '%"+query+"%'";
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		rs.next();
		count = rs.getInt("count");
		
		rs.close();
		st.close();
		con.close();
		
		return count;
	}
	
	public Notice get(int id) throws ClassNotFoundException, SQLException {
		
		String sql = String.format("SELECT * FROM NOTICE WHERE ID=%d", id);
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		rs.next();

		String title = rs.getString("title");
		int adminId = rs.getInt("admin_id");
		Date regDate = rs.getDate("regdate");
		int hit = rs.getInt("hit");
		String content = rs.getString("content");
		String files = rs.getString("files");
		
		Notice notice = new Notice();
		notice.setId(id);
		notice.setTitle(title);
		notice.setAdminId(adminId);
		notice.setRegDate(regDate);
		notice.setHit(hit);
		notice.setContent(content);
		notice.setFiles(files);
		
		rs.close();
		st.close();
		con.close();
		
		return notice;
	}

	public int delete(int id) throws ClassNotFoundException, SQLException {

		int result = 0;
		
		String sql = "DELETE FROM NOTICE WHERE ID=?";
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		
		String sql = "INSERT INTO NOTICE(TITLE, ADMIN_ID, CONTENT) VALUES(?, ?, ?)";
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setInt(2, notice.getAdminId());
		st.setString(3, notice.getContent());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		
		String sql = "UPDATE NOTICE SET TITLE=?, CONTENT=?, HIT=?, FILES=? WHERE ID=?";
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setString(2, notice.getContent());
		st.setInt(3, notice.getHit());
		st.setString(4, notice.getFiles());
		st.setInt(5, notice.getId());
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

}
