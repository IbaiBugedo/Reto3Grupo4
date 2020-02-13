package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class Resumen extends JFrame {

	public static enum enumAcciones{
		SIGUIENTE_PAGINA,
		CANCELAR_COMPRA,
		MODIFICAR_COMPRA,
		PAGINA_ANTERIOR
	}
	private JPanel contentPane;
	private JLabel lblLinea,
	lblOrigenDestino,
	lblTipoViaje,
	lblFecha,
	lblHora,
	lblPrecio;
	private JButton btnRetroceso,
	btnCancelar,
	btnModificar,
	btnAceptar;
	private JComboBox boxNumeroTiquets;
	private JLabel lblHoraVuelta;
	private JLabel lblFechaVuelta;
	public Resumen() {
		
		mCrearJFrame();
		mCrearJLabel();
		mCrearJButton();
		mCrearJComboBox();
		
		
	}
	
	private void mCrearJFrame(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	private void mCrearJLabel() {
		
		JLabel lblLnea = new JLabel("L\u00EDnea");
		lblLnea.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLnea.setBounds(79, 40, 62, 25);
		contentPane.add(lblLnea);
		
		JLabel label_1 = new JLabel("Origen - Destino");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(268, 40, 185, 25);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Tipo de viaje");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(545, 40, 142, 25);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Fecha");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(79, 166, 62, 25);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Hora");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBounds(325, 166, 62, 25);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Precio");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_5.setBounds(559, 166, 77, 25);
		contentPane.add(label_5);
		
		JLabel lblNmeroDeTiquets = new JLabel("N\u00FAmero de tickets :");
		lblNmeroDeTiquets.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNmeroDeTiquets.setBounds(135, 311, 185, 25);
		contentPane.add(lblNmeroDeTiquets);
		
		lblLinea = new JLabel("Bilbao-San Sebastian");
		lblLinea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLinea.setBounds(27, 95, 185, 25);
		contentPane.add(lblLinea);
		
		lblOrigenDestino = new JLabel("Sondika-Derio");
		lblOrigenDestino.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrigenDestino.setBounds(222, 95, 373, 25);
		contentPane.add(lblOrigenDestino);
		
		lblTipoViaje = new JLabel("Ida y Vuelta");
		lblTipoViaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoViaje.setBounds(618, 95, 106, 25);
		contentPane.add(lblTipoViaje);
		
		lblFecha = new JLabel("24 Enero 2020");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFecha.setBounds(44, 202, 156, 25);
		contentPane.add(lblFecha);
		
		lblHora = new JLabel("15:30");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHora.setBounds(297, 202, 156, 25);
		contentPane.add(lblHora);
		
		lblPrecio = new JLabel("28,95\u20AC");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrecio.setBounds(559, 221, 106, 25);
		contentPane.add(lblPrecio);
		
		lblHoraVuelta = new JLabel("15:30");
		lblHoraVuelta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHoraVuelta.setBounds(297, 245, 156, 25);
		contentPane.add(lblHoraVuelta);
		
		lblFechaVuelta = new JLabel("24 Enero 2020");
		lblFechaVuelta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaVuelta.setBounds(44, 245, 156, 25);
		contentPane.add(lblFechaVuelta);
	}
	
	private void mCrearJButton() {
		btnRetroceso = new JButton("<-\r\n");
		btnRetroceso.setForeground(Color.BLACK);
		btnRetroceso.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRetroceso.setBackground(Color.LIGHT_GRAY);
		btnRetroceso.setBounds(0, 422, 62, 39);
		contentPane.add(btnRetroceso);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBounds(286, 388, 150, 51);
		contentPane.add(btnCancelar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBackground(Color.LIGHT_GRAY);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnModificar.setBounds(487, 388, 150, 51);
		contentPane.add(btnModificar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAceptar.setBackground(Color.LIGHT_GRAY);
		btnAceptar.setBounds(85, 388, 150, 51);
		contentPane.add(btnAceptar);
	}
	
	private void mCrearJComboBox() {
		boxNumeroTiquets = new JComboBox();
		boxNumeroTiquets.setMaximumRowCount(50);
		boxNumeroTiquets.setBackground(Color.LIGHT_GRAY);
		boxNumeroTiquets.setBounds(339, 311, 185, 25);
		boxNumeroTiquets.setPrototypeDisplayValue(true);	
		boxNumeroTiquets.setMaximumRowCount(8);
		contentPane.add(boxNumeroTiquets);
		

	}

	//
	public JLabel getLblLinea() {
		return lblLinea;
	}

	public void setLblLinea(JLabel lblLinea) {
		this.lblLinea = lblLinea;
	}

	public JLabel getLblOrigenDestino() {
		return lblOrigenDestino;
	}

	public void setLblOrigenDestino(JLabel lblOrigenDestino) {
		this.lblOrigenDestino = lblOrigenDestino;
	}

	public JLabel getLblTipoViaje() {
		return lblTipoViaje;
	}

	public void setLblTipoViaje(JLabel lblTipoViaje) {
		this.lblTipoViaje = lblTipoViaje;
	}


	public JLabel getLblHoraVuelta() {
		return lblHoraVuelta;
	}

	public void setLblHoraVuelta(JLabel lblHoraVuelta) {
		this.lblHoraVuelta = lblHoraVuelta;
	}

	public JLabel getLblFechaVuelta() {
		return lblFechaVuelta;
	}

	public void setLblFechaVuelta(JLabel lblFechaVuelta) {
		this.lblFechaVuelta = lblFechaVuelta;
	}

	public JLabel getLblFecha() {
		return lblFecha;
	}

	public void setLblFecha(JLabel lblFecha) {
		this.lblFecha = lblFecha;
	}

	public JLabel getLblHora() {
		return lblHora;
	}

	public void setLblHora(JLabel lblHora) {
		this.lblHora = lblHora;
	}

	public JLabel getLblPrecio() {
		return lblPrecio;
	}

	public void setLblPrecio(JLabel lblPrecio) {
		this.lblPrecio = lblPrecio;
	}

	public JButton getBtnRetroceso() {
		return btnRetroceso;
	}

	public void setBtnRetroceso(JButton btnRetroceso) {
		this.btnRetroceso = btnRetroceso;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public JComboBox getBoxNumeroTiquets() {
		return boxNumeroTiquets;
	}

	public void setBoxNumeroTiquets(JComboBox boxNumeroTiquets) {
		this.boxNumeroTiquets = boxNumeroTiquets;
	}
}
