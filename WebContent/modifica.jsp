<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>pagina di modifica</title>
</head>
<body>


	
	<%boolean flag= (boolean)request.getAttribute("flag_attribute");
	  if(!flag){
	  %>
	  <form action="ExecuteUpdateServlet" method="post">
	  <%Abitante a =(Abitante)request.getAttribute("input_item"); %>
		NOME :<input type="text" name="nomeinput" value="<%=a.getNome()%>">
		COGNOME :<input type="text" name="cognomeinput"  value="<%=a.getCognome()%>">
		CODICE FISCALE :<input type="text" name="codicefinput"  value="<%=a.getCodiceFiscale()%>">
		MOTTO :<input type="text" name="mottoinput"  value="<%=a.getMottoDiVita()%>">   
		ETA' :<input type="text" name="etainput"  value="<%=a.getEta()%>">
		<input type="submit" value="vai">
	</form>
	
	  <%}else{ %>
	  
	ecco l'abitante che stai modificando:<br>  
	
	<%Abitante abitanteInPage=(Abitante)request.getAttribute("esito_attribute"); %>
	CODICE FISCALE:<%=abitanteInPage.getCodiceFiscale()%>
	COGNOME:<%=abitanteInPage.getCognome() %>
	NOME:<%=abitanteInPage.getNome() %>
	ETA:<%= abitanteInPage.getEta() %>
	MOTTO:<%= abitanteInPage.getMottoDiVita() %>
	
	  <form action="ExecuteUpdateServlet" method="post">
	  	<input type="text" name="inputid" value="<%abitanteInPage.getIdAbitante(); %>">
		<input type="text" name="nomeinput">
		<input type="text" name="cognomeinput">
		<input type="text" name="codicefinput">
		<input type="text" name="mottoinput">
		<input type="text" name="etainput">
		<input type="submit" value="vai">
	</form><% }%>

</body>
</html>