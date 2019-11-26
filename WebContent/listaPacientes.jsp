<%@page import="java.util.List"%>
<%@page import="negocio.Paciente"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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


	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">AppProntuario</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Operações <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Deslogar</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid">

		<div class="row">

			<div class="col-lg-2">

				<div class="card">
					<ul class="list-group list-group-flush">
						<li class="list-group-item"><a
							href="/AppProntuario/PacienteController?tela=listar">Pacientes</a></li>
						<li class="list-group-item"><a
							href="/AppProntuario/ProntuarioController?tela=listar">Prontuários</a></li>
					</ul>
				</div>
			</div>

			<div class="col-lg-8">

				<a class="btn btn-default"
					href="/AppProntuario/PacienteController?tela=registrar"> <span
					class="glyphicon glyphicon-plus"></span> Novo Paciente
				</a>

				<h3>Pacientes</h3>
				<%
					if (pacientes != null && pacientes.toArray().length > 0) {
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
							<td><%=paciente.EhCasado()%></td>
							<td><a class="btn btn-default"
								href="/AppProntuario/PacienteController?idPaciente=<%=paciente.getId()%>&tela=editar"
								title="Editar"><span class="glyphicon glyphicon-pencil"></span>
							</a>
								<form action="PacienteController" method="post">
									<input type="hidden" name="idPaciente"
										value="<%=paciente.getId()%>">

									<button type="submit" class="btn btn-link" title="Excluir">
										<span class="glyphicon glyphicon-trash"></span>
									</button>

								</form></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<%
					} else {
				%>
				<p>Nenhum paciente cadastrado.</p>
				<%
					}
				%>

			</div>

		</div>

	</div>
</body>
</html>