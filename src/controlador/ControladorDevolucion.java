package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vista.Bienvenida;
import vista.Devolucion;
import vista.MenuLinea;

	public class ControladorDevolucion implements ActionListener, ListSelectionListener {
		
		private Devolucion vistaDevolucion;
		
		public ControladorDevolucion(Devolucion ventanaDevolucion) {
			this.vistaDevolucion = ventanaDevolucion;
			
			this.inicializarControlador();
		}

		public ControladorDevolucion(ControladorDevolucion ventanaDevolucion) {
			// TODO Auto-generated constructor stub
		}

		private void inicializarControlador() {
			
			
			
		}
		public void actionPerformed(ActionEvent e) {
	
			
		}

		public void valueChanged(ListSelectionEvent e) {
			
			
		}
	
}
