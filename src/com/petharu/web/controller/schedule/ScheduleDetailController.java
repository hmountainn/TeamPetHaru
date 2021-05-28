package com.petharu.web.controller.schedule;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.petharu.web.entity.Schedule;
import com.petharu.web.service.JDBCScheduleService;
import com.petharu.web.service.ScheduleService;

@WebServlet("/pet-manager/schedule/detail")
public class ScheduleDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		String _id = req.getParameter("id");
		int id = Integer.parseInt(_id);
		//int id=90;
		ScheduleService scheduleService = new JDBCScheduleService();
		Schedule schedule = scheduleService.get(id);
		
		Gson gson = new Gson();
		String json = gson.toJson(schedule);
		out.println(json);
		//resp.sendRedirect("/pet-management/schedule/calendar.html");
	}
}
