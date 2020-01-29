package modelo;

public class Autobus {
	
	private String codAutobus;
	private int numPlazas;
	private double consumoPorKm;
	private String color;
	private int numPlazasOcupadas;
	
	public Autobus(String codAutobus, int numPlazas, int numPlazasOcupadas, double consumoPorKm, String color) {
		this.codAutobus = codAutobus;
		this.numPlazas = numPlazas;
		this.consumoPorKm = consumoPorKm;
		this.color = color;
		this.numPlazasOcupadas = numPlazasOcupadas;
	}

	public String getCodAutobus() {
		return codAutobus;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public double getConsumoPorKm() {
		return consumoPorKm;
	}

	public String getColor() {
		return color;
	}
	
	public int getNumPlazasOcupadas() {
		return numPlazasOcupadas;
	}
	
}
