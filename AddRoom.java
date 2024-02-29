package hotel.management.system;

/**
 *
 * @author onkar
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddRoom extends JFrame implements ActionListener{

    private JPanel contentPane;
    
    private JTextField t1,t2;
    private JComboBox comboBox1, comboBox2, comboBox3;
    JLabel l1,l2,l3,l4,l5,l6;
    //b1= Add buton
    //b2=Cancel Button
    JButton b1,b2;
    Choice c1;
    

    public static void main(String[] args) {
        new AddRoom().setVisible(true);
    }


    public AddRoom() {
        setBounds(330, 200, 940, 470);
        setTitle("The Champ Hotel");
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l15 = new JLabel(i2);
                l15.setBounds(400,30,500,370);
                add(l15);
        
        l1 = new JLabel("Add Rooms");
        l1.setFont(new Font("Tahoma", Font.BOLD, 18));
	l1.setBounds(194, 10, 120, 22);
	contentPane.add(l1);
	
        
	l2 = new JLabel("Room Number");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(60, 70, 120, 20);
	contentPane.add(l2);
        t1 = new JTextField();
	t1.setBounds(174, 70, 156, 20);
	contentPane.add(t1);
        

	l3 = new JLabel("Availability");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(60, 110, 102, 22);
	contentPane.add(l3);
        comboBox1= new JComboBox(new String[] { "Available", "Occupied" });
	comboBox1.setBounds(176, 110, 154, 20);
	contentPane.add(comboBox1);


	l4 = new JLabel("Status");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(60, 150, 102, 22);
	contentPane.add(l4);
        comboBox2 = new JComboBox(new String[] { "Cleaned", "Dirty" });
	comboBox2.setBounds(176, 150, 154, 20);
	contentPane.add(comboBox2);
        
        l6 = new JLabel("Bed Type");
	l6.setForeground(new Color(25, 25, 112));
	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
	l6.setBounds(60, 190, 102, 22);
	contentPane.add(l6);
        comboBox3 = new JComboBox(new String[] { "Choose","Single Bed", "Double Bed"});
	comboBox3.setBounds(174, 190, 156, 20);
	contentPane.add(comboBox3);
        
 
	l5 = new JLabel("Price");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(60, 230, 102, 22);
	contentPane.add(l5);
        t2 = new JTextField();
	t2.setBounds(176, 230, 154, 20);
        contentPane.add(t2);

        
	b1 = new JButton("Add"); //b1=Add button
	b1.addActionListener(this);
	b1.setBounds(64, 321, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back"); //b2=back button
	b2.addActionListener(this);
	b2.setBounds(198, 321, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	
        contentPane.setBackground(Color.WHITE);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                try{
                Conn c = new Conn();
                String roomnumber = t1.getText();
                String availablity = (String)comboBox1.getSelectedItem();
                String cleaning_status = (String)comboBox2.getSelectedItem();
                String price  = t2.getText();
                String bed_type = (String)comboBox3.getSelectedItem();
                String str = "INSERT INTO room values( '"+roomnumber+"', '"+availablity+"', '"+cleaning_status+"','"+price+"', '"+bed_type+"')";
              
                
		c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "New Room Added Successfully");
                this.setVisible(false);
               
                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == b2){
                this.setVisible(false);
            }
        }catch(Exception eee){
            
        }
    }
}

