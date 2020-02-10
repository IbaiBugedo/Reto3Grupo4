package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controlador.ControladorResumen;

public class Bienvenida extends JFrame {

	public static enum enumAcciones{
		CONTINUAR
	}
	public JPanel PanelBienvenida;


	public Bienvenida() {
		mCrearPanelContenedor();
		mCrearJLabel();
		
	}
	
	private void mCrearPanelContenedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		PanelBienvenida = new JPanel();
		PanelBienvenida.setBackground(Color.WHITE);
		PanelBienvenida.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelBienvenida);
		PanelBienvenida.setLayout(null);
	}
	
	private void mCrearJLabel() {
	JLabel ongiEtorri = new JLabel("Ongi Etorri");
		ongiEtorri.setFont(new Font("Tahoma", Font.PLAIN, 48));
		ongiEtorri.setBounds(248, 68, 237, 67);
		PanelBienvenida.add(ongiEtorri);
		
		JLabel Bienvenido = new JLabel("Bienvenido");
		Bienvenido.setFont(new Font("Tahoma", Font.PLAIN, 48));
		Bienvenido.setBounds(248, 300, 237, 67);
		PanelBienvenida.add(Bienvenido);
		
		JLabel logoTermibus = new JLabel("");
		logoTermibus.setIcon(new ImageIcon(Bienvenida.class.getResource("/imagenes/logo-termibus.png")));
		logoTermibus.setBounds(213, 146, 301, 125);
		PanelBienvenida.add(logoTermibus);

	}
	
	public JPanel getPanelBienvenida() {
		return PanelBienvenida;
	}
}
