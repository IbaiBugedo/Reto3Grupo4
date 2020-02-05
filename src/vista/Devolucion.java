package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Devolucion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Devolucion frame = new Devolucion();
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
	public Devolucion() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Cambios = new JLabel("Cambios");
		Cambios.setFont(new Font("Tahoma", Font.PLAIN, 68));
		Cambios.setBounds(212, 11, 285, 72);
		contentPane.add(Cambios);
		
		JPanel panelCambios = new JPanel();
		panelCambios.setBackground(SystemColor.control);
		panelCambios.setBounds(196, 169, 310, 264);
		contentPane.add(panelCambios);
		
		JLabel RecojaSusCambios = new JLabel("Recoja sus cambios porfavor");
		RecojaSusCambios.setFont(new Font("Tahoma", Font.PLAIN, 23));
		RecojaSusCambios.setBounds(196, 122, 301, 28);
		contentPane.add(RecojaSusCambios);
	}
}
