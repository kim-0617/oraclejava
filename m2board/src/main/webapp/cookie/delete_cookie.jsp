<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Cookie cookie = new Cookie("id", URLEncoder.encode("손흥민손", "UTF-8"));
	cookie.setMaxAge(0); // 쿠키 삭제
	response.addCookie(cookie);
	response.sendRedirect("using_cookie.jsp");
%>