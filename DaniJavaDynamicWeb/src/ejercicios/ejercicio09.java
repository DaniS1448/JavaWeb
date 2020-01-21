package ejercicios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import helpers.MiHelper;

@MultipartConfig(location = "C:\\Users\\USUARIO\\Desktop", maxFileSize = 10485760L)
@WebServlet("/ejercicio09")
public class ejercicio09 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(MiHelper.titulo("Formulario y subida de ficheros"));
		
		out.println("<form method='post' enctype=\"multipart/form-data\">");
		out.println("<h4>Selecciona un fichero</h4>"
				+ "<input type='file' name='miArchivo'></br>"
				+ "<h4>Nuevo nombre</h4>"
				+ "<input type='text' name='nuevoNombre'/></br>"
				+ "<input type='submit' value='Subir'>");
		out.println("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		Part parteArchivo = request.getPart("miArchivo");  
		String nombre = request.getParameter("nuevoNombre");
		
		if(!nombre.contentEquals("")) {
			parteArchivo.write(nombre);
		}else {
			parteArchivo.write(MiHelper.devuelveNombreArchivo(parteArchivo));
		}
		
		
		
		
	}

}
