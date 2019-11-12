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

	<div class="container">
		<h3>Cadastrar Usuário</h3>

		<form action="UsuarioController" method="post">
			<div class="form-group">
				<label for="nome">Nome:</label> <input type="text"
					class="form-control" id="nome" placeholder="Entre com o seu nome"
					name="nome"  >
			</div>

			<div class="form-group">
				<label for="pwd">Senha:</label> <input type="password"
					class="form-control" id="senha" placeholder="Entre com a sua senha"
					name="senha" value="<%= %>">
			</div>

			<div class="form-check">
				<input type="checkbox" class="form-check-input" id="ehCasado">
				<label class="form-check-label" for=""ehCasado"" value="<%= %>">É casado?</label>
			</div>

			<button type="submit" class="btn btn-default">Salvar</button>
		</form>
	</div>
</body>
</html>