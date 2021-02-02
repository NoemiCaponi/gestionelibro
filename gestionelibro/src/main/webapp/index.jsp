<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    
    <jsp:include page="./header.jsp" />
    
    <!-- Custom styles for this template -->
    <link href="./assets/css/global.css" rel="stylesheet">
    <style type="text/css">
    	body {
		  padding-top: 3.5rem;
		}	
    </style>
<title>Home</title>
</head>
<body>

<jsp:include page="./navbar.jsp"></jsp:include>
<main role="main">
	
		

	  <!-- Main jumbotron for a primary marketing message or call to action -->
	  <div class="jumbotron jumbotron-fluid " >
	    <div class="container ">
	      <h1 class="display-3">Benvenuto!</h1>
	      <p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
	      <p><a class="btn btn-success btn-lg" href="ListAutoriServlet" role="button">Apri la lista Autori &raquo;</a></p>
	    </div>
	  </div>
	  
	  <div class="container shadow p-3 mb-5 bg-white rounded">
	  
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	  
	    <!-- Example row of columns -->
	    <div class="row">
	      <div class="col-md-4">
	        <h2>Heading</h2>
	        <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	        <p><a class="btn btn-outline-success" href="PrepareInsertServlet" role="button">Inserisci nuovo &raquo;</a></p>
	      </div>
	      <div class="col-md-4">
	        <h2>Heading</h2>
	        <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	        <p><a class="btn btn-outline-success" href="ListLibriServlet" role="button">Scegli dalla lista Libri &raquo;</a></p>
	      </div>
	      <div class="col-md-4">
	        <h2>Heading</h2>
	        <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
	        <p><a class="btn btn-outline-success" href="ExecuteRicercaServlet" role="button">Effettua una ricerca &raquo;</a></p>
	      </div>
	    </div>
	
	    <hr>
	
	  </div> <!-- /container -->
	
	</main>


<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>