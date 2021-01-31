package it.gestionelibro.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionelibro.service.MyServiceFactory;


public class ListLibriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				try {
					request.setAttribute("listaLibriAttribute", MyServiceFactory.getLibroServiceInstance().listAll());
				} catch (Exception e) {
					//qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
					e.printStackTrace();
					request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
					request.getRequestDispatcher("/index.jsp").forward(request, response);
					return;
				}
				request.getRequestDispatcher("/libro/result.jsp").forward(request, response);
	}

}
