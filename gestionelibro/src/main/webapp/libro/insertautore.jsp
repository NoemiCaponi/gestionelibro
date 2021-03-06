<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="../header.jsp" />
	<title>Inserisci nuovo Autore</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">

</head>
<body>
<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
	
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card shadow-lg p-3 mb-5 bg-white rounded'>
		    <div class='card-header'>
		        <h5>Inserisci un nuovo autore</h5> 
		    </div>
		    <div class='card-body'>

					<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>

					<form method="post" action="ExecuteInserisciAutoreServlet" novalidate="novalidate">
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Nome <span class="text-danger">*</span></label>
								<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire il nome" required>
							</div>
							
							<div class="form-group col-md-6">
								<label>Cognome <span class="text-danger">*</span></label>
								<input type="text" name="cognome" id="cognome" class="form-control" placeholder="Inserire il cognome" required>
							</div>
						
							
						<div class="form-group col-md-6">
								<label>Titolo libro <span class="text-danger">*</span></label>
								<input type="text" name="titolo" id="titolo" class="form-control" placeholder="Inserire un titolo" required>
							</div>
						
						<div class="form-group col-md-6">
								<label>Codice <span class="text-danger">*</span></label>
								<input type="number" class="form-control" name="codice" id="codice" placeholder="Inserire il codice" required>
							</div>
						
						
							<div class="form-group col-md-6">
								<label>Prezzo <span class="text-danger">*</span></label>
								<input type="number" class="form-control" name="prezzo" id="prezzo" placeholder="Inserire prezzo" required>
							</div>
							<div class="form-group col-md-6">
								<label>Data di Arrivo<span class="text-danger">*</span></label>
                        		<input class="form-control" id="dataArrivo" type="date" placeholder="dd/MM/yy"
                            		title="formato : gg/mm/aaaa"  name="dataArrivo" required>
							
							</div>
						</div>
							
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-success">Conferma</button>
					

					</form>

		    
		    
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>