<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ESO ES OTRA JSP</title>
</head>
<body>
	<h1>ESTA ES LA OTRA PÁGINA</h1>
	<p>El parámetro de inicialización es: </p>
	<p>
	
	<%
		ServletContext sc = request.getServletContext();
		String prmtr = (String)(sc.getAttribute("param"));
		
		out.println(prmtr+"<br>");
		
		String prmtrContext = (String)(sc.getInitParameter("deContexto"));
		
		out.println(prmtrContext);
	%>
	
	</p>
</body>
</html>