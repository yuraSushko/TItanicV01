package org.example;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener  implements KeyListener {
    private JTextField jTextField;
    private JLabel dialogMassage;

    public MyKeyListener(JTextField jTextField) {
        this.jTextField = jTextField;
        this.dialogMassage = new JLabel();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if( !jTextField.getText().matches("\\d+")){
            if(!jTextField.getText().equals("")) {
                JOptionPane.showMessageDialog(dialogMassage, "only Digits!!");
                jTextField.setText("");
            }
        }
    }
}


