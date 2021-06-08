package poscopy;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class updateitem extends JPanel {

	/**
	 * Create the panel.
	 */
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
    	
    	JLabel lblNewLabel_1 = new JLabel("Product Code");
    	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1.setBounds(49, 124, 110, 26);
    	add(lblNewLabel_1);
    	
    	JLabel lblNewLabel_1_1 = new JLabel("Product Name");
    	lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_1_1.setBounds(49, 181, 110, 26);
    	add(lblNewLabel_1_1);
    	
    	JLabel lblNewLabel_1_2 = new JLabel("Wight");
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
    	
    	JTextArea textArea = new JTextArea();
    	textArea.setBounds(251, 124, 224, 36);
    	add(textArea);
    	
    	JTextArea textArea_1 = new JTextArea();
    	textArea_1.setBounds(251, 181, 224, 36);
    	add(textArea_1);
    	
    	JTextArea textArea_2 = new JTextArea();
    	textArea_2.setBounds(251, 241, 224, 29);
    	add(textArea_2);
    	
    	JTextArea textArea_1_1 = new JTextArea();
    	textArea_1_1.setBounds(251, 293, 224, 29);
    	add(textArea_1_1);
    	
    	JTextArea textArea_1_1_1 = new JTextArea();
    	textArea_1_1_1.setBounds(251, 401, 224, 29);
    	add(textArea_1_1_1);
    	
    	JTextArea textArea_2_1 = new JTextArea();
    	textArea_2_1.setBounds(251, 350, 224, 29);
    	add(textArea_2_1);
    	
    	JButton btnNewButton = new JButton("UPDATE");
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    		}
    	});
    	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    	btnNewButton.setBounds(340, 441, 89, 23);
    	add(btnNewButton);
    	
    	JButton btnNewButton_1 = new JButton("CANCEL");
    	btnNewButton_1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    		}
    	});
    	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	btnNewButton_1.setBounds(523, 441, 89, 23);
    	add(btnNewButton_1);

	}

}
