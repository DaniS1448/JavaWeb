package ejercicios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/formularioConCheckbox")
public class formularioConCheckbox extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Rellena el formulario</h1>"
				+ "<form action='' method='post'>"
				+ "NOMBRE: <input type='text' name='nombre'/><br>"
				+ "<h3>AFICIONES</h3>"
				+ "<label for='bailar'>Bailar </label><input type='checkbox' id='bailar' name='aficiones[]' value='bailar'/><br>"
				+ "<label for='cantar'>Cantar </label><input type='checkbox' id='cantar' name='aficiones[]' value='cantar'/>"
				+ "<br><input type='submit' value='Enviar'/>"
				+ "</form>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String nombre = request.getParameter("nombre");
		
		String[] aficiones = request.getParameterValues("aficiones[]");
		
		if(nombre == "") {
			
			out.println("<h3>Tienes que introducir un nombre</h3>");
		}else {
			
			if(aficiones == null) {
				
				out.println("<h3>A "+ nombre +" no le gusta nada</h3>");
				
			} else{
			out.println("<h3>A "+ nombre +" le gusta: ");
			
			
			for(String aficion : aficiones) {
				
				out.println(aficion + ", ");
			}
			out.println("</h3>");
			}
		}
		
	}

}
