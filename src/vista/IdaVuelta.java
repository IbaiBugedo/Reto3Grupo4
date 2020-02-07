package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class IdaVuelta extends JFrame {

	public static enum enumAcciones{
		CANCELAR, CONFIRMAR
		
	}
	private JPanel contentPane;
	private JCalendar calendar;
	private JComboBox boxHora;
	private JButton btnConfirmar;
	private JButton btnCancelar;

	public IdaVuelta() {
		mCrearPanelContenedor();
		mCrearJButton();
		mCrearJLabel();
		mCrearJComboBox();
		mCrearJCalendar();
		
		
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
	
	private void mCrearJButton() {
		
		calendar = new JCalendar();
		calendar.setBounds(20, 11, 305, 252);
		contentPane.add(calendar);
	
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnConfirmar.setBounds(20, 274, 294, 56);
		contentPane.add(btnConfirmar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnCancelar.setBounds(20, 361, 294, 56);
		contentPane.add(btnCancelar);
	}
	private void mCrearJLabel(){

		JLabel lblNewLabel = new JLabel("Fecha y hora para la vuelta");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(335, 11, 374, 67);
		contentPane.add(lblNewLabel);
	
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(IdaVuelta.class.getResource("/imagenes/logo-termibus.png")));
		lblNewLabel_1.setBounds(357, 233, 301, 142);
		contentPane.add(lblNewLabel_1);			
	}
	
	private void mCrearJComboBox() {
		boxHora = new JComboBox();
		boxHora.setBounds(335, 78, 374, 72);
		contentPane.add(boxHora);
	}
	
	private void mCrearJCalendar(){
	}
	public JCalendar getCalendar() {
		return calendar;
	}
	public void setCalendar(JCalendar calendar) {
		this.calendar = calendar;
	}
	public JComboBox getBoxHora() {
		return boxHora;
	}
	public void setBoxHora(JComboBox boxHora) {
		this.boxHora = boxHora;
	}
	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}
	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	
	
	
}
