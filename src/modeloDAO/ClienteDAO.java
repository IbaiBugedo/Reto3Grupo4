package modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;
import modelo.Cliente;

public class ClienteDAO {
	
	public ClienteDAO() {
		
	}
	
	public boolean mInsetarContacto(Cliente cliente) {
		boolean registrar = false;
		
		Connection con=null;
		
	
		String sql = " insert into Cliente values(?,?,?,?,?) ";
		
		try {
			con=Conexion.conectar();
			
		    PreparedStatement cs = con.prepareStatement(sql);
		   
		    cs.setString(1, cliente.getDni());
		    cs.setString(2, cliente.getNombre());
		    cs.setString(3, cliente.getApellido());
		    cs.setString(4, cliente.getSexo());
		    cs.setString(5, cliente.getContraseña());
	
		    cs.execute();
			
		
		    registrar=true;
		
	
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDAO, método insertar");
			e.printStackTrace();
		}
		return registrar;
	}

	public boolean mIniciarSesion(String dniCliente, String contraseñaCliente) {
		boolean existeContacto=false;
		Connection co = null;
	
		ResultSet rs = null;
	
		PreparedStatement stmt = null;
		
		String sql = "SELECT * FROM cliente WHERE DNI = ? && Contraseña = ?;";
	
	
		try {
			co = Conexion.conectar();
	
			stmt = co.prepareStatement(sql);
			stmt.setString(1, dniCliente);
			stmt.setString(2, contraseñaCliente);
			rs = stmt.executeQuery();
	
			if (rs.first()) {
				existeContacto=true;
			}
			
			stmt.close();
			rs.close();
			co.close();
	
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDAO, metodo Iniciar Sesion");
			e.printStackTrace();
		}
	
		return existeContacto;
	}

}
