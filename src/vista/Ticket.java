package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Ticket extends JFrame {

	public static enum enumAcciones{
		IMPRIMIR, 
		FINALIZAR
	}
	private JPanel contentPane;
	private JTable table,
	table_1,
	table_2,
	table_3,
	table_4,
	table_5,
	table_6,
	table_7,
	table_8,
	table_9,
	table_10,
	table_11,
	table_12;
	private JLabel Nombre,
	Apellido,
	Apellido_1,
	Sexo,
	NBillete,
	respuestaEmpresa,
	respuestaLinea,
	respuestaOrigen,
	respuestaCodigo;
	private JLabel respuestaFechaCompra,
	respuestaFechaSalida,
	respuestaCoste,
	respuestaTipoBillete,
	respuestaNombre,
	respuestaDNI,
	respuestaSexo,
	respuestaApellido,
	respuestaNBillete,
	CosteDeBillete,
	TipoDeBillete,
	respuestaHoraSalida,
	respuestaAutobus2;
	private JButton ImprimirTiquet;
	private JButton Finalizar;
	private JLabel lblHoraVuelta;
	private JLabel lblFechaVuelta;

	public Ticket() {
		mCrearPanelContenedor();
		mCrearJButton();
		mCrearJLabel();
		mCrearJTable();
		

		
	}
	
	private void mCrearPanelContenedor(){
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(1, 0, 1, 1));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	private void mCrearJButton() {
		
		respuestaAutobus2 = new JLabel("");
		respuestaAutobus2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respuestaAutobus2.setBounds(330, 51, 75, 24);
		contentPane.add(respuestaAutobus2);
		

		
		ImprimirTiquet = new JButton("Imprimir ticket");
		ImprimirTiquet.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ImprimirTiquet.setBounds(70, 397, 272, 53);
		contentPane.add(ImprimirTiquet);
		
		Finalizar = new JButton("Finalizar\r\n");
		Finalizar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Finalizar.setBounds(394, 397, 262, 53);
		contentPane.add(Finalizar);
	}
	
	private void mCrearJTable() {
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		table.setBounds(10, 11, 280, 69);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		table_1.setBackground(Color.WHITE);
		table_1.setBounds(287, 11, 155, 69);
		contentPane.add(table_1);
		
		table_2 = new JTable();
		table_2.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		table_2.setBackground(Color.WHITE);
		table_2.setBounds(441, 11, 283, 69);
		contentPane.add(table_2);
		
		table_3 = new JTable();
		table_3.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		table_3.setBackground(Color.WHITE);
		table_3.setBounds(10, 78, 395, 69);
		contentPane.add(table_3);
		
		table_4 = new JTable();
		table_4.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		table_4.setBackground(Color.WHITE);
		table_4.setBounds(403, 78, 321, 69);
		contentPane.add(table_4);
		
		table_5 = new JTable();
		table_5.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		table_5.setBackground(Color.WHITE);
		table_5.setBounds(10, 146, 254, 69);
		contentPane.add(table_5);
		
		table_6 = new JTable();
		table_6.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		table_6.setBackground(Color.WHITE);
		table_6.setBounds(264, 146, 254, 69);
		contentPane.add(table_6);
		
		table_7 = new JTable();
		table_7.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		table_7.setBackground(Color.WHITE);
		table_7.setBounds(513, 146, 211, 69);
		contentPane.add(table_7);
		
		table_8 = new JTable();
		table_8.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		table_8.setBackground(Color.WHITE);
		table_8.setBounds(10, 248, 280, 69);
		contentPane.add(table_8);
		
		table_9 = new JTable();
		table_9.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		table_9.setBackground(Color.WHITE);
		table_9.setBounds(10, 317, 375, 69);
		contentPane.add(table_9);
		
		table_10 = new JTable();
		table_10.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		table_10.setBackground(Color.WHITE);
		table_10.setBounds(287, 248, 155, 69);
		contentPane.add(table_10);
		
		table_11 = new JTable();
		table_11.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		table_11.setBackground(Color.WHITE);
		table_11.setBounds(441, 248, 283, 69);
		contentPane.add(table_11);
		
		table_12 = new JTable();
		table_12.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		table_12.setBackground(Color.WHITE);
		table_12.setBounds(384, 317, 340, 69);
		contentPane.add(table_12);
	}

	private void mCrearJLabel() {
		
		JLabel Empresa = new JLabel("Empresa");
		Empresa.setFont(new Font("Tahoma", Font.BOLD, 14));
		Empresa.setBounds(117, 11, 75, 24);
		contentPane.add(Empresa);
		
		JLabel Linea = new JLabel("Linea");
		Linea.setFont(new Font("Tahoma", Font.BOLD, 14));
		Linea.setBounds(166, 78, 45, 24);
		contentPane.add(Linea);
		
		JLabel OrigenDestino = new JLabel("Origen - Destino");
		OrigenDestino.setFont(new Font("Tahoma", Font.BOLD, 14));
		OrigenDestino.setBounds(493, 81, 121, 24);
		contentPane.add(OrigenDestino);
		
		JLabel CodigoAutobus = new JLabel("Codigo Autobus");
		CodigoAutobus.setFont(new Font("Tahoma", Font.BOLD, 14));
		CodigoAutobus.setBounds(300, 11, 126, 24);
		contentPane.add(CodigoAutobus);
		
		JLabel FechaDeCompra = new JLabel("Fecha de compra");
		FechaDeCompra.setFont(new Font("Tahoma", Font.BOLD, 14));
		FechaDeCompra.setBounds(493, 11, 126, 24);
		contentPane.add(FechaDeCompra);
		
		JLabel FechaDeSalida = new JLabel("Fecha de salida");
		FechaDeSalida.setFont(new Font("Tahoma", Font.BOLD, 14));
		FechaDeSalida.setBounds(70, 146, 126, 24);
		contentPane.add(FechaDeSalida);
		
		CosteDeBillete = new JLabel("Coste de billete");
		CosteDeBillete.setFont(new Font("Tahoma", Font.BOLD, 14));
		CosteDeBillete.setBounds(330, 146, 126, 24);
		contentPane.add(CosteDeBillete);
		
		TipoDeBillete = new JLabel("Tipo de billete");
		TipoDeBillete.setFont(new Font("Tahoma", Font.BOLD, 14));
		TipoDeBillete.setBounds(570, 146, 126, 24);
		contentPane.add(TipoDeBillete);
		
		Nombre = new JLabel("Nombre");
		Nombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		Nombre.setBounds(113, 248, 61, 24);
		contentPane.add(Nombre);
		
		Apellido = new JLabel("DNI");
		Apellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		Apellido.setBounds(350, 248, 35, 24);
		contentPane.add(Apellido);
		
		Apellido_1 = new JLabel("Apellido");
		Apellido_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		Apellido_1.setBounds(150, 315, 67, 24);
		contentPane.add(Apellido_1);
		
		NBillete = new JLabel("N\u00BA Billete");
		NBillete.setFont(new Font("Tahoma", Font.BOLD, 14));
		NBillete.setBounds(514, 315, 76, 24);
		contentPane.add(NBillete);
		
		Sexo = new JLabel("Sexo");
		Sexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		Sexo.setBounds(555, 248, 35, 24);
		contentPane.add(Sexo);
		
		respuestaLinea = new JLabel("Bilbao - Mungia");
		respuestaLinea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respuestaLinea.setBounds(34, 113, 354, 24);
		contentPane.add(respuestaLinea);
		
		respuestaEmpresa = new JLabel("Termibus");
		respuestaEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respuestaEmpresa.setBounds(117, 44, 75, 24);
		contentPane.add(respuestaEmpresa);
		
		respuestaOrigen = new JLabel("Univ. Deusto - Mungia");
		respuestaOrigen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respuestaOrigen.setBounds(415, 111, 309, 24);
		contentPane.add(respuestaOrigen);
		
		respuestaCodigo = new JLabel("2348");
		respuestaCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respuestaCodigo.setBounds(330, 30, 75, 24);
		contentPane.add(respuestaCodigo);
		
		respuestaFechaCompra = new JLabel("12/01/2020");
		respuestaFechaCompra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respuestaFechaCompra.setBounds(514, 46, 84, 24);
		contentPane.add(respuestaFechaCompra);
		
		respuestaFechaSalida = new JLabel("15/01/2020");
		respuestaFechaSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respuestaFechaSalida.setBounds(21, 168, 84, 24);
		contentPane.add(respuestaFechaSalida);
		
		respuestaCoste = new JLabel("18,85\u20AC");
		respuestaCoste.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respuestaCoste.setBounds(334, 174, 92, 24);
		contentPane.add(respuestaCoste);
		
		respuestaTipoBillete = new JLabel("Ida y vuelta");
		respuestaTipoBillete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respuestaTipoBillete.setBounds(570, 181, 92, 24);
		contentPane.add(respuestaTipoBillete);
		
		respuestaNombre = new JLabel("Juan");
		respuestaNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respuestaNombre.setBounds(100, 282, 117, 24);
		contentPane.add(respuestaNombre);
		
		respuestaDNI = new JLabel("82472845R");
		respuestaDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respuestaDNI.setBounds(330, 283, 76, 24);
		contentPane.add(respuestaDNI);
		
		respuestaSexo = new JLabel("Hombre");
		respuestaSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respuestaSexo.setBounds(535, 282, 76, 24);
		contentPane.add(respuestaSexo);
		
		respuestaApellido = new JLabel("Picapiedra");
		respuestaApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respuestaApellido.setBounds(118, 350, 138, 24);
		contentPane.add(respuestaApellido);
		
		respuestaNBillete = new JLabel("12-354-50057");
		respuestaNBillete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respuestaNBillete.setBounds(493, 350, 126, 24);
		contentPane.add(respuestaNBillete);
	
		lblHoraVuelta = new JLabel("21:35");
		lblHoraVuelta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoraVuelta.setBounds(150, 188, 84, 24);
		contentPane.add(lblHoraVuelta);
		
		respuestaHoraSalida = new JLabel("12:00");
		respuestaHoraSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		respuestaHoraSalida.setBounds(150, 168, 84, 24);
		contentPane.add(respuestaHoraSalida);
		
		lblFechaVuelta = new JLabel("15/01/2020");
		lblFechaVuelta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaVuelta.setBounds(21, 188, 84, 24);
		contentPane.add(lblFechaVuelta);
	}

	
public JLabel getRespuestaEmpresa() {
		return respuestaEmpresa;
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

	public void setRespuestaEmpresa(JLabel respuestaEmpresa) {
		this.respuestaEmpresa = respuestaEmpresa;
	}


	public JLabel getRespuestaLinea() {
		return respuestaLinea;
	}


	public void setRespuestaLinea(JLabel respuestaLinea) {
		this.respuestaLinea = respuestaLinea;
	}


	public JLabel getRespuestaOrigen() {
		return respuestaOrigen;
	}


	public void setRespuestaOrigen(JLabel respuestaOrigen) {
		this.respuestaOrigen = respuestaOrigen;
	}


	public JLabel getRespuestaCodigo() {
		return respuestaCodigo;
	}


	public void setRespuestaCodigo(JLabel respuestaCodigo) {
		this.respuestaCodigo = respuestaCodigo;
	}


	public JLabel getRespuestaFechaCompra() {
		return respuestaFechaCompra;
	}


	public void setRespuestaFechaCompra(JLabel respuestaFechaCompra) {
		this.respuestaFechaCompra = respuestaFechaCompra;
	}


	public JLabel getRespuestaFechaSalida() {
		return respuestaFechaSalida;
	}


	public void setRespuestaFechaSalida(JLabel respuestaFechaSalida) {
		this.respuestaFechaSalida = respuestaFechaSalida;
	}


	public JLabel getRespuestaCoste() {
		return respuestaCoste;
	}


	public void setRespuestaCoste(JLabel respuestaCoste) {
		this.respuestaCoste = respuestaCoste;
	}


	public JLabel getRespuestaTipoBillete() {
		return respuestaTipoBillete;
	}


	public void setRespuestaTipoBillete(JLabel respuestaTipoBillete) {
		this.respuestaTipoBillete = respuestaTipoBillete;
	}


	public JLabel getRespuestaNombre() {
		return respuestaNombre;
	}


	public void setRespuestaNombre(JLabel respuestaNombre) {
		this.respuestaNombre = respuestaNombre;
	}


	public JLabel getRespuestaDNI() {
		return respuestaDNI;
	}


	public void setRespuestaDNI(JLabel respuestaDNI) {
		this.respuestaDNI = respuestaDNI;
	}


	public JLabel getRespuestaSexo() {
		return respuestaSexo;
	}


	public void setRespuestaSexo(JLabel respuestaHombre) {
		this.respuestaSexo = respuestaHombre;
	}


	public JLabel getRespuestaApellido() {
		return respuestaApellido;
	}


	public void setRespuestaApellido(JLabel respuestaApellido) {
		this.respuestaApellido = respuestaApellido;
	}

	
	public JLabel getRespuestaNBillete() {
		return respuestaNBillete;
	}


	public void setRespuestaNBillete(JLabel respuestaNBillete) {
		this.respuestaNBillete = respuestaNBillete;
	}


	public JButton getImprimirTiquet() {
		return ImprimirTiquet;
	}


	public void setImprimirTiquet(JButton imprimirTiquet) {
		ImprimirTiquet = imprimirTiquet;
	}


	public JButton getFinalizar() {
		return Finalizar;
	}


	public void setFinalizar(JButton finalizar) {
		Finalizar = finalizar;
	}

	
	public JLabel getRespuestaHoraSalida() {
		return respuestaHoraSalida;
	}

	
	public void setRespuestaHoraSalida(JLabel respuestaHoraSalida) {
		this.respuestaHoraSalida = respuestaHoraSalida;
	}


	public JLabel getRespuestaAutobus2() {
		return respuestaAutobus2;
	}

	
	public void setRespuestaAutobus2(JLabel respuestaAutobus2) {
		this.respuestaAutobus2 = respuestaAutobus2;
	}


}
