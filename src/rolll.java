
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class rolll extends JPanel {
    private JTable itemsTable;
    private DefaultTableModel tableModel;
    GridBagConstraints gbclabel2 = new GridBagConstraints();
    GridBagConstraints gbclogin = new GridBagConstraints();
    GridBagConstraints gbcfield1 = new GridBagConstraints();

    private Connection conn;
    private Statement stmt;

    public rolll() {
        setBackground(Color.GRAY);
        setLayout(new GridBagLayout());

        setSize(600, 400);

        JLabel label2 = new JLabel("Enter your password");
        label2.setBounds(150, 170, 400, 30);
        label2.setFont(new Font("Arial", Font.ITALIC, 16));
        gbclabel2.gridx = 0;
        gbclabel2.gridy = 0;
        gbclabel2.insets = new Insets(5, 5, 5, 5);
        add(label2, gbclabel2);

        JTextField field1 = new JTextField(20);
        field1.setBounds(150, 130, 400, 30);
        gbcfield1.gridx = 1;
        gbcfield1.gridy = 0;
        gbcfield1.insets = new Insets(5, 5, 5, 5);
        add(field1, gbcfield1);

        JButton loginButton = new JButton("OK");
        loginButton.setBounds(250, 240, 100, 30);
        gbclogin.gridx = 0;
        gbclogin.gridy = 2;
        gbclogin.insets = new Insets(5, 5, 5, 5);
        add(loginButton, gbclogin);

        String[] columns = {"Name", "Contact", "Username","Roles" };
        tableModel = new DefaultTableModel(columns, 0);
        itemsTable = new JTable(tableModel);
        itemsTable.setBackground(Color.lightGray);
        JScrollPane scrollPane = new JScrollPane(itemsTable);
        scrollPane.setBackground(Color.lightGray);
        add(scrollPane);


       loginButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String password = field1.getText();


        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "Aqqa1234%");
            stmt=conn.createStatement();
            String selectQuery = "SELECT Nname, contact, username, Roles FROM user_registration WHERE ppassword=?";
            PreparedStatement selectStatement = conn.prepareStatement(selectQuery);
            selectStatement.setString(1, password);
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
           }
       });


        setVisible(true);
    }

}
