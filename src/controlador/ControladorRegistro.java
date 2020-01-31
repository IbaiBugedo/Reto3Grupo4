package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Cliente;
import modeloDAO.ClienteDAO;
import vista.Registro;

public class ControladorRegistro implements ActionListener {
	
	private Registro ventanaRegistro;
	
	public ControladorRegistro(Registro pVentanaRegistro) {
		
		this.ventanaRegistro = pVentanaRegistro;
		
		metInicializarControlador();
		
	}
	


	private void metInicializarControlador() {
		
		this.ventanaRegistro.getBtnRegistro().addActionListener(this);
		this.ventanaRegistro.getBtnRegistro().setActionCommand("Registrarse");
		
		this.ventanaRegistro.getBtnRegistro().addActionListener(this);
		this.ventanaRegistro.getBtnRegistro().setActionCommand("Cancelar");
		
		this.ventanaRegistro.getBtnRegistro().addActionListener(this);
		this.ventanaRegistro.getBtnRegistro().setActionCommand("Atrás");
		
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
		
		ventanaRegistro.setVisible(false);
		vista.Pago ventanaPago = new vista.Pago();
		ventanaPago.setVisible(true);
		ControladorPago controladorPago= new ControladorPago(ventanaPago);
		
	}



	private void metCancelar() {
		// Cancela toda la compra y devuelve a la ventana de Bienvenida
		
	}



	private void metRegistrarse() {	
		// Los campos completados los registra en la base de datos.
		
		Cliente nuevoCliente = new Cliente();
		
		nuevoCliente.setNombre(ventanaRegistro.getRespuestaNombre().getText());
		nuevoCliente.setApellido(ventanaRegistro.getRespuestaApellido().getText());
		nuevoCliente.setSexo(ventanaRegistro.getRespuestaSexo().getSelectedItem().toString());
		nuevoCliente.setContrasena(ventanaRegistro.getRespuestaContrasena().getText());
		nuevoCliente.setDni(ventanaRegistro.getRespuestaDNI().getText());
		
		
		ClienteDAO nuevoClienteDAO = new ClienteDAO();
		nuevoClienteDAO.mInsetarContacto(nuevoCliente);
		
		
		if(modeloDAO.ClienteDAO.mInsetarContacto(nuevoCliente)) {	
		ventanaRegistro.setVisible(false);
		vista.Pago ventanaPago = new vista.Pago();
		ventanaPago.setVisible(true);
	
		
		}
	}
	

	
}
