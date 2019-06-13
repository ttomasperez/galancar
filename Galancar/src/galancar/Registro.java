/* 
 *  PROYECTO GALANCAR.
 * 	
 * 	FELIPE PARRA
 * 	JULIÁN DEL OLMO
 *  TOMÁS PÉREZ
 *  
 * 
 * */
package galancar;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;

public class Registro extends JFrame {
	JTextField t_dni, t_nombre, t_apellidos, t_contrasena, t_provincia, t_localidad, t_movil, t_email;
	JDateChooser t_fecha;
	JButton btnAdelante;
	Container c;

	handler handle;

	ConnectorBBDD db;

	Registro() {
		// NOMBRE DE LA VENTANA
		super("Registrate");

		c = getContentPane();

		db = new ConnectorBBDD();
		handle = new handler();

		t_nombre = new JTextField(10);
		t_nombre.setBounds(337, 86, 158, 22);
		getContentPane().add(t_nombre);
		t_nombre.setColumns(10);

		btnAdelante = new JButton("\u00A1Reg\u00EDstrate!");
		btnAdelante.setFont(new Font("Arial", Font.BOLD, 14));
		btnAdelante.setBounds(337, 319, 158, 25);

		btnAdelante.addActionListener(handle);
		getContentPane().setLayout(null);

		c.add(btnAdelante);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			// BOTÓN DE LOGIN
			public void actionPerformed(ActionEvent arg0) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});

		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(126, 319, 158, 25);
		getContentPane().add(btnNewButton);

		t_dni = new JTextField();
		t_dni.setBounds(126, 86, 158, 22);
		getContentPane().add(t_dni);
		t_dni.setColumns(10);

		t_apellidos = new JTextField();
		t_apellidos.setBounds(126, 129, 158, 22);
		getContentPane().add(t_apellidos);
		t_apellidos.setColumns(10);

		t_contrasena = new JTextField();
		t_contrasena.setBounds(337, 129, 158, 22);
		getContentPane().add(t_contrasena);
		t_contrasena.setColumns(10);

		t_provincia = new JTextField();
		t_provincia.setBounds(337, 172, 158, 22);
		getContentPane().add(t_provincia);
		t_provincia.setColumns(10);

		t_localidad = new JTextField();
		t_localidad.setBounds(126, 215, 158, 22);
		getContentPane().add(t_localidad);
		t_localidad.setColumns(10);

		t_movil = new JTextField();
		t_movil.setBounds(335, 215, 160, 22);
		getContentPane().add(t_movil);
		t_movil.setColumns(10);

		t_email = new JTextField();
		t_email.setBounds(126, 284, 369, 22);
		getContentPane().add(t_email);
		t_email.setColumns(10);

		t_fecha = new JDateChooser();
		t_fecha.setDateFormatString("yyyy-MM-dd");
		t_fecha.setBounds(126, 172, 158, 22);
		getContentPane().add(t_fecha);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Arial", Font.BOLD, 14));
		lblDni.setBounds(90, 89, 24, 16);
		getContentPane().add(lblDni);

		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
		lblNombre.setBounds(507, 89, 63, 16);
		getContentPane().add(lblNombre);

		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 14));
		lblApellidos.setBounds(37, 132, 77, 16);
		getContentPane().add(lblApellidos);

		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 14));
		lblContrasea.setBounds(507, 132, 95, 16);
		getContentPane().add(lblContrasea);

		JLabel lblFechaDeNacimiento = new JLabel("NACIMIENTO");
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.BOLD, 14));
		lblFechaDeNacimiento.setBounds(26, 175, 88, 16);
		getContentPane().add(lblFechaDeNacimiento);

		JLabel lblProvincia = new JLabel("PROVINCIA");
		lblProvincia.setFont(new Font("Arial", Font.BOLD, 14));
		lblProvincia.setBounds(507, 175, 77, 16);
		getContentPane().add(lblProvincia);

		JLabel lblLocalidad = new JLabel("LOCALIDAD");
		lblLocalidad.setFont(new Font("Arial", Font.BOLD, 14));
		lblLocalidad.setBounds(37, 218, 88, 16);
		getContentPane().add(lblLocalidad);

		JLabel lblMvil = new JLabel("M\u00D3VIL");
		lblMvil.setFont(new Font("Arial", Font.BOLD, 14));
		lblMvil.setBounds(507, 218, 56, 16);
		getContentPane().add(lblMvil);

		JLabel lblCorreoElectrnico = new JLabel("CORREO ELECTR\u00D3NICO");
		lblCorreoElectrnico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreoElectrnico.setFont(new Font("Arial", Font.BOLD, 14));
		lblCorreoElectrnico.setBounds(126, 264, 369, 16);
		getContentPane().add(lblCorreoElectrnico);

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Registro.class.getResource("/imageresources/nombreblancosmall300.png")));
		label.setBounds(0, 357, 632, 46);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon(Registro.class.getResource("/imageresources/logosmall65.png")));
		label_1.setBounds(0, 13, 605, 40);
		getContentPane().add(label_1);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 650, 500);
	}

	// LE DIGO QUE ME EJECUTE EL REGISTRO
	public static void main(String args[]) {
		Registro sample = new Registro();
	}

	class handler implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			// COMPRUEBO SI EL BOTÓN ESTÁ ACCIONADO
			if (ae.getSource() == btnAdelante) {

				// FUNCIÓN PARA CONVERTIR LA FECHA DEL JCALENDAR
				java.util.Date Date = t_fecha.getDate();
				SimpleDateFormat formato_fecha = new SimpleDateFormat("yyyy-mm-dd");
				String fecha = formato_fecha.format(Date);

				// AQUÍ TRANSFORMO MI FECHA UTIL.DATE EN SQL.DATE
				java.sql.Date sqlDate = new java.sql.Date(Date.getTime());

				// PASO EL TEXTFIELD A INT
				int movil = Integer.parseInt(t_movil.getText());

				System.out.println(fecha);
				// COMPRUEBO CON CHECKLOGIN, LO CUÁL ME DARÁ UN VALOR BOOLEAN. EN CASO DE SER
				// VERDADERO LE DIGO QUE MUESTRE INICIO
				// AL ESTAR DENTRO DE LA CONDICIÓN IF, NO LE PONGO == TRUE POR QUE SE OBVIA
				if (db.checkRegister(t_dni.getText(), t_nombre.getText(), t_apellidos.getText(), t_contrasena.getText(),
						sqlDate, t_provincia.getText(), t_localidad.getText(), movil, t_email.getText())) {

					Login login = new Login();
					login.setVisible(true);
					dispose();
				}
				// SI NO ES IGUAL, MUESTRO UN JOPTIONPANE QUE ME ADVIERTA DE QUE ALGO ESTOY
				// HACIENDO MAL
				else {
					JOptionPane.showMessageDialog(null, "Error al validar", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

	}
}