package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Resumen extends JFrame {

	private JPanel contentPane;
	
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

	public Resumen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Linea = new JLabel("Linea");
		Linea.setFont(new Font("Tahoma", Font.BOLD, 20));
		Linea.setBounds(60, 40, 62, 25);
		contentPane.add(Linea);

		JLabel Origen = new JLabel("Origen - Destino");
		Origen.setFont(new Font("Tahoma", Font.BOLD, 20));
		Origen.setBounds(268, 40, 185, 25);
		contentPane.add(Origen);

		JLabel TipoViaje = new JLabel("Tipo de viaje");
		TipoViaje.setFont(new Font("Tahoma", Font.BOLD, 20));
		TipoViaje.setBounds(545, 40, 142, 25);
		contentPane.add(TipoViaje);

		JLabel Fecha = new JLabel("Fecha");
		Fecha.setFont(new Font("Tahoma", Font.BOLD, 20));
		Fecha.setBounds(60, 166, 62, 25);
		contentPane.add(Fecha);

		JLabel Hora = new JLabel("Hora");
		Hora.setFont(new Font("Tahoma", Font.BOLD, 20));
		Hora.setBounds(303, 166, 62, 25);
		contentPane.add(Hora);

		JLabel Precio = new JLabel("Precio");
		Precio.setFont(new Font("Tahoma", Font.BOLD, 20));
		Precio.setBounds(574, 166, 77, 25);
		contentPane.add(Precio);

		JLabel NumeroTickets = new JLabel("Numero de tiquets :");
		NumeroTickets.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NumeroTickets.setBounds(135, 311, 185, 25);
		contentPane.add(NumeroTickets);

		JLabel respuestaLinea = new JLabel("Bilbao-San Sebastian");
		respuestaLinea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		respuestaLinea.setBounds(27, 95, 156, 25);
		contentPane.add(respuestaLinea);

		JLabel respuestaOrigen = new JLabel("Sondika-Derio");
		respuestaOrigen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		respuestaOrigen.setBounds(270, 95, 156, 25);
		contentPane.add(respuestaOrigen);

		JLabel respuestaTipoViaje = new JLabel("Ida y Vuelta");
		respuestaTipoViaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		respuestaTipoViaje.setBounds(545, 95, 156, 25);
		contentPane.add(respuestaTipoViaje);

		JLabel respuestaFecha = new JLabel("24 Enero 2020");
		respuestaFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		respuestaFecha.setBounds(44, 221, 156, 25);
		contentPane.add(respuestaFecha);

		JLabel respuestaHora = new JLabel("15:30");
		respuestaHora.setFont(new Font("Tahoma", Font.PLAIN, 16));
		respuestaHora.setBounds(303, 221, 52, 25);
		contentPane.add(respuestaHora);

		JLabel respuestaPrecio = new JLabel("28,95\u20AC");
		respuestaPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		respuestaPrecio.setBounds(574, 221, 106, 25);
		contentPane.add(respuestaPrecio);

		JButton Aceptar = new JButton("Aceptar");
		Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Aceptar.setBackground(Color.BLACK);
		Aceptar.setFont(new Font("Tahoma", Font.BOLD, 20));
		Aceptar.setBounds(85, 388, 150, 51);
		contentPane.add(Aceptar);

		JButton Cancelar = new JButton("Cancelar");
		Cancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		Cancelar.setBounds(286, 388, 150, 51);
		contentPane.add(Cancelar);

		JButton Modificar = new JButton("Modificar");
		Modificar.setFont(new Font("Tahoma", Font.BOLD, 20));
		Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Modificar.setBounds(487, 388, 150, 51);
		contentPane.add(Modificar);

		JComboBox respuestaNumeroTiquet = new JComboBox();
		respuestaNumeroTiquet.setMaximumRowCount(50);
		respuestaNumeroTiquet.setBackground(Color.LIGHT_GRAY);
		respuestaNumeroTiquet.setBounds(339, 311, 185, 25);
		contentPane.add(respuestaNumeroTiquet);
		
		JButton Retroceso = new JButton("<-\r\n");
		Retroceso.setSelectedIcon(new ImageIcon(Resumen.class.getResource("/imagenes/blanco.jpg")));
		Retroceso.setForeground(Color.BLACK);
		Retroceso.setBackground(Color.BLACK);
		Retroceso.setFont(new Font("Tahoma", Font.BOLD, 14));
		Retroceso.setBounds(0, 422, 49, 39);
		contentPane.add(Retroceso);
	}
}
