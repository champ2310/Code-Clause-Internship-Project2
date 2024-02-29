package hotel.management.system;

/**
 * @author onkar
 */
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;


public class NewCustomer extends JFrame implements ActionListener {
    

	JPanel contentPane;
	JTextField t1,t2,t3,t4;
        JComboBox comboBox;
        JRadioButton male,female;
        JButton addButton,exitButton;
        JLabel lblName,lblId,lblnum,lblName_1,lblGender,lblCountry,lblReserveRoomNumber,lblCheckInStatus,checkinTime,lblDeposit;
        Choice croom;
	/**
	 * Launch the application.
	 */
	NewCustomer(){
		
               
		contentPane = new JPanel();
		setContentPane(contentPane);
                getContentPane().setBackground(Color.WHITE);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
                Image i2 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                JLabel image = new JLabel(i3);
                image.setBounds(480,10,300,500);
                add(image);
		
		lblName = new JLabel("NEW CUSTOMER FORM");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 260, 53);
		add(lblName);
                
                lblId = new JLabel("ID :");
		lblId.setBounds(35, 76, 200, 14);
		add(lblId);
              
                String options[] = {"Select" ,"Passport", "Aadhar Card", "Voter Id", "Driving license"};
		comboBox=new JComboBox(options);
                comboBox.setBounds(271, 73, 150, 20);
                comboBox.setBackground(Color.white);
		add(comboBox);
                
                lblnum = new JLabel("Number :");
		lblnum.setBounds(35, 111, 200, 14);
		add(lblnum);
                t1 = new JTextField();
		t1.setBounds(271, 111, 150, 20);
		t1.setColumns(10);
                add(t1);
	
                // Name Section
		lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 151, 200, 14);
		add(lblName_1);
		t2 = new JTextField();
		t2.setBounds(271, 151, 150, 20);
		t2.setColumns(10);
               add(t2);

                
		lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 191, 200, 14);
		add(lblGender);
                
                male = new JRadioButton("Male");
                male.setFont(new Font("Raleway", Font.BOLD, 14));
                male.setBackground(Color.WHITE);
                male.setBounds(271, 191, 80, 12);
                add(male);
                
                female = new JRadioButton("Female");
                female.setFont(new Font("Raleway", Font.BOLD, 14));
                female.setBackground(Color.WHITE);
                female.setBounds(350, 191, 100, 12);
		add(female);
                
                ButtonGroup bg=new ButtonGroup();
                bg.add(male);
                bg.add(female);
                
		lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 231, 200, 14);
		add(lblCountry);
                t3 = new JTextField();
		t3.setBounds(271, 231, 150, 20);
		t3.setColumns(10);
                add(t3);
		
		lblReserveRoomNumber = new JLabel("Allocated Room Number :");
		lblReserveRoomNumber.setBounds(35, 274, 200, 14);
		add(lblReserveRoomNumber);
                //croom
                croom = new Choice();
                try{
                    Conn c = new Conn();
                    String query = "select * from room where availablity = 'Available'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        croom.add(rs.getString("roomnumber"));    
                    }
                }catch(Exception e){ 
                     e.printStackTrace();
                }
                croom.setBounds(271, 274, 150, 20);
		add(croom);
		
		lblCheckInStatus = new JLabel("Checked-In :");
		lblCheckInStatus.setBounds(35, 316, 200, 14);
		add(lblCheckInStatus);
                
                Date date=new Date();//for accessing date^
                
                checkinTime = new JLabel (""+date);
                checkinTime.setBounds(271,320,200,14);
                checkinTime.setFont(new Font("Raleway",Font.PLAIN,15));
                add(checkinTime);
                
		lblDeposit = new JLabel("Deposit :");
		lblDeposit.setBounds(35, 359, 200, 14);
		add(lblDeposit);
		t4 = new JTextField();
		t4.setBounds(271, 359, 150, 20);
		add(t4);
		t4.setColumns(10);

		addButton = new JButton("Add");
                addButton.setBounds(100, 430, 120, 30);
                addButton.setBackground(Color.BLACK);
                addButton.setForeground(Color.WHITE);
                addButton.addActionListener(this);
		add(addButton);
                
                exitButton = new JButton("Back");
                exitButton.setBounds(260, 430, 120, 30);
                exitButton.setBackground(Color.BLACK);
                exitButton.setForeground(Color.WHITE);
                exitButton.addActionListener(this);
		add(exitButton);
                
                 setBounds(350, 200, 850, 550);
                setVisible(true);
        }
		
    public void actionPerformed(ActionEvent ae) {
           
            if (ae.getSource()== addButton){         
                String id =(String)comboBox.getSelectedItem();
                String number =(String)t1.getText();
                String name =(String)t2.getText();
                String gender =null;
                
                if(male.isSelected()){ 
                                gender = "Male";
                            }
                            else if(female.isSelected()){ 
                                gender = "Female";
                            }
                
                String country =t3.getText();
                String room= croom.getSelectedItem();
                String time = checkinTime.getText();
                String deposit = t4.getText();
                
                 try{
	    		
                        String q1 = "insert into customer values ('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                        String q2 = "update room set availablity = 'Occupied' where room_number = '"+room+"'";
                        
                        Conn c = new Conn();
                        
                        c.s.executeUpdate(q1);
                        c.s.executeUpdate(q2);
	
	    		JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                        
                            this.setVisible(false);
                            new Reception();
                    
                 } catch(Exception e){
	    		e.printStackTrace();
	    	    }
		
            }  else  if(ae.getSource()== exitButton){
                   
                this.setVisible(false);
                new Reception();
                     
                }
            
    }
     public static void main(String[] args) {
            new NewCustomer();
        }
	
    }
             