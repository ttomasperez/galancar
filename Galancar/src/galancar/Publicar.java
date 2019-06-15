
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

public class Publicar extends JFrame {
	// BOTON Y CONTENEDOR
	JButton btnAdelante, btnPublicar, btnBuscar, btnInicio, btnGalancar;
	Container c;
	JPanel contentPane;
	handler handle;
	JComboBox c_origen = new JComboBox();
	JComboBox c_destino = new JComboBox();
	ConnectorBBDD db;

	JTextField t_plazas;
	String dni_user;

	// CONSTRUCTOR
	Publicar(String dni_user) {

		// NOMBRE DE LA VENTANA
		super("Sesión Iniciada por el usuario: " + dni_user);
		this.dni_user = dni_user;

		// CONTAINER
		c = getContentPane();
		db = new ConnectorBBDD();
		handle = new handler();

		btnAdelante = new JButton("Publicar");
		btnAdelante.setFont(new Font("Arial", Font.BOLD, 14));
		btnAdelante.setBounds(237, 209, 158, 25);
		btnAdelante.addActionListener(handle);
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

		c.add(btnAdelante);
		c.add(btnBuscar);
		c.add(btnGalancar);
		c.add(btnInicio);
		c.add(btnPublicar);

		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon(Publicar.class.getResource("/imageresources/logosmall75.png")));
		label_1.setBounds(557, 395, 75, 58);
		getContentPane().add(label_1);

