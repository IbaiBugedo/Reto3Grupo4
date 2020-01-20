package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Bienvenida extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenida frame = new Bienvenida();
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
	public Bienvenida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ongiEtorri = new JLabel("Ongi Etorri");
		ongiEtorri.setFont(new Font("Tahoma", Font.PLAIN, 48));
		ongiEtorri.setBounds(248, 68, 237, 67);
		contentPane.add(ongiEtorri);
		
		JLabel Bienvenido = new JLabel("Bienvenido");
		Bienvenido.setFont(new Font("Tahoma", Font.PLAIN, 48));
		Bienvenido.setBounds(248, 300, 237, 67);
		contentPane.add(Bienvenido);
		
		JLabel logoTermibus = new JLabel("");
		logoTermibus.setIcon(new ImageIcon(Bienvenida.class.getResource("/imagenes/logo-termibus.png")));
		logoTermibus.setBounds(213, 146, 301, 125);
		contentPane.add(logoTermibus);
	}
}
