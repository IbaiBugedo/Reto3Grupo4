package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import vista.MenuLinea;
import vista.Pago;


	public class ControladorPago implements ActionListener, ListSelectionListener {
		
		private Pago vistaPago;
		
		public ControladorPago(Pago ventanaPago) {
			this.vistaPago = ventanaPago;
			
			this.inicializarControlador();
		}

		private void inicializarControlador() {
			
			
		}
		public void actionPerformed(ActionEvent e) {
	
			
		}

		public void valueChanged(ListSelectionEvent e) {
			
			
		}
	
}
