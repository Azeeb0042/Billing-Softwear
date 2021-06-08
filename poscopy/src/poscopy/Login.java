package poscopy;

import javax.swing.*;
import javax.swing.text.ChangedCharSetException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame implements ActionListener {
	
	

    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JCheckBox showPassword = new JCheckBox("Show Password");
   


    Login() {
    	this.setExtendedState(Login.MAXIMIZED_BOTH);
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AZEEB\\Downloads\\depositphotos_62960791-stock-illustration-machine-billing-icon-on-screen.jpg"));
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
    }

    public void setLocationAndSize() {


    }

    public void addComponentsToContainer() {
        getContentPane().setLayout(null);
        userLabel.setBounds(350, 150, 100, 30);
        container.add(userLabel);
        passwordLabel.setBounds(350, 220, 100, 30);
        container.add(passwordLabel);
        userTextField.setBounds(500, 150, 150, 30);
        container.add(userTextField);
        passwordField.setBounds(500, 220, 150, 30);
        container.add(passwordField);
        showPassword.setBounds(535, 257, 150, 30);
        container.add(showPassword);
        loginButton.setBounds(500, 350, 115, 36);
        container.add(loginButton);
        
        JPopupMenu popupMenu = new JPopupMenu();
        addPopup(loginButton, popupMenu);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {      
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("Azeeb") && pwdText.equalsIgnoreCase("0042")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
               
                Home  homeobj=new  Home();
                	
                homeobj.setVisible(true);
                this.setVisible(false);
                this.setExtendedState(Login.MAXIMIZED_BOTH);
               
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
               
            }
    }
         
              
        		  
            
           
              
                	
                
                	


        
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
            

        
        }
    }
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
			
		});
		
	}
	
}


