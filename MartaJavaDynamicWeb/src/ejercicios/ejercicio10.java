package ejercicios;

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

import helpers.MiHelper;

@WebServlet("/ejercicio10")
public class ejercicio10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(MiHelper.titulo("Ejercicio de cookies!"));
		
		out.println("<h4>Rellena el formulario</h4>"
				+ "<form action='' method='post'>"
				+ "NOMBRE: <input type='text' name='nombre'/>"
				+ "CONTRASEÑA: <input type='password' name='pwd'/>"
				+ "<input type='submit' value='Enviar'/>"
				+ "</form>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String nombre = request.getParameter("nombre");
		String pwd = request.getParameter("pwd");
		
		Cookie miCookie1 = new Cookie(nombre, pwd);
		miCookie1.setMaxAge(60);
		response.addCookie(miCookie1);
		
		Map<String,String> arrayUsuarios = new HashMap<String,String>();
		arrayUsuarios.put("marta", "marta");
		arrayUsuarios.put("dani", "dani");
		
		if(nombre.contentEquals("") && pwd.contentEquals("")) {
			out.println("Hola, es necesario que valides un usuario");
		}
		else {
			
			for(String clave: arrayUsuarios.keySet()) {
				
				if(clave.contentEquals("marta") && arrayUsuarios.get(clave).contentEquals("marta")) {
					out.println("Hola "+clave+ " llevas sin validarte: __ segundos");
					out.println("en el if marta");
				}
				
				else if(clave.contentEquals("dani") && arrayUsuarios.get(clave).contentEquals("dani")){
					out.println("Hola "+clave+ " llevas sin validarte: __ segundos");
					out.println("en el if dani");
				}
			}				
		}	
	}
	

}
