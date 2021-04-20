<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina inserimento abitante</title>
</head>
<body>
		BENVENUTO:<BR>
		INSERSCI IL TUO ABITANTE :
		<form action="ExecuteInsertServlet" method="post">
			nome: <input type="text" name="nomeinput">
			cognome: <input type="text" name="cognomeinput">
			codicefiscale:<input type="text" name="codicefinput">
			età :<input type="text" name="etainput">
			motto:<input type="text" name="mottoinput">
			<input type="submit" value="inserisci">
		</form>
</body>
</html>