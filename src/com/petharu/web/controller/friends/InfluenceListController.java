package com.petharu.web.controller.friends;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petharu.web.entity.Influence;
import com.petharu.web.service.JDBCInfluenceService;

@WebServlet("/friends/influence")
public class InfluenceListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		JDBCInfluenceService service = new JDBCInfluenceService();
		List<Influence> list = service.getList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/friends/influence.jsp").forward(request, response);
		
	}
}
