package cls;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class LibrosDAO {
	
	public List<Libro> recuperarLibros() throws SQLException {
		List<Libro> listaLibros = new ArrayList<Libro>();
		ResultSet rs = null;

		try {
			String consultaSQL = "select * from libros";
			HelpDataBase helper = new HelpDataBase();

			rs = helper.seleccionarRegistros(consultaSQL);

			while (rs.next()) {

				listaLibros.add(new Libro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5)));

			}

		} catch (RuntimeException e) {
			System.out.println("Error de acceso" + e.getMessage());

		} finally {

			rs.close();
		}
		System.out.println(listaLibros);
		return listaLibros;

	}
	
	

	

}
