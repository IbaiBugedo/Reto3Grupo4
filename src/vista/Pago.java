package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorRegistro;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pago extends JFrame {

	
	JFrame ventanaPago;
	private JPanel contentPane;
	private double [] dinero=new double[]{0.05,0.10,0.20,0.50,1.00,2.00,5.00,10.00,20.00,50.00};
	private JButton Introducir;
	private JButton Cancelar;
	private JComboBox boxImporte;
	private JLabel lblAPagar;
	private JLabel lblImporteIntroducido;
	private JLabel lblImporteRestante;
	
	

	public Pago() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		boxImporte = new JComboBox();
		for(int contador=0;contador <dinero.length;contador++) {
		boxImporte.addItem(dinero[contador]);
		}
		boxImporte.setBounds(441, 288, 148, 32);
		contentPane.add(boxImporte);
		
		JLabel label = new JLabel("Total a pagar:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label.setBounds(148, 51, 189, 57);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Importe introducido:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_1.setBounds(148, 119, 283, 57);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Importe restante:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_2.setBounds(148, 187, 246, 57);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Introducir importe:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_3.setBounds(148, 268, 258, 57);
		contentPane.add(label_3);
		
		Introducir = new JButton("Introducir");
		Introducir.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Introducir.setBounds(148, 336, 189, 66);
		contentPane.add(Introducir);
		
		Cancelar = new JButton("Cancelar");
		Cancelar.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Cancelar.setBounds(415, 336, 189, 66);
		contentPane.add(Cancelar);
		
		lblAPagar = new JLabel("");
		lblAPagar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAPagar.setBounds(441, 68, 163, 26);
		contentPane.add(lblAPagar);
		
		lblImporteIntroducido = new JLabel("0");
		lblImporteIntroducido.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblImporteIntroducido.setBounds(441, 130, 148, 32);
		contentPane.add(lblImporteIntroducido);
		
		lblImporteRestante = new JLabel("30");
		lblImporteRestante.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblImporteRestante.setBounds(441, 199, 163, 26);
		contentPane.add(lblImporteRestante);
	}

	
	
	// ********** METODOS GET Y SET ********** // 
		
	public JFrame getVentanaPago() {
		return ventanaPago;
	}

	public void setVentanaPago(JFrame ventanaPago) {
		this.ventanaPago = ventanaPago;
	}

	public double[] getDinero() {
		return dinero;
	}

	public void setDinero(double[] dinero) {
		this.dinero = dinero;
	}

	public JButton getIntroducir() {
		return Introducir;
	}

	public void setIntroducir(JButton introducir) {
		Introducir = introducir;
	}

	public JButton getCancelar() {
		return Cancelar;
	}

	public void setCancelar(JButton cancelar) {
		Cancelar = cancelar;
	}

	public JComboBox getBoxImporte() {
		return boxImporte;
	}

	public void setBoxImporte(JComboBox boxImporte) {
		this.boxImporte = boxImporte;
	}

	public JLabel getLblAPagar() {
		return lblAPagar;
	}

	public void setLblAPagar(JLabel lblAPagar) {
		this.lblAPagar = lblAPagar;
	}

	public JLabel getLblImporteIntroducido() {
		return lblImporteIntroducido;
	}

	public void setLblImporteIntroducido(JLabel lblImporteIntroducido) {
		this.lblImporteIntroducido = lblImporteIntroducido;
	}

	public JLabel getLblImporteRestante() {
		return lblImporteRestante;
	}

	public void setLblImporteRestante(JLabel lblImporteRestante) {
		this.lblImporteRestante = lblImporteRestante;
	}
	
	
}
