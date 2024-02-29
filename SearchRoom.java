package hotel.management.system;

/**
 * @author onkar
 */


import java.awt.BorderLayout;
import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchRoom extends JFrame implements ActionListener {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTextField txt_Type;
	JTable table;
        JButton exit,Search;
        JComboBox bedtype;
        JCheckBox available;
        Choice c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new SearchRoom();
	}
	public void close()
	{
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException
	 */
	 SearchRoom(){
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchForRoom = new JLabel("Search For Room");
		lblSearchForRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchForRoom.setBounds(400, 30, 200, 30);
		contentPane.add(lblSearchForRoom);
		
		JLabel lblRoomAvailable = new JLabel("Room Bed Type:");
		lblRoomAvailable.setBounds(50, 100, 100, 20);
		contentPane.add(lblRoomAvailable);
                
                bedtype = new JComboBox(new String[]{"Single bed","Double bed"});
                bedtype.setBounds(200,100,150,25);
                bedtype.setBackground(Color.white);
                contentPane.add(bedtype);
                
                available = new JCheckBox("Only display Available");
		available.setBounds(650, 100, 150, 25);
                available.setBackground(Color.WHITE);
		contentPane.add(available);
         
		JLabel lblRoomType = new JLabel("Room Number");
		lblRoomType.setBounds(50, 160, 100, 20);
		contentPane.add(lblRoomType);
		
		JLabel lblRoomAvailable_1 = new JLabel("Availability");
		lblRoomAvailable_1.setBounds(270, 160, 100, 20);
		contentPane.add(lblRoomAvailable_1);
                
                JLabel lblCleanStatus = new JLabel("Clean Status");
		lblCleanStatus.setBounds(450, 160, 100, 20);
		contentPane.add(lblCleanStatus);
		
		JLabel lblPrice_1 = new JLabel("Price");
		lblPrice_1.setBounds(670, 160, 100, 20);
		contentPane.add(lblPrice_1);
                
                JLabel l1 = new JLabel("Bed Type");
		l1.setBounds(870, 160, 100, 20);
		contentPane.add(l1);
                
                table = new JTable();
		table.setBounds(0, 200, 1000, 300);
		contentPane.add(table);
		
                try{
                    Conn c=new Conn();
                    ResultSet rs=c.s.executeQuery("select * from room");
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }catch (Exception e){
                    e.printStackTrace();
                }
                
                Search = new JButton("Search");
                Search.setBounds(300, 520, 120, 30);
                Search.setBackground(Color.BLACK);
                Search.setForeground(Color.WHITE);
                Search.addActionListener(this);
		contentPane.add(Search);
                
                exit = new JButton("Back");
		exit.setBounds(500, 520, 120, 30);
                exit.setBackground(Color.BLACK);
                exit.setForeground(Color.WHITE);
                exit.addActionListener(this);
		contentPane.add(exit);
                
                
                setBounds(260, 150, 1000, 620);
                getContentPane().setBackground(Color.WHITE);
                setVisible(true);
                
         }       
               
    public void actionPerformed(ActionEvent ae) {
     
        if(ae.getSource()== Search){
                                    
            try{	
               String query1 = "select * from Room where bed_type = '"+bedtype.getSelectedItem()+"'";
	       String query2 = "select * from Room where availablity = 'Available' AND bed_type = '"+bedtype.getSelectedItem()+"'";
               Conn c = new Conn();
	       ResultSet rs;
	
                  if(available.isSelected()) {	
	               rs = c.s.executeQuery(query2);
	            }else{
                       rs = c.s.executeQuery(query1);
                    }
                    table.setModel(DbUtils.resultSetToTableModel(rs));
	    }catch (Exception e){
				e.printStackTrace();
	        } 
        
			
        }        else{
                      
                        setVisible(false);
                    new Reception();
       
    }
  }
}
		
		
		/**btnExit.addActionListener(new ActionListener() {
			
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		
 
                /*c1 = new Choice();
                c1.add("Single Bed");
                c1.add("Double Bed");
                c1.setBounds(153, 70, 120, 20);
		contentPane.add(c1);
		
		JButton btnSearch = new JButton("Search");
                btnSearch.setBounds(200, 400, 120, 30);
                btnSearch.setBackground(Color.BLACK);
                btnSearch.setForeground(Color.WHITE);
                btnSearch.addActionListener(this);
		contentPane.add(btnSearch); */