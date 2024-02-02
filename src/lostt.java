
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class lostt extends JPanel {
    private JTable itemsTable;
    private DefaultTableModel tableModel;

    private Connection conn;
    private Statement stmt;

    public lostt() {
        setBackground(Color.GRAY);

        setSize(600, 400);

        String[] columns = {"Loss_id", "Equipment name", "Lost/damaged by:" };
        tableModel = new DefaultTableModel(columns, 0);
        itemsTable = new JTable(tableModel);
        itemsTable.setBackground(Color.lightGray);
        JScrollPane scrollPane = new JScrollPane(itemsTable);
        scrollPane.setBackground(Color.lightGray);
        add(scrollPane);
        populateTable();
    }

    private void populateTable() {
        String selectQuery = "SELECT loss_id, equipment_name, member_username FROM lostdamaged";

        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/itemlist&price", "root", "Aqqa1234%");
            stmt=conn.createStatement();
            PreparedStatement selectStatement = conn.prepareStatement(selectQuery);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Object[] rowData = {

                        resultSet.getInt("Loss_id"),
                        resultSet.getString("equipment_name"),
                        resultSet.getString("member_username"),

                };

                tableModel.addRow(rowData);
            }

            resultSet.close();
            selectStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


        setVisible(true);
    }
}
