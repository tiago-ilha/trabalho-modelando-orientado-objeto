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
		String titulo = (String) request.getAttribute("titulo");
		String tela = (String) request.getAttribute("tela");
		Paciente paciente = (Paciente) request.getAttribute("paciente");
	%>
	<%-- 	<div class="btn-group btn-group-justified">
		<h2><%=titulo%></h2>
		<div class="alert <%= operacaoValida ? "alert-success" : "alert-danger" %>">
			<%=mensagem%>
		</div>
	</div> --%>

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
						aria-expanded="false">Opera��es <span class="caret"></span></a>
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
							href="/AppProntuario/ProntuarioController?tela=listar">Prontu�rios</a></li>
					</ul>
				</div>
			</div>

			<div class="col-lg-8">

				<h2><%=titulo%>
					Paciente
				</h2>

				<form action="PacienteController" method="post">

					<input type="hidden" name="tela" value="<%=tela%>"> <input
						type="hidden" name="idPaciente" value="<%=paciente.getId()%>">

					<div class="form-group">
						<label for="Nome">Nome:</label> <input type="text"
							class="form-control" id="nome" placeholder="Entre com o seu Nome"
							name="nome" value="<%=paciente.getNome()%>">
					</div>

					<div class="form-group">
						<label for="documento">Documento:</label> <input type="text"
							class="form-control" id="documento"
							placeholder="Entre com o seu Documento" name="documento"
							value="<%=paciente.getDocumento()%>">
					</div>

					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="casado"
							name="casado" value="<%=paciente.getCasado()%>"> <label
							class="form-check-label" for="casado">Casado(a)</label>
					</div>

					<button type="submit" class="btn btn-default">Salvar</button>
				</form>

			</div>

		</div>

	</div>

</body>
</html>