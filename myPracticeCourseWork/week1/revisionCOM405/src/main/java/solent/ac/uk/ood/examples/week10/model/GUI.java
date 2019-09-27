/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent.ac.uk.ood.examples.week10.model;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Emma
 */
public class GUI extends JFrame{
    private JLabel LABEL_name;
    private JLabel LABEL_output;
    
    private JTextField TEXT_name;
    
    private JButton BUTTON_ok;
    
    private GridBagConstraints constraints; 
    public GUI() {
     initComponents();
     layoutComponents();
     addListeners();
     pack();
     setVisible(true);
        
    }
    private void initComponents() {
        constraints = new GridBagConstraints(); 
        setLayout(new GridBagLayout());
        
        LABEL_name = new JLabel("Name");
        LABEL_output = new JLabel("Hello"); 
        
        TEXT_name = new JTextField();
        
        BUTTON_ok = new JButton("ok!");
    }

    private void layoutComponents() {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx=1; 
        add(LABEL_name, constraints);
        constraints.gridy++;
        add(TEXT_name, constraints);
        constraints.gridx++;
        constraints.gridy--; 
        constraints.gridwidth=2;
        add(BUTTON_ok, constraints);
        constraints.gridx++; 
        add(LABEL_output, constraints);
        
    }

    private void addListeners() {
        BUTTON_ok.addActionListener(e -> {
            LABEL_output.setText("Hellow " + TEXT_name.getText());
        });
    }
}
