package hotel.management.system;
/**
 * @author onkar
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Dashboard extends JFrame{

    
    
    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
    
    public Dashboard() {
        super("HOTEL MANAGEMENT SYSTEM");
	
        setForeground(Color.CYAN);
        setLayout(null); 

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(0, 0, 1950, 1000); 
        add(NewLabel);
        
        JLabel HotelManagementSystem = new JLabel("THE CHAMP HOTEL WELCOMES YOU");
	HotelManagementSystem.setForeground(Color.WHITE);
        HotelManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 46));
	HotelManagementSystem.setBounds(400, 80, 1000, 50);
	NewLabel.add(HotelManagementSystem);
		
		
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
		
        JMenu HotelSystem = new JMenu("HOTEL MANAGEMENT");
        HotelSystem.setForeground(Color.BLUE);
	menuBar.add(HotelSystem);
		
        JMenuItem ReceptionDetails = new JMenuItem("RECEPTION");
	HotelSystem.add(ReceptionDetails);
		
	JMenu AdminSystem = new JMenu("ADMIN");
        AdminSystem.setForeground(Color.RED);
	menuBar.add(AdminSystem);
        
        JMenuItem AddEmp = new JMenuItem("ADD EMPLOYEE");
	AdminSystem.add(AddEmp);
        
        AddEmp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddEmployee().setVisible(true);
                }catch(Exception e ){}
            }
	});
        

        JMenuItem AddRoom = new JMenuItem("ADD ROOMS");
	AdminSystem.add(AddRoom);
        
        AddRoom.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddRoom().setVisible(true);
                }catch(Exception e ){}
            }
	});
        

	ReceptionDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Reception();
            }
	});
        
        
        JMenuItem AddDrivers = new JMenuItem("ADD DRIVERS");
	AdminSystem.add(AddDrivers);
        
	AddDrivers.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddDrivers().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
		
       setExtendedState(JFrame.MAXIMIZED_BOTH);
        
       // setSize(2000,1090);
	setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}
