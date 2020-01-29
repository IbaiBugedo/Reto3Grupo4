package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorRegistro;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	JFrame ventanaRegistro;
	private JPanel contentPane;
	private JTextField respuestaNombre;
	private JTextField respuestaApellido;
	private JTextField respuestaDNI;
	private JTextField respuestaContrasena;
	private JComboBox respuestaSexo;
	
	private JButton Registrarse;
	private JButton Cancelar;
	private JButton Atras;
	




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
					
					ControladorRegistro controladorRegistro = new ControladorRegistro(frame); 
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	
	/**
	 * Create the frame.
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Registro = new JLabel("Registro");
		Registro.setFont(new Font("Tahoma", Font.PLAIN, 48));
		Registro.setBounds(252, 11, 204, 57);
		contentPane.add(Registro);
		
		JLabel Nombre = new JLabel("Nombre:");
		Nombre.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Nombre.setBounds(45, 96, 116, 25);
		contentPane.add(Nombre);
		
		respuestaNombre = new JTextField();
		respuestaNombre.setBounds(171, 96, 166, 25);
		contentPane.add(respuestaNombre);
		respuestaNombre.setColumns(10);
		
		JLabel Apellido = new JLabel("Apellido:");
		Apellido.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Apellido.setBounds(367, 96, 116, 25);
		contentPane.add(Apellido);
		
		respuestaApellido = new JTextField();
		respuestaApellido.setColumns(10);
		respuestaApellido.setBounds(493, 96, 166, 25);
		contentPane.add(respuestaApellido);
		
		JLabel Dni = new JLabel("DNI:");
		Dni.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Dni.setBounds(45, 211, 71, 25);
		contentPane.add(Dni);
		
		respuestaDNI = new JTextField();
		respuestaDNI.setColumns(10);
		respuestaDNI.setBounds(119, 211, 202, 25);
		contentPane.add(respuestaDNI);
		
		JLabel Sexo = new JLabel("Sexo:");
		Sexo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Sexo.setBounds(367, 211, 82, 25);
		contentPane.add(Sexo);
		
		respuestaSexo = new JComboBox();
		respuestaSexo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		respuestaSexo.setModel(new DefaultComboBoxModel(new String[] {"Otro", "Hombre", "Mujer"}));
		respuestaSexo.setMaximumRowCount(50);
		respuestaSexo.setToolTipText("");
		respuestaSexo.setBounds(459, 211, 130, 25);
		contentPane.add(respuestaSexo);
		
		JLabel Contrasena = new JLabel("Contrase\u00F1a:");
		Contrasena.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Contrasena.setBounds(45, 310, 166, 25);
		contentPane.add(Contrasena);
		
		respuestaContrasena = new JTextField();
		respuestaContrasena.setColumns(10);
		respuestaContrasena.setBounds(221, 310, 215, 25);
		contentPane.add(respuestaContrasena);
		
		Registrarse = new JButton("Registrarse");
		
		Registrarse.setFont(new Font("Tahoma", Font.BOLD, 20));
		Registrarse.setBackground(Color.LIGHT_GRAY);
		Registrarse.setBounds(92, 368, 150, 51);
		contentPane.add(Registrarse);
		
		Cancelar = new JButton("Cancelar");
		Cancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		Cancelar.setBackground(Color.LIGHT_GRAY);
		Cancelar.setBounds(299, 368, 150, 51);
		contentPane.add(Cancelar);
		Atras.setFont(new Font("Tahoma", Font.BOLD, 20));
		Atras.setBackground(Color.LIGHT_GRAY);
		Atras.setBounds(487, 368, 150, 51);
		contentPane.add(Atras);
	}




	public JFrame getVentanaRegistro() {
		return ventanaRegistro;
	}




	public void setVentanaRegistro(JFrame ventanaRegistro) {
		this.ventanaRegistro = ventanaRegistro;
	}




	public JTextField getRespuestaNombre() {
		return respuestaNombre;
	}




	public void setRespuestaNombre(JTextField respuestaNombre) {
		this.respuestaNombre = respuestaNombre;
	}




	public JTextField getRespuestaApellido() {
		return respuestaApellido;
	}




	public void setRespuestaApellido(JTextField respuestaApellido) {
		this.respuestaApellido = respuestaApellido;
	}




	public JTextField getRespuestaDNI() {
		return respuestaDNI;
	}




	public void setRespuestaDNI(JTextField respuestaDNI) {
		this.respuestaDNI = respuestaDNI;
	}




	public JTextField getRespuestaContrasena() {
		return respuestaContrasena;
	}




	public void setRespuestaContrasena(JTextField respuestaContrasena) {
		this.respuestaContrasena = respuestaContrasena;
	}




	public JComboBox getRespuestaSexo() {
		return respuestaSexo;
	}




	public void setRespuestaSexo(JComboBox respuestaSexo) {
		this.respuestaSexo = respuestaSexo;
	}




	public JButton getRegistrarse() {
		return Registrarse;
	}




	public void setRegistrarse(JButton registrarse) {
		Registrarse = registrarse;
	}




	public JButton getCancelar() {
		return Cancelar;
	}




	public void setCancelar(JButton cancelar) {
		Cancelar = cancelar;
	}




	public JButton getAtras() {
		return Atras;
	}




	public void setAtras(JButton atras) {
		Atras = atras;
	}

	

	
}
