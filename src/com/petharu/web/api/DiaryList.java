package com.petharu.web.api;

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
import com.petharu.web.entity.Diary;
import com.petharu.web.entity.DiaryView;
import com.petharu.web.service.JDBCMyhomeService;
import com.petharu.web.service.MyhomeService;


@WebServlet("/api/myhome/list")
public class DiaryList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		try {
			String p = req.getParameter("page");
			String m = req.getParameter("memberId");

			int page = 1;
			int memberId = 1;
			
			if (p != null && !p.equals("")) {
				page = Integer.parseInt(p);
			}			
			if (m != null && !m.equals("")) {
				memberId = Integer.parseInt(m);
			}
			
			MyhomeService myhomeService = new JDBCMyhomeService();
			List<DiaryView> list = myhomeService.getViewList(page, memberId);
			
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.println(json);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
}
