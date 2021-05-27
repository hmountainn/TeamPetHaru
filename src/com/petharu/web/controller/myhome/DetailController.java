package com.petharu.web.controller.myhome;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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

@WebServlet("/myhome/detail")
public class DetailController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();

		try {
			String id_ = req.getParameter("id");
			int id = Integer.parseInt(id_);
			
			MyhomeService myhomeService = new JDBCMyhomeService();
			DiaryView diaryView = myhomeService.get(id);
			
			Gson gson = new Gson();
			String json = gson.toJson(diaryView);
			out.println(json);
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
}
