
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
import java.awt.EventQueue;
import java.sql.*;
public class ConnectorBBDD 
{
    Connection con;
    // PS LOGIN
    PreparedStatement pst;
    // PS REGISTRO
    PreparedStatement pst2;
    // PS BUSCAR
    PreparedStatement pst3;
    // PS PERFIL
    PreparedStatement pst4;
    ResultSet rs;
    int rs2;
    int rs3;
    ResultSet rs4;
    
    
    
    ConnectorBBDD()
    {
        try{
             
            // CONECTO CON LA BDD
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/galancar?user=root&password="
            		+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
                        pst=con.prepareStatement("select * from usuario where dni_usuario=? and contrasena=?");
                        pst2=con.prepareStatement("insert into usuario values (?,?,?,?,?,?,?,?,?)");
                        pst3=con.prepareStatement("insert into viajes (dni_conductor, id_origen, id_destino, plazas_disponibles) values (?,?,?,?)");
                        pst4=con.prepareStatement("select dni_usuario, nombre, apellidos, contrasena, fecha_nacimiento, provincia, localidad, movil, email from usuario where dni_usuario=?");
           }
        catch (Exception e) 
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    public String getDni_usuario() {
		return dni_login;
	}
	public void setDni_usuario(String dni_usuario) {
		this.dni_login = dni_usuario;
	}

	String dni_login;
    // VALIDADOR DE LOGIN
    public Boolean checkLogin(String uname,String pwd)
    {
        try {
                        
            pst.setString(1, uname); 
            pst.setString(2, pwd);    

            rs=pst.executeQuery();
            if(rs.next())
            {
                
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e);
            return false;
        }

	
} // FIN DE VALIDADOR DE LOGIN
    
    // VALIDADOR DE REGISTRO
    public Boolean checkRegister(String dni_usuario, String nombre, String apellidos, String contrasena,
    		Date fecha_nacimiento, String provincia, String localidad, int movil, String email)
    {
        try {
            pst2.setString(1, dni_usuario);
            pst2.setString(2, nombre);
            pst2.setString(3, apellidos);
            pst2.setString(4, contrasena);
            pst2.setDate(5, fecha_nacimiento);
            pst2.setString(6, provincia);
            pst2.setString(7, localidad);
            pst2.setInt(8, movil);
            pst2.setString(9, email);
            
            
            rs2=pst2.executeUpdate();
            
            if(rs2==1)
            {
            	// VERDADERO SI ENCUENTRA LOS DATOS
                return true;
               
            }
            else
            {
            	// FALSO SI NO LOS ENCUENTRA
                return false;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e);
            e.printStackTrace();
            return false;
        }

	
    } // FIN DEL VALIDADOR DE REGISTRO 
    
    // VALIDAR VIAJES
    public Boolean checkPublicar(String dni_usuario, int id_origen, int id_destino, int numero_plazas)
    {
        try {
        	ConnectorBBDD db = new ConnectorBBDD();
            pst3.setString(1, dni_usuario);
            pst3.setInt(2, id_origen);
            pst3.setInt(3, id_destino);
            pst3.setInt(4, numero_plazas);           
            
            rs3=pst3.executeUpdate();
            
            if(rs3==1)
            {
            	// VERDADERO SI ENCUENTRA LOS DATOS
                return true;
            }
            else
            {
            	// FALSO SI NO LOS ENCUENTRA
                return false;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e);
            e.printStackTrace();
            return false;
        }

	
    }
    // VALIDAR PERFIL
    public Boolean checkPerfil(String dni_usuario)
    {
        try {
                        
            pst4.setString(1, dni_usuario);   
            
            
            

            rs4=pst4.executeQuery();
            if(rs4.next())
            {
                
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e);
            return false;
        }

	
} // FIN DE VALIDADOR DE LOGIN
    
}
