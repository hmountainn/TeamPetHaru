package com.petharu.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petharu.web.entity.Notice;
import com.petharu.web.service.JDBCNoticeService;
import com.petharu.web.service.NoticeService;


@WebServlet("/community/notice/create")
public class NoticeCreateController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		NoticeService noticeService = new JDBCNoticeService();
		
		try {
			Notice notice = new Notice();
			notice.setTitle(title);
			notice.setAdminId(1);
			notice.setContent(content);
			noticeService.insert(notice);

			resp.sendRedirect("list.html");
		} catch (Exception e) {
			resp.sendRedirect("exception.html");
		}
	}
	
}
