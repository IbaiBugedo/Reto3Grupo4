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

public class ControladorBienvenida implements ActionListener, ListSelectionListener {

	private Bienvenida vistaBienvenida;

	public ControladorBienvenida(Bienvenida ventanaBienvenida) {
		this.vistaBienvenida = ventanaBienvenida;

		this.inicializarControlador();
	}

	private void inicializarControlador() {
		ControladorIdaVuelta.fechaVuelta="";
		ControladorIdaVuelta.horaVuelta="";
		
		vistaBienvenida.getPanelBienvenida().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vistaBienvenida.setVisible(false);
				vista.MenuLinea ventanaMenuLinea = new vista.MenuLinea();
				ventanaMenuLinea.setVisible(true);
				ControladorMenuLinea controladorMenuLinea = new ControladorMenuLinea(ventanaMenuLinea);
			}
		});

	}

	public void actionPerformed(ActionEvent e) {

	}

	public void valueChanged(ListSelectionEvent e) {

	}

}
