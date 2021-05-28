package com.petharu.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petharu.web.entity.Member;
import com.petharu.web.service.JDBCMemberService;
import com.petharu.web.service.MemberService;

@WebServlet("/member/signup")
public class MemberSignupController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("id");
		String passWord = req.getParameter("password");
		String email = req.getParameter("email"); 
		
		
		MemberService memberService = new JDBCMemberService();
		Member member = new Member();
		member.setUserId(userId);
		member.setPassword(passWord);
		member.setEmail(email);
		memberService.insert(member);
		
		resp.sendRedirect("/login");
	}
}
