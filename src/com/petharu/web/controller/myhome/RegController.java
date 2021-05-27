package com.petharu.web.controller.myhome;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petharu.web.entity.Diary;
import com.petharu.web.entity.Knowhow;
import com.petharu.web.service.JDBCKnowhowService;
import com.petharu.web.service.JDBCMyhomeService;
import com.petharu.web.service.KnowhowService;
import com.petharu.web.service.MyhomeService;

@WebServlet("/myhome/reg")
public class RegController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String content = req.getParameter("content");
		String keyword = req.getParameter("keyword");

		MyhomeService myhomeService = new JDBCMyhomeService();
		
		try {
			
			Diary diary = new Diary();
			diary.setMemberId(1); // 수정 필요
			diary.setKeyword(keyword);
			diary.setContent(content);
			myhomeService.insert(diary);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		resp.sendRedirect("list.html");
	};
	
}
