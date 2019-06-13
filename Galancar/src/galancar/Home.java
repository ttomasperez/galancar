
/* 
 *  PROYECTO GALANCAR.
 * 	
 * 	FELIPE PARRA
 * 	JULIÁN DEL OLMO
 *  TOMÁS PÉREZ
 *  
 *  2019
 * 
 * */
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
	private String dni_usuario;
	private String dni_user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home(null);
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
	public Home(String dni_user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPublicar = new JButton("Publicar");
		btnPublicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// FUNCIÓN DEL BOTÓN PUBLICAR
				Publicar publicar = new Publicar(dni_user); 
				publicar.setVisible(true); 
				dispose();
			}
		});
		btnPublicar.setIcon(new ImageIcon(Home.class.getResource("/imageresources/buscar35.png")));
		btnPublicar.setFont(new Font("Arial", Font.BOLD, 14));
		btnPublicar.setBounds(0, 0, 137, 38);
		contentPane.add(btnPublicar);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FUNCIÓN DEL BOTÓN BUSCAR
				Buscar buscar = new Buscar(dni_user); 
				buscar.setVisible(true); 
				dispose();
			}
		});
		btnBuscar.setIcon(new ImageIcon(Home.class.getResource("/imageresources/lupa30.png")));
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 13));
		btnBuscar.setBounds(131, 0, 137, 38);
		contentPane.add(btnBuscar);
		
		JButton btnInicio = new JButton("Perfil");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FUNCIÓN DEL BOTÓN PERFIL
				Perfil perfil = new Perfil(dni_user); 
				perfil.setVisible(true); 
				dispose();
			}
		});
		btnInicio.setFont(new Font("Arial", Font.BOLD, 13));
		btnInicio.setIcon(new ImageIcon(Home.class.getResource("/imageresources/perfil30.png")));
		btnInicio.setBounds(495, 0, 137, 38);
		contentPane.add(btnInicio);
		
		JButton btnGalancar = new JButton("");
		btnGalancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FUNCIÓN DEL BOTÓN HOME, EL CUÁL NOS RECARGARÁ ESTA MISMA PÁGINA
				Home home = new Home(null); 
				home.setVisible(true); 
				dispose();
			}
		});
		btnGalancar.setIcon(new ImageIcon(Home.class.getResource("/imageresources/logosmall60.png")));
		btnGalancar.setBounds(266, 0, 230, 38);
		contentPane.add(btnGalancar);
		
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
