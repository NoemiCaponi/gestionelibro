<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="it.gestionelibro.model.Libro" %>
    <%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="../header.jsp" />

<title>Elimina</title>
</head>
<body>
<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
		
		<div class='card'>
		    <div class='card-header'>
		        Conferma Eliminazione
		    </div>
		    <% Libro libroDaEliminare = (Libro)request.getAttribute("libroAttributeElimina"); %>
		
		    <div class='card-body'>
		    <form method="post" action="ExecuteDeleteServlet" novalidate="novalidate">
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Codice</dt>
				  <dd class="col-sm-9"><%=libroDaEliminare.getCodice() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Titolo:</dt>
				  <dd class="col-sm-9"><%=libroDaEliminare.getTitolo() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Prezzo:</dt>
				  <dd class="col-sm-9"><%=libroDaEliminare.getPrezzo() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Data di Arrivo:</dt>
				  <dd class="col-sm-9"><%=libroDaEliminare.getDataArrivo()!=null? new SimpleDateFormat("dd/MM/yyyy").format(libroDaEliminare.getDataArrivo()):"N.D."  %></dd>
		    	</dl>
		    	
		    
		    <input type="hidden" name="libroId" value="<%=libroDaEliminare.getId()%>">
		    
		 <button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Elimina</button>
		
		</form>
		
		</div>	
	
	</div>
	
	<!-- end main container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>