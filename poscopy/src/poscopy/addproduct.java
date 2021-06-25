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
import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.Rectangle;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;

/**
 *
 * @author Go
 */
public class addproduct extends javax.swing.JFrame {
	private JTextField wieght;
	private JLabel qtymsg;
	private JFormattedTextField txtdisc;
	private JTextField txttax;
	private JButton clsbtn;
	JTextField rprice ;
	JTextField pcode ;
	JTextField pname ;
	JTextField qty ;
	JTextField wprice ;

    /**
     * Creates new form customer1
     */
    public addproduct() {
    	setName("ADD ITEM");
    	setForeground(new Color(255, 255, 153));
    	getContentPane().setBackground(new Color(255, 255, 153));
    	setBackground(new Color(255, 255, 153));
    	setType(Type.UTILITY);
    	setExtendedState(Frame.ICONIFIED);
    	setBounds(new Rectangle(180, 80, 1000, 600));
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	getContentPane().setLayout(null);
    	
    	JLabel lblNewLabel_1 = new JLabel("Product Code");
    	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1.setBounds(59, 39, 110, 26);
    	getContentPane().add(lblNewLabel_1);
    	
    	JLabel lblNewLabel_1_1 = new JLabel("Product Name");
    	lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1_1.setBounds(59, 79, 110, 26);
    	getContentPane().add(lblNewLabel_1_1);
    	
    	JLabel lblNewLabel_1_2 = new JLabel("Weight");
    	lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1_2.setBounds(59, 116, 110, 26);
    	getContentPane().add(lblNewLabel_1_2);
    	
    	JLabel lblNewLabel_1_3 = new JLabel("Quantity");
    	lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1_3.setBounds(59, 159, 110, 26);
    	getContentPane().add(lblNewLabel_1_3);
    	
    	JLabel lblNewLabel_1_4 = new JLabel("Wholesale Price");
    	lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1_4.setBounds(59, 202, 140, 26);
    	getContentPane().add(lblNewLabel_1_4);
    	
    	JLabel lblNewLabel_1_4_1 = new JLabel("Rettail Price");
    	lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1_4_1.setBounds(59, 239, 140, 26);
    	getContentPane().add(lblNewLabel_1_4_1);
     	 DefaultListModel model1 = new DefaultListModel();
    	
        pcode = new JTextField();
    	pcode.setBounds(249, 42, 225, 25);
    	getContentPane().add(pcode);
    	
    	 pname = new JTextField();
    	pname.setBounds(249, 82, 225, 25);
    	getContentPane().add(pname);
    	
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
    	wieght.setBounds(249, 122, 225, 25);
    	getContentPane().add(wieght);
    	
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
    	
    	qty.setBounds(249, 162,  225, 25);
    	getContentPane().add(qty);
    	
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
    	rprice.setBounds(249, 242,  225, 25);
    	getContentPane().add(rprice);
    	
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
    	wprice.setBounds(250, 202, 225, 25);
    	getContentPane().add(wprice);
    	
    	JButton btnNewButton = new JButton("ADD");
    	btnNewButton.setForeground(new Color(255, 255, 255));
    	btnNewButton.setBackground(new Color(0, 51, 51));
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
    		            //keyfun();
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
    	btnNewButton.setBounds(281, 369, 89, 23);
    	getContentPane().add(btnNewButton);
    	
    	JButton btnNewButton_1 = new JButton("RESET");
    	btnNewButton_1.setForeground(new Color(255, 255, 255));
    	btnNewButton_1.setBackground(new Color(0, 51, 51));
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
    	btnNewButton_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
    	btnNewButton_1.setBounds(399, 369, 89, 23);
    	getContentPane().add(btnNewButton_1);
    	
    	JLabel qtymsg = new JLabel();
    	qtymsg.setBounds(525, 296, 110, 22);
    	getContentPane().add(qtymsg);
    	
    	txtdisc = new JFormattedTextField();
    	txtdisc.setBounds(249, 282,  225, 25);
    	getContentPane().add(txtdisc);
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
    	txttax.setBounds(249, 322, 225, 25);
    	getContentPane().add(txttax);
    	txttax.setColumns(10);
    	txttax.setText("0");
    	
    	JLabel disclabel = new JLabel("Discount");
    	disclabel.setFont(new Font("Tahoma", Font.BOLD, 15));
    	disclabel.setBounds(59, 285, 140, 14);
    	getContentPane().add(disclabel);
    	
    	JLabel taxlabel = new JLabel("Tax");
    	taxlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
    	taxlabel.setBounds(59, 325, 110, 14);
    	getContentPane().add(taxlabel);
    	
    	JLabel lblNewLabel_2 = new JLabel("%");
    	lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	lblNewLabel_2.setBounds(484, 317, 23, 30);
    	getContentPane().add(lblNewLabel_2);
    
        
        
    }
    
}