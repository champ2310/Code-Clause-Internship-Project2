package hotel.management.system;
/**
 * @author onkar
 */
import javax.swing.*;
//import java.sql.*;	
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame implements  ActionListener {

        JButton btncustomer,btnroom,btndepartment,
                btnEmpInfo,btnCustInfo,btnManagerInfo,btnCheckout,
                btnStatus,btnRoomStatus,btnLogout,btnPickUpSerice,btnSearchRoom;
	
        

	Reception(){
		// frame size
                getContentPane().setBackground(Color.WHITE);
                setLayout(null);
                setBounds(330, 150, 850, 570);
		
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
                JLabel image=new JLabel(i1);
                image.setBounds(250,30,500,470);
                add(image);
		
		btncustomer = new JButton("New Customer Form");  // first button
		btncustomer.setBounds(10, 30, 200, 30);
                btncustomer.setBackground(Color.BLACK);
                btncustomer.setForeground(Color.WHITE);
                btncustomer.addActionListener(this);
		add(btncustomer);
		
		btnroom = new JButton("Room"); // second button
		btnroom.setBounds(10, 70, 200, 30);
                btnroom.setBackground(Color.BLACK);
                btnroom.setForeground(Color.WHITE);
                btnroom.addActionListener(this);
                add(btnroom);
		
		btndepartment = new JButton("Department"); // third button
		btndepartment.setBounds(10, 110, 200, 30);
                btndepartment.setBackground(Color.BLACK);
                btndepartment.setForeground(Color.WHITE);
                btndepartment.addActionListener(this);
		add(btndepartment);
		
		btnEmpInfo = new JButton("All Employee Info");  // fourth button
		btnEmpInfo.setBounds(10, 150, 200, 30);                
                btnEmpInfo.setBackground(Color.BLACK);
                btnEmpInfo.setForeground(Color.WHITE);
                btnEmpInfo.addActionListener(this);
		add(btnEmpInfo);
		
		btnCustInfo = new JButton("Customer Info");  // fifth button
		btnCustInfo.setBounds(10, 190, 200, 30);
                btnCustInfo.setBackground(Color.BLACK);
                btnCustInfo.setForeground(Color.WHITE);
                btnCustInfo.addActionListener(this);
		add(btnCustInfo);
		
		btnManagerInfo = new JButton("Manager Info");  // sixth button
		btnManagerInfo.setBounds(10, 230, 200, 30);
                btnManagerInfo.setBackground(Color.BLACK);
                btnManagerInfo.setForeground(Color.WHITE);
                btnManagerInfo.addActionListener(this);
		add(btnManagerInfo);
		
		btnCheckout = new JButton("Check Out");  // seven button
		btnCheckout.setBounds(10, 270, 200, 30);
                btnCheckout.setBackground(Color.BLACK);
                btnCheckout.setForeground(Color.WHITE);
                btnCheckout.addActionListener(this);
		add(btnCheckout);
		
		btnStatus = new JButton("Update Check Status");  // eight button
		btnStatus.setBounds(10, 310, 200, 30);
                btnStatus.setBackground(Color.BLACK);
                btnStatus.setForeground(Color.WHITE);
                btnStatus.addActionListener(this);
		add(btnStatus);
		
		btnRoomStatus = new JButton("Update Room Status");  // nine button
		btnRoomStatus.setBounds(10, 350, 200, 30);
                btnRoomStatus.setBackground(Color.BLACK);
                btnRoomStatus.setForeground(Color.WHITE);
                btnRoomStatus.addActionListener(this);
		add(btnRoomStatus);
		
		btnPickUpSerice = new JButton("Pick up Service");  // ten button
		btnPickUpSerice.setBounds(10, 390, 200, 30);
                btnPickUpSerice.setBackground(Color.BLACK);
                btnPickUpSerice.setForeground(Color.WHITE);
                btnPickUpSerice.addActionListener(this);
		add(btnPickUpSerice);
		
		btnSearchRoom = new JButton("Search Room");  // elevan button
		btnSearchRoom.setBounds(10, 430, 200, 30);
                btnSearchRoom.setBackground(Color.BLACK);
                btnSearchRoom.setForeground(Color.WHITE);
                btnSearchRoom.addActionListener(this);
		add(btnSearchRoom);

		btnLogout = new JButton("Log Out");  // twelve button
		btnLogout.setBounds(10, 470, 200, 30);
                btnLogout.setBackground(Color.BLACK);
                btnLogout.setForeground(Color.WHITE);
                btnLogout.addActionListener(this);
		add(btnLogout);
                
                getContentPane().setBackground(Color.WHITE);
                setVisible(true);
	}
        
    public void actionPerformed (ActionEvent ae){
           
        if (ae.getSource() == btncustomer){
                setVisible(false);
                new NewCustomer();
            } else if (ae.getSource() == btnroom){
                setVisible(false);
                new Room();
            } else if (ae.getSource() == btndepartment){
                setVisible(false);
                new Department();
            }else if(ae.getSource()== btnEmpInfo){
                setVisible(false);
                new Employee();
            }  else if(ae.getSource()== btnCustInfo){
                setVisible(false);
                new CustomerInfo();
            } else if(ae.getSource()== btnManagerInfo){
                setVisible(false);
                new ManagerInfo();
            }  else if(ae.getSource()== btnCheckout ){
                setVisible(false);
                new CheckOut();
            }else if(ae.getSource()== btnStatus ){
                setVisible(false);
                new UpdateCheck();
            } else if(ae.getSource()== btnRoomStatus ){
                setVisible(false);
                new UpdateRoom ();
            } else if(ae.getSource()== btnPickUpSerice ){
                setVisible(false);
                new PickUp ();
            } else if(ae.getSource()== btnSearchRoom ){ 
                setVisible(false);
                new SearchRoom ();
            } else if (ae.getSource()== btnLogout ){ 
                setVisible(false);
                new Login ();
            }
      
            
            
    }
        public static void main(String[] args) {
		new Reception();
	}
}
