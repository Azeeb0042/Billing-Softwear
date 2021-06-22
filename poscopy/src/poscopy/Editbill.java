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
import javax.swing.SwingConstants;

public class Editbill extends JPanel {
	
	
	
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
	private JTextField txtdisc;
	
	private JTextField txttax;
	private JTextField txtcustomer;
	private JTextField txtpaid;
	private JTextField txtbalance;
	private JTextField bill_id;
	private JTextField txtnetamnt;
	private JTextField txtmdisc;
	/*public int getbillno()
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
		}*/
	
	public Editbill() {
    	setLayout(null);
    	 
    	JPanel panel = new JPanel();
    	panel.setBounds(87, 11, 627, 55);
    	add(panel);
    	panel.setLayout(null);
    	
    	JLabel lblNewLabel = new JLabel("EDIT BILL");
    	lblNewLabel.setBounds(207, 11, 294, 35);
    	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
    	panel.add(lblNewLabel);
    	
    	txtbillid = new JTextField();
    	txtbillid.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyReleased(KeyEvent e) {
    			char c=e.getKeyChar();
    			if(Character.isLetter(c))
    			{ JOptionPane.showMessageDialog(null, "enter number");
    			txtbillid.setText("");
    				
    			}}
    	});
    	txtbillid.setBounds(10, 11, 86, 26);
    	panel.add(txtbillid);
    	
    	JButton search_bill = new JButton("Search Bill");
    	search_bill.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(!txtbillid.getText().equals("")) {
    			try {
    				String l=txtbillid.getText();
           			float v=Float.parseFloat(l);
    					Statement s = db.mycon().createStatement();
    					ResultSet r = s.executeQuery("select * from sampledb.sales where billid='"+v+"'");
    					DefaultTableModel model=(DefaultTableModel)table.getModel();
    					
    		           while(r.next()) {

    		        	   String BillId=r.getString("billid");
    		        	   String Itemno=r.getString("slno");
    		        	   String Productname=r.getString("item");
    		        	   String rprice=r.getString("price");
    		        	   String Discount=r.getString("disc");
    		        	   String Tax=r.getString("tax");
    		        	   String Netrate=r.getString("netrate");
    		        	   String Qty=r.getString("qty");
    		        	   String Amount=r.getString("amount");

    		        	   	String Object[]= {BillId,Itemno,Productname,rprice,Discount,Tax,Netrate,Qty,Amount};
    		        	   	
    		        	   	model.addRow(Object);}
    		           
    		           
    		           bill_id.setText(txtbillid.getText());
    		           		txtbillid.setText("");
    		           		ResultSet r5 = s.executeQuery("select * from sampledb.biller where billid='"+v+"'");
    		           		while(r5.next()) {
    		           		txtpaid.setText(r5.getString("paid"));
    		           		txtnetamnt.setText(r5.getString("netrate"));
    		           		txtmdisc.setText(r5.getString("disc"));
    		           		txttotal.setText(r5.getString("total"));
    		           		txtbalance.setText(r5.getString("balance"));
    		           		}
    				}
    				catch(SQLException l) {
    					l.printStackTrace();
    					
    				}	
    			}else {
    					JOptionPane.showMessageDialog(null, "enter a number");
    					
    				}
    		}
    	});
    	search_bill.setBounds(106, 13, 89, 23);
    	panel.add(search_bill);
    	
    	 
    	 
    	
    	
    	JLabel lblNewLabel_1_1 = new JLabel("Product Search");
    	lblNewLabel_1_1.setBounds(10, 87, 128, 26);
    	lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_1);
    	
    	JLabel lblNewLabel_1_3 = new JLabel("Qty");
    	lblNewLabel_1_3.setBounds(87, 124, 34, 26);
    	lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_3);
    	
    	JLabel lblNewLabel_1_4_1 = new JLabel("R Price");
    	lblNewLabel_1_4_1.setBounds(512, 124, 60, 26);
    	lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_4_1);
    	JButton clsbtn;
   	 clsbtn = new JButton("x");
        clsbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	 Home  homeobj1=new  Home();
      	
          homeobj1.setVisible(true);
        		
        		
        	  
        	  
        	}
        });
        clsbtn.setFont(new Font("Tahoma", Font.BOLD, 39));
        clsbtn.setBounds(0, 0, 60, 55);
        add(clsbtn);
    	
      
    	txtpname= new JTextField();
    	txtpname.setBounds(132, 89, 147, 26);
    	txtpname.addKeyListener(new KeyAdapter() {
    	    @Override
    		public void keyPressed(KeyEvent e) {
    			
    			
    			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
    				list.setVisible(true);
        			lister();
    			}
    		}
    	});
         add(txtpname);
    	
    	 list = new JList();
    	 list.setBounds(282, 93, 154, 83);
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
    			    txtdisc.setText(t.getString("disc"));
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
    				 txtdisc.setText(t.getString("disc"));
    			    txtrprice.setText(t.getString("rprice"));
    			    txttax.setText(t.getString("tax"));
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
    	 add(list);
    	 
    	 
       model = new DefaultListModel();
       list.setModel(model);
       
       txtamount = new JTextField();
       txtamount.setBounds(1010, 198, 110, 26);
       txtamount.setVisible(false);
       add(txtamount);
       txtamount.setColumns(10);
       
       txtqtye = new JTextField();
       txtqtye.setBounds(131, 127, 86, 25);
       txtqtye.addKeyListener(new KeyAdapter() {
       	@Override
       	public void keyPressed(KeyEvent e) {
       		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
           		
       			keyfunction();
           		
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
       add(txtqtye);
       txtqtye.setColumns(10);
       
       txtrprice = new JTextField();
       txtrprice.setBounds(582, 127, 86, 25);
       txtrprice.setEditable(false);
       add(txtrprice);
       txtrprice.setColumns(10);
       
       JButton btnNewButton = new JButton("Add");
       btnNewButton.setBounds(132, 163, 89, 23);
       btnNewButton.addKeyListener(new KeyAdapter() {
       	@Override
       	public void keyPressed(KeyEvent e) {
       		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
       			keyfunction();
       		}
       		
       		
       		
       	}
       });
 
       btnNewButton.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		keyfunction();
       	}
       });
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
       		"Bill Id", "Item no", "Product name", "rprice", "Discount", "Tax", "Net rate", "Qty", "Amount"
       	}
       ) {
       	boolean[] columnEditables = new boolean[] {
       		false, false, false, false, false, false, false, true, true
       	};
       	public boolean isCellEditable(int row, int column) {
       		return columnEditables[column];
       	}
       });
       table.getColumnModel().getColumn(0).setPreferredWidth(25);
       table.getColumnModel().getColumn(1).setPreferredWidth(60);
       table.getColumnModel().getColumn(2).setPreferredWidth(128);
       table.getColumnModel().getColumn(3).setPreferredWidth(40);
       table.getColumnModel().getColumn(4).setPreferredWidth(65);
       table.getColumnModel().getColumn(5).setPreferredWidth(65);
       table.getColumnModel().getColumn(6).setPreferredWidth(65);
       table.getColumnModel().getColumn(7).setPreferredWidth(65);
       table.getColumnModel().getColumn(8).setPreferredWidth(65);
   



       txttotal = new JTextField();
       txttotal.setBounds(10, 479, 117, 26);
       add(txttotal);
       txttotal.setColumns(10);
       
       
       JLabel ttllabel = new JLabel("Total");
       ttllabel.setBounds(45, 445, 60, 23);
       ttllabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
       add(ttllabel);
       
       JButton GENBTN = new JButton("Generate Bill");
       GENBTN.setBounds(467, 557, 147, 34);
       
       GENBTN.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       	
       		try {
       			DefaultTableModel model=(DefaultTableModel)table.getModel();
       			String a11,b11,c11,d11,f11,g11,h11,i11,j11;
       			Statement n = db.mycon().createStatement();
				String l=bill_id.getText();
       			float v=Float.parseFloat(l);
       			try {
           			Statement s = db.mycon().createStatement();
    					ResultSet r1 = s.executeQuery("select * from sampledb.sales where billid='"+v+"'");

    					
    		           while(r1.next()) {
    		        	   String Productname=r1.getString("item");
    		        	   String Qty=r1.getString("qty");
    		        	   float q=Float.parseFloat(Qty);
    		        	  s.execute("update sampledb.product  SET qty=qty+("+q+") where name like '"+Productname+"' " );
    		           }
    		           
   				}
   				catch(SQLException f) {
   	    			
   	    			f.printStackTrace();
   	    		}
       			n.execute("delete from sampledb.sales where billid='"+v+"'");
       			n.execute("delete from sampledb.biller where billid='"+v+"'");
       			
       				
       			
       			for(int i=0;i<model.getRowCount();i++)
       				
       			{  	   
       				a11=model.getValueAt(i, 0).toString();
       				b11=model.getValueAt(i, 1).toString();
       				c11=model.getValueAt(i, 2).toString();
       				d11=model.getValueAt(i, 3).toString();
       				f11=model.getValueAt(i, 4).toString();
       				g11=model.getValueAt(i, 5).toString();
       				h11=model.getValueAt(i, 6).toString();
       				i11=model.getValueAt(i, 7).toString();
       				j11=model.getValueAt(i, 8).toString();
       				
       				float g1=Float.parseFloat(i11); 
       				n.executeUpdate("INSERT INTO sampledb.sales (billid,item,amount,slno,qty,datetime,price,disc,tax,netrate)VALUES ('"+a11+"','"+c11+"','"+j11+"','"+b11+"','"+i11+"',(CURRENT_TIMESTAMP),'"+d11+"','"+f11+"','"+g11+"','"+h11+"')");
       				n.executeUpdate("UPDATE sampledb.product SET qty=qty -("+g1+")WHERE  name like '"+c11+"'");
       			
       			}
       			Statement k = db.mycon().createStatement();
       		 String billid1,custom,tota,bala,disc,paid,net;
  			  custom=txtcustomer.getText();
  	       	  billid1=bill_id.getText();
  	          tota=txttotal.getText();
  	          bala=txtbalance.getText();
  	          disc=txtmdisc.getText();
  	          paid=txtpaid.getText();
       	      net=txtnetamnt.getText();
  	          
       	  k.executeUpdate("INSERT INTO sampledb.biller (billid,datetime,customer,total,balance,disc,paid,netrate)VALUES ('"+billid1+"',(CURRENT_TIMESTAMP),'"+custom+"','"+tota+"','"+bala+"','"+disc+"','"+paid+"','"+net+"')");
       			
       			
       			JOptionPane.showMessageDialog(null, "Bill created");
       		      //txtbillid.setText("");
       			GENBTN.setEnabled(false);
       		 
       		}
       		catch(SQLException f) {
    			
    			f.printStackTrace();
    		}}
       });
       GENBTN.setFont(new Font("Tahoma", Font.PLAIN, 18));
       add(GENBTN);
       
       JButton dltbtn = new JButton("DELETE");
       dltbtn.setBounds(732, 251, 89, 34);
       dltbtn.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       	     DefaultTableModel model=(DefaultTableModel)table.getModel();
              int slct=table.getSelectedRow();
               model.removeRow(slct);
               	total=0;
               for(int i=0;i<table.getRowCount();i++) {
            	  
      				
      				 total = total+Float.parseFloat(table.getValueAt(i, 8).toString());
    		
      			}
               String tot=String.valueOf(total);
      			txttotal.setText(tot);
      			txtnetamnt.setText(tot);	
       			txtpaid.setText(txtnetamnt.getText());	
              
       	}
       });
       dltbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
       add(dltbtn);
       
       txtdisc = new JTextField();
       txtdisc.setBounds(584, 87, 84, 26);
       add(txtdisc);
       txtdisc.setColumns(10);
       
       JLabel cstmelabel = new JLabel("Discount");
       cstmelabel.setBounds(504, 87, 70, 26);
       cstmelabel.setFont(new Font("Tahoma", Font.BOLD, 14));
       add(cstmelabel);
       
       txttax = new JTextField();
       txttax.setBounds(582, 163, 86, 26);
       add(txttax);
       txttax.setColumns(10);
       
       JLabel lblNewLabel_1 = new JLabel("Tax");
       lblNewLabel_1.setBounds(522, 161, 49, 20);
       lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
       add(lblNewLabel_1);
       
       txtcustomer = new JTextField();
       txtcustomer.setBounds(1003, 87, 117, 26);
       add(txtcustomer);
       txtcustomer.setColumns(10);
       
       txtbalance = new JTextField();
       txtbalance.setBounds(504, 479, 110, 26);
       add(txtbalance);
       txtbalance.setColumns(10);
       txtbalance.setText("0");
       
       
       JLabel lblNewLabel_2 = new JLabel("Customer");
       lblNewLabel_2.setBounds(907, 87, 86, 26);
       lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
       add(lblNewLabel_2);
       
       txtpaid = new JTextField();
       txtpaid.setBounds(384, 479, 110, 26);
       txtpaid.addKeyListener(new KeyAdapter() {
       	@Override
       	public void keyPressed(KeyEvent e) {
       		
       	}
       	@Override
       	public void keyReleased(KeyEvent e) {

       		if(!txtpaid.getText().equals("")) {
       		

     	   String h=txtnetamnt.getText();
     	   float h1=Float.parseFloat(h);
     	   String o=txtpaid.getText();
     	   float o1=Float.parseFloat(o);
     	   float j=h1-o1;
     	   String q=String.valueOf(j);
     	   txtbalance.setText(q);
     	   
            		
        			
            		
            	
       		
       		}
       	}
       });
       add(txtpaid);
       txtpaid.setColumns(10);
       
      
       JLabel lblNewLabel_3 = new JLabel("Paid");
       lblNewLabel_3.setBounds(419, 447, 49, 22);
       lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
       add(lblNewLabel_3);
       
       JLabel lblNewLabel_4 = new JLabel("Balance");
       lblNewLabel_4.setBounds(528, 445, 71, 23);
       lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
       add(lblNewLabel_4);
       
       bill_id = new JTextField();
       bill_id.setBounds(963, 28, 84, 26);
        bill_id.addKeyListener(new KeyAdapter() {
       	
    	   @Override
       	 public void keyPressed(KeyEvent e) {} 
       });
       add(bill_id);
       bill_id.setColumns(10);
       
       txtnetamnt = new JTextField();
       txtnetamnt.setColumns(10);
       txtnetamnt.setBounds(259, 479, 117, 26);
       add(txtnetamnt);
       
       JLabel lblNetAmountTopay = new JLabel("Net Amount Topay");
       lblNetAmountTopay.setFont(new Font("Tahoma", Font.PLAIN, 14));
       lblNetAmountTopay.setBounds(259, 442, 117, 26);
       add(lblNetAmountTopay);
       
       txtmdisc = new JTextField();
       txtmdisc.addKeyListener(new KeyAdapter() {
       	@Override
       	public void keyReleased(KeyEvent e) {

       		if(!txtmdisc.getText().equals("")) {
       		  String h=txttotal.getText();
       	   float h1=Float.parseFloat(h);
       	   String o=txtmdisc.getText();
       	   float o1=Float.parseFloat(o);
       	   float j=h1-o1;
       	   String q=String.valueOf(j);
       	   txtnetamnt.setText(q);
       	   txtpaid.setText(txtnetamnt.getText());
       		}

        	 
        	   
        		
        		
        	  
       	
       	}
       });
       txtmdisc.setColumns(10);
       txtmdisc.setBounds(132, 482, 117, 26);
       add(txtmdisc);
       
       JLabel lblDiscount = new JLabel("Discount");
       lblDiscount.setFont(new Font("Tahoma", Font.PLAIN, 16));
       lblDiscount.setBounds(146, 445, 95, 26);
       add(lblDiscount);
       
      
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
	public void keyfunction() {
		if(!txtpname.getText().equals("") & !txtrprice.getText().equals("") & !txtqtye.getText().equals("") ) {
   			
   			try {
   				String b=txtrprice.getText();
   				String c=txtdisc.getText();
   				String e=txttax.getText();
   				String a=txtqtye.getText();
       			float cf=Float.parseFloat(c);     			
       			float af=Float.parseFloat(a);
       			float bf=Float.parseFloat(b);
       			float ef=Float.parseFloat(e);
       			
       			int bill;
   				Statement s = db.mycon().createStatement();
   				String m=txtpname.getText();
           	    ResultSet n= s.executeQuery("select qty from sampledb.product where name like '"+m+"' ");  
           	    n.next();
           	    String qtyr=n.getString("qty");
           		float qtyf=Float.parseFloat(qtyr);
           		if (qtyf>=af)
           		{
           			float g=bf-cf;
           			float h=(g*ef)/100;
           			float t=af*g;
           			float r=h*af;
           			float q=cf*af;
           			slno=slno+1;
           			String z=String.valueOf(r);
           			String w=String.valueOf(q);
           			String tstring=String.valueOf(t);
           			String o=String.valueOf(g);
           			txtamount.setText(tstring);
           			txttax.setText(z);
           			txtdisc.setText(w);
           			DefaultTableModel model=new DefaultTableModel();
           			model=(DefaultTableModel)table.getModel();
           			model.addRow(new Object[] {
           					
           					
           					bill_id.getText(),
           					slno,
           				txtpname.getText(),
           				txtrprice.getText(),
           				txtdisc.getText(),
           				txttax.getText(),
           				o,
           				txtqtye.getText(),
           				txtamount.getText(),
           				
           				
           				});
           			
           			txtpname.setText("");
           			txtrprice.setText("");
           			txtqtye.setText("");
           			txtamount.setText("");
           			txtdisc.setText("");
           			txttax.setText("");
           			txtnetamnt.setText("");
           			txtpaid.setText("");
           			float total=0;
           			for(int i=0;i<table.getRowCount();i++) {
           				total=total+Float.parseFloat(table.getValueAt(i, 8).toString());
         		
           			}

           			String tot=String.valueOf(total);
           			float x7=Float.parseFloat(tot);
           			txttotal.setText(tot);
           			String a6=txtmdisc.getText();
           			float x1=Float.parseFloat(a6);
           			float x5=x7-x1;
           			String x10=String.valueOf(x5);
           			txtnetamnt.setText(x10);
           		    txtpaid.setText(txtnetamnt.getText());


               	  
               	/*	 
               	   float h1=Float.parseFloat(tot);
               	   String p=txtmdisc.getText();
               	   float o1=Float.parseFloat(o);
               	   float j=h1-o1;
               	   String f=String.valueOf(j);
               	   txtnetamnt.setText(f);
               	   txtpaid.setText(txtnetamnt.getText());
               		
*/
                	 
                	   
                		
                		
                	  
               	
               	
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


