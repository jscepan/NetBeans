package com.mycompany.assignmenttimerapp.controller;

import com.mycompany.assignmenttimerapp.view.SettingsForm;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Controller {

    static JFrame jFrame;
    static Timer timer;
    static Integer switchColor;

    public static void startApp() {
        showInputDialog();
    }

    public static void showInputDialog() {
        int decision = JOptionPane.showOptionDialog(null, "Choose option", "Option dialog", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Settings", "Close"}, null);
        if (decision == JOptionPane.YES_OPTION) {
            showSettingsDialog();
        } else {
            System.exit(0);
        }
    }

    public static void showSettingsDialog() {
        SettingsForm settingsForm = new SettingsForm();
        settingsForm.setVisible(true);
    }

    public static void showFinalWindow(Color color, int jComboBoxSpeed) {
        Color color1 = Color.WHITE;

        jFrame = new JFrame();
        jFrame.getContentPane().setBackground(color1);
        jFrame.setSize(100, 100);
        switchColor = 1;

        timer = new Timer(jComboBoxSpeed * 1000, (ActionEvent arg0) -> {
            if (switchColor == 1) {
                jFrame.getContentPane().setBackground(color);
                SwingUtilities.updateComponentTreeUI(jFrame);
                switchColor = 2;
            } else if (switchColor == 2) {
                jFrame.getContentPane().setBackground(color1);
                SwingUtilities.updateComponentTreeUI(jFrame);
                switchColor = 1;
            }
        });
        timer.start();
        jFrame.setVisible(true);
    }

    public static void closeFinalWindow() {
        jFrame.dispose();
        if (timer.isRunning()) {
            timer.stop();
        }
    }
}
