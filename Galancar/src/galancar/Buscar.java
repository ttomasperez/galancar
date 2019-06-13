
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
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;

public class Buscar extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldBuscar;
	String dni_user;

	/**
	 * Launch the application.
	 */
		
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buscar frame = new Buscar("");
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
	public Buscar(String dni_user) {
		this.dni_user=dni_user;
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
		btnPublicar.setIcon(new ImageIcon(Buscar.class.getResource("/imageresources/buscar35.png")));
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
		btnBuscar.setIcon(new ImageIcon(Buscar.class.getResource("/imageresources/lupa30.png")));
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 13));
		btnBuscar.setBounds(137, 0, 137, 38);
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
		btnInicio.setIcon(new ImageIcon(Buscar.class.getResource("/imageresources/perfil30.png")));
		btnInicio.setBounds(495, 0, 137, 38);
		contentPane.add(btnInicio);

		JButton btnGalancar = new JButton("");
		btnGalancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FUNCIÓN DEL BOTÓN INICIO
				Home home = new Home(dni_user);
				home.setVisible(true);
				dispose();
			}
		});
		btnGalancar.setIcon(new ImageIcon(Buscar.class.getResource("/imageresources/nombreblancosmall220.png")));
		btnGalancar.setBounds(272, 0, 224, 38);
		contentPane.add(btnGalancar);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Buscar.class.getResource("/imageresources/logosmall75.png")));
		lblNewLabel.setBounds(557, 395, 75, 58);
		contentPane.add(lblNewLabel);
		
		class Item {

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
			}
		class ItemRenderer extends BasicComboBoxRenderer {
			  @Override
			  public Component getListCellRendererComponent(JList list, Object value,
			      int index, boolean isSelected, boolean cellHasFocus) {
			    super.getListCellRendererComponent(list, value, index, isSelected,
			        cellHasFocus);
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
			}
			
		JComboBox comboBox = new JComboBox();
		comboBox.setSize(149, 20);
		comboBox.setLocation(156, 128);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {}));
		comboBox.setEditable(true);
		comboBox.addItem(new Item(1, "Ciudad Real"));
	    comboBox.addItem(new Item(2, "Puertollano"));
	    comboBox.addItem(new Item(3, "Tomelloso"));
	    comboBox.addItem(new Item(4, "Alcazar De San Juan"));
	    comboBox.addItem(new Item(5, "Valdepeñas"));
	    comboBox.addItem(new Item(6, "La Solana"));
	    comboBox.addItem(new Item(7, "Membrilla"));
	    comboBox.addItem(new Item(8, "San Carlos Del Valle"));
	    comboBox.addItem(new Item(9, "Daimiel"));
	    comboBox.addItem(new Item(10, "Miguelturra"));
	    comboBox.addItem(new Item(11, "Herencia"));
	    comboBox.addItem(new Item(12, "Alhambra"));
	    comboBox.addItem(new Item(13, "Almagro"));
	    comboBox.addItem(new Item(14, "Sotuelamos"));
	    comboBox.addItem(new Item(15, "Malagon"));
	    comboBox.addItem(new Item(16, "Pedro Muñoz"));
	    comboBox.addItem(new Item(17, "Campo de Criptana"));
	    comboBox.addItem(new Item(18, "Almaden"));
	    comboBox.addItem(new Item(19, "Pozo De La Serna"));
	    comboBox.addItem(new Item(20, "Argamasilla De Alba"));
	    comboBox.setMaximumRowCount(20);
		contentPane.add(comboBox);
	    comboBox.setPrototypeDisplayValue(" None of the above ");
	    comboBox.addActionListener(e -> {
	      JComboBox c = (JComboBox) e.getSource();
	      Item item = (Item) c.getSelectedItem();
	      System.out.println(item.getId() + " : " + item.getDescription());
	    });
		
	    JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setSize(149, 20);
		comboBox_1.setLocation(321, 128);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {}));
		comboBox_1.setEditable(true);
	    comboBox_1.addItem(new Item(1, "Ciudad Real"));
	    comboBox_1.addItem(new Item(2, "Puertollano"));
	    comboBox_1.addItem(new Item(3, "Tomelloso"));
	    comboBox_1.addItem(new Item(4, "Alcazar De San Juan"));
	    comboBox_1.addItem(new Item(5, "Valdepeñas"));
	    comboBox_1.addItem(new Item(6, "La Solana"));
	    comboBox_1.addItem(new Item(7, "Membrilla"));
	    comboBox_1.addItem(new Item(8, "San Carlos Del Valle"));
	    comboBox_1.addItem(new Item(9, "Daimiel"));
	    comboBox_1.addItem(new Item(10, "Miguelturra"));
	    comboBox_1.addItem(new Item(11, "Herencia"));
	    comboBox_1.addItem(new Item(12, "Alhambra"));
	    comboBox_1.addItem(new Item(13, "Almagro"));
	    comboBox_1.addItem(new Item(14, "Sotuelamos"));
	    comboBox_1.addItem(new Item(15, "Malagon"));
	    comboBox_1.addItem(new Item(16, "Pedro Muñoz"));
	    comboBox_1.addItem(new Item(17, "Campo de Criptana"));
	    comboBox_1.addItem(new Item(18, "Almaden"));
	    comboBox_1.addItem(new Item(19, "Pozo De La Serna"));
	    comboBox_1.addItem(new Item(20, "Argamasilla De Alba"));
	    comboBox_1.setMaximumRowCount(20);
		contentPane.add(comboBox_1);
	    comboBox_1.setPrototypeDisplayValue(" None of the above ");
	    comboBox_1.addActionListener(e -> {
	      JComboBox c = (JComboBox) e.getSource();
	      Item item = (Item) c.getSelectedItem();
	      System.out.println(item.getId() + " : " + item.getDescription());
	    });
	    System.out.println(dni_user);
		

		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setFont(new Font("Arial", Font.BOLD, 14));
		lblOrigen.setBounds(92, 130, 54, 14);
		contentPane.add(lblOrigen);

		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setFont(new Font("Arial", Font.BOLD, 14));
		lblDestino.setBounds(480, 130, 54, 14);
		contentPane.add(lblDestino);

		JButton btnConsulta = new JButton("Encontrar viaje");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {


					// Conectar a BD y enviarla
					Connection connect = null;
					Statement query = null;
					ResultSet resultSet = null;
					// Driver
					Class.forName("com.mysql.jdbc.Driver");
					connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/galancar?user=root&password="
							+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
					
					// Construir una query para SQL con los datos del combobox
					//String consulta = "select id_viaje,dni_conductor,id_origen,id_destino,plazas_disponibles from viajes where id_origen = " 
					//+ ((Item)comboBox.getSelectedItem()).getId()+" and id_destino= "+((Item)comboBox_1.getSelectedItem()).getId();
					String consulta = "select id_viaje, dni_conductor, l1.nombre_localidad origen, l2.nombre_localidad destino, plazas_disponibles from viajes " + 
							" inner join localidad l1 on viajes.id_origen=l1.id_localidad inner join localidad l2 on viajes.id_destino=l2.id_localidad " + 
							" where id_origen = "+ ((Item)comboBox.getSelectedItem()).getId()+" and id_destino= "+((Item)comboBox_1.getSelectedItem()).getId();
					//JOptionPane.showMessageDialog(null, consulta); //solo para probar
					query = connect.createStatement();
					ResultSet resultado = query.executeQuery(consulta);
					// Tratar el resultSet para meterlo en la tabla
					int i = 0;
					while (resultado.next()) {
						int id_viaje = resultado.getInt("id_viaje");
						table.setValueAt(id_viaje, i, 0);

						String dni_conductor = resultado.getString("dni_conductor");
						table.setValueAt(dni_conductor, i, 1);

						String origen = resultado.getString("origen");
						table.setValueAt(origen, i, 2);

						String destino = resultado.getString("destino");
						table.setValueAt(destino, i, 3);
						
						int plazas_disponibles = resultado.getInt("plazas_disponibles");
						table.setValueAt(plazas_disponibles, i, 4);

						i++;
					}
				}

				catch (Exception e) {

				}
			}
		});
		btnConsulta.setFont(new Font("Arial", Font.BOLD, 14));
		btnConsulta.setBounds(243, 164, 149, 25);
		contentPane.add(btnConsulta);

		table = new JTable();
		table.setBounds(58, 13, 498, 160);
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "N\u00BA DE VIAJE", "DNI CONDUCTOR", "ORIGEN", "DESTINO", "N\u00BA PLAZAS" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 202, 608, 135);
		contentPane.add(scrollPane).setVisible(true);
		getContentPane().add(scrollPane);

		// JLABEL QUE PEDIRÁ AL USUARIO UN NÚMERO IDENTIFICADOR DEL VIAJE EN EL QUE
		// QUIEREN VIAJAR
		JLabel lblenQueNumero = new JLabel("\u00BFEn qu\u00E9 numero de viaje quieres desplazarte?");
		lblenQueNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblenQueNumero.setFont(new Font("Arial", Font.BOLD, 14));
		lblenQueNumero.setBounds(0, 348, 632, 14);
		contentPane.add(lblenQueNumero);

		textFieldBuscar = new JTextField();
		textFieldBuscar.setFont(new Font("Arial", Font.BOLD, 14));
		textFieldBuscar.setBounds(286, 375, 34, 22);
		contentPane.add(textFieldBuscar);
		textFieldBuscar.setColumns(10);

		JButton btnUnirse = new JButton("Unirse");
		btnUnirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FUNCIÓN DEL BOTÓN UNIRSE
				
				Home home = new Home(dni_user);
				home.setVisible(true);
				Buscar buscar = new Buscar(dni_user);
				buscar.setVisible(false);
				dispose();
				try {


					// Conectar a BD y enviarla
					Connection connect = null;
					PreparedStatement query = null;
					ResultSet resultSet = null;
					// Driver
					Class.forName("com.mysql.jdbc.Driver");
					connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/galancar?user=root&password="
							+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
					
					// Construir una query para SQL con los datos del combobox
					String consulta = "insert into galancar.pasajero_viaje (id_viaje, dni_pasajero) " +
	        				"values("+textFieldBuscar.getText()+",'"+dni_user+"')";
					System.out.println(textFieldBuscar.getText());
					//JOptionPane.showMessageDialog(null, consult); //solo para probar
					query = connect.prepareStatement(consulta);
					int resultado = query.executeUpdate(consulta);
					
					// Tratar el resultSet para meterlo en la tabla
					int i = 0;
					
				}

				catch (Exception e1) {
					e1.printStackTrace();
				}
				

			}
		});
		btnUnirse.setFont(new Font("Arial", Font.BOLD, 14));
		btnUnirse.setBounds(255, 401, 97, 25);
		contentPane.add(btnUnirse);
		
		

	}
}