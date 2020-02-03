package modelo;

public class Parada {

	private String Nombre;
	private String Calle;
	private double latitud;
	private double longitud;
	private int cod_Parada;
	
	public Parada(String nombre, String calle, double latitud, double longitud, int cod_Parada) {
		super();
		this.Nombre = nombre;
		this.Calle = calle;
		this.latitud = latitud;
		this.longitud = longitud;
		this.cod_Parada= cod_Parada;
	}


	public Parada(String sql, String sql2, int latitud2, int longitud2, String sql3) {
		// TODO Auto-generated constructor stub
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


	public int getCod_Parada() {
		return cod_Parada;
	}


	public void setCod_Parada(int cod_Parada) {
		this.cod_Parada = cod_Parada;
	}
	
	
	
	
}
