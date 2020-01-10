<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
response.sendRedirect(request.getContextPath() + "/boardadmin?act=index"); //index들어오자마자 db에서 얻어와서 뿌려주기
%>








