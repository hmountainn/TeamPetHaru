package com.petharu.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.petharu.web.entity.Notice;

public class JDBCNoticeService implements NoticeService {

	@Override
	public List<Notice> getList() {
		return getList(1, "title", "", "desc", 10);
	}

	@Override
	public List<Notice> getList(int page, String field, String query, String sort, int size) {
		
		List<Notice> list = new ArrayList<>();
		
		int startIdx = (page-1)*size + 1;
		int endIdx = size*page;
		
//		String sql = "SELECT * FROM ("
//				+ "    SELECT ROWNUM \"INDEX\", N.*"
//				+ "    FROM"
//				+ "    (SELECT *"
//				+ "    FROM NOTICE"
//				+ "    WHERE "+field+" LIKE '%"+query+"%'"
//				+ "    ORDER BY REGDATE DESC"
//				+ "    ) N)"
//				+ "    WHERE \"INDEX\" BETWEEN "+startIdx+" AND "+endIdx;
		
		String sql = "SELECT N.RN, N.ID, N.TITLE, N.ADMIN_ID, N.USER_ID, N.REGDATE, N.HIT, N.CONTENT, N.FILES"
				+ "    FROM ("
				+ "        SELECT ROWNUM RN, NV.*"
				+ "        FROM ("
				+ "            SELECT *"
				+ "            FROM NOTICE_VIEW"
				+ "            WHERE "+field+" LIKE '%"+query+"%'"
				+ "            ORDER BY REGDATE " + sort
				+ "        ) NV"
				+ "    ) N"
				+ "    WHERE RN BETWEEN "+startIdx+" AND "+endIdx;
		
		try {
			
			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				int adminId = rs.getInt("admin_id");
				String userId = rs.getString("user_id");
				Date regdate = rs.getDate("regdate");
				int hit = rs.getInt("hit");
				String content = rs.getString("content");
				String files = rs.getString("files");
				
				Notice notice = new Notice();
				notice.setId(id);
				notice.setTitle(title);
				notice.setAdminId(adminId);
				notice.setUserId(userId);
				notice.setRegdate(regdate);
				notice.setHit(hit);
				notice.setContent(content);
				notice.setFiles(files);
				
				list.add(notice);
			}
			
			rs.close();
			st.close();
			con.close();
		
			return list;

		} catch (Exception e) {
			throw new ServiceException();
		}
		
	}
	
	@Override
	public int getCount(String field, String query) {
		
		int count = 0;
		
		String sql = "SELECT COUNT(ID) COUNT"
				+ "    FROM NOTICE"
				+ "    WHERE "+field+" LIKE '%"+query+"%'";
		
		try {
			
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
			
		} catch (Exception e) {
			throw new ServiceException();
		}
		
		return count;
	}
	
	@Override
	public Notice get(int id) {
		
		String sql = String.format("SELECT * FROM NOTICE_VIEW N WHERE N.ID=%d", id);
		
		try {

			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			rs.next();
	
			String title = rs.getString("title");
			int adminId = rs.getInt("admin_id");
			String userId = rs.getString("user_id");
			Date regdate = rs.getDate("regdate");
			int hit = rs.getInt("hit");
			String content = rs.getString("content");
			String files = rs.getString("files");
			String upTitle = rs.getString("up_title");
			int upId = rs.getInt("up_id");
			String downTitle = rs.getString("down_title");
			int downId = rs.getInt("down_id");
			
			
			Notice notice = new Notice();
			notice.setId(id);
			notice.setTitle(title);
			notice.setAdminId(adminId);
			notice.setUserId(userId);
			notice.setRegdate(regdate);
			notice.setHit(hit);
			notice.setContent(content);
			notice.setFiles(files);
			notice.setUpTitle(upTitle);
			notice.setUpId(upId);
			notice.setDownTitle(downTitle);
			notice.setDownId(downId);
			
			rs.close();
			st.close();
			con.close();
			
			return notice;
			
		} catch (Exception e) {
			throw new ServiceException();
		}
		
	}

	@Override
	public int delete(int id) {

		int result = 0;
		
		String sql = "DELETE FROM NOTICE WHERE ID=?";
		
		try {
			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
		} catch (Exception e) {
			throw new ServiceException();
		}
		
		return result;
	}

	@Override
	public int insert(Notice notice) {
		
		int result = 0;
		
		String sql = "INSERT INTO NOTICE(TITLE, ADMIN_ID, CONTENT, FILES) VALUES(?, ?, ?, ?)";
		
		try {
			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setInt(2, notice.getAdminId());
			st.setString(3, notice.getContent());
			st.setString(4, notice.getFiles());
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
		} catch (Exception e) {
			throw new ServiceException();
		}
		
		return result;
	}

	@Override
	public int update(Notice notice) {
		
		int result = 0;
		
		String sql = "UPDATE NOTICE SET TITLE=?, CONTENT=?, HIT=?, FILES=? WHERE ID=?";
		
		try {
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
		} catch (Exception e) {
			throw new ServiceException();
		}
		
		return result;
	}

	@Override
	public int hitUp(Notice notice) {
		
		int result = 0;
		
		String sql = String.format("UPDATE NOTICE SET HIT=HIT+1 WHERE ID=?");
		
		try {
			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, notice.getId());
			result = st.executeUpdate();
			
			st.close();
			con.close();
		} catch (Exception e) {
			throw new ServiceException();
		}
		
		return result;
	}
	
	
}
