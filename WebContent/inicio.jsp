<%@page import="negocio.Usuario"%>

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
		String usuarioLogado = (String)session.getAttribute("usuarioLogado");
	%>

	<div class="container">
		<h2>AppProntuario: Sistema de Prontuário</h2>
		<h2>
			Olá
			<%=usuarioLogado%>, seja bem-vindo!
		</h2>

		<a href="/AppProntuario/PacienteController">Pacientes</a>
	</div>
</body>
</html>