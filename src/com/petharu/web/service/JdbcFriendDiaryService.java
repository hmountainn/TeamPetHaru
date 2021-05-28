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
import com.petharu.web.entity.FriendDiaryView;
import com.petharu.web.entity.Member;
import com.petharu.web.entity.Pet;

public class JdbcFriendDiaryService implements FriendService {

	public List<FriendDiaryView> getFriendDiaryList() throws ClassNotFoundException, SQLException {
		return getFriendDiaryList(1);
	}

	public List<FriendDiaryView> getFriendDiaryList(int memberId) throws ClassNotFoundException, SQLException {
		List<FriendDiaryView> list = new ArrayList<>();

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM FRIEND_DIARY_VIEW WHERE FOLLOWER_ID =" + memberId;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				String userId = rs.getString("user_id");
				String keyword = rs.getString("keyword");
				String content = rs.getString("content");
				int followerId = rs.getInt("follower_id");
				java.sql.Date regDate = rs.getDate("regdate");

				FriendDiaryView diary = new FriendDiaryView();
				diary.setUserId(userId);
				diary.setKeyword(keyword);
				diary.setContent(content);
				diary.setMemberId(followerId);
				diary.setRegDate(regDate);			

				list.add(diary);
			}
			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
//			throw new ServiceException();
			e.printStackTrace();
		}

		return list;

	}

	public List<DiaryComment> getFriendDiaryCommentList() throws ClassNotFoundException, SQLException {
		List<DiaryComment> list = new ArrayList<>();
		System.out.println("다이어리 댓글:" + list);

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM DIARY_COMMENT_VIEW";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("id");
				String content = rs.getString("content");
				java.sql.Date regDate = rs.getDate("regdate");
				String userId = rs.getString("USER_ID");

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
		int followerCnt = 0;
		String sql = "SELECT COUNT(FOLLOWER_ID) followerCnt FROM FRIEND WHERE MEMBER_ID =" + memberId;

		try {
			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next())
				followerCnt = rs.getInt("followerCnt");

			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("팔로워 숫자 :" + followerCnt);
		return followerCnt;

	}

	public List<Friend> getRequestCount() throws ClassNotFoundException, SQLException {
		return null;

	}

	@Override
	public List<Friend> getFollowerList(int memberId) throws ClassNotFoundException, SQLException {
		List<Friend> list = new ArrayList<>();
		System.out.println("팔로워리스트 :" + list);

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT F.*,M.USER_ID FROM FRIEND F LEFT JOIN MEMBER M ON F.FOLLOWER_ID = M.ID WHERE MEMBER_ID ="
				+ memberId;

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

	@Override
	public List<Friend> getFollowingList(int mebmerId) throws ClassNotFoundException, SQLException {
		List<Friend> list = new ArrayList<>();
		System.out.println("팔로잉리스트 :" + list);

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT F.*,M.USER_ID FROM FRIEND F LEFT JOIN MEMBER M ON F.MEMBER_ID = M.ID WHERE FOLLOWER_ID ="
				+ mebmerId;

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

	@Override
	public int getFollowingCount(int memberId) throws ClassNotFoundException, SQLException {
		int followingCnt = 0;
		String sql = "SELECT COUNT(FOLLOWER_ID) followingCnt FROM FRIEND WHERE FOLLOWER_ID = " + memberId;

		try {
			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next())
				followingCnt = rs.getInt("followingCnt");

			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("팔로잉 숫자 :" + followingCnt);
		return followingCnt;

	}

	@Override
	public List<Member> getMemberList(String query) throws ClassNotFoundException, SQLException {
		List<Member> list = new ArrayList<>();

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT*FROM MEMBER WHERE USER_ID LIKE '%" + query + "%'";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("id");
				String userId = rs.getString("user_id");

				Member member = new Member();
				member.setId(id);
				member.setUserId(userId);

				list.add(member);
			}
			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
//			throw new ServiceException();
			e.printStackTrace();
		}

		return list;
	}
}
