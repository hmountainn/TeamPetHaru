package com.petharu.web.controller.myhome;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petharu.web.entity.Diary;
import com.petharu.web.entity.DiaryView;
import com.petharu.web.service.JDBCMyhomeService;
import com.petharu.web.service.MyhomeService;


@WebServlet("/myhome/edit")
public class EditController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		int id = Integer.parseInt(req.getParameter("id"));
		String content = req.getParameter("content");
		String keyword = req.getParameter("keyword");
	
		MyhomeService myhomeService = new JDBCMyhomeService();
		DiaryView diary = null;
		
		try {
			diary = myhomeService.get(id);
			diary.setMemberId(1);
			diary.setKeyword(keyword);
			diary.setContent(content);
			myhomeService.update(diary);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		resp.sendRedirect("list.html");
	
	}
}
	