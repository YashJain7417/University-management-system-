
package university.management.system;
import javax.swing.*;
import java.awt.*;

public class About extends JFrame{
    About(){
        setSize(700,500);
        setLocation(400,150);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,300,200);
        add(image);
        
        JLabel heading = new JLabel("<html>UNIVERSITY<br>MANAGEMENT SYSTEM</html>");
        heading.setBounds(70,20,300,130);
        heading.setFont(new Font("Tahoma", Font.BOLD,30));
        add(heading);
        
        JLabel name = new JLabel("Developed By:  YASH JAIN");
        name.setBounds(70,220,400,30);
        name.setFont(new Font("serif", Font.BOLD,30));
        add(name);
        
        JLabel cname = new JLabel("College :  Meerut Institute Of Engineering And Technology");
        cname.setBounds(70,320,550,30);
        cname.setFont(new Font("serif", Font.BOLD,20));
        add(cname);
        
        JLabel rname = new JLabel("Roll Number:  2000680100368 (AKTU)");
        rname.setBounds(70,280,550,30);
        rname.setFont(new Font("serif", Font.BOLD,20));
        add(rname);
        
        JLabel lname = new JLabel("<html>Language Used :  JAVA<br>Database Used: MySQL</html>");
        lname.setBounds(70,370,550,40);
        lname.setFont(new Font("serif", Font.BOLD,15));
        add(lname);
        
        JLabel ctname = new JLabel("Contact Us: yashjain74170@gmail.com");
        ctname.setBounds(70,410,550,30);
        ctname.setFont(new Font("serif", Font.BOLD,15));
        add(ctname);
        
        setVisible(true);
    }
    
    public static void main(String[] args){
        new About();
    }
}
