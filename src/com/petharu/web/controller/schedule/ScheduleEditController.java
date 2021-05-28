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

@WebServlet("/pet-management/schedule/edit")
public class ScheduleEditController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id_ = req.getParameter("id");
		int id = Integer.parseInt(id_);
		ScheduleService scheduleservice = new JDBCScheduleService();
		Schedule schedule = scheduleservice.get(id);
		
		req.setAttribute("schedule", schedule);
		
		req.getRequestDispatcher("edit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String datetime = req.getParameter("datetime");		
		String scheduleType = req.getParameter("scheduleType");
		
		ScheduleService scheduleservice = new JDBCScheduleService();		
		Schedule schedule = scheduleservice.get(id);
		schedule.setTitle(title);
		schedule.setContent(content);
		schedule.setDateTime(datetime);
		schedule.setScheduleTypeName(scheduleType);
		scheduleservice.update(schedule);
		
		resp.sendRedirect("/pet-management/schedule/calendar.html");
		
		
	}
}
