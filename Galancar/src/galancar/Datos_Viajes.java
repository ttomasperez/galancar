package galancar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Datos_Viajes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buscar frame = new Buscar();
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
	public Datos_Viajes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

			
			table = new JTable();
			table.setBounds(58, 13, 498, 160);
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
				},
				new String[] {
					"N\u00BA DE VIAJE", "DNI CONDUCTOR", "ORIGEN", "DESTINO", "N\u00BA PLAZAS"
				}
			));
			table.getColumnModel().getColumn(1).setPreferredWidth(112);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(12, 151, 608, 197);
			contentPane.add(scrollPane).setVisible(true);
			getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Buscar.class.getResource("/imageresources/logosmall75.png")));
		lblNewLabel.setBounds(557, 395, 75, 58);
		contentPane.add(lblNewLabel);
		
		JLabel lblenQuNumero = new JLabel("\u00BFEn qu\u00E9 numero de viaje quieres desplazarte?");
		lblenQuNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblenQuNumero.setFont(new Font("Arial", Font.BOLD, 14));
		lblenQuNumero.setBounds(0, 63, 632, 14);
		contentPane.add(lblenQuNumero);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 14));
		textField.setBounds(231, 91, 85, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnUnirse = new JButton("Unirse");
		btnUnirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Datos_Viajes datos_Viajes = new Datos_Viajes(); 
				datos_Viajes.setVisible(false); 
				dispose();
			}
		});
		btnUnirse.setFont(new Font("Arial", Font.BOLD, 14));
		btnUnirse.setBounds(328, 90, 97, 25);
		contentPane.add(btnUnirse);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Datos_Viajes.class.getResource("/imageresources/nombreblancosmall300.png")));
		label.setBounds(0, 0, 632, 41);
		contentPane.add(label);
		//

	}
}