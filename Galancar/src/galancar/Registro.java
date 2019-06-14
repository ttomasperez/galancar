
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
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.awt.event.*;
import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Registro extends JFrame {
	JTextField t_dni, t_nombre, t_apellidos, t_contrasena, t_provincia, t_localidad, t_movil, t_email;
	JDateChooser t_fecha;
	JButton btnAdelante;
	Container c;

	handler handle;

	ConnectorBBDD db;

	
	
	Registro() {
		// NOMBRE DE LA VENTANA

		c = getContentPane();

		db = new ConnectorBBDD();
		handle = new handler();

		t_nombre = new JTextField(10);
		t_nombre.setBounds(159, 160, 188, 22);
		getContentPane().add(t_nombre);
		t_nombre.setColumns(10);

		btnAdelante = new JButton("\u00A1Reg\u00EDstrate!");
		btnAdelante.setFont(new Font("Arial", Font.BOLD, 14));
		btnAdelante.setBounds(159, 568, 188, 25);

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
		btnNewButton.setBounds(159, 606, 188, 25);
		getContentPane().add(btnNewButton);

		t_dni = new JTextField();
		t_dni.setBounds(159, 110, 188, 22);
		getContentPane().add(t_dni);
		t_dni.setColumns(10);

		t_apellidos = new JTextField();
		t_apellidos.setBounds(159, 210, 188, 22);
		getContentPane().add(t_apellidos);
		t_apellidos.setColumns(10);

		t_contrasena = new JTextField();
		t_contrasena.setBounds(159, 260, 188, 22);
		getContentPane().add(t_contrasena);
		t_contrasena.setColumns(10);

		t_provincia = new JTextField();
		t_provincia.setBounds(159, 360, 188, 22);
		getContentPane().add(t_provincia);
		t_provincia.setColumns(10);

		t_localidad = new JTextField();
		t_localidad.setBounds(159, 410, 188, 22);
		getContentPane().add(t_localidad);
		t_localidad.setColumns(10);

		t_movil = new JTextField();
		t_movil.setBounds(159, 460, 188, 22);
		getContentPane().add(t_movil);
		t_movil.setColumns(10);

		t_email = new JTextField();
		t_email.setBounds(159, 510, 188, 22);
		getContentPane().add(t_email);
		t_email.setColumns(10);

		t_fecha = new JDateChooser();
		t_fecha.setDateFormatString("yyyy-MM-dd");
		t_fecha.setBounds(159, 310, 188, 22);
		getContentPane().add(t_fecha);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setForeground(Color.WHITE);
		lblDni.setFont(new Font("Arial", Font.BOLD, 14));
		lblDni.setBounds(126, 113, 24, 16);
		getContentPane().add(lblDni);

		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
		lblNombre.setBounds(84, 164, 63, 16);
		getContentPane().add(lblNombre);

		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 14));
		lblApellidos.setBounds(70, 213, 77, 16);
		getContentPane().add(lblApellidos);

		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 14));
		lblContrasea.setBounds(52, 263, 95, 16);
		getContentPane().add(lblContrasea);

		JLabel lblFechaDeNacimiento = new JLabel("NACIMIENTO");
		lblFechaDeNacimiento.setForeground(Color.WHITE);
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.BOLD, 14));
		lblFechaDeNacimiento.setBounds(59, 316, 88, 16);
		getContentPane().add(lblFechaDeNacimiento);

		JLabel lblProvincia = new JLabel("PROVINCIA");
		lblProvincia.setForeground(Color.WHITE);
		lblProvincia.setFont(new Font("Arial", Font.BOLD, 14));
		lblProvincia.setBounds(70, 363, 77, 16);
		getContentPane().add(lblProvincia);

		JLabel lblLocalidad = new JLabel("LOCALIDAD");
		lblLocalidad.setForeground(Color.WHITE);
		lblLocalidad.setFont(new Font("Arial", Font.BOLD, 14));
		lblLocalidad.setBounds(70, 413, 88, 16);
		getContentPane().add(lblLocalidad);

		JLabel lblMvil = new JLabel("M\u00D3VIL");
		lblMvil.setForeground(Color.WHITE);
		lblMvil.setFont(new Font("Arial", Font.BOLD, 14));
		lblMvil.setBounds(99, 463, 48, 16);
		getContentPane().add(lblMvil);

		JLabel lblCorreoElectrnico = new JLabel("E-MAIL");
		lblCorreoElectrnico.setForeground(new Color(255, 255, 255));
		lblCorreoElectrnico.setHorizontalAlignment(SwingConstants.LEFT);
		lblCorreoElectrnico.setFont(new Font("Arial", Font.BOLD, 14));
		lblCorreoElectrnico.setBounds(99, 513, 48, 16);
		getContentPane().add(lblCorreoElectrnico);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Registro.class.getResource("/imageresources/nombreenblancocompleto300.png")));
		label.setBounds(1, 654, 481, 52);
		getContentPane().add(label);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(70, 51, 56, 16);
		getContentPane().add(label_2);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Registro.class.getResource("/imageresources/fondoregistro500.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(1, -4, 481, 756);
		getContentPane().add(label_1);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 500, 800);
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

					try {

						// Connect Database
						Connection connect = null;
						Statement s = null;

						Class.forName("com.mysql.jdbc.Driver");
						connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/galancar?user=root&password="
								+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

						s = connect.createStatement();

						String sql = "select dni_usuario,nombre,apellidos,contrasena,fecha_nacimiento,provincia,localidad,movil,email from usuario";

						ResultSet rec = s.executeQuery(sql);
						

						String ruta = JOptionPane.showInputDialog("Introduce la ruta donde quieres que se guarde el fichero XML seguido del nombre + .xml: ");
						
						String strPath = ruta;

						DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
						DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

						// define root elements
						Document doc = documentBuilder.newDocument();

						Element ele = doc.createElement("Registros");
						doc.appendChild(ele);

						int iRows = 0;
						while ((rec != null) && (rec.next())) {

							++iRows;

							// Row
							Element sUsuarios = doc.createElement("Usuario");
							ele.appendChild(sUsuarios);

							// Attributes
							Attr sAttrN = doc.createAttribute("Numero");
							sAttrN.setValue(String.valueOf(iRows));
							sUsuarios.setAttributeNode(sAttrN);

							Element sDNI = doc.createElement("DNI_Usuario");
							sDNI.appendChild(doc.createTextNode(rec.getString("dni_usuario")));
							sUsuarios.appendChild(sDNI);

							// CustomerID
							Element snombre = doc.createElement("Nombre");
							snombre.appendChild(doc.createTextNode(rec.getString("nombre")));
							sUsuarios.appendChild(snombre);

							// Name
							Element sapellidos = doc.createElement("Apellidos");
							sapellidos.appendChild(doc.createTextNode(rec.getString("apellidos")));
							sUsuarios.appendChild(sapellidos);

							// Email
							Element scontrasena = doc.createElement("Contrasena");
							scontrasena.appendChild(doc.createTextNode(rec.getString("contrasena")));
							sUsuarios.appendChild(scontrasena);

							// CountryCode
							Element sfecha_nacimiento = doc.createElement("Fecha_Nacimiento");
							sfecha_nacimiento.appendChild(doc.createTextNode(rec.getString("fecha_nacimiento")));
							sUsuarios.appendChild(sfecha_nacimiento);

							// Budget
							Element sprovincia = doc.createElement("Provincia");
							sprovincia.appendChild(doc.createTextNode(rec.getString("provincia")));
							sUsuarios.appendChild(sprovincia);

							// Used
							Element slocalidad = doc.createElement("Localidad");
							slocalidad.appendChild(doc.createTextNode(rec.getString("localidad")));
							sUsuarios.appendChild(slocalidad);

							Element smovil = doc.createElement("Movil");
							smovil.appendChild(doc.createTextNode(rec.getString("movil")));
							sUsuarios.appendChild(smovil);

							Element semail = doc.createElement("E-mail");
							semail.appendChild(doc.createTextNode(rec.getString("email")));
							sUsuarios.appendChild(semail);

						}

						// creating and writing to xml file
						TransformerFactory tff = TransformerFactory.newInstance();
						Transformer tf = tff.newTransformer();
						DOMSource domSource = new DOMSource(doc);
						StreamResult streamResult = new StreamResult(new File(strPath));

						tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
						tf.setOutputProperty(OutputKeys.INDENT, "yes");

						tf.transform(domSource, streamResult);

						JOptionPane.showMessageDialog(null, "Introducido con éxito");

					} catch (Exception e) {
						e.printStackTrace();
					}

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