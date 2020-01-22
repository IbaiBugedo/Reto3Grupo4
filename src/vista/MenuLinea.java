package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import com.toedter.calendar.JCalendar;


import controlador.ControladorBienvenida;

public class MenuLinea extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private MenuLinea frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuLinea frame = new MenuLinea();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	controlador.ControladorMenuLinea controladorMenuLinea= new controlador.ControladorMenuLinea(frame);

	/**
	 * Create the frame.
	 */
	public MenuLinea() {

		mCrearPanelContenedor();
		mCrearJLabel();
		mCrearJTable();
		mCrearJCalendar();
		mCrearJComboBox();

	}
	
	private void mCrearPanelContenedor() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	private void mCrearJLabel() {
	
		JLabel SeleccioneLinea = new JLabel("Selecione la linea de autobus");
		SeleccioneLinea.setFont(new Font("Tahoma", Font.PLAIN, 35));
		SeleccioneLinea.setBounds(31, 14, 454, 40);
		contentPane.add(SeleccioneLinea);
	}

	private void mCrearJTable() {		
		
		table = new JTable();
		table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		table.setBounds(0, 0, 510, 156);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		table_1.setBounds(0, 155, 734, 306);
		contentPane.add(table_1);
		
	}
	
	private void mCrearJComboBox() {
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(48, 65, 410, 60);
		contentPane.add(comboBox);
	}
	
	private void mCrearJCalendar() {
		
		JCalendar calendar = new JCalendar();
		calendar.getYearChooser().getSpinner().setEnabled(false);
		calendar.setBounds(530, 10, 184, 134);
		contentPane.add(calendar);
		
	}
	
}
