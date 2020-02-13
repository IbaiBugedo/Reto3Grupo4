package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Component;

import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class MenuOrigenDestino extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JComboBox boxDestino;
	private JComboBox boxOrigen;
	private JComboBox boxHora;
	private JButton btnSiguiente;
	private JButton btnIda;
	private JButton btnIdaVuelta;
	private JButton btnRetroceso;
	private JLabel lblImagen;


	public MenuOrigenDestino() {
		
		mCrearPanelContenedor();
		mCrearJComboBox();
		mCrearJLabel();
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
	
	private void mCrearJComboBox() {
		boxHora = new JComboBox();
		boxHora.setFont(new Font("Tahoma", Font.PLAIN, 24));
		boxHora.setModel(new DefaultComboBoxModel(new String[] {"Seleccione Hora"}));
		boxHora.setBounds(520, 59, 194, 40);
		contentPane.add(boxHora);
		
		
		boxOrigen = new JComboBox();
		boxOrigen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		boxOrigen.setModel(new DefaultComboBoxModel(new String[] {"Seleccione Origen"}));
		boxOrigen.setBounds(24, 59, 218, 40);
		contentPane.add(boxOrigen);
		
		
		boxDestino = new JComboBox();
		boxDestino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		boxDestino.setModel(new DefaultComboBoxModel(new String[] {"Seleccione Destino"}));
		boxDestino.setBounds(270, 59, 218, 40);
		contentPane.add(boxDestino);
	}
	
	private void mCrearJButton() {
		
		btnRetroceso = new JButton("<-\r\n");
		btnRetroceso.setForeground(Color.BLACK);
		btnRetroceso.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRetroceso.setBackground(Color.LIGHT_GRAY);
		btnRetroceso.setBounds(5, 416, 62, 39);
		contentPane.add(btnRetroceso);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setEnabled(false);
		btnSiguiente.setBounds(631, 426, 97, 29);
		contentPane.add(btnSiguiente);
		
	}

	
	private void mCrearJTable() {
		
		btnIda = new JButton("Ida");
		btnIda.setBounds(519, 122, 97, 29);
		contentPane.add(btnIda);
		
		btnIdaVuelta = new JButton("Ida y Vuelta");
		btnIdaVuelta.setBounds(632, 122, 97, 29);
		contentPane.add(btnIdaVuelta);
		
		lblImagen = new JLabel("");
		lblImagen.setVerticalAlignment(SwingConstants.TOP);
		lblImagen.setBounds(5, 160, 723, 295);
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

	public JButton getBtnIda() {
		return btnIda;
	}


	public void setBtnIda(JButton btnIda) {
		this.btnIda = btnIda;
	}


	public JButton getBtnIdaVuelta() {
		return btnIdaVuelta;
	}


	public void setBtnIdaVuelta(JButton btnIdaVuelta) {
		this.btnIdaVuelta = btnIdaVuelta;
	}


	private void mCrearJLabel() {
	}

	public JComboBox getBoxDestino() {
		return boxDestino;
	}

	public void setBoxDestino(JComboBox boxDestino) {
		this.boxDestino = boxDestino;
	}

	public JComboBox getBoxOrigen() {
		return boxOrigen;
	}

	public void setBoxOrigen(JComboBox boxOrigen) {
		this.boxOrigen = boxOrigen;
	}

	public JComboBox getBoxHora() {
		return boxHora;
	}

	public void setBoxHora(JComboBox boxHora) {
		this.boxHora = boxHora;
	}

	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}

	public void setBtnSiguiente(JButton btnSiguiente) {
		this.btnSiguiente = btnSiguiente;
	}
	
	public JButton getBtnRetroceso() {
		return btnRetroceso;
	}

	public void setBtnRetroceso(JButton btnRetroceso) {
		this.btnRetroceso = btnRetroceso;
	}

	public JLabel getLblImagen() {
		return lblImagen;
	}

	public void setLblImagen(JLabel lblImagen) {
		this.lblImagen = lblImagen;
	}
	
}
