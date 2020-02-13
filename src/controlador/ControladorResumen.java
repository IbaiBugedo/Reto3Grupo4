package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Autobus;
import modelo.Linea;
import modelo.Parada;
import vista.Resumen;

public class ControladorResumen implements ActionListener, ListSelectionListener {
	private String fecha, linea, origenDestino, horaStr, tipoBillete, destinoS, origenS;
	private static Resumen vistaResumen;
	public static int Linea = 0, origen, horaInt, destino, objetoOrigen, objetoDestino, asientosOcupados, numAsientos,
			asientosLibres, multiplicador;
	String cod_Linea;
	public static double precioTotalIda,precioTotalVuelta;
	private static double precioBillete,precioBilleteTotal=0,precioBilleteTotalVuelta=0;

	ArrayList<Linea> listaLinea;
	ArrayList<Parada> listaParada;
	ArrayList<Autobus> listaAutobus;
	
	public ControladorResumen(Resumen ventanaResumen, ArrayList<modelo.Linea> listaLinea, ArrayList<Parada> listaParada, ArrayList<Autobus> listaAutobus)
	{
		this.vistaResumen = ventanaResumen;

		this.listaAutobus=listaAutobus;
		this.listaLinea=listaLinea;
		this.listaParada=listaParada;
		
		this.inicializarControlador();
	}

