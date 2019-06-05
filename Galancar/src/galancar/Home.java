package galancar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Publicar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Publicar publicar = new Publicar(); 
				publicar.setVisible(true); 
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(Home.class.getResource("/imageresources/buscar35.png")));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(0, 0, 137, 38);
		contentPane.add(btnNewButton);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscar buscar = new Buscar(); 
				buscar.setVisible(true); 
				dispose();
			}
		});
		btnBuscar.setIcon(new ImageIcon(Home.class.getResource("/imageresources/lupa30.png")));
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
		btnInicio.setIcon(new ImageIcon(Home.class.getResource("/imageresources/perfil30.png")));
		btnInicio.setBounds(495, 0, 137, 38);
		contentPane.add(btnInicio);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home(); 
				home.setVisible(true); 
				dispose();
			}
		});
		button_2.setIcon(new ImageIcon(Home.class.getResource("/imageresources/logosmall60.png")));
		button_2.setBounds(272, 0, 224, 38);
		contentPane.add(button_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/imageresources/logosmall75.png")));
		lblNewLabel.setBounds(0, 395, 75, 58);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/imageresources/imagenfondo.png")));
		lblNewLabel_1.setBounds(0, 36, 632, 417);
		contentPane.add(lblNewLabel_1);
	}
}
