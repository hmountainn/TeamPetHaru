package com.petharu.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.petharu.web.entity.Diary;
import com.petharu.web.entity.DiaryComment;
import com.petharu.web.entity.Friend;
import com.petharu.web.entity.Pet;

public class JdbcFriendDiaryService implements FriendService {

	public List<Diary> getFriendDiaryList() throws ClassNotFoundException, SQLException {
		return getFriendDiaryList(1);
	}

	public List<Diary> getFriendDiaryList(int memberId) throws ClassNotFoundException, SQLException {
		List<Diary> list = new ArrayList<>();

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT D.*,M.USER_ID FROM DIARY D "
				+ "LEFT JOIN MEMBER M ON M.ID = D.MEMBER_ID WHERE MEMBER_ID = " + memberId;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("id");
				String keyword = rs.getString("keyword");
				String content = rs.getString("content");
				java.sql.Date regDate = rs.getDate("regdate");
//			int memberId = rs.getInt("member_id");

				Diary diary = new Diary();
				diary.setId(id);
				diary.setKeyword(keyword);
				diary.setContent(content);
				diary.setRegDate(regDate);
//			diary.setMemberId(memberId);				

				list.add(diary);
			}
			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			throw new ServiceException();
		}

		return list;

	}

	public List<DiaryComment> getFriendDiaryCommentList(int diaryId) throws ClassNotFoundException, SQLException {
		List<DiaryComment> list = new ArrayList<>();

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT DIARY_COMMENT.*,MEMBER.USER_ID FROM DIARY_COMMENT LEFT JOIN MEMBER ON MEMBER.ID = diary_comment.member_id WHERE DIARY_ID="
				+ diaryId;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				
				int id = rs.getInt("id");
				String content = rs.getString("content");
				java.sql.Date regDate = rs.getDate("regdate");
				String userId = rs.getString("user_id");
				
				DiaryComment diary = new DiaryComment();
				diary.setId(id);
				diary.setContent(content);
				diary.setRegdate(regDate);
				diary.setUserId(userId);
				
				list.add(diary);
				
			}
			rs.close();
			st.close();
			con.close();			
		} catch (Exception e) {
			throw new ServiceException();
		}

		return list;
	}

	public int getFollowerCount(int memberId) throws ClassNotFoundException, SQLException {
		int count = 0;
		String sql = "SELECT COUNT(FOLLOWER_ID) COUNT followerCnt FROM FRIEND WHERE MEMBER_ID = " + memberId;

		try {
			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next())
				count = rs.getInt("COUNT");

			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(count);
		return count;

	}

	public List<Friend> getFollowingCount() throws ClassNotFoundException, SQLException {
		return null;

	}

	public List<Friend> getRequestCount() throws ClassNotFoundException, SQLException {
		return null;

	}

	@Override
	public List<Friend> getFollowerList(int memberId) throws ClassNotFoundException, SQLException {
		List<Friend> list = new ArrayList<>();

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT F.*,M.USER_ID FROM FRIEND F LEFT JOIN MEMBER M ON F.MEMBER_ID = M.ID WHERE MEMBER_ID = " + memberId;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				int followerId = rs.getInt("follower_id");
				Date responseDate = rs.getDate("response_date");
				Date requestDate = rs.getDate("request_date");
				String userId = rs.getString("user_id");
		

				Friend friend = new Friend();
				friend.setFollowrId(followerId);
				friend.setRequestDate(requestDate);
				friend.setResponseDate(responseDate);
				friend.setUserId(userId);

				list.add(friend);
			}
			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			throw new ServiceException();
		}

		return list;
	}


}