	private void inicializarControlador() {

		ArrayList<Linea> listaLinea = modeloDAO.LineaDAO.mObtenerLinea();
		ArrayList<Parada> listaParada = modeloDAO.ParadaDAO
				.mObtenerParada(listaLinea.get(ControladorMenuLinea.conservarLinea() - 1).getCod_Linea());

		fecha = (ControladorMenuLinea.recogerFecha());
		linea = (ControladorMenuLinea.recogerLinea());
		origenS = (ControladorMenuOrigenDestino.recogerOrigen());
		destinoS = (ControladorMenuOrigenDestino.recogerDestino());
		origenDestino = (origenS + " - " + destinoS);
		horaStr = (ControladorMenuOrigenDestino.recogerHora());
		tipoBillete = (ControladorMenuOrigenDestino.recogerTipoBillete());
		objetoOrigen = mDevolverNObjetoOrigen();
		objetoDestino = mDevolverNObjetoDestino();
		cod_Linea = listaLinea.get(ControladorMenuLinea.conservarLinea() - 1).getCod_Linea();
		ArrayList<Autobus> listaAutobus = modeloDAO.AutobusDAO.mObtenerDatosAutobus(cod_Linea, horaStr, fecha);
		asientosOcupados = listaAutobus.get(0).getNumPlazasOcupadas();
		numAsientos = listaAutobus.get(0).getNumPlazas();
		asientosLibres = numAsientos - asientosOcupados;
		for (int i = 1; i <= asientosLibres; i++) {
			vistaResumen.getBoxNumeroTiquets().addItem(i);
		}
	
		for(int i=objetoOrigen;i<=objetoDestino;i++) {
			precioBillete = modeloDAO.BilleteDAO.mPrecioTrayecto(listaAutobus.get(0), listaParada.get(i),
					listaParada.get(i+1));		
			precioBilleteTotal=precioBilleteTotal+precioBillete;
			precioBilleteTotal = Math.round(precioBilleteTotal * 100.0) / 100.0;
		}
		for(int i=objetoDestino;i<=objetoOrigen;i++) {
			precioBillete = modeloDAO.BilleteDAO.mPrecioTrayecto(listaAutobus.get(0), listaParada.get(i),
					listaParada.get(i+1));
			precioBilleteTotal=precioBilleteTotal+precioBillete;
			precioBilleteTotal = Math.round(precioBilleteTotal * 100.0) / 100.0;
		}
		precioTotalIda=precioBilleteTotal;
		if (tipoBillete.equals("Ida y Vuelta")) {
			ArrayList<Autobus> listaAutobusVuelta = modeloDAO.AutobusDAO.mObtenerDatosAutobus(cod_Linea, ControladorIdaVuelta.horaVuelta, ControladorIdaVuelta.fechaVuelta);
			
			for(int i=objetoOrigen;i<=objetoDestino;i++) {
				precioBillete = modeloDAO.BilleteDAO.mPrecioTrayecto(listaAutobusVuelta.get(0), listaParada.get(i),
						listaParada.get(i+1));
				precioBilleteTotalVuelta=precioBilleteTotalVuelta+precioBillete;
				precioBilleteTotalVuelta = Math.round(precioBilleteTotalVuelta * 100.0) / 100.0;
			}
			for(int i=objetoDestino;i<=objetoOrigen;i++) {
				precioBillete = modeloDAO.BilleteDAO.mPrecioTrayecto(listaAutobusVuelta.get(0), listaParada.get(i),
						listaParada.get(i+1));
				precioBilleteTotalVuelta=precioBilleteTotalVuelta+precioBillete;
				precioBilleteTotalVuelta = Math.round(precioBilleteTotalVuelta * 100.0) / 100.0;
			}	
			precioTotalVuelta=precioBilleteTotalVuelta;
			precioBilleteTotal=precioTotalIda+precioTotalVuelta;
			
			
		}
		precioBilleteTotal=precioTotalIda+precioTotalVuelta;
		vistaResumen.getLblHoraVuelta().setText(ControladorIdaVuelta.horaVuelta);
		vistaResumen.getLblFechaVuelta().setText(ControladorIdaVuelta.fechaVuelta);
		precioBilleteTotal = Math.round(precioBilleteTotal * 100.0) / 100.0;
		vistaResumen.getLblPrecio().setText(precioBilleteTotal + "\u20AC");
		vistaResumen.getLblFecha().setText(fecha);
		vistaResumen.getLblLinea().setText(linea);
		vistaResumen.getLblOrigenDestino().setText(origenDestino);
		vistaResumen.getLblHora().setText(horaStr);
		vistaResumen.getLblTipoViaje().setText(tipoBillete);

		this.vistaResumen.getBtnAceptar().addActionListener(this);
		this.vistaResumen.getBtnAceptar().setActionCommand(Resumen.enumAcciones.SIGUIENTE_PAGINA.toString());
		this.vistaResumen.getBtnCancelar().addActionListener(this);
		this.vistaResumen.getBtnCancelar().setActionCommand(Resumen.enumAcciones.CANCELAR_COMPRA.toString());
		this.vistaResumen.getBtnModificar().addActionListener(this);
		this.vistaResumen.getBtnModificar().setActionCommand(Resumen.enumAcciones.MODIFICAR_COMPRA.toString());
		this.vistaResumen.getBtnRetroceso().addActionListener(this);
		this.vistaResumen.getBtnRetroceso().setActionCommand(Resumen.enumAcciones.PAGINA_ANTERIOR.toString());

		vistaResumen.getBoxNumeroTiquets().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				precioBilleteTotal=precioTotalIda+precioTotalVuelta;
				multiplicador = Integer.parseInt(vistaResumen.getBoxNumeroTiquets().getSelectedItem().toString());
				precioBilleteTotal = precioBilleteTotal * multiplicador;
				precioBilleteTotal = Math.round(precioBilleteTotal * 100.0) / 100.0;
				vistaResumen.getLblPrecio().setText(precioBilleteTotal + "\u20AC");
			}
		});
	}

	public void actionPerformed(ActionEvent e) {

		Resumen.enumAcciones accion = Resumen.enumAcciones.valueOf(e.getActionCommand());

		switch (accion) {
		case SIGUIENTE_PAGINA:
			Linea = 0;
			origen = 0;
			horaInt = 0;
			destino = 0;
			vistaResumen.setVisible(false);
			vista.IniciarSesion ventanaIniciarSesion = new vista.IniciarSesion();
			ventanaIniciarSesion.setVisible(true);
			ControladorIniciarSesion controladorIniciarSesion = new ControladorIniciarSesion(ventanaIniciarSesion,listaLinea,listaParada,listaAutobus);
			break;
		case CANCELAR_COMPRA:
			Linea = 0;
			origen = 0;
			horaInt = 0;
			destino = 0;
			vistaResumen.setVisible(false);
			vista.Bienvenida ventanaBienvenida = new vista.Bienvenida();
			ventanaBienvenida.setVisible(true);
			ControladorBienvenida controladorBienvenida = new ControladorBienvenida(ventanaBienvenida);
			break;
		case PAGINA_ANTERIOR:
			vistaResumen.setVisible(false);
			vista.MenuOrigenDestino ventanaMenuOrigenDestino = new vista.MenuOrigenDestino();
			ventanaMenuOrigenDestino.setVisible(true);
			ControladorMenuOrigenDestino controladorMenuOrigenDestino = new ControladorMenuOrigenDestino(
					ventanaMenuOrigenDestino,listaLinea);
			break;
		case MODIFICAR_COMPRA:
			Linea = (ControladorMenuLinea.conservarLinea());
			origen = (ControladorMenuOrigenDestino.conservarOrigen());
			destino = (ControladorMenuOrigenDestino.conservarDestino());
			horaInt = (ControladorMenuOrigenDestino.conservarHora());
			vistaResumen.setVisible(false);
			vista.MenuLinea ventanaMenuLinea = new vista.MenuLinea();
			ventanaMenuLinea.setVisible(true);
			ControladorMenuLinea controladorMenuLinea = new ControladorMenuLinea(ventanaMenuLinea);
			break;
		}

	}

	public void valueChanged(ListSelectionEvent e) {

	}

	private int mDevolverNObjetoOrigen() {
		int origenDestino = 1000;

		String nombreParada[][] = new String[listaParada.size()][4];

		for (int i = 0; i < listaParada.size(); i++) {
			nombreParada[i][0] = (listaParada.get(i).getNombre());
			if (nombreParada[i][0].equals(origenS)) {
				origenDestino = i;
			}

		}
		return origenDestino;
	}

	private int mDevolverNObjetoDestino() {

		int origenDestino = 1000;

		String nombreParada[][] = new String[listaParada.size()][4];

		for (int i = 0; i < listaParada.size(); i++) {
			nombreParada[i][0] = (listaParada.get(i).getNombre());
			if (nombreParada[i][0].equals(destinoS)) {
				origenDestino = i;
			}

		}

		return origenDestino;
	}

	public static double recogerPrecio() {
		// recoge aqui el precio para llevarlo al ControladorPago //

		return precioBilleteTotal;
	}

}
