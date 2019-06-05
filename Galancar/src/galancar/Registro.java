package galancar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDNI;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JPasswordField passwordFieldContrasena;
	private JTextField textFieldProvincia;
	private JTextField textFieldLocalidad;
	private JTextField textFieldMovil;
	private JTextField textField;
	private JLabel lblDni;
	private JLabel lblNewLabel;
	private JLabel lblApellidos;
	private JLabel lblNewLabel_1;
	private JLabel lblLocalidad;
	private JLabel lblProvincia;
	private JLabel lblMvil;
	private JLabel lblE;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setFont(new Font("Arial", Font.BOLD, 19));
		lblRegistro.setBounds(250, 13, 100, 16);
		contentPane.add(lblRegistro);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldDNI.setBounds(136, 66, 116, 22);
		contentPane.add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldNombre.setBounds(136, 114, 116, 22);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldApellidos.setBounds(136, 162, 116, 22);
		contentPane.add(textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		passwordFieldContrasena = new JPasswordField();
		passwordFieldContrasena.setFont(new Font("Arial", Font.PLAIN, 14));
		passwordFieldContrasena.setBounds(136, 209, 116, 22);
		contentPane.add(passwordFieldContrasena);
		
		textFieldProvincia = new JTextField();
		textFieldProvincia.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldProvincia.setBounds(348, 114, 116, 22);
		contentPane.add(textFieldProvincia);
		textFieldProvincia.setColumns(10);
		
		textFieldLocalidad = new JTextField();
		textFieldLocalidad.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldLocalidad.setBounds(348, 162, 116, 22);
		contentPane.add(textFieldLocalidad);
		textFieldLocalidad.setColumns(10);
		
		textFieldMovil = new JTextField();
		textFieldMovil.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldMovil.setBounds(348, 209, 116, 22);
		contentPane.add(textFieldMovil);
		textFieldMovil.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(136, 294, 328, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDni.setBounds(98, 67, 26, 19);
		contentPane.add(lblDni);
		
		lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(55, 116, 69, 16);
		contentPane.add(lblNewLabel);
		
		lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setFont(new Font("Arial", Font.PLAIN, 16));
		lblApellidos.setBounds(35, 164, 89, 16);
		contentPane.add(lblApellidos);
		
		lblNewLabel_1 = new JLabel("CONTRASE\u00D1A");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(12, 211, 112, 16);
		contentPane.add(lblNewLabel_1);
		
		lblLocalidad = new JLabel("LOCALIDAD");
		lblLocalidad.setFont(new Font("Arial", Font.PLAIN, 16));
		lblLocalidad.setBounds(476, 164, 100, 16);
		contentPane.add(lblLocalidad);
		
		lblProvincia = new JLabel("PROVINCIA");
		lblProvincia.setFont(new Font("Arial", Font.PLAIN, 16));
		lblProvincia.setBounds(476, 117, 89, 16);
		contentPane.add(lblProvincia);
		
		lblMvil = new JLabel("M\u00D3VIL");
		lblMvil.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMvil.setBounds(476, 212, 56, 16);
		contentPane.add(lblMvil);
		
		lblE = new JLabel("CORREO ELECTR\u00D3NICO");
		lblE.setHorizontalAlignment(SwingConstants.CENTER);
		lblE.setFont(new Font("Arial", Font.PLAIN, 16));
		lblE.setBounds(136, 272, 328, 16);
		contentPane.add(lblE);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(Registro.class.getResource("/imageresources/nombreblancosmall300.png")));
		lblNewLabel_2.setBounds(0, 369, 595, 44);
		contentPane.add(lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(348, 66, 116, 22);
		contentPane.add(dateChooser);
		
		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 16));
		lblFecha.setBounds(476, 71, 89, 16);
		contentPane.add(lblFecha);
		
		JButton btnNewButton = new JButton("Comenzar");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(348, 335, 116, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login login = new Login(); 
				login.setVisible(true); 
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1.setBounds(136, 335, 116, 23);
		contentPane.add(btnNewButton_1);
		
		
		
	}
}
