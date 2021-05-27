package com.petharu.web.controller.community.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petharu.web.service.JDBCNoticeService;
import com.petharu.web.service.NoticeService;


@WebServlet("/community/notice/delete")
public class NoticeDeleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		int id = Integer.parseInt(req.getParameter("id"));

		NoticeService noticeService = new JDBCNoticeService();
		
		try {
			noticeService.delete(id);
		} catch (Exception e) {
			resp.sendRedirect("exception.html");
		}
	}

}
