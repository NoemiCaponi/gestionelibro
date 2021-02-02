package it.gestionelibro.web.servlet.autore;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionelibro.model.Autore;
import it.gestionelibro.model.Libro;
import it.gestionelibro.service.MyServiceFactory;
import it.gestionelibro.utility.Utility;

@WebServlet("/ExecuteInserisciAutoreServlet")
public class ExecuteInserisciAutoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeParam = request.getParameter("nome");
		String cognomeParamString = request.getParameter("cognome");
		String titoloParamString = request.getParameter("titolo");
		String codiceParamString = request.getParameter("codice");
		String prezzoParamString = request.getParameter("prezzo");
		String dataArrivoInput = request.getParameter("dataArrivo");

		Date dataArrivoParsed = Utility.parseDateArrivoFromString(dataArrivoInput);
		Integer prezzoInputParsed = Integer.parseInt(prezzoParamString);

		if (!Utility.validateInput(codiceParamString, titoloParamString, prezzoParamString, dataArrivoInput)
				|| dataArrivoParsed == null && !Utility.validateInputAutore(nomeParam, cognomeParamString)) {
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione!");
			request.getRequestDispatcher("/libro/insert.jsp").forward(request, response);
			return;
		}

		Autore autoreInput = new Autore(nomeParam, cognomeParamString);
		Libro libroNuovo = new Libro(titoloParamString, codiceParamString, prezzoInputParsed, dataArrivoParsed,
				autoreInput);
		autoreInput.addLibro(libroNuovo);

		try {
			
			MyServiceFactory.getAutoreServiceInstance().inserisciNuovo(autoreInput);
			//MyServiceFactory.getLibroServiceInstance().inserisciNuovo(libroNuovo);
			request.setAttribute("listaAutoriAttribute", MyServiceFactory.getAutoreServiceInstance().listAll());
			request.setAttribute("successMessage", "Inserimento eseguito correttamente!");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione!");
			request.getRequestDispatcher("/libro/insertautore.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/libro/resultautori.jsp").forward(request, response);

	}

}
