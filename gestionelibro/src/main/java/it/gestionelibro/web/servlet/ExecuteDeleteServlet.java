package it.gestionelibro.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionelibro.model.Libro;
import it.gestionelibro.service.MyServiceFactory;

@WebServlet("/ExecuteDeleteServlet")
public class ExecuteDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idLibroDaEliminare = request.getParameter("libroId");
		Long idLibroConvertito = Long.parseLong(idLibroDaEliminare);

		try {
			Libro libroInstance = MyServiceFactory.getLibroServiceInstance().caricaSingoloElemento(idLibroConvertito);
			MyServiceFactory.getLibroServiceInstance().rimuovi(libroInstance);
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
