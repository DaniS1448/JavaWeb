package ejercicios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formulario")
public class formulario extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Rellena el formulario</h1>"
				+ "<form action='' method='get'>"
				+ "NOMBRE: <input type='text' name='nombre'/>"
				+ "<input type='submit' value='Enviar'/>"
				+ "</form>");
		String nombre = request.getParameter("nombre");
		
		if (nombre!=null) {
			out.println("<h3>Hola "+ nombre +"!!Buenos días!!</h3>");
		}
		
	}

}
