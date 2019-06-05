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

public class Buscar extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
	public Buscar() {
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
			scrollPane.setBounds(95, 213, 452, 193);
			contentPane.add(scrollPane).setVisible(true);
			getContentPane().add(scrollPane);
		
		JButton btnPublicar = new JButton("Publicar");
		btnPublicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Publicar publicar = new Publicar(); 
				publicar.setVisible(true); 
				dispose();
			}
		});
		btnPublicar.setIcon(new ImageIcon(Buscar.class.getResource("/imageresources/buscar35.png")));
		btnPublicar.setFont(new Font("Arial", Font.BOLD, 14));
		btnPublicar.setBounds(0, 0, 137, 38);
		contentPane.add(btnPublicar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscar buscar = new Buscar(); 
				buscar.setVisible(true); 
				dispose();
			}
		});
		btnBuscar.setIcon(new ImageIcon(Buscar.class.getResource("/imageresources/lupa30.png")));
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 13));
		btnBuscar.setBounds(137, 0, 137, 38);
		contentPane.add(btnBuscar);
		
		JButton btnInicio = new JButton("Perfil");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Perfil perfil = new Perfil(); 
				perfil.setVisible(true); 
				dispose();
			}
		});
		btnInicio.setFont(new Font("Arial", Font.BOLD, 13));
		btnInicio.setIcon(new ImageIcon(Buscar.class.getResource("/imageresources/perfil30.png")));
		btnInicio.setBounds(495, 0, 137, 38);
		contentPane.add(btnInicio);
		
		JButton btnGalancar = new JButton("");
		btnGalancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home(); 
				home.setVisible(true); 
				dispose();
			}
		});
		btnGalancar.setIcon(new ImageIcon(Buscar.class.getResource("/imageresources/nombreblancosmall220.png")));
		btnGalancar.setBounds(272, 0, 224, 38);
		contentPane.add(btnGalancar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Buscar.class.getResource("/imageresources/logosmall75.png")));
		lblNewLabel.setBounds(557, 395, 75, 58);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBoxOrigen = new JComboBox();
		comboBoxOrigen.setBounds(334, 71, 149, 20);
		contentPane.add(comboBoxOrigen);
		
		JComboBox comboBoxDestino = new JComboBox();
		comboBoxDestino.setBounds(159, 70, 149, 20);
		contentPane.add(comboBoxDestino);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setFont(new Font("Arial", Font.BOLD, 14));
		lblOrigen.setBounds(95, 72, 54, 14);
		contentPane.add(lblOrigen);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setFont(new Font("Arial", Font.BOLD, 14));
		lblDestino.setBounds(493, 73, 54, 14);
		contentPane.add(lblDestino);
		
		JLabel lblenQuNumero = new JLabel("\u00BFEn qu\u00E9 numero de viaje quieres desplazarte?");
		lblenQuNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblenQuNumero.setFont(new Font("Arial", Font.BOLD, 14));
		lblenQuNumero.setBounds(159, 146, 329, 14);
		contentPane.add(lblenQuNumero);
		//

	}
}