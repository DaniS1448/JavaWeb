package despliegue;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletControl
 */
//@WebServlet("/ServletControl")
public class ServletControl extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext contexto = config.getServletContext();
		contexto.setAttribute("param", config.getInitParameter("param"));
	}

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Establece el tipo MIME del mensaje de respuesta
				response.setContentType("text/html");
						// Crea un flujo de salida para escribir la respuesta a la petición del cliente
				PrintWriter out = response.getWriter();
						// Recoge la sesión actual si existe, en otro caso crea una nueva
				HttpSession session = request.getSession();
				Integer contadorAccesos;
				synchronized (session) {
					contadorAccesos = (Integer) session.getAttribute("contadorAccesos");
					if (contadorAccesos == null) {
						contadorAccesos = 0;
					} else {
						contadorAccesos = Integer.valueOf(contadorAccesos+1);
					}
					session.setAttribute("contadorAccesos", contadorAccesos);
				}
				
		//----------------- Escritura de la respuesta en un html
				try {
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
					out.println("<title>Servlet de prueba de sesión</title></head><body>");
					out.println("<h2>Accesos: " + contadorAccesos + " en esta sesión.</h2>");
					out.println("<p>(Identificador de sesión: " + session.getId() + ")</p>");
					out.println("<p>(Fecha de creación de la sesión: " + new Date(session.getCreationTime()) + ")</p>");
					out.println("<p>(Fecha de último acceso a la sesión " + new Date(session.getLastAccessedTime()) + ")</p>");
					out.println("<p>(Máximo tiempo inactivo de la sesión: " + session.getMaxInactiveInterval() + " seconds)</p>");
					out.println("<p><a href='" + request.getRequestURI() + "'>REFRESCAR</a>");
					out.println("<p><a href='" + response.encodeURL(request.getRequestURI())
							+ "'>REFRESCAR CON URL</a>");
					out.println("</body></html>");
				} finally {
					out.close(); // Cerrar el flujo de salida

				}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}