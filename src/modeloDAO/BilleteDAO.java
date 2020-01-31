package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.Conexion;
import modelo.Autobus;
import modelo.Parada;

public class BilleteDAO {

	private final double precioGasoil=0.80;
	
	public double mPrecioTrayecto(Autobus pAutobus, Parada parada1, Parada parada2) {
		
		double beneficio;
		double precioFinal=0;
		double distancia=distanciaCoord(parada1, parada2);
		double consumo=pAutobus.getConsumoPorKm();
		int numAsientosOcupados=pAutobus.getNumPlazasOcupadas();
		
		beneficio=(((distancia/consumo)*precioGasoil)/numAsientosOcupados)*0.2;
		precioFinal = (((distancia/consumo)/numAsientosOcupados)*precioGasoil)+beneficio;
		
		
		return precioFinal;
		
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
	
	/*public static double mLat1(int codParada) {
		double latitud=0;
		Connection co = null;
	
		ResultSet rs = null;
	
		PreparedStatement stmt = null;
		
		String sql = "SELECT Latitud FROM parada WHERE Cod_Parada = ?;";
	
	
		try {
			co = Conexion.conectar();
	
			stmt = co.prepareStatement(sql);
			stmt.setInt(1, codParada);
			rs = stmt.executeQuery();
	
			if (rs.first()) {
				latitud=rs.getInt(1);
			}
			
			stmt.close();
			rs.close();
			co.close();
	
		} catch (SQLException e) {
			System.out.println("Error: Clase BilleteDAO, metodo Latitud1");
			e.printStackTrace();
		}
	
		return latitud;
	}
	
	public static double mLong1(int codParada) {
		double longitud=0;
		Connection co = null;
	
		ResultSet rs = null;
	
		PreparedStatement stmt = null;
		
		String sql = "SELECT Longitud FROM parada WHERE Cod_Parada = ?;";
	
	
		try {
			co = Conexion.conectar();
	
			stmt = co.prepareStatement(sql);
			stmt.setInt(1, codParada);
			rs = stmt.executeQuery();
	
			if (rs.first()) {
				longitud=rs.getInt(1);
			}
			
			stmt.close();
			rs.close();
			co.close();
	
		} catch (SQLException e) {
			System.out.println("Error: Clase BilleteDAO, metodo Longitud1");
			e.printStackTrace();
		}
	
		return longitud;
	}*/
}
