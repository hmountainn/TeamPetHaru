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
import com.petharu.web.entity.Knowhow;
import com.petharu.web.entity.KnowhowView;
import com.petharu.web.service.JDBCKnowhowService;
import com.petharu.web.service.KnowhowService;

@WebServlet("/api/knowhow/list")
public class KnowhowList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		try {
			
			String p = req.getParameter("page");
			String p_ = req.getParameter("pet");

			int page = 1;
			String pet = "";
			
			if (p != null && !p.equals("")) {
				page = Integer.parseInt(p);
			}			
			if (p_ != null && !p_.equals("")) {
				pet = p_;
			}
			
			KnowhowService knowhowService = new JDBCKnowhowService();
			List<KnowhowView> list = knowhowService.getViewList();
			
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.println(json);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
}
