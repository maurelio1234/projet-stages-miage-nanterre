<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="beans.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion offre de stage Entreprise</title>
</head>
<body>
	<jsp:useBean id="entr" scope="session" class="beans.Entreprise"/>
<%-- 	<jsp:useBean id="listeOffreE" scope="session" class="beans.OffreDeStage"/> --%>
	<h1>Gestion de vos offres :</h1>
	<form METHOD="POST"	ACTION="ControleurCreaOS">
		<p>Liste de vos offres :</p>

<%-- 		<c:forEach var="listeOffreE" items="${listeOffreE}"> --%>
			<input type="checkbox" name="choix"><% out.print("Entreprise " + entr.getNom() + "  " + entr.getNumeroEntreprise()) ; %>
			<a href="OffreStagev2.jsp"><img src="/../src/images/modify.png" alt="delete" height="16" width="16"/></a>
			<a href="Suppresion.jsp"><img src="/src/images/delete.png" alt="delete" height="16" width="16"/></a>
			<br>
<!-- 		</c:forEach> -->
	<input type="submit" value="Créer" name="creer_offre"/>
	</form>
</body>
</html>