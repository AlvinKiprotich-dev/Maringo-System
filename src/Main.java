import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    @Override
    public void setResizable(boolean resizable) {
        super.setResizable(false);
        setFont(new Font("Arial", Font.ITALIC, 30));
    }

    public JPanel newpanel;
    JPanel currentpanel;
    JPanel currentpanell;
    public Main() {
       setTitle("Maringo Sports Club");
       setResizable(false);
        setFont(new Font("Arial", Font.ITALIC, 30));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 900);
        setLocationRelativeTo(null);
        Switchpanel(new Home());

        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }

        });
    }
    public void Switchpanel(JPanel newpanel){

        getContentPane().removeAll();
        getContentPane().add(newpanel);
        revalidate();
        repaint();
        currentpanell=newpanel;
    }
}
