import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class patronlogin extends JPanel {
    GridBagConstraints gbclabel1 = new GridBagConstraints();
    GridBagConstraints gbcfield1 = new GridBagConstraints();
    GridBagConstraints gbclabel2 = new GridBagConstraints();
    GridBagConstraints gbcfield2 = new GridBagConstraints();
    GridBagConstraints gbclogin = new GridBagConstraints();

    JLabel label1, label2;
    JTextField field1, field2;
    JButton loginButton;
    //private Connection conn;

    public patronlogin() {
        //private Statement stmt;

        setBounds(0, 0, 600, 400);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridBagLayout());

        label1 = new JLabel("Enter your username");
        label1.setBounds(150, 100, 400, 30);
        label1.setFont(new Font("Arial", Font.ITALIC, 16));
        gbclabel1.gridx = 0;
        gbclabel1.gridy = 0;
        gbclabel1.insets = new Insets(5, 5, 5, 5);
        add(label1, gbclabel1);


        field1 = new JTextField(20);
        field1.setBounds(150, 130, 400, 30);
        gbcfield1.gridx = 1;
        gbcfield1.gridy = 0;
        gbcfield1.insets = new Insets(5, 5, 5, 5);
        add(field1, gbcfield1);
        field1.setBounds(150, 130, 400, 30);

        label2 = new JLabel("Enter your password");
        label2.setBounds(150, 170, 400, 30);
        label2.setFont(new Font("Arial", Font.ITALIC, 16));
        gbclabel2.gridx = 0;
        gbclabel2.gridy = 1;
        gbclabel2.insets = new Insets(5, 5, 5, 5);
        add(label2, gbclabel2);


        field2 = new JPasswordField(20);
        field2.setBounds(150, 200, 400, 30);
        gbcfield2.gridx = 1;
        gbcfield2.gridy = 1;
        gbcfield2.insets = new Insets(5, 5, 5, 5);
        add(field2, gbcfield2);

        loginButton = new JButton("Login");
        loginButton.setBounds(250, 240, 100, 30);
        gbclogin.gridx = 1;
        gbclogin.gridy = 2;
        gbclogin.insets = new Insets(5, 5, 5, 5);
        add(loginButton, gbclogin);


        // Add ActionListener for the login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = field1.getText();
                String password = field2.getText();
                try {
                    // Establish a database connection
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "Aqqa1234%");
                    String query = "SELECT * FROM user_registration WHERE Roles='Patron' && username = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, username);

                    // Execute the query
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {

                        String storedPassword = resultSet.getString("ppassword");


                        if (password.equals(storedPassword)) {


                            Main switch2 = new Main();
                            switch2.Switchpanel(new patronpage());

                        } else {
                            JOptionPane.showMessageDialog(null, "Wrong password !!");
                            System.out.println("Intrusion detected!!");

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Username does not exist !!");
                        System.out.println("Intrusion detected!!");

                    }

                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


            }
        });
    }
}




