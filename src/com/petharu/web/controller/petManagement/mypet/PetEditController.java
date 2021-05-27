package com.petharu.web.controller.petManagement.mypet;

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

@WebServlet("/pet-management/mypet/edit")
public class PetEditController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		req.setCharacterEncoding("UTF-8");

		resp.setCharacterEncoding("UTF-8");		
		resp.setContentType("text/html; charset=UTF-8");
		int id_ = 0;
		if (req.getParameter("id") != null) {
			id_ = Integer.parseInt(req.getParameter("id"));
		}
		int breedId = 0;
		if (req.getParameter("breed_id") != null) {
			breedId = Integer.parseInt(req.getParameter("breed_id"));

		}
		System.out.println(id_);
		String name = req.getParameter("name");
		System.out.println(name);
		String gender = req.getParameter("gender");
		String birthday = req.getParameter("birthday");
		String personality = req.getParameter("personality");
		System.out.println(breedId);

		PetService petService = new JdbcPetService();
		Pet pet = null;

		try {
			pet = petService.get(id_);//펫id
			pet.setId(id_);
			pet.setName(name);
			pet.setGender(gender);
			pet.setBirthday(birthday);
			pet.setPersonality(personality);
			pet.setBreedId(breedId);
			petService.updatePetProfile(pet);


		} catch (Exception e) {
			resp.sendRedirect("exception.html");
		}
		
		req.setAttribute("pet", pet);
//		resp.sendRedirect("/pet-management/mypet/list");
		out.println("<script>location.href='/pet-management/mypet/list'</script>");

	}
}
