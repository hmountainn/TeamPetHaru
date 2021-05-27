package com.petharu.web.controller.petManagement.weightRecord;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petharu.web.service.JDBCWeightService;

@WebServlet("/pet-management/weight-record/del")
public class WeightDelController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		int petid = Integer.parseInt(req.getParameter("petid"));
		
		JDBCWeightService service = new JDBCWeightService();
		
		try {
			service.delete(id);
		} catch (Exception e) {
			
		}
		
		resp.sendRedirect("table?petid="+petid);
	}
	
}
