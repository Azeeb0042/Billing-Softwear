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
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;

public class Billinsec extends JPanel {
	
	
	
	JList list;
	JTextField txtpname;
	 
	
	

	private DefaultListModel model;
	private DefaultListModel model1;
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
	JpanelLoader jpload = new JpanelLoader();
	private JList list2;
	
	
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
		setForeground(new Color(0, 153, 0));
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		String bills=String.valueOf(getbillno());	
				
    	setLayout(null);
    	
    	JLabel lblNewLabel_1_1 = new JLabel("Product Search");
    	lblNewLabel_1_1.setBounds(23, 99, 128, 26);
    	lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_1);
    	
    	JLabel lblNewLabel_1_3 = new JLabel("Qty");
    	lblNewLabel_1_3.setBounds(530, 114, 34, 26);
    	lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_3);
    	
    	JLabel lblNewLabel_1_4_1 = new JLabel("R Price");
    	lblNewLabel_1_4_1.setBounds(23, 212, 60, 26);
    	lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_4_1);
    	  list2 = new JList();
    	  list2.addKeyListener(new KeyAdapter() {
    	  	@Override
    	  	public void keyPressed(KeyEvent e) {
    			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
    				String s=(String) list2.getSelectedValue();
        			txtcustomer.setText(s);
        			list2.setVisible(false);
        			try {
        				Statement g = db.mycon().createStatement();
            			String j=txtcustomer.getText();
            			ResultSet r6 = g.executeQuery("select customer from sampledb.biller where customer like '"+j+"' LIMIT 1");
            			while (r6.next()) {
            				Statement g2 = db.mycon().createStatement();

                			ResultSet r11 = g2.executeQuery("select sum(balance) from sampledb.biller where customer like '"+j+"'");
                			while (r11.next()) {

                				String a12=r11.getString("sum(balance)");
                				 float a13=Float.parseFloat(a12);
                				 if(a13!=0) {
                					 DefaultTableModel model=new DefaultTableModel();
                         			model=(DefaultTableModel)table.getModel();
                         			slno=slno+1;
                         			
                         			model.addRow(new Object[] {
                         					
                         					
                         					txtbillid.getText(),
                         					slno,
                         				"old balance",
                         				"0",
                         				"0",
                         				"0",
                         				"0",
                         				"0",
                         				a12,
                         				
                         				
                         				});
                         			float total=0;
        		           			for(int j1=0;j1<table.getRowCount();j1++) {
        		           				total=total+Float.parseFloat(table.getValueAt(j1, 8).toString());}
        		           			String tot=String.valueOf(total);
        		           			txttotal.setText(tot);	
        		           		    netamnt.setText(tot);
        		           		    txtpaid.setText(netamnt.getText());
                					 
                				 }
                				
                				
                				
                			
                			}
            				
            			}

            			
            			
            			
            			
        			}
        			catch(SQLException l) {
        				
        				l.printStackTrace();
        			}
        			
                   
        			
    				
    				
    			}}
    	  });
          list2.addMouseListener(new MouseAdapter() {
          	@Override
          	public void mouseClicked(MouseEvent e) {
          		String s=(String) list2.getSelectedValue();
    			txtcustomer.setText(s);
    			list2.setVisible(false);
          		
          	}
          });
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
     	
          list2.setBounds(922, 153, 160, 87);
     	 add(list2);
     	 
          model1 = new DefaultListModel();
          list2.setModel(model1);
    	
      
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
    	
    	txtpname.setBounds(145, 101, 147, 26);
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
    			  	list.setVisible(false);}
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
    	 	String[] values = new String[] {};
    	 	public int getSize() {
    	 		return values.length;
    	 	}
    	 	public Object getElementAt(int index) {
    	 		return values[index];
    	 	}
    	 });
    	
    	 list.setBounds(295, 105, 211, 139);
    	 add(list);
    	 
    	 
       model = new DefaultListModel();
       list.setModel(model);
       
       txtamount = new JTextField();
       txtamount.setVisible(false);
       txtamount.setBounds(1018, 290, 110, 26);
       add(txtamount);
       txtamount.setColumns(10);
       
       txtqtye = new JTextField();
       txtqtye.addKeyListener(new KeyAdapter() {
       	@Override
       	public void keyPressed(KeyEvent e) {
       		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
           		
       			modifyitem();
           		
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
       txtqtye.setBounds(598, 117, 99, 25);
       add(txtqtye);
       txtqtye.setColumns(10);
       
       txtrprice = new JTextField();
       txtrprice.setEditable(false);
       txtrprice.setBounds(146, 214, 146, 26);
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
       btnNewButton.setBounds(792, 117, 128, 24);
       add(btnNewButton);
       
       JScrollPane scrollPane = new JScrollPane();
       scrollPane.setBounds(12, 249, 996, 233);
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
       txttotal.setBounds(232, 546, 117, 26);
       add(txttotal);
       txttotal.setColumns(10);
       
       txtbalance = new JTextField();
       txtbalance.setEditable(false);
       txtbalance.setBounds(726, 546, 110, 26);
       add(txtbalance);
       txtbalance.setColumns(10);
       txtbalance.setText("0");
       
       
       JLabel ttllabel = new JLabel("Total");
       ttllabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
       ttllabel.setBounds(250, 512, 60, 23);
       add(ttllabel);
       
       JButton GENBTN = new JButton("Save");
       GENBTN.setForeground(new Color(255, 255, 255));
       GENBTN.setBorder(new LineBorder(new Color(0, 0, 0)));
       GENBTN.setBackground(new Color(0, 255, 0));
       
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
        	  
        	  //DefaultTableModel model=new DefaultTableModel();
     			model=(DefaultTableModel)table.getModel();
     			String k1="old balance";    				
     			
				for(int i=0;i<model.getRowCount();i++) {
					String a12=model.getValueAt(i, 2).toString();
					if(k1.equals (a12)) {
        	  s.executeUpdate("UPDATE sampledb.biller SET balance=0 where customer like '"+custom+"'");
					}
				}
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
       GENBTN.setBounds(214, 591, 147, 34);
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
       dltbtn.setBounds(1018, 356, 89, 34);
       add(dltbtn);
       
       txtbillid = new JTextField();
       txtbillid.setEditable(false);
       txtbillid.setBounds(145, 173, 147, 26);
       add(txtbillid);
       txtbillid.setText(bills);
       txtbillid.setColumns(10);
       
       txtdisc = new JTextField();
      
       
       
       txtdisc.setBounds(598, 153, 99, 26);
       add(txtdisc);
       txtdisc.setColumns(10);
       
       JLabel cstmelabel = new JLabel("Discount");
       cstmelabel.setFont(new Font("Tahoma", Font.BOLD, 14));
       cstmelabel.setBounds(516, 151, 70, 26);
       add(cstmelabel);
       
       txttax = new JTextField();
       txttax.setBounds(598, 200, 99, 26);
       add(txttax);
       txttax.setColumns(10);
       
       JLabel lblNewLabel_1 = new JLabel("Tax");
       lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
       lblNewLabel_1.setBounds(516, 199, 49, 20);
       add(lblNewLabel_1);
       
       txtcustomer = new JTextField();
       txtcustomer.addKeyListener(new KeyAdapter() {
       	@Override
       	public void keyReleased(KeyEvent e) {

     	    list2.setVisible(true);

			String m=txtcustomer.getText();
			try {
			Statement s = db.mycon().createStatement();
			ResultSet r = s.executeQuery("select customer from sampledb.customers where customer like '%"+m+"%'order by customer");
            model1.removeAllElements();
			int v=0;
           while(r.next()& v<6) {
        	   model1.addElement(r.getString("customer"));
        	   v++;
           }
		}
		catch(SQLException l) {
			
			l.printStackTrace();
		}
			
		
       	}
       
       	@Override
       	public void keyPressed(KeyEvent e) {

			if(e.getKeyCode()==KeyEvent.VK_ENTER) {}	}
       });
       txtcustomer.setBounds(803, 153, 117, 26);
       add(txtcustomer);
       txtcustomer.setColumns(10);
       
       JLabel lblNewLabel_2 = new JLabel("Customer");
       lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
       lblNewLabel_2.setBounds(707, 151, 86, 26);
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
     	   txtbalance.setText(q);}}
       	@Override
       	public void keyTyped(KeyEvent e) {
       		
       	}
       });
       txtpaid.setBounds(606, 546, 110, 26);
       add(txtpaid);
       txtpaid.setColumns(10);
       
      
       
       JLabel lblNewLabel_3 = new JLabel("Paid");
       lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
       lblNewLabel_3.setBounds(641, 512, 49, 22);
       add(lblNewLabel_3);
       
       JLabel lblNewLabel_4 = new JLabel("Balance");
       lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
       lblNewLabel_4.setBounds(741, 512, 71, 23);
       add(lblNewLabel_4);
       
       txtmdisc = new JTextField();
       txtmdisc.setText("0");
       
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
       		} 	}
       });
       txtmdisc.setBounds(359, 546, 110, 26);
       add(txtmdisc);
       txtmdisc.setColumns(10);
       
       JLabel lblNewLabel_5 = new JLabel("Discount");
       lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
       lblNewLabel_5.setBounds(370, 512, 86, 26);
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
			    }}}
       });
       textField_1.setBounds(145, 136, 147, 26);
       add(textField_1);
       textField_1.setColumns(10);
       
       JLabel lblNewLabel_6 = new JLabel("Barcode");
       lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
       lblNewLabel_6.setBounds(23, 136, 112, 26);
       add(lblNewLabel_6);
       
       netamnt = new JTextField();
       netamnt.setEditable(false);
       netamnt.setBounds(479, 546, 117, 26);
       add(netamnt);
       netamnt.setColumns(10);
       
       JLabel lblNewLabel_5_1 = new JLabel("Net Amount to pay");
       lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
       lblNewLabel_5_1.setBounds(477, 512, 154, 26);
       add(lblNewLabel_5_1);
       
       JButton btnNewButton_2 = new JButton("+");
       btnNewButton_2.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		Customer cst=new Customer();
       		cst.setVisible(true);
       	}
       });
       btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
       btnNewButton_2.setBounds(838, 190, 39, 26);
       add(btnNewButton_2);
       
       JButton GENBTN_1 = new JButton("Save/Print");
       GENBTN_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
       GENBTN_1.setBounds(384, 591, 147, 34);
       add(GENBTN_1);
       
       
       JButton GENBTN_2 = new JButton("Print");
       GENBTN_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
       GENBTN_2.setBounds(541, 591, 147, 34);
       add(GENBTN_2);
       
       JButton GENBTN_1_1 = new JButton("Generate Bill");
       GENBTN_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
       GENBTN_1_1.setBounds(711, 591, 147, 34);
       add(GENBTN_1_1);
       
       JLabel lblNewLabel_6_1 = new JLabel("Bill ID");
       lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
       lblNewLabel_6_1.setBounds(23, 173, 112, 26);
       add(lblNewLabel_6_1);
       
       JLabel lblNewLabel = new JLabel("INIT BILL");
       lblNewLabel.setBounds(337, 11, 160, 35);
       add(lblNewLabel);
       lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));}
	
	public void lister(){
		
		String m=txtpname.getText();
			try {
			Statement s = db.mycon().createStatement();
			ResultSet r = s.executeQuery("select name from sampledb.product where name like '%"+m+"%'order by name");
           model.removeAllElements();
			int v=0;
           while(r.next()& v<6) {
        	   model.addElement(r.getString("name"));
        	   v++;
           }
		}
		catch(SQLException e) {
			
			e.printStackTrace();
		}	
	}

	public void modifyitem()
	{
		if(!txtpname.getText().equals("") & !txtrprice.getText().equals("") & !txtqtye.getText().equals("") ) {
		DefaultTableModel model=new DefaultTableModel();
			model=(DefaultTableModel)table.getModel();
			String k1=txtpname.getText();    				
			int f=0;
		for(int i=0;i<model.getRowCount();i++) {
			String a12=model.getValueAt(i, 2).toString();
			if(k1.equals (a12))
			{
				 String v=model.getValueAt(i, 7).toString();
				 String sl=model.getValueAt(i, 1).toString();
				 String j=txtqtye.getText();
				 float m=Float.parseFloat(j);
				 float n=Float.parseFloat(v);
				 float m1=m+n;
				 
	   				ResultSet n1;
					try {
						Statement s = db.mycon().createStatement();
						n1 = s.executeQuery("select qty from sampledb.product where name like '"+k1+"' ");
						n1.next();
		           	    String qtyr=n1.getString("qty");
		           		float qtyf=Float.parseFloat(qtyr);
		           		if (qtyf>=m1) {
		           			String b=txtrprice.getText();
		       				String c=txtdisc.getText();
		       				String e=txttax.getText();
		       				//String a=txtqtye.getText();
		           			float cf=Float.parseFloat(c);     			
		           			//float af=Float.parseFloat(a);
		           			float bf=Float.parseFloat(b);
		           			float ef=Float.parseFloat(e);
		           			float g=bf-cf; //netprice
		           			float h=(g*ef)/100; //tax
		           			float t=m1*g; //amount
		           			float r=h*m1; //actual tax
		           			float q=cf*m1; //actual dics
		           			
		           			
		           			String z=String.valueOf(r);
		           			model.setValueAt(z, i, 5);
		           			
		           			String w=String.valueOf(q);
		           			model.setValueAt(w, i, 4);
		           			String tstring=String.valueOf(t);
		           			model.setValueAt(tstring, i, 8);
		           			
		           			String o=String.valueOf(g);
		           			model.setValueAt(o, i, 6);
		           			
		           			model.setValueAt(m1, i, 7);
		           			txtpname.setText("");
		           			txtrprice.setText("");
		           			txtqtye.setText("");
		           			txtamount.setText("");
		           			txtdisc.setText("");
		           			txttax.setText("");
		           			textField_1.setText("");
		           			float total=0;
		           			for(int j1=0;j1<table.getRowCount();j1++) {
		           				total=total+Float.parseFloat(table.getValueAt(j1, 8).toString());}
		           			String tot=String.valueOf(total);
		           			txttotal.setText(tot);	
		           		    netamnt.setText(tot);
		           		    txtpaid.setText(netamnt.getText());
		           			
		           					           		}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
	           	    
				 
				  f=1;   						 
				 
				}
		}
		if(f!=1) {
			keyfunction();
		}		

		}
		else {
   			JOptionPane.showMessageDialog(null, "Please Enter all Values");
   		}}

	public void keyfunction() {
		if(!txtpname.getText().equals("") & !txtrprice.getText().equals("") & !txtqtye.getText().equals("") ) {
			String m=txtpname.getText();
   			
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
           				total=total+Float.parseFloat(table.getValueAt(i, 8).toString());}
           			String tot=String.valueOf(total);
           			float x7=Float.parseFloat(tot);
           			txttotal.setText(tot);
           			String a6=txtmdisc.getText();
           			float x1=Float.parseFloat(a6);
           			float x5=x7-x1;
           			String x10=String.valueOf(x5);
           			netamnt.setText(x10);
           		    txtpaid.setText(netamnt.getText());
           		}
           		else {
           			JOptionPane.showMessageDialog(null, "No stock");
           		}
           		
           		}
   			catch(SQLException d) {
           			JOptionPane.showMessageDialog(null, d);
           			d.printStackTrace();
        		}}
   	else {
   			JOptionPane.showMessageDialog(null, "Please Enter all Values");
   		} }}