package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import com.toedter.calendar.JCalendar;
import controlador.ControladorMenuLinea;

import controlador.ControladorResumen;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class MenuLinea extends JFrame {

	public static enum enumAcciones{
		SIGUIENTE_PAGINA, 
		VIAJE_IDA,
		VIAJE_IDA_VUELTA, 
		PAGINA_ANTERIOR
	}
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private MenuLinea frame;
	private JComboBox boxLinea;
	private JCalendar calendar;
	private JButton btnSiguiente;
	private JLabel lblImagen;


	public MenuLinea() {

		mCrearPanelContenedor();
		mCrearJCalendar();
		mCrearJComboBox();
		mCrearJButton();
		mCrearJTable();

	}
	
	private void mCrearPanelContenedor() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	


	private void mCrearJTable() {	
		
		lblImagen = new JLabel("");
		lblImagen.setVerticalAlignment(SwingConstants.TOP);
		lblImagen.setBounds(10, 160, 718, 295);
		contentPane.add(lblImagen);
		
		table_1 = new JTable();
		table_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		table_1.setBounds(0, 155, 734, 306);
		contentPane.add(table_1);
		
		table = new JTable();
		table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		table.setBounds(0, 0, 510, 156);
		contentPane.add(table);
	}
	
	private void mCrearJComboBox() {
		
		boxLinea = new JComboBox();
		boxLinea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		boxLinea.setModel(new DefaultComboBoxModel(new String[] {"Seleccione la l\u00EDnea"}));
		boxLinea.setBounds(33, 29, 444, 98);
		contentPane.add(boxLinea);
	}
	
	private void mCrearJCalendar() {
		
		calendar = new JCalendar();
		calendar.getDayChooser().getDayPanel().setForeground(new Color(0, 0, 0));
		calendar.getYearChooser().getSpinner().setEnabled(false);
		calendar.setBounds(530, 10, 184, 141);
		contentPane.add(calendar);
		
	}

	private void mCrearJButton() {
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setEnabled(false);
		btnSiguiente.setBounds(631, 426, 97, 29);
		contentPane.add(btnSiguiente);
		
	}

	
	
	
	public JComboBox getBoxLinea() {
		return boxLinea;
	}

	public void setBoxLinea(JComboBox boxLinea) {
		this.boxLinea = boxLinea;
	}

	public JCalendar getCalendar() {
		return calendar;
	}

	public void setCalendar(JCalendar mes) {
		this.calendar = mes;
	}

	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}

	public void setBtnSiguiente(JButton btnSiguiente) {
		this.btnSiguiente = btnSiguiente;
	}

	public JLabel getLblImagen() {
		return lblImagen;
	}

	public void setLblImagen(JLabel lblImagen) {
		this.lblImagen = lblImagen;
	}
	
}
