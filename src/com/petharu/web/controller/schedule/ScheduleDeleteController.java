package com.petharu.web.controller.schedule;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petharu.web.entity.Schedule;
import com.petharu.web.service.JDBCScheduleService;
import com.petharu.web.service.ScheduleService;

@WebServlet("/pet-management/schedule/del")
public class ScheduleDeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String _id = req.getParameter("id");
		int id = Integer.parseInt(_id);
		//int id=90;
		ScheduleService scheduleService = new JDBCScheduleService();
		scheduleService.delete(id);
		resp.sendRedirect("/pet-management/schedule/calendar.html");
	}
}
