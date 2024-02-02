
//package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.sql.*;

public class Item_purchase extends JPanel {
    private JSpinner[] spinners;
    private int confirm;
    private double[] unitPrices = {250.0, 750.0, 2000.0, 350.0, 1500.0,2000.0, 1000.0, 800.0, 450.0, 22.0};
    private String[] items={"Bloomer","Games shorts","Hockey stick","Socks","Sports shoes","Track suit","T-shirt", "Wrapper"};


    private Connection conn;
    private Statement stmt;
    public Image image;
    public Item_purchase() {
        setBackground(Color.white);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets= new Insets(10,10,10,10);

        //image= new ImageIcon(getClass().getResource("/Imagge/sports.png")).getImage();

        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        spinners = new JSpinner[8];
        for (int i = 0; i < 8; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            ImageIcon icon = new ImageIcon("item" + (i + 1) + ".png");
            JLabel iconLabel = new JLabel(icon);
            add(iconLabel, gbc);

            gbc.gridx = 1;
            JLabel label = new JLabel(items[i]);
            add(label, gbc);

            gbc.gridx = 2;
            spinners[i] = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
            add(spinners[i], gbc);

            gbc.gridx = 3;
            JLabel priceLabel = new JLabel("Price:KSH" + unitPrices[i]);
            add(priceLabel, gbc);
        }


        JButton totalButton = new JButton("Calculate Total");
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 4;
        add(totalButton, gbc);

        JTextField totalField = new JTextField(10);
        totalField.setEditable(false);
        gbc.gridx = 4;
        gbc.gridwidth = 1;
        add(totalField, gbc);

        totalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = 0.0;
                for (int i = 0; i < 8; i++) {
                    total += (int) spinners[i].getValue() * unitPrices[i];
                }
                //calculate discount if any
                if (total>10000) {
                    double discount = total * 0.05;
                    total = total - discount;
                    JOptionPane.showMessageDialog(null, "the discount received is " + discount);

                    totalField.setText(NumberFormat.getCurrencyInstance().format(total));
                }
                else {
                    totalField.setText(NumberFormat.getCurrencyInstance().format(total));}

            }
        });

        JButton buyButton = new JButton("Buy");
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 5;
        add(buyButton, gbc);

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirm = JOptionPane.showConfirmDialog(Item_purchase.this, "Are you sure you want to buy these items?");
                String pass= JOptionPane.showInputDialog(Item_purchase.this,"please enter user account password");
                int pin=Integer.parseInt(pass);
                int rightpin=1234;
                if (pin==rightpin){
                    JOptionPane.showMessageDialog(Item_purchase.this, "Pin confirmed. Transaction successful!");
                    reduceStock();
                }
                else {JOptionPane.showMessageDialog(Item_purchase.this, "Wrong pin please try again");}}
        });

    }

    private void reduceStock() {
        //creating a function that decreases the value of stock in the database as purchases are made,and wipes the Jspinners after the transaction is complete


        if (confirm == JOptionPane.YES_OPTION) {
            int[] stock = new int[8];
            for (int i = 0; i < 8; i++) {
                stock[i] = (int) spinners[i].getValue();
            }
            //take the stock for affected items from the database, subtract the stock bought, and update the database
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itemlist&price", "root", "Aqqa1234%");
                stmt = conn.createStatement();
                String selectQuery = "SELECT Product_level FROM items WHERE Item_name = ?";
                PreparedStatement selectStatement = conn.prepareStatement(selectQuery);
                for (int i = 0; i < 8; i++) {
                    selectStatement.setString(1, items[i]);
                    ResultSet resultSet = selectStatement.executeQuery();
                    if (resultSet.next()) {
                        int currentStock = resultSet.getInt("Product_level");
                        int newStock = currentStock - stock[i];
                        String updateQuery = "UPDATE items SET Product_level = ? WHERE Item_name = ?";
                        PreparedStatement updateStatement = conn.prepareStatement(updateQuery);
                        updateStatement.setInt(1, newStock);
                        updateStatement.setString(2, items[i]);
                        int rowsAffected = updateStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Stock updated successfully. New stock level: " + newStock);
                        } else {
                            System.out.println("Failed to update stock.");
                        }
                        updateStatement.close();
                    } else {
                        System.out.println("Item not found.");
                    }
                    resultSet.close();
                }
                selectStatement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            //clear the spinners
            for (int i = 0; i < 8; i++) {
                spinners[i].setValue(0);
            }
        } else {
            JOptionPane.showMessageDialog(Item_purchase.this, "Transaction cancelled.");
        }
    }
        @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g);
            g.drawImage(image,0,0,getWidth(),getHeight(),this);
        }

    }





