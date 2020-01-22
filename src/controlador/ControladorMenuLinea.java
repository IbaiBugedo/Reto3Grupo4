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

		public class ControladorMenuLinea implements ActionListener, ListSelectionListener {
			
			private vista.MenuLinea vistaMenuLinea;
			
			public ControladorMenuLinea(MenuLinea ventanaMenuLinea) {
				this.vistaMenuLinea = vistaMenuLinea;
				
				this.inicializarControlador();
			}

			private void inicializarControlador() {
				
			
			}

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}

			

}


