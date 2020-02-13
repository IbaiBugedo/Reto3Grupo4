package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField respuestaNombre;
	private JTextField respuestaApellido;
	private JTextField respuestaDNI;
	private JComboBox respuestaSexo;
	private JButton btnRegistro;
	private JButton btnCancelar;
	private JButton btnAtras;
	private JPasswordField respuestaContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		mCrearPanelContenedor();
		mCrearJLabel();
		mCrearJComboBox();
		mCrearJButton();
		mCrearJTextField();
	}
	private void mCrearPanelContenedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	private void mCrearJLabel(){
		
		JLabel label = new JLabel("Registro");
		label.setFont(new Font("Tahoma", Font.PLAIN, 48));
		label.setBounds(244, 11, 204, 57);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Nombre:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_1.setBounds(37, 96, 116, 25);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Apellido:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_2.setBounds(359, 96, 116, 25);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("DNI:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_3.setBounds(37, 211, 71, 25);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Sexo:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_4.setBounds(359, 211, 82, 25);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Contrase\u00F1a:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_5.setBounds(37, 310, 166, 25);
		contentPane.add(label_5);
		
	}

	private void mCrearJButton() {
		btnRegistro = new JButton("Registrarse");
		btnRegistro.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegistro.setBackground(Color.LIGHT_GRAY);
		btnRegistro.setBounds(84, 368, 150, 51);
		contentPane.add(btnRegistro);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setBounds(291, 368, 150, 51);
		contentPane.add(btnCancelar);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAtras.setBackground(Color.LIGHT_GRAY);
		btnAtras.setBounds(501, 368, 150, 51);
		contentPane.add(btnAtras);
	}

	private void mCrearJComboBox() {
		respuestaSexo = new JComboBox();
		respuestaSexo.setModel(new DefaultComboBoxModel(new String[] {"Otro", "Hombre", "Mujer"}));
		respuestaSexo.setToolTipText("");
		respuestaSexo.setMaximumRowCount(50);
		respuestaSexo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		respuestaSexo.setBounds(451, 211, 130, 25);
		contentPane.add(respuestaSexo);
	}
	
	private void mCrearJTextField() {
		respuestaNombre = new JTextField();
		respuestaNombre.setColumns(10);
		respuestaNombre.setBounds(163, 96, 166, 25);
		contentPane.add(respuestaNombre);
		
		
		
		respuestaApellido = new JTextField();
		respuestaApellido.setColumns(10);
		respuestaApellido.setBounds(485, 96, 166, 25);
		contentPane.add(respuestaApellido);
		
		
		
		respuestaDNI = new JTextField();
		respuestaDNI.setColumns(10);
		respuestaDNI.setBounds(111, 211, 202, 25);
		contentPane.add(respuestaDNI);
		
		respuestaContrasena = new JPasswordField();
		respuestaContrasena.setBounds(213, 310, 252, 25);
		contentPane.add(respuestaContrasena);
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

	public void setRespuestaContrasena(JPasswordField respuestaContrasena) {
		this.respuestaContrasena = respuestaContrasena;
	}

	public JComboBox getRespuestaSexo() {
		return respuestaSexo;
	}

	public void setRespuestaSexo(JComboBox respuestaSexo) {
		this.respuestaSexo = respuestaSexo;
	}

	public JButton getBtnRegistro() {
		return btnRegistro;
	}

	public void setBtnRegistro(JButton btnRegistro) {
		this.btnRegistro = btnRegistro;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JButton getBtnAtras() {
		return btnAtras;
	}

	public void setBtnAtras(JButton btnAtras) {
		this.btnAtras = btnAtras;
	}
	
	
}
