<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bienvenue cher partenaire !</h1>
	<form METHOD="POST"
		ACTION="OffreStagev1.jsp">
		<p>Nom de l'etudiant :</p>
		<table>
			<tr>
				<td>Nom : </td>
				<td><input type="text" name="Nom" value="Nom..." disabled="disabled"/></td>
			</tr>
			<tr>
				<td>Prénom : </td>
				<td><input type="text" name="Prenom" value="Prénom..." disabled="disabled"/></td>
			</tr>
			<tr>
				<td>Adresse : </td>
				<td><input type="text" name="Adresse" /></td>
			</tr>
			<tr>
				<td>Date de naissance : </td>
				<td><input type="text" name="Naissance" value="date de naissance" disabled="disabled"/></td>
			</tr>
			<tr>
				<td>Telephone : </td>
				<td><input type="text" name="Telephone" /></td>
			</tr>
			<tr>
				<td>Mail : </td>
				<td><input type="text" name="Mail" /></td>
			</tr>
			<tr>
				<td>Login : </td>
				<td><input type="text" name="Login" value="login etudiant" disabled="disabled"/></td>
			</tr>
		</table>
		<br>
		<center><input type="submit" value="Valider"  /><input type="button" value="Retour"  /></center>
	</form>
</body>
</html>