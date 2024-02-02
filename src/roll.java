
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class roll extends JPanel {
    private JTable itemsTable;
    private DefaultTableModel tableModel;

    private Connection conn;
    private Statement stmt;

    public roll() {
        setBackground(Color.GRAY);

        setSize(600, 400);

        String[] columns = {"Name", "Contact", "Username","Roles" };
        tableModel = new DefaultTableModel(columns, 0);
        itemsTable = new JTable(tableModel);
        itemsTable.setBackground(Color.lightGray);
        JScrollPane scrollPane = new JScrollPane(itemsTable);
        scrollPane.setBackground(Color.lightGray);
        add(scrollPane);
        populateTable();
    }

    public void populateTable() {
        userlogin field=new userlogin();
        String username = field.getEnteredText();
System.out.print("Is"+username);

        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "Aqqa1234%");
            stmt=conn.createStatement();
            String selectQuery = "SELECT Nname, contact, username, Roles FROM user_registration WHERE username=?";
            PreparedStatement selectStatement = conn.prepareStatement(selectQuery);
            selectStatement.setString(1, username);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Object[] rowData = {

                        resultSet.getString("Nname"),
                        resultSet.getDouble("Contact"),
                        resultSet.getString("username"),
                        resultSet.getString("Roles"),

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
