<!-- navbar -->
<nav class="navbar navbar-expand-md navbar- fixed-top" style="background-color: #E3F3E3;">

	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
       <span class="navbar-toggler-icon"></span>
     </button>

  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link item" href="index.jsp"><b>Home</b><span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link item" href="ListLibriServlet"><b>Lista</b></a>
      </li>
       <li class="nav-item">
        <a class="nav-link item" href="PrepareInsertServlet"><b>Inserisci nuovo</b></a>
      </li>
      <!--  <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="index.jsp">Home</a>
          <a class="dropdown-item" href="ListLibriServlet">Consulta l'archivio</a>
        </div>
      </li>-->
    </ul>
    <form class="form-inline my-2 my-lg-0" method="post" action="ExecuteRicercaServlet" novalidate="novalidate">
      <input class="form-control mr-sm-2" type="search" name="ricerca" id="ricerca" placeholder="Search" aria-label="Search" required>
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cerca</button>
    </form>
  </div>
</nav>

<style>
	.item {
	  
	  color:#28a745;

	}
</style>
