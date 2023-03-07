package com.usercontrolloer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kobb.model.UserDAO;
import com.kobb.model.UserDTO;


public class JoinProgram implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String result = null;

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		birth = birth.replaceAll("-", "");
		String job = request.getParameter("job");
		String clas = request.getParameter("clas");

		// 직업이 강사일 때
		if (job.equals("1")) {
			UserDTO dto = new UserDTO();
			UserDAO dao = new UserDAO();
			int row = dao.join(dto);
			if (row > 0) {
				request.getSession().setAttribute("name", name);
				request.getSession().setAttribute("id", id);

				// 웹 구현되면 join success 화면 만들어서 연결해야함!
				result = "joinSuccess.jsp";
			} else {
				// 웹 구현되면 main 화면 만들어서 연결해야함!
				result = "main.jsp";
			}
			
		// 직업이 학생일 때
		} else {
			UserDTO dto = new UserDTO();
			UserDAO dao = new UserDAO();
			int row = dao.join(dto);
			if (row > 0) {
				request.getSession().setAttribute("name", name);
				request.getSession().setAttribute("id", id);

				// 웹 구현되면 join success 화면 만들어서 연결해야함!
				result = "joinSuccess.jsp";
			} else {
				// 웹 구현되면 main 화면 만들어서 연결해야함!
				result = "main.jsp";
			}
		}

		return result;
	}

}
