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

		<h2>Login</h2>
		<form action="LoginController" method="post">
			<div class="form-group">
				<label for="login">Login:</label> <input type="text"
					class="form-control" id="login" placeholder="Entre com o seu login"
					name="login" value="">
			</div>

			<div class="form-group">
				<label for="pwd">Senha:</label> <input type="password"
					class="form-control" id="pwd" placeholder="Entre com a sua senha"
					name="senha" value="">
			</div>

			<button type="submit" class="btn btn-default">Entrar</button>
		</form>
	</div>

	<div class="container">
		<a href="/AppProntuario/UsuarioController">Novo Usuário</a>
	</div>

</body>
</html>