package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Autobus;
import modelo.Linea;
import modelo.Parada;
import vista.IniciarSesion;
import vista.MenuLinea;
import vista.Resumen;

	public class ControladorResumen implements ActionListener, ListSelectionListener {
		private String fecha,linea,origenDestino,horaStr,tipoBillete,destinoS,origenS;
		private static Resumen vistaResumen;
		public static int Linea=0,origen,horaInt,destino,objetoOrigen,objetoDestino,asientosOcupados,numAsientos,asientosLibres,multiplicador;
		String cod_Linea;
		private double precioBillete;
		
		public ControladorResumen(Resumen ventanaResumen) {
			this.vistaResumen = ventanaResumen;
			
			this.inicializarControlador();
		}

		private void inicializarControlador() {
			
			ArrayList<Linea> listaLinea = modeloDAO.LineaDAO.mObtenerLinea();
			ArrayList<Parada> listaParada = modeloDAO.ParadaDAO.mObtenerParada(listaLinea.get(ControladorMenuLinea.conservarLinea()-1).getCod_Linea());
			
			fecha=(ControladorMenuLinea.recogerFecha());
			linea=(ControladorMenuLinea.recogerLinea());
			origenS=(ControladorMenuOrigenDestino.recogerOrigen());
			destinoS=(ControladorMenuOrigenDestino.recogerDestino());
			origenDestino=(origenS+" - "+destinoS);
			horaStr=(ControladorMenuOrigenDestino.recogerHora());
			tipoBillete=(ControladorMenuOrigenDestino.recogerTipoBillete());
			objetoOrigen=mDevolverNObjetoOrigen();
			objetoDestino=mDevolverNObjetoDestino();
			cod_Linea=listaLinea.get(ControladorMenuLinea.conservarLinea()-1).getCod_Linea();
			ArrayList<Autobus> listaAutobus = modeloDAO.AutobusDAO.mObtenerDatosAutobus(cod_Linea,horaStr,fecha);
			asientosOcupados=listaAutobus.get(0).getNumPlazasOcupadas();
			numAsientos=listaAutobus.get(0).getNumPlazas();
			asientosLibres=numAsientos-asientosOcupados;
			for(int i=1;i<=asientosLibres;i++) {
				vistaResumen.getBoxNumeroTiquets().addItem(i);
			}
			precioBillete=modeloDAO.BilleteDAO.mPrecioTrayecto(listaAutobus.get(0), listaParada.get(objetoOrigen),listaParada.get(objetoDestino));
			MathContext formatoDecimal = new MathContext(3);
			BigDecimal decimal = new BigDecimal(precioBillete,formatoDecimal);
			precioBillete=decimal.doubleValue();
		
			
			
			
			if(tipoBillete.equals("Ida y Vuelta")) {
				precioBillete=precioBillete*2;
			}
			vistaResumen.getLblPrecio().setText(precioBillete+"");
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
				precioBillete=modeloDAO.BilleteDAO.mPrecioTrayecto(listaAutobus.get(0), listaParada.get(objetoOrigen),listaParada.get(objetoDestino));
				
				multiplicador=Integer.parseInt(vistaResumen.getBoxNumeroTiquets().getSelectedItem().toString());
				precioBillete=precioBillete*multiplicador;
				if(tipoBillete.equals("Ida y Vuelta")) {
					precioBillete=precioBillete*2;
				} 
				MathContext formatoDecimal = new MathContext(3);
				BigDecimal decimal = new BigDecimal(precioBillete,formatoDecimal);
				precioBillete=decimal.doubleValue();
				vistaResumen.getLblPrecio().setText(precioBillete+"\u20AC");
			}
			});}
		
		public void actionPerformed(ActionEvent e) {
			
			Resumen.enumAcciones accion = Resumen.enumAcciones.valueOf(e.getActionCommand());
	

			switch (accion) {
			case SIGUIENTE_PAGINA:
				Linea=0;
				origen=0;
				horaInt=0;
				destino=0;
				vistaResumen.setVisible(false);
				vista.IniciarSesion ventanaIniciarSesion = new vista.IniciarSesion();
				ventanaIniciarSesion.setVisible(true);
				ControladorIniciarSesion controladorIniciarSesion = new ControladorIniciarSesion(ventanaIniciarSesion);
				break;
			case CANCELAR_COMPRA:
				Linea=0;
				origen=0;
				horaInt=0;
				destino=0;
				vistaResumen.setVisible(false);
				vista.Bienvenida ventanaBienvenida = new vista.Bienvenida();
				ventanaBienvenida.setVisible(true);
				ControladorBienvenida controladorBienvenida= new ControladorBienvenida(ventanaBienvenida);
				break;
			case PAGINA_ANTERIOR:
				vistaResumen.setVisible(false);
				vista.MenuOrigenDestino ventanaMenuOrigenDestino = new vista.MenuOrigenDestino();
				ventanaMenuOrigenDestino.setVisible(true);
				ControladorMenuOrigenDestino controladorMenuOrigenDestino= new ControladorMenuOrigenDestino(ventanaMenuOrigenDestino);
				break;
			case MODIFICAR_COMPRA:
				Linea=(ControladorMenuLinea.conservarLinea());
				origen=(ControladorMenuOrigenDestino.conservarOrigen());
				destino=(ControladorMenuOrigenDestino.conservarDestino());
				horaInt=(ControladorMenuOrigenDestino.conservarHora());
				vistaResumen.setVisible(false);
				vista.MenuLinea ventanaMenuLinea = new vista.MenuLinea();
				ventanaMenuLinea.setVisible(true);
				ControladorMenuLinea controladorMenuLinea= new ControladorMenuLinea(ventanaMenuLinea);
				break;
			}
			
		}

		public void valueChanged(ListSelectionEvent e) {
			
			
		}
		
		private int mDevolverNObjetoOrigen() {

			ArrayList<Linea> listaLinea = modeloDAO.LineaDAO.mObtenerLinea();
			ArrayList<Parada> listaParada = modeloDAO.ParadaDAO.mObtenerParada(listaLinea.get(ControladorMenuLinea.conservarLinea()-1).getCod_Linea());

			int origenDestino = 1000;
			
			String nombreParada[][] = new String[listaParada.size()][4];

			for (int i = 0; i < listaParada.size(); i++) {
				nombreParada[i][0] =(listaParada.get(i).getNombre());
				if(nombreParada[i][0].equals(origenS)) {
					origenDestino=i;
				}
				
				}
			return origenDestino;
			}
		
		
		private int mDevolverNObjetoDestino() {

			ArrayList<Linea> listaLinea = modeloDAO.LineaDAO.mObtenerLinea();
			ArrayList<Parada> listaParada = modeloDAO.ParadaDAO.mObtenerParada(listaLinea.get(ControladorMenuLinea.conservarLinea()-1).getCod_Linea());

			int origenDestino = 1000;
			
			String nombreParada[][] = new String[listaParada.size()][4];

			for (int i = 0; i < listaParada.size(); i++) {
				nombreParada[i][0] =(listaParada.get(i).getNombre());
				if(nombreParada[i][0].equals(destinoS)) {
					origenDestino=i;
				}
				
				}
			
			return origenDestino;
		}



		
		public static float recogerPrecio() {
			// recoge aqui el precio para llevarlo al ControladorPago //
			
			float precio;
			
			precio = Float.parseFloat(vistaResumen.getLblPrecio().getText().toString());
			
			return precio;
		}
		
	
}

