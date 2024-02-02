import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User_page extends JPanel {
    GridBagConstraints gbcleb = new GridBagConstraints();
    GridBagConstraints gbcreg = new GridBagConstraints();
    GridBagConstraints gbcitems = new GridBagConstraints();
    public User_page() {
        setLayout(new GridBagLayout());
        setBackground(Color.lightGray);

        JLabel leb = new JLabel("User page");
        leb.setFont(new Font("Arial", Font.ITALIC, 30));
        gbcleb.gridx=0;
        gbcleb.gridy=0;
        gbcleb.insets = new Insets(5, 5, 5, 5);
        add(leb,gbcleb);

        JButton pur= new JButton("Purchase item");
        pur.setFont(new Font("Arial", Font.ITALIC, 20));
        pur.setBackground(Color.lightGray);
        gbcreg.gridx=0;
        gbcreg.gridy=1;
        gbcreg.insets = new Insets(5, 5, 5, 5);
        add(pur,gbcreg);

        JButton prof= new JButton("Profile");
        prof.setFont(new Font("Arial", Font.ITALIC, 18));
        prof.setBackground(Color.lightGray);
        gbcitems.gridx=0;
        gbcitems.gridy=2;
        gbcitems.insets = new Insets(5, 5, 5, 5);
        add(prof,gbcitems);


        pur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main switch1 = new Main();
                switch1.Switchpanel(new Item_purchase());
            }
        });
        prof.addActionListener(EVT -> {
           Main swiitch= new Main();//(Main) SwingUtilities.getWindowAncestor(this);
           swiitch.Switchpanel(new rolll());
        });
    }

}


