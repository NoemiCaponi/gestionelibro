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

@WebServlet("/ExecuteModificaServlet")
public class ExecuteModificaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idLibroDaModificare = request.getParameter("libroId");
		String codiceInput = request.getParameter("codice");
		String titoloInput = request.getParameter("titolo");
		String autoreInput = request.getParameter("autore");
		String prezzoInput = request.getParameter("prezzo");
		String dataArrivoInput = request.getParameter("dataArrivo");

		Date dataArrivoParsed = Utility.parseDateArrivoFromString(dataArrivoInput);

		Long idLibroConvertito = Long.parseLong(idLibroDaModificare);
		int prezzoConvertito = Integer.parseInt(prezzoInput);

		try {
			Libro libroInstance = MyServiceFactory.getLibroServiceInstance().caricaSingoloElemento(idLibroConvertito);
			if (!Utility.validateInput(codiceInput, titoloInput, prezzoInput, dataArrivoInput, autoreInput)
					|| dataArrivoParsed == null) {
				request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
				request.setAttribute("libroAttributeModifica", libroInstance);
				request.getRequestDispatcher("/libro/update.jsp").forward(request, response);
				return;
			}
			libroInstance.setCodice(codiceInput);
			libroInstance.setTitolo(titoloInput);
			libroInstance.setAutore(autoreInput);
			libroInstance.setPrezzo(prezzoConvertito);
			libroInstance.setDataArrivo(dataArrivoParsed);

			MyServiceFactory.getLibroServiceInstance().aggiorna(libroInstance);

			request.setAttribute("successMessage", "Operazione effettuata con successo");
			request.setAttribute("listaLibriAttribute", MyServiceFactory.getLibroServiceInstance().listAll());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/libro/result.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/libro/result.jsp").forward(request, response);

	}

}
