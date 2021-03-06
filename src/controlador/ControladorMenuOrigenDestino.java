package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Autobus;
import modelo.Linea;
import modelo.Parada;
import vista.MenuLinea;
import vista.MenuOrigenDestino;

	public class ControladorMenuOrigenDestino implements ActionListener, ListSelectionListener {
		
		private static MenuOrigenDestino vistaMenuOrigenDestino;
		ArrayList<Linea> listaLinea;
		ArrayList<Parada> listaParada; 
		ArrayList<Autobus> listaAutobus;
		
		public ControladorMenuOrigenDestino(MenuOrigenDestino ventanaMenuOrigenDestino, ArrayList<Linea> listaLinea) {
			this.vistaMenuOrigenDestino = ventanaMenuOrigenDestino;
			
			this.listaLinea=listaLinea;
			listaParada = modeloDAO.ParadaDAO.mObtenerParada(listaLinea.get(ControladorMenuLinea.conservarLinea() - 1).getCod_Linea());
			
			String fecha, Cod_Linea, Cod_Linea2 = "";
			fecha = ControladorMenuLinea.recogerFecha();


			String nombreLinea[] = new String[listaLinea.size()];

			for (int i = 0; i < listaLinea.size(); i++) {
				Cod_Linea = ControladorMenuLinea.recogerLinea();
				nombreLinea[i] = (listaLinea.get(i).getCod_Linea());
				Cod_Linea = Cod_Linea.substring(0, nombreLinea[i].length());
				if (nombreLinea[i].equals(Cod_Linea)) {
					Cod_Linea2 = nombreLinea[i];
				}
			}
			
			listaAutobus = modeloDAO.AutobusDAO.mObtenerHoraAutobus(fecha, Cod_Linea2);
			this.inicializarControlador();
		}


	private void inicializarControlador() {

		mCargarHoraAutobus();
		mCargarParada();
		vistaMenuOrigenDestino.getLblImagen().setIcon(new ImageIcon(ControladorMenuLinea.class.getResource(ControladorMenuLinea.Imagen)));
		vistaMenuOrigenDestino.getBoxOrigen().setSelectedIndex(ControladorResumen.origen);
		vistaMenuOrigenDestino.getBoxDestino().setSelectedIndex(ControladorResumen.destino);
		vistaMenuOrigenDestino.getBoxHora().setSelectedIndex(ControladorResumen.horaInt);

		vistaMenuOrigenDestino.getBtnSiguiente().addActionListener(this);
		vistaMenuOrigenDestino.getBtnSiguiente().setActionCommand(MenuLinea.enumAcciones.SIGUIENTE_PAGINA.toString());
		vistaMenuOrigenDestino.getBtnIda().addActionListener(this);
		vistaMenuOrigenDestino.getBtnIda().setActionCommand(MenuLinea.enumAcciones.VIAJE_IDA.toString());
		vistaMenuOrigenDestino.getBtnIdaVuelta().addActionListener(this);
		vistaMenuOrigenDestino.getBtnIdaVuelta().setActionCommand(MenuLinea.enumAcciones.VIAJE_IDA_VUELTA.toString());
		vistaMenuOrigenDestino.getBtnRetroceso().addActionListener(this);
		vistaMenuOrigenDestino.getBtnRetroceso().setActionCommand(MenuLinea.enumAcciones.PAGINA_ANTERIOR.toString());

		vistaMenuOrigenDestino.getBoxOrigen().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ((vistaMenuOrigenDestino.getBoxOrigen().getSelectedItem()) != "Selecione Origen"
						&& vistaMenuOrigenDestino.getBoxDestino().getSelectedItem() != "Selecione Destino"
						&& vistaMenuOrigenDestino.getBoxHora().getSelectedItem() != "Seleccione Hora"
						&& (vistaMenuOrigenDestino.getBtnIda().isEnabled() == false
								|| vistaMenuOrigenDestino.getBtnIdaVuelta().isEnabled() == false)) {

					vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(true);
				} else {
					vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(false);
				}
			}
		});

		vistaMenuOrigenDestino.getBoxDestino().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ((vistaMenuOrigenDestino.getBoxOrigen().getSelectedItem()) != "Selecione Origen"
						&& vistaMenuOrigenDestino.getBoxDestino().getSelectedItem() != "Selecione Destino"
						&& vistaMenuOrigenDestino.getBoxHora().getSelectedItem() != "Seleccione Hora"
						&& (vistaMenuOrigenDestino.getBtnIda().isEnabled() == false
								|| vistaMenuOrigenDestino.getBtnIdaVuelta().isEnabled() == false)) {

					vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(true);
				} else {
					vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(false);
				}
			}
		});
		vistaMenuOrigenDestino.getBoxHora().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ((vistaMenuOrigenDestino.getBoxOrigen().getSelectedItem()) != "Selecione Origen"
						&& vistaMenuOrigenDestino.getBoxDestino().getSelectedItem() != "Selecione Destino"
						&& vistaMenuOrigenDestino.getBoxHora().getSelectedItem() != "Seleccione Hora"
						&& (vistaMenuOrigenDestino.getBtnIda().isEnabled() == false
								|| vistaMenuOrigenDestino.getBtnIdaVuelta().isEnabled() == false)) {

					vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(true);
				} else {
					vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(false);
				}
			}
		});

	}

	public void actionPerformed(ActionEvent e) {

		MenuLinea.enumAcciones accion = MenuLinea.enumAcciones.valueOf(e.getActionCommand());

		switch (accion) {
		case SIGUIENTE_PAGINA:
			if(vistaMenuOrigenDestino.getBtnIdaVuelta().isEnabled()==false) {
				vistaMenuOrigenDestino.setVisible(false);
				vista.IdaVuelta ventanaIdaVuelta = new vista.IdaVuelta();
				ventanaIdaVuelta.setVisible(true);
				ControladorIdaVuelta controladorIdaVuelta = new ControladorIdaVuelta(ventanaIdaVuelta,listaLinea,listaParada,listaAutobus);
			}else {
			vistaMenuOrigenDestino.setVisible(false);
			vista.Resumen ventanaResumen = new vista.Resumen();
			ventanaResumen.setVisible(true);
			ControladorResumen controladorResumen = new ControladorResumen(ventanaResumen,listaLinea,listaParada,listaAutobus);
			}
			break;
		case VIAJE_IDA:
			vistaMenuOrigenDestino.getBtnIda().setEnabled(false);
			vistaMenuOrigenDestino.getBtnIdaVuelta().setEnabled(true);
			if ((vistaMenuOrigenDestino.getBoxOrigen().getSelectedItem()) != "Selecione Origen"
					&& vistaMenuOrigenDestino.getBoxDestino().getSelectedItem() != "Selecione Destino"
					&& vistaMenuOrigenDestino.getBoxHora().getSelectedItem() != "Seleccione Hora"
					&& (vistaMenuOrigenDestino.getBtnIda().isEnabled() == false
							|| vistaMenuOrigenDestino.getBtnIdaVuelta().isEnabled() == false)) {

				vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(true);
			} else {
				vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(false);
			}
			break;
		case VIAJE_IDA_VUELTA:
			vistaMenuOrigenDestino.getBtnIda().setEnabled(true);
			vistaMenuOrigenDestino.getBtnIdaVuelta().setEnabled(false);
			if ((vistaMenuOrigenDestino.getBoxOrigen().getSelectedItem()) != "Selecione Origen"
					&& vistaMenuOrigenDestino.getBoxDestino().getSelectedItem() != "Selecione Destino"
					&& vistaMenuOrigenDestino.getBoxHora().getSelectedItem() != "Seleccione Hora"
					&& (vistaMenuOrigenDestino.getBtnIda().isEnabled() == false
							|| vistaMenuOrigenDestino.getBtnIdaVuelta().isEnabled() == false)) {

				vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(true);
			} else {
				vistaMenuOrigenDestino.getBtnSiguiente().setEnabled(false);
			}
			break;
		case PAGINA_ANTERIOR:
			vistaMenuOrigenDestino.setVisible(false);
			vista.MenuLinea ventanaMenuLinea = new vista.MenuLinea();
			ventanaMenuLinea.setVisible(true);
			ControladorMenuLinea controladorMenuLinea = new ControladorMenuLinea(ventanaMenuLinea);
			break;

		}
	}

	public void valueChanged(ListSelectionEvent e) {

	}

	public static String recogerOrigen() {
		String origen;
		origen = vistaMenuOrigenDestino.getBoxOrigen().getSelectedItem().toString();

		return origen;
	}

	public static String recogerDestino() {
		String destino;
		destino = vistaMenuOrigenDestino.getBoxDestino().getSelectedItem().toString();
		return destino;
	}

	public static String recogerHora() {
		String hora;
		hora = vistaMenuOrigenDestino.getBoxHora().getSelectedItem().toString();
		return hora;
	}

	public static String recogerTipoBillete() {
		String tipoBillete;

		if (vistaMenuOrigenDestino.getBtnIda().isEnabled() == false) {
			tipoBillete = "Ida";
		} else {
			tipoBillete = "Ida y Vuelta";
		}
		return tipoBillete;
	}

	public static int conservarOrigen() {
		int origen;
		origen = (vistaMenuOrigenDestino.getBoxOrigen().getSelectedIndex());
		return origen;
	}

	public static int conservarDestino() {
		int destino;
		destino = (vistaMenuOrigenDestino.getBoxDestino().getSelectedIndex());
		return destino;
	}

	public static int conservarHora() {
		int hora;
		hora = (vistaMenuOrigenDestino.getBoxHora().getSelectedIndex());
		return hora;
	}

	public static boolean conservarTipoBillete() {
		boolean tipoBillete;

		if (vistaMenuOrigenDestino.getBtnIda().isEnabled() == false) {
			tipoBillete = true;
		} else {
			tipoBillete = false;
		}
		return tipoBillete;
	}

	private void mCargarParada() {

		String nombreParada[][] = new String[listaParada.size()][4];

		for (int i = 0; i < listaParada.size(); i++) {
			nombreParada[i][0] = (listaParada.get(i).getNombre());
			vistaMenuOrigenDestino.getBoxOrigen().addItem(nombreParada[i][0]);
			vistaMenuOrigenDestino.getBoxDestino().addItem(nombreParada[i][0]);
		}

	}

	private void mCargarHoraAutobus() {


		

		String nombreAutobus[][] = new String[listaAutobus.size()][4];

		for (int i = 0; i < listaAutobus.size(); i++) {
			nombreAutobus[i][0] = (listaAutobus.get(i).getHora());
			vistaMenuOrigenDestino.getBoxHora().addItem(nombreAutobus[i][0]);

		}

	}
}
