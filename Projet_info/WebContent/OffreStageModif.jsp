<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="beans.*" %>
    <%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="entr" scope="session" class="beans.Entreprise"/>
	<% SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	   SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	   String param = request.getParameter("idOffre");
	   int numO = Integer.parseInt(param);
	%>
	<h1>Offre de Stage</h1>
	<form METHOD="POST"
		ACTION="Controleur_OS_Modif">
		<p>Modification de votre offre de stage!</p>
		<%
			OffreDeStage ods = new OffreDeStage();
		    ods=entr.getMesOffres().get(numO);%>
		<p>Intitule de l'offre: </p>
		<INPUT TYPE="text" NAME="intitule" SIZE="80" MAXLENGTH="150">
		<p>Date début de stage : 
		<INPUT TYPE="text" NAME="dateDebut" value=<% out.print(sdf1.format(ods.getDateDebutStage().getDateDuJour().getTime())); %> SIZE="15" MAXLENGTH="25">
		 Date fin de stage : 
		<INPUT TYPE="text" NAME="dateFin" value=<% out.print(sdf2.format(ods.getDateFinStage().getDateDuJour().getTime())); %> SIZE="15" MAXLENGTH="25">
		</p>
		<p>Etat de l'offre: </p>
		<input type="text" name="etat" value=<% out.print(ods.getEtatOffre()); %> SIZE="20" MAXLENGTH="35" disabled="disabled" />
		<p>Description : </p>
		<TEXTAREA NAME="description" ROWS="10" COLS="80" ><% out.print(ods.getDescriptionPoste()); %></TEXTAREA><br>
		<input type="submit" value="Enregistrer" /><input type="button" value="Annuler" /><INPUT TYPE="button" VALUE="Supprimer">
	</form>
</body>
</html>