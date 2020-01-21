package t7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ej10")
public class ej10 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<h1>INICIAR SESIÓN</h1>"
				+ "<form method='post'>"
				+ "<label for='nombre'>Nombre</label> <input type='text' name='nombre' id='nombre'/><br/>"
				+ "<label for='pwd'>Contraseña</label> <input type='password' name='pwd' id='pwd'/><br/>"
				+ "<input type='submit' value='Login'/>"
				+ "</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String nombre = request.getParameter("nombre");
		String pwd = request.getParameter("pwd");
		
		Map<String, String> users = new HashMap<>();
		users.put("dani", "stuparu");
		users.put("marta", "santana");
	}

}
