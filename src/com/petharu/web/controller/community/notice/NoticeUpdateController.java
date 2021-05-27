package com.petharu.web.controller.community.notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.petharu.web.entity.Notice;
import com.petharu.web.service.JDBCNoticeService;
import com.petharu.web.service.NoticeService;

@WebServlet("/community/notice/update")
public class NoticeUpdateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		NoticeService noticeService = new JDBCNoticeService();
		
		try {
			Notice notice = noticeService.get(id);
			notice.setTitle(title);
			notice.setContent(content);
			noticeService.update(notice);			
		} catch (Exception e) {
			resp.sendRedirect("exception.html");
		}
	}
	
}
