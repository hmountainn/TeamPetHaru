package com.petharu.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petharu.web.entity.Diary;
import com.petharu.web.entity.DiaryComment;
import com.petharu.web.entity.Friend;
import com.petharu.web.service.FriendService;
import com.petharu.web.service.JdbcFriendDiaryService;

@WebServlet("/friends/list")
public class FriendDiaryListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JdbcFriendDiaryService friendService = new JdbcFriendDiaryService();
		List<Diary> list = null;
		List<DiaryComment> diaryCommentslist =null;		
		int followerCount = 1;
		List<Friend> followerList = null;
		
		try {
			list = friendService.getFriendDiaryList(1);
			diaryCommentslist = friendService.getFriendDiaryCommentList(1);
			followerCount = friendService.getFollowerCount(1);
			System.out.println(followerCount);
			followerList = friendService.getFollowerList(1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(list);
		request.setAttribute("list", list);
		request.setAttribute("diaryCommentslist", diaryCommentslist);
		request.setAttribute("followerCount", followerCount);
		request.setAttribute("followerList", followerList);
		
		request.getRequestDispatcher("/friends/list.jsp").forward(request, response);//
	}

}
