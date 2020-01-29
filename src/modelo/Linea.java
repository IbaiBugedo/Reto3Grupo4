package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;

public class Linea {

	private String nombreLinea;
	private String cod_Linea;

	public Linea(String nombreLinea, String cod_Linea) {
		super();
		this.nombreLinea = nombreLinea;
		this.cod_Linea = cod_Linea;
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
}
