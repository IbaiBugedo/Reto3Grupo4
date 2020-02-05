package modelo;

import java.util.Date;

public class Autobus {

	private int codAutobus;
	private int numPlazas;
	private double consumoPorKm;
	private int numPlazasOcupadas;
	private Date fecha;
	private String hora;

	public Autobus(int codAutobus, int numPlazas, double consumoPorKm, String color, int numPlazasOcupadas, Date fecha,
			String hora) {
		super();
		this.codAutobus = codAutobus;
		this.numPlazas = numPlazas;
		this.consumoPorKm = consumoPorKm;
		this.numPlazasOcupadas = numPlazasOcupadas;
		this.fecha = fecha;
		this.hora = hora;
	}

	public Autobus() {
		// TODO Auto-generated constructor stub
	}

	public int getCodAutobus() {
		return codAutobus;
	}

	public void setCodAutobus(int codAutobus) {
		this.codAutobus = codAutobus;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	public double getConsumoPorKm() {
		return consumoPorKm;
	}

	public void setConsumoPorKm(double consumoPorKm) {
		this.consumoPorKm = consumoPorKm;
	}

	public int getNumPlazasOcupadas() {
		return numPlazasOcupadas;
	}

	public void setNumPlazasOcupadas(int numPlazasOcupadas) {
		this.numPlazasOcupadas = numPlazasOcupadas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

}
