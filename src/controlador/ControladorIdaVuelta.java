package controlador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Autobus;
import modelo.Linea;
import vista.Bienvenida;
import vista.IdaVuelta;
import vista.MenuLinea;

public class ControladorIdaVuelta implements ActionListener, ListSelectionListener {
	
	private IdaVuelta vistaIdaVuelta;
	private int mes;

	public ControladorIdaVuelta(IdaVuelta ventanaIdaVuelta) {
		this.vistaIdaVuelta = ventanaIdaVuelta;

		this.inicializarControlador();
	}

	private void inicializarControlador() {
		mcargarfecha();
		
		vistaIdaVuelta.getBtnCancelar().addActionListener(this);
		vistaIdaVuelta.getBtnCancelar().setActionCommand(IdaVuelta.enumAcciones.CANCELAR.toString());
		vistaIdaVuelta.getBtnConfirmar().addActionListener(this);
		vistaIdaVuelta.getBtnConfirmar().setActionCommand(IdaVuelta.enumAcciones.CONFIRMAR.toString());
		
		vistaIdaVuelta.getCalendar().getDayChooser().addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				if(vistaIdaVuelta.getCalendar().getDayChooser().getDay()==(ControladorMenuLinea.conservarDia())) {
					mCargarHoraPrimerAutobus();
				}
				else {
					mCargarHoraAutobus();
				}
				}
		});
		
		vistaIdaVuelta.getBoxHora().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ((vistaIdaVuelta.getBoxHora().getSelectedItem()) !="") {
					vistaIdaVuelta.getBtnConfirmar().setEnabled(true);
					
				} else {
					vistaIdaVuelta.getBtnConfirmar().setEnabled(false);
				}
			}
		});

	}

	public void actionPerformed(ActionEvent e) {
		
		IdaVuelta.enumAcciones accion = IdaVuelta.enumAcciones.valueOf(e.getActionCommand());

		switch (accion) {
		case CANCELAR:
			vistaIdaVuelta.setVisible(false);
			vista.Bienvenida ventanaBienvenida = new vista.Bienvenida();
			ventanaBienvenida.setVisible(true);
			ControladorBienvenida controladorBienvenida = new ControladorBienvenida(ventanaBienvenida);
			break;
		case CONFIRMAR:
			vistaIdaVuelta.setVisible(false);
			vista.Resumen ventanaResumen = new vista.Resumen();
			ventanaResumen.setVisible(true);
			ControladorResumen controladorResumen = new ControladorResumen(ventanaResumen);
			break;

		}
	}

	public void valueChanged(ListSelectionEvent e) {

	}
	private void mCargarHoraAutobus() {
		String fecha, Cod_Linea, Cod_Linea2 = "";
		fecha = recogerFecha();

		ArrayList<Linea> listaLinea = modeloDAO.LineaDAO.mObtenerLinea();

		String nombreLinea[] = new String[listaLinea.size()];

		for (int i = 0; i < listaLinea.size(); i++) {
			Cod_Linea = ControladorMenuLinea.recogerLinea();
			nombreLinea[i] = (listaLinea.get(i).getCod_Linea());
			Cod_Linea = Cod_Linea.substring(0, nombreLinea[i].length());
			System.out.println(nombreLinea[i]);
			if (nombreLinea[i].equals(Cod_Linea)) {
				Cod_Linea2 = nombreLinea[i];
			}
		}

		ArrayList<Autobus> listaAutobus = modeloDAO.AutobusDAO.mObtenerHoraAutobus(fecha, Cod_Linea2);

		String nombreAutobus[][] = new String[listaAutobus.size()][4];

		for (int i = 0; i < listaAutobus.size(); i++) {
			nombreAutobus[i][0] = (listaAutobus.get(i).getHora());
			vistaIdaVuelta.getBoxHora().addItem(nombreAutobus[i][0]);

		}

	}

	private String recogerFecha() {
		String fecha;
		int dia, mes, ano;
		String cero="";

		dia = vistaIdaVuelta.getCalendar().getDayChooser().getDay();
		mes = ((vistaIdaVuelta.getCalendar().getMonthChooser().getMonth())+1);
		ano = vistaIdaVuelta.getCalendar().getYearChooser().getYear();
		if(Integer.toString(mes).length()==1) {
			cero="0";
		}
		fecha = ( ano+ "-" + cero + mes + "-" + dia);

		return fecha;
	}
	
	private void mcargarfecha() {
		Calendar calendario = Calendar.getInstance();
		Date fechaMinima = ControladorMenuLinea.conservarMesDate();
		calendario.add(Calendar.DAY_OF_YEAR, 14);
		Date fechaMaxima = calendario.getTime();
		
		vistaIdaVuelta.getCalendar().setSelectableDateRange(fechaMinima,fechaMaxima);
		
	}
	private void mCargarHoraPrimerAutobus() {
		String fecha, Cod_Linea, Cod_Linea2 = "";
		fecha = recogerFecha();
		String hora=ControladorMenuOrigenDestino.recogerHora();
		ArrayList<Linea> listaLinea = modeloDAO.LineaDAO.mObtenerLinea();

		String nombreLinea[] = new String[listaLinea.size()];

		for (int i = 0; i < listaLinea.size(); i++) {
			Cod_Linea = ControladorMenuLinea.recogerLinea();
			nombreLinea[i] = (listaLinea.get(i).getCod_Linea());
			Cod_Linea = Cod_Linea.substring(0, nombreLinea[i].length());
			System.out.println(nombreLinea[i]);
			if (nombreLinea[i].equals(Cod_Linea)) {
				Cod_Linea2 = nombreLinea[i];
			}
		}

		ArrayList<Autobus> listaAutobus = modeloDAO.AutobusDAO.mObtenerHoraPrimerAutobus(fecha, Cod_Linea2,hora);

		String nombreAutobus[][] = new String[listaAutobus.size()][4];

		for (int i = 0; i < listaAutobus.size(); i++) {
			nombreAutobus[i][0] = (listaAutobus.get(i).getHora());
			vistaIdaVuelta.getBoxHora().addItem(nombreAutobus[i][0]);

		}

	}
}
