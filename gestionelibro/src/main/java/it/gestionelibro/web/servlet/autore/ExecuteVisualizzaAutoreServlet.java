package it.gestionelibro.web.servlet.autore;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.gestionelibro.service.MyServiceFactory;

@WebServlet("/ExecuteVisualizzaAutoreServlet")
public class ExecuteVisualizzaAutoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idAutore = request.getParameter("idAutore");

		if (!NumberUtils.isCreatable(idAutore)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			request.setAttribute("visualizza_autore_attr",
					MyServiceFactory.getAutoreServiceInstance().caricaSingoloElemento(Long.parseLong(idAutore)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/libro/showautore.jsp").forward(request, response);
	
	}

}
