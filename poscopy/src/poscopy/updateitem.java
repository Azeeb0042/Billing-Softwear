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

import com.barcodelib.barcode.Linear;

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

public class updateitem extends JPanel {
	
	
	
	JList list;
	private JList list2;
	JTextField searchbox;
	

	private DefaultListModel model;
	private JTextField txtweight;
	private JTextField txtqty;
	private JTextField txtwprice;
	private JTextField txtrprice;
	private JTextField txtname;
	private JTextField txtcode;
	private JTextField txtdisc;
	private JTextField txttax;
	private JTable table;
	private JTextField txtvendor;
	private JTextField txttotal;
	private JTextField txtnqty;
	
	 
	

	
	public updateitem() {
		setBackground(new Color(255, 255, 153));
		
    	setLayout(null);
    	
    	JPanel panel = new JPanel();
    	panel.setBounds(418, 11, 293, 67);
    	add(panel);
    	panel.setLayout(null);
    	
    	JLabel lblNewLabel = new JLabel("UPDATE PRODUCT");
    	lblNewLabel.setBounds(10, 11, 273, 45);
    	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
    	panel.add(lblNewLabel);
    	
        
    	
    	JLabel lblNewLabel_1_1 = new JLabel("Product Name search");
    	lblNewLabel_1_1.setBounds(49, 90, 162, 26);
    	lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_1);
    	
