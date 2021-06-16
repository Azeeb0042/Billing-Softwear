package poscopy;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class sales extends JPanel {

	/**
	 * Create the panel.
	 */
	public sales() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 0, 607, 69);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sales Report");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(63, 11, 127, 31);
		panel.add(lblNewLabel);

	}
}
