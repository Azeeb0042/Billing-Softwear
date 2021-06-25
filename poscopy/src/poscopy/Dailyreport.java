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


public class Dailyreport extends JPanel {
	
	
	JTable table;

	/**
	 * Create the panel.
	 */
	public Dailyreport() {
		setBackground(new Color(255, 255, 153));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(292, 30, 502, 69);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Day Report");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(179, 11, 210, 31);
		panel.add(lblNewLabel);
		
        JDateChooser dateChooser=new JDateChooser();
        dateChooser.setBounds(497, 127, 200, 30);
        add(dateChooser);
        
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(111, 192, 942, 389);
	    add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Bill Id", "Customer", "Total", "Disc", "Netrate", "Paid", "Balance", "Date&Time"
			}
		));
		table.getColumnModel().getColumn(6).setPreferredWidth(58);
		table.getColumnModel().getColumn(7).setPreferredWidth(111);
		
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
					ResultSet r = s.executeQuery("select * from sampledb.biller where datetime like '"+a+"%'");
					
					
		           while(r.next()) {
		        	   String BILLID=r.getString("billid");
		        	   String CUSTOM=r.getString("customer");
		        	   String TOT=r.getString("total");
		        	   String DISC=r.getString("disc");
		        	   String NTR=r.getString("netrate");
		        	   String PAID=r.getString("paid");
		        	   String BLNC=r.getString("balance");
		        	   String DTM=r.getString("datetime");
		        	  
		        	 
		        	   	String str[]= {BILLID,CUSTOM,TOT,DISC,NTR,PAID,BLNC,DTM};
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
		srcbtn.setBounds(707, 127, 110, 39);
		add(srcbtn);
	
        
        
	}
}
