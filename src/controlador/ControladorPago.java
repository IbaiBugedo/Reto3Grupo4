package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.MathContext;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vista.MenuLinea;
import vista.Pago;



	public class ControladorPago implements ActionListener, ListSelectionListener {
		

		private Pago vistaPago;
		public static double importe,precio,importeRestante,sumaImporte=0;
		
		public ControladorPago(Pago ventanaPago) {
			this.vistaPago = ventanaPago;
			
			this.inicializarControlador();
		}

		private void inicializarControlador() {
			
			// recoge de la ventana Resumen el precio para operar con el.
			
			precio = (ControladorResumen.recogerPrecio()); 
			importeRestante=precio;
			vistaPago.getLblAPagar().setText(precio+"\u20AC");
			MathContext formatoDecimal = new MathContext(5);
			BigDecimal decimal = new BigDecimal(precio,formatoDecimal);
			precio=decimal.doubleValue();
			vistaPago.getLblImporteRestante().setText(precio+"\u20AC");
			
			this.vistaPago.getIntroducir().addActionListener(this);
			this.vistaPago.getIntroducir().setActionCommand("Introducir");
			
			this.vistaPago.getCancelar().addActionListener(this);
			this.vistaPago.getCancelar().setActionCommand("Cancelar");
					
		}
		
		public void actionPerformed(ActionEvent e) {
			
			switch (e.getActionCommand()) {
			case "Introducir":
				if(metIntroducir()) {
					
					vistaPago.setVisible(false);
					vista.Devolucion ventanaDevolucion = new vista.Devolucion();
					ventanaDevolucion.setVisible(true);
					ControladorDevolucion controladorDevolucion= new ControladorDevolucion(ventanaDevolucion);
				}
			break;
			
			case "Cancelar":
				metCancelar();		
			break;
		}
					
	}

	public void valueChanged(ListSelectionEvent e) {
			
			
	}
	
	
	
	private boolean metIntroducir() {
			boolean pasarPagina=false;
		
		importe = Double.parseDouble(vistaPago.getBoxImporte().getSelectedItem().toString());
		
		if (importe>=importeRestante) {
			pasarPagina=true;
		}
		else {
			importeRestante = importeRestante-importe;
			sumaImporte = sumaImporte + importe;
			MathContext formatoDecimal = new MathContext(5);
			BigDecimal decimal = new BigDecimal(sumaImporte,formatoDecimal);
			sumaImporte=decimal.doubleValue();
			BigDecimal decimal2 = new BigDecimal(importeRestante,formatoDecimal);
			importeRestante=decimal2.doubleValue();
			vistaPago.getLblImporteIntroducido().setText(sumaImporte+"\u20AC");
			vistaPago.getLblImporteRestante().setText(importeRestante+"\u20AC");
		}
					
		return pasarPagina;
	}
	
	
	
	
	private void metCancelar() {
		
		vistaPago.setVisible(false);
		vista.Bienvenida ventanaBienvenida = new vista.Bienvenida();
		ventanaBienvenida.setVisible(true);
		ControladorBienvenida controladorBienvenida= new ControladorBienvenida(ventanaBienvenida);
	}
	
	public static double mConservarDineroIntroducido(){
		
		return importe;
		
	}

	public static double mConservarDineroRestante(){
		
		return importeRestante;
		
	}
}		