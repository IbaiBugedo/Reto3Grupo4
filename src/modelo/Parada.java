package modelo;

public class Parada {

	private String codParada;
	private String calle;
	private String nomParada;
	private float coordenadas;
	
	public Parada(String codParada, String calle, String nomParada, float coordenadas) {
		this.codParada = codParada;
		this.calle = calle;
		this.nomParada = nomParada;
		this.coordenadas = coordenadas;
	}

	public String getCodParada() {
		return codParada;
	}

	public String getCalle() {
		return calle;
	}

	public String getNomParada() {
		return nomParada;
	}

	public float getCoordenadas() {
		return coordenadas;
	}

}
