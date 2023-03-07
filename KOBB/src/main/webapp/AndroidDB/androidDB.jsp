<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.db.ConnectDB"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%

   ConnectDB connectDB = ConnectDB.getInstance();

//한글 인코딩 부분
	request.setCharacterEncoding("utf-8");
   String user_id = request.getParameter("user_id");
   String user_pw = request.getParameter("user_pw");
   String user_phone = request.getParameter("user_phone");
   String user_shop_name = request.getParameter("user_shop_name");
   System.out.println(user_id);
  

  
   
	
   String returns = connectDB.connectionDB(user_id, user_pw, user_phone, user_shop_name);
   
   System.out.println(returns);

   // 안드로이드로 전송
   out.println(returns);
%>