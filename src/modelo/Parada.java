package modelo;

public class Parada {

	private String Nombre;
	private String Calle;
	private double latitud;
	private double longitud;
	
	
	public Parada(String nombre, String calle, double latitud, double longitud) {
		super();
		Nombre = nombre;
		Calle = calle;
		this.latitud = latitud;
		this.longitud = longitud;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getCalle() {
		return Calle;
	}


	public void setCalle(String calle) {
		Calle = calle;
	}


	public double getLatitud() {
		return latitud;
	}


	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}


	public double getLongitud() {
		return longitud;
	}


	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	
	
	
}
