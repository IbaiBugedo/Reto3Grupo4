package modelo;

import java.util.ArrayList;

public class Municipio {

	private String nomMunicipio;
	private int codPostalMunicipio;
	private ArrayList<Parada> arrayParadas = new ArrayList<Parada>();
	
	public Municipio(String nomMunicipio, int codPostalMunicipio, ArrayList<Parada> arrayParadas) {
		super();
		this.nomMunicipio = nomMunicipio;
		this.codPostalMunicipio = codPostalMunicipio;
		this.arrayParadas = arrayParadas;
	}

	public String getNomMunicipio() {
		return nomMunicipio;
	}

	public int getCodPostalMunicipio() {
		return codPostalMunicipio;
	}

	public ArrayList<Parada> getArrayParadas() {
		return arrayParadas;
	}
		
	
}
