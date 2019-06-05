package galancar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;

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
		btnNewButton.setIcon(new ImageIcon(Home.class.getResource("/imageresources/buscar35.png")));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(0, 0, 137, 38);
		contentPane.add(btnNewButton);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(Home.class.getResource("/imageresources/lupa30.png")));
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 14));
		btnBuscar.setBounds(137, 0, 137, 38);
		contentPane.add(btnBuscar);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.setFont(new Font("Arial", Font.BOLD, 14));
		btnInicio.setIcon(new ImageIcon(Home.class.getResource("/imageresources/perfil30.png")));
		btnInicio.setBounds(495, 0, 137, 38);
		contentPane.add(btnInicio);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(272, 0, 224, 38);
		contentPane.add(button_2);
	}
}
