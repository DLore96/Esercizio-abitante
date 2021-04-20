<%@page import="it.helloabitante.model.Abitante"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina per la cancellazione</title>
</head>
<body>
	ecco l'abitante che stai eliminando:<br>  
	<%Abitante abitanteInPage=(Abitante)request.getAttribute("esito_attribute"); %>
	CODICE FISCALE:<%=abitanteInPage.getCodiceFiscale()%>
	COGNOME:<%=abitanteInPage.getCognome() %>
	NOME:<%=abitanteInPage.getNome() %>
	ETA:<%= abitanteInPage.getEta() %>
	MOTTO:<%= abitanteInPage.getMottoDiVita() %>
	
	<form action="ExecuteDeleteServlet" method="post">
	<input type="submit" value="elimina">
	<input type="hidden" name="inputid" value="<%= abitanteInPage.getIdAbitante() %>">
	</form>
	<a href = "ExecuteDeleteServlet"> Conferma eliminazione </a>
	<a href = "searchForm.jsp"> Home </a>

</body>
</html>