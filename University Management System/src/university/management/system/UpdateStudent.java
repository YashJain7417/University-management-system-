
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener{
    
    JTextField tfcourse,taddress,tfphn,tmail,tadhar,tfbranch;
    JLabel lblroll;
    JButton submit,cancel;
    Choice crollno;
    
    UpdateStudent() {
        
        setSize(900,650);
        setLocation(350,50);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(110, 30, 500, 50);
        heading.setFont(new Font("serif",Font.ITALIC, 30));
        add(heading);
        
        JLabel lblrollno = new JLabel("Select Roll Number");
        lblrollno.setBounds(50, 100, 200, 20);
        lblrollno.setFont(new Font("serif",Font.PLAIN, 20));
        add(lblrollno);
        
        crollno = new Choice();
        crollno.setBounds(250,100,200,20);
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
        name.setBounds(60, 140, 200, 40);
        name.setFont(new Font("serif",Font.BOLD, 20));
        add(name);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(180,145,180,30);
        labelname.setFont(new Font("tahoma",Font.PLAIN, 15));
        add(labelname);
        
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(450, 140, 200, 40);
        fname.setFont(new Font("serif",Font.BOLD, 20));
        add(fname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(620,145,180,30);
        labelfname.setFont(new Font("tahoma",Font.PLAIN, 15));
        add(labelfname);
        
        JLabel roll = new JLabel("Roll Number :");
        roll.setBounds(60, 190, 200, 40);
        roll.setFont(new Font("serif",Font.BOLD, 20));
        add(roll);
        
        lblroll = new JLabel();
        lblroll.setBounds(220, 190, 200, 40);
        lblroll.setFont(new Font("tahoma",Font.BOLD, 14));
        add(lblroll);
        
        
        
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(450, 190, 200, 40);
        dob.setFont(new Font("serif",Font.BOLD, 20));
        add(dob);
        
        JLabel labeldoc = new JLabel();
        labeldoc.setBounds(620,195,180,30);
        labeldoc.setFont(new Font("tahoma",Font.PLAIN, 15));
        add(labeldoc);
        
        JLabel address = new JLabel("Address");
        address.setBounds(60, 240, 200, 40);
        address.setFont(new Font("serif",Font.BOLD, 20));
        add(address);
        
        taddress = new JTextField();
        taddress.setBounds(180,245,180,30);
        add(taddress);
        
        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(450, 240, 200, 40);
        phone.setFont(new Font("serif",Font.BOLD, 20));
        add(phone);
        
        tfphn = new JTextField();
        tfphn.setBounds(620,245,180,30);
        add(tfphn);
        
        JLabel email = new JLabel("Email Id");
        email.setBounds(60, 290, 200, 40);
        email.setFont(new Font("serif",Font.BOLD, 20));
        add(email);
        
        tmail = new JTextField();
        tmail.setBounds(180,295,180,30);
        add(tmail);
        
        JLabel Xmarks = new JLabel("Class X (%)");
        Xmarks.setBounds(450, 290, 200, 40);
        Xmarks.setFont(new Font("serif",Font.BOLD, 20));
        add(Xmarks);
        
        JLabel xmarks = new JLabel();
        xmarks.setBounds(620,295,180,30);
        xmarks.setFont(new Font("tahoma",Font.PLAIN, 15));
        add(xmarks);
        
        JLabel XIImarks = new JLabel("Class XII (%)");
        XIImarks.setBounds(60, 340, 200, 40);
        XIImarks.setFont(new Font("serif",Font.BOLD, 20));
        add(XIImarks);
        
        JLabel xxmarks = new JLabel();
        xxmarks.setBounds(190,345,180,30);
        xxmarks.setFont(new Font("tahoma",Font.PLAIN, 15));
        add(xxmarks);
        
        JLabel adhar = new JLabel("Aadhar Number");
        adhar.setBounds(450, 340, 200, 40);
        adhar.setFont(new Font("serif",Font.BOLD, 20));
        add(adhar);
        
        tadhar = new JTextField();
        tadhar.setBounds(620,345,180,30);
        add(tadhar);
        
        JLabel courses = new JLabel("Courses");
        courses.setBounds(60, 390, 200, 40);
        courses.setFont(new Font("serif",Font.BOLD, 20));
        add(courses);
        
        tfcourse = new JTextField();
        tfcourse.setBounds(180,395,180,30);
        add(tfcourse);
        
        JLabel branch = new JLabel("Branch");
        branch.setBounds(450, 390, 200, 40);
        branch.setFont(new Font("serif",Font.BOLD, 20));
        add(branch);
        
        tfbranch = new JTextField();
        tfbranch.setBounds(620,395,180,30);
        add(tfbranch);
        
        try{
            Cons c = new Cons();
            String query  = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldoc.setText(rs.getString("dob"));
                taddress.setText(rs.getString("address"));
                tfphn.setText(rs.getString("phone"));
                tmail.setText(rs.getString("email"));
                xmarks.setText(rs.getString("x"));
                xxmarks.setText(rs.getString("xii"));
                tadhar.setText(rs.getString("adhar"));
                lblroll.setText(rs.getString("rollno"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
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
                        lblroll.setText(rs.getString("rollno"));
                        labeldoc.setText(rs.getString("dob"));
                        taddress.setText(rs.getString("address"));
                        tfphn.setText(rs.getString("phone"));
                        tmail.setText(rs.getString("email"));
                        xmarks.setText(rs.getString("x"));
                        xxmarks.setText(rs.getString("xii"));
                        tadhar.setText(rs.getString("adhar"));
                        tfcourse.setText(rs.getString("course"));
                        tfbranch.setText(rs.getString("branch"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
            }
        });
        
        submit = new JButton("Update");
        submit.setBounds(210, 490, 150, 28);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,18));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(490, 490, 150, 28);
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,18));
        add(cancel);
        
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String rollno = lblroll.getText();
            String address = taddress.getText();
            String phone = tfphn.getText();
            String email = tmail.getText();
            String adhar = tadhar.getText();
            String course = tfcourse.getText();
            String branch = tfbranch.getText();
            
            try{
                String query = "update student set address='"+address+"',phone='"+phone+"',email='"+email+"',adhar='"+adhar+"',course='"+course+"',branch='"+branch+"' where rollno='"+rollno+"'";
                Cons con = new Cons();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new UpdateStudent();
    }
}
