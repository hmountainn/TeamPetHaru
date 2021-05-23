package com.petharu.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.petharu.web.entity.DiaryComment;

public class JDBCDiaryCommentService implements DiaryCommentService {

	@Override
	public List<DiaryComment> getList(int diaryId) {
		
		List<DiaryComment> list = new ArrayList<>();
		
		String sql = String.format("SELECT *"
				+ "    FROM DIARY_COMMENT_VIEW"
				+ "    WHERE DIARY_ID=%d"
				+ "    ORDER BY REGDATE", diaryId);
		
		try {
			
			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String content = rs.getString("content");
				Date regdate = rs.getDate("regdate");
				int memberId = rs.getInt("member_id");
				String userId = rs.getString("user_id");
				
				DiaryComment diaryComment = new DiaryComment();
				diaryComment.setId(id);
				diaryComment.setContent(content);
				diaryComment.setRegdate(regdate);
				diaryComment.setMemberId(memberId);
				diaryComment.setDiaryId(diaryId);
				diaryComment.setUserId(userId);
				
				list.add(diaryComment);
			}
			
			rs.close();
			st.close();
			con.close();
		
			return list;
			
		} catch(Exception e) {
			throw new ServiceException();
		}

	};

	@Override
	public int delete(int id) {
		
		int count = 0;
		
		return count;
	};
	
	@Override
	public int insert(DiaryComment diaryComment) {
		
		int count = 0;
		
		return count;
	};
	
	@Override
	public int update(DiaryComment diaryComment) {
		
		int count = 0;
		
		return count;
	};

	@Override
	public int reply(DiaryComment diaryComment) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
