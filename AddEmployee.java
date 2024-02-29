package hotel.management.system;

/**
 * @author onkar
 */

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddEmployee extends JFrame{ //Third Frame

        JLabel lbname,lbage,lbgender,lbaddress,lbsalary,lbphone,lbadhar,lbemail,lbaddemp;
	JTextField tfname,tfage,tfsalary,tfphone,tfadhar,tfemail;
        JComboBox c1;

        public AddEmployee(){
            setBounds(330,200,940,470);
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ADD EMPLOYEE DETAILS");
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            getContentPane().setLayout(null);
			
            lbname = new JLabel("NAME");
            lbname.setFont(new Font("Tahoma", Font.PLAIN, 17));
            lbname.setBounds(60, 30, 150, 27);
            add(lbname);
            
            tfname = new JTextField();
            tfname.setBounds(200, 30, 150, 27);
            add(tfname);
				
            lbage = new JLabel("AGE");
            lbage.setFont(new Font("Tahoma", Font.PLAIN, 17));
            lbage.setBounds(60, 80, 150, 27);
            add(lbage);
			
            tfage = new JTextField();
            tfage.setBounds(200, 80, 150, 27);
            add(tfage);
            
            lbgender = new JLabel("GENDER");
            lbgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
            lbgender.setBounds(60, 130, 120, 27);
            add(lbgender);
		
            // RadioButton One
            JRadioButton Male = new JRadioButton("MALE");
            Male.setFont(new Font("Tahoma", Font.PLAIN, 12));
            Male.setBackground(Color.WHITE);
            Male.setBounds(200, 130, 70, 27);
            add(Male);
	            
            // RadioButton Two
            JRadioButton Female = new JRadioButton("FEMALE");
            Female.setFont(new Font("Tahoma", Font.PLAIN, 12));
            Female.setBackground(Color.WHITE);
            Female.setBounds(270, 130, 70, 27);
            add(Female);
            
            ButtonGroup bg=new ButtonGroup();
            bg.add(Male);
            bg.add(Female);
            
            lbaddress = new JLabel("JOB");
            lbaddress.setFont(new Font("Tahoma", Font.PLAIN, 17));
            lbaddress.setBounds(60, 170, 150, 27);
            add(lbaddress);
			
            String course[] = {"Select","Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
            c1 = new JComboBox(course);
            c1.setBackground(Color.WHITE);
            c1.setBounds(200,170,150,30);
            add(c1);
            		
            lbsalary= new JLabel("SALARY");
            lbsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
            lbsalary.setBounds(60, 220, 150, 27);
            add(lbsalary);
			
            tfsalary = new JTextField();
            tfsalary.setBounds(200, 220, 150, 27);
            add(tfsalary);
	
            lbphone = new JLabel("PHONE");
            lbphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
            lbphone.setBounds(60, 270, 150, 27);
            add(lbphone);
	
            tfphone = new JTextField();
            tfphone.setBounds(200, 270, 150, 27);
            add(tfphone);
	
            lbadhar = new JLabel("AADHAR");
            lbadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
            lbadhar.setBounds(60, 320, 150, 27);
            add(lbadhar);
			
            tfadhar = new JTextField();
            tfadhar.setBounds(200, 320, 150, 27);
            add(tfadhar);
	
            
            lbemail = new JLabel("EMAIL");
            lbemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
            lbemail.setBounds(60, 370, 150, 27);
            add(lbemail);
			
            tfemail = new JTextField();
            tfemail.setBounds(200, 370, 150, 27);
            add(tfemail);
            
            JButton Next = new JButton("SAVE");
            Next.setBounds(200, 420, 150, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            add(Next);
	
            setVisible(true);
	
            lbaddemp = new JLabel("ADD EMPLOYEE DETAILS");
            lbaddemp.setForeground(Color.green);
            lbaddemp.setFont(new Font("Tahoma", Font.PLAIN, 31));
            lbaddemp.setBounds(450, 24, 442, 35);
            add(lbaddemp);
			
     
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
            Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(410,80,480,410);
            add(image);

            
            Next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    String name = tfname.getText();
                    String age = tfage.getText();
                    String salary = tfsalary.getText();
                    String phone = tfphone.getText();
                    String aadhar = tfadhar.getText();
                    String email = tfemail.getText();
                    String gender = null;
                    
                    if(Male.isSelected()){
                        gender = "male";
                    
                    }else if(Female.isSelected()){
                        gender = "female";
                    }

                    String job = (String) c1.getSelectedItem();
                    
                    try {
                        Conn c = new Conn();
                        String query = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"','"+email+"', '"+aadhar+"')";
                        
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"New Employee Added Successfully");
                        setVisible(false);
                    
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
		}
            });
			
            setSize(900,600);
            setVisible(true);
            setLocation(350,200);
			
	}
        
    public static void main(String[] args){
        new AddEmployee();
    }   
}