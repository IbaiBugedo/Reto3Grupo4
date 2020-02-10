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
import modelo.Billete;
import modelo.Cliente;
import modelo.Linea;
import modelo.Parada;
import modeloDAO.BilleteDAO;
import modeloDAO.ClienteDAO;
import vista.Bienvenida;
import vista.MenuLinea;
import vista.Resumen;
import vista.Ticket;

public class ControladorTicket implements ActionListener, ListSelectionListener {

	private Ticket vistaTicket;
	private String fecha, cod_Linea, horaStr, origenS, destinoS, linea, nombre, apellido, sexo,codigoBillete;
	private double precio;
	private int codigoBilleteIda, codigoBilleteVuelta;

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
		ArrayList <Billete> listaBillete = modeloDAO.BilleteDAO.mObtenerNBillete();
		codigoBilleteIda=listaBillete.get(0).getCodBillete();
		precio=ControladorResumen.recogerPrecio();
		if(ControladorMenuOrigenDestino.recogerTipoBillete().equals("Ida y Vuelta")) {
			precio=precio/2;
			codigoBilleteVuelta=codigoBilleteIda+1;
			codigoBillete=codigoBilleteIda+"-"+codigoBilleteVuelta;
		}
		else {
			codigoBillete=codigoBilleteIda+"";
		}
	
		
		
		vistaTicket.getRespuestaNBillete().setText(codigoBillete+"");
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
		
		Billete nuevoBillete = new Billete();

		nuevoBillete.setCodBillete(codigoBilleteIda);
		nuevoBillete.setCodBus(listaAutobus.get(0).getCodAutobus());
		nuevoBillete.setCodLinea((listaLinea.get(ControladorMenuLinea.conservarLinea() - 1).getCod_Linea()));
		nuevoBillete.setCodParadaFin(listaParada.get(ControladorMenuOrigenDestino.conservarDestino()).getCod_Parada());
		nuevoBillete.setCodParadaInicio(listaParada.get(ControladorMenuOrigenDestino.conservarOrigen()).getCod_Parada());
		nuevoBillete.setDni(ControladorIniciarSesion.DNI);
		nuevoBillete.setFecha(fecha);
		nuevoBillete.setHora(horaStr);
		nuevoBillete.setPrecio(precio);


		modeloDAO.BilleteDAO.mInsertarBillete(nuevoBillete);
		if(ControladorMenuOrigenDestino.recogerTipoBillete().equals("Ida y Vuelta")) {
			Billete nuevoBillete2 = new Billete();

			nuevoBillete2.setCodBillete(codigoBilleteVuelta);
			nuevoBillete2.setCodBus(listaAutobus.get(0).getCodAutobus());
			nuevoBillete2.setCodLinea((listaLinea.get(ControladorMenuLinea.conservarLinea() - 1).getCod_Linea()));
			nuevoBillete2.setCodParadaFin(listaParada.get(ControladorMenuOrigenDestino.conservarOrigen()).getCod_Parada());
			nuevoBillete2.setCodParadaInicio(listaParada.get(ControladorMenuOrigenDestino.conservarDestino()).getCod_Parada());
			nuevoBillete2.setDni(ControladorIniciarSesion.DNI);
			nuevoBillete2.setFecha(ControladorIdaVuelta.fechaVuelta);
			nuevoBillete2.setHora(ControladorIdaVuelta.horaVuelta);
			nuevoBillete2.setPrecio(precio);

		
			modeloDAO.BilleteDAO.mInsertarBillete(nuevoBillete2);
		}
		
		
		this.vistaTicket.getImprimirTiquet().addActionListener(this);
		this.vistaTicket.getImprimirTiquet().setActionCommand(Ticket.enumAcciones.IMPRIMIR.toString());
		this.vistaTicket.getFinalizar().addActionListener(this);
		this.vistaTicket.getFinalizar().setActionCommand(Ticket.enumAcciones.FINALIZAR.toString());
		
	}

	public void actionPerformed(ActionEvent e) {
		
		Ticket.enumAcciones accion = Ticket.enumAcciones.valueOf(e.getActionCommand());

		switch (accion) {
		case IMPRIMIR:

			vistaTicket.setVisible(false);
			vista.Fin ventanaFin = new vista.Fin();
			ventanaFin.setVisible(true);
			ControladorFin controladorFin = new ControladorFin(ventanaFin);
			vista.Alerta ventanaAlerta = new vista.Alerta(1);
			ventanaAlerta.setVisible(true);
			ControladorAlerta controladorAlerta = new ControladorAlerta(ventanaAlerta);
			break;
		case FINALIZAR:
			vistaTicket.setVisible(false);
			vista.Fin ventanaFin2 = new vista.Fin();
			ventanaFin2.setVisible(true);
			ControladorFin controladorFin2 = new ControladorFin(ventanaFin2);
			break;
	}
		
	}
	  private void esperar(){
	        try {
	            Thread.sleep(2750);
	         } catch (Exception e) {
	            System.out.println(e);
	         }
	    } 
	public void valueChanged(ListSelectionEvent e) {

	}

}
