package helpers;

import java.util.Map;

import javax.servlet.http.Part;

public class MiHelper {
	
	public static String pintarRadio(String nombre, Map<String,String> arrayValueLabel, String seleccionado) {
		
		
		String html="";

		for (String clave : arrayValueLabel.keySet() ) { 
			html+="<input type='radio' name='"+nombre+"' value='"+clave+"' id='"+clave+"'";
			
			if(clave==seleccionado) {
				html+=" checked";
			}
			html+="/>";
			html+="<label for='"+clave+"'>"+arrayValueLabel.get(clave)+"</label><br/>";
		
		}		
		return html;
	}
	
	public static String titulo(String texto) {
		return "<h1>"+texto+"</h1>";
	}
	
	public static String pintarCheckbox(String nombre, Map<String,String> arrayValueCheck, String arraySeleccionado[]) {
				
		String html="";

		for (String clave : arrayValueCheck.keySet()) { 
			html+="<input type='checkbox' name='"+nombre+"[]' value='"+clave+"' id='"+clave+"'";
				for(String valorSelected : arraySeleccionado) {
					if(clave == valorSelected) {
						html+=" checked";
					}
				}
			html+="/>";
			html+="<label for='"+clave+"'>"+arrayValueCheck.get(clave)+"</label><br/>";
		
		}		
		return html;
	}
	
	public static String pintarSelectMultiple(String nombre, Map<String,String> arrayValueSelect, String arraySeleccionado[]) {
		
		String html="";
		
		html+="<select name='"+ nombre +"' multiple>";

			for (String clave : arrayValueSelect.keySet()) { 
				html+="<option value='"+clave+"'"; 
				
					for(String valorSelected : arraySeleccionado) {
						if(clave == valorSelected) {
							html+=" selected";
						}
					}
					
				html+="/>"+arrayValueSelect.get(clave)+"</option>";
			}
		html+="</select>";
		return html;
	}
	public static String pintarSelectSimple(String nombre, Map<String,String> arrayValueSelect, String seleccionado) {
		
		String html="";
		
		html+="<select name='"+ nombre +"'>";
		
			for (String clave : arrayValueSelect.keySet()) { 
				
				html+="<option value='"+clave+"'"; 
				
					if(clave==seleccionado) {
						html+=" selected";
					}
				html+=">"+arrayValueSelect.get(clave)+"</option>";
			}
		html+="</select>";
		return html;
	}
	
	public static String devuelveNombreArchivo(Part parte) {
		
		for(String cd : parte.getHeader("content-disposition").split(";")) {
			if(cd.trim().startsWith("filename")) {
				String filename=cd.substring(cd.indexOf('=') +1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') +1).substring(filename.lastIndexOf('\\') +1);
			}
		}
		return null;
	}
}
