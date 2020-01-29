package modeloDAO;

import modelo.Autobus;

public class BilleteDAO {

	private final double precioGasoil=0.80;
	
	public double mPrecioTrayecto(double pDistancia, Autobus pAutobus) {
		
		double precioFinal=0;
		double distancia=pDistancia;
		double consumo=pAutobus.getConsumoPorKm();
		int numAsientosOcupados=pAutobus.getNumPlazasOcupadas();
		
		precioFinal = (distancia*consumo)/numAsientosOcupados;
		
		
		return precioFinal;
		
	}
	
}
