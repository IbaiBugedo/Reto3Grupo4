package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Fin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fin frame = new Fin();
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
	public Fin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel GraciasPorSu = new JLabel("Gracias por su");
		GraciasPorSu.setFont(new Font("Tahoma", Font.PLAIN, 74));
		GraciasPorSu.setBounds(107, 52, 494, 72);
		contentPane.add(GraciasPorSu);
		
		JLabel CompraSu = new JLabel("compra su");
		CompraSu.setFont(new Font("Tahoma", Font.PLAIN, 74));
		CompraSu.setBounds(107, 135, 438, 78);
		contentPane.add(CompraSu);
		
		JLabel SesionASido = new JLabel("sesion ha sido");
		SesionASido.setFont(new Font("Tahoma", Font.PLAIN, 74));
		SesionASido.setBounds(107, 224, 590, 78);
		contentPane.add(SesionASido);
		
		JLabel Cerrada = new JLabel("cerrada");
		Cerrada.setFont(new Font("Tahoma", Font.PLAIN, 74));
		Cerrada.setBounds(107, 313, 309, 78);
		contentPane.add(Cerrada);
	}
}
