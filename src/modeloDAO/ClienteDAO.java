
package modeloDAO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import controlador.ControladorAlerta;
import modelo.Cliente;
import modelo.Parada;

public class ClienteDAO {
	
	public ClienteDAO() {
		
	}
	
	public static boolean mInsetarContacto(Cliente cliente) {
		boolean registrar = false;
		
		Connection con=null;
		PreparedStatement stmt = null;
	
		String sql = " insert into Cliente(DNI, NOMBRE, APELLIDOS,SEXO,CONTRASEÑA) values(?,?,?,?,?); ";
		
		try {
			con=Conexion.conectar();
			
		   stmt = con.prepareStatement(sql);
		   
		   stmt.setString(1, cliente.getDni());
		   stmt.setString(2, cliente.getNombre());
		   stmt.setString(3, cliente.getApellido());
		   stmt.setString(4, cliente.getSexo());
		   stmt.setString(5, getMD5(cliente.getContraseña()));
	
		   stmt.executeUpdate();
			
		   stmt.close();
		   con.close();
		   registrar=true;
		
	
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDAO, método insertar");
			e.printStackTrace();
		}
		return registrar;
	}

	public static boolean mComprobarDniCliente(String dniCliente) {
		boolean existeContacto=false;
		Connection co = null;
	
		ResultSet rs = null;
	
		PreparedStatement stmt = null;
		
		String sql = "SELECT * FROM cliente WHERE DNI = ?;";
	
	
		try {
			co = Conexion.conectar();
	
			stmt = co.prepareStatement(sql);
			stmt.setString(1, dniCliente);
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

	public static ArrayList<Cliente> mObtenerDatosCliente(String DNI) {
		
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		
		String sql="SELECT nombre,DNI,Apellidos,sexo FROM cliente where dni='"+DNI+"' ;";
		
		ArrayList<Cliente> listaCliente= new ArrayList<Cliente>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Cliente c=new Cliente();
				c.setNombre(rs.getString(1));
				c.setDni(rs.getString(2));
				c.setApellido(rs.getString(3));
				c.setSexo(rs.getString(4));
				listaCliente.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ParadaDAO, método mObtenerParada");
			e.printStackTrace();
		}
		
		return listaCliente;
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

	public static boolean mIniciarSesion(String dniCliente, String contraseñaCliente) {
		boolean existeContacto=false;
		Connection co = null;
	
		ResultSet rs = null;
	
		PreparedStatement stmt = null;
		
		String sql = "SELECT * FROM cliente WHERE DNI = ? && Contraseña = ?;";
	
	
		try {
			co = Conexion.conectar();
	
			stmt = co.prepareStatement(sql);
			stmt.setString(1, dniCliente);
			stmt.setString(2, getMD5(contraseñaCliente));
			rs = stmt.executeQuery();
	
			if (rs.first()) {
				existeContacto=true;
			}
			else {
				vista.Alerta ventanaAlerta = new vista.Alerta(6);
				ventanaAlerta.setVisible(true);
				ControladorAlerta controladorAlerta = new ControladorAlerta(ventanaAlerta);
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
