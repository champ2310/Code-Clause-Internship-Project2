package hotel.management.system;
/**
 * @author onkar
 */
import java.awt.BorderLayout;
import java.awt.*;

import java.sql.*;	
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.*;


public class UpdateCheck extends JFrame implements ActionListener {
	Connection conn = null;
	PreparedStatement pst = null;
	JPanel contentPane;
	JTextField tfroom,tfName,tfCheckin,tfPaid,tfAmount ;
        JButton btnUpdate,btnExit,btnCheck;
	

        Choice c1, c2;
	/**
	 * Launch the application.
	 */
	
	public void close(){
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	 UpdateCheck(){
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 950, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateCheckStatus = new JLabel("Update Status");
		lblUpdateCheckStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateCheckStatus.setBounds(124, 11, 222, 25);
		contentPane.add(lblUpdateCheckStatus);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
                JLabel l1 = new JLabel(i1);
                l1.setBounds(450,70,476,270);
                add(l1);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(25, 88, 46, 14);
		contentPane.add(lblNewLabel);
                
                c1 = new Choice();
                 c1.setBounds(248, 85, 140, 20);
		contentPane.add(c1);
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                        c1.add(rs.getString("number"));    
                    }
                }catch(Exception e){ 
                     e.printStackTrace();
                }
               
		
		JLabel lblNewLabel_1 = new JLabel("Room Number :");
		lblNewLabel_1.setBounds(25, 129, 107, 14);
		contentPane.add(lblNewLabel_1);
                tfroom = new JTextField();
                tfroom.setBounds(248, 126, 140, 20);
		contentPane.add(tfroom);
               
		JLabel lblNewLabel_2 = new JLabel("Name : ");
		lblNewLabel_2.setBounds(25, 174, 97, 14);
		contentPane.add(lblNewLabel_2);
                tfName = new JTextField();
		tfName.setBounds(248, 171, 140, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Checked-in :");
		lblNewLabel_3.setBounds(25, 216, 107, 14);
		contentPane.add(lblNewLabel_3);
                tfCheckin= new JTextField();
		tfCheckin.setBounds(248, 216, 140, 20);
		contentPane.add(tfCheckin);
		tfCheckin.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Amount Paid (Rs) : ");
		lblNewLabel_4.setBounds(25, 261, 107, 14);
		contentPane.add(lblNewLabel_4);
                tfPaid = new JTextField();
		tfPaid.setBounds(248, 258, 140, 20);
		contentPane.add(tfPaid);
		tfPaid.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Pending Amount (Rs) : ");
		lblNewLabel_5.setBounds(25, 302, 150, 14);
		contentPane.add(lblNewLabel_5);
                tfAmount = new JTextField();
		tfAmount.setBounds(248, 299, 140, 20);
		contentPane.add(tfAmount);
		tfAmount.setColumns(10);
                
                btnCheck = new JButton("Check");
                btnCheck.setBounds(56, 378, 89, 23);
                btnCheck.setBackground(Color.BLACK);
                btnCheck.setForeground(Color.WHITE);
                btnCheck.addActionListener(this);
		contentPane.add(btnCheck);
		
                
		btnUpdate  = new JButton("Update");
                btnUpdate.setBounds(168, 378, 89, 23);
                btnUpdate.setBackground(Color.BLACK);
                btnUpdate.setForeground(Color.WHITE);
                btnUpdate.addActionListener(this);
		contentPane.add(btnUpdate);
                
                btnExit = new JButton("Back");
                btnExit.setBounds(281, 378, 89, 23);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
                btnExit.addActionListener(this);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(Color.WHITE);
                setVisible(true);
         }
                
		
	public void actionPerformed(ActionEvent ae) { 
                       
            if(ae.getSource () == btnCheck){
                String id = c1.getSelectedItem();
                String query = "select * from customer where number = '"+id+"'";
                try{
                                Conn c = new Conn();
                                ResultSet rs1 = c.s.executeQuery(query);
                                
                                while(rs1.next()){
                                   tfroom.setText(rs1.getString("room"));    
                                    tfName.setText(rs1.getString("name"));    
                                    tfCheckin.setText(rs1.getString("checkintime"));    
                                   tfPaid.setText(rs1.getString("deposit"));    
                                }
                                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
                                while(rs2.next()){
                                    String price = rs2.getString("price"); 
                                    int pending = Integer.parseInt(price)- Integer.parseInt(tfPaid.getText());
                                    tfAmount.setText(""+pending);
                                            
                                }
                               
                            }catch(Exception e){
                                e.printStackTrace();
                            }				
				
				
				
			}else if (ae.getSource()== btnUpdate){
                            
                            String number = c1.getSelectedItem();
                            String room =tfroom.getText(); //room_number;    
                            String name = tfName.getText(); //name    
                            String checkin = tfCheckin.getText(); //status;    
                            String deposit =tfPaid.getText(); //deposit  
                            
                            try{
                                Conn c = new Conn();
                                c.s.executeUpdate("update customer set room = '"+room+"', name = '"+name+"', checkintime = '"+checkin+"', deposit = '"+deposit+"'");
                                
                                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                                setVisible(false);
                                new Reception().setVisible(true);
                                
                            }catch (Exception e){
                                e.printStackTrace();
                              
                            }
                            
                            
                            
                        } else {
                            setVisible(false);
                            new Reception().setVisible(true);
            
                        }
           
 
}
        public static void main(String[] args) {
		new UpdateCheck ();
}
       
}

