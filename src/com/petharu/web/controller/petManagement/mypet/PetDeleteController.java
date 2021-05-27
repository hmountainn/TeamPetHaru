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
import com.petharu.web.service.NoticeService;
import com.petharu.web.service.PetService;
import com.petharu.web.service.ServiceException;

@WebServlet("/pet-management/mypet/del")
public class PetDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));

		PetService petService = new JdbcPetService();
		
		try {
			petService.deletePetProfile(id);
			//resp.sendRedirect("list.html");
		} catch (Exception e) {
			throw new ServiceException();
		}
		resp.sendRedirect("/pet-management/mypet/list");
	}
}
