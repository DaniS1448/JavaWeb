package pruebas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.MiHelper;


@WebServlet("/prueba1")
public class Prueba1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(MiHelper.titulo("Helper con RadioButtons!"));
				
		
		Map<String,String> arrayValueLabel=new HashMap<String,String>();
		arrayValueLabel.put("F", "Fútbol");
		arrayValueLabel.put("C", "Cantar");
		arrayValueLabel.put("B", "Bailar");
		arrayValueLabel.put("D", "Dormir");
		arrayValueLabel.put("CA", "Caminar");
		
		String [] arrSELEC = {"D","B"};
		
		out.println(MiHelper.pintarRadio("aficiones", arrayValueLabel, "D"));
		
		out.println(MiHelper.titulo("Helper con Checkbox!"));
		out.println(MiHelper.pintarCheckbox("aficiones", arrayValueLabel, arrSELEC));
		
		out.println(MiHelper.titulo("Helper con Select!"));
		out.println(MiHelper.pintarSelectSimple("aficiones", arrayValueLabel, "CA", "multiple"));
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
