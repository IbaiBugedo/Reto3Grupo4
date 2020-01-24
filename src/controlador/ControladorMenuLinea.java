package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vista.Bienvenida;
import vista.MenuLinea;
import vista.MenuOrigenDestino;

public class ControladorMenuLinea implements ActionListener, ListSelectionListener {

	private static MenuLinea vistaMenuLinea;

	public ControladorMenuLinea(MenuLinea ventanaMenuLinea) {
		this.vistaMenuLinea = ventanaMenuLinea;

		this.inicializarControlador();
	}

	private void inicializarControlador() {

		this.vistaMenuLinea.getBtnSiguiente().addActionListener(this);
		this.vistaMenuLinea.getBtnSiguiente().setActionCommand(MenuLinea.enumAcciones.SIGUIENTE_PAGINA.toString());

		vistaMenuLinea.getBoxLinea().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ((vistaMenuLinea.getBoxLinea().getSelectedItem()) != "Selecciona la linea") {
					vistaMenuLinea.getBtnSiguiente().setEnabled(true);
				} else {
					vistaMenuLinea.getBtnSiguiente().setEnabled(false);
				}
			}
		});
	}

	public void valueChanged(ListSelectionEvent e) {

	}

	public void actionPerformed(ActionEvent e) {

		MenuLinea.enumAcciones accion = MenuLinea.enumAcciones.valueOf(e.getActionCommand());

		switch (accion) {
		case SIGUIENTE_PAGINA:
			vistaMenuLinea.setVisible(false);
			vista.MenuOrigenDestino ventanaMenuOrigenDestino = new vista.MenuOrigenDestino();
			ventanaMenuOrigenDestino.setVisible(true);
			ControladorMenuOrigenDestino controladorMenuOrigenDestino = new ControladorMenuOrigenDestino(
					ventanaMenuOrigenDestino);
			break;

		}

	}

	public static String recogerLinea() {
		String Linea;
		Linea = vistaMenuLinea.getBoxLinea().getSelectedItem().toString();
		return Linea;
	}

	public static String recogerFecha() {
		String fecha;
		int dia, mes, año;

		dia = vistaMenuLinea.getCalendar().getDayChooser().getDay();
		mes = ((vistaMenuLinea.getCalendar().getMonthChooser().getMonth())+1);
		año = vistaMenuLinea.getCalendar().getYearChooser().getYear();
		fecha = (dia + "/" + mes + "/" + año);

		return fecha;
	}
}