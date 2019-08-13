
package refrigerator;

import javax.swing.*;

public class GUIDisplay extends JFrame implements RefrigratorDisplay {

    private Refrigrator refrigrator;

    /**
     * Creates new form GUIDisplay
     */
    public GUIDisplay() {
        initComponents();
        this.setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        roomTemp = new JTextField();
        desiredFridgeTemp = new JTextField();
        desiredFreezerTemp = new JTextField();
        bRoomTemp = new JButton();
        bDesiredFridgeTemp = new JButton();
        bOpenFridge = new JButton();
        bCloseFridge = new JButton();
        bOpenFreezer = new JButton();
        bCloseFreezer = new JButton();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        fridgeLight = new JLabel();
        fridgeTemp = new JLabel();
        freezerTemp = new JLabel();
        freezerLight = new JLabel();
        fridge = new JLabel();
        freezer = new JLabel();
        bDesiredFreezerTemp = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Room temp");

        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("Desired fridge temp");

        jLabel3.setForeground(new java.awt.Color(255, 102, 0));
        jLabel3.setText("Desired Freezer temp");

        bRoomTemp.setText("Set room temp");
        bRoomTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRoomTempActionPerformed(evt);
            }
        });

        bDesiredFridgeTemp.setText("Set desired fridge temp");
        bDesiredFridgeTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDesiredFridgeTempActionPerformed(evt);
            }
        });

        bOpenFridge.setText("Open fridge door");
        bOpenFridge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOpenFridgeActionPerformed(evt);
            }
        });

        bCloseFridge.setText("Close fridge door");
        bCloseFridge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseFridgeActionPerformed(evt);
            }
        });

        bOpenFreezer.setText("Open freezer door");
        bOpenFreezer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOpenFreezerActionPerformed(evt);
            }
        });

        bCloseFreezer.setText("Close freezer door");
        bCloseFreezer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseFreezerActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 102, 0));
        jLabel4.setText("Status");

        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setText("Fridge light ");

        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
        jLabel6.setText("Fridge temp");

        jLabel7.setForeground(new java.awt.Color(102, 0, 102));
        jLabel7.setText("Fridge");

        jLabel8.setForeground(new java.awt.Color(102, 0, 102));
        jLabel8.setText("Freezer light ");

        jLabel9.setForeground(new java.awt.Color(102, 0, 102));
        jLabel9.setText("Freezer temp");

        jLabel10.setForeground(new java.awt.Color(102, 0, 102));
        jLabel10.setText("Freezer");

        fridgeLight.setForeground(new java.awt.Color(102, 0, 102));
        fridgeLight.setText("off");

        fridgeTemp.setForeground(new java.awt.Color(102, 0, 102));
        fridgeTemp.setText("00");

        freezerTemp.setForeground(new java.awt.Color(102, 0, 102));
        freezerTemp.setText("00");

        freezerLight.setForeground(new java.awt.Color(102, 0, 102));
        freezerLight.setText("off");

        fridge.setForeground(new java.awt.Color(102, 0, 102));
        fridge.setText("cooling");

        freezer.setForeground(new java.awt.Color(102, 0, 102));
        freezer.setText("cooling");

        bDesiredFreezerTemp.setText("Set desired freezer temp");
        bDesiredFreezerTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDesiredFreezerTempActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(roomTemp)
                                                        .addComponent(desiredFridgeTemp)
                                                        .addComponent(desiredFreezerTemp, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(bDesiredFridgeTemp)
                                                        .addComponent(bRoomTemp)
                                                        .addComponent(bDesiredFreezerTemp)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(bOpenFreezer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(bOpenFridge, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(8, 8, 8)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel4)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(10, 10, 10)
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabel5)
                                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(fridgeLight, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                                        .addComponent(jLabel7)
                                                                                                        .addGap(18, 18, 18)
                                                                                                        .addComponent(fridge, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                                        .addComponent(jLabel6)
                                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(fridgeTemp, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))))))
                                                .addGap(33, 33, 33)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel8)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(freezerLight, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(bCloseFreezer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(bCloseFridge, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel9)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(freezerTemp, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel10)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(freezer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addGap(109, 109, 109))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(roomTemp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bRoomTemp))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(desiredFridgeTemp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bDesiredFridgeTemp))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(desiredFreezerTemp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bDesiredFreezerTemp))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(bOpenFridge)
                                        .addComponent(bCloseFridge))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(bOpenFreezer)
                                        .addComponent(bCloseFreezer))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel8)
                                                .addComponent(freezerLight, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(fridgeLight, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel9)
                                        .addComponent(fridgeTemp, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(freezerTemp, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel10)
                                        .addComponent(fridge, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(freezer, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bOpenFridgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOpenFridgeActionPerformed
        // TODO add your handling code here:
        refrigrator.processDoorOpen();
    }//GEN-LAST:event_bOpenFridgeActionPerformed

    private void bCloseFridgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseFridgeActionPerformed
        // TODO add your handling code here:
        refrigrator.processDoorClose();
    }//GEN-LAST:event_bCloseFridgeActionPerformed

    private void bOpenFreezerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOpenFreezerActionPerformed
        // TODO add your handling code here:
        refrigrator.fprocessDoorOpen();

    }//GEN-LAST:event_bOpenFreezerActionPerformed

    private void bCloseFreezerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseFreezerActionPerformed
        // TODO add your handling code here:
        refrigrator.fprocessDoorClose();
    }//GEN-LAST:event_bCloseFreezerActionPerformed

    private void bRoomTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRoomTempActionPerformed
        // TODO add your handling code here:
        int val = Integer.parseInt(roomTemp.getText());
        if (val <=110 && val >=50) {
            refrigrator.setRoomTemp(val);
        }else {
            JOptionPane.showMessageDialog(new JFrame(),
                    "Please enter a correct room Temp range");
        }
    }//GEN-LAST:event_bRoomTempActionPerformed

    private void bDesiredFridgeTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDesiredFridgeTempActionPerformed
        // TODO add your handling code here:
        int val = Integer.parseInt(desiredFridgeTemp.getText());
        if (val <=41 && val >=37) {
            refrigrator.setDesiredFridgeTemp(val);
        }else {
            JOptionPane.showMessageDialog(new JFrame(),
                    "Please enter a correct Fridge Temp range");
        }

    }//GEN-LAST:event_bDesiredFridgeTempActionPerformed

    private void bDesiredFreezerTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDesiredFreezerTempActionPerformed
        // TODO add your handling code here:
        int val = Integer.parseInt(desiredFreezerTemp.getText());

        if (val <=0 && val >=-9) {
            refrigrator.setDesiredFreezerTemp(val);
        }else {
            JOptionPane.showMessageDialog(new JFrame(),
                    "Please enter a correct Freezer Temp range");
        }
    }//GEN-LAST:event_bDesiredFreezerTempActionPerformed

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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton bCloseFreezer;
    private JButton bCloseFridge;
    private JButton bDesiredFreezerTemp;
    private JButton bDesiredFridgeTemp;
    private JButton bOpenFreezer;
    private JButton bOpenFridge;
    private JButton bRoomTemp;
    private JTextField desiredFreezerTemp;
    private JTextField desiredFridgeTemp;
    private JLabel freezer;
    private JLabel freezerLight;
    private JLabel freezerTemp;
    private JLabel fridge;
    private JLabel fridgeLight;
    private JLabel fridgeTemp;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JTextField roomTemp;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setRefrigrator(Refrigrator refrigrator) {
        this.refrigrator = refrigrator;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fridgeturnLightOn() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        fridgeLight.setText("ON");
    }

    @Override
    public void fridgeturnLightOff() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        fridgeLight.setText("OFF");
    }


    @Override
    public void fridgestartCooling() {
        fridge.setText("cooling");
    }

    @Override
    public void fridgeidle() {
        fridge.setText("Idle");
    }


    @Override
    public void setFridgeTemp(int value) {
        fridgeTemp.setText("" + value);


    }

    @Override
    public void freezerturnLightOn() {
        freezerLight.setText("ON");
    }

    @Override
    public void freezerturnLightOff() {
        freezerLight.setText("OFF");
    }

    @Override
    public void freezerstartCooling() {
        freezer.setText("Cooling");
    }

    @Override
    public void freezeridle() {
        freezer.setText("Idle");

    }

    @Override
    public void setFreezerTemp(int value) {
        freezerTemp.setText("" + value);
    }
}