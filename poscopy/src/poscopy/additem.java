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

/**
 *
 * @author Go
 */
public class additem extends javax.swing.JPanel {
	private JTextField wieght;
	private JLabel qtymsg;

    /**
     * Creates new form customer1
     */
    public additem() {
    	setLayout(null);
    	
    	JPanel panel = new JPanel();
    	panel.setBounds(10, 11, 687, 68);
    	add(panel);
    	panel.setLayout(null);
    	
    	JLabel lblNewLabel = new JLabel("ADD NEW PRODUCT");
    	lblNewLabel.setBounds(207, 11, 294, 46);
    	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
    	panel.add(lblNewLabel);
    	
    	JLabel lblNewLabel_1 = new JLabel("Product Code");
    	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1.setBounds(49, 124, 110, 26);
    	add(lblNewLabel_1);
    	
    	JLabel lblNewLabel_1_1 = new JLabel("Product Name");
    	lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1_1.setBounds(49, 181, 110, 26);
    	add(lblNewLabel_1_1);
    	
    	JLabel lblNewLabel_1_2 = new JLabel("Weight");
    	lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1_2.setBounds(49, 244, 110, 26);
    	add(lblNewLabel_1_2);
    	
    	JLabel lblNewLabel_1_3 = new JLabel("Quantity");
    	lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1_3.setBounds(49, 296, 110, 26);
    	add(lblNewLabel_1_3);
    	
    	JLabel lblNewLabel_1_4 = new JLabel("Wholesale Price");
    	lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1_4.setBounds(49, 353, 140, 26);
    	add(lblNewLabel_1_4);
    	
    	JLabel lblNewLabel_1_4_1 = new JLabel("Rettail Price");
    	lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1_4_1.setBounds(49, 404, 140, 26);
    	add(lblNewLabel_1_4_1);
    	
    	JTextField pcode = new JTextField();
    	pcode.setBounds(251, 124, 224, 26);
    	add(pcode);
    	
    	JTextField pname = new JTextField();
    	pname.setBounds(251, 191, 224, 26);
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
    	wieght.setBounds(251, 241, 224, 29);
    	add(wieght);
    	
    	JTextField qty = new JTextField();
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
    	
    	qty.setBounds(251, 293, 224, 29);
    	add(qty);
    	
    	JTextField rprice = new JTextField();
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
    	rprice.setBounds(251, 401, 224, 29);
    	add(rprice);
    	
    	JTextField wprice = new JTextField();
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
    	wprice.setBounds(251, 350, 224, 29);
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
        			 try {
        		            
        		            Statement s = db.mycon().createStatement();
        		            s.executeUpdate(" INSERT INTO sampledb.product(productcode,name,qty,wieght,rprice,wprice) VALUES ('"+code+"','"+name+"','"+floatqty+"','"+floatwiegh+"','"+floatrpri+"','"+floatwpri+"')");
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
    			 try {
    		            
    		            Statement s = db.mycon().createStatement();
    		            s.executeUpdate(" INSERT INTO sampledb.product(productcode,name,qty,wieght,rprice,wprice) VALUES ('"+code+"','"+name+"','"+floatqty+"','"+floatwiegh+"','"+floatrpri+"','"+floatwpri+"')");
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
    	});
    	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    	btnNewButton.setBounds(340, 441, 89, 23);
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
    	btnNewButton_1.setBounds(523, 441, 89, 23);
    	add(btnNewButton_1);
    	
    	JLabel qtymsg = new JLabel();
    	qtymsg.setBounds(525, 296, 110, 22);
    	add(qtymsg);
        
        
        
        
    }

   
    
    
    
   
}
