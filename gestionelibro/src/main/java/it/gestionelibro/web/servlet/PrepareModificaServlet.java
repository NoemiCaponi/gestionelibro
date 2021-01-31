package it.gestionelibro.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.gestionelibro.service.MyServiceFactory;


/**
 * Servlet implementation class PrepareModificaServlet
 */
public class PrepareModificaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PrepareModificaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idLibro = request.getParameter("idLibro");

		if (!NumberUtils.isCreatable(idLibro)) {
			
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			request.setAttribute("libroAttributeModifica", MyServiceFactory.getLibroServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idLibro)));
		} catch (Exception e) {
			
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/libro/update.jsp").forward(request, response);
	}

		
	
}
