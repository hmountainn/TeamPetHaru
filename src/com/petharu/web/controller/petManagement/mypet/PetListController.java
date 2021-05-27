package com.petharu.web.controller.petManagement.mypet;

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
import com.petharu.web.service.JdbcPetService;
import com.petharu.web.service.PetService;

@WebServlet("/pet-management/mypet/list")
public class PetListController extends HttpServlet {
	// ���
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/x-json; charset=UTF-8");
		PrintWriter out = response.getWriter();

		request.setCharacterEncoding("UTF-8");

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		int id_ = 1;
		if (request.getParameter("id") != null) {
			id_ = Integer.parseInt(request.getParameter("id"));
		}
//			String name = req.getParameter("name");
//			System.out.println(name);
//			String breed = req.getParameter("breed");			
		PetService petService = new JdbcPetService();
		List<Pet> list = petService.getPetList(id_);

		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json.toString());

		out.println(json);

		request.setAttribute("list", list);

		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
}