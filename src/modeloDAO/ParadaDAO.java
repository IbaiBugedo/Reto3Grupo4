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


	public static ArrayList<Parada> mObtenerParada(int linea) {
		String lineaS;
		lineaS = "'L"+linea+"'";
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT nombre,calle,latitud,longitud FROM parada where cod_parada in(select cod_parada from linea_parada where cod_linea="+lineaS+") ORDER BY cod_parada ;";
		
		ArrayList<Parada> listaParada= new ArrayList<Parada>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Parada c=new Parada(sql, sql, 0, 0);
				c.setNombre(rs.getString(1));
				c.setCalle(rs.getString(2));
				c.setLatitud(rs.getDouble(3));
				c.setLongitud(rs.getDouble(4));
				listaParada.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase Contacto, m�todo mObtenerContactos");
			e.printStackTrace();
		}
		
		return listaParada;
	}
}