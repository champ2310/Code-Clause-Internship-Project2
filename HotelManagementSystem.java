package hotel.management.system;

/**
 * @author onkar
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

        JLabel l1;
        JButton b1;
        
        public HotelManagementSystem() {
		
               setSize(1366,565);          // setContentPane(300,300,1366,390);   frame size
                //setBound(0,0,1366,565);
                setLayout(null);
                setLocation(100,100);

		l1 = new JLabel("");
                b1 = new JButton("Enter");
                
                b1.setBackground(Color.YELLOW);
                b1.setForeground(Color.BLACK);
                b1.setBounds(1150,450,150,50);
                b1.setFont(new Font("serif",Font.PLAIN,30));
				
                
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
               Image i3 = i1.getImage().getScaledInstance(1366, 590,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);
                
                JLabel lid=new JLabel("HOTEL MANAGEMENT SYSTEM");
                lid.setBounds(20,430,1000,90);
                lid.setFont(new Font("serif",Font.PLAIN,50));
                lid.setForeground(Color.white);
                l1.add(lid);
                
                

		l1.setBounds(0, 0, 1366, 565);
                
                l1.add(b1);
		add(l1);
 
                b1.addActionListener(this);
                setVisible(true);
                
                while(true){
                        lid.setVisible(false); // lid =  j label
                    try{
                        Thread.sleep(500); //1000 = 1 second
                    }catch(Exception e){} 
                        lid.setVisible(true);
                    try{
                        Thread.sleep(500);
                    }catch(Exception e){}
                }
	}
        
        public void actionPerformed(ActionEvent ae){
                new Login().setVisible(true);
                this.setVisible(false);
                
        }
        
        public static void main(String[] args) {
                HotelManagementSystem window = new HotelManagementSystem();
                window.setVisible(true);			
	}
}

