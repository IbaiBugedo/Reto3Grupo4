package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vista.Bienvenida;
import vista.IniciarSesion;
import vista.MenuLinea;

	public class ControladorIniciarSesion implements ActionListener, ListSelectionListener {
		
		private IniciarSesion vistaIniciarSesion;
		
		public ControladorIniciarSesion(IniciarSesion ventanaIniciarSesion) {
			this.vistaIniciarSesion = ventanaIniciarSesion;
			
			this.inicializarControlador();
		}

		private void inicializarControlador() {
			this.vistaIniciarSesion.getBtnIniciarSesion().addActionListener(this);
			this.vistaIniciarSesion.getBtnIniciarSesion().setActionCommand(IniciarSesion.enumAcciones.SIGUIENTE_PAGINA.toString());
			this.vistaIniciarSesion.getBtnRegistrarse().addActionListener(this);
			this.vistaIniciarSesion.getBtnRegistrarse().setActionCommand(IniciarSesion.enumAcciones.PAGINA_REGISTRO.toString());
			this.vistaIniciarSesion.getBtnCancelar().addActionListener(this);
			this.vistaIniciarSesion.getBtnCancelar().setActionCommand(IniciarSesion.enumAcciones.CANCELAR.toString());
			this.vistaIniciarSesion.getBtnRetroceso().addActionListener(this);
			this.vistaIniciarSesion.getBtnRetroceso().setActionCommand(IniciarSesion.enumAcciones.RETROCESO.toString());;			
		}
		
		public void actionPerformed(ActionEvent e) {

			IniciarSesion.enumAcciones accion = IniciarSesion.enumAcciones.valueOf(e.getActionCommand());

			switch (accion) {
			case SIGUIENTE_PAGINA:
				if ((modeloDAO.ClienteDAO.mIniciarSesion(vistaIniciarSesion.getRespuestaDNI().toString(), vistaIniciarSesion.getRespuestaContrasena().toString()))==false) {
				vistaIniciarSesion.setVisible(false);
				vista.Pago ventanaPago = new vista.Pago();
				ventanaPago.setVisible(true);
				ControladorPago controladorPago= new ControladorPago(ventanaPago);
				break;}
			case PAGINA_REGISTRO:
				vistaIniciarSesion.setVisible(false);
				vista.Registro ventanaRegistro = new vista.Registro();
				ventanaRegistro.setVisible(true);
				ControladorRegistro controladorRegistro= new ControladorRegistro(ventanaRegistro);
				break;
			case CANCELAR:
				vistaIniciarSesion.setVisible(false);
				vista.Bienvenida ventanaBienvenida = new vista.Bienvenida();
				ventanaBienvenida.setVisible(true);
				ControladorBienvenida controladorBienvenida= new ControladorBienvenida(ventanaBienvenida);
				break;
			case RETROCESO:
				vistaIniciarSesion.setVisible(false);
				vista.Resumen ventanaResumen = new vista.Resumen();
				ventanaResumen.setVisible(true);
				ControladorResumen controladorResumen= new ControladorResumen(ventanaResumen);
				break;
			}
		}

		public void valueChanged(ListSelectionEvent e) {
			
			
		}
	
}