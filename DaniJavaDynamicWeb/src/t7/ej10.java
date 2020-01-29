package t7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		
		if(nombre != "" && users.containsKey(nombre) && users.get(nombre).equals(pwd) ) {
			boolean comprobador = true;
			for(Cookie cadaCookie : request.getCookies()) {
				if(cadaCookie.getName() == "ultimaConexion") {
					Long diferencia = System.currentTimeMillis() - Long.parseLong(cadaCookie.getValue());
					out.println("Han pasado " +diferencia+ " segundos");
					comprobador=false;
				}
			}
			
			if(comprobador) {
				out.println("Ha pasado más de 60 segundos desde la última sesión");
			}
			Cookie miCookie = new Cookie("ultimaConexion",
			Long.toString(System.currentTimeMillis()) ); miCookie.setMaxAge(60);
			response.addCookie(miCookie);
			
		} else {
			out.println("<h1>No se ha podido iniciar sesión</h1>");
		}
	}

}
