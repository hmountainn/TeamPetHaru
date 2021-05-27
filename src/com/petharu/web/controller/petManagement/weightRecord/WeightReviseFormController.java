package com.petharu.web.controller.petManagement.weightRecord;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petharu.web.entity.Weight;
import com.petharu.web.service.JDBCWeightService;

@WebServlet("/pet-management/weight-record/revise-form")
public class WeightReviseFormController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_ = request.getParameter("id");
		int id = Integer.parseInt(id_);
		
		String petid_ = request.getParameter("petid");
		int petid = Integer.parseInt(petid_);
		
		JDBCWeightService weightservice = new JDBCWeightService();
		Weight weight = weightservice.get(id);
		
		request.setAttribute("weight", weight);
		request.getRequestDispatcher("/pet-management/weight-record/revise-form.jsp").forward(request, response);
	}
}
