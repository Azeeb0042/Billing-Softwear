package poscopy;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sales extends JPanel {

	/**
	 * Create the panel.
	 */
	public sales() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(87, 3, 502, 69);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sales Report");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(63, 11, 127, 31);
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

	}
}
