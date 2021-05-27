package com.petharu.web.controller.community.knowhow;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.petharu.web.entity.Knowhow;
import com.petharu.web.entity.KnowhowView;
import com.petharu.web.service.JDBCKnowhowService;
import com.petharu.web.service.KnowhowService;

@WebServlet("/community/knowhow/edit")
@MultipartConfig (
    fileSizeThreshold = 1024*1024,
    maxFileSize = 1024*1024*50, // 50메가
    maxRequestSize = 1024*1024*50*5 // 50메가 파일 5개까지
)
public class EditController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		KnowhowService service = new JDBCKnowhowService();
		KnowhowView knowhow = null;
		
		try {
			knowhow = service.get(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("knowhow", knowhow);
		req.getRequestDispatcher("/community/knowhow/edit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String pet = request.getParameter("pet");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 파일 업로드하기
		Part fpart = request.getPart("f"); // 파일을 가져오기, 반환 타입이 파트형
		String fileName = fpart.getSubmittedFileName(); // 전송된 파일 이름
		InputStream fis = fpart.getInputStream(); // 파일 스트림
		
		ServletContext application = request.getServletContext(); // 어플리케이션의 저장소 역할, 다른 서블릿이 작업을 이어가려면 동일한 도구, 저장소(ServletContext)가 필요
		String path = "/upload"; // 업로드할 경로, 해당 경로는 절대 경로로 설정해야 파일 출력 나옴, 하지만 배포 서버가 모두 다를 것이므로 정적으로 설정하면 안됨
		String realPath = application.getRealPath(path); // 실제 물리 경로를 얻어내줌
		
		File pathFile = new File(realPath); // 파일 만들기
		if(!pathFile.exists()) // 파일이 없으면
			pathFile.mkdirs(); // 경로를 만들어줌
		
		String filePath = realPath + File.separator + fileName; // 운영체제마다 파일 구분자가 다를 수 있음
		FileOutputStream fos = new FileOutputStream(filePath);
		
		System.out.println(realPath);
		
		byte[] buf = new byte[1024];
		int len = 0;
		
		while((len = fis.read(buf, 0, 1024)) >= 0)
			fos.write(buf, 0, len);
		
		fos.flush();
		fos.close();
		fis.close();
		
		KnowhowService service = new JDBCKnowhowService();
		KnowhowView knowhow = null;
		
		try {
			knowhow = service.get(id);
			knowhow.setKnowhowTypeName(pet);
			knowhow.setTitle(title);
			knowhow.setContent(content);
			service.update(knowhow);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		response.sendRedirect("detail?id="+id);
	
	}
}
	