    	JLabel lblNewLabel_1_2 = new JLabel("Weight");
    	lblNewLabel_1_2.setBounds(101, 315, 110, 26);
    	lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_2);
    	
    	JLabel lblNewLabel_1_3 = new JLabel("Stock Qty");
    	lblNewLabel_1_3.setBounds(101, 352, 110, 26);
    	lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_3);
    	
    	JLabel lblNewLabel_1_4 = new JLabel("Wholesale Price");
    	lblNewLabel_1_4.setBounds(100, 425, 140, 26);
    	lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_4);
    	
    	JLabel lblNewLabel_1_4_1 = new JLabel("Rettail Price");
    	lblNewLabel_1_4_1.setBounds(100, 462, 140, 26);
    	lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_4_1);
    	
    	
    	
    	 list2 = new JList();
    	 list2.addMouseListener(new MouseAdapter() {
    	 	@Override
    	 	public void mouseClicked(MouseEvent e) {

    	 		String s=(String) list2.getSelectedValue();
    			txtvendor.setText(s);
    			list2.setVisible(false);
    		    
    	 	
    	 	}
    	 });
    	 list2.addKeyListener(new KeyAdapter() {
    	 	@Override
    	 	public void keyPressed(KeyEvent e) {


        	 	if(e.getKeyCode()==KeyEvent.VK_ENTER) {
        	 		String s=(String) list2.getSelectedValue();
        			txtvendor.setText(s);
        			list2.setVisible(false);
        		    
        	 	}}
    	 });
    	 list2.setVisible(false);
     	list2.setModel(new AbstractListModel() {
     		String[] values = new String[] {};
     		public int getSize() {
     			return values.length;
     		}
     		public Object getElementAt(int index) {
     			return values[index];
     		}
     	});
     	list2.setBounds(835, 90, 225, 97);
     	add(list2);
     	 DefaultListModel model1 = new DefaultListModel();
         list2.setModel(model1);
    	
    	
    	txtdisc = new JTextField();
    	txtdisc.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyReleased(KeyEvent e) {

           		char c=e.getKeyChar();
    			if(Character.isLetter(c))
    			{
    				
    				 JOptionPane.showMessageDialog(null, "enter number");
    				 txttax.setText("");
    				
    				
    			}
           	
    		}
    	});
    	txtdisc.setBounds(250, 506,  225, 25);
    	add(txtdisc);
    	txtdisc.setColumns(10);
    	
    	txttax = new JTextField();
    	txttax.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyReleased(KeyEvent e) {
           		char c=e.getKeyChar();
    			if(Character.isLetter(c))
    			{
    				
    				 JOptionPane.showMessageDialog(null, "enter number");
    				 txttax.setText("");
    				
    				
    			}
           	
    		}
    	});
    	txttax.setBounds(250, 545, 225, 25);
    	add(txttax);
    	txttax.setColumns(10);
    	
    	JLabel disclabel = new JLabel("Discount");
    	disclabel.setFont(new Font("Tahoma", Font.BOLD, 15));
    	disclabel.setBounds(100, 509, 140, 14);
    	add(disclabel);
    	
    	JLabel taxlabel = new JLabel("Tax");
    	taxlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
    	taxlabel.setBounds(100, 548, 110, 14);
    	add(taxlabel);
    	
      
    	searchbox= new JTextField();
    	searchbox.addKeyListener(new KeyAdapter() {
    		
    		@Override
    		public void keyPressed(KeyEvent e) {
    			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
        			list.setVisible(true);
        			lister();
    			}
    		}
    	});
    	
    	searchbox.setBounds(251, 90, 224, 26);
         add(searchbox);
    	
    	JButton btnNewButton = new JButton("UPDATE");
    	btnNewButton.setBounds(250, 581, 110, 23);
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(!txtname.getText().equals("") & !txtrprice.getText().equals("") & !txtnqty.getText().equals("") & !txtwprice.getText().equals("") & !txtweight.getText().equals("") )
    				
    			{
    				float q1=Float.parseFloat(txtqty.getText());
    				float q2=Float.parseFloat(txtnqty.getText());
    				float q=q1+q2;
    			 try {  
    					Statement u = db.mycon().createStatement();
    					float t=Float.parseFloat(txtrprice.getText());
    					float t1=Float.parseFloat(txtweight.getText());
    					
    					float t3=Float.parseFloat(txtwprice.getText());
    					float t4=Float.parseFloat(txtdisc.getText());
    					float t5=Float.parseFloat(txttax.getText());

    			        u.execute("UPDATE sampledb.product SET rprice="+t+", qty="+q+",wprice="+t3+",wieght="+t1+",disc="+t4+",tax="+t5+" WHERE name LIKE '"+txtname.getText()+"'");  
    			        keyfun();
    			        JOptionPane.showMessageDialog(null, "Record is updated...");  
    			        u.close();  
    			       
    			 }
    				catch(SQLException e1) {
    					e1.printStackTrace();
    					 JOptionPane.showMessageDialog(null, "Record is NOT updated..."); 
    				}
    			
    			 }
    			else
				{
		            JOptionPane.showMessageDialog(null, "Enter all values");

				}

    		}
    	});
    	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(btnNewButton);
    	
    	JButton btnNewButton_1 = new JButton("CANCEL");
    	btnNewButton_1.setBounds(365, 581, 110, 23);
    	btnNewButton_1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    		}
    	});
    	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(btnNewButton_1);
    	
    	 list = new JList();
    	 list.addKeyListener(new KeyAdapter() {
    	 	@Override
    	 	public void keyPressed(KeyEvent e) {
    	 		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
    	 			
    	 			String s=(String) list.getSelectedValue();
    	 			searchbox.setText(s);
    	 			//list.setVisible(false);
    	 			String x =searchbox.getText();
    	 			txtnqty.setText("0");
    	 			{try {
    	 				Statement m = db.mycon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    	 				
    	 				ResultSet t=m.executeQuery("select * from sampledb.product where name ='"+x+"' order by rprice LIMIT 1");
    	 				t.first();
    	 				txtcode.setText(t.getString("productcode"));
    	 				 txtrprice.setText(t.getString("rprice"));
    	 				 txtwprice.setText(t.getString("wprice"));
    	 				 txtqty.setText(t.getString("qty"));
    	 				 txtname.setText(t.getString("name"));
    	 				 txtweight.setText(t.getString("wieght"));
    	 				 txtdisc.setText(t.getString("disc"));
    	 				 txttax.setText(t.getString("tax"));
    	 				//model.removeAllElements();
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
    	
    	 list.setBounds(251, 127, 224, 95);
    	 add(list);
    	 
    	 
       model = new DefaultListModel();
       list.setModel(model);
       
       txtweight = new JTextField();
       txtweight.addKeyListener(new KeyAdapter() {
       	@Override
       	public void keyReleased(KeyEvent e) {
       		char c=e.getKeyChar();
			if(Character.isLetter(c))
			{
				
				 JOptionPane.showMessageDialog(null, "enter number");
				 txtweight.setText("");
				
				
			}
       	}
       });
       txtweight.setBounds(251, 317, 224, 26);
       add(txtweight);
       txtweight.setColumns(10);
       
       
      
       txtnqty = new JTextField();
    	  txtnqty.addMouseListener(new MouseAdapter() {
    	  	@Override
    	  	public void mouseClicked(MouseEvent e) {
    	  		txtnqty.setText("");
    	  	}
    	  });
    	  txtnqty.setColumns(10);
    	  txtnqty.setBounds(246, 391, 224, 25);
    	  add(txtnqty);
    	  txtnqty.setText("0");
       txtnqty.addKeyListener(new KeyAdapter() {
       	@Override
       	public void keyReleased(KeyEvent e) {
       		char c=e.getKeyChar();
			if(Character.isLetter(c))
			{
				
				 JOptionPane.showMessageDialog(null, "enter number");
				 txtnqty.setText("0");
				
			}
       	}
       });
       txtqty = new JTextField();
       txtqty.setEditable(false);
       txtqty.setBounds(250, 354, 224, 25);
       add(txtqty);
       txtqty.setColumns(10);
       
       txtwprice = new JTextField();
       txtwprice.addKeyListener(new KeyAdapter() {
       	@Override
       	public void keyReleased(KeyEvent e) {
       		char c=e.getKeyChar();
			if(Character.isLetter(c))
			{
				
				 JOptionPane.showMessageDialog(null, "enter number");
				
				 txtwprice.setText("");
			}
       	}
       });
       txtwprice.setBounds(249, 426, 224, 26);
       add(txtwprice);
       txtwprice.setColumns(10);
       
       txtrprice = new JTextField();
       txtrprice.addKeyListener(new KeyAdapter() {
       	@Override
       	public void keyReleased(KeyEvent e) {
       		char c=e.getKeyChar();
			if(Character.isLetter(c))
			{
				
				 JOptionPane.showMessageDialog(null, "enter number");
				 txtrprice.setText("");
				
			}
       	}
       });
       txtrprice.setBounds(250, 463, 224, 25);
       add(txtrprice);
       txtrprice.setColumns(10);
       
       JLabel lblNewLabel_1_1_1 = new JLabel("Product Name");
       lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
       lblNewLabel_1_1_1.setBounds(101, 278, 110, 26);
       add(lblNewLabel_1_1_1);
       
       txtname = new JTextField();
       txtname.setEditable(false);
       txtname.setBounds(251, 280, 224, 26);
       add(txtname);
       txtname.setColumns(10);
       
       JButton btnNewButton_2 = new JButton("Generate Barcode");
       btnNewButton_2.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		try {
				Linear barcode = new Linear();
				barcode.setType(Linear.CODE128B);
				barcode.setData(txtcode.getText());
				barcode.setI(11.0f);
				String fname=txtcode.getText();
				barcode.renderBarcode("D:\\Barcode\\"+fname+".png");
				
				
			}
			catch(Exception a) {
				a.printStackTrace();
		}
       		
       	}
       });
       btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
       btnNewButton_2.setBounds(508, 552, 171, 39);
       add(btnNewButton_2);
       
       JScrollPane scrollPane = new JScrollPane();
     	scrollPane.setBounds(498, 198, 627, 333);
     	add(scrollPane);
       
       table = new JTable();
    	scrollPane.setViewportView(table);
   	  table.setModel(new DefaultTableModel(
   		new Object[][] {
   		},
   		new String[] {
   			"Product code", "Product Name", "Weight", "Quantity", "W Price", "R Price", "Amount"
   		}
   	));
   	table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
       
       txtcode = new JTextField();
       txtcode.setEditable(false);
       txtcode.setColumns(10);
       txtcode.setBounds(251, 243, 224, 26);
       add(txtcode);
       txtvendor = new JTextField();
       txtvendor.addKeyListener(new KeyAdapter() {
       
       	@Override
       	public void keyPressed(KeyEvent e) {
       		if(e.getKeyCode()==KeyEvent.VK_ENTER) {


    			list2.setVisible(true);
    			String m=txtvendor.getText();
    			try {
    			Statement s = db.mycon().createStatement();
    			ResultSet r = s.executeQuery("select vendor from sampledb.vendors where vendor like '%"+m+"%'order by vendor");
                model1.removeAllElements();
    			int v=0;
               while(r.next()& v<6) {
            	   
            	   model1.addElement(r.getString("vendor"));
            	   v++;
               }
              
    		}
    		catch(SQLException l) {
    			
    			l.printStackTrace();
    		}
    			
    			
    		
           		
           		
           	
       			
       		}
       	}
       });
       txtvendor.setBounds(835, 60, 225, 26);
   	add(txtvendor);
   	txtvendor.setColumns(10);
   	
   	JLabel lblNewLabel_3 = new JLabel("Vendor");
   	lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
   	lblNewLabel_3.setBounds(736, 59, 89, 23);
   	add(lblNewLabel_3);
       
       JLabel lblNewLabel_1_1_1_1 = new JLabel("Product Code");
       lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
       lblNewLabel_1_1_1_1.setBounds(101, 243, 110, 26);
       add(lblNewLabel_1_1_1_1);
       
       JButton GENBTN = new JButton("Save");
   	GENBTN.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent e) {
   			try {
          			DefaultTableModel model=(DefaultTableModel)table.getModel();
          			String a11,b11,c11,d11,e11,f11,g11,h11,i11;
          			h11=txtvendor.getText();
          			i11=txttotal.getText();
          			Statement s = db.mycon().createStatement();
          			for(int i=0;i<model.getRowCount();i++)
          				
          			{	
          				a11=model.getValueAt(i, 0).toString();
          				b11=model.getValueAt(i, 1).toString();
          				c11=model.getValueAt(i, 2).toString();
          				d11=model.getValueAt(i, 3).toString();
          				e11=model.getValueAt(i, 4).toString();
          				f11=model.getValueAt(i, 5).toString();
          				g11=model.getValueAt(i, 6).toString();
          				
          				s.executeUpdate("INSERT INTO sampledb.purchase (code,name,weight,qty,wprice,rprice,amount,vendor,datetime)VALUES ('"+a11+"','"+b11+"','"+c11+"','"+d11+"','"+e11+"','"+f11+"','"+g11+"','"+h11+"',(CURRENT_TIMESTAMP))");
          			 
          			}
          			s.executeUpdate("INSERT INTO sampledb.purchase2 (vendor,total,datetime)VALUES('"+h11+"','"+i11+"',(CURRENT_TIMESTAMP))");
          			JOptionPane.showMessageDialog(null, "Purchase Bill Saved");
   			}catch(SQLException f) {
           			
           			f.printStackTrace();
           		}
   			}
   		
   	});
   	GENBTN.setForeground(Color.WHITE);
   	GENBTN.setFont(new Font("Tahoma", Font.PLAIN, 18));
   	GENBTN.setBorder(new LineBorder(new Color(0, 0, 0)));
   	GENBTN.setBackground(Color.GREEN);
   	GENBTN.setBounds(713, 554, 147, 34);
   	add(GENBTN);
       
       JLabel lblNewLabel_1 = new JLabel("%");
       lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
       lblNewLabel_1.setBounds(486, 514, 19, 20);
       add(lblNewLabel_1);
       txttotal = new JTextField();
    	txttotal.setBounds(971, 554, 140, 26);
     	add(txttotal);
    	txttotal.setColumns(10);
   	
    	JLabel lblNewLabel_4 = new JLabel("Total");
    	lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
   	  lblNewLabel_4.setBounds(901, 554, 60, 26);
   	  add(lblNewLabel_4);
   	  
   
   	 
   	  
   	  JLabel lblNewLabel_1_3_1 = new JLabel("Purchase Qty");
   	  lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
   	  lblNewLabel_1_3_1.setBounds(97, 389, 110, 26);
   	  add(lblNewLabel_1_3_1);
   	  
   	  JButton btnNewButton_3 = new JButton("Add New Product");
   	  btnNewButton_3.addActionListener(new ActionListener() {
   	  	public void actionPerformed(ActionEvent e) {
   	  		addproduct addobj=new addproduct();
   	  		addobj.setVisible(true);
   	  	}
   	  });
   	  btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
   	  btnNewButton_3.setBounds(101, 27, 281, 39);
   	  add(btnNewButton_3);
   	  
   	  JButton btnNewButton_4 = new JButton("+");
   	  btnNewButton_4.addActionListener(new ActionListener() {
   	  	public void actionPerformed(ActionEvent e) {
   	  	Vendors vnd=new Vendors();
		vnd.setVisible(true);
   	  	}
   	  });
   	  btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 22));
   	  btnNewButton_4.setBounds(1070, 62, 55, 39);
   	  add(btnNewButton_4);
   
    	}
	
	public void lister(){
		
		String m=searchbox.getText();
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
	
	list.addMouseListener(new MouseAdapter(){
		
	@Override
	public void mouseClicked(MouseEvent e) {
		
		String s=(String) list.getSelectedValue();
		searchbox.setText(s);
		//list.setVisible(false);
		String x =searchbox.getText();
		txtnqty.setText("0");
		{try {
			Statement m = db.mycon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ResultSet t=m.executeQuery("select * from sampledb.product where name like '%"+x+"%' order by rprice LIMIT 1");
			t.first();
			txtcode.setText(t.getString("productcode"));
			 txtrprice.setText(t.getString("rprice"));
			 txtwprice.setText(t.getString("wprice"));
			 txtqty.setText(t.getString("qty"));
			 txtname.setText(t.getString("name"));
			 txtweight.setText(t.getString("wieght"));
			 txtdisc.setText(t.getString("disc"));
			 txttax.setText(t.getString("tax"));
			//model.removeAllElements();
			list.setVisible(false);
			
			
		
		
		}
		catch(SQLException d) {
			d.printStackTrace();
			
			
		}
		
		}
	}
	});}
	 public void keyfun() {
	        String x=txtnqty.getText();
	        String y=txtwprice.getText();
	        float x1=Float.parseFloat(x);
	        float y1=Float.parseFloat(y); 
	        float z=x1*y1;
	        String z1=String.valueOf(z);  	 
			 DefaultTableModel model=new DefaultTableModel();
			 model=(DefaultTableModel)table.getModel();
			 model.addRow(new Object[] {
				txtcode.getText(),
				txtname.getText(),
				txtweight.getText(),
			    txtnqty.getText(),
			   txtwprice.getText(),
			    txtrprice.getText(),
			     z1,
			});
			 float total=0;
 			for(int i=0;i<table.getRowCount();i++) {
 		    total=total+Float.parseFloat(table.getValueAt(i, 6).toString());}
 			String tot=String.valueOf(total);
 			float x7=Float.parseFloat(tot);
 			txttotal.setText(tot);
}	
}


