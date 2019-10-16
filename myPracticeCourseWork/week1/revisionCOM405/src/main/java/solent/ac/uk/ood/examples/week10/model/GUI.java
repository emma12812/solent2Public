/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent.ac.uk.ood.examples.week10.model;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Emma
 */
public class GUI extends JFrame {

    private Bridge Itchen;
    private JLabel LABEL_BridgeSystem;
    private JLabel LABEL_CurrentLoad;
    private JLabel LABEL_TotalWeight;
    private JLabel LABEL_Reg;
    private JLabel LABEL_Weight;
    private JLabel LABEL_Entry;
    private JLabel LABEL_Fee;
    private JLabel LABEL_Type;

    private JTextField TEXT_Reg;
    private JTextField TEXT_Weight;

    private JComboBox BOX_Vehicle;

    private JButton BUTTON_Add;
    private JButton BUTTON_Remove;

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

        LABEL_BridgeSystem = new JLabel("Bridge System");
        LABEL_CurrentLoad = new JLabel("Current Load");
        LABEL_TotalWeight = new JLabel("");
        LABEL_Weight = new JLabel("Weight");
        LABEL_Reg = new JLabel("Registration");
        LABEL_Entry = new JLabel();
        LABEL_Fee = new JLabel();
        LABEL_Type = new JLabel("Type");

        TEXT_Reg = new JTextField();
        TEXT_Weight = new JTextField();

        String[] vehicleType = {"Car", "Bike", "Lorry"};
        BOX_Vehicle = new JComboBox(vehicleType);
        BUTTON_Add = new JButton("Add");
        BUTTON_Remove = new JButton("Remove");

        Itchen = new Bridge();

    }

    private void layoutComponents() {
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.gridwidth = 2;
        add(LABEL_BridgeSystem, constraints);
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        add(LABEL_CurrentLoad, constraints);
        constraints.gridx++;
        add(LABEL_TotalWeight, constraints);
        constraints.gridx--;
        constraints.gridy++;
        add(LABEL_Reg, constraints);
        constraints.gridy++;
        add(LABEL_Weight, constraints);
        constraints.gridy++;
        add(LABEL_Type, constraints);
        constraints.gridx++;
        add(BOX_Vehicle, constraints);
        constraints.gridy++;
        add(BUTTON_Add, constraints);
        constraints.gridx++;
        add(BUTTON_Remove, constraints);
        constraints.gridwidth++;
        constraints.gridx--;
        constraints.gridy++;
        add(LABEL_Entry, constraints);
        constraints.gridy++;
        add(LABEL_Fee, constraints);
        constraints.gridwidth = 0;
        constraints.gridy -= 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(TEXT_Weight, constraints);
        constraints.gridy--;
        add(TEXT_Reg, constraints);
    }

    private void addListeners() {
        BUTTON_Add.addActionListener(e -> {
            Vehicle newVehicle; 
            if(BOX_Vehicle.getSelectedItem().equals("Car")){
                newVehicle = new Car();
            }
            else if(BOX_Vehicle.getSelectedItem().equals("Bike")){
                newVehicle = new Motorbike();
            }
            else {
                newVehicle = new Lorry(); 
            }
            
                newVehicle.setRegistration(TEXT_Reg.getText());
                newVehicle.setWeight(Double.parseDouble(TEXT_Weight.getText()));
            boolean success = Itchen.requestAddVechicle(newVehicle); 
            if (success){
                LABEL_Entry.setText("Entry Granted!");
                LABEL_Fee.setText("Fee: " + newVehicle.calculateFee());
                LABEL_TotalWeight.setText(Itchen.calcTotalWeight() + "kg");
            }
        });
        BUTTON_Remove.addActionListener(e -> {
           boolean Remove = Itchen.requestRemoveVehicle(TEXT_Reg.getText());
           if(Remove){
                LABEL_Entry.setText("Vehicle Removed");
                LABEL_Fee.setText("");
                LABEL_TotalWeight.setText(Itchen.calcTotalWeight() + "kg");
           } 
           else{
               LABEL_Entry.setText("Vehicle not on bridge currently. Cannot remove.");
           }
        });
    }
}

