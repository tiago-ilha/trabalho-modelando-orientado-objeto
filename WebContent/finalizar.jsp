<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String titulo = (String) request.getAttribute("titulo");
		boolean operacaoValida = (boolean) request.getAttribute("operacaoValida");
		String controller = (String) request.getAttribute("controller");
		String mensagem = (String) request.getAttribute("mensagem");
	%>
	
	<div class="btn-group btn-group-justified">
		<h2><%=titulo%></h2>
		<div class="alert <%= operacaoValida ? "alert-success" : "alert-danger" %>">
			<%=mensagem%>
		</div>
	</div>
	
	<div class="container">
		<div class="panel-group">
			<div class="panel panel-default">

				<!-- <c:import url="cabecalho.jsp" /> -->

				<div class="panel-body">
					<div class="btn-group btn-group-justified">
						<div class="btn-group"></div>

						<div class="btn-group"></div>

						<div class="btn-group"></div>

						<div class="btn-group">
							<form action="<%=controller%>">
								<button type="submit" class="btn btn-default">Voltar</button>
							</form>
						</div>

						<div class="btn-group">
							<!-- <c:import url="sair.jsp" /> --> 
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>