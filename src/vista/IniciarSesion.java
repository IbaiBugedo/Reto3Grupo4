package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class IniciarSesion extends JFrame {

	private JPanel contentPane;
	private JTextField respuestaDNI;
	private JTextField respuestaContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IniciarSesion frame = new IniciarSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IniciarSesion() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel iniciarSesion = new JLabel("Iniciar Sesion");
		iniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 60));
		iniciarSesion.setBounds(149, 11, 442, 92);
		contentPane.add(iniciarSesion);
		
		JLabel DNI = new JLabel("DNI:");
		DNI.setFont(new Font("Tahoma", Font.PLAIN, 50));
		DNI.setBounds(54, 130, 108, 61);
		contentPane.add(DNI);
		
		JLabel Contrasena = new JLabel("Contrase\u00F1a:");
		Contrasena.setFont(new Font("Tahoma", Font.PLAIN, 50));
		Contrasena.setBounds(54, 239, 269, 61);
		contentPane.add(Contrasena);
		
		respuestaDNI = new JTextField();
		respuestaDNI.setBounds(193, 130, 462, 61);
		contentPane.add(respuestaDNI);
		respuestaDNI.setColumns(10);
		
		respuestaContrasena = new JTextField();
		respuestaContrasena.setColumns(10);
		respuestaContrasena.setBounds(323, 239, 332, 61);
		contentPane.add(respuestaContrasena);
		
		JButton botonRetroceso = new JButton("<-\r\n");
		botonRetroceso.setForeground(Color.BLACK);
		botonRetroceso.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonRetroceso.setBackground(Color.BLACK);
		botonRetroceso.setBounds(0, 422, 49, 39);
		contentPane.add(botonRetroceso);
		
		JButton botonIniciarSesion = new JButton("Iniciar Sesion");
		botonIniciarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		botonIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 20));
		botonIniciarSesion.setBackground(Color.BLACK);
		botonIniciarSesion.setBounds(90, 384, 171, 51);
		contentPane.add(botonIniciarSesion);
		
		JButton botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 20));
		botonRegistrarse.setBackground(Color.BLACK);
		botonRegistrarse.setBounds(303, 384, 150, 51);
		contentPane.add(botonRegistrarse);
		
		JButton botonCancelar = new JButton("Cancelar\r\n");
		botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		botonCancelar.setBackground(Color.BLACK);
		botonCancelar.setBounds(505, 384, 150, 51);
		contentPane.add(botonCancelar);
	}
}
