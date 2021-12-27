<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de Atendimento</title>
<link rel="icon" href="imagens/fivecon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar Atendimento</h1>
	<form name="frmContato" action="update">
		<table>
			<tr>
				<td><input type="text" name="id" id="caixa3" readonly value="<%out.print(request.getAttribute("id_atendimento"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" placeholder="Nome"
					class="Caixa1" value="<%out.print(request.getAttribute("nome_cliente"));%>"></td>	
			</tr>
			<tr>
				<td><input type="text" name="fone" placeholder="Fone"
					class="Caixa1" value="<%out.print(request.getAttribute("telefone_cliente"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="fisio"
					placeholder="Fisioterapeuta" class="Caixa1" value="<%out.print(request.getAttribute("fisio"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="hospital" placeholder="Hospital"
					class="Caixa1" value="<%out.print(request.getAttribute("local_hospital"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome_cirurgiao"
					placeholder="Nome Cirurgião" class="Caixa1" value="<%out.print(request.getAttribute("nome_cirurgiao"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="procedimento"
					placeholder="Procedimento" class="Caixa1" value="<%out.print(request.getAttribute("procedimento"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="cor_tape" placeholder="Cor Tape"
					class="Caixa1" value="<%out.print(request.getAttribute("cor_tape"));%>"></td>
			</tr>
			<tr>
				<td><input type="date" name="data_avaliacao"
					placeholder="Data Avaliação" class="Caixa1" value="<%out.print(request.getAttribute("data_avaliacao"));%>"></td>
			</tr>
			<tr>
				<td><input type="date" name="data_cirurgia"
					placeholder="Data Cirurgia" class="Caixa1" value="<%out.print(request.getAttribute("data_cirurgia"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="horario_cirurgia" placeholder="Horario"
					class="Caixa1" value="<%out.print(request.getAttribute("horario_cirurgia"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1"
			onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>