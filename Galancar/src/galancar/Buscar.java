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
import javax.swing.DefaultComboBoxModel;

public class Buscar extends JFrame {

	private JPanel contentPane;

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
		
		JButton btnPublicar = new JButton("Publicar");
		btnPublicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// FUNCI�N DEL BOT�N PUBLICAR
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
				// FUNCI�N DEL BOT�N BUSCAR
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
				// FUNCI�N DEL BOT�N PERFIL
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
				// FUNCI�N DEL BOT�N INICIO
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
		comboBoxOrigen.setToolTipText("");
		comboBoxOrigen.setModel(new DefaultComboBoxModel(new String[] {"Elegir una opci\u00F3n...", "Ciudad Real", "Puertollano", "Tomelloso", "Alc\u00E1zar De San Juan", "Valdepe\u00F1as", "La Solana", "Membrilla", "San Carlos Del Valle", "Daimiel", "Miguelturra", "Herencia", "Alhambra", "Almagro", "Sotu\u00E9lamos ", "Malagon", "Pedro Mu\u00F1oz", "Campo de Criptana", "Almad\u00E9n", "Pozo De La Serna", "Argamasilla De Alba"}));
		comboBoxOrigen.setSelectedIndex(0);
		comboBoxOrigen.setBounds(158, 127, 149, 20);
		contentPane.add(comboBoxOrigen);
		
		
		JComboBox comboBoxDestino = new JComboBox();
		comboBoxDestino.setModel(new DefaultComboBoxModel(new String[] {"Elegir una opci\u00F3n...", "Ciudad Real", "Puertollano", "Tomelloso", "Alc\u00E1zar De San Juan", "Valdepe\u00F1as", "La Solana", "Membrilla", "San Carlos Del Valle", "Daimiel", "Miguelturra", "Herencia", "Alhambra", "Almagro", "Sotu\u00E9lamos ", "Malagon", "Pedro Mu\u00F1oz", "Campo de Criptana", "Almad\u00E9n", "Pozo De La Serna", "Argamasilla De Alba"}));
		comboBoxDestino.setSelectedIndex(0);
		comboBoxDestino.setBounds(319, 127, 149, 20);
		contentPane.add(comboBoxDestino);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setFont(new Font("Arial", Font.BOLD, 14));
		lblOrigen.setBounds(92, 130, 54, 14);
		contentPane.add(lblOrigen);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setFont(new Font("Arial", Font.BOLD, 14));
		lblDestino.setBounds(480, 130, 54, 14);
		contentPane.add(lblDestino);
		
		JButton btnConsulta = new JButton("Encontrar viaje");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// FUNCI�N DEL BOT�N ENCONTRAR VIAJE
				Datos_Viajes datos_viajes = new Datos_Viajes(); 
				datos_viajes.setVisible(true); 
				dispose();
			}
		});
		btnConsulta.setFont(new Font("Arial", Font.BOLD, 14));
		btnConsulta.setBounds(242, 163, 149, 25);
		contentPane.add(btnConsulta);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Buscar.class.getResource("/imageresources/lupa200.png")));
		label.setBounds(0, 199, 620, 220);
		contentPane.add(label);
		//

	}
}