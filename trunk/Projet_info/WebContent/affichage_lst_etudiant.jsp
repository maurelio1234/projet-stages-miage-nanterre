<%@page import="beans.Candidat"%>
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
	<jsp:useBean id="lstcandi" scope="session" class="java.util.ArrayList" />
		<!--<c:forEach var="IntituleOffre" items="${ListeOffre}"> 
		<a href="gestion_eleves.jsp"> Promotion L3 Classique 2011/2012</a><br/>
			<a href="gestion_eleves.jsp"> Promotion M1 Classique 2011/2012</a><br/>
			<a href="gestion_eleves.jsp"> Promotion M2 Classique 2011/2012</a><br/>
			<a href="gestion_eleves.jsp"> Promotion L3 App 2011/2012</a><br/>
			<a href="gestion_eleves.jsp"> Promotion M1 App 2011/2012</a><br/>
			<a href="gestion_eleves.jsp"> Promotion M2 App 2011/2012</a><br/> -->

		<% 	
		
		Candidat c=new Candidat();
		 for (int i = 0; i <lstcandi.size(); i++) {
			 c=(beans.Candidat)lstcandi.get(i);
			 %>
		<a href="Controleur_Candidat_Promo"> <% out.print(c.getLogin());%><br />

			<%
		 }
		 %> <!-- </c:forEach> -->
</body>
</html>