		t_plazas = new JTextField();
		t_plazas.setFont(new Font("Arial", Font.BOLD, 14));
		t_plazas.setBounds(260, 174, 116, 22);
		getContentPane().add(t_plazas);
		t_plazas.setColumns(10);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 650, 500);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Publicar.class.getResource("/imageresources/consultoria-integral.png")));
		lblNewLabel.setBounds(208, 242, 224, 211);
		getContentPane().add(lblNewLabel);

		JLabel lbldesdeDndeViajas = new JLabel("\u00BFDESDE D\u00D3NDE VIAJAS?");
		lbldesdeDndeViajas.setFont(new Font("Arial", Font.BOLD, 14));
		lbldesdeDndeViajas.setBounds(138, 86, 171, 16);
		getContentPane().add(lbldesdeDndeViajas);

		JLabel lblhaciaDndeViajas = new JLabel("\u00BFHACIA D\u00D3NDE VIAJAS?");
		lblhaciaDndeViajas.setFont(new Font("Arial", Font.BOLD, 14));
		lblhaciaDndeViajas.setBounds(321, 86, 171, 16);
		getContentPane().add(lblhaciaDndeViajas);

		JLabel lblcuntasPlazasLibres = new JLabel("\u00BFCU\u00C1NTAS PLAZAS LIBRES TIENES?");
		lblcuntasPlazasLibres.setHorizontalAlignment(SwingConstants.CENTER);
		lblcuntasPlazasLibres.setFont(new Font("Arial", Font.BOLD, 14));
		lblcuntasPlazasLibres.setBounds(170, 155, 300, 16);
		getContentPane().add(lblcuntasPlazasLibres);

		// CLASE ITEMRENDERER
		class ItemRenderer extends BasicComboBoxRenderer {
			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value != null) {
					Item item = (Item) value;
					setText(item.getDescription().toUpperCase());
				}
				if (index == -1) {
					Item item = (Item) value;
					setText("" + item.getId());
				}
				return this;
			}
		}// FIN CLASE ITEMRENDERER

		// COMBOBOX ORIGEN

		c_origen.setSize(149, 20);
		c_origen.setLocation(160, 115);
		c_origen.setModel(new DefaultComboBoxModel(new String[] {}));
		c_origen.setEditable(true);
		c_origen.addItem(new Item(1, "Ciudad Real"));
		c_origen.addItem(new Item(2, "Puertollano"));
		c_origen.addItem(new Item(3, "Tomelloso"));
		c_origen.addItem(new Item(4, "Alcazar De San Juan"));
		c_origen.addItem(new Item(5, "Valdepñas"));
		c_origen.addItem(new Item(6, "La Solana"));
		c_origen.addItem(new Item(7, "Membrilla"));
		c_origen.addItem(new Item(8, "San Carlos Del Valle"));
		c_origen.addItem(new Item(9, "Daimiel"));
		c_origen.addItem(new Item(10, "Miguelturra"));
		c_origen.addItem(new Item(11, "Herencia"));
		c_origen.addItem(new Item(12, "Alhambra"));
		c_origen.addItem(new Item(13, "Almagro"));
		c_origen.addItem(new Item(14, "Sotuelamos"));
		c_origen.addItem(new Item(15, "Malagon"));
		c_origen.addItem(new Item(16, "Pedro Muñoz"));
		c_origen.addItem(new Item(17, "Campo de Criptana"));
		c_origen.addItem(new Item(18, "Almaden"));
		c_origen.addItem(new Item(19, "Pozo De La Serna"));
		c_origen.addItem(new Item(20, "Argamasilla De Alba"));
		c_origen.setMaximumRowCount(20);
		getContentPane().add(c_origen);
		c_origen.setPrototypeDisplayValue(" None of the above ");
		c_origen.addActionListener(e -> {
			JComboBox c = (JComboBox) e.getSource();
			Item item = (Item) c.getSelectedItem();
			System.out.println(item.getId());
		});// FIN COMBOBOX ORIGEN

		// COMBOBOX DESTINO
		c_destino.setSize(149, 20);
		c_destino.setLocation(321, 115);
		c_destino.setModel(new DefaultComboBoxModel(new String[] {}));
		c_destino.setEditable(true);
		c_destino.addItem(new Item(1, "Ciudad Real"));
		c_destino.addItem(new Item(2, "Puertollano"));
		c_destino.addItem(new Item(3, "Tomelloso"));
		c_destino.addItem(new Item(4, "Alcazar De San Juan"));
		c_destino.addItem(new Item(5, "Valdepñas"));
		c_destino.addItem(new Item(6, "La Solana"));
		c_destino.addItem(new Item(7, "Membrilla"));
		c_destino.addItem(new Item(8, "San Carlos Del Valle"));
		c_destino.addItem(new Item(9, "Daimiel"));
		c_destino.addItem(new Item(10, "Miguelturra"));
		c_destino.addItem(new Item(11, "Herencia"));
		c_destino.addItem(new Item(12, "Alhambra"));
		c_destino.addItem(new Item(13, "Almagro"));
		c_destino.addItem(new Item(14, "Sotuelamos"));
		c_destino.addItem(new Item(15, "Malagon"));
		c_destino.addItem(new Item(16, "Pedro Muñoz"));
		c_destino.addItem(new Item(17, "Campo de Criptana"));
		c_destino.addItem(new Item(18, "Almaden"));
		c_destino.addItem(new Item(19, "Pozo De La Serna"));
		c_destino.addItem(new Item(20, "Argamasilla De Alba"));
		c_destino.setMaximumRowCount(20);
		getContentPane().add(c_destino);
		c_destino.setPrototypeDisplayValue(" None of the above ");
		c_destino.addActionListener(e -> {
			JComboBox c = (JComboBox) e.getSource();
			Item item = (Item) c.getSelectedItem();
			System.out.println(item.getId());
		});// FIN COMBOBOX DESTINO

	}// FIN CONSTRUCTOR
		// CLASE ITEM

	public class Item {

		private int id;
		private String description;

		public Item(int id, String description) {
			this.id = id;
			this.description = description;
		}

		public int getId() {
			return id;
		}

		public String getDescription() {
			return description;
		}

		@Override
		public String toString() {
			return description;
		}
	}// FIN CLASE ITEM

	class handler implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			// COMPRUEBO SI EL BOTÓN ESTÁ ACCIONADO
			if (ae.getSource() == btnAdelante) {

				System.out.println();
				// PASO EL TEXTFIELD A INT
				int plazas = Integer.parseInt(t_plazas.getText());

				// COMPRUEBO CON CHECKLOGIN, LO CUÁL ME DARÁ UN VALOR BOOLEAN. EN CASO DE SER
				// VERDADERO LE DIGO QUE MUESTRE INICIO
				// AL ESTAR DENTRO DE LA CONDICIÓN IF, NO LE PONGO == TRUE POR QUE SE OBVIA

				int origen = ((Item) c_origen.getSelectedItem()).getId();
				int destino = ((Item) c_destino.getSelectedItem()).getId();

				if (origen != destino) {
					if (plazas > 0) {
						if (db.checkPublicar(dni_user, origen, destino, plazas)) {

							JOptionPane.showMessageDialog(null, "Viaje insertado con éxito");
						}
						// SI NO ES IGUAL, MUESTRO UN JOPTIONPANE QUE ME ADVIERTA DE QUE ALGO ESTOY
						// HACIENDO MAL
						else {
							JOptionPane.showMessageDialog(null, "Error al validar", "Error", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Para publicar un viaje necesitas alguna plaza libre",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Destino inválido", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}