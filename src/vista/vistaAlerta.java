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

public class vistaAlerta extends JFrame {

	private JPanel contentPane;
	private JTextArea txtAlert;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public vistaAlerta(int cod_Alerta) {
		mCrearPanelContenedor();
		mCrearJLabel();
	switch (cod_Alerta) {
	case 1:
		txtAlert.setText("Debe introducir un DNI y una contrase\u00F1a valida");
		
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
		
		txtAlert.setBounds(10, 11, 229, 114);
		txtAlert.setWrapStyleWord(true);
		contentPane.add(txtAlert);
	}
}
