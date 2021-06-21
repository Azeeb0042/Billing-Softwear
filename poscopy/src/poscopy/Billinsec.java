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
	private JTextField txtdisc;
	
	private JTextField txttax;
	private JTextField txtcustomer;
	private JTextField txtpaid;
	private JTextField txtbalance;
	private JTextField txtmdisc;
	private JTextField textField_1;
	private JTextField netamnt;
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
    	
    	JLabel lblNewLabel_1_1 = new JLabel("Product Search");
    	lblNewLabel_1_1.setBounds(23, 159, 128, 26);
    	lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_1);
    	
    	JLabel lblNewLabel_1_3 = new JLabel("Qty");
    	lblNewLabel_1_3.setBounds(507, 157, 34, 26);
    	lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_3);
    	
    	JLabel lblNewLabel_1_4_1 = new JLabel("R Price");
    	lblNewLabel_1_4_1.setBounds(75, 196, 60, 26);
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
    	
    	txtpname.setBounds(145, 161, 147, 26);
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
    			    txtdisc.setText(t.getString("disc"));
    			    txttax.setText(t.getString("tax"));
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
    	
    	 list.setBounds(295, 165, 154, 83);
    	 add(list);
    	 
    	 
       model = new DefaultListModel();
       list.setModel(model);
       
       txtamount = new JTextField();
       txtamount.setVisible(false);
       txtamount.setBounds(1010, 198, 110, 26);
       add(txtamount);
       txtamount.setColumns(10);
       
       txtqtye = new JTextField();
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
       txtqtye.setBounds(551, 160, 86, 25);
       add(txtqtye);
       txtqtye.setColumns(10);
       
       txtrprice = new JTextField();
       txtrprice.setEditable(false);
       txtrprice.setBounds(145, 199, 86, 25);
       add(txtrprice);
       txtrprice.setColumns(10);
       
       JButton btnNewButton = new JButton("Add");
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
       btnNewButton.setBounds(667, 159, 89, 23);
       add(btnNewButton);
       
       JScrollPane scrollPane = new JScrollPane();
       scrollPane.setBounds(10, 272, 693, 157);
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
       txttotal.setEditable(false);
       txttotal.setBounds(12, 474, 117, 26);
       add(txttotal);
       txttotal.setColumns(10);
       
       
       JLabel ttllabel = new JLabel("Total");
       ttllabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
       ttllabel.setBounds(30, 440, 60, 23);
       add(ttllabel);
       
       JButton GENBTN = new JButton("Generate Bill");
       
       GENBTN.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       	
       		try {
       			DefaultTableModel model=(DefaultTableModel)table.getModel();
       			String a11,b11,c11,d11,f11,g11,h11,i11,j11;
       			Statement s = db.mycon().createStatement();
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
       				s.executeUpdate("INSERT INTO sampledb.sales (billid,item,amount,slno,qty,datetime,price,disc,tax,netrate)VALUES ('"+a11+"','"+c11+"','"+j11+"','"+b11+"','"+i11+"',(CURRENT_TIMESTAMP),'"+d11+"','"+f11+"','"+g11+"','"+h11+"')");
       				s.executeUpdate("UPDATE sampledb.product SET qty=qty -("+g1+")WHERE  name like '"+c11+"'");
       				
       			    	          
       	       	
       				
       				
       			}
       		  String billid1,custom,tota,bala,disc,paid,net;
   			  custom=txtcustomer.getText();
   	       	  billid1=txtbillid.getText();
   	          tota=txttotal.getText();
   	          bala=txtbalance.getText();
   	          disc=txtmdisc.getText();
   	          paid=txtpaid.getText();
        	  net=netamnt.getText();
   	          
        	  s.executeUpdate("INSERT INTO sampledb.biller (billid,datetime,customer,total,balance,disc,paid,netrate)VALUES ('"+billid1+"',(CURRENT_TIMESTAMP),'"+custom+"','"+tota+"','"+bala+"','"+disc+"','"+paid+"','"+net+"')");

       		  JOptionPane.showMessageDialog(null, "Bill created");
       		      //txtbillid.setText("");
       		  GENBTN.setEnabled(false);
       		 
       		}
       		catch(SQLException f) {
    			
    			f.printStackTrace();
    		}	}
       });
       GENBTN.setFont(new Font("Tahoma", Font.PLAIN, 18));
       GENBTN.setBounds(490, 525, 147, 34);
       add(GENBTN);
       
       JButton dltbtn = new JButton("DELETE");
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
      		    netamnt.setText(tot);
                txtpaid.setText(netamnt.getText());
              
       	}
       });
       dltbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
       dltbtn.setBounds(732, 251, 89, 34);
       add(dltbtn);
       
       txtbillid = new JTextField();
       txtbillid.setEditable(false);
       txtbillid.setBounds(1044, 11, 86, 26);
       add(txtbillid);
       txtbillid.setText(bills);
       txtbillid.setColumns(10);
       
       txtdisc = new JTextField();
      
       
       
       txtdisc.setBounds(553, 196, 84, 26);
       add(txtdisc);
       txtdisc.setColumns(10);
       
       JLabel cstmelabel = new JLabel("Discount");
       cstmelabel.setFont(new Font("Tahoma", Font.BOLD, 14));
       cstmelabel.setBounds(471, 194, 70, 26);
       add(cstmelabel);
       
       txttax = new JTextField();
       txttax.setBounds(145, 235, 86, 26);
       add(txttax);
       txttax.setColumns(10);
       
       JLabel lblNewLabel_1 = new JLabel("Tax");
       lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
       lblNewLabel_1.setBounds(85, 233, 49, 20);
       add(lblNewLabel_1);
       
       txtcustomer = new JTextField();
       txtcustomer.setBounds(883, 196, 117, 26);
       add(txtcustomer);
       txtcustomer.setColumns(10);
       
       JLabel lblNewLabel_2 = new JLabel("Customer");
       lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
       lblNewLabel_2.setBounds(787, 196, 86, 26);
       add(lblNewLabel_2);
       
       txtpaid = new JTextField();
       txtpaid.addMouseListener(new MouseAdapter() {
       	@Override
       	public void mouseClicked(MouseEvent e) {
       		txtpaid.setText("");
       	}
       });
       txtpaid.addKeyListener(new KeyAdapter() {
       
       	@Override
       	public void keyReleased(KeyEvent e) {
       		if(!txtpaid.getText().equals("")) {
       		

     	   String h=netamnt.getText();
     	   float h1=Float.parseFloat(h);
     	   String o=txtpaid.getText();
     	   float o1=Float.parseFloat(o);
     	   float j=h1-o1;
     	   String q=String.valueOf(j);
     	   txtbalance.setText(q);
     	   
            		
        			
            		
            	
       		
       		}}
       	@Override
       	public void keyTyped(KeyEvent e) {
       		
       	}
       });
       txtpaid.setBounds(386, 474, 110, 26);
       add(txtpaid);
       txtpaid.setColumns(10);
       
       txtbalance = new JTextField();
       txtbalance.setEditable(false);
       txtbalance.setBounds(506, 474, 110, 26);
       add(txtbalance);
       txtbalance.setColumns(10);
       
       JLabel lblNewLabel_3 = new JLabel("Paid");
       lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
       lblNewLabel_3.setBounds(421, 440, 49, 22);
       add(lblNewLabel_3);
       
       JLabel lblNewLabel_4 = new JLabel("Balance");
       lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
       lblNewLabel_4.setBounds(521, 440, 71, 23);
       add(lblNewLabel_4);
       
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
       	   netamnt.setText(q);
       	   txtpaid.setText(netamnt.getText());
       		}

        	 
        	   
        		
        		
        	  
       	}
       });
       txtmdisc.setBounds(139, 474, 110, 26);
       add(txtmdisc);
       txtmdisc.setColumns(10);
       
       JLabel lblNewLabel_5 = new JLabel("Discount");
       lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
       lblNewLabel_5.setBounds(150, 440, 86, 26);
       add(lblNewLabel_5);
       
       textField_1 = new JTextField();
       textField_1.addKeyListener(new KeyAdapter() {
       	@Override
       	public void keyPressed(KeyEvent e) {

	 		
			
			String x =textField_1.getText();
			{try {
				Statement m = db.mycon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet t=m.executeQuery("select * from sampledb.product where productcode= '"+x+"' ");
				t.first();
			    txtrprice.setText(t.getString("rprice"));
			    txtdisc.setText(t.getString("disc"));
			    txttax.setText(t.getString("tax"));
			    txtpname.setText(t.getString("name"));
				
				}
			    catch(SQLException d) {
				d.printStackTrace();
			    }
			
			}
	 	
       		
       		
       	}
       });
       textField_1.setBounds(145, 106, 147, 26);
       add(textField_1);
       textField_1.setColumns(10);
       
       JLabel lblNewLabel_6 = new JLabel("Barcode Search");
       lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
       lblNewLabel_6.setBounds(23, 106, 112, 26);
       add(lblNewLabel_6);
       
       netamnt = new JTextField();
       netamnt.setEditable(false);
       netamnt.setBounds(259, 474, 117, 26);
       add(netamnt);
       netamnt.setColumns(10);
       
       JLabel lblNewLabel_5_1 = new JLabel("Net Amount to pay");
       lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
       lblNewLabel_5_1.setBounds(257, 440, 154, 26);
       add(lblNewLabel_5_1);
       
      
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
           					
           					
           					txtbillid.getText(),
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
           			textField_1.setText("");

           			float total=0;
           			for(int i=0;i<table.getRowCount();i++) {
           				total=total+Float.parseFloat(table.getValueAt(i, 8).toString());
         		
           			}
           			
                   
           			String tot=String.valueOf(total);
           			txttotal.setText(tot);	
           		    netamnt.setText(tot);
           		    txtpaid.setText(netamnt.getText());
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


