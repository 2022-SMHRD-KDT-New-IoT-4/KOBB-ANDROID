package com.usercontrolloer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	
	public String execute (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;

}
