package cls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ServletJDBC
 */
@WebServlet("/ServletJDBC")
public class ServletJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletJDBC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibrosDAO daoLibros=new LibrosDAO();
		List<Libro> listaLibros=new ArrayList<Libro>();
		
		try {
			listaLibros=daoLibros.recuperarLibros();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listadoLibros", listaLibros);
		response.setContentType("text/html");
		// Crea un flujo de salida para escribir la respuesta a la petición del cliente
		PrintWriter out = response.getWriter();

try {
	out.println("<!DOCTYPE html>");
	out.println("<html>");
	out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	out.println("<title>LISTA DE LIBROS</title></head><body>");
	out.println("<table><thead>\r\n" + 
			"			<tr>\r\n" + 
			"			<td>Id</td>" + 
			"			<td>Título</td>" + 
			"			<td>Autor</td>" + 
			"			<td>Precio</td>" + 
			"			<td>Cantidad</td>" + 
			"			</tr>" + 
			"			</thead>");
	for (Libro l: listaLibros) {
		out.println("<tr>");
		out.println("<td>"+l.getIdLibro()+"</td>");
		out.println("<td>"+l.getTitulo()+"</td>");
		out.println("<td>"+l.getAutor()+"</td>");
		out.println("<td>"+l.getPrecio()+"</td>");
		out.println("<td>"+l.getCantidad()+"</td>");
		out.println("</tr>");
	}
	out.println("</table>");
	out.println("</body></html>");
} finally {
	out.close(); // Cerrar el flujo de salida

}
		
		System.out.println(listaLibros);
		// Establece el tipo MIME del mensaje de respuesta
		
	
		//RequestDispatcher requestDispatcher=request.getRequestDispatcher("/vistas/verLibros.jsp");
		//requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
