<%@ page import="java.util.List" %>
<%@ page import="model.Cliente" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cliente.jsp</title>
</head>
<body>

	<form method="post" action="./FirstServlet">
		E-mail:
		<input type="text" value="" name="email" /> 
		<input type="submit" value="Save">
	</form>

<%
// Obt�m a lista de clientes do atributo da requisi��o
List<Cliente> lista = (List<Cliente>) request.getAttribute("lista");

// Verifica se a lista n�o � nula e n�o est� vazia
if (lista != null && !lista.isEmpty()) {
    for (Cliente c : lista) {
        out.print(c.getEmail() + "<br/>"); // Usa o objeto `c` para acessar o m�todo `getEmail()`
    }
} else {
    out.print("Nenhum cliente encontrado.");
}
%>

</body>
</html>