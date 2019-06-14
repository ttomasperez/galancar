package galancar;

import java.sql.Date;

import javax.swing.JTextField;

public class CUsuario {
	String nombre;
	String apellidos;
	String contrasena;
	String fecha_nacimiento; 
	String provincia;
	String localidad;
	String movil; 
	String email;
	
	public CUsuario(String nombre, String apellidos, String contrasena,
			String fecha_nacimiento, String provincia, String localidad, String movil, String email) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.contrasena=contrasena;
		this.fecha_nacimiento=fecha_nacimiento;
		this.provincia=provincia;
		this.localidad=localidad;
		this.movil=movil;
		this.email=email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
