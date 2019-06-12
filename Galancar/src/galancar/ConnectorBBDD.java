package galancar;
import java.sql.*;
public class ConnectorBBDD 
{
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst2;
    ResultSet rs;
    int rs2;
    ConnectorBBDD()
    {
        try{
             
            //MAKE SURE YOU KEEP THE mysql_conndector.jar file in java/lib folder
            //ALSO SET THE CLASSPATH
            Class.forName("com.mysql.jc.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Galancar","root","");
                        pst=con.prepareStatement("select * from usuario where dni_usuario=? and contrasena=?");
                        pst2=con.prepareStatement("insert into usuario values (?,?,?,?,?,?,?,?,?)");
             
           }
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
        //ip:username,password
        //return boolean
    public Boolean checkLogin(String uname,String pwd)
    {
        try {
                        
            pst.setString(1, uname); //this replaces the 1st  "?" in the query for username
            pst.setString(2, pwd);    //this replaces the 2st  "?" in the query for password
            //executes the prepared statement
            rs=pst.executeQuery();
            if(rs.next())
            {
                //TRUE iff the query founds any corresponding datad
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("error while validating"+e);
            return false;
        }

	
}
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
            return false;
        }

	
}   
}