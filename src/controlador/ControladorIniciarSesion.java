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

			
			
		}
		public void actionPerformed(ActionEvent e) {
	
			
		}

		public void valueChanged(ListSelectionEvent e) {
			
			
		}
	
}