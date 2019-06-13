package galancar;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

import java.sql.*;

public class fichero {
	public Statement stmt = null;
	public ResultSet rs = null;
	public Connection conect;

	public fichero() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3307/galancar?user=root&password="
					+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

			String ruta = JOptionPane.showInputDialog("Introduce la ruta donde tienes el fichero a ejecutar: ");
			FileReader fr = new FileReader(ruta);
			BufferedReader br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
				String sql = (linea);
				stmt = conect.createStatement();
				stmt.executeUpdate(sql);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}

	}

	public static void main(String[] args) {
		fichero iniciador = new fichero();

	}
}
