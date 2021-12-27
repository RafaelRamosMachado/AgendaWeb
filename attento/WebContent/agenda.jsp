<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
	@ SuppressWarnings ("unchecked")
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de Atendimentos</title>
<link rel="icon" href="imagens/fivecon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de Atendimentos</h1>
	<a href="novo.html" class="Botao1">Novo Atendimento</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>Fisio</th>
				<th>Hospital</th>
				<th>Cirurgião</th>
				<th>Procedimento</th>
				<th>Cor Tape</th>
				<th>Data Avaliação</th>
				<th>Data Cirurgia</th>
				<th>Horario Cirurgia</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++) { %>
				<tr>
					<td><%=lista.get(i).getId_atendimento()%></td>
					<td><%=lista.get(i).getNome_cliente()%></td>
					<td><%=lista.get(i).getTelefone_cliente()%></td>
					<td><%=lista.get(i).getfisio()%></td>
					<td><%=lista.get(i).getLocal_hospital()%></td>
					<td><%=lista.get(i).getNome_cirurgiao()%></td>
					<td><%=lista.get(i).getProcedimento_cirurgia()%></td>
					<td><%=lista.get(i).getCor_tape()%></td>
					<td><%=lista.get(i).getData_avaliacao()%></td>
					<td><%=lista.get(i).getData_cirurgia()%></td>
					<td><%=lista.get(i).getHorario_cirurgia()%></td>
					<td><a href="select?id_atendimento=<%=lista.get(i).getId_atendimento()%>" class="Botao1">Editar</a></td>
					<td><a href="javascript: confirmar(<%=lista.get(i).getId_atendimento()%>)" class="Botao2">Excluir</a></td>
				</tr>
			<%} %>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>