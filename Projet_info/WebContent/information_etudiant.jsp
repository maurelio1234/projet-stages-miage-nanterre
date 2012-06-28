<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Information Etudiant</title>
</head>
<body>
	<jsp:useBean id="etudiant" scope="request" class="beans.Etudiant"/>
	<h1>Information de l'étudiant</h1>
	<form method="POST" action="Controleur_Update_Etudiant.jsp?id_etudiant=<%out.print(etudiant.getNumeroEtudiant());%>">
	<input type="hidden" name="id_candidat" value="<%out.print(etudiant.getMonCandidat().getNumeroCandidat());%>"/>
		<table>
			<tr>
				<td>Nom : </td>
				<td><% out.print(etudiant.getMonCandidat().getNom()); %></td>
			</tr>
			<tr>
				<td>Prénom : </td>
				<td><% out.print(etudiant.getMonCandidat().getPrenom()); %></td>
			</tr>
			<tr>
				<td>Adresse : </td>
				<td><input type="text" name="adresse" value="<% out.print(etudiant.getMonCandidat().getAdresse()); %>"/></td>
			</tr>
			<tr>
				<td>Date de naissance : </td>
				<td><input type="text" name="date_naissance" value="<% out.print(etudiant.getMonCandidat().getDateNaissance()); %>"/></td>
			</tr>
			<tr>
				<td>Telephone : </td>
				<td><input type="text" name="telephone" value="<% out.print(etudiant.getMonCandidat().getTelephone()); %>" /></td>
			</tr>
			<tr>
				<td>Mail : </td>
				<td><input type="text" name="mail" value="<% out.print(etudiant.getMonCandidat().getMail()); %>"/></td>
			</tr>
			<tr>
				<td>Login : </td>
				<td><%out.print(etudiant.getMonCandidat().getLogin()); %></td>
			</tr>
		</table>
		<br/>
		<center><input type="submit" value="Valider"/><input type="button" value="Retour"/></center>
	</form>
</body>
</html>