/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Item_purchase extends JPanel {


    //GridBagConstraints gbcpanel = new GridBagConstraints();
    GridBagConstraints gbcnamelabel = new GridBagConstraints();

    GridBagConstraints gbcnamefield = new GridBagConstraints();

    GridBagConstraints gbcdoblabel = new GridBagConstraints();
    GridBagConstraints gbcdobfield = new GridBagConstraints();
    GridBagConstraints gbccontact = new GridBagConstraints();
    GridBagConstraints gbccontactfield = new GridBagConstraints();
    GridBagConstraints gbckin = new GridBagConstraints();
    GridBagConstraints gbckinfield = new GridBagConstraints();

    GridBagConstraints gbcschool = new GridBagConstraints();
    GridBagConstraints gbcschoolfield = new GridBagConstraints();
    GridBagConstraints gbcusername = new GridBagConstraints();
    GridBagConstraints gbcusernamefield = new GridBagConstraints();
    GridBagConstraints gbcpassword = new GridBagConstraints();
    GridBagConstraints gbcshoelabel = new GridBagConstraints();
    GridBagConstraints gbcshoefield = new GridBagConstraints();
    GridBagConstraints gbcpasswordfield = new GridBagConstraints();
    GridBagConstraints gbcsubmit= new GridBagConstraints();
    GridBagConstraints gbcclearbutton= new GridBagConstraints();

    public Image image;
    public  Item_purchase() {
       // super();
        setLayout(new GridBagLayout());

        //gbc.insets = new Insets(10, 10, 10, 10);
        setSize(400, 500);
        setBackground(Color.white);
        image= new ImageIcon(getClass().getResource("/Imagge/ttday.jpg")).getImage();


        JLabel bloomerlabel = new JLabel("Bloomer @250/=");
        bloomerlabel.setForeground(Color.white);
        JTextField bloomerfield = new JTextField(20);

        JLabel shortslabel = new JLabel(" Games shorts @750/=");
        shortslabel.setForeground(Color.white);
        JTextField shortsfield = new JTextField(20);

        JLabel hockeylabel=new JLabel("Hockey stick @2000/= ");
        hockeylabel.setForeground(Color.white);
        JTextField hockeyfield=new JTextField(20);

        JLabel suitlabel = new JLabel("Track suit @1000/=");
        suitlabel.setForeground(Color.white);
        JTextField suitfield = new JTextField(20);

        JLabel shirtlabel = new JLabel("T-shirt @800/=");
        shirtlabel.setForeground(Color.white);
        JTextField shirtfield = new JTextField(20);

        JLabel wrapper = new JLabel("Wrapper @450");
        wrapper.setForeground(Color.white);
        JTextField wrapperfield = new JTextField(20);

        JLabel shoelabel = new JLabel("Shoes @2000");
        shoelabel.setForeground(Color.white);
        JTextField shoefield = new JTextField(20);

        JLabel sockslabel = new JLabel("Socks @350/=");
        sockslabel.setForeground(Color.white);
        JTextField socksfield = new JTextField(20);

        JButton totalbutton = new JButton("TOTAL");


        gbcnamelabel.gridx = 0;
        gbcnamelabel.gridy = 0;
        gbcnamelabel.insets = new Insets(5, 5, 5, 5);
        add(bloomerlabel,gbcnamelabel);

        gbcnamefield.gridx = 1;
        gbcnamefield.gridy = 0;
        gbcnamefield.insets = new Insets(5, 5, 5, 5);
        add(bloomerfield,gbcnamefield);


        gbcdoblabel.gridx = 0;
        gbcdoblabel.gridy = 3;
        gbcdoblabel.insets = new Insets(5, 5, 5, 5);
        add(suitlabel,gbcdoblabel);
        gbcdobfield.gridx = 1;
        gbcdobfield.gridy = 3;
        gbcdobfield.insets = new Insets(5, 5, 5, 5);
        add(suitfield,gbcdobfield);
        gbccontact.gridx = 0;
        gbccontact.gridy = 4;
        gbccontact.insets = new Insets(5, 5, 5, 5);
        add(shirtlabel,gbccontact);
        gbccontactfield.gridx = 1;
        gbccontactfield.gridy = 4;
        gbccontactfield.insets = new Insets(5, 5, 5, 5);
        add(shirtfield,gbccontactfield);
        gbckin.gridx = 0;
        gbckin.gridy = 5;
        gbckin.insets = new Insets(5, 5, 5, 5);
        add(wrapper,gbckin);
        gbckinfield.gridx = 1;
        gbckinfield.gridy = 5;
        gbckinfield.insets = new Insets(5, 5, 5, 5);
        add(wrapperfield,gbckinfield);
        gbcshoelabel.gridx = 0;
        gbcshoelabel.gridy = 6;
        gbcshoelabel.insets = new Insets(5, 5, 5, 5);
        add(shoelabel,gbcshoelabel);
        gbcshoefield.gridx = 1;
        gbcshoefield.gridy = 6;
        gbcshoefield.insets = new Insets(5, 5, 5, 5);
        add(shoefield,gbcshoefield);

        gbcschool.gridx = 0;
        gbcschool.gridy = 7;
        gbcschool.insets = new Insets(5, 5, 5, 5);
        add(sockslabel,gbcschool);
        gbcschoolfield.gridx = 1;
        gbcschoolfield.gridy = 7;
        gbcschoolfield.insets = new Insets(5, 5, 5, 5);
        add(socksfield,gbcschoolfield);


        gbcusername.gridx = 0;
        gbcusername.gridy = 19;
        gbcusername.insets = new Insets(5, 0, 5, 0);
        add(shortslabel,gbcusername);
        gbcusernamefield.gridx = 1;
        gbcusernamefield.gridy = 19;
        gbcusernamefield.insets = new Insets(5, 0, 5, 0);
        add(shortsfield,gbcusernamefield);
        gbcpassword.gridx = 0;
        gbcpassword.gridy = 20;
        gbcpassword.insets = new Insets(5, 0, 5, 0);
        add(hockeylabel,gbcpassword);

        gbcpasswordfield.gridx = 1;
        gbcpasswordfield.gridy = 20;
        gbcpasswordfield.insets = new Insets(5, 0, 5, 0);
        add(hockeyfield,gbcpasswordfield);

        gbcsubmit.gridx = 1;
        gbcsubmit.gridy = 21;
        gbcsubmit.insets = new Insets(5, 5, 5, 5);
        add(totalbutton,gbcsubmit);

        totalbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String bloomer = bloomerfield.getText();
                Integer bloomervalue = Integer.parseInt(bloomer);
                String suit = suitfield.getText();
                Integer suitvalue = Integer.parseInt(suit);
                String shirt = shirtfield.getText();
                Integer shirtvalue = Integer.parseInt(shirt);
                String wrapper = wrapperfield.getText();
                Integer wrappervalue = Integer.parseInt(wrapper);
                String socks = socksfield.getText();
                Integer socksvalue = Integer.parseInt(socks);
                String shorts=shortsfield.getText();
                Integer shortsalue = Integer.parseInt(shorts);
                String hockey=hockeyfield.getText();
                Integer hockeyvalue = Integer.parseInt(hockey);
                String shoes=shoefield.getText();
                Integer shoevalue = Integer.parseInt(shoes);
                Integer total= suitvalue * 1000 + shirtvalue * 800 + wrappervalue*450
                        +socksvalue*350+shoevalue*2000+shortsalue*750+hockeyvalue*2000+
                        bloomervalue*250;

               // Integer disco=Integer.getInteger(Integer.valueOf(total));
                Integer disc=total/5;
                Integer discounted=(total-disc);
                if (total>10000){

                     //disc=5/total;
                      //discounted=
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Total: Ksh." + discounted + "\n Discounted amount :" + disc);

                    // discounted=total-disc;

                }else {

                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Total: Ksh." + total );

                }


            }});
    }

    @Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        g.drawImage(image,0,0,getWidth(),getHeight(),this);
    }
    }*/

