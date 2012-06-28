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
	<h1>Gestion des élèves :</h1>
	<input type="hidden" id="id_etudiant" value="12<%out.print(etudiant.getNumeroEtudiant());%>"/>
		<a href="Controleur_Info_Etudiant?id_etudiant=<%out.print(etudiant.getNumeroEtudiant());%>">Vos informations</a><br/>
		<a href="Controleur_Gestion_Notes?id_etudiant=<%etudiant.getNumeroEtudiant();%>">Vos notes</a><br/>
		<a href="Controleur_Gestion_Offres">Vos offres</a><br/>
</body>
</html>