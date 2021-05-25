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
import com.petharu.web.entity.Notice;
import com.petharu.web.service.JDBCNoticeService;
import com.petharu.web.service.NoticeService;


@WebServlet("/api/notice/list")
public class NoticeList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();

		try {
			
			String p = req.getParameter("page");
			String f = req.getParameter("field");
			String q = req.getParameter("query");
			String srt = req.getParameter("sort");
			String sz = req.getParameter("size");

			int page = 1;
			String field = "title";
			String query = "";
			String sort = "desc";
			int size = 10;
	
			if (p != null && !p.equals("")) {
				page = Integer.parseInt(p);
			}			
			if (f != null && !f.equals("")) {
				field = f;
			}			
			if (q != null && !q.equals("")) {
				query = q;
			}
			if (srt != null && !srt.equals("")) {
				sort = srt;
			}
			if (sz != null && !sz.equals("")) {
				size = Integer.parseInt(sz);
			}

			NoticeService noticeService = new JDBCNoticeService();
			List<Notice> list = noticeService.getList(page, field, query, sort, size);

			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.println(json);
			
		} catch (Exception e) {
			resp.sendRedirect("/community/notice/exception.html");
		}
		
	}
	
}
