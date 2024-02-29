package hotel.management.system;

/**
 * @author onkar
 */

import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.*;
//import java.awt.event.ActionEvent;

public class UpdateRoom extends JFrame implements ActionListener {
    
Connection conn = null;
PreparedStatement pst = null;
	private JPanel contentPane;
	JTextField txt_ID,txt_Ava,txt_Status,txt_Room;
        JButton btnCheck,btnUpdate,btnExit;
        JLabel lblUpdateRoomStatus,lblNewLabel,lblRoomId,lblAvailability,lblCleanStatus;
        Choice c1;

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
	 UpdateRoom(){
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 1000, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
                Image i3 = i1.getImage().getScaledInstance(550, 250,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(350,80,600,250);
                add(l1);
		
		lblUpdateRoomStatus = new JLabel("Update Room Status");
		lblUpdateRoomStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateRoomStatus.setBounds(85, 11, 206, 34);
		contentPane.add(lblUpdateRoomStatus);
		
		lblNewLabel = new JLabel("Guest ID:");
		lblNewLabel.setBounds(27, 87, 90, 14);
		contentPane.add(lblNewLabel);
                
                c1 = new Choice();
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                        c1.add(rs.getString("number"));    
                    }
                }catch(Exception e){ 
                      e.printStackTrace();
                }
                c1.setBounds(160, 84, 140, 20);
		contentPane.add(c1);
                
                lblRoomId = new JLabel("Room Number:");
		lblRoomId.setBounds(27, 133, 100, 14);
		contentPane.add(lblRoomId);
                txt_Room = new JTextField();
		txt_Room.setBounds(160, 130, 140, 20);
		contentPane.add(txt_Room);
		txt_Room.setColumns(10);
		
		lblAvailability = new JLabel("Availability:");
		lblAvailability.setBounds(27, 187, 90, 14);
		contentPane.add(lblAvailability);
                txt_Ava = new JTextField();
		txt_Ava.setBounds(160, 184, 140, 20);
		contentPane.add(txt_Ava);
		txt_Ava.setColumns(10);
		
		lblCleanStatus = new JLabel("Clean Status:");
		lblCleanStatus.setBounds(27, 240, 90, 14);
		contentPane.add(lblCleanStatus);
		txt_Status = new JTextField();
		txt_Status.setBounds(160, 237, 140, 20);
		contentPane.add(txt_Status);
		txt_Status.setColumns(10);
                
  
                btnCheck = new JButton("Check");
                btnCheck.setBounds(120, 315, 89, 23);
                btnCheck.setBackground(Color.BLACK);
                btnCheck.setForeground(Color.WHITE);
                btnCheck.addActionListener(this);
		contentPane.add(btnCheck);
                
                JButton btnUpdate = new JButton("Update");
                btnUpdate.setBounds(60, 355, 89, 23);
                btnUpdate.setBackground(Color.BLACK);
                btnUpdate.setForeground(Color.WHITE);
                btnUpdate.addActionListener(this);
		contentPane.add(btnUpdate);
                
                btnExit = new JButton("Back");
                btnExit.setBounds(190, 355, 89, 23);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
                btnExit.addActionListener(this);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(Color.WHITE);
                setVisible(true);
         }    
		
	public void actionPerformed(ActionEvent ae) {
                            
                if(ae.getSource()==btnCheck){
                    String id = c1.getSelectedItem();
                    String query = "select * from customer where number = '"+id+"'";
                            
                            try{
                                
				Conn c = new Conn();
                                ResultSet rs1 = c.s.executeQuery(query);
                                
                                while(rs1.next()){
                                    txt_Room.setText(rs1.getString("room")); 
                                    
                                    
                                }
                                
                                ResultSet rs2 =c.s.executeQuery("select * from room where roomnumber = '"+txt_Room.getText()+"'");
                                while(rs2.next()) {
                                   txt_Ava.setText(rs2.getString("availablity"));
                                   txt_Status.setText(rs2.getString("cleaning_status"));
                                }
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                } else if(ae.getSource()==btnUpdate){
                    
                    try{
                                    Conn c = new Conn();
                                    String str = "update room set clean_status = '"+txt_Status.getText()+"' where room_number = "+txt_Room.getText();
                                    c.s.executeUpdate(str);
                                    JOptionPane.showMessageDialog(null, "Update Sucessful");
                                    
                                    new Reception().setVisible(true);
                                    setVisible(false);
				}catch (Exception ee){
					ee.printStackTrace();
				}
                }else {
                            setVisible(false);
                            new Reception().setVisible(true);
            
                        }
                            
        }
		
	
         public static void main(String[] args) {
		new UpdateRoom();
	}
}
