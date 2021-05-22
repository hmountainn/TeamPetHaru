package com.petharu.web.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.petharu.web.entity.DiaryComment;
import com.petharu.web.service.DiaryCommentService;
import com.petharu.web.service.JDBCDiaryCommentService;

@WebServlet("/api/myhome/comment/list")
public class DiaryCommentList extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
	
		try {
			
			String id_ = req.getParameter("diary-id");
			int id = Integer.parseInt(id_);
			
			DiaryCommentService diaryCommentService = new JDBCDiaryCommentService();
			List<DiaryComment> list = diaryCommentService.getList(id);

			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.println(json);
			
		} catch (Exception e) {
			resp.sendRedirect("/myhome/exception.html");
		}
		
	}
	
}
