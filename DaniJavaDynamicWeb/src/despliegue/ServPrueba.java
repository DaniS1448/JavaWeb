package despliegue;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServPrueba
 */
//@WebServlet("/ServPruebaDeLeticia")
public class ServPrueba extends HttpServlet {
	private static String usuario;
	private static String pass;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		usuario = config.getInitParameter("usuario");
		pass = config.getInitParameter("password");
	}

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServPrueba() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Comienzo");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// Establece el tipo MIME del mensaje de respuesta
		response.setContentType("text/html");
		// Crea un flujo de salida para escribir la respuesta a la petici�n del cliente
		PrintWriter out = response.getWriter();
		// Escribe el mensaje de respuesta en una p�gina html
		try {
			out.println("<html>");
			out.println("<head><title>Hola "+usuario+"</title></head>");
			out.println("<body>");
			out.println("<h1>BUENOS DÍAS: "+usuario+" tu contraseña es: "+pass+"</h1>");
			out.println("<h1>PRUEBA DE NUEVA PÁGINA</h1>"); // dice hola
			// Muestra informaci�n de la petici�n del cliente
			out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
			out.println("<p>Protocolo: " + request.getProtocol() + "</p>");
			out.println("<p>Direccion remota: " + request.getRemoteAddr() + "</p>");
			// Genera un n_umero aleatorio para cada petici_on
			out.println("<p>Numero aleatorio: <strong>" + Math.random() + "</strong></p>");
			out.println("</body></html>");
		} finally {
			out.close(); // Cierra el flujo de salida
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