package pruebas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<a href='prueba1'>PRUEBA 1</a><br/>");
		out.println("<a href='miSegundoServlet'>miSegundoServlet</a><br/>");
		out.println("<a href='formularioConCheckbox'>formularioConCheckbox</a><br/>");
		out.println("<a href='ejercicio09'>ejercicio09</a><br/>");
		out.println("<a href='ServletControl'>ServletControl</a><br/>");
		out.println("<a href='ServPrueba'>ServPrueba</a><br/>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
