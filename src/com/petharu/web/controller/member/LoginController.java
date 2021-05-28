package com.petharu.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petharu.web.entity.Member;
import com.petharu.web.service.JDBCMemberService;
import com.petharu.web.service.MemberService;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("uid");
		String passWord = req.getParameter("password");
		String returnUrl = req.getParameter("returnURL"); //get요청인데 어케?? form에서 hidden으로 ${param.returnURL} 받아옴.
		
		
		MemberService memberService = new JDBCMemberService();
		Member member = memberService.get(userId);
		if(member == null) {
			//회원이 없을 경우
			//에러 메시지를 보여주거나 jsp에서 보여주게한다.
			resp.sendRedirect("/login");
			return;
			
		}else if(!memberService.getPwd(userId).equals(passWord)) {
			resp.sendRedirect("/login");
			return;
		}else {
			
		
			//인증이 성공하면
			//session에 인증정보를 기록한다.		
			HttpSession session = req.getSession();//세션이라는 캐비넷 얻음
			session.setAttribute("uid", userId); //인증된 사용자아이디 세션저장소에 넣음(알아서 ex)1004번 캐비넷 넣어줌)
			if(returnUrl != null && !returnUrl.equals("")) {
				resp.sendRedirect(returnUrl);
				return;
			}
		}
		resp.sendRedirect("/myhome/list.html");
	}
}
