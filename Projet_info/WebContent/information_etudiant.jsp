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
	<form method="POST" action="AccueilEtudiant.jsp">
		<table>
			<tr>
				<td>Nom : </td>
				<td><input type="text" name="nom" value="<% etudiant.getMonCandidat().getNom(); %>" /></td>
			</tr>
			<tr>
				<td>Prénom : </td>
				<td><input type="text" name="prenom" value="<% etudiant.getMonCandidat().getPrenom(); %>"/></td>
			</tr>
			<tr>
				<td>Adresse : </td>
				<td><input type="text" name="adresse" value="<% etudiant.getMonCandidat().getAdresse(); %>"/></td>
			</tr>
			<tr>
				<td>Date de naissance : </td>
				<td><input type="text" name="date_naissance" value="<% etudiant.getMonCandidat().getDateNaissance(); %>"/></td>
			</tr>
			<tr>
				<td>Telephone : </td>
				<td><input type="text" name="telephone" value="<% etudiant.getMonCandidat().getTelephone(); %>" /></td>
			</tr>
			<tr>
				<td>Mail : </td>
				<td><input type="text" name="mail" value="<% etudiant.getMonCandidat().getMail(); %>"/></td>
			</tr>
			<tr>
				<td>Login : </td>
				<td><input type="text" name="login" value="<% etudiant.getMonCandidat().getLogin(); %>"/></td>
			</tr>
		</table>
		<br/>
		<center><input type="submit" value="Valider"/><input type="button" value="Retour"/></center>
	</form>
</body>
</html>