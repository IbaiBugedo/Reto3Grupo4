package controlador;


	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;

	import javax.swing.JPanel;
	import javax.swing.event.ListSelectionEvent;
	import javax.swing.event.ListSelectionListener;

	import vista.Bienvenida;
	import vista.MenuLinea;



		public class ControladorMenuLinea implements ActionListener, ListSelectionListener {
			
			private MenuLinea vistaMenuLinea;
			
			public ControladorMenuLinea(MenuLinea ventanaMenuLinea) {
				this.vistaMenuLinea = ventanaMenuLinea;
				
				this.inicializarControlador();
			}

			private void inicializarControlador() {
				
				/*this.vistaMenuLinea.getBtnSiguiente().addActionListener(this);
				this.vistaMenuLinea.getBtnSiguiente()
						.setActionCommand(MenuLinea.enumAcciones.SIGUIENTE_PAGINA.toString());*/
				
				vistaMenuLinea.getBoxLinea().addComponentListener(new ComponentAdapter() {
					public void itemStateChanged(ItemEvent arg0) {
								if(vistaMenuLinea.getBoxLinea().getSelectedItem()!="Selecciona la linea" && vistaMenuLinea.getCalendar().getDayChooser()!=null) {
									vistaMenuLinea.getBtnSiguiente().setEnabled(true);
								}
							}
						});
					}
		

			
			

			public void valueChanged(ListSelectionEvent e) {
			
			}

			public void actionPerformed(ActionEvent e) {
			
				
				
				
			}

			

}


