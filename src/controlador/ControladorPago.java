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
		
		private static Pago ventanaPago;
		
		
		
		
		public ControladorPago(Pago pVentanaPago) {
			this.ventanaPago = pVentanaPago;
			
			this.inicializarControlador();
		}

		private void inicializarControlador() {
			
			this.ventanaPago.getIntroducir().addActionListener(this);
			this.ventanaPago.getIntroducir().setActionCommand("Introducir");
			
			this.ventanaPago.getCancelar().addActionListener(this);
			this.ventanaPago.getCancelar().setActionCommand("Cancelar");
					
		}
		
		public void actionPerformed(ActionEvent e) {
			
			switch (e.getActionCommand()) {
			case "Introducir":
				metIntroducir();
			break;
			
			case "Cancelar":
				metCancelar();		
			break;
		}
					
	}

	public void valueChanged(ListSelectionEvent e) {
			
			
	}
	
	private int metIntroducir() {
			
		int importe;
		
		
			ventanaPago.getBoxImporte();
		
		return 0;
					
	}
		
	private void metCancelar() {
		
	/*	Linea=0;
		mes=0;
		dia=0;
		origen=0;
		horaInt=0;
		destino=0;
		vistaResumen.setVisible(false);
		vista.Bienvenida ventanaBienvenida = new vista.Bienvenida();
		ventanaBienvenida.setVisible(true);
		
		ControladorBienvenida controladorBienvenida= new ControladorBienvenida(ventanaBienvenida);
		*/
	}
		
}
