
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class FacultyLeave extends JFrame implements ActionListener{
    
    Choice cemploy,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    
    
    FacultyLeave(){
        
        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Apply Leave(Faculty)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        JLabel lblemploy = new JLabel("Search by Employee Id Number");
        lblemploy.setBounds(60, 100, 200, 20);
        lblemploy.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lblemploy);
        
        cemploy = new Choice();
        cemploy.setBounds(60,130,200,20);
        add(cemploy);
        
        try{
            Cons c = new Cons();
            ResultSet rs = c.s.executeQuery("select * from faculty");
            while(rs.next()){
                cemploy.add(rs.getString("employid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60,210,200,25);
        add(dcdate);
        
        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60, 260, 200, 20);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lbltime);
        
        ctime = new Choice();
        ctime.setBounds(60,290,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        submit = new JButton("Submit");
        submit.setBounds(60, 350, 110, 25);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,18));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(230, 350, 110, 25);
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,18));
        add(cancel);
        
        setVisible(true); 
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String employid = cemploy.getSelectedItem();
            String date = (String)((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            
            String query = "insert into facultyleaves values('"+employid+"','"+date+"','"+duration+"')";
            
            try{
                Cons c = new Cons();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new FacultyLeave();
            
       
    }
}
