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
import javax.swing.JTextArea;

public class Devolucion extends JFrame {

	private JPanel contentPane;
	private JLabel RecojaSusCambios;
	private JPanel panelCambios2;
	private JTextArea panelCambios;

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
		
		panelCambios2 = new JPanel();
		panelCambios2.setBackground(SystemColor.control);
		panelCambios2.setBounds(196, 169, 310, 264);
		contentPane.add(panelCambios2);
		panelCambios2.setLayout(null);
		
		panelCambios = new JTextArea();
		panelCambios.setBounds(0, 0, 310, 264);
		panelCambios2.add(panelCambios);
		
		RecojaSusCambios = new JLabel("Recoja sus cambios por favor");
		RecojaSusCambios.setFont(new Font("Tahoma", Font.PLAIN, 23));
		RecojaSusCambios.setBounds(196, 122, 301, 28);
		contentPane.add(RecojaSusCambios);
	}

	public JLabel getRecojaSusCambios() {
		return RecojaSusCambios;
	}

	public void setRecojaSusCambios(JLabel recojaSusCambios) {
		RecojaSusCambios = recojaSusCambios;
	}

	public JTextArea getPanelCambios() {
		return panelCambios;
	}

	public void setPanelCambios(JTextArea panelCambios) {
		this.panelCambios = panelCambios;
	}
}
