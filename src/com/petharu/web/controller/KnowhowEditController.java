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

@WebServlet("/community/knowhow/edit")
public class KnowhowEditController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		int id = Integer.parseInt(req.getParameter("id"));
		String pet = req.getParameter("pet");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
	
		KnowhowService service = new JDBCKnowhowService();
		
		Knowhow knowhow;
		
		try {
			
			knowhow = service.get(id);
			knowhow.setKnowhowTypeName(pet);
			knowhow.setTitle(title);
			knowhow.setContent(content);
			service.update(knowhow);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("detail.jsp?id="+id);
	
	}
}
	