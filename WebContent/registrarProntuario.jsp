<%@page import="java.util.List"%>

<%@page import="negocio.Prontuario"%>
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
		Prontuario prontuario = (Prontuario) request.getAttribute("prontuario");
		List<Paciente> pacientes = (List<Paciente>) request.getAttribute("pacientes");
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

				<h2><%=titulo%>
					Prontuário
				</h2>

				<form action="PacienteController" method="post">

					<input type="hidden" name="tela" value="<%=tela%>">


					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="pacientes">Paciente</label> <select id="pacientes"
								class="form-control">
								<option selected>-- Selecione Paciente --</option>
								<%
									if (pacientes != null && pacientes.toArray().length > 0) {
										for (Paciente paciente : pacientes) {
								%>

								<option value="<%=paciente.getId()%>"><%=paciente.getNome()%></option>

								<%
									}
									}
								%>
								<option></option>
							</select> <input type="hidden" name="idPacienteSelecionado" value="">
						</div>

						<div class="form-group col-md-6">
							<label for="atividades">Atividades</label> <select
								id="atividades" class="form-control">
								<option selected>-- Selecione Atividade --</option>
								<option value="lmp">Limpeza</option>
								<option value="ort">Ortodontia</option>
								<option value="imp">Implante</option>
							</select> <input type="hidden" name="idAtividadeSelecionada" value="">
						</div>

						<button type="button" id="btn-adicionar-atividades" onclick="adicionarAtividades("dadosProntuario")">
							<span class="glyphicon glyphicon-plus"></span>
						</button>
					</div>

					<%
					if(prontuario.getAtividades() != null && prontuario.getAtividades().toArray().length > 0){
					%>
					<table class="table table-striped" id="dadosProntuario" name="dadosProntuario">
						<thead>
							<tr>
								<th>Atividades</th>
								<th>Data Atividade</th>
								<th>-</th>
							</tr>
						</thead>
						<tbody>
							<%
						
					%>
						</tbody>
					</table>
					<%
					}else {
					%>
					<p>Nenhum atividade foi registrada no prontuário</p>
					<%
					}
					%>
					<button type="submit" class="btn btn-default">Salvar</button>
				</form>

			</div>

		</div>

	</div>

	<script>
		$('#pacientes option').click(function() {
			$('input[name=idPacienteSelecionado]').val($(this).val());
		});

		$('#atividades option').click(function() {
			$('input[name=idAtividadeSelecionada]').val($(this).val());
		});
		
		function adicionarAtividades(dadosProntuario)
		{
			var idPaciente = $('input[name=idPaciente]').val();
			var idAtividade = $('input[name=idAtividade]').val();
			
			var nomeAtividade = $("#atividades").text();
			
			$("#" + dadosProntuario + "tbody").append
			(
					"<tr>" +
					"<td>" + nomeAtividade + "</td>" +
					"<td>" + 
					"<input type='hidden' name='idPaciente' value='" + idPaciente + "'/>" +
					"<input type='hidden' name='idAtividade' value='" + idAtividade + "'/>" +
					
					"</td>" +
					
					"</tr>"
			);
		}
		
		/* $("#btn-adicionar-atividades").click(function(){
			
			
			
		}); */
	</script>

</body>
</html>