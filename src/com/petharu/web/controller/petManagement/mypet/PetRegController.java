package com.petharu.web.controller.petManagement.mypet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.petharu.web.entity.Pet;
import com.petharu.web.service.JdbcPetService;
import com.petharu.web.service.PetService;

@WebServlet("/pet-management/mypet/reg")
@MultipartConfig(
	    fileSizeThreshold = 1024*1024,
	    maxFileSize = 1024*1024*50, //50메가
	    maxRequestSize = 1024*1024*50*5 // 50메가 5개까지
	)
public class PetRegController extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");

		response.setCharacterEncoding("UTF-8");		
		response.setContentType("text/html; charset=UTF-8");
		int id_ = 1;
		if (request.getParameter("id") != null) {
			Integer.parseInt(request.getParameter("id"));
		}
		int breedId =1;
		if (request.getParameter("breed_id") != null) {
			breedId = Integer.parseInt(request.getParameter("breed_id"));

		}
			String name = request.getParameter("name");
			System.out.println(name);
			String gender = request.getParameter("gender");	
			String birthday = request.getParameter("birthday");	
			String personality = request.getParameter("personality");	
			System.out.println(breedId);
			
			String fileNames = "";
			int fileCount = 0;
			
			Collection<Part> parts = request.getParts();
			for(Part fpart : parts) {
				if(!fpart.getName().equals("f"))
					continue;//파일인것만찾아서 작업하기
				if(fpart.getSize()==0)//파일전달된게없으면
					continue;//break면 for문을 완전벗어난다. continue:다음반복으로넘어간다.
			
//			Part fpart= request.getPart("f");//특정파일
			String fileName = fpart.getSubmittedFileName();
			InputStream fis = fpart.getInputStream();	
			
			fileNames += fileName + ",";
			fileCount++;
			
			ServletContext application = request.getServletContext(); // ->어플리케이션저장소역할
			String path = "/upload";//반드시절대경로 C:/proj/web/root/ 물리경로
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
			
			if(fileCount>0)
			fileNames = fileNames.substring(0, fileNames.length()-1);//마지막 쉼표자르기

		PetService petService = new JdbcPetService();
		List<Pet> list = petService.getPetList(id_);
		Pet pet = new Pet();

		try {
			pet.setName(name);
			pet.setGender(gender);
			pet.setBirthday(birthday);
			pet.setPersonality(personality);
			pet.setMemberId(id_);
			pet.setBreedId(breedId);
			petService.insertPetProfile(pet);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("exception.html");
		}
		System.out.println(list);
		request.setAttribute("pet", pet);
//		response.sendRedirect("/pet-management/mypet/list");
//		request.getRequestDispatcher("/pet-management/mypet/list.jsp").forward(request, response);
		out.println("<script>location.href='/pet-management/mypet/list'</script>");
	}
}
