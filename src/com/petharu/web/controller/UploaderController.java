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
    maxFileSize = 1024*1024*500, // 50�ް�
    maxRequestSize = 1024*1024*500*5 // 50�ް� ���� 5������
)
public class UploaderController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ���� ���ε��ϱ�
		request.setCharacterEncoding("UTF-8");
		String p = request.getParameter("p");
		
		Part fpart = request.getPart("f"); // ������ ��������, ��ȯ Ÿ���� ��Ʈ��
		String fileName = fpart.getSubmittedFileName(); // ���۵� ���� �̸�
		InputStream fis = fpart.getInputStream(); // ���� ��Ʈ��
	
		ServletContext application = request.getServletContext(); // ���ø����̼��� ����� ����, �ٸ� ������ �۾��� �̾���� ������ ����, �����(ServletContext)�� �ʿ�
		
		String path = "/upload"; // ���ε��� ���, �ش� ��δ� ���� ��η� �����ؾ� ���� ��� ����, ������ ���� ������ ��� �ٸ� ���̹Ƿ� �������� �����ϸ� �ȵ�
		if(p != null && !p.equals(""))
			path = p;
		
		String realPath = application.getRealPath(path); // ���� ���� ��θ� ����
		
		File pathFile = new File(realPath); // ���� �����
		if(!pathFile.exists()) // ������ ������
			pathFile.mkdirs(); // ��θ� �������
		
		String filePath = realPath + File.separator + fileName; // �ü������ ���� �����ڰ� �ٸ� �� ����
		FileOutputStream fos = new FileOutputStream(filePath);
		
		System.out.println(realPath);
		
		byte[] buf = new byte[1024];
		int len = 0;
		
		while((len = fis.read(buf, 0, 1024)) >= 0) // �ִ� 1024������ �ѹ��� ���� �� ����, len: �Է� ��Ʈ������ ���ۿ� ���� ����Ʈ ����(�ִ� 1024)
			fos.write(buf, 0, len); // �о���� len��ŭ write�ϴ� ��
		
		fos.flush();
		fos.close();
		fis.close();
		
		PrintWriter out = response.getWriter();

		out.println(path + "/" + fileName); // response�� ������!

	}	
}
