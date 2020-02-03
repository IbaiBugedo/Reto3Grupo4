package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.Icon;

import conexion.Conexion;
import modelo.Autobus;
import modelo.Linea;
import java.awt.Image;

public class LineaDAO {

	public static ArrayList<Linea> mObtenerLinea() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT nombre,Cod_Linea,Imagen_linea FROM linea ORDER BY cod_linea;";
		
		ArrayList<Linea> listaLinea= new ArrayList<Linea>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Linea c=new Linea(sql, sql, null);
				c.setNombreLinea(rs.getString(1));
				c.setCod_Linea(rs.getString(2));
				c.setImagen_linea(rs.getString(3));
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
