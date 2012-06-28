<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="etudiant" scope="request" class="beans.Etudiant"/>
	<jsp:useBean id="ManagerNoteEtudiant" scope="request" class="Manager.ManagerNoteEtudiant"/>
	<%Float NoteFinal = (Float)(request.getAttribute("NoteFinal"));%>

	<h1>Note de : </h1>
	<h1><% out.print(etudiant.getMonCandidat().getNom()); %></h1>

	<form METHOD="POST"ACTION="http://localhost:8080/Car1_TD4_MVC/Controller">
		<p>Veuillez rentrer votre offre de stage!</p>
		<p>Intitule de l'offre: </p>

	</form>
</body>
</html>