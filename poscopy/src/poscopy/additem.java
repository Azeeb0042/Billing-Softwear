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
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Go
 */
public class additem extends javax.swing.JPanel {
	private JTextArea wieght;

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
    	
    	JTextArea pcode = new JTextArea();
    	pcode.setBounds(251, 124, 224, 36);
    	add(pcode);
    	
    	JTextArea pname = new JTextArea();
    	pname.setBounds(251, 181, 224, 36);
    	add(pname);
    	
    	wieght = new JTextArea();
    	wieght.setBounds(251, 241, 224, 29);
    	add(wieght);
    	
    	JTextArea qty = new JTextArea();
    	qty.setBounds(251, 293, 224, 29);
    	add(qty);
    	
    	JTextArea rprice = new JTextArea();
    	rprice.setBounds(251, 401, 224, 29);
    	add(rprice);
    	
    	JTextArea wprice = new JTextArea();
    	wprice.setBounds(251, 350, 224, 29);
    	add(wprice);
    	
    	JButton btnNewButton = new JButton("ADD");
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
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
    		        }
    		}
    	});
    	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    	btnNewButton.setBounds(340, 441, 89, 23);
    	add(btnNewButton);
    	
    	JButton btnNewButton_1 = new JButton("RESET");
    	btnNewButton_1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    		}
    	});
    	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	btnNewButton_1.setBounds(523, 441, 89, 23);
    	add(btnNewButton_1);
        
        
        
        
    }

   
    
    
    
   
}
