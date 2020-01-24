package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	public static Connection conectar() {
		Connection con = null;
		
		String password = "";
		String usuario = "root"; //root@localhost
		String url = "jdbc:mysql://localhost:3306/Reto3?user=" + usuario
				                                     + "&password=" + password;
		try {
			con = DriverManager.getConnection(url);
			if (con != null) {
				System.out.println("Conectado");
			}
		} catch (SQLException e) {
			System.out.println("No se pudo conectar a la base de datos");
			e.printStackTrace();
		}
		return con;
	}

}
