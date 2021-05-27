package com.petharu.web.controller.myhome;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petharu.web.entity.DiaryComment;
import com.petharu.web.service.DiaryCommentService;
import com.petharu.web.service.JDBCDiaryCommentService;

@WebServlet("/myhome/comment/create")
public class DiaryCommentCreateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		String content = req.getParameter("comment-content");
		int memberId = Integer.parseInt(req.getParameter("comment-member-id"));
		int diaryId = Integer.parseInt(req.getParameter("diary-id"));
		
		DiaryCommentService diaryCommentService = new JDBCDiaryCommentService();
		
		try {
			DiaryComment diaryComment = new DiaryComment();
			diaryComment.setContent(content);
			diaryComment.setMemberId(memberId);
			diaryComment.setDiaryId(diaryId);
			diaryCommentService.insert(diaryComment);			
		} catch(Exception e) {
			resp.sendRedirect("/myhome/exception.html");
		}
	}
	
}
