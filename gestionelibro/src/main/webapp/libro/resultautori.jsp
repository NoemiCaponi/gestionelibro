<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="it.gestionelibro.model.Autore"%>
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
				<h5>Lista degli Autori</h5>
			</div>
			<div class='card-body'>
				<a class="btn btn-success " href="PrepareInsertAutoreServlet">Add
					New</a>

				<div class='table-responsive'>
					<table class='table table-success table-striped'>
						<thead>
							<tr>
								<th>Id</th>
								<th>Nome</th>
								<th>Cognome</th>
								<th>Azioni</th>
							</tr>
						</thead>
						<tbody>
							<% List<Autore> listaAutori = (List<Autore>)request.getAttribute("listaAutoriAttribute");
		                		for(Autore item:listaAutori){ %>
							<tr>
								<td><%=item.getId() %></td>
								<td><%=item.getNome() %></td>
								<td><%=item.getCognome() %></td>
								
								<td><a class="btn  btn-sm btn-outline-secondary"
									href="ExecuteVisualizzaAutoreServlet?idAutore=<%=item.getId() %>">Visualizza</a>
									<a class="btn  btn-sm btn-outline-primary ml-2 mr-2"
									href="PrepareModificaAutoreServlet?idAutore=<%=item.getId()%>">Edit</a>
									<a class="btn btn-outline-danger btn-sm"
									href="PrepareRimozioneAutoreServlet?idAutore=<%=item.getId()%>">Delete</a>
									<a class="btn btn-outline-danger btn-sm"
									href="PrepareAggiuntaLibroServlet?idAutore=<%=item.getId()%>">Aggiungi Libro</a>
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