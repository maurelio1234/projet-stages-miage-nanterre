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
	<form METHOD="POST"
		ACTION="http://localhost:8080/Car1_TD4_MVC/Controller">
		<!--<c:forEach var="IntituleOffre" items="${ListeOffre}"> 
		<a href="gestion_eleves.jsp"> Promotion L3 Classique 2011/2012</a><br/>
			<a href="gestion_eleves.jsp"> Promotion M1 Classique 2011/2012</a><br/>
			<a href="gestion_eleves.jsp"> Promotion M2 Classique 2011/2012</a><br/>
			<a href="gestion_eleves.jsp"> Promotion L3 App 2011/2012</a><br/>
			<a href="gestion_eleves.jsp"> Promotion M1 App 2011/2012</a><br/>
			<a href="gestion_eleves.jsp"> Promotion M2 App 2011/2012</a><br/> -->

		<% 	
		Formation f=new Formation();
		 for (int i = 0; i <Forma.size(); i++) {
			 f=(beans.Formation)Forma.get(i);
			 %>
		<a href="gestion_eleves.jsp">
			<% out.print(f.getGrade()+" "+f.getNiveau()+" "+f.getLibelle());%><br />

			<%
		 }
		 %> <!-- </c:forEach> -->
	</form>
</body>
</html>