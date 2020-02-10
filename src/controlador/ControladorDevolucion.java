package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vista.Bienvenida;
import vista.Devolucion;
import vista.MenuLinea;

public class ControladorDevolucion implements ActionListener, ListSelectionListener {

	private Devolucion vistaDevolucion;

	public ControladorDevolucion(Devolucion ventanaDevolucion) {
		this.vistaDevolucion = ventanaDevolucion;

		this.inicializarControlador();
	}

	public ControladorDevolucion(ControladorDevolucion ventanaDevolucion) {
		// TODO Auto-generated constructor stub
	}

	private void inicializarControlador() {

		DecimalFormat formato1 = new DecimalFormat("#.00");
		double vueltas = 0, importe, importeRestante;
		importeRestante = controlador.ControladorPago.mConservarDineroRestante();
		importe = controlador.ControladorPago.mConservarDineroIntroducido();
		vueltas = importe - importeRestante;

		if (vueltas == 0) {
			vistaDevolucion.setVisible(false);
			vista.Ticket ventanaTicket = new vista.Ticket();
			ventanaTicket.setVisible(true);
			ControladorTicket controladorTicket = new ControladorTicket(ventanaTicket);
		}
		vueltas = vueltas * 100;

		if (vueltas / 20000 >= 1) {
			int doscientosEuros = (int) (vueltas / 20000);
			vistaDevolucion.getPanelCambios().setText(vistaDevolucion.getPanelCambios().getText().toString()
					+ doscientosEuros + " x Billetes de 200\u20ac " + "\n");
			vueltas = vueltas - 20000 * doscientosEuros;
		}
		if (vueltas / 10000 >= 1) {
			int cienEuros = (int) (vueltas / 10000);
			vistaDevolucion.getPanelCambios().setText(
					vistaDevolucion.getPanelCambios().getText().toString() + cienEuros + " x Billetes de 100\u20ac \n");
			vueltas = vueltas - 10000 * cienEuros;
		}
		if (vueltas / 5000 >= 1) {
			int cincuentaEuros = (int) (vueltas / 5000);
			vistaDevolucion.getPanelCambios().setText(vistaDevolucion.getPanelCambios().getText().toString()
					+ cincuentaEuros + " x Billetes de 50\u20ac \n");
			vueltas = vueltas - 5000 * cincuentaEuros;
		}
		if (vueltas / 2000 >= 1) {
			int veinteEuros = (int) (vueltas / 2000);
			vistaDevolucion.getPanelCambios().setText(vistaDevolucion.getPanelCambios().getText().toString()
					+ veinteEuros + " x Billetes de 20\u20ac \n");
			vueltas = vueltas - 2000 * veinteEuros;
		}
		if (vueltas / 1000 >= 1) {
			int diezEuros = (int) (vueltas / 1000);
			vistaDevolucion.getPanelCambios().setText(
					vistaDevolucion.getPanelCambios().getText().toString() + diezEuros + " x Billetes de 10\u20ac \n");
			vueltas = vueltas - 1000 * diezEuros;
		}
		if (vueltas / 500 >= 1) {
			int cincoEuros = (int) (vueltas / 500);
			vistaDevolucion.getPanelCambios().setText(
					vistaDevolucion.getPanelCambios().getText().toString() + cincoEuros + " x Billetes de 5\u20ac \n ");
			vueltas = vueltas - 500 * cincoEuros;
		}
		if (vueltas / 200 >= 1) {
			int dosEuros = (int) (vueltas / 200);
			vistaDevolucion.getPanelCambios().setText(
					vistaDevolucion.getPanelCambios().getText().toString() + dosEuros + " x Monedas de 2\u20ac \n");
			vueltas = vueltas - 200 * dosEuros;
		}
		if (vueltas / 100 >= 1) {
			int unEuro = (int) (vueltas / 100);
			vistaDevolucion.getPanelCambios().setText(
					vistaDevolucion.getPanelCambios().getText().toString() + unEuro + " x Monedas de 1\u20ac \n");
			vueltas = vueltas - 100 * unEuro;
		}
		if (vueltas / 50 >= 1) {
			int cincuentaCents = (int) (vueltas / 50);
			vistaDevolucion.getPanelCambios().setText(vistaDevolucion.getPanelCambios().getText().toString()
					+ cincuentaCents + " x Monedas de 50cents \n");
			vueltas = vueltas - 50 * cincuentaCents;
		}
		if (vueltas / 20 >= 1) {
			int veinteCents = (int) (vueltas / 20);
			vistaDevolucion.getPanelCambios().setText(
					vistaDevolucion.getPanelCambios().getText().toString() + veinteCents + " x Monedas de 20cents \n");
			vueltas = vueltas - 20 * veinteCents;
		}
		if (vueltas / 10 >= 1) {
			int diezCents = (int) (vueltas / 10);
			vistaDevolucion.getPanelCambios().setText(
					vistaDevolucion.getPanelCambios().getText().toString() + diezCents + " x Monedas de 10cents \n");
			vueltas = vueltas - 10 * diezCents;
		}
		if (vueltas / 5 >= 1) {
			int cincoCents = (int) (vueltas / 5);
			vistaDevolucion.getPanelCambios().setText(
					vistaDevolucion.getPanelCambios().getText().toString() + cincoCents + " x Monedas de 5cents \n");
			vueltas = vueltas - 5 * cincoCents;
		}
		if (vueltas / 2 >= 1) {
			int dosCents = (int) (vueltas / 2);
			vistaDevolucion.getPanelCambios().setText(
					vistaDevolucion.getPanelCambios().getText().toString() + dosCents + " x Monedas de 2cents \n");
			vueltas = vueltas - 2 * dosCents;
		}
		if (vueltas / 1 >= 1) {
			int unCent = (int) (vueltas / 1);
			vistaDevolucion.getPanelCambios().setText(
					vistaDevolucion.getPanelCambios().getText().toString() + unCent + " x Monedas de 1cent \n");
			vueltas = vueltas - 1 * unCent;
		}

		vistaDevolucion.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try {
					// TODO add your handling code here:
					Thread.sleep(2750);
					vistaDevolucion.setVisible(false);
					vista.Ticket ventanaTicket = new vista.Ticket();
					ventanaTicket.setVisible(true);
					ControladorTicket controladorTicket = new ControladorTicket(ventanaTicket);
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
