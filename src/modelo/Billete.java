package modelo;

import java.util.ArrayList;

public class Billete {

	private String CodLinea,fecha,Hora,Dni;
	private int CodBus,CodParadaInicio,CodParadaFin,codBillete;
	private double precio;
	public Billete(int codBillete, String codLinea, String fecha, String hora, String dni, int codBus,
			int codParadaInicio, int codParadaFin, double precio) {
		super();
		this.codBillete = codBillete;
		CodLinea = codLinea;
		this.fecha = fecha;
		Hora = hora;
		Dni = dni;
		CodBus = codBus;
		CodParadaInicio = codParadaInicio;
		CodParadaFin = codParadaFin;
		this.precio = precio;
	}

	public Billete() {
		
	}

	public int getCodBillete() {
		return codBillete;
	}

	public void setCodBillete(int codBillete) {
		this.codBillete = codBillete;
	}

	public String getCodLinea() {
		return CodLinea;
	}

	public void setCodLinea(String codLinea) {
		CodLinea = codLinea;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return Hora;
	}

	public void setHora(String hora) {
		Hora = hora;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public int getCodBus() {
		return CodBus;
	}

	public void setCodBus(int codBus) {
		CodBus = codBus;
	}

	public int getCodParadaInicio() {
		return CodParadaInicio;
	}

	public void setCodParadaInicio(int codParadaInicio) {
		CodParadaInicio = codParadaInicio;
	}

	public int getCodParadaFin() {
		return CodParadaFin;
	}

	public void setCodParadaFin(int codParadaFin) {
		CodParadaFin = codParadaFin;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	


}
