package modelo;

public class CompraActual {
	
	private String origenIda,origenVuelta,destinoIda,destinoVuelta,fechaIda,fechaVuelta,horaIda,horaVuelta,linea,tipoBillete;

	public CompraActual() {
		
	}
	
	
	public CompraActual(String origenIda, String origenVuelta, String destinoIda, String destinoVuelta, String fechaIda,
			String fechaVuelta, String horaIda, String horaVuelta, String linea, String tipoBillete) {
		super();
		this.origenIda = origenIda;
		this.origenVuelta = origenVuelta;
		this.destinoIda = destinoIda;
		this.destinoVuelta = destinoVuelta;
		this.fechaIda = fechaIda;
		this.fechaVuelta = fechaVuelta;
		this.horaIda = horaIda;
		this.horaVuelta = horaVuelta;
		this.linea = linea;
		this.tipoBillete = tipoBillete;
	}


	public String getOrigenIda() {
		return origenIda;
	}


	public void setOrigenIda(String origenIda) {
		this.origenIda = origenIda;
	}


	public String getOrigenVuelta() {
		return origenVuelta;
	}


	public void setOrigenVuelta(String origenVuelta) {
		this.origenVuelta = origenVuelta;
	}


	public String getDestinoIda() {
		return destinoIda;
	}


	public void setDestinoIda(String destinoIda) {
		this.destinoIda = destinoIda;
	}


	public String getDestinoVuelta() {
		return destinoVuelta;
	}


	public void setDestinoVuelta(String destinoVuelta) {
		this.destinoVuelta = destinoVuelta;
	}


	public String getFechaIda() {
		return fechaIda;
	}


	public void setFechaIda(String fechaIda) {
		this.fechaIda = fechaIda;
	}


	public String getFechaVuelta() {
		return fechaVuelta;
	}


	public void setFechaVuelta(String fechaVuelta) {
		this.fechaVuelta = fechaVuelta;
	}


	public String getHoraIda() {
		return horaIda;
	}


	public void setHoraIda(String horaIda) {
		this.horaIda = horaIda;
	}


	public String getHoraVuelta() {
		return horaVuelta;
	}


	public void setHoraVuelta(String horaVuelta) {
		this.horaVuelta = horaVuelta;
	}


	public String getLinea() {
		return linea;
	}


	public void setLinea(String linea) {
		this.linea = linea;
	}


	public String getTipoBillete() {
		return tipoBillete;
	}


	public void setTipoBillete(String tipoBillete) {
		this.tipoBillete = tipoBillete;
	}

	
	
	
}
