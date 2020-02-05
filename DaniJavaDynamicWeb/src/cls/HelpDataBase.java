package cls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelpDataBase {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/despliegue";
	private static final String USUARIO="root";
	private static final String CLAVE="";
	
	@SuppressWarnings("finally")
	public int modificarRegistro (String consultaSQL) {
		Connection con=null;
		PreparedStatement sentencia=null;
		int filasAfectadas=0;
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL,USUARIO,CLAVE);
			sentencia=con.prepareStatement(consultaSQL);
			filasAfectadas=sentencia.executeUpdate();
		}
		catch (ClassNotFoundException e){
			System.out.println("Error en el driver: " + e.getMessage());
			
		}
		catch (SQLException e) {
			System.out.println("Error de SQL: " + e.getMessage());
		}
		finally {
			if (sentencia!=null) {
				try {sentencia.close();
				}
				catch (SQLException e) {
				}
				}
			if (con!=null) {
				try {con.close();
				}
				catch (SQLException e) {
				}
				}
			return filasAfectadas;
			}
		}
	
	

	public ResultSet seleccionarRegistros (String consultaSQL) {
	Connection con=null;
	Statement sentencia=null;
	ResultSet filas=null;
	try {
		Class.forName(DRIVER);
		con=DriverManager.getConnection(URL,USUARIO,CLAVE);
		sentencia=con.createStatement();
		filas=sentencia.executeQuery(consultaSQL);
	}
	catch (ClassNotFoundException e){
		System.out.println("Error en el driver: " + e.getMessage());
		
	}
	catch (SQLException e) {
		System.out.println("Error de SQL: " + e.getMessage());
	}
	
	return filas;
		
	
}
	
}

