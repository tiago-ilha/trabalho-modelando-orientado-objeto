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
		boolean operacaoValida = (boolean)request.getAttribute("operacaoValida");
		String mensagem = (String) request.getAttribute("mensagem");
	%>

	<div class="btn-group btn-group-justified">
		<h2><%=titulo%></h2>
		<div class="alert <%= operacaoValida ? "alert-success" : "alert-danger" %>">
			<%=mensagem%>
		</div>
	</div>


	<h2>Registrar Paciente</h2>

	<form action="PacienteController" method="post">
		<div class="form-group">
			<label for="Nome">Nome:</label> <input type="text"
				class="form-control" id="nome" placeholder="Entre com o seu Nome"
				name="nome">
		</div>

		<div class="form-group">
			<label for="documento">Documento:</label> <input type="text"
				class="form-control" id="documento"
				placeholder="Entre com o seu Documento" name="documento" value="">
		</div>

		<div class="form-check">
			<input type="checkbox" class="form-check-input" id="casado">
			<label class="form-check-label" for="casado">Casado</label>
		</div>

		<button type="submit" class="btn btn-default">Salvar</button>
	</form>
	</div>

</body>
</html>