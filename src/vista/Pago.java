package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Pago extends JFrame {

	
	JFrame ventanaPago;
	private JPanel contentPane;
	private double [] dinero=new double[]{0.05,0.10,0.20,0.50,1.00,2.00,5.00,10.00,20.00,50.00};
	private JButton Introducir;
	private JButton Cancelar;
	private JTextField txfTotalAPagar;
	private JTextField txfImporteIntroducido;
	private JTextField txfImporteRestante;
	private JComboBox boxImporte;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pago frame = new Pago();
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
	public Pago() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox BoxImporte = new JComboBox();
		for(int contador=0;contador <dinero.length;contador++) {
		BoxImporte.addItem(dinero[contador]);
		}
		BoxImporte.setBounds(441, 288, 148, 32);
		contentPane.add(BoxImporte);
		
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
		
		JButton button = new JButton("Introducir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 35));
		button.setBounds(148, 336, 189, 66);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		button_1.setBounds(415, 336, 189, 66);
		contentPane.add(button_1);
		
		txfTotalAPagar = new JTextField();
		txfTotalAPagar.setBounds(441, 71, 148, 32);
		contentPane.add(txfTotalAPagar);
		txfTotalAPagar.setColumns(10);
		
		txfImporteIntroducido = new JTextField();
		txfImporteIntroducido.setBounds(441, 139, 148, 32);
		contentPane.add(txfImporteIntroducido);
		txfImporteIntroducido.setColumns(10);
		
		txfImporteRestante = new JTextField();
		txfImporteRestante.setBounds(441, 207, 148, 32);
		contentPane.add(txfImporteRestante);
		txfImporteRestante.setColumns(10);
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
	
	public JTextField getTxfTotalAPagar() {
		return txfTotalAPagar;
	}

	public void setTxfTotalAPagar(JTextField txfTotalAPagar) {
		this.txfTotalAPagar = txfTotalAPagar;
	}

	public JTextField getTxfImporteIntroducido() {
		return txfImporteIntroducido;
	}

	public void setTxfImporteIntroducido(JTextField txfImporteIntroducido) {
		this.txfImporteIntroducido = txfImporteIntroducido;
	}

	public JTextField getTxfImporteRestante() {
		return txfImporteRestante;
	}

	public void setTxfImporteRestante(JTextField txfImporteRestante) {
		this.txfImporteRestante = txfImporteRestante;
	}

	public JComboBox getBoxImporte() {
		return boxImporte;
	}

	public void setBoxImporte(JComboBox boxImporte) {
		this.boxImporte = boxImporte;
	}
}
