import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class captain extends JPanel {



    GridBagConstraints gbcnamelabel = new GridBagConstraints();

    GridBagConstraints gbcnamefield = new GridBagConstraints();
    GridBagConstraints gbcsubmit = new GridBagConstraints();
    GridBagConstraints gbcremove = new GridBagConstraints();
    GridBagConstraints gbccaps = new GridBagConstraints();

    private Connection conn;
    private Statement stmt;
    public captain() {
        super();
        setLayout(new GridBagLayout());

        //gbc.insets = new Insets(10, 10, 10, 10);
        setSize(400, 500);
        setBackground(Color.LIGHT_GRAY);

        JLabel cap = new JLabel("Manage captains ");
        cap.setFont(new Font("Arial", Font.ITALIC, 30));
        gbcnamelabel.gridx = 0;
        gbcnamelabel.gridy = 0;
        gbcnamelabel.insets = new Insets(5, 5, 5, 5);
        add(cap,gbcnamelabel);

        JLabel nameLabel = new JLabel("Player username: ");
        nameLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        JTextField nameField = new JTextField(20);

        JButton caps = new JButton("View captains");
        caps.setFont(new Font("Arial", Font.ITALIC, 20));
        caps.setBackground(Color.lightGray);
        caps.setForeground(Color.white);
        gbccaps.gridx = 0;
        gbccaps.gridy = 3;
        gbccaps.insets = new Insets(5, 5, 5, 5);
        add(caps,gbccaps);

        JButton add = new JButton("Add");
        JButton remove = new JButton("Remove");
        remove.setBackground(Color.red);
        remove.setForeground(Color.white);

        gbcnamelabel.gridx = 0;
        gbcnamelabel.gridy = 2;
        gbcnamelabel.insets = new Insets(5, 5, 5, 5);
        add(nameLabel,gbcnamelabel);

        gbcnamefield.gridx = 1;
        gbcnamefield.gridy = 2;
        gbcnamefield.insets = new Insets(5, 5, 5, 5);
        add(nameField,gbcnamefield);

        gbcsubmit.gridx = 1;
        gbcsubmit.gridy = 3;
        gbcsubmit.insets = new Insets(5, 5, 5, 5);
        add(add,gbcsubmit);

        gbcremove.gridx = 2;
        gbcremove.gridy = 3;
        gbcremove.insets = new Insets(5, 5, 5, 5);
        add(remove,gbcremove);

        caps.addActionListener(EVT -> {
            Main switchh= (Main) SwingUtilities.getWindowAncestor(this);
            switchh.Switchpanel(new capss());

        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nname = nameField.getText();

                try{
                    conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "Aqqa1234%");
                    stmt=conn.createStatement();
                    String sql="UPDATE  user_registration SET Roles= 'Captain' WHERE username='"+Nname+"'";
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Captain added successfully... " );
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

                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Captain removed successfully... " );
                }catch(SQLException e3){
                    e3.printStackTrace();
                }
            }
        });





    }
}