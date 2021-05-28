package com.petharu.web.controller.schedule;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petharu.web.entity.Schedule;
import com.petharu.web.service.JDBCScheduleService;
import com.petharu.web.service.ScheduleService;

@WebServlet("/pet-management/schedule/reg")
public class RegScheduleController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String datetime = req.getParameter("datetime");		
		String scheduleType = req.getParameter("scheduleType");
		
		try {
			ScheduleService scheduleservice = new JDBCScheduleService();		
			Schedule schedule = new Schedule();
			schedule.setTitle(title);
			schedule.setContent(content);
			schedule.setDateTime(datetime);
			schedule.setScheduleTypeName(scheduleType);
			schedule.setMemberId(1);
			scheduleservice.insert(schedule);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("/pet-management/schedule/calendar.html");
		
		
	}

}
