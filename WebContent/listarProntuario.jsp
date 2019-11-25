<%@page import="java.util.List"%>
<%@page import="negocio.Prontuario"%>

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
		List<Prontuario> prontuarios = (List<Prontuario>) request.getAttribute("prontuarios");
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

				<div></div>
				<a class="btn btn-default"
					href="/AppProntuario/ProntuarioController?tela=registrar"> <span
					class="glyphicon glyphicon-plus"></span>Novo Prontuário
				</a>

				<h3>Lista de Prontuários</h3>

				<%
					if (prontuarios != null && prontuarios.toArray().length > 0) {
				%>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Paciente</th>
							<th>-</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Prontuario prontuario : prontuarios) {
						%>
						<tr>
							<%-- <td><%=prontuario.getNome()%></td> --%>
							<td><a class="btn btn-default"
								href="/AppProntuario/ProntuarioController?idProntuario=<%=prontuario.getIdProntuario()%>&tela=editar"
								title="Editar"><span class="glyphicon glyphicon-pencil"></span>
							</a>
								<form action="ProntuarioController" method="post">
									<input type="hidden" name="idProntuario"
										value="<%=prontuario.getIdProntuario()%>">

									<button type="submit" class="btn btn-link" titl="Excluir">
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
				<p>Nenhum prontuário cadastrado.</p>
				<%
					}
				%>

			</div>

		</div>

	</div>
</body>
</html>