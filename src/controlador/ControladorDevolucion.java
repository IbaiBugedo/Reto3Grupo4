package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

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
			
			
			
			vistaDevolucion.addWindowListener(new WindowAdapter() {
				@Override
				public void windowOpened(WindowEvent arg0) {
					 try {
				            // TODO add your handling code here:
				            Thread.sleep(5000);
				            vistaDevolucion.setVisible(false);
							vista.Ticket ventanaTicket = new vista.Ticket();
							ventanaTicket.setVisible(true);
							ControladorTiquet controladorTicket = new ControladorTiquet(ventanaTicket);
				        } catch (InterruptedException ex) {
				            Logger.getLogger(Devolucion.class.getName()).log(Level.SEVERE, null, ex);
				        }
				}
				
			});
		}
		
		
		
		public void actionPerformed(ActionEvent e) {
	
			
		}

		public void valueChanged(ListSelectionEvent e) {
			
			
		}
	
}
