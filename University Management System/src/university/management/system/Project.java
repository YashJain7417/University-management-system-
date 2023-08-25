
package university.management.system;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;


public class Project extends JFrame implements ActionListener{
    Project(){
        setSize(1680,850);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        //menubar
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE );
        mb.add(newInformation);
        
        JMenuItem facultyinfo = new JMenuItem("New Faculty Information");
        facultyinfo.setBackground(Color.WHITE);
        facultyinfo.addActionListener(this);
        newInformation.add(facultyinfo);
        
        JMenuItem stdntinfo = new JMenuItem("New Student Information");
        stdntinfo.setBackground(Color.WHITE);
        stdntinfo.addActionListener(this);
        newInformation.add(stdntinfo);
        //details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED );
        mb.add(details);
        
        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);
        
        JMenuItem stdntdetails = new JMenuItem("View Student Details");
        stdntdetails.setBackground(Color.WHITE);
        stdntdetails.addActionListener(this);
        details.add(stdntdetails);
        
        //leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE );
        mb.add(leave);
        
        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);
        
        JMenuItem stdntleave = new JMenuItem("Student Leave");
        stdntleave.setBackground(Color.WHITE);
        stdntleave.addActionListener(this);
        leave.add(stdntleave);
        
        //leave details
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.RED );
        mb.add(leaveDetails);
        
        JMenuItem facultyleaveDetails = new JMenuItem("Faculty Leave Details");
        facultyleaveDetails.setBackground(Color.WHITE);
        facultyleaveDetails.addActionListener(this);
        leaveDetails.add(facultyleaveDetails);
        
        JMenuItem stdntleaveDetails = new JMenuItem("Student Leave Details");
        stdntleaveDetails.setBackground(Color.WHITE);
        stdntleaveDetails.addActionListener(this);
        leaveDetails.add(stdntleaveDetails);
        
        //Exams
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE );
        mb.add(exam);
        
        JMenuItem examdetails = new JMenuItem("Examination Details");
        examdetails.setBackground(Color.WHITE);
        examdetails.addActionListener(this);
        exam.add(examdetails);
        
        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);
        
        //UpdateInfo
        JMenu updateinfo = new JMenu("Update Details");
        updateinfo.setForeground(Color.RED );
        mb.add(updateinfo);
        
        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.WHITE);
        updatefacultyinfo.addActionListener(this);
        updateinfo.add(updatefacultyinfo);
        
        JMenuItem updatestudentsinfo = new JMenuItem("Update Student Details");
        updatestudentsinfo.setBackground(Color.WHITE);
        updatestudentsinfo.addActionListener(this);
        updateinfo.add(updatestudentsinfo);
        
        //Fee
        JMenu Fee = new JMenu("Fee Details");
        Fee.setForeground(Color.BLUE );
        mb.add(Fee);
        
        JMenuItem Feestructure = new JMenuItem("Fee Structure");
        Feestructure.setBackground(Color.WHITE);
        Feestructure.addActionListener(this);
        
        Fee.add(Feestructure);
        
        JMenuItem Feeform = new JMenuItem("Student Fee Form");
        Feeform.setBackground(Color.WHITE);
        Feeform.addActionListener(this);
        Fee.add(Feeform);
        
        //Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED );
        mb.add(utility);
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.WHITE);
        calculator.addActionListener(this);
        utility.add(calculator);
        
        //About
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE );
        mb.add(about);
        
        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);
        
        //exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED );
        mb.add(exit);
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
        
   
        
        setJMenuBar(mb);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        
        if(msg.equals("Exit")){
            setVisible(false);
        }
         else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e) {
                
            }
        }
        else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e) {
                
            }    
        }
        else if (msg.equals("New Faculty Information")){
            new AddFaculty();
        }
        else if (msg.equals("New Student Information")){
            new AddStudent();
        }
        else if (msg.equals("View Faculty Details")){
            new FacultyDetails();
        }
        else if (msg.equals("View Student Details")){
            new StudentDetails();
        }
        else if (msg.equals("Faculty Leave")){
            new FacultyLeave();
        }
        else if (msg.equals("Student Leave")){
            new StudentLeave();
        }
        else if (msg.equals("Faculty Leave Details")){
            new FacultyLeaveDetails();
        }
        else if (msg.equals("Student Leave Details")){
            new StudentLeaveDetails();
        }
        else if (msg.equals("Update Faculty Details")){
            new UpdateFaculty();
        }
        else if (msg.equals("Update Student Details")){
            new UpdateStudent();
        }
        else if (msg.equals("Enter Marks")){
            new EnterMarks();
        }
        else if (msg.equals("Examination Details")){
            new ExaminationDetails();
        }
        else if (msg.equals("Fee Structure")){
            new FeeStructure();
        }
        else if (msg.equals("About")){
            new About();
        }
        else if (msg.equals("Student Fee Form")){
            new FeeForm();
        }
    }
    
    public static void main(String[] args){
        new Project(); 
    }
    
}
