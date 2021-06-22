package poscopy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Customer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	Customer frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Customer() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 611, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(75, 138, 132, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {


				char c=e.getKeyChar();
				if(Character.isLetter(c))
				{
					
					 JOptionPane.showMessageDialog(null, "enter mobile number");
					 textField_1.setText("");
					
					
				}
			
	       	
			}
		});
		textField_1.setBounds(269, 138, 132, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
 		            
 		            Statement s = db.mycon().createStatement();
 		            s.executeUpdate(" INSERT INTO sampledb.customers(customer,mobile) VALUES ('"+textField.getText()+"','"+textField_1.getText()+"')");
 		             JOptionPane.showMessageDialog(null, " Customer Added");
 		           // frame.setVisible(false);
 		            
 		            
 		        } catch (Exception b) { 
 		            System.out.println(b);
 		            JOptionPane.showMessageDialog(null, b);
 		        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(433, 138, 97, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(93, 76, 114, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMobileNumber.setBounds(280, 76, 114, 38);
		contentPane.add(lblMobileNumber);
	}

}
