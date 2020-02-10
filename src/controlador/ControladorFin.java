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
import vista.Fin;
import vista.MenuLinea;

public class ControladorFin implements ActionListener, ListSelectionListener {

	private Fin vistaFin;

	public ControladorFin(Fin ventanaFin) {
		this.vistaFin = ventanaFin;

		this.inicializarControlador();
	}

	private void inicializarControlador() {

		vistaFin.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try {
					// TODO add your handling code here:
					Thread.sleep(2750);
					vistaFin.setVisible(false);
					vista.Bienvenida ventanaBienvenida = new vista.Bienvenida();
					ventanaBienvenida.setVisible(true);
					ControladorBienvenida controladorBienvenida = new ControladorBienvenida(ventanaBienvenida);
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
