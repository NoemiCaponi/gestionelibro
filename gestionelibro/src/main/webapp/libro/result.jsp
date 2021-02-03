<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="it.gestionelibro.model.Libro"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp" />
<title>Insert title here</title>
<link href="./assets/css/global.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../navbar.jsp" />

	<main role="main" class="container">

		<div
			class="alert alert-success alert-dismissible fade show ${successMessage==null?'d-none': ''}"
			role="alert">
			${successMessage}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<div class='card shadow-lg p-3 mb-5 bg-white rounded'>
			<div class='card-header'>
				<h5>Lista dei risultati</h5>
			</div>
			<div class='card-body'>
				<a class="btn btn-success " href="PrepareInsertServlet">Add
					New</a>

				<div class='table-responsive'>
					<table class='table table-success table-striped'>
						<thead>
							<tr>
								<th>Id</th>
								<th>Codice</th>
								<th>Titolo</th>
								<th>Prezzo</th>
								<th>Data di Arrivo</th>
								<th>Azioni</th>
							</tr>
						</thead>
						<tbody>
							<% List<Libro> listaLibri = (List<Libro>)request.getAttribute("listaLibriAttribute");
		                		for(Libro item:listaLibri){ %>
							<tr>
								<td><%=item.getId() %></td>
								<td><%=item.getCodice() %></td>
								<td><%=item.getTitolo() %></td>
								
								<td><%=item.getPrezzo() %></td>
								<td><%=item.getDataArrivo()!=null? new SimpleDateFormat("dd/MM/yyyy").format(item.getDataArrivo()):"N.D."%></td>
								<td><a class="btn  btn-sm btn-outline-secondary"
									href="ExecuteVisualizzaServlet?idLibro=<%=item.getId() %>">Visualizza</a>
									<a class="btn  btn-sm btn-outline-primary ml-2 mr-2"
									href="PrepareModificaServlet?idLibro=<%=item.getId()%>">Edit</a>
									<a class="btn btn-outline-danger btn-sm"
									href="PrepareRimozioneServlet?idLibro=<%=item.getId()%>">Delete</a>
								</td>
							</tr>
							<% } %>
						</tbody>
					</table>
				</div>

				<!-- end card-body -->
			</div>
		</div>



		<!-- end container -->
	</main>
	<jsp:include page="../footer.jsp" />

</body>
</html>