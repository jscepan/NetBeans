package com.mycompany.assignmenttimerapp.view;

import com.mycompany.assignmenttimerapp.controller.Controller;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.time.LocalTime;
import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;
import javax.swing.Timer;

public class SettingsForm extends javax.swing.JFrame {

    static Color color2;
    static Integer secondsTillShowing;
    static Timer timer;
    static Integer speedOfColorChanging;

    public SettingsForm() {
        initComponents();
        ButtonGroup myChoices = new ButtonGroup();
        myChoices.add(jRadioButtonCountdown);
        myChoices.add(jRadioButtonOnTime);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonOnTime = new javax.swing.JRadioButton();
        jRadioButtonCountdown = new javax.swing.JRadioButton();
        jButtonChooseColor = new javax.swing.JButton();
        jLabelSelectedColor = new javax.swing.JLabel();
        jComboBoxSpeed = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButtonStart = new javax.swing.JButton();
        jButtonStop = new javax.swing.JButton();
        jSpinnerSeconds = new javax.swing.JSpinner();
        jFormattedTextFieldOnTime = new javax.swing.JFormattedTextField();
        jLabelCounter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jRadioButtonOnTime.setText("on time:");
        jRadioButtonOnTime.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonOnTimeItemStateChanged(evt);
            }
        });
        jRadioButtonOnTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOnTimeActionPerformed(evt);
            }
        });

        jRadioButtonCountdown.setText("countdown (mins)");
        jRadioButtonCountdown.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonCountdownItemStateChanged(evt);
            }
        });

        jButtonChooseColor.setText("Choose color");
        jButtonChooseColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChooseColorActionPerformed(evt);
            }
        });

        jLabelSelectedColor.setText("No color selected");
        jLabelSelectedColor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jComboBoxSpeed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel1.setText("Speed:");

        jButtonStart.setText("Start");
        jButtonStart.setEnabled(false);
        jButtonStart.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jButtonStartItemStateChanged(evt);
            }
        });
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jButtonStop.setText("Stop");
        jButtonStop.setEnabled(false);
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });

        jSpinnerSeconds.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinnerSeconds.setEnabled(false);

        jFormattedTextFieldOnTime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm:ss"))));
        jFormattedTextFieldOnTime.setText("16:00:00");
        jFormattedTextFieldOnTime.setToolTipText("");
        jFormattedTextFieldOnTime.setEnabled(false);

        jLabelCounter.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelCounter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCounter.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonChooseColor)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelSelectedColor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
                            .addComponent(jLabelCounter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonOnTime, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButtonCountdown)
                            .addComponent(jButtonStart))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jButtonStop))
                            .addComponent(jSpinnerSeconds)
                            .addComponent(jFormattedTextFieldOnTime))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonOnTime)
                    .addComponent(jFormattedTextFieldOnTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCountdown)
                    .addComponent(jSpinnerSeconds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonChooseColor)
                    .addComponent(jLabelSelectedColor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabelCounter, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonStart)
                    .addComponent(jButtonStop))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonOnTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOnTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonOnTimeActionPerformed

    private void jRadioButtonOnTimeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonOnTimeItemStateChanged
        if (evt.getStateChange() == 1) {
            jFormattedTextFieldOnTime.setEnabled(true);
            jButtonStart.setEnabled(true);
        } else {
            jFormattedTextFieldOnTime.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButtonOnTimeItemStateChanged

    private void jRadioButtonCountdownItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonCountdownItemStateChanged
        if (evt.getStateChange() == 1) {
            jSpinnerSeconds.setEnabled(true);
            jButtonStart.setEnabled(true);
        } else {
            jSpinnerSeconds.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButtonCountdownItemStateChanged

    private void jButtonChooseColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooseColorActionPerformed
//        JColorChooser jcc = new JColorChooser();
        color2 = JColorChooser.showDialog(null, "Choose color", Color.white);
        jLabelSelectedColor.setOpaque(true);
        jLabelSelectedColor.setText("");
        jLabelSelectedColor.setBackground(color2);
    }//GEN-LAST:event_jButtonChooseColorActionPerformed

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        //deaktiviraj sve druge kontrole osim stop
        secondsTillShowing = 0;
        speedOfColorChanging = Integer.parseInt(jComboBoxSpeed.getSelectedItem().toString());
        if (jRadioButtonOnTime.isSelected()) {
            String inputTime = jFormattedTextFieldOnTime.getText();
            int inputTimeInSeconds = (Integer.parseInt(inputTime.split(":")[0])) * 3600 + (Integer.parseInt(inputTime.split(":")[1])) * 60 + (Integer.parseInt(inputTime.split(":")[2]));
            int currentTimeInSeconds = LocalTime.now().getHour() * 3600 + LocalTime.now().getMinute() * 60 + LocalTime.now().getSecond();
            secondsTillShowing = inputTimeInSeconds - currentTimeInSeconds;
        } else {
            secondsTillShowing = Integer.parseInt(jSpinnerSeconds.getValue().toString());
        }

        //pokreni odbrojavanje
        jLabelCounter.setEnabled(true);
        jLabelCounter.setText((secondsTillShowing).toString());
        SettingsForm.timer = new Timer(1000, (ActionEvent arg0) -> {
            jLabelCounter.setText((--secondsTillShowing).toString());
            if (secondsTillShowing <= 0) {
                Component[] components = getContentPane().getComponents();
                for (Component c : components) {
                    c.setEnabled(false);
                }
                jButtonStop.setEnabled(true);
                timer.stop();
                if (color2 == null) {
                    color2 = Color.RED;
                }
                Controller.showFinalWindow(color2, speedOfColorChanging);
            }
        });
        SettingsForm.timer.start();


    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        Component[] components = getContentPane().getComponents();
        for (Component c : components) {
            c.setEnabled(true);
        }
        jButtonStop.setEnabled(false);
        Controller.closeFinalWindow();
    }//GEN-LAST:event_jButtonStopActionPerformed

    private void jButtonStartItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jButtonStartItemStateChanged

    }//GEN-LAST:event_jButtonStartItemStateChanged

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
            java.util.logging.Logger.getLogger(SettingsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SettingsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SettingsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SettingsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SettingsForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonChooseColor;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JComboBox<String> jComboBoxSpeed;
    private javax.swing.JFormattedTextField jFormattedTextFieldOnTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCounter;
    private javax.swing.JLabel jLabelSelectedColor;
    private javax.swing.JRadioButton jRadioButtonCountdown;
    private javax.swing.JRadioButton jRadioButtonOnTime;
    private javax.swing.JSpinner jSpinnerSeconds;
    // End of variables declaration//GEN-END:variables
}
