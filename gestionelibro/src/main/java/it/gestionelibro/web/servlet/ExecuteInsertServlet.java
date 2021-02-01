package it.gestionelibro.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionelibro.model.Libro;
import it.gestionelibro.service.MyServiceFactory;
import it.gestionelibro.utility.Utility;

@WebServlet("/ExecuteInsertServlet")
public class ExecuteInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String codiceInput=request.getParameter("codice");
		String titoloInput=request.getParameter("titolo");
		String autoreInput=request.getParameter("autore");
		String prezzoInput=request.getParameter("prezzo");
		String dataArrivoInput=request.getParameter("dataArrivo");
		
		Date dataArrivoParsed=Utility.parseDateArrivoFromString(dataArrivoInput);
		Integer prezzoInputParsed=Integer.parseInt(prezzoInput);
		
		if(!Utility.validateInput(codiceInput, titoloInput, prezzoInput, dataArrivoInput, autoreInput)|| dataArrivoParsed==null) {
			request.setAttribute("errorMessage","Attenzione sono presenti errori di validazione!");
			request.getRequestDispatcher("/libro/insert.jsp").forward(request, response);
			return;
		}
		
		Libro libroDaInserire= new Libro(codiceInput, titoloInput, prezzoInputParsed, dataArrivoParsed, autoreInput);
		
		try {
			
			MyServiceFactory.getLibroServiceInstance().inserisciNuovo(libroDaInserire);
			request.setAttribute("listaLibriAttribute", MyServiceFactory.getLibroServiceInstance().listAll());
			request.setAttribute("successMessage", "Inserimento eseguito correttamente!");
			
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage","Attenzione sono presenti errori di validazione!");
			request.getRequestDispatcher("/libro/insert.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/libro/result.jsp").forward(request,response);
		
	}

}
