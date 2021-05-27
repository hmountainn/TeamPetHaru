package com.petharu.web.controller.petManagement.weightRecord;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petharu.web.entity.Weight;
import com.petharu.web.service.JDBCWeightService;

@WebServlet("/pet-management/weight-record/table")
public class WeightTableListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id_ = request.getParameter("petid");
		int petid = 1;
		
		
		if (request.getParameter("petid") != null) {
			id_ = request.getParameter("petid");
			petid = Integer.parseInt(id_);
		}


	    JDBCWeightService weightservice = new JDBCWeightService();
	    List<Weight> list = weightservice.getList(petid);
	    
	    request.setAttribute("list", list);
		request.getRequestDispatcher("/pet-management/weight-record/table.jsp").forward(request, response);
	}
}
