package modelo;

import java.util.ArrayList;

public class Linea {

	private String codLinea;
	private ArrayList<Autobus> arrayAutobus = new ArrayList<Autobus>();
	private ArrayList<Municipio> arrayMunicipios = new ArrayList<Municipio>();
	
	public Linea(String codLinea, ArrayList<Autobus> arrayAutobus, ArrayList<Municipio> arrayMunicipios) {
		this.codLinea = codLinea;
		this.arrayAutobus = arrayAutobus;
		this.arrayMunicipios = arrayMunicipios;
	}

	public String getCodLinea() {
		return codLinea;
	}

	public ArrayList<Autobus> getArrayAutobus() {
		return arrayAutobus;
	}

	public ArrayList<Municipio> getArrayMunicipios() {
		return arrayMunicipios;
	}
	
	
}
