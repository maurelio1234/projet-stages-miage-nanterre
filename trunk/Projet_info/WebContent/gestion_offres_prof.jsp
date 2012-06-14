<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Gestion des offres des entreprises :</h1>
	<form METHOD="POST"
		ACTION="http://localhost:8080/Car1_TD4_MVC/Controller">
		<h3>Liste des offres validées:</h3>
		<!--<c:forEach var="OffresValide" items="${ListeOffreValide}">  -->
			<br>

	<!-- </c:forEach> -->	
		<h3>Liste des offres à valider:</h3>
		<!--<c:forEach var="OffresàValide" items="${ListeOffreàValide}">  -->
			<br>

	<!-- </c:forEach> -->	
		<h3>Liste des offres rejettées:</h3>
		<!--<c:forEach var="OffresRejette" items="${ListeOffreRejette}">  -->
			<br>

	<!-- </c:forEach> -->	
	</form>
</body>
</html>