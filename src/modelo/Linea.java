package modelo;

import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.Icon;

import com.mysql.cj.jdbc.Blob;

import conexion.Conexion;

public class Linea {

	private String nombreLinea;
	private String cod_Linea;
	private String imagen_linea;

	public Linea(String nombreLinea, String cod_Linea, String imagen_linea) {
		super();
		this.nombreLinea = nombreLinea;
		this.cod_Linea = cod_Linea;
		this.imagen_linea = imagen_linea;
	}
	
	
	
	public String getCod_Linea() {
		return cod_Linea;
	}



	public void setCod_Linea(String cod_Linea) {
		this.cod_Linea = cod_Linea;
	}



	public String getNombreLinea() {
		return nombreLinea;
	}

	public void setNombreLinea(String nombreLinea) {
		this.nombreLinea = nombreLinea;
	}



	public String getImagen_linea() {
		return imagen_linea;
	}



	public void setImagen_linea(String string) {
		this.imagen_linea = string;
	}
	
}
