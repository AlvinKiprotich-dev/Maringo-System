import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class management_page extends JPanel {
    GridBagConstraints gbcleb = new GridBagConstraints();
    GridBagConstraints gbcreg = new GridBagConstraints();
    GridBagConstraints gbcitems = new GridBagConstraints();
    GridBagConstraints gbccoach = new GridBagConstraints();
    GridBagConstraints gbclost = new GridBagConstraints();

    public management_page() {
        setLayout(new GridBagLayout());
        setBackground(Color.GRAY);

        JLabel leb = new JLabel("Management page");
        leb.setFont(new Font("Arial", Font.ITALIC, 30));
        gbcleb.gridx=0;
        gbcleb.gridy=0;
        gbcleb.insets = new Insets(5, 5, 5, 5);
        add(leb,gbcleb);

        JButton reg= new JButton("Members");
        reg.setFont(new Font("Arial", Font.ITALIC, 20));
        gbcreg.gridx=0;
        gbcreg.gridy=1;
        gbcreg.insets = new Insets(5, 5, 5, 5);
        add(reg,gbcreg);
        JButton additem = new JButton("Add stock");
        additem.setFont(new Font("Arial", Font.ITALIC, 18));
        gbcitems.gridx=0;
        gbcitems.gridy=3;
        gbcitems.insets = new Insets(5, 5, 5, 5);
        add(additem,gbcitems);


        JButton items= new JButton("Items in store");
        items.setFont(new Font("Arial", Font.ITALIC, 18));
        gbcitems.gridx=0;
        gbcitems.gridy=2;
        gbcitems.insets = new Insets(5, 5, 5, 5);
        add(items,gbcitems);

        JButton coach= new JButton("Manage patrons");
        coach.setFont(new Font("Arial", Font.ITALIC, 18));
        gbccoach.gridx=0;
        gbccoach.gridy=4;
        gbccoach.insets = new Insets(5, 5, 5, 5);
        add(coach,gbccoach);

        JButton lost= new JButton("Lost/damaged items");
        lost.setFont(new Font("Arial", Font.ITALIC, 18));
        gbclost.gridx=0;
        gbclost.gridy=5;
        gbclost.insets = new Insets(5, 5, 5, 5);
        add(lost,gbclost);

        lost.addActionListener(EVT ->{

            Main switch5 = (Main) SwingUtilities.getWindowAncestor(this);
            switch5.Switchpanel(new lostt());
                });

        reg.addActionListener (EVT -> {
            Main switch2 = (Main) SwingUtilities.getWindowAncestor(this);
            switch2.Switchpanel(new registeredmembers());
        });

        items.addActionListener (EVT -> {
                    Main switch3 = (Main) SwingUtilities.getWindowAncestor(this);
                    switch3.Switchpanel(new Items_in_the_store());
                });
        additem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main switch4= new Main();
                switch4.Switchpanel(new ItemManagerGUI());
            }
        });
        coach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main switch4 = new Main();
                switch4.Switchpanel(new patron());
            }
        });
            }

    }


