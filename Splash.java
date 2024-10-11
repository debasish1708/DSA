
import javax.swing.*;

public class Splash extends JFrame{
    Splash(){
        
        // ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        // JLabel image=new JLabel(i1);
        // add(image);
        
        setLocation(198, 50);
        setSize(900,600);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Splash();
    }
}
