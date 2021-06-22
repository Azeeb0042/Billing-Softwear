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




public class Home extends javax.swing.JFrame {

    JpanelLoader jpload = new JpanelLoader();
    
    
    
    
    
    
    
    public Home() {
        initComponents();
        this.setExtendedState(Home.MAXIMIZED_BOTH);
        
        
        
        
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home_bnt_grp = new javax.swing.ButtonGroup();
        panel_load = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_load.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        
        JToggleButton jToggleButton7_1 = new JToggleButton();
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
        			.addContainerGap(296, Short.MAX_VALUE))
        );
        panel_loadLayout.setVerticalGroup(
        	panel_loadLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panel_loadLayout.createSequentialGroup()
        			.addGap(38)
        			.addGroup(panel_loadLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jToggleButton7_1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jToggleButton3_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jToggleButton2_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
        			.addGap(30)
        			.addGroup(panel_loadLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(panel_loadLayout.createSequentialGroup()
        					.addComponent(jToggleButton6_1, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
        					.addGap(29))
        				.addGroup(panel_loadLayout.createSequentialGroup()
        					.addComponent(jToggleButton1_1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addGroup(panel_loadLayout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jToggleButton4_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jToggleButton5_1, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
        			.addContainerGap(85, Short.MAX_VALUE))
        );
        panel_load.setLayout(panel_loadLayout);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 1366, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.TRAILING)
        		.addGap(0, 95, Short.MAX_VALUE)
        );
        jPanel3.setLayout(jPanel3Layout);
        
        JPanel panel = new JPanel();
        panel.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new LineBorder(new Color(0, 0, 0))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jPanel3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1346, Short.MAX_VALUE)
        				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(panel_load, GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        				.addComponent(panel_load, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE))
        			.addContainerGap())
        );
        panel.setLayout(null);
        jToggleButton7 = new javax.swing.JToggleButton();
        jToggleButton7.setBounds(10, 11, 130, 50);
        panel.add(jToggleButton7);
        
                home_bnt_grp.add(jToggleButton7);
                jToggleButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                //jToggleButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/reports.png"))); // NOI18N
                jToggleButton7.setText("Reports");
                jToggleButton1 = new javax.swing.JToggleButton();
                jToggleButton1.setBounds(10, 67, 130, 51);
                panel.add(jToggleButton1);
                
                        home_bnt_grp.add(jToggleButton1);
                        jToggleButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                        //jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/customer.png"))); // NOI18N
                        jToggleButton1.setText("Add Item");
                        jToggleButton3 = new javax.swing.JToggleButton();
                        jToggleButton3.setBounds(10, 124, 130, 49);
                        panel.add(jToggleButton3);
                        
                                home_bnt_grp.add(jToggleButton3);
                                jToggleButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                                //jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/product.png"))); // NOI18N
                                jToggleButton3.setText("Billing");
                                jToggleButton2 = new javax.swing.JToggleButton();
                                jToggleButton2.setBounds(10, 179, 130, 51);
                                panel.add(jToggleButton2);
                                
                                        home_bnt_grp.add(jToggleButton2);
                                        jToggleButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                                        //jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/supplier.png"))); // NOI18N
                                        jToggleButton2.setText("Update Item");
                                        jToggleButton6 = new javax.swing.JToggleButton();
                                        jToggleButton6.setBounds(10, 236, 130, 50);
                                        panel.add(jToggleButton6);
                                        
                                                home_bnt_grp.add(jToggleButton6);
                                                jToggleButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                                                //jToggleButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/invo.png"))); // NOI18N
                                                jToggleButton6.setText("Invoice");
                                                jToggleButton4 = new javax.swing.JToggleButton();
                                                jToggleButton4.setBounds(10, 292, 130, 42);
                                                panel.add(jToggleButton4);
                                                
                                                        home_bnt_grp.add(jToggleButton4);
                                                        jToggleButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                                                        //jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/emp.png"))); // NOI18N
                                                        jToggleButton4.setText("Stock");
                                                        jToggleButton5 = new javax.swing.JToggleButton();
                                                        jToggleButton5.setBounds(10, 340, 130, 50);
                                                        panel.add(jToggleButton5);
                                                        
                                                                home_bnt_grp.add(jToggleButton5);
                                                                jToggleButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                                                                //jToggleButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/sales_menu.png"))); // NOI18N
                                                                jToggleButton5.setText("Edit Bill");
                                                                jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
                                                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                                        jToggleButton5ActionPerformed(evt);
                                                                    }
                                                                });
                                                        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
                                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                                jToggleButton4ActionPerformed(evt);
                                                            }
                                                        });
                                                jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
                                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                        jToggleButton6ActionPerformed(evt);
                                                    }
                                                });
                                        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jToggleButton2ActionPerformed(evt);
                                            }
                                        });
                                jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        jToggleButton3ActionPerformed(evt);
                                    }
                                });
                        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jToggleButton1ActionPerformed(evt);
                            }
                        });
                jToggleButton7.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jToggleButton7ActionPerformed(evt);
                    }
                });
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // customer load
        
    	additem add = new additem();
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
    	Editbill kl = new Editbill();
        jpload.jPanelLoader(panel_load, kl); 
      
        
        
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
        //Invoice inv = new Invoice();
        //jpload.jPanelLoader(panel_load, inv);
    	 sales sl = new sales();
         jpload.jPanelLoader(panel_load, sl);
         
        
        
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton7ActionPerformed
       
    	
        
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
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JPanel panel_load;
}
