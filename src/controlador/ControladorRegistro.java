package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Registro;

public class ControladorRegistro implements ActionListener {
	
	private Registro ventanaRegistro;
	
	public ControladorRegistro(Registro pVentanaRegistro) {
		
		this.ventanaRegistro = pVentanaRegistro;
		
		metInicializarControlador();
		
	}
	


	private void metInicializarControlador() {
		
		this.ventanaRegistro.getRegistrarse().addActionListener(this);
		this.ventanaRegistro.getRegistrarse().setActionCommand("Registrarse");
		
		this.ventanaRegistro.getCancelar().addActionListener(this);
		this.ventanaRegistro.getCancelar().setActionCommand("Cancelar");
		
		this.ventanaRegistro.getAtras().addActionListener(this);
		this.ventanaRegistro.getAtras().setActionCommand("Atr�s");
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
			case "Registrarse":
				metRegistrarse();
			break;
			
			case "Cancelar":
				metCancelar();
				
			break;
			
			case "Atr�s":
				metAtras();
			break;
		}
		
		
		
	}

	private void metAtras() {
		// TODO Auto-generated method stub
		
	}



	private void metCancelar() {
		// TODO Auto-generated method stub
		
	}



	private void metRegistrarse() {
		
	}
	
}
