package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vista.Bienvenida;
import vista.MenuLinea;
import vista.Ticket;

	public class ControladorTiquet implements ActionListener, ListSelectionListener {
		
		private Ticket vistaTicket;
		
		public ControladorTiquet(Ticket ventanaTicket) {
			this.vistaTicket = ventanaTicket;
			
			this.inicializarControlador();
		}

		private void inicializarControlador() {
	
			
			
		}
		public void actionPerformed(ActionEvent e) {
	
			
		}

		public void valueChanged(ListSelectionEvent e) {
			
			
		}
	
}
