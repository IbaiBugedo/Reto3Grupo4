package modeloDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import modelo.Linea;
import modelo.Parada;

public class ParadaDAO {


	public static ArrayList<Parada> mObtenerParada(String lineaS) {
		
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		
		String sql="SELECT nombre,calle,latitud,longitud,a.cod_parada FROM parada a, linea_parada b where a.cod_parada=b.cod_parada and cod_linea='"+lineaS+"' ORDER BY num_parada ;";
		
		ArrayList<Parada> listaParada= new ArrayList<Parada>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Parada c=new Parada(sql, sql, 0, 0,sql);
				c.setNombre(rs.getString(1));
				c.setCalle(rs.getString(2));
				c.setLatitud(rs.getDouble(3));
				c.setLongitud(rs.getDouble(4));
				c.setCod_Parada(rs.getInt(5));
				listaParada.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ParadaDAO, método mObtenerParada");
			e.printStackTrace();
		}
		
		return listaParada;
	}
	
	public static ArrayList<Parada> mOrdenarParada(ArrayList<Parada> paradas){
		
		ArrayList<Parada> listaParadaOrdenada= new ArrayList<Parada>();
		
		double lat1=paradas.get(0).getLatitud();
		double long1=paradas.get(0).getLongitud();
		double diferenciaX=0;
		double diferenciaY=0;
		double distanciaE[] = new double[paradas.size()];
		
		for(int i=1; i<=paradas.size(); i++) {
			double lat2=paradas.get(i).getLatitud();
			double long2=paradas.get(i).getLongitud();
			
			diferenciaX=lat1-lat2;
			diferenciaY=long1-long2;
			
			distanciaE[i-1]=Math.sqrt(Math.pow(diferenciaX, 2) + Math.pow(diferenciaY, 2));
		}
		
		for(int i=0; i<=distanciaE.length; i++) {
			
			
			
		}
		
		
		
		return listaParadaOrdenada;
	}
}
