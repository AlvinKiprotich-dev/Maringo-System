import javax.swing.*;
import java.awt.*;

public class patronpage extends JPanel {
    GridBagConstraints gbcleb = new GridBagConstraints();
    GridBagConstraints gbcreg = new GridBagConstraints();
    GridBagConstraints gbcitems = new GridBagConstraints();
    GridBagConstraints gbcllost = new GridBagConstraints();
    GridBagConstraints gbcadditems = new GridBagConstraints();
    public patronpage() {
        setLayout(new GridBagLayout());
        setBackground(Color.GRAY);

        JLabel leb = new JLabel("Patron page");
        leb.setFont(new Font("Arial", Font.ITALIC, 30));
        gbcleb.gridx=0;
        gbcleb.gridy=0;
        gbcleb.insets = new Insets(5, 5, 5, 5);
        add(leb,gbcleb);

        JButton members= new JButton("Members");
        members.setFont(new Font("Arial", Font.ITALIC, 20));
        gbcreg.gridx=0;
        gbcreg.gridy=1;
        gbcreg.insets = new Insets(5, 5, 5, 5);
        add(members,gbcreg);

        JButton caps = new JButton("Manage captains");
        caps.setFont(new Font("Arial", Font.ITALIC, 18));
        gbcadditems.gridx=0;
        gbcadditems.gridy=3;
        gbcadditems.insets = new Insets(5, 5, 5, 5);
        add(caps,gbcadditems);


        JButton items= new JButton("Items in store");
        items.setFont(new Font("Arial", Font.ITALIC, 18));
        gbcitems.gridx=0;
        gbcitems.gridy=2;
        gbcitems.insets = new Insets(5, 5, 5, 5);
        add(items,gbcitems);

        JButton lost= new JButton("Report lost/damaged equipments");
        lost.setFont(new Font("Arial", Font.ITALIC, 18));
        gbcllost.gridx=0;
        gbcllost.gridy=4;
        gbcllost.insets = new Insets(5, 5, 5, 5);
        add(lost,gbcllost);

        lost.addActionListener(EVT ->{
            Main switch1 = new Main();//(Main) SwingUtilities.getWindowAncestor(this);
            switch1.Switchpanel(new lostitems());
        });

        members.addActionListener (EVT -> {
                    Main switch2 = new Main();//(Main) SwingUtilities.getWindowAncestor(this);
                    switch2.Switchpanel(new registeredmembers());
                });

        items.addActionListener (EVT -> {
                    Main switch2 = new Main();//(Main) SwingUtilities.getWindowAncestor(this);
                    switch2.Switchpanel(new Items_in_the_store());
                });

            caps.addActionListener( EVT ->{
            Main switch1=new Main();
            switch1.Switchpanel(new captain());

        });
    }

}


