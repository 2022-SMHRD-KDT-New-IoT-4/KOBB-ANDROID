package com.frontcontroller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.usercontrolloer.Command;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = null;

	public void init() throws ServletException {
	map = new HashMap<>();
	
	//map.put("Join.do", new JoinProgram());
	}


	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		System.out.println("요청 uri: " + uri);

		String path = request.getContextPath();
		String finalUrl = uri.substring(path.length() + 1);
		System.out.println("잘라낸 url: " + finalUrl);

		String finalurl = uri.substring(path.length() + 1);

		Command com = null;

		request.setCharacterEncoding("UTF-8");

		com = map.get(finalurl);

		String rdPath = com.execute(request, response);

		// WEB-INF에 파일 넣으면 rdPath 앞에 "WEB-INF" 추가 할 것
		if (rdPath == null) {
			//ajax 통신을 위한 하나의 옵션
		} else {
			RequestDispatcher rd = request.getRequestDispatcher(rdPath);
			rd.forward(request, response);
		}
	}

}
