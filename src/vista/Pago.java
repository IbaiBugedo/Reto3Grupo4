package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;

public class Pago extends JFrame {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket frame = new Ticket();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JPanel contentPane;
	public String [] monedas = {"0,05\u20AC","0,10\u20AC", "0,20\u20AC", "0,50\u20AC", "1,00\u20AC", "2,00\u20AC", "5,00\u20AC", "10,00\u20AC", "20,00\u20AC", "50,00\u20AC"};
	public Pago() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel TotalAPagar = new JLabel("Total a pagar:");
		TotalAPagar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		TotalAPagar.setBounds(136, 52, 189, 57);
		contentPane.add(TotalAPagar);
		
		JLabel ImporteIntroducido = new JLabel("Importe introducido:");
		ImporteIntroducido.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ImporteIntroducido.setBounds(136, 127, 283, 57);
		contentPane.add(ImporteIntroducido);
		
		JLabel ImporteRestante = new JLabel("Importe restante:");
		ImporteRestante.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ImporteRestante.setBounds(136, 204, 246, 57);
		contentPane.add(ImporteRestante);
		
		JLabel IntroducirImporte = new JLabel("Introducir importe:");
		IntroducirImporte.setFont(new Font("Tahoma", Font.PLAIN, 30));
		IntroducirImporte.setBounds(136, 285, 258, 57);
		contentPane.add(IntroducirImporte);
		
		JButton Introducir = new JButton("Introducir");
		Introducir.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Introducir.setBounds(136, 353, 189, 66);
		contentPane.add(Introducir);
		
		JButton Cancelar = new JButton("Cancelar");
		Cancelar.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Cancelar.setBounds(403, 353, 189, 66);
		contentPane.add(Cancelar);
		
		JPanel respuestaTotalPagar = new JPanel();
		FlowLayout flowLayout = (FlowLayout) respuestaTotalPagar.getLayout();
		respuestaTotalPagar.setBounds(436, 66, 106, 46);
		contentPane.add(respuestaTotalPagar);
		
		JPanel respuestaTotalIntroducido = new JPanel();
		respuestaTotalIntroducido.setBounds(436, 138, 106, 46);
		contentPane.add(respuestaTotalIntroducido);
		
		JPanel respuestaTotalRestante = new JPanel();
		respuestaTotalRestante.setBounds(436, 215, 106, 46);
		contentPane.add(respuestaTotalRestante);
		
		JComboBox monedasBilletes = new JComboBox();
		monedasBilletes.setModel(new DefaultComboBoxModel(monedas));
		monedasBilletes.setBounds(436, 305, 106, 32);
		contentPane.add(monedasBilletes);
	}

}
