
/* 
 *  PROYECTO GALANCAR.
 * 	
 * 	FELIPE PARRA
 * 	JULI�N DEL OLMO
 *  TOM�S P�REZ
 *  
 *  2019
 * 
 * */
package galancar;

import java.awt.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import galancar.Login.handler;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.net.URI;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import javax.swing.JPasswordField;

public class Perfil extends JFrame {
	// BOTON Y CONTENEDOR
	JButton btnPublicar, btnBuscar, btnInicio, btnGalancar;
	Container c;
	JPanel contentPane;
	JButton btnCambiarContrasea;
	ConnectorBBDD db;
	String dni_user, contrasena1, contrasena2;
	ResultSet rs4;
	handler handle;

	private JTextField t_nombre, t_dni, t_nacimiento, t_provincia, t_apellidos, t_localidad, t_contrasena, t_movil, t_email;
	private JLabel lblPron, lblEmail, lblMovil, lblLocalidad, lblProvincia;
	private JPasswordField psw1, psw2;

	
	
	// CONSTRUCTOR
	Perfil(String dni_user) {

		// NOMBRE DE LA VENTANA
		super("Perfil");
		this.dni_user = dni_user;

		// CONTAINER
		c = getContentPane();
		db = new ConnectorBBDD();

		getContentPane().setLayout(null);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FUNCI�N DEL BOT�N BUSCAR
				Buscar buscar = new Buscar(dni_user);
				buscar.setVisible(true);
				dispose();
			}
		});

		btnPublicar = new JButton("Publicar");
		btnPublicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FUNCI�N DEL BOT�N PUBLICAR
				Publicar publicar = new Publicar(dni_user);
				publicar.setVisible(true);
				dispose();
			}
		});

		btnPublicar.setIcon(new ImageIcon(Publicar.class.getResource("/imageresources/buscar35.png")));
		btnPublicar.setFont(new Font("Arial", Font.BOLD, 14));
		btnPublicar.setBounds(0, 0, 137, 38);
		getContentPane().add(btnPublicar);

		btnBuscar.setIcon(new ImageIcon(Publicar.class.getResource("/imageresources/lupa30.png")));
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 13));
		btnBuscar.setBounds(137, 0, 137, 38);
		getContentPane().setLayout(null);

		btnInicio = new JButton("Perfil");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FUNCI�N DEL BOT�N PERFIL
				Perfil perfil = new Perfil(dni_user);
				perfil.setVisible(true);
				dispose();

			}
		});
		btnInicio.setFont(new Font("Arial", Font.BOLD, 13));
		btnInicio.setIcon(new ImageIcon(Publicar.class.getResource("/imageresources/perfil30.png")));
		btnInicio.setBounds(495, 0, 137, 38);
		getContentPane().add(btnInicio);

		btnGalancar = new JButton("");
		btnGalancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FUNCI�N DEL BOT�N INICIO
				Home home = new Home(dni_user);
				home.setVisible(true);
				dispose();
			}
		});
		btnGalancar.setIcon(new ImageIcon(Publicar.class.getResource("/imageresources/nombreblancosmall220.png")));
		btnGalancar.setBounds(272, 0, 224, 38);
		getContentPane().add(btnGalancar);
		c.add(btnBuscar);
		c.add(btnGalancar);
		c.add(btnInicio);
		c.add(btnPublicar);

		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon(Publicar.class.getResource("/imageresources/logosmall75.png")));
		label_1.setBounds(557, 395, 75, 58);
		getContentPane().add(label_1);

		t_nombre = new JTextField();
		t_nombre.setEditable(false);
		t_nombre.setFont(new Font("Arial", Font.BOLD, 14));
		t_nombre.setBounds(137, 177, 156, 22);
		getContentPane().add(t_nombre);
		t_nombre.setColumns(10);

		t_dni = new JTextField();
		t_dni.setEditable(false);
		t_dni.setFont(new Font("Arial", Font.BOLD, 14));
		t_dni.setBounds(137, 132, 156, 22);
		getContentPane().add(t_dni);
		t_dni.setColumns(10);

		t_nacimiento = new JTextField();
		t_nacimiento.setFont(new Font("Arial", Font.BOLD, 14));
		t_nacimiento.setEditable(false);
		t_nacimiento.setBounds(342, 132, 154, 22);
		getContentPane().add(t_nacimiento);
		t_nacimiento.setColumns(10);

		t_provincia = new JTextField();
		t_provincia.setFont(new Font("Arial", Font.BOLD, 14));
		t_provincia.setEditable(false);
		t_provincia.setBounds(342, 177, 154, 22);
		getContentPane().add(t_provincia);
		t_provincia.setColumns(10);

		t_apellidos = new JTextField();
		t_apellidos.setFont(new Font("Arial", Font.BOLD, 14));
		t_apellidos.setEditable(false);
		t_apellidos.setBounds(137, 223, 156, 22);
		getContentPane().add(t_apellidos);
		t_apellidos.setColumns(10);

		t_localidad = new JTextField();
		t_localidad.setFont(new Font("Arial", Font.BOLD, 14));
		t_localidad.setEditable(false);
		t_localidad.setBounds(340, 223, 156, 22);
		getContentPane().add(t_localidad);
		t_localidad.setColumns(10);

		t_contrasena = new JTextField();
		t_contrasena.setFont(new Font("Arial", Font.BOLD, 14));
		t_contrasena.setEditable(false);
		t_contrasena.setBounds(137, 266, 156, 22);
		getContentPane().add(t_contrasena);
		t_contrasena.setColumns(10);

		t_movil = new JTextField();
		t_movil.setFont(new Font("Arial", Font.BOLD, 14));
		t_movil.setEditable(false);
		t_movil.setBounds(342, 266, 154, 22);
		getContentPane().add(t_movil);
		t_movil.setColumns(10);

		t_email = new JTextField();
		t_email.setFont(new Font("Arial", Font.BOLD, 14));
		t_email.setEditable(false);
		t_email.setBounds(212, 318, 219, 22);
		getContentPane().add(t_email);
		t_email.setColumns(10);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Arial", Font.BOLD, 14));
		lblDni.setBounds(96, 135, 29, 16);
		getContentPane().add(lblDni);

		JLabel lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(62, 180, 63, 16);
		getContentPane().add(lblNewLabel);

		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 14));
		lblApellidos.setBounds(48, 226, 77, 16);
		getContentPane().add(lblApellidos);

		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 14));
		lblContrasea.setBounds(30, 269, 95, 16);
		getContentPane().add(lblContrasea);

		lblPron = new JLabel("NACIMIENTO");
		lblPron.setFont(new Font("Arial", Font.BOLD, 14));
		lblPron.setBounds(508, 135, 95, 16);
		getContentPane().add(lblPron);

		lblProvincia = new JLabel("PROVINCIA");
		lblProvincia.setFont(new Font("Arial", Font.BOLD, 14));
		lblProvincia.setBounds(508, 180, 95, 16);
		getContentPane().add(lblProvincia);

		lblLocalidad = new JLabel("LOCALIDAD");
		lblLocalidad.setFont(new Font("Arial", Font.BOLD, 14));
		lblLocalidad.setBounds(508, 226, 95, 16);
		getContentPane().add(lblLocalidad);

		lblMovil = new JLabel("MOVIL");
		lblMovil.setFont(new Font("Arial", Font.BOLD, 14));
		lblMovil.setBounds(508, 269, 95, 16);
		getContentPane().add(lblMovil);

		lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmail.setBounds(295, 301, 43, 16);
		getContentPane().add(lblEmail);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 650, 500);
		CUsuario oUsuario = db.obtenerDatosUsuario(dni_user);
		t_dni.setText(dni_user);
		t_nombre.setText(oUsuario.getNombre());
		t_apellidos.setText(oUsuario.getApellidos());
		t_contrasena.setText(oUsuario.getContrasena());
		t_nacimiento.setText(oUsuario.getFecha_nacimiento());
		t_provincia.setText(oUsuario.getProvincia());
		t_localidad.setText(oUsuario.getLocalidad());
		t_movil.setText(oUsuario.getMovil());
		t_email.setText(oUsuario.getEmail());

		btnCambiarContrasea = new JButton("\u00BFCambiar!");
		btnCambiarContrasea.setFont(new Font("Arial", Font.BOLD, 14));
		btnCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// PASO EL TIPO PASSWORD A UN STRING NORMAL
				char[] temp_pwd1 = psw1.getPassword();
				contrasena1 = null;
				contrasena1 = String.copyValueOf(temp_pwd1);

				// PASO EL TIPO PASSWORD A UN STRING NORMAL
				char[] temp_pwd2 = psw2.getPassword();
				contrasena2 = null;
				contrasena2 = String.copyValueOf(temp_pwd2);

				// VALIDADOR CONTRASE�A ANTIGUA
				if (contrasena1.equals(oUsuario.getContrasena())) {
					JOptionPane.showMessageDialog(null, "No puedes introducir una contrase�a igual a la que ya ten�as",
							"Error", JOptionPane.ERROR_MESSAGE);
				} else {
					// SI LAS DOS CONTARSE�AS SON IGUALES
					if (contrasena1.equals(contrasena2)) {
						// COMPRUEBO CON CHECKLOGIN, LO CU�L ME DAR� UN VALOR BOOLEAN. EN CASO DE SER
						// VERDADERO LE DIGO QUE MUESTRE INICIO
						// AL ESTAR DENTRO DE LA CONDICI�N IF, NO LE PONGO == TRUE POR QUE SE OBVIA
						if (db.checkNuevaContrasena(contrasena1, dni_user)) {
							JOptionPane.showMessageDialog(null, "Operaci�n realizada con �xito");
						}
						// SI NO ES IGUAL, MUESTRO UN JOPTIONPANE QUE ME ADVIERTA DE QUE ALGO ESTOY
						// HACIENDO MAL
						else {
							JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error",
									JOptionPane.ERROR_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(null, "Las contrase�as son diferentes", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}// FIN VALIDADOR CONTRASE�A ANTIGUA
			}
		});
		btnCambiarContrasea.setBounds(399, 377, 117, 58);
		getContentPane().add(btnCambiarContrasea);

		JLabel lblNuevaContrasena = new JLabel("Nueva contrase\u00F1a");
		lblNuevaContrasena.setFont(new Font("Arial", Font.BOLD, 14));
		lblNuevaContrasena.setBounds(106, 377, 132, 16);
		getContentPane().add(lblNuevaContrasena);

		JLabel lblNuevaContrasea = new JLabel("Nueva contrase\u00F1a");
		lblNuevaContrasea.setFont(new Font("Arial", Font.BOLD, 14));
		lblNuevaContrasea.setBounds(106, 419, 132, 16);
		getContentPane().add(lblNuevaContrasea);

		JLabel lblConfirmar = new JLabel("Confirmar");
		lblConfirmar.setFont(new Font("Arial", Font.BOLD, 14));
		lblConfirmar.setBounds(106, 405, 79, 16);
		getContentPane().add(lblConfirmar);

		psw1 = new JPasswordField();
		psw1.setBounds(250, 377, 137, 22);
		getContentPane().add(psw1);

		psw2 = new JPasswordField();
		psw2.setText("");
		psw2.setBounds(250, 413, 137, 22);
		getContentPane().add(psw2);

	}// FIN CONSTRUCTOR
}
