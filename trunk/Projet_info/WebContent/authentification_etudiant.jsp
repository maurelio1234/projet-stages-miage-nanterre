<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bienvenue cher utilisateur!!</h1>
	<form METHOD="POST" ACTION="ControleurEtu">
		<p>Veuillez entrer votre identifiant, ainsi que votre mot de
			passe!</p>
		<p>Login:</p>
		<input type="text" name="login" />
		<p>Mot de passe:</p>
		<input type="password" name="mdp" /><br> <input type="submit" />
	</form>
</body>
</html>