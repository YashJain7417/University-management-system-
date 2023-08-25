
package university.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,cancel;
    JTextField tfusername,tfpassword;
    Login (){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 120, 40);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 180, 28);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 80, 120, 40);
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 80, 180, 28);
        add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(70, 140, 100, 23);
        login.setBackground(Color.blue);
        login.setForeground(Color.white);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma",Font.BOLD,18));
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(250, 140, 100, 23);
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,18));
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(360,20,200,200);
        add(image);
        
        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login){
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            String query = "select * from login where username='"+username+"' and password='"+password+"'";
            try{
                Cons c = new Cons();
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()) {
                    setVisible(false);
                    new Project();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid usernme or password!");
                    setVisible(false);                
                }
                c.s.close();
            }catch(Exception e){
                e.printStackTrace();
            }      
          
        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Login();
    }

    
        
    }

