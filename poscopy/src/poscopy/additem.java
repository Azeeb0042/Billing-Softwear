/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poscopy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.barcodelib.barcode.Linear;

import poscopy.db;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Go
 */
public class additem extends javax.swing.JPanel {
	private JTextField wieght;
	private JLabel qtymsg;
	private JFormattedTextField txtdisc;
	private JTextField txttax;
	private JButton clsbtn;
	private JTable table;
	private JTextField txtvendor;
	private JTextField txttotal;
	JTextField rprice ;
	JTextField pcode ;
	JTextField pname ;
	JTextField qty ;
	JTextField wprice ;
	JList list;

    /**
     * Creates new form customer1
     */
    public additem() {
    	setLayout(null);
    	//list.setVisible(false);
    	
    	JPanel panel = new JPanel();
    	panel.setBounds(235, 11, 687, 68);
    	add(panel);
    	panel.setLayout(null);
    	
    	JLabel lblNewLabel = new JLabel("ADD NEW PRODUCT");
    	lblNewLabel.setBounds(207, 11, 294, 46);
    	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
    	panel.add(lblNewLabel);
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
    	
    	JLabel lblNewLabel_1 = new JLabel("Product Code");
    	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1.setBounds(60, 87, 110, 26);
    	add(lblNewLabel_1);
    	
    	JLabel lblNewLabel_1_1 = new JLabel("Product Name");
    	lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1_1.setBounds(60, 127, 110, 26);
    	add(lblNewLabel_1_1);
    	
    	JLabel lblNewLabel_1_2 = new JLabel("Weight");
    	lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1_2.setBounds(60, 164, 110, 26);
    	add(lblNewLabel_1_2);
    	
    	JLabel lblNewLabel_1_3 = new JLabel("Quantity");
    	lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1_3.setBounds(60, 207, 110, 26);
    	add(lblNewLabel_1_3);
    	
    	JLabel lblNewLabel_1_4 = new JLabel("Wholesale Price");
    	lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1_4.setBounds(60, 250, 140, 26);
    	add(lblNewLabel_1_4);
    	
    	JLabel lblNewLabel_1_4_1 = new JLabel("Rettail Price");
    	lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1_4_1.setBounds(60, 287, 140, 26);
    	add(lblNewLabel_1_4_1);
    	 list = new JList();
    	 list.addMouseListener(new MouseAdapter() {
    	 	@Override
    	 	public void mouseClicked(MouseEvent e) {

    	 		String s=(String) list.getSelectedValue();
    			txtvendor.setText(s);
    			list.setVisible(false);
    		    
    	 	
    	 	}
    	 });
    	 list.addKeyListener(new KeyAdapter() {
    	 	@Override
    	 	public void keyPressed(KeyEvent e) {


        	 	if(e.getKeyCode()==KeyEvent.VK_ENTER) {
        	 		String s=(String) list.getSelectedValue();
        			txtvendor.setText(s);
        			list.setVisible(false);
        		    
        	 	}}
    	 });
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
     	list.setBounds(843, 117, 225, 80);
     	add(list);
     	 DefaultListModel model1 = new DefaultListModel();
         list.setModel(model1);
    	
        pcode = new JTextField();
    	pcode.setBounds(250, 90, 225, 25);
    	add(pcode);
    	
    	 pname = new JTextField();
    	pname.setBounds(250, 130, 225, 25);
    	add(pname);
    	
    	wieght = new JTextField();
    	wieght.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyReleased(KeyEvent e) {

    			char c=e.getKeyChar();
    			if(Character.isLetter(c))
    			{
    				
    				 JOptionPane.showMessageDialog(null, "enter number");
    				 wieght.setText("");
    				
    			}
    		
    		}
    	});
    	wieght.setBounds(250, 170, 225, 25);
    	add(wieght);
    	
    	 qty = new JTextField();
    	qty.addKeyListener(new KeyAdapter() {
    		
    		@Override
    		public void keyReleased(KeyEvent e) {
    			char c=e.getKeyChar();
    			if(Character.isLetter(c))
    			{
    				
    				 JOptionPane.showMessageDialog(null, "enter number");
    				
    				 qty.setText("");
    			}
    		}
    	});
    	
    	qty.setBounds(250, 210,  225, 25);
    	add(qty);
    	
    	 rprice = new JTextField();
    	rprice.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyReleased(KeyEvent e) {

    			char c=e.getKeyChar();
    			if(Character.isLetter(c))
    			{
    				
    				 JOptionPane.showMessageDialog(null, "enter number");
    				
    				 rprice.setText("");
    			}
    		
    		}
    	});
    	rprice.setBounds(250, 290,  225, 25);
    	add(rprice);
    	
    	 wprice = new JTextField();
    	wprice.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyReleased(KeyEvent e) {

    			char c=e.getKeyChar();
    			if(Character.isLetter(c))
    			{ JOptionPane.showMessageDialog(null, "enter number");
    			 wprice.setText("");
    				
    			}
    		
    		}
    	});
    	wprice.setBounds(251, 250, 225, 25);
    	add(wprice);
    	
    	JButton btnNewButton = new JButton("ADD");
    	btnNewButton.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyPressed(KeyEvent e) {
    			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
    				if(!pcode.getText().equals("") & !rprice.getText().equals("") & !qty.getText().equals("") & !wprice.getText().equals("") & !pname.getText().equals("") & !wieght.getText().equals("") ) 
    				{
    				String code=pcode.getText();
        			String name=pname.getText();
        			String qtyn=qty.getText();
        			float floatqty=Float.parseFloat(qtyn);
        			String wpri=wprice.getText();
        			float floatwpri=Float.parseFloat(wpri);
        			String rpri=rprice.getText();
        			float floatrpri=Float.parseFloat(rpri);
        			String wiegh=wieght.getText();
        			float floatwiegh=Float.parseFloat(wiegh);
        			String disco=txtdisc.getText();
        			float floatdisc=Float.parseFloat(disco);
        			String taxe=txttax.getText();
        			float floattax=Float.parseFloat(taxe);
        			 try {
        		            
        		            Statement s = db.mycon().createStatement();
        		            s.executeUpdate(" INSERT INTO sampledb.product(productcode,name,qty,wieght,rprice,wprice,disc,tax) VALUES ('"+code+"','"+name+"','"+floatqty+"','"+floatwiegh+"','"+floatrpri+"','"+floatwpri+"','"+floatdisc+"','"+floattax+"')");
        		             JOptionPane.showMessageDialog(null, "Added Item");
        		            
        		            
        		        } catch (Exception b) { 
        		            System.out.println(b);
        		            JOptionPane.showMessageDialog(null, b);
        		        }
    				
    			}
    				else
    				{
    		            JOptionPane.showMessageDialog(null, "Enter all values");

    				}
    			
    			}
    		}
    	});
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
				if(!pcode.getText().equals("") & !rprice.getText().equals("") & !qty.getText().equals("") & !wprice.getText().equals("") & !pname.getText().equals("") & !wieght.getText().equals("") ) 
				{
					 
				String code=pcode.getText();
    			String name=pname.getText();
    			String qtyn=qty.getText();
    			float floatqty=Float.parseFloat(qtyn);
    			String wpri=wprice.getText();
    			float floatwpri=Float.parseFloat(wpri);
    			String rpri=rprice.getText();
    			float floatrpri=Float.parseFloat(rpri);
    			String wiegh=wieght.getText();
    			float floatwiegh=Float.parseFloat(wiegh);
    			String disco=txtdisc.getText();
    			float floatdisc=Float.parseFloat(disco);
    			String taxe=txttax.getText();
    			float floattax=Float.parseFloat(taxe);
    			 try {
    				   
    		            Statement s = db.mycon().createStatement();
    		            s.executeUpdate(" INSERT INTO sampledb.product(productcode,name,qty,wieght,rprice,wprice,disc,tax) VALUES ('"+code+"','"+name+"','"+floatqty+"','"+floatwiegh+"','"+floatrpri+"','"+floatwpri+"','"+floatdisc+"','"+floattax+"')");
    		            keyfun();
    		            JOptionPane.showMessageDialog(null, "Added Item");
    		            
    		            
    		        } catch (Exception b) { 
    		           
    		            JOptionPane.showMessageDialog(null, b);
    		        }
				
			}
				else
				{
		            JOptionPane.showMessageDialog(null, "Enter all values");

				}
			
			}
    	});
    	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    	btnNewButton.setBounds(202, 468, 89, 23);
    	add(btnNewButton);
    	
    	JButton btnNewButton_1 = new JButton("RESET");
    	btnNewButton_1.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyPressed(KeyEvent e) {
    			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
    				pcode.setText("");
       			 pname.setText("");
       			 wieght.setText("");
       			 qty.setText("");
       			 rprice.setText("");
       			 wprice.setText("");
    				
    			}
    		}
    	});
    	btnNewButton_1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			pcode.setText("");
    			 pname.setText("");
    			 wieght.setText("");
    			 qty.setText("");
    			 rprice.setText("");
    			 wprice.setText("");
    		}
    	});
    	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	btnNewButton_1.setBounds(399, 468, 89, 23);
    	add(btnNewButton_1);
    	
    	JLabel qtymsg = new JLabel();
    	qtymsg.setBounds(525, 296, 110, 22);
    	add(qtymsg);
    	
    	txtdisc = new JFormattedTextField();
    	txtdisc.setBounds(250, 330,  225, 25);
    	add(txtdisc);
    	txtdisc.setText("0");
    	
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
    	txttax.setBounds(250, 370, 225, 25);
    	add(txttax);
    	txttax.setColumns(10);
    	txttax.setText("0");
    	
    	JLabel disclabel = new JLabel("Discount");
    	disclabel.setFont(new Font("Tahoma", Font.BOLD, 15));
    	disclabel.setBounds(60, 333, 140, 14);
    	add(disclabel);
    	
    	JLabel taxlabel = new JLabel("Tax");
    	taxlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
    	taxlabel.setBounds(60, 373, 110, 14);
    	add(taxlabel);
    	
    	JLabel lblNewLabel_2 = new JLabel("%");
    	lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	lblNewLabel_2.setBounds(476, 365, 23, 30);
    	add(lblNewLabel_2);
    	
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
    	
    	txtvendor = new JTextField();
    	txtvendor.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyReleased(KeyEvent e) {
    			list.setVisible(true);
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
    	});
    	txtvendor.setBounds(843, 91, 225, 26);
    	add(txtvendor);
    	txtvendor.setColumns(10);
    	
    	JLabel lblNewLabel_3 = new JLabel("Vendor");
    	lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
    	lblNewLabel_3.setBounds(744, 90, 89, 23);
    	add(lblNewLabel_3);
    	
       
    	
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
    	GENBTN.setBounds(727, 555, 147, 34);
    	add(GENBTN);
    	
    	txttotal = new JTextField();
    	txttotal.setBounds(985, 555, 140, 26);
    	add(txttotal);
    	txttotal.setColumns(10);
    	
    	JLabel lblNewLabel_4 = new JLabel("Total");
    	lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
    	lblNewLabel_4.setBounds(915, 555, 60, 26);
    	add(lblNewLabel_4);
    	
    	JButton btnNewButton_2 = new JButton("+");
    	btnNewButton_2.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			Vendors vnd=new Vendors();
    			vnd.setVisible(true);
    		}
    	});
    	btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
    	btnNewButton_2.setBounds(1076, 91, 49, 34);
    	add(btnNewButton_2);
    
        
        
    }
    public void keyfun() {
    	        String x=qty.getText();
    	        String y=wprice.getText();
    	        float x1=Float.parseFloat(x);
    	        float y1=Float.parseFloat(y); 
    	        float z=x1*y1;
    	        String z1=String.valueOf(z);  	 
				 DefaultTableModel model=new DefaultTableModel();
				 model=(DefaultTableModel)table.getModel();
				 model.addRow(new Object[] {
   					pcode.getText(),
   					pname.getText(),
   					wieght.getText(),
   				    qty.getText(),
   				    wprice.getText(),
   				    rprice.getText(),
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