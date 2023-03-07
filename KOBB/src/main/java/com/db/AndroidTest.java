package com.db;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AndroidTest")
public class AndroidTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서버 요청이 들어옴!");
		ConnectDB connectDB = ConnectDB.getInstance();
		// 전달된 데이터 확인
		// 1. 인코딩 작업 진행
		request.setCharacterEncoding("utf-8");
		// 2. 전달된 데이터 꺼내오기
		String user_shop_name = request.getParameter("user_shop_name");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_phone = request.getParameter("user_phone");
		
		System.out.println(user_shop_name);
		System.out.println(user_id);
		System.out.println(user_pw);
		System.out.println(user_phone);
		
		
		String returns = connectDB.connectionDB(user_id, user_pw, user_phone, user_shop_name);
	}

}
