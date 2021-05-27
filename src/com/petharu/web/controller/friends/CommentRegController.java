package com.petharu.web.controller.friends;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petharu.web.entity.DiaryComment;
import com.petharu.web.service.JDBCInfluenceService;

@WebServlet("/friends/DiaryComment")
public class CommentRegController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String diaryId_ = req.getParameter("diaryId");
		int diaryId = Integer.parseInt(diaryId_);
		String memberId_ = req.getParameter("memberId");
		int memberId = Integer.parseInt(memberId_);
		String userId = req.getParameter("userId");
		String comment = req.getParameter("comment");
		
		System.out.println(diaryId);
		System.out.println(memberId);
		System.out.println(userId);
		System.out.println(comment);
		
		JDBCInfluenceService service = new JDBCInfluenceService();
		
		DiaryComment dcomment = new DiaryComment();
		dcomment.setContent(comment);
		dcomment.setMemberId(memberId);
		dcomment.setDiaryId(diaryId);
		dcomment.setUserId(userId);
		service.insert(dcomment);
		
		resp.sendRedirect("influence");
	}

}
