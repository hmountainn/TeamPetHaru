package com.petharu.web.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.petharu.web.entity.Schedule;
import com.petharu.web.service.JDBCScheduleService;
import com.petharu.web.service.ScheduleService;

@WebServlet("/pet-management/api/schedule/list")
public class ScheduleList extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();

		Date date = new Date();

		String m = req.getParameter("m");
		String member = req.getParameter("member");

		int month = date.getMonth() + 1;
		int memberId = 1;

		if (m != null && m != "") {
			month = Integer.parseInt(m);
		}
		if (member != null && member != "") {
			memberId = Integer.parseInt(member);
		}

		ScheduleService scheduleservice = new JDBCScheduleService();
		List<Schedule> list = scheduleservice.getList(month, memberId);
		// out.println(list);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.println(json);

	}
}
