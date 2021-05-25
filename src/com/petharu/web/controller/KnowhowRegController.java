package com.petharu.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petharu.web.entity.Knowhow;
import com.petharu.web.service.JDBCKnowhowService;
import com.petharu.web.service.KnowhowService;

@WebServlet("/community/knowhow/reg")
public class KnowhowRegController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String pet = req.getParameter("pet");
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		KnowhowService knowhowService = new JDBCKnowhowService();
		
		try {
			
			Knowhow knowhow = new Knowhow();
			knowhow.setMemberId(1); // 수정 필요
			knowhow.setKnowhowTypeName(pet);
			knowhow.setTitle(title);
			knowhow.setContent(content);
			knowhowService.insert(knowhow);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		resp.sendRedirect("list");
	};
	
}
