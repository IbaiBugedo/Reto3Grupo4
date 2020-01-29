package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexion.Conexion;
import modelo.Cliente;

public class LineaDAO {
	
	public LineaDAO() {
		
	}
	
	
	
	public boolean mInsetarContacto(Cliente cliente) {
		boolean registrar = false;
		
		Connection con=null;
		

		String sql = " insert into Clientes values(?,?,?,?) ";
		
		try {
			con=Conexion.conectar();
			
		    PreparedStatement cs = con.prepareStatement(sql);
		   
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

	
	public boolean mConsultarContacto(Cliente cliente) {
		boolean registrar = false;
		
		Connection con=null;
		

		String sql = " select * from Clientes where DNI="+cliente.getDni();
		
		try {
			con=Conexion.conectar();
			
		    PreparedStatement cs = con.prepareStatement(sql);


		    cs.execute();
			
		
		    registrar=true;
		

		} catch (SQLException e) {
			System.out.println("Error: Clase Contacto, método insertar");
			e.printStackTrace();
		}
		return registrar;
	}
}
