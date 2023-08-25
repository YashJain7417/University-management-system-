package university.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class FeeForm extends JFrame implements ActionListener{ 
    
    Choice crollno;
    JComboBox cbcourses,cbbranch,cbsemester;
    JLabel labeltotal;
    JButton submit,cancel,cancel1;
    
    FeeForm(){
        setSize(900,500);
        setLocation(300,100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
        
        JLabel lblrollno = new JLabel("Select Roll No.");
        lblrollno.setBounds(40, 60, 150, 20);
        lblrollno.setFont(new Font("tahoma",Font.BOLD, 16));
        add(lblrollno);
        
        crollno = new Choice();
        crollno.setBounds(200,60,150,20);
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
        
        JLabel name = new JLabel("Name");
        name.setBounds(40, 100, 150, 20);
        name.setFont(new Font("tahoma",Font.BOLD, 16));
        add(name);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(200,100,150,20);
        labelname.setFont(new Font("tahoma",Font.PLAIN, 15));
        add(labelname);
        
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(40, 140, 150, 20);
        fname.setFont(new Font("tahoma",Font.BOLD, 16));
        add(fname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(200,140,150,20);
        labelfname.setFont(new Font("tahoma",Font.PLAIN, 16));
        add(labelfname);
        
        try{
            Cons c = new Cons();
            String query  = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Cons c = new Cons();
                    String query  = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
            }
        });
        
        JLabel courses = new JLabel("Courses");
        courses.setBounds(40, 180, 150, 20);
        courses.setFont(new Font("tahoma",Font.BOLD, 16));
        add(courses);
        
        String course[] = {"B.Tech","BBA","MBA","BSc","BCA","MCA","B.Pharma","M.Pharma","M.tech"};
        cbcourses = new JComboBox(course);
        cbcourses.setBounds(200,180,150,20);
        cbcourses.setBackground(Color.WHITE);
        add(cbcourses);
        
        JLabel branch = new JLabel("Branch");
        branch.setBounds(40, 220, 150, 20);
        branch.setFont(new Font("tahoma",Font.BOLD, 16));
        add(branch);
        
        String brnch[] = {"Computer Science","Electronics","Civil","IT","BioTech","Aerospace","Others"};
        cbbranch = new JComboBox(brnch);
        cbbranch.setBounds(200,220,150,20);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(40, 260, 150, 20);
        lblsemester.setFont(new Font("tahoma",Font.BOLD, 16));
        add(lblsemester);
        
        String semester[] = {"Semester1", "Semester2","Semester3","Semester4","Semester5","Semester6","Semester7","Semester8"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200,260,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lbltotal = new JLabel("Total Payable");
        lbltotal.setBounds(40, 300, 150, 20);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD, 16));
        add(lbltotal);
        
        labeltotal= new JLabel();
        labeltotal.setBounds(200, 300, 150, 20);
        labeltotal.setFont(new Font("Tahoma",Font.PLAIN, 16));
        add(labeltotal);
        
        submit = new JButton("Update");
        submit.setBounds(30, 380, 110, 25);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,18));
        add(submit);
        
        cancel = new JButton("Pay Fee");
        cancel.setBounds(160, 380, 110, 25);
        cancel.setBackground(Color.green);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,18));
        add(cancel);
        
        cancel1 = new JButton("Back");
        cancel1.setBounds(290, 380, 110, 25);
        cancel1.setBackground(Color.red);
        cancel1.setForeground(Color.white);
        cancel1.addActionListener(this);
        cancel1.setFont(new Font("Tahoma",Font.BOLD,18));
        add(cancel1);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String course = (String)cbcourses.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            try{
                Cons c =  new Cons();
                ResultSet rs = c.s.executeQuery("select * from fee where course = '"+course+"'");
                while(rs.next()){
                    labeltotal.setText(rs.getString(semester));
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == cancel){
            String rollno = crollno.getSelectedItem();
            String course = (String)cbcourses.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            String total = labeltotal.getText();
            
            try{
                Cons c =  new Cons();
                String query = "insert into collegefee values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
                
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"College fee submitted Successfully");
                setVisible(false);
                }
            
            catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    
    
    public static void main(String[] srgs){
        new FeeForm();
            
        
    }
}
