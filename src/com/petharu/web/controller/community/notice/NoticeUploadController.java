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

@WebServlet("/community/notice/upload")
@MultipartConfig (
	fileSizeThreshold = 1024*1024,
	maxFileSize = 1024*1024*500,
	maxRequestSize = 1024*1024*500*5
)
public class NoticeUploadController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String p = req.getParameter("p");
		Part fpart = req.getPart("file"); //파일 하나일 때.
		String fileName = fpart.getSubmittedFileName(); //전송한 파일 이름
		InputStream fis = fpart.getInputStream(); //파일에 대한 정보, 스트림
		
		ServletContext application = req.getServletContext();
		
		String path = "/community/notice/upload";
		if (p != null && !p.equals(""))
			path = p;
		
		String realPath = application.getRealPath(path); //홈디렉토리를 기준으로 하는 path를 주면 물리경로, 절대경로를 알려준다.
		
		File pathFile = new File(realPath);
		if (!pathFile.exists()) {
			pathFile.mkdirs(); //경로가 없을 경우 dir은 하나만, dirs는 모든 경로를 만들어준다.
		}
		
		String filePath = realPath + File.separator + fileName; //운영체제별 구분자를 삽입
		FileOutputStream fos =  new FileOutputStream(filePath);
		
		System.out.println(realPath);
		
		byte[] buf = new byte[1024];
		int len = 0;
		
		while((len=fis.read(buf, 0, 1024))>=0)
			fos.write(buf, 0, len);
		
		fos.flush();
		fos.close();
		fis.close();
		
		PrintWriter out = resp.getWriter();
		out.println(path + "/" + fileName);
		
		
	}
	
}
