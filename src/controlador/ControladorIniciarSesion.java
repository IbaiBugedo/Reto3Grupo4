package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Autobus;
import modelo.Linea;
import modelo.Parada;
import otrosMetodos.ValidarDNI;
import vista.Bienvenida;
import vista.IniciarSesion;
import vista.MenuLinea;

public class ControladorIniciarSesion implements ActionListener, ListSelectionListener {

	private IniciarSesion vistaIniciarSesion;
	public static String DNI;
	ArrayList<Linea> listaLinea;
	ArrayList<Parada> listaParada;
	ArrayList<Autobus> listaAutobus;
	
	
	public ControladorIniciarSesion(IniciarSesion ventanaIniciarSesion, ArrayList<Linea> listaLinea, ArrayList<Parada> listaParada, ArrayList<Autobus> listaAutobus) {
		this.vistaIniciarSesion = ventanaIniciarSesion;
		
		this.listaLinea=listaLinea;
		this.listaParada=listaParada;
		this.listaAutobus=listaAutobus;
		
		this.inicializarControlador();
	}
	
	private void inicializarControlador() {
		this.vistaIniciarSesion.getBtnIniciarSesion().addActionListener(this);
		this.vistaIniciarSesion.getBtnIniciarSesion()
				.setActionCommand(IniciarSesion.enumAcciones.SIGUIENTE_PAGINA.toString());
		this.vistaIniciarSesion.getBtnRegistrarse().addActionListener(this);
		this.vistaIniciarSesion.getBtnRegistrarse()
				.setActionCommand(IniciarSesion.enumAcciones.PAGINA_REGISTRO.toString());
		this.vistaIniciarSesion.getBtnCancelar().addActionListener(this);
		this.vistaIniciarSesion.getBtnCancelar().setActionCommand(IniciarSesion.enumAcciones.CANCELAR.toString());
		this.vistaIniciarSesion.getBtnRetroceso().addActionListener(this);
		this.vistaIniciarSesion.getBtnRetroceso().setActionCommand(IniciarSesion.enumAcciones.RETROCESO.toString());
		;

	}

	public void actionPerformed(ActionEvent e) {

		IniciarSesion.enumAcciones accion = IniciarSesion.enumAcciones.valueOf(e.getActionCommand());

		switch (accion) {
		case SIGUIENTE_PAGINA:
			
			String respuestaDNI, respuestaContrasena, vacio;
			respuestaDNI = vistaIniciarSesion.getRespuestaDNI().getText();	
			
			respuestaContrasena = vistaIniciarSesion.getRespuestaContrasena().getText();
			vacio = "";

			
				if ((modeloDAO.ClienteDAO.mIniciarSesion(respuestaDNI, respuestaContrasena))) {
					DNI=vistaIniciarSesion.getRespuestaDNI().getText().toString();
					vistaIniciarSesion.setVisible(false);
					vista.Pago ventanaPago = new vista.Pago();
					ventanaPago.setVisible(true);
					ControladorPago controladorPago = new ControladorPago(ventanaPago,listaLinea,listaParada,listaAutobus);
				}else {
					vista.Alerta ventanaAlerta = new vista.Alerta(6);
					ventanaAlerta.setVisible(true);
					ControladorAlerta controladorAlerta = new ControladorAlerta(ventanaAlerta);
			}
			break;
		case PAGINA_REGISTRO:
			vistaIniciarSesion.setVisible(false);
			vista.Registro ventanaRegistro = new vista.Registro();
			ventanaRegistro.setVisible(true);
			ControladorRegistro controladorRegistro = new ControladorRegistro(ventanaRegistro,listaLinea,listaParada,listaAutobus);
			break;
		case CANCELAR:
			vistaIniciarSesion.setVisible(false);
			vista.Bienvenida ventanaBienvenida = new vista.Bienvenida();
			ventanaBienvenida.setVisible(true);
			ControladorBienvenida controladorBienvenida = new ControladorBienvenida(ventanaBienvenida);
			break;
		case RETROCESO:
			vistaIniciarSesion.setVisible(false);
			vista.Resumen ventanaResumen = new vista.Resumen();
			ventanaResumen.setVisible(true);
			ControladorResumen controladorResumen = new ControladorResumen(ventanaResumen,listaLinea,listaParada,listaAutobus);
			break;
		}
	}

	public void valueChanged(ListSelectionEvent e) {

	}

}