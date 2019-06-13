
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


public class Login extends JFrame
{
    
    JLabel l_name,l_pass;
    JTextField t_name;
    JPasswordField t_pass;     
    JButton button;
    Container c;

    handler handle;

    ConnectorBBDD db;
    private JLabel label_1;
    
    Login()
    {
    	// NOMBRE DE LA VENTANA
        super("Galancar");
 
        
        
        c=getContentPane();
 
        db=new ConnectorBBDD();
        handle =new handler();

        l_name=new JLabel("DNI");
        l_name.setBounds(258, 192, 24, 17);
        l_name.setFont(new Font("Arial", Font.BOLD, 14));
        
        l_pass=new JLabel("Contrase\u00F1a");
        l_pass.setFont(new Font("Arial", Font.BOLD, 14));
        l_pass.setBounds(201, 227, 81, 16);
        
        t_name=new JTextField(10);
        t_name.setBounds(304, 189, 158, 22);
        
        t_pass=new JPasswordField(10);
        t_pass.setBounds(304, 224, 158, 22);
        
        button=new JButton("Login");
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBounds(201, 288, 125, 25);
 
        button.addActionListener(handle);
        getContentPane().setLayout(null);
 
        c.add(l_name);
        c.add(t_name);
        c.add(l_pass);
        c.add(t_pass);
        c.add(button);
        
        JButton btnNewButton = new JButton("\u00A1Reg\u00EDstrate!");
        btnNewButton.addActionListener(new ActionListener() {
        	// BOTÓN DE REGISTRO
        	public void actionPerformed(ActionEvent arg0) {
        		Registro registro = new Registro(); 
				registro.setVisible(true); 
				dispose();
        	}
        });
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
        btnNewButton.setBounds(337, 288, 125, 25);
        getContentPane().add(btnNewButton);
        
        //IMAGENES
        JLabel label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setIcon(new ImageIcon(Login.class.getResource("/imageresources/logosmall65.png")));
        label.setBounds(239, 95, 158, 84);
        getContentPane().add(label);
        
        label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon(Login.class.getResource("/imageresources/nombreblancosmall300.png")));
        label_1.setBounds(182, 342, 292, 54);
        getContentPane().add(label_1);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 650, 500);
 
    }
    public static void main(String args[])
    {
        Login sample=new Login();
    }

    class handler implements ActionListener
    {

        public void actionPerformed(ActionEvent ae)
        {
        	// COMPRUEBO SI EL BOTÓN ESTÁ ACCIONADO
            if(ae.getSource()==button)
            {
                char[] temp_pwd=t_pass.getPassword();
                String pwd=null;
                pwd=String.copyValueOf(temp_pwd);
                System.out.println("Username,Pwd:"+t_name.getText()+","+pwd);
                
                
                String dni_user=null;
                dni_user=t_name.getText();
                db.setDni_usuario(dni_user);
 

                // COMPRUEBO CON CHECKLOGIN, LO CUÁL ME DARÁ UN VALOR BOOLEAN. EN CASO DE SER VERDADERO LE DIGO QUE MUESTRE INICIO
                // AL ESTAR DENTRO DE LA CONDICIÓN IF, NO LE PONGO == TRUE POR QUE SE OBVIA
                if(db.checkLogin(t_name.getText(), pwd))
                {
                	
                	Home home = new Home(dni_user); 
    				home.setVisible(true); 
    				dispose();
                }
                // SI NO ES IGUAL, MUESTRO UN JOPTIONPANE QUE ME ADVIERTA DE QUE ALGO ESTOY HACIENDO MAL
                else
                {
                    JOptionPane.showMessageDialog(null, "DNI o Contraseña incorrecto","Error",
                                        JOptionPane.ERROR_MESSAGE);
                }
            }
        }
 
    }
}