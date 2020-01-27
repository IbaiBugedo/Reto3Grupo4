package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Cliente;
import modelo.ClienteDAO;

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
		this.ventanaRegistro.getAtras().setActionCommand("Atrás");
		
		
		
		
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
			
			case "Atrás":
				metAtras();
			break;
		}
		
		
		
	}

	private void metAtras() {
		// Devuelve a la ventana anterior
		
	}



	private void metCancelar() {
		// Cancela toda la compra y devuelve a la ventana de Bienvenida
		
	}



	private void metRegistrarse() {	
		
		Cliente nuevoCliente = new Cliente();
		
		nuevoCliente.setNombre(ventanaRegistro.getRespuestaNombre().getText());
		nuevoCliente.setApellido(ventanaRegistro.getRespuestaApellido().getText());
		nuevoCliente.setSexo(ventanaRegistro.getRespuestaSexo().getSelectedItem().toString());
		nuevoCliente.setContrasena(ventanaRegistro.getRespuestaContrasena().getText());
		nuevoCliente.setDni(ventanaRegistro.getRespuestaDNI().getText());
		
		
		ClienteDAO nuevoClienteDAO = new ClienteDAO();
		nuevoClienteDAO.mInsetarContacto(nuevoCliente);
		
		
		
		ventanaRegistro.setVisible(false);
		vista.Pago2 ventanaPago = new vista.Pago2();
		ventanaPago.setVisible(true);
		
		
		
	}
	

	
}
