package com.petharu.web.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.petharu.web.entity.Pet;
import com.petharu.web.service.PetService;

@WebServlet("/api/pet-management/mypet/list")
public class PetList extends HttpServlet {
	//¸ñ·Ï
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		

		try {		
			int id_ = 1;
			if (req.getParameter("id") != null) {
				Integer.parseInt(req.getParameter("id"));				
			}
			String name = req.getParameter("name");
			System.out.println(name);
			String breed = req.getParameter("breed");			
			System.out.println(id_);
			
			PetService petService = new PetService();
			List<Pet> list = petService.getList(name,breed,id_);
//			List<Pet> list = petService.getList();
			
			Gson gson = new Gson();				
			String json = gson.toJson(list);
			System.out.println(json.toString());
			
			out.println(json);
						
		System.out.println("list");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
