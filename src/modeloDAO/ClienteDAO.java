
package modeloDAO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;
import modelo.Cliente;

public class ClienteDAO {
	
	public ClienteDAO() {
		
	}
	
	public static boolean mInsetarContacto(Cliente cliente) {
		boolean registrar = false;
		
		Connection con=null;
		PreparedStatement stmt = null;
	
		String sql = " insert into Cliente(DNI, NOMBRE, APELLIDOS,SEXO,CONTRASE�A) values(?,?,?,?,?); ";
		
		try {
			con=Conexion.conectar();
			
		   stmt = con.prepareStatement(sql);
		   
		   stmt.setString(1, cliente.getDni());
		   stmt.setString(2, cliente.getNombre());
		   stmt.setString(3, cliente.getApellido());
		   stmt.setString(4, cliente.getSexo());
		   stmt.setString(5, getMD5(cliente.getContrase�a()));
	
		   stmt.executeUpdate();
			
		   stmt.close();
		   con.close();
		   registrar=true;
		
	
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDAO, m�todo insertar");
			e.printStackTrace();
		}
		return registrar;
	}

	public static boolean mIniciarSesion(String dniCliente, String contrase�aCliente) {
		boolean existeContacto=false;
		Connection co = null;
	
		ResultSet rs = null;
	
		PreparedStatement stmt = null;
		
		String sql = "SELECT * FROM cliente WHERE DNI = ? && Contrase�a = ?;";
	
	
		try {
			co = Conexion.conectar();
	
			stmt = co.prepareStatement(sql);
			stmt.setString(1, dniCliente);
			stmt.setString(2, getMD5(contrase�aCliente));
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
	
	
	public static String getMD5(String input) {
		 try {
		 MessageDigest md = MessageDigest.getInstance("MD5");
		 byte[] messageDigest = md.digest(input.getBytes());
		 BigInteger number = new BigInteger(1, messageDigest);
		 String hashtext = number.toString(16);

		 while (hashtext.length() < 32) {
		 hashtext = "0" + hashtext;
		 }
		 return hashtext;
		 }
		 catch (NoSuchAlgorithmException e) {
		 throw new RuntimeException(e);
		 }
		 }
}
