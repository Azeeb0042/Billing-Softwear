package poscopy;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Purchasereport extends JPanel {
	
	
	JTable table;
	private JTextField txtvendor;

	/**
	 * Create the panel.
	 */
	public Purchasereport() {
		setBackground(new Color(255, 255, 153));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(290, 21, 502, 69);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Purchase Report");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(132, 11, 210, 31);
		panel.add(lblNewLabel);
		
        JDateChooser dateChooser=new JDateChooser();
        dateChooser.setBounds(497, 127, 200, 30);
        add(dateChooser);
        
    	
		JDateChooser dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(706, 127, 200, 30);
		add(dateChooser1);
        
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(117, 195, 847, 389);
	    add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ProductCode", "ProductName", "Weight", "Quantity", "Wprice", "Rprice ", "Amount", "Vendor"
			}
		));
		
		JButton srcbtn = new JButton("Search");
		srcbtn.setForeground(new Color(255, 255, 255));
		srcbtn.setBackground(new Color(0, 51, 51));
		srcbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					 DateFormat df=new SimpleDateFormat("YYYY-MM-dd");
					//Date d=dateChooser.getMinSelectableDate();
					
					 
					 
					 
					String a=df.format(dateChooser.getDate());
					//Date a=dateChooser.getDate();
					Statement s = db.mycon().createStatement();
					ResultSet r = s.executeQuery("select * from sampledb.purchase where datetime like '"+a+"%'");
					
					
		           while(r.next()) {
		        	   String ProductCode=r.getString("code");
		        	   String ProductName=r.getString("name");
		        	   String Weight=r.getString("weight");
		        	   String Quantity=r.getString("qty");
		        	   String Wprice=r.getString("wprice");
		        	   String Rprice=r.getString("rprice");
		        	   String amount=r.getString("amount");
		        	   String vendor=r.getString("vendor");
		        	  
		        	 
		        	   	String str[]= {ProductCode,ProductName,Weight,Quantity,Wprice,Rprice,amount,vendor};
		        	   	DefaultTableModel model=(DefaultTableModel)table.getModel();
		        	   	model.addRow(str);
		        	   	
		        	   	
		           }
				}
				catch(SQLException l) {
					
					l.printStackTrace();
				}
				
			}
		});
		srcbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		srcbtn.setBounds(927, 127, 110, 39);
		add(srcbtn);
		
		txtvendor = new JTextField();
		txtvendor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {

					
					try {
						String g=txtvendor.getText();
						Statement s = db.mycon().createStatement();
						ResultSet r = s.executeQuery("select * from sampledb.purchase where vendor like '"+g+"' ");
						
			           while(r.next()) {
			        	   String ProductCode=r.getString("code");
			        	   String ProductName=r.getString("name");
			        	   String Weight=r.getString("weight");
			        	   String Quantity=r.getString("qty");
			        	   String Wprice=r.getString("wprice");
			        	   String Rprice=r.getString("rprice");
			        	   String amount=r.getString("amount");
			        	   String vendor=r.getString("vendor");
			        	  
			        	 
			        	   	String str[]= {ProductCode,ProductName,Weight,Quantity,Wprice,Rprice,amount,vendor};
			        	   	DefaultTableModel model=(DefaultTableModel)table.getModel();
			        	   	model.addRow(str);
			        	   	
			        	   	
			           }
					}
					catch(SQLException l) {
						
						l.printStackTrace();
					}
					
				
					
				}
			}
		});
		txtvendor.setBounds(344, 127, 143, 30);
		add(txtvendor);
		txtvendor.setColumns(10);
	
        
        
	}
}
