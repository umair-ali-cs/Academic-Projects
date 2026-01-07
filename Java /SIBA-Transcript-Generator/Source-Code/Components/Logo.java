import java.awt.*;
import javax.swing.*;

public class Logo extends JLabel {
    ImageIcon SIBAlogo;
    Image scaledImage;

    Logo(int x, int y, int w, int h) {
        SIBAlogo = new ImageIcon("images/IBAlogo.png");
        scaledImage = SIBAlogo.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        SIBAlogo = new ImageIcon(scaledImage);
        this.setLayout(new FlowLayout());
        this.setBounds(x, y, w, h);
        this.setBackground(Color.BLACK);
        this.setIcon(SIBAlogo);
    }
}
