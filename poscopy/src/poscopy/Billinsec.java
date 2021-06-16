package poscopy;

import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.MediaName;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.DebugGraphics;
import javax.swing.DefaultListModel;

import java.awt.Cursor;
import javax.swing.AbstractListModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Billinsec extends JPanel {
	
	
	
	JList list;
	JTextField txtpname;
	

	private DefaultListModel model;
	private JTextField txtamount;
	private JTextField txtqtye;
	private JTextField txtrprice;
	private JTable table;
	private JTextField txttotal;
	 
	int slno=0;
	private JTextField txtbillid;
	float total;
	public int getbillno()
	{
		int bill=0;
		try{
			Statement s = db.mycon().createStatement();
			ResultSet v= s.executeQuery("select max(billid) as billid from sampledb.sales");
			v.next();
			bill=v.getInt("billid");
			
		}
		catch(SQLException a) {
				a.printStackTrace();
		}
		bill=bill+1;
		return bill;
		}
	public Billinsec() {
		String bills=String.valueOf(getbillno());		
		
    	setLayout(null);
    	 
    	JPanel panel = new JPanel();
    	panel.setBounds(10, 11, 627, 55);
    	add(panel);
    	panel.setLayout(null);
    	
    	JLabel lblNewLabel = new JLabel("INIT BILL");
    	lblNewLabel.setBounds(207, 11, 294, 35);
    	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
    	panel.add(lblNewLabel);
    	
    	JLabel lblNewLabel_1_1 = new JLabel("Product Name search");
    	lblNewLabel_1_1.setBounds(10, 87, 162, 26);
    	lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_1);
    	
    	JLabel lblNewLabel_1_3 = new JLabel("Qty");
    	lblNewLabel_1_3.setBounds(503, 87, 34, 26);
    	lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_3);
    	
    	JLabel lblNewLabel_1_4_1 = new JLabel("R Price");
    	lblNewLabel_1_4_1.setBounds(73, 149, 60, 26);
    	lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_4_1);
    	
      
    	txtpname= new JTextField();
    	txtpname.addKeyListener(new KeyAdapter() {
    	    @Override
    		public void keyPressed(KeyEvent e) {
    			
    			
    			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
    				list.setVisible(true);
        			lister();
    			}
    		}
    	});
    	
    	txtpname.setBounds(182, 90, 147, 26);
         add(txtpname);
    	
    	 list = new JList();
    	 list.addMouseListener(new MouseAdapter() {
    	 	@Override
    	 	public void mouseClicked(MouseEvent e) {
    	 		String s=(String) list.getSelectedValue();
    			txtpname.setText(s);
    			String x =txtpname.getText();
    			{try {
    				Statement m = db.mycon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    				ResultSet t=m.executeQuery("select * from sampledb.product where name like '%"+x+"%' order by rprice LIMIT 1");
    				t.first();
    			    txtrprice.setText(t.getString("rprice"));
    				list.setVisible(false);
    				}
    			    catch(SQLException d) {
    				d.printStackTrace();
    			    }
    			
    			}
    	 	}
    	 });
    	 list.addKeyListener(new KeyAdapter() {
    	 	@Override
    	 	public void keyPressed(KeyEvent e) {

    	 	if(e.getKeyCode()==KeyEvent.VK_ENTER) {
    	 		String s=(String) list.getSelectedValue();
    			txtpname.setText(s);
    		    String x =txtpname.getText();
    			{try {
    				Statement m = db.mycon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    				
    				ResultSet t=m.executeQuery("select * from sampledb.product where name like '%"+x+"%' order by rprice LIMIT 1");
    				t.first();
    				
    			    txtrprice.setText(t.getString("rprice"));
    			  	list.setVisible(false);
    				
    				
    			
    			
    			}
    			catch(SQLException d) {
    				d.printStackTrace();
    		   }
    		  }	
    	 	 }
    	 	}
    	 });
    	 list.setBorder(new LineBorder(new Color(0, 0, 0)));
    	 list.setVisible(false);
    	
    	 list.setModel(new AbstractListModel() {
    	 	String[] values = new String[] {""};
    	 	public int getSize() {
    	 		return values.length;
    	 	}
    	 	public Object getElementAt(int index) {
    	 		return values[index];
    	 		
    	 		
    	 	}
    	 });
    	
    	 list.setBounds(339, 93, 154, 83);
    	 add(list);
    	 
    	 
       model = new DefaultListModel();
       list.setModel(model);
       
       txtamount = new JTextField();
       txtamount.setVisible(false);
       txtamount.setBounds(938, 89, 110, 26);
       add(txtamount);
       txtamount.setColumns(10);
       
       txtqtye = new JTextField();
       txtqtye.addKeyListener(new KeyAdapter() {
       	@Override
       	public void keyPressed(KeyEvent e) {
       		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
           		if(!txtpname.getText().equals("") & !txtrprice.getText().equals("") & !txtqtye.getText().equals("") ) {
           			
           			try {
           				
           				String a=txtqtye.getText();
               			String b=txtrprice.getText();
               			float af=Float.parseFloat(a);
               			float bf=Float.parseFloat(b);
               			int bill;
           				Statement s = db.mycon().createStatement();
           				String m=txtpname.getText();
                   	    ResultSet n= s.executeQuery("select qty from sampledb.product where name like '"+m+"' ");  
                   	    n.next();
                   	    String qtyr=n.getString("qty");
                   		float qtyf=Float.parseFloat(qtyr);
                   		if (qtyf>=af)
                   		{	
                   			float t=af*bf;
                   			slno=slno+1;
                   			String tstring=String.valueOf(t);
                   			txtamount.setText(tstring);
                   			DefaultTableModel model=new DefaultTableModel();
                   			model=(DefaultTableModel)table.getModel();
                   			model.addRow(new Object[] {
                   					txtbillid.getText(),
                   					slno,
                   				txtpname.getText(),
                   				txtrprice.getText(),
                   				txtqtye.getText(),
                   				txtamount.getText(),
                   				
                   				});
                   			
                   			txtpname.setText("");
                   			txtrprice.setText("");
                   			txtqtye.setText("");
                   			txtamount.setText("");
                   			float total=0;
                   			for(int i=0;i<table.getRowCount();i++) {
                   				total=total+Float.parseFloat(table.getValueAt(i, 5).toString());
                 		
                   			}

                   			String tot=String.valueOf(total);
                   			txttotal.setText(tot);	
                   		}
                   		else {
                   			JOptionPane.showMessageDialog(null, "No stock");
                   		}
                   		
                   		}
           			catch(SQLException d) {
                   			JOptionPane.showMessageDialog(null, d);
                   			d.printStackTrace();
                		}
           			
           					
           		}
           	else {
           			JOptionPane.showMessageDialog(null, "Please Enter all Values");
           		} 
           		
           		
           	}
       		
       	
       	}
       	@Override
       	public void keyReleased(KeyEvent e) {

			char c=e.getKeyChar();
			if(Character.isLetter(c))
			{
				
				 JOptionPane.showMessageDialog(null, "enter number");
				 txtqtye.setText("");
				
				
			}
		
       	}
       });
       txtqtye.setBounds(547, 90, 86, 25);
       add(txtqtye);
       txtqtye.setColumns(10);
       
       txtrprice = new JTextField();
       txtrprice.setEditable(false);
       txtrprice.setBounds(182, 152, 110, 25);
       add(txtrprice);
       txtrprice.setColumns(10);
       
       JButton btnNewButton = new JButton("Add");
       btnNewButton.addKeyListener(new KeyAdapter() {
       	@Override
       	public void keyPressed(KeyEvent e) {
       		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
           		if(!txtpname.getText().equals("") & !txtrprice.getText().equals("") & !txtqtye.getText().equals("") ) {
           			
           			try {
           				String a=txtqtye.getText();
               			String b=txtrprice.getText();
               			float af=Float.parseFloat(a);
               			float bf=Float.parseFloat(b);
               			int bill;
           				Statement s = db.mycon().createStatement();
           				String m=txtpname.getText();
                   	    ResultSet n= s.executeQuery("select qty from sampledb.product where name like '"+m+"' ");  
                   	    n.next();
                   	    String qtyr=n.getString("qty");
                   		float qtyf=Float.parseFloat(qtyr);
                   		if (qtyf>=af)
                   		{	
                   			float t=af*bf;
                   			slno=slno+1;
                   			String tstring=String.valueOf(t);
                   			txtamount.setText(tstring);
                   			DefaultTableModel model=new DefaultTableModel();
                   			model=(DefaultTableModel)table.getModel();
                   			model.addRow(new Object[] {
                   					txtbillid.getText(),
                   					slno,
                   				txtpname.getText(),
                   				txtrprice.getText(),
                   				txtqtye.getText(),
                   				txtamount.getText(),
                   				
                   				});
                   			
                   			txtpname.setText("");
                   			txtrprice.setText("");
                   			txtqtye.setText("");
                   			txtamount.setText("");
                   			float total=0;
                   			for(int i=0;i<table.getRowCount();i++) {
                   				total=total+Float.parseFloat(table.getValueAt(i, 5).toString());
                 		
                   			}

                   			String tot=String.valueOf(total);
                   			txttotal.setText(tot);	
                   		}
                   		else {
                   			JOptionPane.showMessageDialog(null, "No stock");
                   		}
                   		
                   		}
           			catch(SQLException d) {
                   			JOptionPane.showMessageDialog(null, d);
                   			d.printStackTrace();
                		}
           			
           					
           		}
           	else {
           			JOptionPane.showMessageDialog(null, "Please Enter all Values");
           		} 
           		
           		
           	}
       		
       		
       		
       	}
       });
       
       
       /* ============== for item decrement==============
        * try {
           		
           		Statement u = db.mycon().createStatement();
           		String j=txtqtye.getText();
       			float t2=Float.parseFloat(j);


           	    u.execute("UPDATE sampledb.product SET qty=qty -("+t2+")WHERE qty!=0;");  
           	       txtqtye.setText("");
           		
           		
           		}catch(SQLException d) {
        			d.printStackTrace();
        			
        			
        		}
        * ==================================================================
        */
       
       btnNewButton.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		if(!txtpname.getText().equals("") & !txtrprice.getText().equals("") & !txtqtye.getText().equals("") ) {
       			
       			try {
       				String a=txtqtye.getText();
           			String b=txtrprice.getText();
           			float af=Float.parseFloat(a);
           			float bf=Float.parseFloat(b);
           			int bill;
       				Statement s = db.mycon().createStatement();
       				String m=txtpname.getText();
               	    ResultSet n= s.executeQuery("select qty from sampledb.product where name like '"+m+"' ");  
               	    n.next();
               	    String qtyr=n.getString("qty");
               		float qtyf=Float.parseFloat(qtyr);
               		if (qtyf>=af)
               		{	
               			slno=slno+1;
               			float t=af*bf;
               			String tstring=String.valueOf(t);
               			txtamount.setText(tstring);
               			DefaultTableModel model=new DefaultTableModel();
               			model=(DefaultTableModel)table.getModel();
               			model.addRow(new Object[] {
               					txtbillid.getText(),
               					slno,
               				txtpname.getText(),
               				txtrprice.getText(),
               				txtqtye.getText(),
               				txtamount.getText(),
               				
               				});
               			
               			txtpname.setText("");
               			txtrprice.setText("");
               			txtqtye.setText("");
               			txtamount.setText("");
               			float total=0;
               			for(int i=0;i<table.getRowCount();i++) {
               				
               				total=total+Float.parseFloat(table.getValueAt(i, 5).toString());
             		
               			}

               			String tot=String.valueOf(total);
               			txttotal.setText(tot);	
               		}
               		else {
               			JOptionPane.showMessageDialog(null, "No stock");
               		}
               	/* try {
               		
               		Statement K = db.mycon().createStatement();
               		String j=txtqtye.getText();
           			float t2=Float.parseFloat(j);

           			
               	    K.execute("UPDATE sampledb.product SET qty=qty -("+t2+")WHERE  name like '"+m+"'");  
               	      
               		
               		
               		}catch(SQLException N) {
            			N.printStackTrace();
            			
            			
            		}*/
               		
               		}
       			catch(SQLException d) {
               			JOptionPane.showMessageDialog(null, d);
               			d.printStackTrace();
            		}
       			
       					
       		}
       	else {
       			JOptionPane.showMessageDialog(null, "Please Enter all Values");
       		} 
       
       		
       		
       	}
       });
       btnNewButton.setBounds(688, 91, 89, 23);
       add(btnNewButton);
       
       JScrollPane scrollPane = new JScrollPane();
       scrollPane.setBounds(10, 214, 693, 157);
       add(scrollPane);
       
       table = new JTable();
       scrollPane.setViewportView(table);
       table.setModel(new DefaultTableModel(
       	new Object[][] {
       	},
       	new String[] {
       		"Bill Id", "Item no", "Product name", "rprice", "Qty", "Amount", "New column"
       	}
       ) {
       	boolean[] columnEditables = new boolean[] {
       		false, false, false, false, false, false, false
       	};
       	public boolean isCellEditable(int row, int column) {
       		return columnEditables[column];
       	}
       });
       table.getColumnModel().getColumn(0).setPreferredWidth(25);
       table.getColumnModel().getColumn(1).setPreferredWidth(60);
       table.getColumnModel().getColumn(2).setPreferredWidth(200);
       table.getColumnModel().getColumn(3).setPreferredWidth(40);
       table.getColumnModel().getColumn(4).setPreferredWidth(65);
       table.getColumnModel().getColumn(5).setPreferredWidth(65);

       txttotal = new JTextField();
       txttotal.setBounds(212, 447, 117, 26);
       add(txttotal);
       txttotal.setColumns(10);
       
       
       JLabel ttllabel = new JLabel("Total");
       ttllabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
       ttllabel.setBounds(122, 446, 50, 20);
       add(ttllabel);
       
       JButton btnNewButton_1 = new JButton("Generate Bill");
       btnNewButton_1.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       	
       		try {
       			DefaultTableModel model=(DefaultTableModel)table.getModel();
       			String a11,b11,c11,d11,g11,f11;
       			Statement s = db.mycon().createStatement();
       			for(int i=0;i<model.getRowCount();i++)
       				
       			{	
       				a11=model.getValueAt(i, 0).toString();
       				b11=model.getValueAt(i, 1).toString();
       				c11=model.getValueAt(i, 2).toString();
       				d11=model.getValueAt(i, 3).toString();
       				g11=model.getValueAt(i, 4).toString();
       				f11=model.getValueAt(i, 4).toString();
       				float g1=Float.parseFloat(g11); 
       				s.executeUpdate("INSERT INTO sampledb.sales (billid,slno,item,qty,price,amount,datetime)VALUES ("+a11+","+b11+",'"+c11+"',"+g11+","+d11+","+f11+",CURRENT_TIMESTAMP)");
       				s.executeUpdate("UPDATE sampledb.product SET qty=qty -("+g1+")WHERE  name like '"+c11+"'");
       			}
       			
       			JOptionPane.showMessageDialog(null, "Bill created");
       		      txtbillid.setText("");
       		 
       		}
       		catch(SQLException f) {
    			
    			f.printStackTrace();
    		}	
       	 
       	}
       });
       btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
       btnNewButton_1.setBounds(490, 440, 147, 34);
       add(btnNewButton_1);
       
       JButton dltbtn = new JButton("DELETE");
       dltbtn.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       	     DefaultTableModel model=(DefaultTableModel)table.getModel();
              int slct=table.getSelectedRow();
               model.removeRow(slct);
               for(int i=0;i<table.getRowCount();i++) {
      				
      				total=total+Float.parseFloat(table.getValueAt(i, 5).toString());
    		
      			}
               String tot=String.valueOf(total);
      			txttotal.setText(tot);
              
       	}
       });
       dltbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
       dltbtn.setBounds(732, 251, 89, 34);
       add(dltbtn);
       
       txtbillid = new JTextField();
       txtbillid.setEditable(false);
       txtbillid.setBounds(948, 133, 86, 26);
       add(txtbillid);
       txtbillid.setText(bills);
       txtbillid.setColumns(10);
       
      
    	}
	
	public void lister(){
		
		String m=txtpname.getText();
			try {
			Statement s = db.mycon().createStatement();
			ResultSet r = s.executeQuery("select name from sampledb.product where name like '%"+m+"%'order by name");
           model.removeAllElements();
			int v=0;
           while(r.next()& v<4) {
        	   model.addElement(r.getString("name"));
        	   v++;
           }
		}
		catch(SQLException e) {
			
			e.printStackTrace();
		}	
	}
}


