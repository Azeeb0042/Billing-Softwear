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
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


import javax.swing.JList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
	JTextArea textArea_1;
	

	private DefaultListModel model;
	private JTextField txtweight;
	private JTextField txtqty;
	private JTextField txtwprice;
	private JTextField txtrprice;
	private JTextField txtname;
	

	
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
    	lblNewLabel_1_2.setBounds(101, 278, 110, 26);
    	lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_2);
    	
    	JLabel lblNewLabel_1_3 = new JLabel("Quantity");
    	lblNewLabel_1_3.setBounds(101, 315, 110, 26);
    	lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_3);
    	
    	JLabel lblNewLabel_1_4 = new JLabel("Wholesale Price");
    	lblNewLabel_1_4.setBounds(101, 366, 140, 26);
    	lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_4);
    	
    	JLabel lblNewLabel_1_4_1 = new JLabel("Rettail Price");
    	lblNewLabel_1_4_1.setBounds(101, 403, 140, 26);
    	lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(lblNewLabel_1_4_1);
    	
      
    	textArea_1= new JTextArea();
    	textArea_1.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyReleased(KeyEvent e) {
    			list.setVisible(true);
    			lister();
    		}
    	});
    	
    	textArea_1.setBounds(251, 90, 224, 26);
         add(textArea_1);
    	
    	JButton btnNewButton = new JButton("UPDATE");
    	btnNewButton.setBounds(340, 441, 110, 23);
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    		}
    	});
    	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(btnNewButton);
    	
    	JButton btnNewButton_1 = new JButton("CANCEL");
    	btnNewButton_1.setBounds(523, 441, 126, 23);
    	btnNewButton_1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    		}
    	});
    	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	add(btnNewButton_1);
    	
    	 list = new JList();
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
       txtweight.setBounds(251, 279, 224, 26);
       add(txtweight);
       txtweight.setColumns(10);
       
       txtqty = new JTextField();
       txtqty.setBounds(251, 316, 224, 25);
       add(txtqty);
       txtqty.setColumns(10);
       
       txtwprice = new JTextField();
       txtwprice.setBounds(251, 361, 224, 26);
       add(txtwprice);
       txtwprice.setColumns(10);
       
       txtrprice = new JTextField();
       txtrprice.setBounds(251, 404, 224, 25);
       add(txtrprice);
       txtrprice.setColumns(10);
       
       JLabel lblNewLabel_1_1_1 = new JLabel("Product Name");
       lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
       lblNewLabel_1_1_1.setBounds(101, 243, 110, 26);
       add(lblNewLabel_1_1_1);
       
       txtname = new JTextField();
       txtname.setBounds(251, 242, 224, 26);
       add(txtname);
       txtname.setColumns(10);
   
    	}
	
	public void lister(){
		
		String m=textArea_1.getText();
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
		textArea_1.setText(s);
		//list.setVisible(false);
		String x =textArea_1.getText();
		{try {
			Statement m = db.mycon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ResultSet t=m.executeQuery("select * from sampledb.product where name like '%"+x+"%' order by rprice LIMIT 1");
			t.first();
			
			 txtrprice.setText(t.getString("rprice"));
			 txtwprice.setText(t.getString("wprice"));
			 txtqty.setText(t.getString("qty"));
			 txtname.setText(t.getString("name"));
			 txtweight.setText(t.getString("wieght"));
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


