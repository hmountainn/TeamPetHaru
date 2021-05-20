package com.petharu.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petharu.web.entity.Notice;
import com.petharu.web.service.NoticeService;


@WebServlet("/community/notice/create")
public class NoticeCreate extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		NoticeService noticeService = new NoticeService();
		
		try {
			Notice notice = new Notice();
			notice.setTitle(title);
			notice.setAdminId(1);
			notice.setContent(content);
			noticeService.insert(notice);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("list.html");
		
	}
	
}
