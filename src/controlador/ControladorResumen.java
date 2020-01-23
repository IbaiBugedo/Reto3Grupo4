package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import vista.Resumen;

	public class ControladorResumen implements ActionListener, ListSelectionListener {
		private String fecha,linea;
		private Resumen vistaResumen;
		
		public ControladorResumen(Resumen ventanaResumen) {
			this.vistaResumen = ventanaResumen;
			
			this.inicializarControlador();
		}

		private void inicializarControlador() {
			fecha=(ControladorMenuLinea.recogerFecha());
			linea=(ControladorMenuLinea.recogerLinea());
			
			vistaResumen.getLblFecha().setText(fecha);
			vistaResumen.getLblLinea().setText(linea);
			
			
		}
		public void actionPerformed(ActionEvent e) {
	
			
		}

		public void valueChanged(ListSelectionEvent e) {
			
			
		}
	
}