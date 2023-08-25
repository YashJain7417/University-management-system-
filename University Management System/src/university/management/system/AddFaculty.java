
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddFaculty extends JFrame implements ActionListener{
    
    JTextField tfname,tffname,taddress,tfphn,tmail,txmarks,txxmarks,tadhar;
    JLabel lblemploy;
    JDateChooser dcdob;
    JComboBox cbcourses,cbbranch;
    JButton submit,cancel;
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L)+ 1000L);
    
    AddFaculty() {
        
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        
        JLabel heading = new JLabel("New Faculty Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif",Font.BOLD, 30));
        add(heading);
        
        JLabel name = new JLabel("Name");
        name.setBounds(60, 140, 200, 40);
        name.setFont(new Font("serif",Font.BOLD, 20));
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(180,145,180,30);
        add(tfname);
        
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(450, 140, 200, 40);
        fname.setFont(new Font("serif",Font.BOLD, 20));
        add(fname);
        
        tffname = new JTextField();
        tffname.setBounds(620,145,180,30);
        add(tffname);
        
        JLabel employ = new JLabel("Employee Id :");
        employ.setBounds(60, 190, 200, 40);
        employ.setFont(new Font("serif",Font.BOLD, 20));
        add(employ);
        
        lblemploy = new JLabel("101"+first4);
        lblemploy.setBounds(220, 190, 200, 40);
        lblemploy.setFont(new Font("serif",Font.BOLD, 20));
        add(lblemploy);
        
        
        
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(450, 190, 200, 40);
        dob.setFont(new Font("serif",Font.BOLD, 20));
        add(dob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(620,195,180,30);
        add(dcdob);
        
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
        
        txmarks = new JTextField();
        txmarks.setBounds(620,295,180,30);
        add(txmarks);
        
        JLabel XIImarks = new JLabel("Class XII (%)");
        XIImarks.setBounds(60, 340, 200, 40);
        XIImarks.setFont(new Font("serif",Font.BOLD, 20));
        add(XIImarks);
        
        txxmarks = new JTextField();
        txxmarks.setBounds(180,345,180,30);
        add(txxmarks);
        
        JLabel adhar = new JLabel("Aadhar Number");
        adhar.setBounds(450, 340, 200, 40);
        adhar.setFont(new Font("serif",Font.BOLD, 20));
        add(adhar);
        
        tadhar = new JTextField();
        tadhar.setBounds(620,345,180,30);
        add(tadhar);
        
        JLabel courses = new JLabel("Qualificaation ");
        courses.setBounds(60, 390, 150, 40);
        courses.setFont(new Font("serif",Font.BOLD, 20));
        add(courses);
        
        String course[] = {"B.Tech","BBA","MBA","BSc","MSc","BCA","MCA","BPharma","MPharma","B Ed","M Ed","Others"};
        cbcourses = new JComboBox(course);
        cbcourses.setBounds(180,395,180,30);
        cbcourses.setBackground(Color.WHITE);
        add(cbcourses);
        
        JLabel branch = new JLabel("Department");
        branch.setBounds(450, 390, 200, 40);
        branch.setFont(new Font("serif",Font.BOLD, 20));
        add(branch);
        
        String brnch[] = {"Computer Science","Electronics","Civil","IT","BioTech","Aerospace","Others","Science","English","Hinsi","Sanskrit","Others"};
        cbbranch = new JComboBox(brnch);
        cbbranch.setBounds(620,395,180,30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        submit = new JButton("Submit");
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
            String name = tfname.getText();
            String fname = tffname.getText();
            String employid = lblemploy.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address = taddress.getText();
            String phone = tfphn.getText();
            String email = tmail.getText();
            String x = txmarks.getText();
            String xii = txxmarks.getText();
            String adhar = tadhar.getText();
            String h_qualification = (String) cbcourses.getSelectedItem();
            String department = (String) cbbranch.getSelectedItem();
            
            try{
                String query = "insert into faculty values('"+name+"', '"+fname+"', '"+employid+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"','"+x+"','"+xii+"','"+adhar+"','"+h_qualification+"','"+department+"')";
                Cons con = new Cons();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Faculty Details Inserted Successfully");
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
        new AddFaculty();
    }
}