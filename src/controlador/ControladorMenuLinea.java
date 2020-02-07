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
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Autobus;
import modelo.Linea;
import vista.Bienvenida;
import vista.MenuLinea;
import vista.MenuOrigenDestino;


public class ControladorMenuLinea implements ActionListener, ListSelectionListener {

	private static MenuLinea vistaMenuLinea;
	public static String Imagen;
	private int numArray;

	public ControladorMenuLinea(MenuLinea ventanaMenuLinea) {
		this.vistaMenuLinea = ventanaMenuLinea;

		this.inicializarControlador();
	}

	private void inicializarControlador() {
		mcargarfecha();
		mCargarLinea();
		vistaMenuLinea.getBoxLinea().setSelectedIndex(ControladorResumen.Linea);
		if ((vistaMenuLinea.getBoxLinea().getSelectedItem()) != "Selecciona la linea") {
			vistaMenuLinea.getBtnSiguiente().setEnabled(true);
		}
		this.vistaMenuLinea.getBtnSiguiente().addActionListener(this);
		this.vistaMenuLinea.getBtnSiguiente().setActionCommand(MenuLinea.enumAcciones.SIGUIENTE_PAGINA.toString());

		vistaMenuLinea.getBoxLinea().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ((vistaMenuLinea.getBoxLinea().getSelectedItem()) != "Selecciona la linea") {
					vistaMenuLinea.getBtnSiguiente().setEnabled(true);
					ArrayList<Linea> listaLinea = modeloDAO.LineaDAO.mObtenerLinea();
					numArray=(vistaMenuLinea.getBoxLinea().getSelectedIndex())-1;
					Imagen=listaLinea.get(numArray).getImagen_linea().toString();
					vistaMenuLinea.getLblImagen().setIcon(new ImageIcon(ControladorMenuLinea.class.getResource(Imagen)));
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
		int dia, mes, ano;
		String cero="",ceroDia="";

		dia = vistaMenuLinea.getCalendar().getDayChooser().getDay();
		mes = ((vistaMenuLinea.getCalendar().getMonthChooser().getMonth())+1);
		ano = vistaMenuLinea.getCalendar().getYearChooser().getYear();
		if(Integer.toString(mes).length()==1) {
			cero="0";
		}
		if(Integer.toString(dia).length()==1) {
			ceroDia="0";
		}
		fecha = ( ano+ "-" + cero + mes + "-" +ceroDia+ dia);

		return fecha;
	}
	public static int conservarLinea(){
		int linea;
		linea = (vistaMenuLinea.getBoxLinea().getSelectedIndex());
		return linea;	
	}
	public static int conservarDia(){
		int dia;
		dia = vistaMenuLinea.getCalendar().getDayChooser().getDay();
		return dia;
	}
	public static int conservarMes(){
		int mes;
		mes = vistaMenuLinea.getCalendar().getMonthChooser().getMonth();
		return mes;
	}
	
	public static Date conservarMesDate() {
		Date mes; 
	
		return mes = vistaMenuLinea.getCalendar().getDate();
	}
	
	private void mCargarLinea() {

		

		ArrayList<Linea> listaLinea = modeloDAO.LineaDAO.mObtenerLinea();

		String nombreLinea[][] = new String[listaLinea.size()][4];

		for (int i = 0; i < listaLinea.size(); i++) {
			nombreLinea[i][0] =(listaLinea.get(i).getNombreLinea());
			nombreLinea[i][1]=(listaLinea.get(i).getCod_Linea());
			vistaMenuLinea.getBoxLinea().addItem(nombreLinea[i][1]+" "+nombreLinea[i][0]);


		}
	}
	
	private void mcargarfecha() {
		Calendar calendario = Calendar.getInstance();
		Date fechaMinima = calendario.getTime();
		calendario.add(Calendar.DAY_OF_YEAR, 14);
		Date fechaMaxima = calendario.getTime();
		vistaMenuLinea.getCalendar().setSelectableDateRange(fechaMinima,fechaMaxima);
		
	}
	
	
	
	
	
	
	
}