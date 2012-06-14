<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Gestion de vos offres :</h1>
	<form METHOD="POST"
		ACTION="http://localhost:8080/Car1_TD4_MVC/Controller">
		<p>Liste de vos offres :</p>


		<!--<c:forEach var="IntituleOffre" items="${ListeOffre}">  -->
			<input type="checkbox" name="${IntituleOffre}" id="${IntituleOffre}">${IntituleOffre}> Assistant chef de projet
			<a href="OffreStagev2.jsp"><img src="/../src/images/modify.png" alt="delete" height="16" width="16"/></a>
			<a href="Suppresion.jsp"><img src="/src/images/delete.png" alt="delete" height="16" width="16"/></a>
			<br>

	<!-- </c:forEach> -->	
	<input type="submit" value="Créer" name="creer_offre"/>
	</form>
</body>
</html>