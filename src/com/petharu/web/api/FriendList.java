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
import com.petharu.web.entity.Diary;
import com.petharu.web.entity.FriendDiaryView;
import com.petharu.web.entity.Pet;
import com.petharu.web.service.FriendService;
import com.petharu.web.service.JdbcFriendDiaryService;
import com.petharu.web.service.JdbcPetService;

@WebServlet("/api/friends/list")
public class FriendList extends HttpServlet {
	
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
			
			FriendService friendService = new JdbcFriendDiaryService();
			List<FriendDiaryView> list = friendService.getFriendDiaryList(id_);
			
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
