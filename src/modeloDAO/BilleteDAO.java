package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import modelo.Autobus;
import modelo.Billete;
import modelo.Cliente;
import modelo.Linea;
import modelo.Parada;

public class BilleteDAO {

	private final static double precioGasoil=0.80;
	
	public static double mPrecioTrayecto(Autobus pAutobus, Parada parada1, Parada parada2) {
		int billeteInt;
		double beneficio,costeBillete;
		double precioFinal=0;
		double distancia=distanciaCoord(parada1, parada2);
		double consumo=pAutobus.getConsumoPorKm();
		int numAsientosOcupados=pAutobus.getNumPlazasOcupadas();
		int numPlazasTotales=pAutobus.getNumPlazas();
		beneficio=(((distancia*consumo)*precioGasoil)*0.2)/numPlazasTotales;
		costeBillete=(((distancia*consumo)*precioGasoil)+beneficio);
		
		
		return costeBillete;
		
	}
	
	public static double distanciaCoord(Parada parada1, Parada parada2) {  
       
        double radioTierra = 6371;//en kilómetros  
        double dLat = Math.toRadians(parada2.getLatitud() - parada1.getLatitud());  
        double dLng = Math.toRadians(parada2.getLongitud() - parada1.getLongitud());  
        double sindLat = Math.sin(dLat / 2);  
        double sindLng = Math.sin(dLng / 2);  
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
                * Math.cos(Math.toRadians(parada1.getLatitud()) * Math.cos(Math.toRadians(parada2.getLatitud())));  
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
        double distancia = radioTierra * va2;  
   
        return distancia;  
    } 
	
	public static ArrayList<Billete> mObtenerNBillete() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT max(Cod_billete)+1 FROM billete ;";
		
		ArrayList<Billete> listaBillete= new ArrayList<Billete>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Billete c=new Billete();
				c.setCodBillete(rs.getInt(1));
				listaBillete.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase Contacto, método mObtenerContactos");
			e.printStackTrace();
		}
		
		return listaBillete;
	}
	
	public static boolean mInsertarBillete(Billete billete) {
		boolean registrar = false;
		
		Connection con=null;
		PreparedStatement stmt = null;
	
		String sql = " insert into billete values(?,?,?,?,?,?,?,?,?); ";
		
		try {
			con=Conexion.conectar();
			
		   stmt = con.prepareStatement(sql);
		   
		   stmt.setInt(1, billete.getCodBillete());
		   stmt.setString(2, billete.getCodLinea());
		   stmt.setInt(3,billete.getCodBus());
		   stmt.setInt(4,billete.getCodParadaInicio());
		   stmt.setInt(5,billete.getCodParadaFin());
		   stmt.setString(6,billete.getFecha());
		   stmt.setString(7,billete.getHora());
		   stmt.setString(8,billete.getDni());
		   stmt.setDouble(9,billete.getPrecio());
	
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
}