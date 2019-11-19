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
		List<Paciente> pacientes = (List<Paciente>) request.getAttribute("pacientes");
	%>

	<div class="container">

		<a class="btn btn-default"
			href="/AppProntuario/PacienteController?tela=registro">Novo
			Paciente</a>

		<h3>Pacientes:</h3>
		<%
			if (pacientes != null) {
		%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Documento</th>
					<th>Casado</th>
					<th>-</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Paciente paciente : pacientes) {
				%>
				<tr>
					<td><%=paciente.getNome()%></td>
					<td><%=paciente.getDocumento()%></td>
					<td><%=paciente.getCasado() ? "Sim" : "Não"%></td>
					<td>
						<form action="PacienteController" method="post">
							<input type="hidden" name="idPaciente" value="<%=paciente.getId()%>">
							<tr>
								<td><%=paciente%></td>
								<td><button type="submit" class="btn btn-link">Excluir</button></td>
							</tr>
						</form>
					</td>
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