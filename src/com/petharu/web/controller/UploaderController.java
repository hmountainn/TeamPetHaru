package com.petharu.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/uploader")
@MultipartConfig (
    fileSizeThreshold = 1024*1024,
    maxFileSize = 1024*1024*500, // 50占쌨곤옙
    maxRequestSize = 1024*1024*500*5 // 50占쌨곤옙 占쏙옙占쏙옙 5占쏙옙占쏙옙占쏙옙
)
public class UploaderController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 占쏙옙占쏙옙 占쏙옙占싸듸옙占싹깍옙
		request.setCharacterEncoding("UTF-8");
		String p = request.getParameter("p");
		
		Part fpart = request.getPart("f"); // 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙, 占쏙옙환 타占쏙옙占쏙옙 占쏙옙트占쏙옙
		String fileName = fpart.getSubmittedFileName(); // 占쏙옙占쌜듸옙 占쏙옙占쏙옙 占싱몌옙
		InputStream fis = fpart.getInputStream(); // 占쏙옙占쏙옙 占쏙옙트占쏙옙
	
		ServletContext application = request.getServletContext(); // 占쏙옙占시몌옙占쏙옙占싱쇽옙占쏙옙 占쏙옙占쏙옙占� 占쏙옙占쏙옙, 占쌕몌옙 占쏙옙占쏙옙占쏙옙 占쌜억옙占쏙옙 占싱어가占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙, 占쏙옙占쏙옙占�(ServletContext)占쏙옙 占십울옙
		
		String path = "/upload"; // 占쏙옙占싸듸옙占쏙옙 占쏙옙占�, 占쌔댐옙 占쏙옙灌占� 占쏙옙占쏙옙 占쏙옙管占� 占쏙옙占쏙옙占쌔억옙 占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙, 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占� 占쌕몌옙 占쏙옙占싱므뤄옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싹몌옙 占싫듸옙
		if(p != null && !p.equals(""))
			path = p;
		
		String realPath = application.getRealPath(path); // 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙罐占� 占쏙옙爭삼옙占�
		
		File pathFile = new File(realPath); // 占쏙옙占쏙옙 占쏙옙占쏙옙占�
		if(!pathFile.exists()) // 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
			pathFile.mkdirs(); // 占쏙옙罐占� 占쏙옙占쏙옙占쏙옙占�
		
		String filePath = realPath + File.separator + fileName; // 占쏘영체占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쌘곤옙 占쌕몌옙 占쏙옙 占쏙옙占쏙옙
		FileOutputStream fos = new FileOutputStream(filePath);
		
		System.out.println("aaa" + realPath);
		
		byte[] buf = new byte[1024];
		int len = 0;
		
		while((len = fis.read(buf, 0, 1024)) >= 0) // 占쌍댐옙 1024占쏙옙占쏙옙占쏙옙 占싼뱄옙占쏙옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙, len: 占쌉뤄옙 占쏙옙트占쏙옙占쏙옙占쏙옙 占쏙옙占쌜울옙 占쏙옙占쏙옙 占쏙옙占쏙옙트 占쏙옙占쏙옙(占쌍댐옙 1024)
			fos.write(buf, 0, len); // 占싻억옙占쏙옙占� len占쏙옙큼 write占싹댐옙 占쏙옙
		
		fos.flush();
		fos.close();
		fis.close();
		
		PrintWriter out = response.getWriter();

		out.println(path + "/" + fileName); // response占쏙옙 占쏙옙占쏙옙占쏙옙!

	}	
}
