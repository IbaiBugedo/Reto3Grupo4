package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Cliente;
import modeloDAO.ClienteDAO;
import vista.Registro;

public class ControladorRegistro implements ActionListener {
	
	private Registro ventanaRegistro;
	
	public ControladorRegistro(Registro VentanaRegistro) {
		
		this.ventanaRegistro = VentanaRegistro;
		
		metInicializarControlador();
		
	}
	


	private void metInicializarControlador() {
		
		this.ventanaRegistro.getBtnRegistro().addActionListener(this);
		this.ventanaRegistro.getBtnRegistro().setActionCommand("Registrarse");
		
		this.ventanaRegistro.getBtnCancelar().addActionListener(this);
		this.ventanaRegistro.getBtnCancelar().setActionCommand("Cancelar");
		
		this.ventanaRegistro.getBtnAtras().addActionListener(this);
		this.ventanaRegistro.getBtnAtras().setActionCommand("Atrás");
		
		
		
		
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
		String sexo,letraSexo;
		sexo=ventanaRegistro.getRespuestaSexo().getSelectedItem().toString();
		if (sexo.equals("Hombre")) {
			letraSexo="V";
		}
		else if(sexo.contentEquals("Mujer")) {
			letraSexo="M";
		}
		else {
			letraSexo="Otro";
		}
		Cliente nuevoCliente = new Cliente();
		
		nuevoCliente.setNombre(ventanaRegistro.getRespuestaNombre().getText());
		nuevoCliente.setApellido(ventanaRegistro.getRespuestaApellido().getText());
		nuevoCliente.setSexo(letraSexo);
		nuevoCliente.setContrasena(ventanaRegistro.getRespuestaContrasena().getText());
		nuevoCliente.setDni(ventanaRegistro.getRespuestaDNI().getText());
		
		
		ClienteDAO nuevoClienteDAO = new ClienteDAO();
		if(modeloDAO.ClienteDAO.mInsetarContacto(nuevoCliente)) {	
		ventanaRegistro.setVisible(false);
		vista.Pago ventanaPago = new vista.Pago();
		ventanaPago.setVisible(true);
		}
		
	}
	

	
}
