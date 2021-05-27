package com.petharu.web.controller.petManagement.weightRecord;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pet-management/weight-record/form")
public class WeightFormController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id_ = request.getParameter("petid");
		int petid = Integer.parseInt(id_);
		
		request.setAttribute("petid", petid);
		request.getRequestDispatcher("/pet-management/weight-record/form.jsp").forward(request, response);
	}
}
