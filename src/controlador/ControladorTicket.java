package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Autobus;
import modelo.Cliente;
import modelo.Linea;
import modelo.Parada;
import vista.Bienvenida;
import vista.MenuLinea;
import vista.Ticket;

public class ControladorTicket implements ActionListener, ListSelectionListener {

	private Ticket vistaTicket;
	private String fecha,cod_Linea,horaStr,origenS,destinoS,linea,nombre,apellido,sexo;
	
	
	
	public ControladorTicket(Ticket ventanaTicket) {
		this.vistaTicket = ventanaTicket;

		this.inicializarControlador();
	}

	private void inicializarControlador() {
		ArrayList<Linea> listaLinea = modeloDAO.LineaDAO.mObtenerLinea();
		ArrayList<Parada> listaParada = modeloDAO.ParadaDAO.mObtenerParada(listaLinea.get(ControladorMenuLinea.conservarLinea() - 1).getCod_Linea());
		origenS = (ControladorMenuOrigenDestino.recogerOrigen());
		destinoS = (ControladorMenuOrigenDestino.recogerDestino());
		fecha = (ControladorMenuLinea.recogerFecha());
		cod_Linea = listaLinea.get(ControladorMenuLinea.conservarLinea() - 1).getCod_Linea();
		horaStr = (ControladorMenuOrigenDestino.recogerHora());
		ArrayList<Autobus> listaAutobus = modeloDAO.AutobusDAO.mObtenerDatosAutobus(cod_Linea, horaStr, fecha);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		linea = (ControladorMenuLinea.recogerLinea());
		ArrayList <Cliente> listaCliente = modeloDAO.ClienteDAO.mObtenerDatosCliente(ControladorIniciarSesion.DNI);
		nombre=listaCliente.get(0).getNombre();
		apellido=listaCliente.get(0).getApellido();
		
		if(listaCliente.get(0).getSexo().equals("V")) {
			sexo="Hombre";
		}else if(listaCliente.get(0).getSexo().equals("M")) {
			sexo="Mujer";
		}else {
			sexo="Alien";
		}
			
			
		vistaTicket.getRespuestaLinea().setText(linea);
		vistaTicket.getRespuestaFechaCompra().setText(localDate+"");
		vistaTicket.getRespuestaCodigo().setText(listaAutobus.get(0).getCodAutobus()+"");
		vistaTicket.getRespuestaFechaSalida().setText(fecha);
		vistaTicket.getRespuestaOrigen().setText(origenS+destinoS);
		vistaTicket.getRespuestaHoraSalida().setText(horaStr);
		vistaTicket.getLblFechaVuelta().setText(ControladorIdaVuelta.fechaVuelta);
		vistaTicket.getLblHoraVuelta().setText(ControladorIdaVuelta.horaVuelta);
		vistaTicket.getRespuestaCoste().setText(ControladorResumen.recogerPrecio()+"\u20AC");
		vistaTicket.getRespuestaTipoBillete().setText(ControladorMenuOrigenDestino.recogerTipoBillete());
		vistaTicket.getRespuestaDNI().setText(ControladorIniciarSesion.DNI);
		vistaTicket.getRespuestaApellido().setText(apellido);
		vistaTicket.getRespuestaNombre().setText(nombre);
		vistaTicket.getRespuestaSexo().setText(sexo);
	}

	public void actionPerformed(ActionEvent e) {

	}

	public void valueChanged(ListSelectionEvent e) {

	}

}
