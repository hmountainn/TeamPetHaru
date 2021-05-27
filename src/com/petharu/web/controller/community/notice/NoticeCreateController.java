package com.petharu.web.controller.community.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.petharu.web.entity.Notice;
import com.petharu.web.service.JDBCNoticeService;
import com.petharu.web.service.NoticeService;


@WebServlet("/community/notice/create")
@MultipartConfig (
	fileSizeThreshold = 1024*1024,
	maxFileSize = 1024*1024*500,
	maxRequestSize = 1024*1024*500*5
)
public class NoticeCreateController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		Part fpart = req.getPart("file"); //파일 하나일 때.
		String fileName = fpart.getSubmittedFileName(); //전송한 파일 이름
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		NoticeService noticeService = new JDBCNoticeService();
		
		try {
			Notice notice = new Notice();
			notice.setTitle(title);
			notice.setAdminId(1);
			notice.setContent(content);
			notice.setFiles(fileName);
			noticeService.insert(notice);

			resp.sendRedirect("list.html");
		} catch (Exception e) {
			resp.sendRedirect("exception.html");
		}
	}
	
}
