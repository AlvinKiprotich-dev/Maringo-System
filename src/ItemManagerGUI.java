import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class ItemManagerGUI extends JPanel {


    //GridBagConstraints gbcpanel = new GridBagConstraints();
    GridBagConstraints gbcnamelabel = new GridBagConstraints();

    GridBagConstraints gbcnamefield = new GridBagConstraints();
    GridBagConstraints gbcsubmit = new GridBagConstraints();
    GridBagConstraints gbcpricelabel = new GridBagConstraints();
    GridBagConstraints gbcpricefield = new GridBagConstraints();

    private Connection conn;
    private Statement stmt;
    public ItemManagerGUI() {
        setLayout(new GridBagLayout());

        //gbc.insets = new Insets(10, 10, 10, 10);
        setSize(400, 500);
        setBackground(Color.LIGHT_GRAY);

        JLabel nameLabel = new JLabel("Item name: ");
        JTextField nameField = new JTextField(20);
        JLabel quntitylabel = new JLabel("Quantity:");
        JTextField quantityfield = new JTextField(20);

        JButton add = new JButton("Add");

        gbcnamelabel.gridx = 0;
        gbcnamelabel.gridy = 0;
        gbcnamelabel.insets = new Insets(5, 5, 5, 5);
        add(nameLabel,gbcnamelabel);

        gbcnamefield.gridx = 1;
        gbcnamefield.gridy = 0;
        gbcnamefield.insets = new Insets(5, 5, 5, 5);
        add(nameField,gbcnamefield);

        gbcpricelabel.gridx = 0;
        gbcpricelabel.gridy = 1;
        gbcpricelabel.insets = new Insets(5, 5, 5, 5);
        add(quntitylabel,gbcpricelabel);

        gbcpricefield.gridx = 1;
        gbcpricefield.gridy = 1;
        gbcpricefield.insets = new Insets(5, 5, 5, 5);
        add(quantityfield,gbcpricefield);

        gbcsubmit.gridx = 1;
        gbcsubmit.gridy = 2;
        gbcsubmit.insets = new Insets(5, 5, 5, 5);
        add(add,gbcsubmit);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nname = nameField.getText();
                String quantity = quantityfield.getText();

                try{
                    conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/itemlist&price", "root", "Aqqa1234%");
                    stmt=conn.createStatement();
                    String sql="UPDATE  items SET Product_level= Product_level +"+quantity+" WHERE Item_name='"+Nname+"'";
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Stock added successfully... " );
                }catch(SQLException e3){
                    e3.printStackTrace();
                }
            }
        });




    }
}