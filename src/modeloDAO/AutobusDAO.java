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
	
}
