package com.petharu.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
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

@WebServlet("/pet-management/mypet/reg")
public class RegPetController extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setCharacterEncoding("UTF-8");

		resp.setCharacterEncoding("UTF-8");		
		resp.setContentType("text/html; charset=UTF-8");
		int id_ = 1;
		if (req.getParameter("id") != null) {
			Integer.parseInt(req.getParameter("id"));
		}
			String name = req.getParameter("name");
			System.out.println(name);
			String gender = req.getParameter("gender");	
			String birthday = req.getParameter("birthday");	
			String personality = req.getParameter("personality");	
			System.out.println(name);

		PetService petService = new JdbcPetService();
		List<Pet> list = petService.getPetList(id_);
		Pet pet = new Pet();

		try {
			pet.setName(name);
			pet.setGender(gender);
			pet.setBirthday(birthday);
			pet.setPersonality(personality);
			pet.setMemberId(id_);
			petService.insertPetProfile(pet);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect("/pet-management/mypet/list.jsp");
//		req.setAttribute("pet", pet);
//		req.getRequestDispatcher("/pet-management/mypet/list.jsp").forward(req, resp);

	}
}
