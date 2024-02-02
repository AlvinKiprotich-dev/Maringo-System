
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Items_in_the_store extends JPanel {
    private JTable itemsTable;
    private DefaultTableModel tableModel;

    private Connection conn;
    private Statement stmt;

    public Items_in_the_store() {

        setBackground(Color.GRAY);

        setSize(600, 400);

        String[] columns = {"Item Name", "Item Price", "Stock Level" };
        tableModel = new DefaultTableModel(columns, 0);
        itemsTable = new JTable(tableModel);
        itemsTable.setBackground(Color.lightGray);
        JScrollPane scrollPane = new JScrollPane(itemsTable);
        scrollPane.setBackground(Color.lightGray);
        add(scrollPane);
        populateTable();
    }

    private void populateTable() {
        String selectQuery = "SELECT Item_name, Price, Product_level FROM items";

        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/itemlist&price", "root", "Aqqa1234%");
            stmt=conn.createStatement();
            PreparedStatement selectStatement = conn.prepareStatement(selectQuery);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Object[] rowData = {

                        resultSet.getString("Item_name"),
                        resultSet.getDouble("Price"),
                        resultSet.getInt("Product_level"),

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
