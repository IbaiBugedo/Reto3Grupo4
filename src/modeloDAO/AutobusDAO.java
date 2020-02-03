package modeloDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import modelo.Autobus;
import modelo.Linea;

public class AutobusDAO {

	public static ArrayList<Autobus> mObtenerHoraAutobus(String fecha, String cod_Linea) {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT hora FROM linea_autobus where fecha='"+fecha+"'and cod_linea='"+cod_Linea+"'ORDER BY hora;";
		
		ArrayList<Autobus> listaAutobus= new ArrayList<Autobus>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Autobus c=new Autobus();
				c.setHora(rs.getString(1));
				listaAutobus.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase Contacto, método mObtenerContactos");
			e.printStackTrace();
		}
		
		return listaAutobus;
	}
	
	public static ArrayList<Autobus> mObtenerDatosAutobus(String cod_Linea,String hora,String fecha) {
		String horaS;
		
		horaS=""+hora+"";
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT a.hora,a.Cod_bus,b.consumo_km,a.fecha,b.N_plazas,a.Plazas_Ocupadas FROM linea_autobus A,autobus B where A.cod_bus=B.cod_bus and cod_linea='"+cod_Linea+"'and hora='"+horaS+"' and a.fecha ='"+fecha+"'ORDER BY hora;";
		
		ArrayList<Autobus> listaAutobus= new ArrayList<Autobus>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Autobus c=new Autobus();
				c.setHora(rs.getString(1));
				c.setCodAutobus(rs.getInt(2));
				c.setConsumoPorKm(rs.getDouble(3));
				c.setFecha(rs.getDate(4));
				c.setNumPlazas(rs.getInt(5));
				c.setNumPlazasOcupadas(rs.getInt(6));
				listaAutobus.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase Contacto, método mObtenerDatosAutobus");
			e.printStackTrace();
		}
		
		return listaAutobus;
	}
}
