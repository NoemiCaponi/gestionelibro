package it.gestionelibro.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionelibro.service.MyServiceFactory;

@WebServlet("/ExecuteRicercaServlet")
public class ExecuteRicercaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String titoloInput=request.getParameter("ricerca");
		try {
		
			request.setAttribute("listaLibriAttribute", MyServiceFactory.getLibroServiceInstance().cercaTuttiTitoli(titoloInput));
		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/libro/result.jsp").forward(request, response);
	}

	

}
