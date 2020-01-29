package modelo;

import java.util.ArrayList;

public class Billete {

	private String numBillete;
	private ArrayList<String> arrayFechas = new ArrayList<String>();
	private ArrayList<Linea> arrayLineas = new ArrayList<Linea>();
	private ArrayList<Autobus> arrayAutobus = new ArrayList<Autobus>();
	private double precioTrayecto;
	
	
	public Billete(String numBillete, ArrayList<String> arrayFechas, ArrayList<Linea> arrayLineas,
			ArrayList<Autobus> arrayAutobus, double codTrayecto) {
		this.numBillete = numBillete;
		this.arrayFechas = arrayFechas;
		this.arrayLineas = arrayLineas;
		this.arrayAutobus = arrayAutobus;
		this.precioTrayecto = codTrayecto;
	}

	public String getNumBillete() {
		return numBillete;
	}

	public ArrayList<String> getArrayFechas() {
		return arrayFechas;
	}

	public ArrayList<Linea> getArrayLineas() {
		return arrayLineas;
	}

	public ArrayList<Autobus> getArrayAutobus() {
		return arrayAutobus;
	}

	public double getCodTrayecto() {
		return precioTrayecto;
	}
	
	
}
