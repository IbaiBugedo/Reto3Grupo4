package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import com.toedter.calendar.JCalendar;

public class MenuOrigenDestino extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuOrigenDestino frame = new MenuOrigenDestino();
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
	public MenuOrigenDestino() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Selecione la linea de autobus");
		label.setFont(new Font("Tahoma", Font.PLAIN, 35));
		label.setBounds(31, 14, 454, 40);
		contentPane.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(48, 65, 410, 60);
		contentPane.add(comboBox);
		
		table = new JTable();
		table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		table.setBounds(0, 0, 510, 156);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		table_1.setBounds(0, 155, 734, 306);
		contentPane.add(table_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(539, 75, 170, 40);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Seleccione la hora");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(520, 17, 204, 43);
		contentPane.add(lblNewLabel);
	}
}
