<%@page import="java.util.List"%>
<%@page import="negocio.Paciente"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		List<Paciente> lista = (List<Paciente>) request.getAttribute("pacientes");
	%>

	<div class="container">
		<h3>Pacientes:</h3>
		<%
			if (lista != null) {
		%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Documento</th>
					<th>Casado</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Paciente item : lista) {
				%>
				<tr>
					<td><%=item.getNome()%></td>
					<td><%=item.getDocumento()%></td>
					<td><%=item.getCasado() ? "Sim" : "Não"%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<%
			} else {
		%>
		<p>Nenhum paciente cadastrado!!!</p>
		<%
			}
		%>
	</div>
</body>
</html>