<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Offre de Stage</h1>
	<form METHOD="POST"
		ACTION="http://localhost:8080/Car1_TD4_MVC/Controller">
		<p>Veuillez rentrer votre offre de stage!</p>
		<p>Intitule de l'offre: </p>
		<INPUT TYPE="text" NAME="intitule" SIZE="80" MAXLENGTH="150">
		<p>Description : </p>
		<TEXTAREA NAME="description" ROWS="10" COLS="80"></TEXTAREA><br>
		<input type="submit" value="Enregistrer" /><INPUT TYPE="button" VALUE="Annuler">
	</form>
</body>
</html>