//package org.example;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lostitems extends JPanel{
    private JPanel reportPanel;
    private JTextField eqptLossField, memberIdField;
    private JLabel eqptLossLabel, memberIdLabel, damageFeeField;
    private JButton reportButton, calculateButton;
     private Connection connection;
    private Statement stmt;
    public lostitems(){
        reportPanel = new JPanel();
        reportPanel.setBackground(Color.GRAY);
        setSize(500,300);


        setBackground(Color.GRAY);

        //equipment panel components initialization
        reportPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        reportPanel.setBackground(Color.WHITE);
        eqptLossField = new JTextField(10);
        memberIdField = new JTextField(10);
        eqptLossLabel = new JLabel("Enter the item name");
        memberIdLabel = new JLabel("Enter Member username");

        damageFeeField = new JLabel("Ksh. -------");

        calculateButton = new JButton("Generate Fee");
        calculateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String selectEquipmentQuery = "SELECT price FROM items WHERE Item_name = ?";
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itemlist&price", "root", "Aqqa1234%");
                    stmt= connection.createStatement();
                    String equipmentId =eqptLossField.getText();
                    // Getting the market value of the damaged equipment
                    PreparedStatement selectEquipmentStatement = connection.prepareStatement(selectEquipmentQuery);
                    selectEquipmentStatement.setString(1, equipmentId);
                    ResultSet equipmentResultSet = selectEquipmentStatement.executeQuery();

                    if (equipmentResultSet.next()) {
                        int equipmentValue = equipmentResultSet.getInt("price");
                        int damageFee = (int) (equipmentValue * 1.1);
                        damageFeeField.setText("Ksh. " + damageFee);
                    } else {
                        damageFeeField.setText("Equipment not found");
                    }

                    equipmentResultSet.close();
                    selectEquipmentStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    damageFeeField.setText("Error occurred");
                }
            }
        });


        reportButton = new JButton("Report");
        //setting the color of the report button to light red using rgb code scheme
        reportButton.setBackground(new Color(255, 127, 127));
        reportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to report the member?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    String selectEquipmentQuery = "SELECT price FROM items WHERE Item_name = ?";
                    String updateDamagedEquipmentQuery = "INSERT INTO  lostdamaged (equipment_name, member_username) VALUES (?, ?)";

                    try {
                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itemlist&price", "root", "Aqqa1234%");
                        stmt= connection.createStatement();
                        String equipmentId =  eqptLossField.getText();
                        String memberId =  memberIdField.getText();

                        // Getting the market value of the damaged equipment
                        PreparedStatement selectEquipmentStatement = connection.prepareStatement(selectEquipmentQuery);
                        selectEquipmentStatement.setString(1, equipmentId);
                        ResultSet equipmentResultSet = selectEquipmentStatement.executeQuery();

                        if (equipmentResultSet.next()) {
                            int equipmentValue = equipmentResultSet.getInt("price");
                            int damageFee = (int) (equipmentValue * 1.1);

                            // Inserting the damaged equipment into the damaged_equipment table
                            PreparedStatement updateDamagedEquipmentStatement = connection.prepareStatement(updateDamagedEquipmentQuery);
                            updateDamagedEquipmentStatement.setString(1, equipmentId);
                            updateDamagedEquipmentStatement.setString(2, memberId);

                            int rowsAffected = updateDamagedEquipmentStatement.executeUpdate();
                            if (rowsAffected > 0) {
                                String receiptMessage = "Damage Fee: Ksh. " + damageFee + "\nEquipment ID: " + equipmentId + "\nMember ID: " + memberId;
                                JOptionPane.showMessageDialog(null, receiptMessage, "Damage Report", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed to update damaged equipment.", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                            updateDamagedEquipmentStatement.close();
                        } else {
                            JOptionPane.showMessageDialog(null, "Equipment not found", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                        equipmentResultSet.close();
                        selectEquipmentStatement.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });


        reportPanel.add(eqptLossLabel); reportPanel.add(eqptLossField); reportPanel.add(memberIdLabel);
        reportPanel.add(memberIdField); reportPanel.add(calculateButton);
        reportPanel.add(damageFeeField); reportPanel.add(reportButton);
        add(reportPanel);
        setVisible(true);


    }
}