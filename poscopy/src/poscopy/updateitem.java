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
	 
	

	
	public updateitem() {
		
    	setLayout(null);
    	
    	JPanel panel = new JPanel();
    	panel.setBounds(10, 11, 687, 68);
    	add(panel);
    	panel.setLayout(null);
    	
    	JLabel lblNewLabel = new JLabel("UPDATE PRODUCT");
    	lblNewLabel.setBounds(207, 11, 294, 46);
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
    	
    	JLabel lblNewLabel_1_3 = new JLabel("Quantity");
    	lblNewLabel_1_3.setBounds(101, 352, 110, 26);
    	lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_3);
    	
    	JLabel lblNewLabel_1_4 = new JLabel("Wholesale Price");
    	lblNewLabel_1_4.setBounds(101, 389, 140, 26);
    	lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_4);
    	
    	JLabel lblNewLabel_1_4_1 = new JLabel("Rettail Price");
    	lblNewLabel_1_4_1.setBounds(101, 426, 140, 26);
    	lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_4_1);
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
    	txtdisc.setBounds(251, 470,  225, 25);
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
    	txttax.setBounds(251, 509, 225, 25);
    	add(txttax);
    	txttax.setColumns(10);
    	
    	JLabel disclabel = new JLabel("Discount");
    	disclabel.setFont(new Font("Tahoma", Font.BOLD, 15));
    	disclabel.setBounds(101, 473, 140, 14);
    	add(disclabel);
    	
    	JLabel taxlabel = new JLabel("Tax");
    	taxlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
    	taxlabel.setBounds(101, 512, 110, 14);
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
    	btnNewButton.setBounds(587, 421, 110, 23);
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(!txtname.getText().equals("") & !txtrprice.getText().equals("") & !txtqty.getText().equals("") & !txtwprice.getText().equals("") & !txtweight.getText().equals("") )
    				
    			{
    			 try {  
    					Statement u = db.mycon().createStatement();
    					float t=Float.parseFloat(txtrprice.getText());
    					float t1=Float.parseFloat(txtweight.getText());
    					float t2=Float.parseFloat(txtqty.getText());
    					float t3=Float.parseFloat(txtwprice.getText());
    					float t4=Float.parseFloat(txtdisc.getText());
    					float t5=Float.parseFloat(txttax.getText());

    			        u.execute("UPDATE sampledb.product SET rprice="+t+", qty="+t2+",wprice="+t3+",wieght="+t1+",disc="+t4+",tax="+t5+" WHERE name LIKE '"+txtname.getText()+"'");  
    			        
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
    	btnNewButton_1.setBounds(587, 483, 110, 23);
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
       
       
       txtqty = new JTextField();
       txtqty.addKeyListener(new KeyAdapter() {
       	@Override
       	public void keyReleased(KeyEvent e) {
       		char c=e.getKeyChar();
			if(Character.isLetter(c))
			{
				
				 JOptionPane.showMessageDialog(null, "enter number");
				 txtqty.setText("");
				
			}
       	}
       });
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
       txtwprice.setBounds(250, 390, 224, 26);
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
       txtrprice.setBounds(251, 427, 224, 25);
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
       btnNewButton_2.setBounds(586, 156, 171, 39);
       add(btnNewButton_2);
       
       txtcode = new JTextField();
       txtcode.setEditable(false);
       txtcode.setColumns(10);
       txtcode.setBounds(251, 243, 224, 26);
       add(txtcode);
       
       JLabel lblNewLabel_1_1_1_1 = new JLabel("Product Code");
       lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
       lblNewLabel_1_1_1_1.setBounds(101, 243, 110, 26);
       add(lblNewLabel_1_1_1_1);
       
       JLabel lblNewLabel_1 = new JLabel("%");
       lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
       lblNewLabel_1.setBounds(486, 514, 19, 20);
       add(lblNewLabel_1);
   
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
}


