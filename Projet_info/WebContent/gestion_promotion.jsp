<%@page import="beans.Formation"%>
<%@ page import="beans.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Gestion des promotions :</h1>
	<jsp:useBean id="Forma" scope="session" class="java.util.ArrayList" />
	

		<% 	
		
		Formation f=new Formation();
		 for (int i = 0; i <Forma.size(); i++) {
			 f=(beans.Formation)Forma.get(i);
			 %>
		<a href="Controleur_Candidat_Promo"> <% out.print(f.getGrade()+" "+f.getNiveau()+" "+f.getLibelle());%><br />
	<input type="hidden" name="aaa" value= <% out.print(f.getNumeroFormation());%>>
			<%
		 }
		 %> 
</body>
</html>