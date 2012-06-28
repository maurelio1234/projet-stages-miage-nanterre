<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="etudiant" scope="request" class="beans.Etudiant" />
	<jsp:useBean id="hSemestre" scope="request" class="java.util.Hashtable" />
	<%
		Float NoteFinal = (Float) (request.getAttribute("NoteFinal"));
	%>
	<h1>
		<%
			//out.print("Note de : "etudiant.getMonCandidat().getNom());
		out.print("Note de : toto");
		%>
	</h1>
	<table>
		<tr>
			<td>Note de Finale :</td>
			<td>
				<%
					out.print(NoteFinal);
				%>
			</td>
		</tr>

		<tr>
			<td>Note des semestres :</td>
			<td>


				<%
					//Iterator itValue = hSemestre.values().iterator();
					//Iterator itKey = hSemestre.keySet().iterator();
					//while (itValue.hasNext()) {
						//out.print("Nom du semestre : " + itKey.next() + " note du semestre : " + itValue.next());
					//}
				%>
			</td>
		</tr>
	</table>
</body>
</html>