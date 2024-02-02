import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class patron extends JPanel {



    GridBagConstraints gbcnamelabel = new GridBagConstraints();

    GridBagConstraints gbcnamefield = new GridBagConstraints();
    GridBagConstraints gbcsubmit = new GridBagConstraints();
    GridBagConstraints gbcremove = new GridBagConstraints();
    GridBagConstraints gbcpricefield = new GridBagConstraints();

    private Connection conn;
    private Statement stmt;
    public patron() {
        super();
        setLayout(new GridBagLayout());

        //gbc.insets = new Insets(10, 10, 10, 10);
        setSize(400, 500);
        setBackground(Color.GRAY);

        JLabel cap = new JLabel("Manage patrons ");
        cap.setFont(new Font("Arial", Font.ITALIC, 30));
        gbcnamelabel.gridx = 0;
        gbcnamelabel.gridy = 0;
        gbcnamelabel.insets = new Insets(5, 5, 5, 5);
        add(cap,gbcnamelabel);

        JLabel nameLabel = new JLabel("Member username: ");
        nameLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        JTextField nameField = new JTextField(20);


        JButton add = new JButton("Add");
        JButton remove = new JButton("Remove");
        remove.setBackground(Color.red);
        remove.setForeground(Color.white);

        gbcnamelabel.gridx = 0;
        gbcnamelabel.gridy = 1;
        gbcnamelabel.insets = new Insets(5, 5, 5, 5);
        add(nameLabel,gbcnamelabel);

        gbcnamefield.gridx = 1;
        gbcnamefield.gridy = 1;
        gbcnamefield.insets = new Insets(5, 5, 5, 5);
        add(nameField,gbcnamefield);



        gbcsubmit.gridx = 0;
        gbcsubmit.gridy = 2;
        gbcsubmit.insets = new Insets(5, 5, 5, 5);
        add(add,gbcsubmit);

        gbcremove.gridx = 1;
        gbcremove.gridy = 2;
        gbcremove.insets = new Insets(5, 5, 5, 5);
        add(remove,gbcremove);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nname = nameField.getText();

                try{
                    conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "Aqqa1234%");
                    stmt=conn.createStatement();
                    String sql="UPDATE  user_registration SET Roles= 'Patron' WHERE username='"+Nname+"'";
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Patron added successfully... " );
                }catch(SQLException e3){
                    e3.printStackTrace();
                }
            }
        });
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nname = nameField.getText();

                try{
                    conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "Aqqa1234%");
                    stmt=conn.createStatement();
                    String sql="UPDATE  user_registration SET Roles= 'Member' WHERE username='"+Nname+"'";
                    stmt.executeUpdate(sql);

                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Patron removed successfully... " );
                }catch(SQLException e3){
                    e3.printStackTrace();
                }
            }
        });





    }
}