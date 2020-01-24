package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vista.MenuLinea;
import vista.MenuOrigenDestino;

	public class ControladorMenuOrigenDestino implements ActionListener, ListSelectionListener {
		
		private MenuOrigenDestino vistaBienvenida;
		private MenuOrigenDestino vistaMenuOrigenDestino;
		
		public ControladorMenuOrigenDestino(MenuOrigenDestino ventanaMenuOrigenDestino) {
			this.vistaMenuOrigenDestino = ventanaMenuOrigenDestino;
			
			this.inicializarControlador();
		}

		private void inicializarControlador() {
			
			this.vistaMenuOrigenDestino.getBtnSiguiente().addActionListener(this);
			this.vistaMenuOrigenDestino.getBtnSiguiente().setActionCommand(MenuLinea.enumAcciones.SIGUIENTE_PAGINA.toString());
			this.vistaMenuOrigenDestino.getBtnIda().addActionListener(this);
			this.vistaMenuOrigenDestino.getBtnIda().setActionCommand(MenuLinea.enumAcciones.VIAJE_IDA.toString());
			this.vistaMenuOrigenDestino.getBtnIdaVuelta().addActionListener(this);
			this.vistaMenuOrigenDestino.getBtnIdaVuelta().setActionCommand(MenuLinea.enumAcciones.VIAJE_IDA_VUELTA.toString());
			

			vistaMenuOrigenDestino.getBoxOrigen().addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if ((vistaMenuOrigenDestino.getBoxOrigen().getSelectedItem()) != "Selecione Origen" && 
							vistaMenuOrigenDestino.getBoxDestino().getSelectedItem() != "Selecione Destino" && 
							vistaMenuOrigenDestino.getBoxHora().getSelectedItem() != "Seleccione Hora"&&(
									vistaMenuOrigenDestino.getBtnIda().isSelected()==true||
									vistaMenuOrigenDestino.getBtnIdaVuelta().isSelected()==true
									)) {
						
						
						vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(true);
					} else {
						vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(false);
					}
				}
			});
			
			vistaMenuOrigenDestino.getBoxDestino().addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if ((vistaMenuOrigenDestino.getBoxOrigen().getSelectedItem()) != "Selecione Origen" && 
							vistaMenuOrigenDestino.getBoxDestino().getSelectedItem() != "Selecione Destino" && 
							vistaMenuOrigenDestino.getBoxHora().getSelectedItem() != "Seleccione Hora"&&(
									vistaMenuOrigenDestino.getBtnIda().isSelected()==true||
									vistaMenuOrigenDestino.getBtnIdaVuelta().isSelected()==true
									)) {
						
						
						vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(true);
					} else {
						vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(false);
					}
				}
			});
			
			vistaMenuOrigenDestino.getBoxHora().addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if ((vistaMenuOrigenDestino.getBoxOrigen().getSelectedItem()) != "Selecione Origen" && 
							vistaMenuOrigenDestino.getBoxDestino().getSelectedItem() != "Selecione Destino" && 
							vistaMenuOrigenDestino.getBoxHora().getSelectedItem() != "Seleccione Hora"&&(
									vistaMenuOrigenDestino.getBtnIda().isEnabled()==false||
									vistaMenuOrigenDestino.getBtnIdaVuelta().isEnabled()==false
									)) {
						
						
						vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(true);
					} else {
						vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(false);
					}
				}
			});
			
		}
	
			
			
		
		public void actionPerformed(ActionEvent e) {
	
			MenuLinea.enumAcciones accion = MenuLinea.enumAcciones.valueOf(e.getActionCommand());

			switch (accion) {
			case SIGUIENTE_PAGINA:
				vistaMenuOrigenDestino.setVisible(false);
				vista.Resumen ventanaResumen = new vista.Resumen();
				ventanaResumen.setVisible(true);
				ControladorResumen controladorResumen= new ControladorResumen(ventanaResumen);
				break;
			case VIAJE_IDA:
				vistaMenuOrigenDestino.getBtnIda().setEnabled(false);
				vistaMenuOrigenDestino.getBtnIdaVuelta().setEnabled(true);
				if ((vistaMenuOrigenDestino.getBoxOrigen().getSelectedItem()) != "Selecione Origen" && 
						vistaMenuOrigenDestino.getBoxDestino().getSelectedItem() != "Selecione Destino" && 
						vistaMenuOrigenDestino.getBoxHora().getSelectedItem() != "Seleccione Hora"&&(
								vistaMenuOrigenDestino.getBtnIda().isEnabled()==false||
								vistaMenuOrigenDestino.getBtnIdaVuelta().isEnabled()==false
								)) {
					
					
					vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(true);
				} else {
					vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(false);
				}
				break;
			case VIAJE_IDA_VUELTA:
				vistaMenuOrigenDestino.getBtnIda().setEnabled(true);
				vistaMenuOrigenDestino.getBtnIdaVuelta().setEnabled(false);
				if ((vistaMenuOrigenDestino.getBoxOrigen().getSelectedItem()) != "Selecione Origen" && 
						vistaMenuOrigenDestino.getBoxDestino().getSelectedItem() != "Selecione Destino" && 
						vistaMenuOrigenDestino.getBoxHora().getSelectedItem() != "Seleccione Hora"&&(
								vistaMenuOrigenDestino.getBtnIda().isEnabled()==false||
								vistaMenuOrigenDestino.getBtnIdaVuelta().isEnabled()==false
								)) {
					
					
					vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(true);
				} else {
					vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(false);
				}
				break;
			
			}
		}
			
		

		public void valueChanged(ListSelectionEvent e) {
			
			
		}
	
		
		
		
		
		
		
		
}
