package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Autobus;
import modelo.Linea;
import modelo.Parada;
import vista.Bienvenida;
import vista.MenuLinea;
import vista.Ticket;

public class ControladorTicket implements ActionListener, ListSelectionListener {

	private Ticket vistaTicket;
	private String fecha,cod_Linea,horaStr,origenS,destinoS;
	
	
	
	public ControladorTicket(Ticket ventanaTicket) {
		this.vistaTicket = ventanaTicket;

		this.inicializarControlador();
	}

	private void inicializarControlador() {
		ArrayList<Linea> listaLinea = modeloDAO.LineaDAO.mObtenerLinea();
		ArrayList<Parada> listaParada = modeloDAO.ParadaDAO
				.mObtenerParada(listaLinea.get(ControladorMenuLinea.conservarLinea() - 1).getCod_Linea());
		origenS = (ControladorMenuOrigenDestino.recogerOrigen());
		destinoS = (ControladorMenuOrigenDestino.recogerDestino());
		fecha = (ControladorMenuLinea.recogerFecha());
		cod_Linea = listaLinea.get(ControladorMenuLinea.conservarLinea() - 1).getCod_Linea();
		horaStr = (ControladorMenuOrigenDestino.recogerHora());
		ArrayList<Autobus> listaAutobus = modeloDAO.AutobusDAO.mObtenerDatosAutobus(cod_Linea, horaStr, fecha);

	}

	public void actionPerformed(ActionEvent e) {

	}

	public void valueChanged(ListSelectionEvent e) {

	}

}
