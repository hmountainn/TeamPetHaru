package com.petharu.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/admin/uploader")
@MultipartConfig(
	    fileSizeThreshold = 1024*1024,
	    maxFileSize = 1024*1024*500, //50메가
	    maxRequestSize = 1024*1024*500*5 // 50메가 5개까지
	)
public class PetUploaderController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String p = request.getParameter("p");
		
		System.out.println(p);
		
		Part fpart= request.getPart("f");
		String fileName = fpart.getSubmittedFileName();
		InputStream fis = fpart.getInputStream();	

		ServletContext application = request.getServletContext(); // ->어플리케이션저장소역할
		String path = "/upload";//반드시절대경로 C:/proj/web/root/ 물리경로
		if( p!=null && !p.equals(""))
			path = p;
		
		String realPath = application.getRealPath(path);
		
		File pathFile = new File(realPath);
		if(!pathFile.exists())//존재하지않으면
			pathFile.mkdirs();//전체경로를만들어줌
		
		String filePath = realPath + File.separator + fileName;//운영체제마다 경로구분자가 다르다. separator가 도와줌
		FileOutputStream fos = new FileOutputStream(filePath);
		
		System.out.print(realPath);
			
		byte[] buf = new byte[1024];
		int len = 0;
		
		while((len=fis.read(buf,0,1024))>=0)
			fos.write(buf,0,len);
		
		fos.flush();
		fos.close();
		fis.close();
	}
}
