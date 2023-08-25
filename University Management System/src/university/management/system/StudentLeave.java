
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class StudentLeave extends JFrame implements ActionListener{
    
    Choice crollno,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    
    
    StudentLeave(){
        
        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Apply Leave(Student)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        JLabel lblroll = new JLabel("Search by Roll Number");
        lblroll.setBounds(60, 100, 200, 20);
        lblroll.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lblroll);
        
        crollno = new Choice();
        crollno.setBounds(60,130,200,20);
        add(crollno);
        
        try{
            Cons c = new Cons();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
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
            String rollno = crollno.getSelectedItem();
            String date = (String)((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            
            String query = "insert into studentleave values('"+rollno+"','"+date+"','"+duration+"')";
            
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
        new StudentLeave();
            
       
    }
}
