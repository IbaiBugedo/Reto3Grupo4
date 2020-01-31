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
		
		private float precio;
		private static Pago ventanaPago;
		
		
		public ControladorPago(Pago pVentanaPago) {
			this.ventanaPago = pVentanaPago;
			
			this.inicializarControlador();
		}

		private void inicializarControlador() {
			
			// recoge de la ventana Resumen el precio para operar con el.
			
			//* precio = (ControladorMenuResumen.recogerPrecio()); */
					
			
			this.ventanaPago.getIntroducir().addActionListener(this);
			this.ventanaPago.getIntroducir().setActionCommand("Introducir");
			
			this.ventanaPago.getCancelar().addActionListener(this);
			this.ventanaPago.getCancelar().setActionCommand("Cancelar");
					
		}
		
		public void actionPerformed(ActionEvent e) {
			
			switch (e.getActionCommand()) {
			case "Introducir":
				//metIntroducir();
			break;
			
			case "Cancelar":
				metCancelar();		
			break;
		}
					
	}

	public void valueChanged(ListSelectionEvent e) {
			
			
	}
	
	/*
	
	private boolean metIntroducir() {
			

		float importe;
		float aPagar;
		float importeRestante;
		float sumaImporte;
		
		importe = (float) ventanaPago.getBoxImporte().getSelectedItem();
					
	}
	
	*/
	
	
	private void metCancelar() {
		
	
	}
		
}		