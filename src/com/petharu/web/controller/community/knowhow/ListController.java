package com.petharu.web.controller.community.knowhow;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petharu.web.entity.Knowhow;
import com.petharu.web.entity.KnowhowView;
import com.petharu.web.service.JDBCKnowhowService;
import com.petharu.web.service.KnowhowService;

@WebServlet("/community/knowhow/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String p = request.getParameter("p");
		String p_ = request.getParameter("p_");
				
		int page_ = 1;
		String pet = "";
		
		if (p != null && !p.equals("")) {
			page_ = Integer.parseInt(p);
		}			
		if (p_ != null && !p_.equals("")) {
			pet = p_;
		}

		KnowhowService knowhowService = new JDBCKnowhowService();
		List<KnowhowView> list = null;
		
		try {
			
			list = knowhowService.getViewList(page_, pet);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		request.setAttribute("list", list);
		System.out.println(list.size());
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
}
