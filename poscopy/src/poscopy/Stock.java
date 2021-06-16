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
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
public class Stock extends javax.swing.JPanel {
	private JLabel qtymsg;

    /**
     * Creates new form customer1
     */
	 JTable table;
    public Stock() {
    	setLayout(null);
    	
    	JPanel panel = new JPanel();
    	panel.setBounds(10, 11, 687, 68);
    	add(panel);
    	panel.setLayout(null);
    	
    	JLabel lblNewLabel = new JLabel("STOCK");
    	lblNewLabel.setBounds(289, 11, 294, 46);
    	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
    	panel.add(lblNewLabel);
    	
    	JLabel qtymsg = new JLabel();
    	qtymsg.setBounds(525, 296, 110, 22);
    	add(qtymsg);
        
        
        
        
   		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 105, 577, 363);
	    add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ProductCode", "ProductName", "Quantity", "Wprice", "Rprice", "Weight"
			}
		));
		
		JButton LISTbtn = new JButton("LIST");
		LISTbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement s = db.mycon().createStatement();
					ResultSet r = s.executeQuery("select * from sampledb.product");
					
		           while(r.next()) {
		        	   String ProductCode=r.getString("productcode");
		        	   String ProductName=r.getString("name");
		        	   String Quantity=r.getString("qty");
		        	   String Wprice=r.getString("wprice");
		        	   String Rprice=r.getString("rprice");
		        	   String Weight=r.getString("wieght");
		        	 
		        	   	String str[]= {ProductCode,ProductName,Quantity,Wprice,Rprice,Weight};
		        	   	DefaultTableModel model=(DefaultTableModel)table.getModel();
		        	   	model.addRow(str);
		        	   	
		        	   	
		           }
				}
				catch(SQLException l) {
					
					l.printStackTrace();
				}
				
			}
		});
		LISTbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LISTbtn.setBounds(679, 127, 110, 39);
		add(LISTbtn);
		
		JButton dltbtn = new JButton("DELETE");
		dltbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        	   	DefaultTableModel model=(DefaultTableModel)table.getModel();
                int slct=table.getSelectedRow();
                model.removeRow(slct);
				
			}
		});
		dltbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dltbtn.setBounds(679, 195, 113, 39);
		add(dltbtn);
		
		
		
	}

   
    
    
    
   
}
