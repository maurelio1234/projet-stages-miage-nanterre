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
	<h1>Gestion des offres de <% out.println(entr.getNom()); %> :</h1>
	<form METHOD="POST"	ACTION="OffreStageCrea.jsp">
		<p>Liste de vos offres :</p>

			<%
			OffreDeStage ods = new OffreDeStage();
		    for (int i = 0; i <entr.getMesOffres().size(); i++) {
		        ods=entr.getMesOffres().get(i);
		        %><input type="checkbox" name="choix">
		        <a href="Controleur_OS_ConsultEtp?idOffre=<%=i%>">
		        <%
			 	out.println(ods.getDescriptionPoste() + " : état à " + ods.getEtatOffre()) ;
			 	%>
			 	</a>
			 	<a href="OffreStageModif.jsp?idOffre=<%=i%>"><img src="/../src/images/modify.png" alt="delete" height="16" width="16"/></a>
				<a href="Suppresion.jsp?idOffre=<%=i%>"><img src="/src/images/delete.png" alt="delete" height="16" width="16"/></a>
			 	<br>
			 	<%
			}
		    %>
			<br>
			<%
		    out.println("Nombre d'offres " + entr.getMesOffres().size()) ;
		    %>
			<br>
	<input type="submit" value="Créer" name="creer_offre"/>
	</form>
</body>
</html>