<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="beans.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="offrestage" scope="request" class="beans.OffreDeStage"/>
	<h1>Offre de Stage</h1>
	<form METHOD="POST"
		ACTION="http://localhost:8080/Car1_TD4_MVC/Controller">
		<p>Consultation de votre offre de stage!</p>
<!-- 		<p>Intitule de l'offre: </p> -->
<!-- 		<input type="text" name="intitule" value="Intitule de votre offre" SIZE="80" MAXLENGTH="150" disabled="disabled" /> -->
		<p>Etat de l'offre: </p>
		<input type="text" name="etat" value=<% out.print(offrestage.getEtatOffre()); %> SIZE="80" MAXLENGTH="150" disabled="disabled" />
		<p>Date de d�but: </p>
		<input type="text" name="datedebut" value=<% out.print(offrestage.getDateDebutStage()); %> SIZE="80" MAXLENGTH="150" disabled="disabled" />
		<p>Date de fin: </p>
		<input type="text" name="datefin" value=<% out.print(offrestage.getDateFinStage()); %> SIZE="80" MAXLENGTH="150" disabled="disabled" />
		<p>Description : </p>
		<TEXTAREA NAME="description" ROWS="10" COLS="80" disabled="disabled"><% out.print(offrestage.getDescriptionPoste()); %></TEXTAREA><br>
		<input type="submit" value="Modifier" /><INPUT TYPE="button" VALUE="Annuler">
	</form>
</body>
</html>