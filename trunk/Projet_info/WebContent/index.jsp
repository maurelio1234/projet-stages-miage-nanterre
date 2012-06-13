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
		ACTION="http://localhost:8080/Car1_TD4_MVC/Controller">
		<p>Veuillez remplir les champs :</p>
		<table>
			<tr>
				<td>Nom de l'entreprise : *</td>
				<td><input type="text" name="Nom" /></td>
			</tr>
			<tr>
				<td>Adresse : *</td>
				<td><input type="text" name="Adresse" /></td>
			</tr>
			<tr>
				<td>Telephone : *</td>
				<td><input type="text" name="Telephone" /></td>
			</tr>
			<tr>
				<td>Mail : *</td>
				<td><input type="text" name="Mail" /></td>
			</tr>
			<tr>
				<td>Login : *</td>
				<td><input type="text" name="Login" /></td>
			</tr>
			<tr>
				<td>Password : *</td>
				<td><input type="password" name="Password" /></td>
			</tr>
		</table>
		<br>
		<center><input type="submit" value="Valider"  /></center>
	</form>
</body>
</html>