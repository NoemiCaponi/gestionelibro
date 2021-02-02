<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="it.gestionelibro.model.Autore" %>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp" />
	<title>Visualizza</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container ">
		
		<div class='card shadow p-3 mb-5 bg-white rounded'>
		    <div class='card-header item'>
		        Visualizza dettaglio
		    </div>
		    <% Autore autoreInPagina = (Autore)request.getAttribute("visualizza_autore_attr"); %>
		
		    <div class='card-body'>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Nome</dt>
				  <dd class="col-sm-9"><%=autoreInPagina .getNome() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Cognome:</dt>
				  <dd class="col-sm-9"><%=autoreInPagina .getCognome() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Opere:</dt>
				  <dd class="col-sm-9"><%=autoreInPagina .getOpere() %></dd>
		    	</dl>
		    	
		   

		    	
		    </div>
		    
		    <div class='card-footer item'>
		        <a href="ListAutoriServlet" class='btn btn-outline-success' style='width:80px'>
		            <i class='fa fa-chevron-left'></i> Back
		        </a>
		    </div>
		</div>	
	
	
	<!-- end main container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	

</body>
</html>