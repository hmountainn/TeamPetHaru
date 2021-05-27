package com.petharu.web.controller.petManagement.weightRecord;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.petharu.web.entity.Pet;
import com.petharu.web.service.JDBCWeightService;
import com.petharu.web.service.JdbcPetService;
import com.petharu.web.service.PetService;

@WebServlet("/pet-management/weight-record/pet-list")
public class WeightPetListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		int id_ = 1;
		if (request.getParameter("id") != null) {
			id_ = Integer.parseInt(request.getParameter("id"));
		}
		
		
		JDBCWeightService service = new JDBCWeightService();
		List<Pet> list = service.getpetList(id_);

		request.setAttribute("list", list);
		request.getRequestDispatcher("/pet-management/weight-record/pet-list.jsp").forward(request, response);
	}
}