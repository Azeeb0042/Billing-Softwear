package poscopy;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Customerrep extends JPanel {
	
	
	JTable table;
	private JTextField txtcustomer;
	private JList list2;
	private DefaultListModel model1;

	/**
	 * Create the panel.
	 */
	public Customerrep() {
		setBackground(new Color(255, 255, 153));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(292, 30, 502, 69);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Report");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(179, 11, 210, 31);
		panel.add(lblNewLabel);
        
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 234, 913, 387);
	    add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Bill Id", "Date&Time", "Total", "Disc", "Netrate", "Paid", "Balance"
			}
		));
		table.getColumnModel().getColumn(6).setPreferredWidth(40);
		
		txtcustomer = new JTextField();
		txtcustomer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
		     	    list2.setVisible(true);
		     	    String m=txtcustomer.getText();
					try {
					Statement s = db.mycon().createStatement();
					ResultSet r = s.executeQuery("select customer from sampledb.customers where customer like '%"+m+"%'order by customer");
		            model1.removeAllElements();
					int v=0;
		           while(r.next()& v<6) {
		        	   model1.addElement(r.getString("customer"));
		        	   v++; }	}
				catch(SQLException l) {
					
					l.printStackTrace();
				}}}});
		txtcustomer.setBounds(414, 117, 159, 30);
		add(txtcustomer);
		txtcustomer.setColumns(10);
		
		JLabel lblCustomer = new JLabel("Customer Search");
		lblCustomer.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCustomer.setBounds(199, 112, 206, 31);
		add(lblCustomer);
		
		 list2 = new JList();
   	  list2.addKeyListener(new KeyAdapter() {
   	  	@Override
   	  	public void keyPressed(KeyEvent e) {
   			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				try {
					String a=txtcustomer.getText();
					Statement s = db.mycon().createStatement();
					ResultSet r = s.executeQuery("select * from sampledb.biller where customer like '"+a+"%'");
					
		           while(r.next()) {
		        	   String BILLID=r.getString("billid");
		        	   String DTM=r.getString("datetime");
		        	   String TOT=r.getString("total");
		        	   String DISC=r.getString("disc");
		        	   String NTR=r.getString("netrate");
		        	   String PAID=r.getString("paid");
		        	   String BLNC=r.getString("balance");
		        	   	String str[]= {BILLID,DTM,TOT,DISC,NTR,PAID,BLNC};
		        	   	DefaultTableModel model=(DefaultTableModel)table.getModel();
		        	   	model.addRow(str);
		        	    list2.setVisible(false);
		        	   	
		           }
				}
				catch(SQLException l) {
					l.printStackTrace();
				}}} });
         
         list2.setBorder(new LineBorder(new Color(0, 0, 0)));
    	    list2.setVisible(false);

         list2.setModel(new AbstractListModel() {
    	 	String[] values = new String[] {""};
    	 	public int getSize() {
    	 		return values.length;
    	 	}
    	 	public Object getElementAt(int index) {
    	 		return values[index];
    	 		
    	 		
    	 	}
    	 });
    	
         list2.setBounds(583, 123, 159, 100);
    	 add(list2);
    	 
         model1 = new DefaultListModel();
         list2.setModel(model1);
	
        
        
	}
}
