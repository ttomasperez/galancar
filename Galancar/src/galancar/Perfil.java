
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
import javax.swing.plaf.basic.BasicComboBoxRenderer;
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
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;

public class Perfil extends JFrame {
	// BOTON Y CONTENEDOR
	JButton btnPublicar, btnBuscar, btnInicio, btnGalancar;
	Container c;

	JPanel contentPane;

	// handler handle;
	
	ConnectorBBDD db;
	String dni_user;
	JTextField t_nombre, t_dni, t_nacimiento, t_provincia, t_apellidos, t_localidad, t_contrasena, t_movil, t_email;
	private JLabel lblPron;
	private JLabel lblProvincia;
	private JLabel lblLocalidad;
	private JLabel lblMovil;
	private JLabel lblEmail;
	
	// CONSTRUCTOR
	Perfil(String dni_user) {
		
	
		
	
		
		// NOMBRE DE LA VENTANA
		super("Publicar");
		this.dni_user=dni_user;
		// CONTAINER
		c = getContentPane();

		db = new ConnectorBBDD();
		getContentPane().setLayout(null);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FUNCIÓN DEL BOTÓN BUSCAR
				Buscar buscar = new Buscar(dni_user);
				buscar.setVisible(true);
				dispose();
			}
		});
		
		btnPublicar = new JButton("Publicar");
		btnPublicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FUNCIÓN DEL BOTÓN PUBLICAR
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
				// FUNCIÓN DEL BOTÓN PERFIL
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
				// FUNCIÓN DEL BOTÓN INICIO
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
		t_nacimiento.setEditable(false);
		t_nacimiento.setBounds(342, 132, 154, 22);
		getContentPane().add(t_nacimiento);
		t_nacimiento.setColumns(10);
		
		t_provincia = new JTextField();
		t_provincia.setEditable(false);
		t_provincia.setBounds(342, 177, 154, 22);
		getContentPane().add(t_provincia);
		t_provincia.setColumns(10);
		
		t_apellidos = new JTextField();
		t_apellidos.setEditable(false);
		t_apellidos.setBounds(137, 223, 156, 22);
		getContentPane().add(t_apellidos);
		t_apellidos.setColumns(10);
		
		t_localidad = new JTextField();
		t_localidad.setEditable(false);
		t_localidad.setBounds(340, 223, 156, 22);
		getContentPane().add(t_localidad);
		t_localidad.setColumns(10);
		
		t_contrasena = new JTextField();
		t_contrasena.setEditable(false);
		t_contrasena.setBounds(137, 266, 156, 22);
		getContentPane().add(t_contrasena);
		t_contrasena.setColumns(10);
		
		t_movil = new JTextField();
		t_movil.setEditable(false);
		t_movil.setBounds(342, 266, 154, 22);
		getContentPane().add(t_movil);
		t_movil.setColumns(10);
		
		t_email = new JTextField();
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
		setBounds(300, 300, 650, 500);
		
	}// FIN CONSTRUCTOR
	/*class handler implements ActionListener
    {

        public void actionPerformed(ActionEvent ae)
        {
        	// COMPRUEBO SI EL BOTÓN ESTÁ ACCIONADO
            if(ae.getSource()==button)
            {
               
                // COMPRUEBO CON CHECKLOGIN, LO CUÁL ME DARÁ UN VALOR BOOLEAN. EN CASO DE SER VERDADERO LE DIGO QUE MUESTRE INICIO
                // AL ESTAR DENTRO DE LA CONDICIÓN IF, NO LE PONGO == TRUE POR QUE SE OBVIA
                if(db.checkPerfil(dni_user))
                {
                	
                	
                }
                // SI NO ES IGUAL, MUESTRO UN JOPTIONPANE QUE ME ADVIERTA DE QUE ALGO ESTOY HACIENDO MAL
                else
                {
                    JOptionPane.showMessageDialog(null, "Error","Error",
                                        JOptionPane.ERROR_MESSAGE);
                }
            }
        }
 
    }*/
}