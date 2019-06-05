package galancar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordFieldContrasena;

	/**
	 * Launch the application. ME FUCKING GUSTA DAW
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/imageresources/logo&nombresmall120.png")));
		label.setBounds(250, 70, 135, 89);
		contentPane.add(label);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 17));
		lblUsuario.setBounds(225, 172, 75, 38);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 17));
		lblContrasea.setBounds(185, 224, 115, 30);
		contentPane.add(lblContrasea);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Arial", Font.BOLD, 17));
		textFieldUsuario.setBounds(323, 180, 116, 22);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		passwordFieldContrasena = new JPasswordField();
		passwordFieldContrasena.setFont(new Font("Arial", Font.BOLD, 17));
		passwordFieldContrasena.setBounds(323, 228, 116, 22);
		contentPane.add(passwordFieldContrasena);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
		btnLogin.setBounds(203, 267, 97, 25);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Registro registro = new Registro(); 
				registro.setVisible(true); 
				dispose();
			}
			
			
			
		});
		btnRegister.setFont(new Font("Arial", Font.BOLD, 14));
		btnRegister.setBounds(323, 267, 97, 25);
		contentPane.add(btnRegister);
	}
}
