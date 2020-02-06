package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

import javax.swing.JTextField;
import java.awt.Font;
import java.util.logging.Logger;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Alerta extends JFrame {

	private JPanel contentPane;
	private JTextArea txtAlert;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Alerta(int cod_Alerta) {
	
		mCrearPanelContenedor();
		mCrearJLabel(); 
		switch (cod_Alerta) {
		case 1:
			txtAlert.setText("");
			break;
		case 2:
			txtAlert.setText("La longitud debe estar entre 8 y 9");
			break;
		case 3:
			txtAlert.setText("La parte numerica del DNI debe ser un numero");
			break;
		case 4:
			txtAlert.setText("La parte de la letra del DNI debe ser una letra entre A y Z");
			break;
		case 5:
			txtAlert.setText("El DNI es incorrecto");
			break;
		}
		
       

		
	}
	private void mCrearPanelContenedor(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 265, 164);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private void mCrearJLabel(){
		
		txtAlert = new JTextArea();
		txtAlert.setFont(new Font("Monospaced", Font.PLAIN, 19));
		txtAlert.setLineWrap(true);
		txtAlert.setText("este es el texto por defecto");
		txtAlert.setBounds(10, 11, 229, 114);
		txtAlert.setWrapStyleWord(true);
		contentPane.add(txtAlert);
	}
	public JTextArea getTxtAlert() {
		return txtAlert;
	}
	public void setTxtAlert(JTextArea txtAlert) {
		this.txtAlert = txtAlert;
	}
	
}
