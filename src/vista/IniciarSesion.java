package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class IniciarSesion extends JFrame {

	public static enum enumAcciones{
		SIGUIENTE_PAGINA,
		PAGINA_REGISTRO, 
		CANCELAR, 
		RETROCESO, 
		RESPUESTA_DNI,
		RESPUESTA_CONTRASENA	
	}
	private JPanel contentPane;
	private JTextField respuestaDNI;
	private JPasswordField respuestaContrasena;
	private JButton btnRetroceso;
	private JButton btnIniciarSesion;
	private JButton btnRegistrarse;
	private JButton btnCancelar;
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

	public IniciarSesion() {
		mCrearPanelContenedor();
		mCrearJButton();
		mCrearJLabel();
		mCrearJTextField();

	}
	private void mCrearPanelContenedor() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane =  new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	private void mCrearJTextField() {
		respuestaDNI = new JTextField();
		respuestaDNI.setBounds(193, 130, 462, 61);
		contentPane.add(respuestaDNI);
		respuestaDNI.setColumns(10);
		
		respuestaContrasena = new JPasswordField();
		respuestaContrasena.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
			}
		});
		respuestaContrasena.setColumns(10);
		respuestaContrasena.setBounds(323, 239, 332, 61);
		contentPane.add(respuestaContrasena);
			
	}
	
	private void mCrearJLabel() {
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
	}
	
	private void mCrearJButton() {
		btnRetroceso = new JButton("<-\r\n");
		btnRetroceso.setForeground(Color.BLACK);
		btnRetroceso.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRetroceso.setBackground(Color.LIGHT_GRAY);
		btnRetroceso.setBounds(0, 422, 49, 39);
		contentPane.add(btnRetroceso);
		
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		btnIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnIniciarSesion.setBackground(Color.LIGHT_GRAY);
		btnIniciarSesion.setBounds(94, 384, 171, 51);
		contentPane.add(btnIniciarSesion);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegistrarse.setBackground(Color.LIGHT_GRAY);
		btnRegistrarse.setBounds(303, 384, 150, 51);
		contentPane.add(btnRegistrarse);
		
		btnCancelar = new JButton("Cancelar\r\n");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setBounds(505, 384, 150, 51);
		contentPane.add(btnCancelar);
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

	public void setRespuestaContrasena(JPasswordField respuestaContrasena) {
		this.respuestaContrasena = respuestaContrasena;
	}

	public JButton getBtnRetroceso() {
		return btnRetroceso;
	}

	public void setBtnRetroceso(JButton btnRetroceso) {
		this.btnRetroceso = btnRetroceso;
	}

	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	public void setBtnIniciarSesion(JButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}

	public JButton getBtnRegistrarse() {
		return btnRegistrarse;
	}

	public void setBtnRegistrarse(JButton btnRegistrarse) {
		this.btnRegistrarse = btnRegistrarse;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
	
	
}
