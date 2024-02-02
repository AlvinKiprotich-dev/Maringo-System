import javax.swing.*;
import java.awt.*;

public class games extends JPanel {
    public Image image;
    public games(){
        //setLayout(new BoxLayout(3,5,5));
        image= new ImageIcon(getClass().getResource("/Imagge/ttday.jpg")).getImage();

        JLabel label1=new JLabel("");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        add(label1);
        JLabel label2=new JLabel("");
        label2.setFont(new Font("Arial", Font.BOLD, 20));
        label2.setForeground(Color.WHITE);
        add(label2);
        JLabel label3=new JLabel("");
        label3.setFont(new Font("Arial", Font.BOLD, 20));
        label3.setForeground(Color.WHITE);
        add(label3);
        JLabel label4=new JLabel("");
        label4.setFont(new Font("Arial", Font.BOLD, 20));
        label4.setForeground(Color.WHITE);
        add(label4);
        JLabel label5=new JLabel("");
        label5.setFont(new Font("Arial", Font.BOLD, 20));
        label5.setForeground(Color.WHITE);
        add(label5);
        JLabel label6=new JLabel("");
        label6.setFont(new Font("Arial", Font.BOLD, 20));
        label6.setForeground(Color.WHITE);
        add(label6);



    }
    @Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        g.drawImage(image,0,0,getWidth(),getHeight(),this);
    }

}
