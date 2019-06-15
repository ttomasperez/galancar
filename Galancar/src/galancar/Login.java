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

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame {

	JLabel l_name, l_pass, label_1;
	JTextField t_name;
	JPasswordField t_pass;
	JButton button;
	Container c;
	handler handle;
	ConnectorBBDD db;

	Login() {
		// NOMBRE DE LA VENTANA
		super("Galancar - Login");

		c = getContentPane();
		db = new ConnectorBBDD();
		handle = new handler();

		l_name = new JLabel("DNI");
		l_name.setHorizontalAlignment(SwingConstants.CENTER);
		l_name.setBounds(551, 168, 381, 17);
		l_name.setFont(new Font("Arial", Font.BOLD, 14));

		l_pass = new JLabel("Contrase\u00F1a");
		l_pass.setHorizontalAlignment(SwingConstants.CENTER);
		l_pass.setFont(new Font("Arial", Font.BOLD, 14));
		l_pass.setBounds(551, 234, 381, 16);

		t_name = new JTextField(10);
		t_name.setBounds(671, 187, 158, 22);

		t_pass = new JPasswordField(10);
		t_pass.setBounds(671, 252, 158, 22);

		button = new JButton("Login");
		button.setFont(new Font("Arial", Font.BOLD, 14));
		button.setBounds(671, 314, 158, 25);

		button.addActionListener(handle);
		getContentPane().setLayout(null);

		c.add(l_name);
		c.add(t_name);
		c.add(l_pass);
		c.add(t_pass);
		c.add(button);

		JButton btnNewButton = new JButton("\u00A1Reg\u00EDstrate!");
		btnNewButton.addActionListener(new ActionListener() {
			// ACCIÓN DEL BOTÓN DE REGISTRO
			public void actionPerformed(ActionEvent arg0) {
				Registro registro = new Registro();
				registro.setVisible(true);
				dispose();
			}
		});

		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(671, 352, 158, 25);
		getContentPane().add(btnNewButton);

		label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon(Login.class.getResource("/imageresources/nombreblancosmall300.png")));
		label_1.setBounds(551, 46, 381, 54);
		getContentPane().add(label_1);

		// BOTÓN DE INSERTAR USUARIOS
		JButton btnInsertarDesdeFichero = new JButton("Insertar usuario desde fichero");
		btnInsertarDesdeFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Statement stmt = null;
				ResultSet rs = null;

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection db = DriverManager
							.getConnection("jdbc:mysql://localhost:3306/galancar?user=root&password="
									+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

					String ruta = JOptionPane.showInputDialog("Introduce la ruta donde tienes el fichero a ejecutar: ");
					FileReader fr = new FileReader(ruta);
					BufferedReader br = new BufferedReader(fr);

					String linea;
					while ((linea = br.readLine()) != null) {
						System.out.println(linea);
						String sql = (linea);
						stmt = db.createStatement();
						stmt.executeUpdate(sql);

					}

				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}

			}

			public void main(String[] args) {
				fichero iniciador = new fichero();

			}

		});
		btnInsertarDesdeFichero.setBounds(642, 436, 224, 43);
		getContentPane().add(btnInsertarDesdeFichero);
		// FIN DEL BOTÓN DE INSERTAR USUARIOS

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Login.class.getResource("/imageresources/login1.png")));
		label_2.setBounds(0, 0, 550, 653);
		getContentPane().add(label_2);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 950, 700);

	}

	public static void main(String args[]) {
		Login sample = new Login();
	}

	class handler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			// COMPRUEBO SI EL BOTÓN ESTÁ ACCIONADO
			if (ae.getSource() == button) {

				// PASO EL TIPO PASSWORD A UN STRING NORMAL
				char[] temp_pwd = t_pass.getPassword();
				String pwd = null;
				pwd = String.copyValueOf(temp_pwd);
				System.out.println("Username,Pwd:" + t_name.getText() + "," + pwd);

				String dni_user = null;
				dni_user = t_name.getText();
				db.setDni_usuario(dni_user);

				// COMPRUEBO CON CHECKLOGIN, LO CUÁL ME DARÁ UN VALOR BOOLEAN. EN CASO DE SER
				// VERDADERO LE DIGO QUE MUESTRE INICIO
				// AL ESTAR DENTRO DE LA CONDICIÓN IF, NO LE PONGO == TRUE POR QUE SE OBVIA
				if (db.checkLogin(t_name.getText(), pwd)) {

					Home home = new Home(dni_user);
					home.setVisible(true);
					dispose();

				}
				// SI NO ES IGUAL, MUESTRO UN JOPTIONPANE QUE ME ADVIERTA DE QUE ALGO ESTOY
				// HACIENDO MAL
				else {
					JOptionPane.showMessageDialog(null, "DNI o Contraseña incorrecto", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}