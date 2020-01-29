package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import conexion.Conexion;
import modelo.Linea;

public class LineaDAO {

	public static ArrayList<Linea> mObtenerLinea() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT nombre,Cod_Linea FROM linea ORDER BY cod_linea;";
		
		ArrayList<Linea> listaLinea= new ArrayList<Linea>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Linea c=new Linea(sql, sql);
				c.setNombreLinea(rs.getString(1));
				c.setCod_Linea(rs.getString(2));
				listaLinea.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase Contacto, método mObtenerContactos");
			e.printStackTrace();
		}
		
		return listaLinea;
	}
}
