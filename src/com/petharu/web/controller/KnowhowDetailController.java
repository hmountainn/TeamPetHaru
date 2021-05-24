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

@WebServlet("/community/knowhow/detail")
public class KnowhowDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id_ = request.getParameter("id");
		int id = Integer.parseInt(id_);
		
		KnowhowService knowhowService = new JDBCKnowhowService();
		Knowhow knowhow = null;
		
		try {
			
			knowhow = knowhowService.get(id);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		request.setAttribute("knowhow", knowhow);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}
}
