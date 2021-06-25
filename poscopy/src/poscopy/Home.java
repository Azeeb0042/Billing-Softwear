package poscopy;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import java.awt.Button;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.border.MatteBorder;
import java.awt.ComponentOrientation;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.DebugGraphics;
import java.awt.Frame;





public class Home extends javax.swing.JFrame {

    JpanelLoader jpload = new JpanelLoader();
    
    
    
    
    
    
    
    public Home() {
    	setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    	setBackground(new Color(102, 102, 51));
    	setTitle("BILLING POS");
        initComponents();
        this.setExtendedState(Home.MAXIMIZED_BOTH);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
        menuBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        menuBar.setBackground(new Color(176, 224, 230));
        setJMenuBar(menuBar);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("INIT BILL");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Billinsec bill = new Billinsec();
                jpload.jPanelLoader(panel_load, bill);
        		
        	}
        });
        mntmNewMenuItem_1.setPreferredSize(new Dimension(100, 26));
        mntmNewMenuItem_1.setBackground(new Color(0, 0, 51));
        menuBar.add(mntmNewMenuItem_1);
        
        JMenuItem mntmNewMenuItem_4 = new JMenuItem("MONTHLY");
        mntmNewMenuItem_4.setPreferredSize(new Dimension(100, 26));
        menuBar.add(mntmNewMenuItem_4);
        
        JMenuItem mntmNewMenuItem_3 = new JMenuItem("DAILY");
        mntmNewMenuItem_3.setPreferredSize(new Dimension(100, 26));
        menuBar.add(mntmNewMenuItem_3);
        
        JMenuItem mntmNewMenuItem_7 = new JMenuItem("ADD PRODUCT");
        mntmNewMenuItem_7.setPreferredSize(new Dimension(100, 26));
        mntmNewMenuItem_7.setHorizontalAlignment(SwingConstants.LEFT);
        mntmNewMenuItem_7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_UNDEFINED, 0));
        mntmNewMenuItem_7.setForeground(new Color(0, 0, 0));
        mntmNewMenuItem_7.setBackground(new Color(0, 0, 51));
        mntmNewMenuItem_7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		addproduct addobj=new addproduct();
       	  		addobj.setVisible(true);
        	}
        });
        menuBar.add(mntmNewMenuItem_7);
        
        JMenuItem mntmNewMenuItem_6 = new JMenuItem("UPDATE DETAILS");
        mntmNewMenuItem_6.setPreferredSize(new Dimension(100, 26));
        menuBar.add(mntmNewMenuItem_6);
        
        JMenuItem mntmNewMenuItem_5 = new JMenuItem("ESTIMATE");
        mntmNewMenuItem_5.setPreferredSize(new Dimension(100, 26));
        menuBar.add(mntmNewMenuItem_5);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("EDIT BILL");
        mntmNewMenuItem_2.setPreferredSize(new Dimension(100, 26));
        menuBar.add(mntmNewMenuItem_2);
        
        
        
        
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home_bnt_grp = new javax.swing.ButtonGroup();
        panel_load = new javax.swing.JPanel();
        panel_load.setBackground(new Color(255, 255, 153));
        jPanel3 = new javax.swing.JPanel();
        jPanel3.setBackground(new Color(0, 51, 102));
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_load.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        
        JToggleButton jToggleButton7_1 = new JToggleButton();
        jToggleButton7_1.setBackground(new Color(0, 51, 51));
        jToggleButton7_1.setText("Reports");
        jToggleButton7_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JToggleButton jToggleButton1_1 = new JToggleButton();
        jToggleButton1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		additem add = new additem();
        	       jpload.jPanelLoader(panel_load, add);
        	       jPanel3.setVisible(true);
        		
        	}
        });
        jToggleButton1_1.setText("Add Item");
        jToggleButton1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JToggleButton jToggleButton3_1 = new JToggleButton();
        jToggleButton3_1.setText("Billing");
        jToggleButton3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JToggleButton jToggleButton2_1 = new JToggleButton();
        jToggleButton2_1.setText("Update Item");
        jToggleButton2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JToggleButton jToggleButton5_1 = new JToggleButton();
        jToggleButton5_1.setText("Edit Bill");
        jToggleButton5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JToggleButton jToggleButton6_1 = new JToggleButton();
        jToggleButton6_1.setText("Invoice");
        jToggleButton6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JToggleButton jToggleButton4_1 = new JToggleButton();
        jToggleButton4_1.setText("Stock");
        jToggleButton4_1.setFont(new Font("Tahoma", Font.BOLD, 14));

        javax.swing.GroupLayout panel_loadLayout = new javax.swing.GroupLayout(panel_load);
        panel_loadLayout.setHorizontalGroup(
        	panel_loadLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panel_loadLayout.createSequentialGroup()
        			.addGap(275)
        			.addGroup(panel_loadLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jToggleButton1_1, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
        				.addGroup(panel_loadLayout.createParallelGroup(Alignment.TRAILING, false)
        					.addComponent(jToggleButton5_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jToggleButton7_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
        			.addGap(45)
        			.addComponent(jToggleButton3_1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
        			.addGap(74)
        			.addGroup(panel_loadLayout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jToggleButton4_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jToggleButton2_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
        				.addComponent(jToggleButton6_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap(284, Short.MAX_VALUE))
        );
        panel_loadLayout.setVerticalGroup(
        	panel_loadLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panel_loadLayout.createSequentialGroup()
        			.addGap(75)
        			.addGroup(panel_loadLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jToggleButton3_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jToggleButton2_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jToggleButton7_1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
        			.addGap(30)
        			.addGroup(panel_loadLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(panel_loadLayout.createSequentialGroup()
        					.addComponent(jToggleButton6_1, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        					.addGap(29))
        				.addGroup(panel_loadLayout.createSequentialGroup()
        					.addComponent(jToggleButton1_1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addGroup(panel_loadLayout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jToggleButton4_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jToggleButton5_1, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
        			.addContainerGap(109, Short.MAX_VALUE))
        );
        panel_load.setLayout(panel_loadLayout);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 1342, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 61, Short.MAX_VALUE)
        );
        jPanel3.setLayout(jPanel3Layout);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 51, 102));
        panel.setForeground(new Color(0, 51, 102));
        panel.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new LineBorder(new Color(0, 0, 0))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jPanel3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1346, Short.MAX_VALUE)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(panel_load, GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
        				.addComponent(panel_load, GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE))
        			.addContainerGap())
        );
        panel.setLayout(null);
        HOME1 = new javax.swing.JToggleButton();
        HOME1.setForeground(new Color(255, 255, 255));
        HOME1.setBackground(new Color(0, 51, 51));
        HOME1.setBounds(10, 6, 130, 50);
        panel.add(HOME1);
        
                home_bnt_grp.add(HOME1);
                HOME1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                //jToggleButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/reports.png"))); // NOI18N
                HOME1.setText("Edit Bill");
                        HOME2 = new javax.swing.JToggleButton();
                        HOME2.setForeground(new Color(255, 255, 255));
                        HOME2.setBackground(new Color(0, 51, 51));
                        HOME2.setBounds(10, 67, 130, 49);
                        panel.add(HOME2);
                        
                                home_bnt_grp.add(HOME2);
                                HOME2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                                //jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/product.png"))); // NOI18N
                                HOME2.setText("Billing");
                                HOME3 = new javax.swing.JToggleButton();
                                HOME3.setForeground(new Color(255, 255, 255));
                                HOME3.setBackground(new Color(0, 51, 51));
                                HOME3.setBounds(10, 127, 130, 51);
                                panel.add(HOME3);
                                
                                        home_bnt_grp.add(HOME3);
                                        HOME3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                                        //jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/supplier.png"))); // NOI18N
                                        HOME3.setText("Item\r\n");
                                        HOME7 = new javax.swing.JToggleButton();
                                        HOME7.setForeground(new Color(255, 255, 255));
                                        HOME7.setBackground(new Color(0, 51, 51));
                                        HOME7.setBounds(10, 364, 130, 50);
                                        panel.add(HOME7);
                                        
                                                home_bnt_grp.add(HOME7);
                                                HOME7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                                                //jToggleButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/invo.png"))); // NOI18N
                                                HOME7.setText("Month");
                                                HOME4 = new javax.swing.JToggleButton();
                                                HOME4.setForeground(new Color(255, 255, 255));
                                                HOME4.setBackground(new Color(0, 51, 51));
                                                HOME4.setBounds(10, 189, 130, 42);
                                                panel.add(HOME4);
                                                
                                                        home_bnt_grp.add(HOME4);
                                                        HOME4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                                                        //jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/emp.png"))); // NOI18N
                                                        HOME4.setText("Stock");
                                                                
                                                                JToggleButton HOME5 = new JToggleButton();
                                                                HOME5.addActionListener(new ActionListener() {
                                                                	public void actionPerformed(ActionEvent e) {
                                                                		Purchasereport obj = new Purchasereport();
                                                                        jpload.jPanelLoader(panel_load, obj);
                                                                      
                                                                	}
                                                                });
                                                                HOME5.setForeground(new Color(255, 255, 255));
                                                                HOME5.setText("Purchase Rep");
                                                                HOME5.setFont(new Font("Tahoma", Font.BOLD, 14));
                                                                HOME5.setBackground(new Color(0, 51, 51));
                                                                HOME5.setBounds(10, 242, 130, 50);
                                                                panel.add(HOME5);
                                                                HOME8 = new javax.swing.JToggleButton();
                                                                HOME8.setBounds(10, 425, 130, 51);
                                                                panel.add(HOME8);
                                                                HOME8.setForeground(new Color(255, 255, 255));
                                                                HOME8.setBackground(new Color(0, 51, 51));
                                                                
                                                                        home_bnt_grp.add(HOME8);
                                                                        HOME8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                                                                        //jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/customer.png"))); // NOI18N
                                                                        HOME8.setText("Customers");
                                                                        
                                                                        JToggleButton tglbtnEstimate = new JToggleButton();
                                                                        tglbtnEstimate.addActionListener(new ActionListener() {
                                                                        	public void actionPerformed(ActionEvent e) {
                                                                        		Estimate estmt = new Estimate();
                                                                                jpload.jPanelLoader(panel_load, estmt);
                                                                        	}
                                                                        });
                                                                        tglbtnEstimate.setText("Estimate");
                                                                        tglbtnEstimate.setForeground(Color.WHITE);
                                                                        tglbtnEstimate.setFont(new Font("Tahoma", Font.BOLD, 14));
                                                                        tglbtnEstimate.setBackground(new Color(0, 51, 51));
                                                                        tglbtnEstimate.setBounds(10, 487, 130, 51);
                                                                        panel.add(tglbtnEstimate);
                                                                        HOME6 = new javax.swing.JToggleButton();
                                                                        HOME6.setBounds(10, 303, 130, 50);
                                                                        panel.add(HOME6);
                                                                        HOME6.setForeground(new Color(255, 255, 255));
                                                                        HOME6.setBackground(new Color(0, 51, 51));
                                                                        
                                                                                home_bnt_grp.add(HOME6);
                                                                                HOME6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                                                                                //jToggleButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/sales_menu.png"))); // NOI18N
                                                                                HOME6.setText("Day");
                                                                                HOME6.addActionListener(new java.awt.event.ActionListener() {
                                                                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                                                        jToggleButton5ActionPerformed(evt);
                                                                                    }
                                                                                });
                                                                        HOME8.addActionListener(new java.awt.event.ActionListener() {
                                                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                                                jToggleButton1ActionPerformed(evt);
                                                                            }
                                                                        });
                                                        HOME4.addActionListener(new java.awt.event.ActionListener() {
                                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                                jToggleButton4ActionPerformed(evt);
                                                            }
                                                        });
                                                HOME7.addActionListener(new java.awt.event.ActionListener() {
                                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                        jToggleButton6ActionPerformed(evt);
                                                    }
                                                });
                                        HOME3.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jToggleButton2ActionPerformed(evt);
                                            }
                                        });
                                HOME2.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        jToggleButton3ActionPerformed(evt);
                                    }
                                });
                HOME1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jToggleButton7ActionPerformed(evt);
                    }
                });
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // customer load
        
    	Customerrep add = new Customerrep();
       jpload.jPanelLoader(panel_load, add);
       
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
       
    	updateitem obj = new updateitem();
        jpload.jPanelLoader(panel_load, obj);
      
        
        
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        // emp load
        
    	Stock stck = new Stock();
        jpload.jPanelLoader(panel_load, stck);
        
        
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
    	 
    	Billinsec bill = new Billinsec();
        jpload.jPanelLoader(panel_load, bill);
        
        
        
        
        
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
    	Dailyreport kl = new Dailyreport();
        jpload.jPanelLoader(panel_load, kl); 
      
        
        
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
        //Invoice inv = new Invoice();
        //jpload.jPanelLoader(panel_load, inv);
    	 Monthly sl = new Monthly();
         jpload.jPanelLoader(panel_load, sl);
         
        
        
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton7ActionPerformed
         Billupdate billupd=new Billupdate();
    	 jpload.jPanelLoader(panel_load, billupd);
        
    }//GEN-LAST:event_jToggleButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup home_bnt_grp;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToggleButton HOME8;
    private javax.swing.JToggleButton HOME3;
    private javax.swing.JToggleButton HOME2;
    private javax.swing.JToggleButton HOME4;
    private javax.swing.JToggleButton HOME6;
    private javax.swing.JToggleButton HOME7;
    private javax.swing.JToggleButton HOME1;
    private javax.swing.JPanel panel_load;
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
