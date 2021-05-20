package com.petharu.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.petharu.web.entity.Notice;
import com.petharu.web.service.JDBCNoticeService;

@WebServlet("/community/notice/detail")
public class NoticeDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		try {
			String id_ = req.getParameter("id");
			int id = Integer.parseInt(id_);
			JDBCNoticeService noticeService = new JDBCNoticeService();
			Notice notice = noticeService.get(id);
			
			Gson gson = new Gson();
			String json = gson.toJson(notice);
			out.println(json);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}
