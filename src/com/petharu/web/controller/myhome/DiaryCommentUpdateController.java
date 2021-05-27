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

@WebServlet("/myhome/comment/update")
public class DiaryCommentUpdateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		int id = Integer.parseInt(req.getParameter("comment-id")); 
		String content = req.getParameter("comment-content");
		
		DiaryCommentService diaryCommentSerivce = new JDBCDiaryCommentService();
		
		try {
			DiaryComment diaryComment = diaryCommentSerivce.get(id);
			diaryComment.setContent(content);
			diaryCommentSerivce.update(diaryComment);
		} catch(Exception e) {
			resp.sendRedirect("/myhome/exception.html");
		}

	}
	
}
