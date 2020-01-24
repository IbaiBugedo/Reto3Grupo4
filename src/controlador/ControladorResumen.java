package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vista.IniciarSesion;
import vista.MenuLinea;
import vista.Resumen;

	public class ControladorResumen implements ActionListener, ListSelectionListener {
		private String fecha,linea,origenDestino,horaStr,tipoBillete;
		private Resumen vistaResumen;
		public static int Linea=0,mes,dia,origen,horaInt,destino;
		
		public ControladorResumen(Resumen ventanaResumen) {
			this.vistaResumen = ventanaResumen;
			
			this.inicializarControlador();
		}

		private void inicializarControlador() {
			fecha=(ControladorMenuLinea.recogerFecha());
			linea=(ControladorMenuLinea.recogerLinea());
			origenDestino=(ControladorMenuOrigenDestino.recogerOrigenDestino());
			horaStr=(ControladorMenuOrigenDestino.recogerHora());
			tipoBillete=(ControladorMenuOrigenDestino.recogerTipoBillete());
			
			
			vistaResumen.getLblFecha().setText(fecha);
			vistaResumen.getLblLinea().setText(linea);
			vistaResumen.getLblOrigenDestino().setText(origenDestino);
			vistaResumen.getLblHora().setText(horaStr);
			vistaResumen.getLblTipoViaje().setText(tipoBillete);
			
			this.vistaResumen.getBtnAceptar().addActionListener(this);
			this.vistaResumen.getBtnAceptar().setActionCommand(Resumen.enumAcciones.SIGUIENTE_PAGINA.toString());
			this.vistaResumen.getBtnCancelar().addActionListener(this);
			this.vistaResumen.getBtnCancelar().setActionCommand(Resumen.enumAcciones.CANCELAR_COMPRA.toString());
			this.vistaResumen.getBtnModificar().addActionListener(this);
			this.vistaResumen.getBtnModificar().setActionCommand(Resumen.enumAcciones.MODIFICAR_COMPRA.toString());
			this.vistaResumen.getBtnRetroceso().addActionListener(this);
			this.vistaResumen.getBtnRetroceso().setActionCommand(Resumen.enumAcciones.PAGINA_ANTERIOR.toString());
			
		}
		public void actionPerformed(ActionEvent e) {
	
			Resumen.enumAcciones accion = Resumen.enumAcciones.valueOf(e.getActionCommand());

			switch (accion) {
			case SIGUIENTE_PAGINA:
				vistaResumen.setVisible(false);
				vista.IniciarSesion ventanaIniciarSesion = new vista.IniciarSesion();
				ventanaIniciarSesion.setVisible(true);
				ControladorIniciarSesion controladorIniciarSesion = new ControladorIniciarSesion(ventanaIniciarSesion);
				break;
			case CANCELAR_COMPRA:
				vistaResumen.setVisible(false);
				vista.Bienvenida ventanaBienvenida = new vista.Bienvenida();
				ventanaBienvenida.setVisible(true);
				ControladorBienvenida controladorBienvenida= new ControladorBienvenida(ventanaBienvenida);
				break;
			case PAGINA_ANTERIOR:
				vistaResumen.setVisible(false);
				vista.MenuOrigenDestino ventanaMenuOrigenDestino = new vista.MenuOrigenDestino();
				ventanaMenuOrigenDestino.setVisible(true);
				ControladorMenuOrigenDestino controladorMenuOrigenDestino= new ControladorMenuOrigenDestino(ventanaMenuOrigenDestino);
				break;
			case MODIFICAR_COMPRA:
				Linea=(ControladorMenuLinea.conservarLinea());
				dia=(ControladorMenuLinea.conservarDia());
				mes=(ControladorMenuLinea.conservarMes());
				origen=(ControladorMenuOrigenDestino.conservarOrigen());
				destino=(ControladorMenuOrigenDestino.conservarDestino());
				horaInt=(ControladorMenuOrigenDestino.conservarHora());
				vistaResumen.setVisible(false);
				vista.MenuLinea ventanaMenuLinea = new vista.MenuLinea();
				ventanaMenuLinea.setVisible(true);
				ControladorMenuLinea controladorMenuLinea= new ControladorMenuLinea(ventanaMenuLinea);
				break;
			}
			
		}

		public void valueChanged(ListSelectionEvent e) {
			
			
		}
	
}

