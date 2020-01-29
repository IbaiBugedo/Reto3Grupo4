package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexion.Conexion;

public class ClienteDAO {
	
	public ClienteDAO() {
		
	}
	
	public boolean mInsetarContacto(Cliente cliente) {
		boolean registrar = false;
		
		Connection con=null;
		

		String sql = " insert into Cliente values(?,?,?,?) ";
		
		try {
			con=Conexion.conectar();
			
		    PreparedStatement cs = con.prepareStatement(sql);
		   
		    // ordenar tal cual este puesto en la bd //
		    
		    cs.setString(1, cliente.getDni());
		    cs.setString(2, "");
		    cs.setString(3, cliente.getNombre());
		    cs.setString(4, cliente.getContraseña());


		    cs.execute();
			
		
		    registrar=true;
		

		} catch (SQLException e) {
			System.out.println("Error: Clase Contacto, método insertar");
			e.printStackTrace();
		}
		return registrar;
	}
	
	

}
