import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JPanel {
    GridBagConstraints gbc = new GridBagConstraints();
    GridBagConstraints gbcsignup = new GridBagConstraints();
    GridBagConstraints gbclogin = new GridBagConstraints();
    GridBagConstraints gbcavailableitems = new GridBagConstraints();
    GridBagConstraints gbcgames = new GridBagConstraints();
    GridBagConstraints gbcgame = new GridBagConstraints();
    GridBagConstraints gbcgam = new GridBagConstraints();
   public Image image;
    public Home() {
        super();
setLayout(new GridBagLayout());


         image= new ImageIcon(getClass().getResource("/Imagge/sports.png")).getImage();

        JLabel wel = new JLabel("WELCOME TO MARINGO SPORTS ACADEMY !");
        wel.setFont(new Font("Arial", Font.BOLD, 35));
        wel.setForeground(Color.pink);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(wel, gbc);

        JMenuBar menuBar= new JMenuBar();

        JMenu menu = new JMenu("Login");
        menu.setContentAreaFilled(false);
        menu.setFocusPainted(false);
        menu.setForeground(Color.green);
        menu.setFont(new Font("Arial", Font.ITALIC, 25));
        JMenuItem menu1Item=new JMenuItem("Management");
        JMenuItem menu2Item=new JMenuItem("Patron");
        JMenuItem menu3Item=new JMenuItem("User");

        menu.add(menu1Item);
        menu.add(menu2Item);
        menu.add(menu3Item);

        menuBar.add(menu);



        JButton signup = new JButton("SIGN UP");
        signup.setForeground(Color.green);
        signup.setContentAreaFilled(false);
        signup.setFont(new Font("Arial", Font.ITALIC, 25));

        JButton logn = new JButton("Login");

        JButton purchase = new JButton("Purchase item");

        purchase.setBackground(Color.green);
        purchase.setContentAreaFilled(false);
        purchase.setForeground(Color.green);
        purchase.setFont(new Font("Arial", Font.ITALIC, 25));
        gbcavailableitems.gridx = 0;
        gbcavailableitems.gridy = 3;
        gbcavailableitems.insets = new Insets(10, 10, 10, 10);
        add(purchase, gbcavailableitems);

        gbcsignup.gridx = 0;
        gbcsignup.gridy = 1;
        gbcsignup.insets = new Insets(10, 10, 10, 10);

        add(signup, gbcsignup);
        gbclogin.gridx = 0;
        gbclogin.gridy = 2;
        gbclogin.insets = new Insets(10, 10, 10, 10);
        add(menuBar, gbclogin);


        menu1Item.addActionListener (EVT ->{
            Main switch1 =  (Main) SwingUtilities.getWindowAncestor(this);
            switch1.Switchpanel(new Management());

        });

        menu2Item.addActionListener (EVT ->{
            Main switch21 =  (Main) SwingUtilities.getWindowAncestor(this);
            switch21.Switchpanel(new patronlogin());

        });

        menu3Item.addActionListener (EVT ->{
            Main switch3 =(Main) SwingUtilities.getWindowAncestor(this);
            switch3.Switchpanel(new userlogin());

        });

        signup.addActionListener (EVT ->{
                    Main switch11 = new Main();// (Main) SwingUtilities.getWindowAncestor(this);
                    switch11.Switchpanel(new RegistrationForm());

                });
        purchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main switch12= new Main();
                switch12.Switchpanel(new Item_purchase());
            }
        });

        JLabel games = new JLabel("Games offered :");
        games.setFont(new Font("Arial", Font.BOLD, 25));
        games.setForeground(Color.green);
        gbcgames.gridx = 0;
        gbcgames.gridy = 4;
        gbcgames.insets = new Insets(10, 10, 10, 10);
        add(games,gbcgames);

        JLabel game = new JLabel("swimming, hockey, lawn tennis, table tennis, darts, badminton, volleyball,");
        game.setFont(new Font("Arial", Font.ITALIC, 20));
        game.setForeground(Color.yellow);
        gbcgame.gridx = 0;
        gbcgame.gridy = 5;
        gbcgame.insets = new Insets(10, 10, 10, 10);
        add(game,gbcgame);
        JLabel gam = new JLabel(" basketball, netball, football, baseball, rugby, pool, chess, and draft");
        gam.setFont(new Font("Arial", Font.ITALIC, 20));
        gam.setForeground(Color.yellow);
        gbcgam.gridx = 0;
        gbcgam.gridy = 6;
        gbcgam.insets = new Insets(10, 10, 10, 10);
        add(gam,gbcgam);
    }

@Override
    protected void paintComponent (Graphics g){
    super.paintComponent(g);
    g.drawImage(image,0,0,getWidth(),getHeight(),this);
}

}
